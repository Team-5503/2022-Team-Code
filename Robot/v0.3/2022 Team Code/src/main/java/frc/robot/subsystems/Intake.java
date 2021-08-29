package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  VictorSP intake;
  public Intake() {
    intake = new VictorSP(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runIntake(double intakeSpeed) {
    intake.set(intakeSpeed);
  }

  public void stopIntake() {
    intake.stopMotor();
  }
}
