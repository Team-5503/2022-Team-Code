package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArms;


public class IntakeArmsUpDown extends CommandBase {
  private final IntakeArms intakeArms;

  public IntakeArmsUpDown(IntakeArms ir) {
    intakeArms = ir;
    addRequirements(intakeArms);
  }


  @Override
  public void initialize() {
  }


  @Override
  public void execute() {
    intakeArms.intakeArmsExtend(); 
  }


  @Override
  public void end(boolean interrupted) {
    intakeArms.intakeArmsRetract();
    }


  @Override
  public boolean isFinished() {
    return false;
  }
}
