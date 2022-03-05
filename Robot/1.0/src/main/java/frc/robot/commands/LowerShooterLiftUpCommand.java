package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LowerShooterLift;

public class LowerShooterLiftUpCommand extends CommandBase {
  private final LowerShooterLift lowerShooterLift;

  public LowerShooterLiftUpCommand(LowerShooterLift lLift) {
    lowerShooterLift = lLift;
    addRequirements(lowerShooterLift);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    lowerShooterLift.liftUp(-0.15);
  }


  @Override
  public void end(boolean interrupted) {
    lowerShooterLift.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
