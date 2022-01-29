package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Dashboard;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends CommandBase {
  private final Drivetrain drivetrain;
  private final Dashboard dashboard;

  /** Creates a new c_TeleopDrive. */
  public DriveCommand(Drivetrain dt, Dashboard db) {
    drivetrain = dt;
    dashboard = db;
    addRequirements(drivetrain);
    addRequirements(dashboard);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dashboard.autoInit();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.ArcadeDrive();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
