package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootUpper extends CommandBase {
  private final Shooter shooter;
  public ShootUpper(Shooter s) {
    shooter = s;
    addRequirements(shooter);
    }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    shooter.runBallShooter(SmartDashboard.getNumber("Shooter Speed", 0.6));
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
