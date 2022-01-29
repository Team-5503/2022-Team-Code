package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public final Solenoid solenoid1;
  public final Solenoid solenoid2;
  public Intake() {
    solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeUp() {
    solenoid1.set(true);
    solenoid2.set(false);
    SmartDashboard.putBoolean("IntakeStat", false);
    }

  public void intakeDown() {
    solenoid1.set(false);
    solenoid2.set(true);
    SmartDashboard.putBoolean("IntakeStat", true);
    }
}

