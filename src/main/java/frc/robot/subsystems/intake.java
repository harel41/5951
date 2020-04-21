
package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  public static Intake intake;
  Solenoid piston;
  WPI_TalonSRX talon1;
  WPI_TalonSRX talon2;
  WPI_VictorSPX victor;

  public Intake() {
    talon1 = new WPI_TalonSRX(1);
    talon2 = new WPI_TalonSRX(2);
    piston = new Solenoid(1);
    victor = new WPI_VictorSPX(3);
    talon1.setInverted(true);
    talon1.follow(talon2);
  }

  public void moveIntake(double power) {
    talon1.set(ControlMode.PercentOutput, power);
  }

  public void intakeCollect(double power) {
    victor.set(ControlMode.PercentOutput, power);

  }

  public void pistonFire(boolean t) {
    piston.set(t);
  }

  public boolean getPiston() {
    return piston.get();
  }

  public static Intake getinstance() {
    if (intake == null) {
      intake = new Intake();
    }
    return intake;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void IntakeMove(int i) {
}
}

    

