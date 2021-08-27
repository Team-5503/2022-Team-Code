package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  CANSparkMax topShooter;
  CANSparkMax bottomShooter;

  // CANSparkMax topShooter;
  // CANSparkMax bottomShooter;
  // CANPIDController topPID;
  // CANPIDController bottomPID;

  public Shooter() {
    topShooter = new CANSparkMax(1, MotorType.kBrushless);
    bottomShooter = new CANSparkMax(4, MotorType.kBrushless);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double topSpeed, double bottomSpeed) {
    topShooter.set(topSpeed * -1);
    bottomShooter.set(bottomSpeed);
  }

  public void pidShoot (double topPID, double bottomPID) {
    topShooter.set(topPID);
    bottomShooter.set(bottomPID);
  }

  public void stopShooter() {
    topShooter.stopMotor();
    bottomShooter.stopMotor();
  }
}
