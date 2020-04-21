
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Mamota extends SubsystemBase {
  public static Mamota mamota ;
  WPI_TalonSRX talon;
  WPI_VictorSPX victor;

  public Mamota() {
    talon = new WPI_TalonSRX(1);
    victor = new WPI_VictorSPX(2);

  }

  public void move(double power) {
    talon.set(ControlMode.PercentOutput, power);
  }

  public void input(double power) {
    victor.set(ControlMode.PercentOutput, power);
  }

  public static Mamota getinstance() {
    if (mamota == null) {
      mamota = new Mamota();
    }
    return mamota;  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
  

 

