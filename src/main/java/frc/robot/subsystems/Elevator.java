
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
import edu.wpi.first.wpiutil.math.MathUtil;

public class Elevator extends SubsystemBase {
    public static Elevator elevator;

    private WPI_TalonSRX ElevatorMotor;

    private Encoder encoder;

    private PIDController pid;

    private static final double Elevator_KP = 1;
    private static final double Elevator_KI = 1;
    private static final double Elevator_KD = 1;

    public Elevator() {
        ElevatorMotor = new WPI_TalonSRX(Constants.ElevatorMotorPort);
       
        
    // Create New Encoder Object
    encoder = new Encoder(Constants.ElevatorEncoderAPort, Constants.ElevatorEncoderBPort, false, EncodingType.k4X);

    // Create Limit Switch
    ElevatorMotor.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen);

    // Create New PID Object
    pid = new PIDController(Elevator_KP, Elevator_KI, Elevator_KD);
    pid.setTolerance(1);

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
  public double encoderPID(double setpoint){
    return pid.calculate(MathUtil.clamp(getDistance(), -1, 1), setpoint);
  }
  public boolean PIDatSetpoint(){
    return pid.atSetpoint();
  } 
  
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Distance: ", getDistance());
    SmartDashboard.putBoolean("Limit Switch Status: ", getLimitSwitch());

    if(getLimitSwitch()){
      resetEncoder();
    }
}
}