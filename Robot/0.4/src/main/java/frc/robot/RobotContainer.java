package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Vision;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.TeleopIntake;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Drivetrain drivetrain;
  private final TeleopDrive teleopDrive;
  private final Limelight limelight;
  private final Intake intake;

  private final Vision vision;
  private final AutoDrive autoDrive;
  private final TeleopIntake teleopIntake;
  public static Joystick controller;
  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    teleopDrive = new TeleopDrive(drivetrain);
    drivetrain.setDefaultCommand(teleopDrive);
    limelight = new Limelight();
    intake = new Intake();

    vision = new Vision(limelight);
    autoDrive = new AutoDrive(drivetrain);
    teleopIntake = new TeleopIntake(intake);
    
    controller = new Joystick(Constants.USB.OPERATOR_0);
    // Configure the button bindings
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
    limelightTrackingButton.toggleWhenPressed(vision);
    JoystickButton intakeCompressor = new JoystickButton(controller, 2);
    intakeCompressor.toggleWhenPressed(teleopIntake);
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
