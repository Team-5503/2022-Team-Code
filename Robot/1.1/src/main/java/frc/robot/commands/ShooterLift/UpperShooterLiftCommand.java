package frc.robot.commands.ShooterLift;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.UpperShooterLift;
public class UpperShooterLiftCommand extends CommandBase {
  private final UpperShooterLift upperShooterLift;
  public UpperShooterLiftCommand(UpperShooterLift uLift) {
    upperShooterLift = uLift;
    addRequirements(upperShooterLift);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    upperShooterLift.liftUp(0.25);
  }


  @Override
  public void end(boolean interrupted) {
    upperShooterLift.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
