package frc.robot.commands.Shooter;

//import Misc.LinearInterpolator;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class ShootUpper extends CommandBase {
  private final Shooter shooter;
  private final Limelight limelight;
  //private LinearInterpolator m_linearInterpolator;
  public ShootUpper(Shooter s, Limelight ll) {
    shooter = s;
    limelight = ll;
    addRequirements(shooter);
    addRequirements(limelight);
    }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    shooter.runBallShooter(SmartDashboard.getEntry("Shooter Speed").getDouble(0.65));

    //shooter.runBallShooter(m_linearInterpolator.getInterpolatedValue(RobotContainer.m_table.getEntry("ty").getDouble(0)));
  }


  @Override
  public void end(boolean interrupted) {
    shooter.stopBallShooter();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
