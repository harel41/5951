
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class elevator extends SubsystemBase {
    public static elevator elevator;
    WPI_TalonSRX talon3;

    public elevator() {
        talon3 = new WPI_TalonSRX(1);
       
    }

    public void elevatorMove(double power) {
        talon3.set(ControlMode.PercentOutput, power);
    }


    public static elevator getinstance() {
        if (elevator == null) {
            elevator = new elevator();
    }
    return elevator;
  }
}