package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public final Solenoid solenoid1;
  public final Solenoid solenoid2;
  public final PWMSparkMax intakeSparkMax;
  public Intake() {
    solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, 5);
    solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, 7);
    intakeSparkMax = new PWMSparkMax(8);
  }

  @Override
  public void periodic() {

  }

  public void intakeArmsExtend() {
    solenoid1.set(true);
    solenoid2.set(false);
    SmartDashboard.putBoolean("IntakeStat", false);
    }

  public void intakeArmsRetract() {
    solenoid1.set(false);
    solenoid2.set(true);
    SmartDashboard.putBoolean("IntakeStat", true);
    }

    public void ballIntake () {
      intakeSparkMax.set(-0.25);
    }

    public void ballEject () {
      intakeSparkMax.set(0.25);
    }

    public void stopIntake () {
      intakeSparkMax.stopMotor();
    }
}

