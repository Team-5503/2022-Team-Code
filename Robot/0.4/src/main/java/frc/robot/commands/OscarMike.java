package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class OscarMike extends CommandBase {
  private final Drivetrain drivetrain;
  /** Creates a new TeleopSprint. */
  public OscarMike(Drivetrain dt) {
    drivetrain = dt;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.ArcadeSprint(0.9, 0.95);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.ArcadeDrive(0.7, 0.75);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
