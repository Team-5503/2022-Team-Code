// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard extends SubsystemBase {

  NetworkTable table;
  public double Limelight_TX;
  public double Limelight_TY;
  public double Limelight_TA;
  public double Limelight_TS;
  public double Limelight_CamMode;
  public double Limelight_LEDMode;

  public Dashboard() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    Limelight_TX = table.getEntry("tx").getDouble(0);
    Limelight_TY = table.getEntry("ty").getDouble(0);
    Limelight_TA = table.getEntry("ta").getDouble(0);
    Limelight_TS = table.getEntry("ts").getDouble(0);

    Limelight_CamMode = table.getEntry("camMode").getDouble(0);
    Limelight_LEDMode = table.getEntry("ledMode").getDouble(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("LimelightX", Limelight_TX);
    SmartDashboard.putNumber("LimelightY", Limelight_TY);
    SmartDashboard.putNumber("LimelightArea", Limelight_TA);
    SmartDashboard.putNumber("LimelightSkew", Limelight_TS);
  }

  public void publishData (String varName, double value) {
    SmartDashboard.putNumber(varName, value);
  }
}
