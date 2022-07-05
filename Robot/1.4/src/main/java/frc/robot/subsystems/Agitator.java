package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Agitator extends SubsystemBase {
  private CANSparkMax upperShooterLift;

  public Agitator() {
    upperShooterLift = new CANSparkMax(Constants.CAN.AGITATOR, MotorType.kBrushless);
  }

  @Override
  public void periodic() {}


  public void run (double speed) {
    upperShooterLift.set(speed);
  }


  public void stop () {
    upperShooterLift.stopMotor();
  }
}
