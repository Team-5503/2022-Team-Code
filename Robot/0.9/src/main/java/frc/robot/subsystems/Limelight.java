package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Limelight extends SubsystemBase {
  public double distance;
  PIDController pidController;
  public double output;
  public Limelight() {
    pidController = new PIDController(-0.1, 0, -025);
    pidController.setIntegratorRange(-0.5, 0.5);
  }
  @Override
  public void periodic() {}


  public void limelightOn () {
    RobotContainer.table.getEntry("camMode").setNumber(0);
    RobotContainer.table.getEntry("ledMode").setNumber(3);
  }

  public void limelightOff () {
    RobotContainer.table.getEntry("camMode").setNumber(1);
    RobotContainer.table.getEntry("ledMode").setNumber(1);
  }

  
  public void estimateDistance () {
    // d = (h2-h1) / tan(a1+a2)
    distance = ((101.625 - 34) / Math.tan(Math.toRadians(39.5 + RobotContainer.table.getEntry("ty").getDouble(0))));
    SmartDashboard.putNumber("Target Distance", distance / 12);
  }

  public void trackTargetX () {
    output = pidController.calculate(RobotContainer.table.getEntry("tx").getDouble(0), 0);
  }
}


