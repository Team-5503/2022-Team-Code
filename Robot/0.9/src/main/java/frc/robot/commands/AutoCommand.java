package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LowerShooterLift;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.UpperShooterLift;

public class AutoCommand extends CommandBase {
  private Timer timer;
  private final Drivetrain drivetrain;
  private final Shooter shooter;
  private final LowerShooterLift lowerShooterLift;
  private final UpperShooterLift upperShooterLift;
  private boolean finish = false;

  public AutoCommand(Drivetrain dt, Shooter s, LowerShooterLift lLift, UpperShooterLift uLift) {
    drivetrain = dt;
    shooter = s;
    lowerShooterLift = lLift;
    upperShooterLift = uLift;
    addRequirements(drivetrain, shooter, lowerShooterLift, upperShooterLift);
    timer = new Timer();
  }


  @Override
  public void initialize() {
        timer.reset();
    if (RobotContainer.autoChooser.getSelected().contains("None")) {
      drivetrain.stop();
    } else if (RobotContainer.autoChooser.getSelected().contains("MoveBackShoot")) {
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, -0.5); // Drive backward 3 sec
      }

      drivetrain.stop();
      timer.reset();
      timer.start();
      while (timer.get() < 2) {
        shooter.runBallShooter(0.5); // Run Ball Shooter
      }
      timer.reset();
      timer.start();
      while (timer.get() < 3) {
        shooter.runBallShooter(0.5);
        lowerShooterLift.liftUp(-0.25);
        upperShooterLift.liftUp();
      }
      lowerShooterLift.stop();
      upperShooterLift.stop();
      shooter.stopBallShooter();
      finish = true;

    } else if (RobotContainer.autoChooser.getSelected().contains("MoveBack")) {
      timer.start();
      while (timer.get() < 3) {
        drivetrain.AutoArcadeDrive(0, -0.5);
      }
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
