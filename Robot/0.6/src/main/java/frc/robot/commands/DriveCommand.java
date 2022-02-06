package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Dashboard;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
  private final Drivetrain drivetrain;
  private final Dashboard dashboard;


  public DriveCommand(Drivetrain dt, Dashboard db) {
    drivetrain = dt;
    dashboard = db;
    addRequirements(drivetrain);
    addRequirements(dashboard);
  }


  @Override
  public void initialize() {
    dashboard.autoInit();
  }


  @Override
  public void execute() {
    drivetrain.ArcadeDrive();
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
