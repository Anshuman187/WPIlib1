import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Robot extends TimedRobot {

    private DifferentialDrive drive;
    private Timer timer;

    @Override
    public void robotInit() {
        // Initialize your motor controllers and the differential drive
        // Replace these with your actual motor controller types and ports
        PWMVictorSPX leftMotor = new PWMVictorSPX(0);
        PWMVictorSPX rightMotor = new PWMVictorSPX(1);
        drive = new DifferentialDrive(leftMotor, rightMotor);

        timer = new Timer();
    }

    @Override
    public void autonomousInit() {
        timer.reset();
        timer.start();
    }

    @Override
    public void autonomousPeriodic() {
        if (timer.get() < 15.0) {
            // Move forward for the first 15 seconds
            drive.arcadeDrive(0.5, 0.0); // Adjust the speed as necessary
        } else if (timer.get() < 30.0) {
            // Stop for the next 15 seconds
            drive.arcadeDrive(0.0, 0.0);
        } else {
            // Reset the timer to repeat the cycle
            timer.reset();
        }
    }

    public static void main(String[] args) {
        RobotBase.startRobot(Robot::new);
    }
}
