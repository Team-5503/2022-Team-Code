package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public double tx = table.getEntry("tx").getDouble(0);
  public double ty = table.getEntry("ty").getDouble(0);
  public double ta = table.getEntry("ta").getDouble(0);
  public double ts = table.getEntry("ts").getDouble(0);

  public Limelight() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enableVision() {

    SmartDashboard.putNumber("camMode", 0); // Vision Processing Enabled
    SmartDashboard.putNumber("ledMode", 3); // LED Array On
  }

  public void disableVision () {
    SmartDashboard.putNumber("camMode", 1); // Vision Processing Disabled
    SmartDashboard.putNumber("ledMode", 1); // LED Array Off
  }
}
