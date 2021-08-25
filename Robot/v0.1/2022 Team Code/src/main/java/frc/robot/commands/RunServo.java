package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ShooterServo;

public class RunServo extends CommandBase {
  private final ShooterServo shooterServo;


  public RunServo(ShooterServo ss) {
    shooterServo = ss;
    addRequirements(shooterServo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterServo.runServo(Constants.SubsystemSpeeds.SERVO_ENGAGED_ANGLE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterServo.runServo(Constants.SubsystemSpeeds.SERVO_DISENGAGED_ANGLE);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
