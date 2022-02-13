package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final PWMSparkMax shooterLift;
  private final PWMTalonFX ballShooter;


  public Shooter() {
    shooterLift = new PWMSparkMax(5);
    ballShooter = new PWMTalonFX(6);
    }

  @Override
  public void periodic() {

  }

  public void shooterLiftUp () {
    shooterLift.set(0.1);
  }

  public void shooterLiftDown () {
    shooterLift.set(-0.1);
  }

  public void stopShooterLift () {
    shooterLift.stopMotor();
  }

  public void runBallShooter (double speed) {
    ballShooter.set(speed);
  }

  public void stopBallShooter () {
    ballShooter.stopMotor();
  }
}
