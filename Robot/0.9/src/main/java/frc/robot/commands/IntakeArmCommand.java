package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArms;


public class IntakeArmCommand extends CommandBase {
  private final IntakeArms intakeArms;

  public IntakeArmCommand(IntakeArms ir) {
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
