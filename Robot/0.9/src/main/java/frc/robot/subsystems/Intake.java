package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  public final PWMSparkMax intakeSparkMax;
  public Intake() {
    intakeSparkMax = new PWMSparkMax(Constants.PWM.INTAKE);
  }

  @Override
  public void periodic() {

  }

    public void ballIntake () {
      intakeSparkMax.set(-0.15); // Invert
    }

    public void ballEject () {
      intakeSparkMax.set(0.15);
    }

    public void stopIntake () {
      intakeSparkMax.stopMotor();
    }
}

