package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class VisionCommand extends CommandBase {
  private final Limelight limelight;
  public VisionCommand(Limelight ll) {
    limelight = ll;
    addRequirements(limelight);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    limelight.ledsOn();
    limelight.estimateDistance();
    limelight.trackTarget();

  }


  @Override
  public void end(boolean interrupted) {
    limelight.ledsOff();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
