
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class climb extends SubsystemBase {
  public static climb climb;
  DoubleSolenoid dSolenoid;

  public climb() {
    dSolenoid = new DoubleSolenoid(1, 2);

  }

  public void extend() {
    dSolenoid.set(Value.kForward);
  }

  public void extract() {
    dSolenoid.set(Value.kReverse);
  }

  public static climb getinstance() {
    if (climb == null) {
      climb = new climb();
    }
    return climb;
  }
}


