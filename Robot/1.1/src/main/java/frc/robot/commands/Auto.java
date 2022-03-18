package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.LowerShooterLift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.UpperShooterLift;

public class Auto extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private final Limelight limelight;
  private final Shooter shooter;
  private final LowerShooterLift lowerShooterLift;
  private final UpperShooterLift upperShooterLift;
  private boolean finish = false;

  public Auto(Drivetrain dt, Limelight ll, Shooter s, LowerShooterLift lLift, UpperShooterLift uLift) {
    drivetrain = dt;
    limelight = ll;
    shooter = s;
    lowerShooterLift = lLift;
    upperShooterLift = uLift;
    addRequirements(drivetrain, limelight, shooter, lowerShooterLift, upperShooterLift);
    timer = new Timer();
  }


  @Override
  public void initialize() {
        timer.reset();
    if (RobotContainer.m_autoChooser.getSelected().contains("None")) {
      drivetrain.stop();
    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBackShootHigh")) {
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, 0.5); // Drive backward 3 sec
      }

      drivetrain.stop();
      timer.reset();
      timer.start();

      while (timer.get() < 3) {
        limelight.limelightOn();
        limelight.trackTargetX();
      }
      timer.reset();
      timer.start();
      while (timer.get() < 5) {
        shooter.runBallShooter(0.6); // Run Ball Shooter
      }
      timer.reset();
      timer.start();
      while (timer.get() < 5) {
        shooter.runBallShooter(0.6);
        lowerShooterLift.liftUp(-0.5);
        upperShooterLift.liftUp(0.35);
      }
      limelight.limelightOff();
      lowerShooterLift.stop();
      upperShooterLift.stop();
      shooter.stopBallShooter();
      finish = true;

      
    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBack")) {
      timer.start();
      while (timer.get() < 3) {
        limelight.limelightOff();
        drivetrain.AutoArcadeDrive(0, 0.5);
      }
      finish = true;

    } else if (RobotContainer.m_autoChooser.getSelected().contains("MoveBackShootLow")) {
      timer.reset();
      timer.start();
      while (timer.get() < 2) {
        drivetrain.AutoArcadeDrive(0, 0.5);
      }
      drivetrain.stop();
      timer.reset();
      timer.start();
      while (timer.get() < 3) {
        shooter.runBallShooter(0.5);
      }
      timer.reset();
      timer.start();

      while (timer.get() < 3) {
        limelight.limelightOn();
        limelight.trackTargetX();
      }
      while (timer.get() < 3) {
        shooter.runBallShooter(0.5);
        lowerShooterLift.liftUp(-0.5);
        upperShooterLift.liftUp(0.35);
      }
      limelight.limelightOff();
      shooter.stopBallShooter();
      lowerShooterLift.stop();
      upperShooterLift.stop();
      finish = true;
    }

}


  @Override
  public void execute() {}


  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  
  @Override
  public boolean isFinished() {
    drivetrain.stop();
    return finish;
  }
}
