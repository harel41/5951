
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    public static Elevator elevator;
    WPI_TalonSRX talon3;

    public Elevator() {
        talon3 = new WPI_TalonSRX(1);
       
    }

    public void elevatorMove(double power) {
        talon3.set(ControlMode.PercentOutput, power);
    }


    public static Elevator getinstance() {
        if (elevator == null) {
            elevator = new Elevator();
    }
    return elevator;
  }
}