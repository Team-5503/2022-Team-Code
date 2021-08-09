// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.networktables.NetworkTableEntry;


public class Limelight extends SubsystemBase {
  Object Limelight;
  NetworkTableEntry tx;
  NetworkTableEntry ty;
  NetworkTableEntry ta;
  NetworkTableEntry ts;
  NetworkTableEntry tv;
  NetworkTableEntry camMode;
  NetworkTableEntry ledMode;
  /** Creates a new Limelight. */
  public Limelight() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx");
    ty = table.getEntry("ty");
    ta = table.getEntry("ta");
    ts = table.getEntry("ts");
    tv = table.getEntry("tv");
    camMode = table.getEntry("camMode");
    ledMode = table.getEntry("ledMode");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enableTargeting(NetworkTableEntry camMode, NetworkTableEntry ledMode) {
    camMode.setNumber(Constants.LIMELIGHT_VISION_PROCESSOR); // Camera set to Vision Processor
    ledMode.setNumber(Constants.LIMELIGHT_LED_ON); // LED Array ON
  }

  public void disableTargeting(NetworkTableEntry camMode, NetworkTableEntry ledMode) {
    camMode.setNumber(Constants.LIMELIGHT_OPERATOR_CAMERA); // Camera set to Operator Camera
    ledMode.setNumber(Constants.LIMELIGHT_LED_OFF); // LED Array OFF
  }

}
