package frc.robot.commands.ShooterLift.Agitator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Agitator;
import frc.robot.subsystems.Limelight;

public class AgitatorCommand extends CommandBase {
  private final Agitator agitator;
  private final Limelight limelight;
  
  public AgitatorCommand(Agitator a, Limelight ll) {
    agitator = a;
    limelight = ll;
    addRequirements(agitator, limelight);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    agitator.run(SmartDashboard.getNumber("Agitator", 0.5) * -1);
  }


  @Override
  public void end(boolean interrupted) {
    agitator.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
