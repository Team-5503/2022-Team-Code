package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeAgitator;

public class RunIntakeAgitator extends CommandBase {
  private final IntakeAgitator m_intakeAgitator;
  /** Creates a new IntakeAgitator. */
  public RunIntakeAgitator(IntakeAgitator i) {
    m_intakeAgitator = i;
    addRequirements(m_intakeAgitator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeAgitator.runIntakeAgitator();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeAgitator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
