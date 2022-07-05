package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Auto;
import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.Indexer.Agitator.AgitatorCommand;
import frc.robot.commands.Indexer.LowerIndexer.IndexerDown;
import frc.robot.commands.Indexer.LowerIndexer.IndexerUp;
import frc.robot.commands.Climber.*;
import frc.robot.commands.Intake.*;
import frc.robot.commands.Limelight.*;
import frc.robot.commands.Shooter.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.IntakeAgitator;


public class RobotContainer {

  // Subsystems 
    private final Drivetrain m_drivetrain;
    private final Limelight m_limelight;
    private final Intake m_intake;
    private final Shooter m_shooter;
    private final Indexer m_indexer;
    private final Agitator m_agitator;
    private final Climber m_climber;
    private final IntakeAgitator m_intakeAgitator;


  // Commands
    private final TeleopDrive m_driveCommand;
    private final ReverseDrive m_reverseDrive;
    private final Auto m_autoCommand;
    private final Vision m_visionCommand;
    private final ZoomIn m_zoomInCommand;
    private final IndexerUp m_indexerUpCommand;
    private final IndexerDown m_indexerDownCommand;
    private final AgitatorCommand m_agitatorCommand;
    private final ShootUpper m_shootUpperCommand;
    private final ShootLower m_shootLowerCommand;
    private final IntakeBall m_intakeBallCommand;
    private final EjectBall m_ejectBallCommand;
    private final ClimberCommand m_climberCommand;
    private final RunIntakeAgitator m_IntakeAgitatorCommand;
    public static Joystick m_controller;

    private final UserButton m_userButton;

 // Other
    public static SendableChooser<String> m_autoChooser;
    public static NetworkTable m_table;


  public RobotContainer() {

    // Subsystems
      m_drivetrain = new Drivetrain();

      m_limelight = new Limelight();
      m_intake = new Intake();
      m_shooter = new Shooter();
      m_indexer = new Indexer();
      m_agitator = new Agitator();
      m_climber = new Climber();
      m_intakeAgitator = new IntakeAgitator();
      


    // Commands
      m_driveCommand = new TeleopDrive(m_drivetrain);
      m_reverseDrive = new ReverseDrive(m_drivetrain);
      m_visionCommand = new Vision(m_limelight, m_drivetrain);
      m_zoomInCommand = new ZoomIn(m_limelight);
      m_autoCommand = new Auto(m_drivetrain, m_limelight, m_shooter, m_indexer, m_agitator);
      m_indexerUpCommand = new IndexerUp(m_indexer);
      m_indexerDownCommand = new IndexerDown(m_indexer);
      m_agitatorCommand = new AgitatorCommand(m_agitator, m_limelight);
      m_shootUpperCommand = new ShootUpper(m_shooter);
      m_shootLowerCommand = new ShootLower(m_shooter);
      m_intakeBallCommand = new IntakeBall(m_intake);
      m_ejectBallCommand = new EjectBall(m_intake);
      m_IntakeAgitatorCommand = new RunIntakeAgitator(m_intakeAgitator);

      m_controller = new Joystick(0);

      m_climberCommand = new ClimberCommand(m_climber);

      m_userButton = new UserButton();
      m_userButton.toggleWhenPressed(m_visionCommand);
    



    m_drivetrain.setDefaultCommand(m_driveCommand);
    m_climber.setDefaultCommand(m_climberCommand);

    m_autoChooser = new SendableChooser<String>();

    m_table = NetworkTableInstance.getDefault().getTable("limelight");

    configureButtonBindings();
    dashboardInit();
  }

  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(m_controller, 1); // X
    limelightTrackingButton.whileHeld(m_visionCommand);

    JoystickButton zoomInButton = new JoystickButton(m_controller, 9);
    zoomInButton.toggleWhenPressed(m_zoomInCommand);

    JoystickButton ballShooterButton = new JoystickButton(m_controller, 8); // RT
    ballShooterButton.whileHeld(m_shootUpperCommand);

    POVButton indexerUpButton = new POVButton(m_controller, 0);
    indexerUpButton.whileHeld(m_indexerUpCommand);

    POVButton indexerDownButton = new POVButton(m_controller, 180);
    indexerDownButton.whileHeld(m_indexerDownCommand);

    JoystickButton agitatorButton = new JoystickButton(m_controller, 5);
    agitatorButton.whileHeld(m_agitatorCommand);

    JoystickButton intakeBallButton = new JoystickButton(m_controller, 4); // Y
    intakeBallButton.toggleWhenPressed(m_intakeBallCommand);
    intakeBallButton.toggleWhenPressed(m_indexerUpCommand);
    intakeBallButton.toggleWhenPressed(m_IntakeAgitatorCommand);

    JoystickButton ejectBallButton = new JoystickButton(m_controller, 2); // A
    ejectBallButton.whileHeld(m_ejectBallCommand);

    JoystickButton shootLowerButton = new JoystickButton(m_controller, 7);
    shootLowerButton.whileHeld(m_shootLowerCommand);

    JoystickButton reverseDriveButton = new JoystickButton(m_controller, 12);
    reverseDriveButton.toggleWhenPressed(m_reverseDrive);
  }

  public Command getAutonomousCommand() {
    return m_autoCommand;
  }

  private void dashboardInit () {

    CameraServer.startAutomaticCapture(0);
    // Teleop
      m_autoChooser.setDefaultOption("None", "None");
      m_autoChooser.addOption("Move Back / Shoot High", "MoveBackShootHigh");
      m_autoChooser.addOption("Move Back / Shoot Low", "MoveBackShootLow");
      m_autoChooser.addOption("Move Back", "MoveBack");
      SmartDashboard.putData("autoChooser", m_autoChooser);
      SmartDashboard.putNumber("Shooter Speed", 0.65);
      SmartDashboard.putNumber("Drivetrain X", 0.85);
      SmartDashboard.putNumber("Drivetrain Y", 0.9);
      SmartDashboard.putNumber("Intake", 0.75);
      SmartDashboard.putNumber("Climber", -0.3);
      SmartDashboard.putNumber("Indexer", 0.75);
      SmartDashboard.putNumber("Agitator", 0.5);
      SmartDashboard.putNumber("Target Velocity", 0);

    // Autonomous
      SmartDashboard.putNumber("HighShotBackupTime", 2);
      SmartDashboard.putNumber("Auto Drivetrain Y", 0.6);
      SmartDashboard.putNumber("Auto Shooter Speed", 0.65);
      SmartDashboard.putNumber("Auto Agitator Speed", 0.5);
      SmartDashboard.putNumber("Auto Indexer Speed", 0.75);
  }
}