package frc.robot.commands.Climber;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Climber;

public class ClimberCommand extends CommandBase {
  private Climber climber;
  public ClimberCommand(Climber c) {
    climber = c;
    addRequirements(climber);
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    climber.runClimber(RobotContainer.m_controller.getRawAxis(3) * SmartDashboard.getNumber("Climber", -0.3));
  }


  @Override
  public void end(boolean interrupted) {
    climber.stop();
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
