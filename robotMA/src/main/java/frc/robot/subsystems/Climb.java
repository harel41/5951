
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {

  public static Climb climb;
  
  public DoubleSolenoid sPiston;

  public Climb() {
    sPiston = new DoubleSolenoid(1, 2);

  }

  public void pistonFor() {
    sPiston.set(Value.kForward);
  }

  public void pistonRev() {
    sPiston.set(Value.kReverse);
  }

  public static Climb getinstance() {
    if (climb == null) {
      climb = new Climb();
    }
    return climb;
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
}
}
