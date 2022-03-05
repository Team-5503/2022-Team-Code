package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.BallShooterCommand;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.LowerShooterLiftUpCommand;
import frc.robot.commands.UpperShooterLiftCommand;
import frc.robot.commands.LowerShooterLiftDownCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.EjectBallCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LowerShooterLift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.UpperShooterLift;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArms;


public class RobotContainer {

  // Subsystems 
    private final Drivetrain drivetrain;
    private final Limelight limelight;
    private final Intake intake;
    private final IntakeArms intakeArms;
    private final LowerShooterLift lowerShooterLift;
    private final UpperShooterLift upperShooterLift;
    private final Shooter shooter;

  // Commands
    private final DriveCommand driveCommand;
    private final AutoCommand autoCommand;
    private final VisionCommand visionCommand;
    private final IntakeArmCommand intakeArmCommand;
    private final LowerShooterLiftUpCommand lowerShooterLiftUpCommand;
    private final LowerShooterLiftDownCommand lowerShooterLiftDownCommand;
    private final UpperShooterLiftCommand upperShooterLiftCommand;
    private final BallShooterCommand ballShooterCommand;
    private final IntakeBallCommand intakeBallCommand;
    private final EjectBallCommand ejectBallCommand;
    public static Joystick controller;

 // Other
    public static SendableChooser<String> autoChooser;
    public static NetworkTable table;


  public RobotContainer() {

    // Subsystems
      drivetrain = new Drivetrain();

      limelight = new Limelight();
      intake = new Intake();
      intakeArms = new IntakeArms();
      lowerShooterLift = new LowerShooterLift();
      upperShooterLift = new UpperShooterLift();
      shooter = new Shooter();

    // Commands
      driveCommand = new DriveCommand(drivetrain);
      visionCommand = new VisionCommand(limelight, drivetrain);
      autoCommand = new AutoCommand(drivetrain, shooter, lowerShooterLift, upperShooterLift);
      intakeArmCommand = new IntakeArmCommand(intakeArms);
      lowerShooterLiftDownCommand = new LowerShooterLiftDownCommand(lowerShooterLift);
      lowerShooterLiftUpCommand = new LowerShooterLiftUpCommand(lowerShooterLift);
      upperShooterLiftCommand = new UpperShooterLiftCommand(upperShooterLift);
      ballShooterCommand = new BallShooterCommand(shooter);
      intakeBallCommand = new IntakeBallCommand(intake);
      ejectBallCommand = new EjectBallCommand(intake);
    
    controller = new Joystick(0);

    drivetrain.setDefaultCommand(driveCommand);

    autoChooser = new SendableChooser<String>();

    table = NetworkTableInstance.getDefault().getTable("limelight");

    configureButtonBindings();
    publishAutonomousData();
  }

  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(controller, 1); // X
    limelightTrackingButton.whileHeld(visionCommand);

    JoystickButton ballShooterButton = new JoystickButton(controller, 8); // RT
    ballShooterButton.whileHeld(ballShooterCommand);

    JoystickButton intakeArmButton = new JoystickButton(controller, 3); // B
    intakeArmButton.toggleWhenPressed(intakeArmCommand);

    POVButton lowerShooterLiftUpButton = new POVButton(controller, 0);
    lowerShooterLiftUpButton.whileHeld(lowerShooterLiftUpCommand);

    POVButton lowerShooterLiftDownButton = new POVButton(controller, 180);
    lowerShooterLiftDownButton.whileHeld(lowerShooterLiftDownCommand);

    JoystickButton upperShooterLiftButton = new JoystickButton(controller, 5);
    upperShooterLiftButton.whileHeld(upperShooterLiftCommand);

    JoystickButton intakeBallButton = new JoystickButton(controller, 4); // Y
    intakeBallButton.whileHeld(intakeBallCommand);

    JoystickButton ejectBallButton = new JoystickButton(controller, 2); // A
    ejectBallButton.whileHeld(ejectBallCommand);
  }

  public Command getAutonomousCommand() {
    return autoCommand;
  }

  private void publishAutonomousData () {
    autoChooser.setDefaultOption("None", "None");
    autoChooser.addOption("Move Back / Shoot", "MoveBackShoot");
    autoChooser.addOption("Move Back", "MoveBack");
    SmartDashboard.putData("autoChooser", autoChooser);
  }
}