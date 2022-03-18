package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Drivetrain.TeleopDrive;
import frc.robot.commands.Drivetrain.ReverseDrive;
import frc.robot.commands.Intake.EjectBall;
import frc.robot.commands.Intake.IntakeArmsUpDown;
import frc.robot.commands.Intake.IntakeBall;
import frc.robot.commands.Limelight.Vision;
import frc.robot.commands.Shooter.ShootUpper;
import frc.robot.commands.Shooter.ShootLower;
import frc.robot.commands.Auto;
import frc.robot.commands.ShooterLift.LowerShooterLiftUpCommand;
import frc.robot.commands.ShooterLift.UpperShooterLiftCommand;
import frc.robot.commands.ShooterLift.LowerShooterLiftDownCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LowerShooterLift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.UpperShooterLift;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeArms;


public class RobotContainer {

  // Subsystems 
    private final Drivetrain m_drivetrain;
    private final Limelight m_limelight;
    private final Intake m_intake;
    private final IntakeArms m_intakeArms;
    private final LowerShooterLift m_lowerShooterLift;
    private final UpperShooterLift m_upperShooterLift;
    private final Shooter m_shooter;

  // Commands
    private final TeleopDrive m_driveCommand;
    private final Auto m_autoCommand;
    private final Vision m_visionCommand;
    private final IntakeArmsUpDown m_intakeArmCommand;
    private final LowerShooterLiftUpCommand m_lowerShooterLiftUpCommand;
    private final LowerShooterLiftDownCommand m_lowerShooterLiftDownCommand;
    private final UpperShooterLiftCommand m_upperShooterLiftCommand;
    private final ShootUpper m_shootUpperCommand;
    private final ShootLower m_shootLowerCommand;
    private final IntakeBall m_intakeBallCommand;
    private final EjectBall m_ejectBallCommand;
    private final ReverseDrive m_reverseDrive;
    public static Joystick m_controller;

 // Other
    public static SendableChooser<String> m_autoChooser;
    public static NetworkTable m_table;


  public RobotContainer() {

    // Subsystems
      m_drivetrain = new Drivetrain();

      m_limelight = new Limelight();
      m_intake = new Intake();
      m_intakeArms = new IntakeArms();
      m_lowerShooterLift = new LowerShooterLift();
      m_upperShooterLift = new UpperShooterLift();
      m_shooter = new Shooter();

    // Commands
      m_driveCommand = new TeleopDrive(m_drivetrain);
      m_visionCommand = new Vision(m_limelight, m_drivetrain);
      m_autoCommand = new Auto(m_drivetrain, m_limelight, m_shooter, m_lowerShooterLift, m_upperShooterLift);
      m_intakeArmCommand = new IntakeArmsUpDown(m_intakeArms);
      m_lowerShooterLiftDownCommand = new LowerShooterLiftDownCommand(m_lowerShooterLift);
      m_lowerShooterLiftUpCommand = new LowerShooterLiftUpCommand(m_lowerShooterLift);
      m_upperShooterLiftCommand = new UpperShooterLiftCommand(m_upperShooterLift);
      m_shootUpperCommand = new ShootUpper(m_shooter, m_limelight);
      m_shootLowerCommand = new ShootLower(m_shooter);
      m_intakeBallCommand = new IntakeBall(m_intake);
      m_ejectBallCommand = new EjectBall(m_intake);
      m_reverseDrive = new ReverseDrive(m_drivetrain);
    
    m_controller = new Joystick(0);


    m_drivetrain.setDefaultCommand(m_driveCommand);

    m_autoChooser = new SendableChooser<String>();

    m_table = NetworkTableInstance.getDefault().getTable("limelight");

    configureButtonBindings();
    publishAutonomousData();
  }

  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(m_controller, 1); // X
    limelightTrackingButton.whileHeld(m_visionCommand);

    JoystickButton ballShooterButton = new JoystickButton(m_controller, 8); // RT
    ballShooterButton.whileHeld(m_shootUpperCommand);

    JoystickButton intakeArmButton = new JoystickButton(m_controller, 3); // B
    intakeArmButton.toggleWhenPressed(m_intakeArmCommand);

    POVButton lowerShooterLiftUpButton = new POVButton(m_controller, 0);
    lowerShooterLiftUpButton.whileHeld(m_lowerShooterLiftUpCommand);

    POVButton lowerShooterLiftDownButton = new POVButton(m_controller, 180);
    lowerShooterLiftDownButton.whileHeld(m_lowerShooterLiftDownCommand);

    JoystickButton upperShooterLiftButton = new JoystickButton(m_controller, 5);
    upperShooterLiftButton.whileHeld(m_upperShooterLiftCommand);

    JoystickButton intakeBallButton = new JoystickButton(m_controller, 4); // Y
    intakeBallButton.whileHeld(m_intakeBallCommand);

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

  private void publishAutonomousData () {
    m_autoChooser.setDefaultOption("None", "None");
    m_autoChooser.addOption("Move Back / Shoot High", "MoveBackShootHigh");
    m_autoChooser.addOption("Move Back / Shoot Low", "MoveBackShootLow");
    m_autoChooser.addOption("Move Back", "MoveBack");
    SmartDashboard.putData("autoChooser", m_autoChooser);
    SmartDashboard.putNumber("Shooter Speed", 0.65);
  }
}