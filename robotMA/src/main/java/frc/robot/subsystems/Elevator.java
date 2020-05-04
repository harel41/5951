
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    public static Elevator elevator;

    WPI_TalonSRX ElevatorMotor;

    Encoder encoder;

    PIDController pid;

   double Elevator_KP = 1;
   double Elevator_KI = 1;
   double Elevator_KD = 1;

    public Elevator() {
        ElevatorMotor = new WPI_TalonSRX(Constants.ElevatorMotorPort);
       
        
    // Create New Encoder Object
    encoder = new Encoder(Constants.ElevatorEncoderAPort, Constants.ElevatorEncoderBPort, false, EncodingType.k4X);

    // Create Limit Switch
    ElevatorMotor.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen);

    // Create New PID Object
    pid = new PIDController(Elevator_KP, Elevator_KI, Elevator_KD);

    }

    public void elevatorMove(double power) {
        ElevatorMotor.set(ControlMode.PercentOutput, power);
    }


    public static Elevator getinstance() {
        if (elevator == null) {
            elevator = new Elevator();
    }
    return elevator;
  }
  
  // Encoder Functions
  public void resetEncoder(){
    encoder.reset();
  }
  public double getDistance(){
    return encoder.getDistance();
  }


  //Limit Switch Functions
  public boolean getLimitSwitch(){
    return ElevatorMotor.getSensorCollection().isFwdLimitSwitchClosed();
  }

  //PID Functions
  public double getEncoderPID(double setpoint){
    return pid.calculate(getDistance(), setpoint);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Distance: ", getDistance());
    SmartDashboard.putBoolean("Limit Switch Status: ", getLimitSwitch());

    if(getLimitSwitch() == true){
      resetEncoder();
    }
}
}