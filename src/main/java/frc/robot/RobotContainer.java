
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.climbCommend;
import frc.robot.commands.intakePull;
import frc.robot.commands.mamotaInput;
import frc.robot.commands.mamotaOutput;
import frc.robot.subsystems.climb;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.mamota;

public class RobotContainer {

  public static Joystick leftJoystick = new Joystick(1);
  public static Joystick righJoystick = new Joystick(2);
  public static XboxController xbox = new XboxController(1);
  public static JoystickButton aButton = new JoystickButton(xbox, 1);
  public static JoystickButton bButton = new JoystickButton(xbox, 2);
  public static Joystick intakeJoystick = new Joystick(1);
  public static JoystickButton gButton = new JoystickButton(xbox, 4);
  public static JoystickButton yButton = new JoystickButton(xbox, 5);
  public static JoystickButton cButton = new JoystickButton(xbox, 6);
  public static Joystick elevatorJoystick = new Joystick(3);


  public RobotContainer() {

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    aButton.whenPressed(new mamotaOutput(mamota.getinstance()));
    bButton.whenPressed(new mamotaInput(mamota.getinstance()));
    gButton.whenPressed(new intakePull(intake.getinstance()));
    yButton.whenPressed(new climbCommend(climb.getinstance()));
    cButton.whenPressed(new climbCommend(climb.getinstance()));
  }


public Command getAutonomousCommand() {
	return null;
}
}
