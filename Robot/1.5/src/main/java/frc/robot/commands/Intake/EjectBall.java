package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeAgitator;

public class EjectBall extends CommandBase {
  private final Intake intake;
  private final IntakeAgitator intakeAgitator;
    public EjectBall(Intake i, IntakeAgitator ia) {
      intake = i;
      intakeAgitator = ia;
      addRequirements(intake, intakeAgitator);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    intake.ballEject();
    intakeAgitator.agitatorReverse();
  }

  @Override
  public void end(boolean interrupted) {
    intake.stopIntake();
    intakeAgitator.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
