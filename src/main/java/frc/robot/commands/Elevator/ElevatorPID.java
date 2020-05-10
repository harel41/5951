
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Timer;


/**
 * An example command that uses an example subsystem.
 */
public class ElevatorPID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private Elevator elevator;
  private double lastTimeOnTarget;
  private double waitTime;
  private double setPoint;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public ElevatorPID(double setPoint, double waitTime) {
    elevator = Elevator.getinstance();
    this.setPoint = setPoint;
    this.waitTime = waitTime;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevator.elevatorMove(elevator.encoderPID(setPoint));      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.elevatorMove(0);

  }
  @Override
  public boolean isFinished() {
    if(elevator.PIDatSetpoint()){
      lastTimeOnTarget = Timer.getFPGATimestamp();
    }
    return elevator.PIDatSetpoint() && Timer.getFPGATimestamp() - lastTimeOnTarget > waitTime;
  }
}