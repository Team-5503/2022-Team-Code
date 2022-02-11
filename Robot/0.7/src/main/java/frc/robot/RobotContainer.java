package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.VisionCommand;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.IntakeArmCommand;
import frc.robot.commands.IntakeBallCommand;
import frc.robot.commands.ServoCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.EjectBallCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterServo;
import frc.robot.subsystems.Intake;


public class RobotContainer {


  // Subsystems 
    private final Drivetrain drivetrain;
    private final Limelight limelight;
    private final Intake intake;
    private final Shooter shooter;
    private final ShooterServo shooterServo;

  // Commands
    private final DriveCommand driveCommand;
    private final VisionCommand visionCommand;
    private final AutoCommand autoCommand;
    private final IntakeArmCommand intakeArmCommand;
    private final ShooterCommand shooterCommand;
    private final ServoCommand servoCommand;
    private final IntakeBallCommand intakeBallCommand;
    private final EjectBallCommand ejectBallCommand;
    public static Joystick controller;

    public static SendableChooser<String> autoChooser;
    private final PneumaticsControlModule pcm;

  public RobotContainer() {

    // Subsystems
      drivetrain = new Drivetrain();

      limelight = new Limelight();
      intake = new Intake();
      shooter = new Shooter();
      shooterServo = new ShooterServo();

    // Commands
      driveCommand = new DriveCommand(drivetrain);
      visionCommand = new VisionCommand(limelight);
      autoCommand = new AutoCommand(drivetrain);
      intakeArmCommand = new IntakeArmCommand(intake);
      shooterCommand = new ShooterCommand(shooter);
      servoCommand = new ServoCommand(shooterServo);
      intakeBallCommand = new IntakeBallCommand(intake);
      ejectBallCommand = new EjectBallCommand(intake);
    
    controller = new Joystick(Constants.USB.OPERATOR_0);

    drivetrain.setDefaultCommand(driveCommand);

    autoChooser = new SendableChooser<String>();
    pcm = new PneumaticsControlModule();


    configureButtonBindings();
    publishAutonomousData();
    clearPCMStickyFaults();
  }

  private void configureButtonBindings() {
    JoystickButton limelightTrackingButton = new JoystickButton(controller, 1); // X
    limelightTrackingButton.toggleWhenPressed(visionCommand);

    JoystickButton intakeButton = new JoystickButton(controller, 3); // B
    intakeButton.toggleWhenPressed(intakeArmCommand);

    JoystickButton shooterButton = new JoystickButton(controller, 8); // RT
    shooterButton.whileHeld(shooterCommand);

    JoystickButton shooterServoButton = new JoystickButton(controller, 7); // LT
    shooterServoButton.whileHeld(servoCommand);

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
    autoChooser.addOption("Straight Back (Red)", "StraightBackRed");
    autoChooser.addOption("Straight Back (Blue)" ,"StraightBackBlue");
    SmartDashboard.putData("autoChooser", autoChooser);
  }

  public void clearPCMStickyFaults () {
    if (RobotController.getUserButton() == true) {
      pcm.clearAllStickyFaults();
    }
  }
}