package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public final CANSparkMax  intake;
  public Intake() {
    intake = new CANSparkMax(2, MotorType.kBrushless);
  }

  @Override
  public void periodic() {}

    public void ballIntake () {
      intake.set(-0.4); // Invert
    }

    public void ballEject () {
      intake.set(0.35);
    }

    public void stopIntake () {
      intake.set(0);
    }
}

