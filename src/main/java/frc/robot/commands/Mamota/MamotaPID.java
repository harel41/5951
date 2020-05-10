
package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mamota;


/**
 * An example command that uses an example subsystem.
 */
public class MamotaPID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Mamota mamota;
  private double lastTimeOnTarget;
  private double waitTime;
  private double setPoint;
  
  
  public MamotaPID(double setPoint, double waitTime) {
    mamota = Mamota.getinstance();
    this.setPoint = setPoint;
    this.waitTime = waitTime;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(mamota);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mamota.move(mamota.encoderPID(setPoint));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mamota.move(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(!mamota.PIDatSetpoint()){
      lastTimeOnTarget = Timer.getFPGATimestamp();
    }
    return mamota.PIDatSetpoint() && Timer.getFPGATimestamp() - lastTimeOnTarget > waitTime;
  }

}