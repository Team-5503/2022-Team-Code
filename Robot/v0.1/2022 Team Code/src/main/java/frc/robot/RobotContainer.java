package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.RunServo;
import frc.robot.commands.RunShooter;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.Vision;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterServo;


public class RobotContainer {

  public static Joystick operatorJoystick;

  // Subsystem Definitions
    private final Drivetrain drivetrain;
    private final Shooter shooter;
    private final Intake intake;
    private final ShooterServo shooterServo;
    private final Limelight limelight;

  // Command Definitions
    private final AutoDrive autoDrive;
    private final TeleopDrive teleopDrive;
    private final RunShooter runShooter;
    private final IntakeIn intakeIn;
    private final IntakeOut intakeOut;
    private final RunServo runServo;
    private final Vision vision;


  public RobotContainer() {

    drivetrain = new Drivetrain();
    shooter = new Shooter();
    intake = new Intake();
    shooterServo = new ShooterServo();
    limelight = new Limelight();

    teleopDrive = new TeleopDrive(drivetrain);
    autoDrive = new AutoDrive(drivetrain);
    runShooter = new RunShooter(shooter);
    intakeIn = new IntakeIn(intake);
    intakeOut = new IntakeOut(intake);
    runServo = new RunServo(shooterServo);
    vision = new Vision(limelight);

    drivetrain.setDefaultCommand(teleopDrive);

    operatorJoystick = new Joystick(Constants.USB.OPERATOR_1_USB);
    
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton runShooterButton = new JoystickButton(operatorJoystick, 8);
    JoystickButton intakeInButton = new JoystickButton(operatorJoystick, 4);
    JoystickButton intakeOutButton = new JoystickButton(operatorJoystick, 2);
    JoystickButton runServoButton = new JoystickButton(operatorJoystick, 7);
    JoystickButton visionButton = new JoystickButton(operatorJoystick, 1);
    visionButton.whileHeld(vision);

    runShooterButton.whileHeld(runShooter);
    intakeInButton.whileHeld(intakeIn);
    intakeOutButton.whileHeld(intakeOut);
    runServoButton.whileHeld(runServo);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoDrive;
  }
}
