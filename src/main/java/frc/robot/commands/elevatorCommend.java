
package frc.robot.commands;


import frc.robot.RobotContainer;
import frc.robot.subsystems.elevator;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class elevatorCommend extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private elevator elevator;

    public elevatorCommend(elevator subsystem) {
    elevator = subsystem;
    addRequirements(subsystem);
  }
  @Override
  public void execute() {
    elevator.elevatorMove(RobotContainer.elevatorJoystick.getY());
    
  }
}
