import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class WPILIB extends TimedRobot {
    private MecanumDrive mecanumDrive;
    private XboxController driverController;

    @Override
    public void robotInit() {
        PWMSparkMax frontLeftMotor = new PWMSparkMax(0);
        PWMSparkMax rearLeftMotor = new PWMSparkMax(1);
        PWMSparkMax frontRightMotor = new PWMSparkMax(2);
        PWMSparkMax rearRightMotor = new PWMSparkMax(3);

        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);

        mecanumDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        driverController = new XboxController(0);
    }

    @Override
    public void teleopPeriodic() {
        double xSpeed = -driverController.getLeftY();
        double ySpeed = driverController.getLeftX();
        double rot = driverController.getRightX();

        mecanumDrive.driveCartesian(ySpeed, xSpeed, rot);
    }
}
