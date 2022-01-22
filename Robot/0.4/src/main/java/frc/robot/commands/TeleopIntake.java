package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class TeleopIntake extends CommandBase {
  private final Intake intake;
    /** Creates a new TeleopIntake */
  public TeleopIntake(Intake i) {
    intake = i;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.intakeDown();
    }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
