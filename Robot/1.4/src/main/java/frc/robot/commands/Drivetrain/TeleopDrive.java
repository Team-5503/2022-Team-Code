package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  private final Drivetrain drivetrain;

  public TeleopDrive(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
      drivetrain.ArcadeDrive(SmartDashboard.getNumber("Drivetrain X", 0.85), SmartDashboard.getNumber("Drivetrain Y", 0.9) * -1);
      }

  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  
  @Override
  public boolean isFinished() {
    return false;
  }
}
