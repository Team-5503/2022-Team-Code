package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Agitator;

public class Auto extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private final Limelight limelight;
  private final Shooter shooter;
  private final Indexer lowerShooterLift;
  private final Agitator agitator;
  private boolean finish = false;

  public Auto(Drivetrain dt, Limelight ll, Shooter s, Indexer lLift, Agitator a) {
    drivetrain = dt;
    limelight = ll;
    shooter = s;
    lowerShooterLift = lLift;
    agitator = a;
    addRequirements(drivetrain, limelight, shooter, lowerShooterLift, agitator);
    timer = new Timer();
  }


  @Override
  public void initialize() {
        timer.reset();
    if (RobotContainer.m_autoChooser.getSelected().contains("None")) {
      //
    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBackShootHigh")) {
      timer.start();
      while (timer.get() < SmartDashboard.getNumber("HighShotBackupTime", 2)) {
        drivetrain.AutoArcadeDrive(0, SmartDashboard.getNumber("Auto Drivetrain Y", 0.55)); // Drive backward 2.5 sec
      }
      drivetrain.stop();
      timer.reset();
      timer.start();

      while (timer.get() < 2.5) {
        limelight.limelightOn();
        limelight.trackTargetX();
      }
      timer.reset();
      timer.start();
      while (timer.get() < 2) {
        shooter.runBallShooter(SmartDashboard.getNumber("Auto Shooter Speed", 0.65)); // Run Ball Shooter
      }
      timer.reset();
      timer.start();
      while (timer.get() < 3) {
        shooter.runBallShooter(0.6);
        lowerShooterLift.liftUp(-0.5);
        agitator.run(-0.35);
      }
      timer.reset();
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, SmartDashboard.getNumber("Auto Drivetrain Y", 0.6));
      }
      timer.reset();
      drivetrain.stop();
      limelight.limelightOff();
      lowerShooterLift.stop();
      agitator.stop();
      shooter.stopBallShooter();
      finish = true;

    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBackShootLow")) {
      timer.reset();
      timer.start();
      while (timer.get() < 2) {
        lowerShooterLift.liftUp(-0.5);
        agitator.run(-0.35);
        shooter.runBallShooter(0.35);
      }
      shooter.stopBallShooter();
      lowerShooterLift.stop();
      agitator.stop();
      timer.reset();
      timer.start();
      while (timer.get() < 2) {
        drivetrain.AutoArcadeDrive(0, SmartDashboard.getNumber("Auto Drivetrain Y", 0.6));
      }
      timer.reset();
      timer.start();
      while (timer.get() < 3) {
        drivetrain.stop();
      }
      finish = true;

    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBack")) {
      timer.start();
      while (timer.get() < 2) {
        limelight.limelightOff();
        drivetrain.AutoArcadeDrive(0, 0.6);
      }
      finish = true;
    }
}


  @Override
  public void execute() {}


  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
    limelight.limelightOff();
    lowerShooterLift.stop();
    agitator.stop();
    shooter.stopBallShooter();
  }

  
  @Override
  public boolean isFinished() {
    drivetrain.stop();
    limelight.limelightOff();
    lowerShooterLift.stop();
    agitator.stop();
    shooter.stopBallShooter();
    return finish;
  }
}
