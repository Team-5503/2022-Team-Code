package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterLiftUpCommand extends CommandBase {
  private final Shooter shooter;

  public ShooterLiftUpCommand(Shooter s) {
    shooter = s;
    addRequirements(shooter);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    shooter.shooterLiftUp();
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
