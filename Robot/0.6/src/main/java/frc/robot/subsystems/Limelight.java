package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.RobotContainer;

public class Limelight extends SubsystemBase {
  // private final Drivetrain drivetrain;
  public final NetworkTable table;
  public double distance;
  public PIDController pidController;
  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    // drivetrain = new Drivetrain();
    pidController = new PIDController(-0.35, 0, 0.001);
    pidController.enableContinuousInput(-0.5, 0.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void ledsOn () {
    /*
    Camera set to "Vision Processor"
    LED array set to "Force On"
    */
    table.getEntry("camMode").setNumber(0);
    table.getEntry("ledMode").setNumber(3);
  }

  public void ledsOff () {
    /*
     Camera set to "Operator Camera"
     LED array set to "Force Off"
    */
    table.getEntry("camMode").setNumber(1);
    table.getEntry("ledMode").setNumber(1);
  }

  public void estimateDistance () {
    distance = table.getEntry("ty").getDouble(0) + (35 * (32 / Math.tan(3.14 / 180) * (4 / 12)));
    /* 
    Takes vertical offset from Limelight, adds 35 (target height)
    and multiplies it 32 divided by a tangent converted to degrees (hence 3.14 divided by 180)
    and finally multiplies the output by 4 / 12.
    This returns the target distance in feet.
    */
    SmartDashboard.putNumber("distance", distance);  
   }

   public void trackTarget () {
     // drivetrain.ArcadeDrive(0, RobotContainer.controller.getRawAxis(0) * pidController.calculate(table.getEntry("ty").getDouble(0), 0));

     // CRASHES ROBOT PROGRAM, DO NOT UNCOMMENT
   }
}
