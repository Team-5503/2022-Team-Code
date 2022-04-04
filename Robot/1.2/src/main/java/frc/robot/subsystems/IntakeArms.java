// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeArms extends SubsystemBase {
  private final Solenoid solenoid1;
  private final Solenoid solenoid2;
  /** Creates a new IntakeArms. */
  public IntakeArms() {
    solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PCM.SOLENOID_1);
    solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.PCM.SOLENOID_2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void intakeArmsExtend() {
    solenoid1.set(true);
    solenoid2.set(false);
    SmartDashboard.putBoolean("IntakeStat", true);
    }

    public void intakeArmsRetract() {
      solenoid1.set(false);
      solenoid2.set(true);
      SmartDashboard.putBoolean("IntakeStat", false);
      }
}


