package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.BallShooterCommand;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeBall_InCommand;
import frc.robot.commands.IntakeBall_OutCommand;
import frc.robot.commands.ShooterLiftDownCommand;
import frc.robot.commands.ShooterLiftUpCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.EjectBallCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;


public class RobotContainer {


  // Subsystems 
    private final Drivetrain drivetrain;
    private final Limelight limelight;
    private final Intake intake;
    private final Shooter shooter;

  // Commands
    private final DriveCommand driveCommand;
    private final VisionCommand visionCommand;
    private final AutoCommand autoCommand;
    private final IntakeArmCommand intakeArmCommand;
    private final ShooterLiftUpCommand shooterLiftUpCommand;
    private final ShooterLiftDownCommand shooterLiftDownCommand;
    private final BallShooterCommand ballShooterCommand;
    private final IntakeBall_InCommand intakeBall_InCommand;
    private final IntakeBall_OutCommand intakeBall_OutCommand;
    private final EjectBallCommand ejectBallCommand;
    public static Joystick controller;

    public static SendableChooser<String> autoChooser;
    private final PneumaticsControlModule pcm;

    public static NetworkTable table;

  public RobotContainer() {

    // Subsystems
      drivetrain = new Drivetrain();

      limelight = new Limelight();
      intake = new Intake();
      shooter = new Shooter();

    // Commands
      driveCommand = new DriveCommand(drivetrain);
      visionCommand = new VisionCommand(limelight);
      autoCommand = new AutoCommand(drivetrain, shooter);
      intakeArmCommand = new IntakeArmCommand(intake);
      shooterLiftUpCommand = new ShooterLiftUpCommand(shooter);
      shooterLiftDownCommand = new ShooterLiftDownCommand(shooter);
      ballShooterCommand = new BallShooterCommand(shooter);
      intakeBall_InCommand = new IntakeBall_InCommand(intake);
      intakeBall_OutCommand = new IntakeBall_OutCommand(intake);
      ejectBallCommand = new EjectBallCommand(intake);
    
    controller = new Joystick(Constants.USB.OPERATOR_0);

    drivetrain.setDefaultCommand(driveCommand);

    autoChooser = new SendableChooser<String>();
    pcm = new PneumaticsControlModule();

    table = NetworkTableInstance.getDefault().getTable("limelight");


    configureButtonBindings();
    publishAutonomousData();
    clearPCMStickyFaults();
  }

  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(controller, 1); // X
    limelightTrackingButton.whileHeld(visionCommand);

    JoystickButton intakeButton = new JoystickButton(controller, 3); // B
    intakeButton.toggleWhenPressed(intakeArmCommand);

    POVButton shooterLiftUpButton = new POVButton(controller, 0); // Up on D-pad
    shooterLiftUpButton.whileHeld(shooterLiftUpCommand);

    POVButton shooterLiftDownButton = new POVButton(controller, 180); // Down on D-pad
    shooterLiftDownButton.whileHeld(shooterLiftDownCommand);

    JoystickButton ballShooterButton = new JoystickButton(controller, 8); // RT
    ballShooterButton.whileHeld(ballShooterCommand);

    JoystickButton intakeBallInButton = new JoystickButton(controller, 4); // Y
    intakeBallInButton.whileHeld(intakeBall_InCommand);

    JoystickButton intakeBallOutButton = new JoystickButton(controller, 2);
    intakeBallOutButton.whileHeld(intakeBall_OutCommand);

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

  public void clearPCMStickyFaults () {
    if (RobotController.getUserButton() == true) {
      pcm.clearAllStickyFaults();
    }
  }
}