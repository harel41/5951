
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Mamota extends SubsystemBase {
  public static Mamota mamota ;

  // Motors
  WPI_TalonSRX MamotaMove;
  WPI_VictorSPX MamotaInput;

  // Indecators
  Encoder encoder;
  
    //PID
  PIDController pid; 

  double Mamota_KP = 1;
  double Mamota_KI = 1;
  double Mamota_KD = 1;

  private Mamota() {
    MamotaMove = new WPI_TalonSRX(Constants.MamotaMovePort);
    MamotaInput  = new WPI_VictorSPX(Constants.MamotaInputPort);

    encoder = new Encoder(Constants.MamotaEncoderAPort,Constants.MamotaEncoderBPort, false, EncodingType.k4X);
    encoder.setDistancePerPulse(1);

    MamotaMove.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen);

    pid = new PIDController(Mamota_KP, Mamota_KI, Mamota_KD);
    pid.setTolerance(1);



  }

  public void move(double power) {
    MamotaMove.set(ControlMode.PercentOutput, power);
  }

  public void input(double power) {
    MamotaInput.set(ControlMode.PercentOutput, power);
  }     

  public static Mamota getinstance() {
    if (mamota == null) {
      mamota = new Mamota();
    }
    return mamota;  
  }
  

  //Encoder Functions
  public void resetEncoder(){
    encoder.reset();
  }
  public double getDistance(){
    return encoder.getDistance();
  }


  //PID Functions
  public double anglePID(double setpoint){
    return pid.calculate(getDistance() * -1 , setpoint);
  }

  //Limit Switch Functions
  public boolean getLimitswitch(){
    return MamotaMove.getSensorCollection().isFwdLimitSwitchClosed();
  }

  //Motor Currnet Functions
  public double getMotorCurrnet(){
    return MamotaMove.getStatorCurrent();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Distance: ",getDistance());

    SmartDashboard.putBoolean("Limit Switch Status: ", getLimitswitch());

    if(mamota.getLimitswitch() == true){
      mamota.resetEncoder();
    }
  }
}
  

 

