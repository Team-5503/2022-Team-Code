package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class VisionCommand extends CommandBase {
  private final Limelight limelight;
  private final Drivetrain drivetrain;
  double output;
  public VisionCommand(Limelight ll, Drivetrain dt) {
    limelight = ll;
    drivetrain = dt;
    addRequirements(limelight);
    addRequirements(drivetrain);

  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    limelight.limelightOn();
    drivetrain.LimelightDrive_X(limelight.output, 0.6);
    limelight.estimateDistance();
  }




  @Override
  public void end(boolean interrupted) {
    limelight.limelightOff();
  }
  

  @Override
  public boolean isFinished() {
    return false;
  }
}
