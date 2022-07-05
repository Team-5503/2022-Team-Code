package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;

public class ZoomIn extends CommandBase {
  private final Limelight limelight;

  public ZoomIn(Limelight ll) {
    limelight = ll;
    addRequirements(limelight);

  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    limelight.zoomIn();
    limelight.limelightOn();
    limelight.estimateDistance();
  }


  @Override
  public void end(boolean interrupted) {
    limelight.zoomOut();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
