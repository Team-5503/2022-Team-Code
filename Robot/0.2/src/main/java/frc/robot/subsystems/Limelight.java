package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  public final NetworkTable table;
  public final PIDController pidController;
  public double distance;
  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    pidController = new PIDController(0, 0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ledsOn () {
    table.getEntry("camMode").setNumber(0);
    table.getEntry("ledMode").setNumber(3);
  }

  public void ledsOff () {
    table.getEntry("camMode").setNumber(1);
    table.getEntry("ledMode").setNumber(1);
  }

  public void trackDistance () {
    distance = table.getEntry("ty").getDouble(0) + (35 * Math.tan(3.14 / 180) / 32 * 4);
    SmartDashboard.putNumber("distance", distance);  
   }
}
