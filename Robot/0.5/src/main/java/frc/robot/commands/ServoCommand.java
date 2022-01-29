package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterServo;

public class ServoCommand extends CommandBase {
  private final ShooterServo shooterServo;
  public ServoCommand(ShooterServo ss) {
    shooterServo = ss;
    addRequirements(shooterServo);
  }


  @Override
  public void initialize() {}

  @Override
  public void execute() {
    shooterServo.disengageServo();
  }

  @Override
  public void end(boolean interrupted) {
    shooterServo.engageServo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
