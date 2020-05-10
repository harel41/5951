
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimbCommend;
import frc.robot.commands.IntakeMove;
import frc.robot.commands.IntakeMoveRev;
import frc.robot.commands.IntakePiston;
import frc.robot.commands.IntakePull;
import frc.robot.commands.MamotaInput;
import frc.robot.commands.MamotaOutput;

public class RobotContainer {

  public static Joystick Left_Joystick = new Joystick(0);
  public static Joystick Right_Joystick = new Joystick(1);
  public static XboxController Operator_Joystick = new XboxController(2);
  public static JoystickButton aButton = new JoystickButton(Operator_Joystick, 1);
  public static JoystickButton yButton = new JoystickButton(Operator_Joystick, 2);
  public static JoystickButton xButton = new JoystickButton(Operator_Joystick, 3);
  public static JoystickButton bButton = new JoystickButton(Operator_Joystick, 4);
  public static JoystickButton rbButton = new JoystickButton(Operator_Joystick, 5);
  public static JoystickButton lbButton = new JoystickButton(Operator_Joystick, 6);
  public static JoystickButton rfButton = new JoystickButton(Operator_Joystick, 7);

  public RobotContainer() {

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    aButton.whileHeld(new MamotaInput());
    yButton.whileHeld(new MamotaOutput());
    xButton.whileHeld(new IntakePull());
    bButton.whenPressed(new IntakePiston());
    rbButton.whenPressed(new ClimbCommend());
    lbButton.whileHeld(new IntakeMove());
    rfButton.whileHeld(new IntakeMoveRev());

  }


public Command getAutonomousCommand() {
	return null;
}
}
