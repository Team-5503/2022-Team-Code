package frc.robot.subsystems;

// import com.revrobotics.CANPIDController;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

  PWMSparkMax topShooter;
  PWMSparkMax bottomShooter;

  // CANSparkMax topShooter;
  // CANSparkMax bottomShooter;
  // CANPIDController topPID;
  // CANPIDController bottomPID;

  public Shooter() {

    topShooter = new PWMSparkMax(4);
    bottomShooter = new PWMSparkMax(5);


    // topShooter = new CANSparkMax(1, MotorType.kBrushless);
    // bottomShooter = new CANSparkMax(4, MotorType.kBrushless);

    // topPID = topShooter.getPIDController();
    // bottomPID = bottomShooter.getPIDController();
    
    //setPIDGains();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runShooter(double topSpeed, double bottomSpeed) {
    topShooter.set(topSpeed * -1);
    bottomShooter.set(bottomSpeed);
  }

  public void stopShooter() {
    topShooter.stopMotor();
    bottomShooter.stopMotor();
  }

  // public void setPIDGains() {

    // Top PID Controller
      // topPID.setP(0.0001);
      // topPID.setI(0.000075);
      // topPID.setD(0);
      // topPID.setFF(0);
      // topPID.setIZone(0);
      // topPID.setOutputRange(-1, 1);


    // Bottom PID Controller
      // bottomPID.setP(0.0001);
      // bottomPID.setI(0.000075);
      // bottomPID.setD(0);
      // bottomPID.setFF(0);
      // bottomPID.setIZone(0);
      // bottomPID.setOutputRange(-1, 1);
  }

