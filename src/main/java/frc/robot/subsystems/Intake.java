
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  public static Intake intake;

  //* Motors And Piston
   private Solenoid IntakePiston;
   private WPI_TalonSRX IntakeMoveA;
   private WPI_TalonSRX IntakeMoveB;
   private  WPI_VictorSPX IntakeMotor;

   private Encoder encoder;

   private PIDController pid;


  private static final double Intake_KP = 1;
  private static final double Intake_KI = 1;
  private static final double Intake_KD = 1;

  private Intake() {
    IntakePiston = new Solenoid(1);
    IntakeMoveA = new WPI_TalonSRX(Constants.IntakeMoveAPort);
    IntakeMoveB = new WPI_TalonSRX(Constants.IntakeMoveBPort);
    IntakeMoveA.follow(IntakeMoveB);
    IntakeMoveB.setInverted(true);

    IntakeMotor = new WPI_VictorSPX(Constants.IntakeMotorPort);

    encoder = new Encoder(Constants.IntakeEncoderAPort, Constants.IntakeEncoderBPort, false, EncodingType.k4X);
    encoder.setDistancePerPulse(1);

    // Creating Limit Switch
    IntakeMoveA.configForwardLimitSwitchSource(LimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyOpen);

    //? Creating New PID Object
    pid = new PIDController(Intake_KP, Intake_KI, Intake_KD);
    pid.setTolerance(1);
  }
  

  public void moveIntake(double power) {
    IntakeMoveA.set(ControlMode.PercentOutput, power);
  }

  public void intakeCollect(double power) {
    IntakeMotor.set(ControlMode.PercentOutput, power);

  }

  public void pistonFire(boolean state) {
    IntakePiston.set(state);
  }

  public boolean getPiston() {
    return IntakePiston.get();
  }

  public static Intake getinstance() {
    if (intake == null) {
      intake = new Intake();
    }
    return intake;
  }

  // Encoder Functions
  public double getDistance(){
    return encoder.getDistance();
  }


  public void resetEncoder(){
    encoder.reset();
  }

  // Limit Switch Functions
  public boolean getLimitSwitch(){
    return IntakeMoveA.getSensorCollection().isFwdLimitSwitchClosed();
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

    if(intake.getLimitSwitch()){
      intake.resetEncoder();
    }
  }
}
