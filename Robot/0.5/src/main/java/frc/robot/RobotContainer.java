package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ServoCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Dashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterServo;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain;

  private final Limelight limelight;
  private final Intake intake;
  private final Shooter shooter;
  private final ShooterServo shooterServo;
  private final Dashboard dashboard;

  private final DriveCommand driveCommand;
  private final VisionCommand visionCommand;
  private final AutoCommand autoCommand;
  private final IntakeCommand intakeCommand;
  private final ShooterCommand shooterCommand;
  private final ServoCommand servoCommand;
  public static Joystick controller;
  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    dashboard = new Dashboard();
    limelight = new Limelight();
    intake = new Intake();
    shooter = new Shooter();
    shooterServo = new ShooterServo();

    driveCommand = new DriveCommand(drivetrain, dashboard);
    visionCommand = new VisionCommand(limelight);
    autoCommand = new AutoCommand(drivetrain, dashboard);
    intakeCommand = new IntakeCommand(intake);
    shooterCommand = new ShooterCommand(shooter);
    servoCommand = new ServoCommand(shooterServo);
    
    controller = new Joystick(Constants.USB.OPERATOR_0);

    drivetrain.setDefaultCommand(driveCommand);

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(controller, 1);
    limelightTrackingButton.toggleWhenPressed(visionCommand);

    JoystickButton intakeButton = new JoystickButton(controller, 2);
    intakeButton.toggleWhenPressed(intakeCommand);

    JoystickButton shooterButton = new JoystickButton(controller, 8);
    shooterButton.whileHeld(shooterCommand);

    JoystickButton shooterServoButton = new JoystickButton(controller, 7);
    shooterServoButton.whileHeld(servoCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoCommand;
  }
}
