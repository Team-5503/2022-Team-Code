package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Limelight extends SubsystemBase {
  public double distance;
  PIDController pidController;
  public double output;
  public boolean enabled;
  public Limelight() {
    pidController = new PIDController(-0.1, 0, 0);
    pidController.setIntegratorRange(-0.5, 0.5);
  }

  @Override
  public void periodic() {}


  public void limelightOn () {
    RobotContainer.m_table.getEntry("camMode").setNumber(0);
    RobotContainer.m_table.getEntry("ledMode").setNumber(3);
    enabled = true;
  }

  public void limelightOff () {
    RobotContainer.m_table.getEntry("camMode").setNumber(1);
    RobotContainer.m_table.getEntry("ledMode").setNumber(1);
    enabled = false;
  }

  
  public void estimateDistance () {
    // d = (h2-h1) / tan(a1+a2)
    distance = ((101.625 - 34) / Math.tan(Math.toRadians(39.5 + RobotContainer.m_table.getEntry("ty").getDouble(0))));
    SmartDashboard.putNumber("Target Distance", distance / 12);
  }

  public void trackTargetX () {
    output = pidController.calculate(RobotContainer.m_table.getEntry("tx").getDouble(0), 0);
  }

  public void zoomIn () {
    RobotContainer.m_table.getEntry("pipeline").setNumber(1);
  }

  public void zoomOut () {
    RobotContainer.m_table.getEntry("pipeline").setNumber(0);
  }
}


