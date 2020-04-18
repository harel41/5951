
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.driveCommend;
import frc.robot.commands.elevatorCommend;
import frc.robot.commands.mamotaMove;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.elevator;
import frc.robot.subsystems.mamota;

public class Robot extends TimedRobot {
  @Override
  public void robotInit() {
    new RobotContainer();
    driveCommend driveCommend = new driveCommend(drive.getinstance());
    mamotaMove mamotaMove = new mamotaMove(mamota.getinstance());
    elevatorCommend elevatorCommend = new elevatorCommend(elevator.getinstance());
    CommandScheduler.getInstance().setDefaultCommand(drive.getinstance(), driveCommend);
    CommandScheduler.getInstance().setDefaultCommand(mamota.getinstance(), mamotaMove);
    CommandScheduler.getInstance().setDefaultCommand(elevator.getinstance(), elevatorCommend);

  }
}