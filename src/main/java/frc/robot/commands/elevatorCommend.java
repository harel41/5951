
package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorCommend extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private Elevator elevator;

    public ElevatorCommend() {
      elevator = Elevator.getinstance();
  
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(elevator);
    }


 @Override
 public void initialize() {
 }

  @Override
    public void execute() {
      elevator.elevatorMove(RobotContainer.Operator_Joystick.getRawAxis(3));    
  }


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

     // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
