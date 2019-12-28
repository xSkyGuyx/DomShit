/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private XboxController gamePad; 

  @Override
  public void robotInit() {
    m_myRobot = new DifferentialDrive(new SpeedControllerGroup(new PWMVictorSPX(0), new PWMVictorSPX(1), new PWMVictorSPX(2)), new SpeedControllerGroup(new PWMVictorSPX(3), new PWMVictorSPX(4), new PWMVictorSPX(5)));
    gamePad = new XboxController(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(gamePad.getRawAxis(1), gamePad.getRawAxis(5));
  }
}
