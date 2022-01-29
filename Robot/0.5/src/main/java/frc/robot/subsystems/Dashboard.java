package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Dashboard extends SubsystemBase {
  public SendableChooser<String> autoChooser;
  public Dashboard() {
    autoChooser = new SendableChooser<String>();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
      
  public void autoInit () {
    autoChooser.setDefaultOption("None", "None");
    autoChooser.addOption("Straight Back (Red)", "StraightBackRed");
    autoChooser.addOption("Straight Back (Blue)" ,"StraightBackBlue");
    SmartDashboard.putData("autoChooser", autoChooser);
    
  }
}
