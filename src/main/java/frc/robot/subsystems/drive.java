
package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  public static drive drive;
  CANSparkMax Spark1;
  CANSparkMax Spark2;
  CANSparkMax Spark3;
  CANSparkMax Spark4;

  public drive() {
    Spark1 = new CANSparkMax(1,MotorType.kBrushless);
    Spark2 = new CANSparkMax(2,MotorType.kBrushless);
    Spark3 = new CANSparkMax(3,MotorType.kBrushless);
    Spark4 = new CANSparkMax(4,MotorType.kBrushless);
    Spark1.setInverted(true);
    Spark2.setInverted(true);
    Spark2.follow(Spark1);
    Spark3.follow(Spark4);
    Spark1.setIdleMode(IdleMode.kBrake);
    Spark2.setIdleMode(IdleMode.kBrake);
    Spark3.setIdleMode(IdleMode.kBrake);
    Spark4.setIdleMode(IdleMode.kBrake);
  }
  public void left(double power){
    Spark1.set(power);
  }
  public void right(double power){
    Spark4.set(power);
  }



  public static drive getinstance() {
    if (drive == null) {
      drive = new drive();
    }
    return drive;
  }
}


