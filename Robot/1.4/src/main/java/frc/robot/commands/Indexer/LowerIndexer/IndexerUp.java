package frc.robot.commands.Indexer.LowerIndexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class IndexerUp extends CommandBase {
  private final Indexer lowerShooterLift;

  public IndexerUp(Indexer lLift) {
    lowerShooterLift = lLift;
    addRequirements(lowerShooterLift);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    lowerShooterLift.liftUp(-0.55);
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
