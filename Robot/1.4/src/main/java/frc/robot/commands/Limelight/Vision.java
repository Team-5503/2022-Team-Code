package frc.robot.commands.Limelight;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class Vision extends CommandBase {
  private final Limelight limelight;
  private final Drivetrain drivetrain;
  double output;
  public Vision(Limelight ll, Drivetrain dt) {
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
    limelight.trackTargetX();
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
