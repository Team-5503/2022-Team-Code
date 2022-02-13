package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeBall_InCommand extends CommandBase {
  private final Intake intake;
    public IntakeBall_InCommand(Intake i) {
      intake = i;
      addRequirements(intake);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    intake.ballIntake();
  }


  @Override
  public void end(boolean interrupted) {
    intake.stopIntake();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
