package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class BallShooterCommand extends CommandBase {
  private final Shooter shooter;
  public BallShooterCommand(Shooter s) {
    shooter = s;
    addRequirements(shooter);
    }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    shooter.runBallShooter(0.7);
  }


  @Override
  public void end(boolean interrupted) {
    shooter.stopBallShooter();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
