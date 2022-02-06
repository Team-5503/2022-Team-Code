package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final PWMSparkMax shooterLift;


  public Shooter() {
    shooterLift = new PWMSparkMax(2);
    }

  @Override
  public void periodic() {

  }

  public void runShooter () {
    shooterLift.set(0.25);
  }

  public void stopShooter () {
    shooterLift.stopMotor();
  }
}
