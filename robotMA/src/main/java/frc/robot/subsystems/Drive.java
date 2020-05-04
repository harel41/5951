
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
  public static Drive drive;
  
  private CANSparkMax M_LeftUp;
  private CANSparkMax M_LeftDown;
  private CANSparkMax M_RightUp;
  private CANSparkMax M_RightDown;

  public Drive() { 
    M_LeftUp = new CANSparkMax(Constants.DriveMotorAPort, MotorType.kBrushless);
    M_LeftDown = new CANSparkMax(Constants.DriveMotorBPort, MotorType.kBrushless);
    M_RightUp = new CANSparkMax(Constants.DriveMotorCPort, MotorType.kBrushless);
    M_RightDown = new CANSparkMax(Constants.DriveMotorDPort, MotorType.kBrushless);
    
  M_LeftUp.setInverted(true);
  M_LeftDown.setInverted(true);

  M_LeftDown.follow(M_LeftUp);
  M_RightDown.follow(M_RightUp);
  }
  public void left(double power){
    M_LeftUp.set(power);
  }
  public void right(double power){
    M_RightUp.set(power);
  }



  public static Drive getinstance() {
    if (drive == null) {
      drive = new Drive();
    }
    return drive;
  }
}


