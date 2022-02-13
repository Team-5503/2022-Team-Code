package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
 import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  Drivetrain drivetrain;
  private final PIDController pidController;
  public NetworkTable table;
  public double distance;
  private double trackingError;
  public Limelight() {
    pidController = new PIDController(-0.35, 0, 0.001);
    pidController.enableContinuousInput(-0.5, 0.5);
    table = NetworkTableInstance.getDefault().getTable("limelight");
  }

  @Override
  public void periodic() {}


  public void ledsOn () {
    table.getEntry("camMode").setNumber(0);
    table.getEntry("ledMode").setNumber(3);
  }

  public void ledsOff () {
    table.getEntry("camMode").setNumber(1);
    table.getEntry("ledMode").setNumber(1);
  }

  public void estimateDistance () {
    distance = table.getEntry("ty").getDouble(0) + (35 * (32 / Math.tan(3.14 / 180) * (4 / 12)));
    SmartDashboard.putNumber("TargetDistance", distance);
    /* 
    Takes vertical offset from Limelight, adds 35 (target height)
    and multiplies it 32 divided by a tangent converted to degrees (hence 3.14 divided by 180)
    and finally multiplies the output by 4 / 12.
    This returns the target distance in feet.
    */
   }

   public void trackTarget () {
     trackingError = pidController.calculate(table.getEntry("tx").getDouble(0), 0);
     drivetrain.ArcadeDrive(trackingError, 0);
   }
}
