package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends CommandBase {
  private final Shooter shooter;

  public ShooterCommand(Shooter s) {
    shooter = s;
    addRequirements(shooter);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    shooter.runShooter();
  }


  @Override
  public void end(boolean interrupted) {
    shooter.stopShooter();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
