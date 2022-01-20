package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSystem extends SubsystemBase {
  Compressor compressor;
  PneumaticsControlModule pcm;
  public IntakeSystem() {
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    pcm = new PneumaticsControlModule(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ClearPCMStickyFaults () {
    pcm.clearAllStickyFaults();
  }
}

