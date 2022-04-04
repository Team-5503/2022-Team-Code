package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  public final CANSparkMax  intake;
  public Intake() {
    intake = new CANSparkMax(Constants.CAN.INTAKE, MotorType.kBrushless);
  }

  @Override
  public void periodic() {}

    public void ballIntake () {
      intake.set(SmartDashboard.getNumber("Intake", 0.75)); // Invert
    }

    public void ballEject () {
      intake.set(SmartDashboard.getNumber("Intake", 0.75) * -1);
    }

    public void stopIntake () {
      intake.set(0);
    }
}

