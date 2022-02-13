package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterLiftDownCommand extends CommandBase {
  private final Shooter shooter;
  public ShooterLiftDownCommand(Shooter s) {
    shooter = s;
    addRequirements(shooter);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    shooter.shooterLiftDown();
  }


  @Override
  public void end(boolean interrupted) {
    shooter.stopShooterLift();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
