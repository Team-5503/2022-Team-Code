package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class IntakeArmCommand extends CommandBase {
  private final Intake intake;

  public IntakeArmCommand(Intake i) {
    intake = i;
    addRequirements(intake);
  }


  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
    intake.intakeArmsExtend(); 
  }


  @Override
  public void end(boolean interrupted) {
    intake.intakeArmsRetract();
    }


  @Override
  public boolean isFinished() {
    return false;
  }
}
