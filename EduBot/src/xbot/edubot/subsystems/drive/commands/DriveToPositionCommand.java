package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class DriveToPositionCommand extends BaseCommand {

	DriveSubsystem drive;
	double goal;
	double x;
	boolean isFinished;
	
	@Inject
	public DriveToPositionCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	public void setTargetPosition(double position) {
		goal = position;
		// This method will be called by the test, and will give you a goal distance.
		// You'll need to remember this target position and use it in your calculations.
	}
	
	@Override
	public void initialize() {
		// If you have some one-time setup, do it here.
	}

	@Override
	public void execute() {
		double a = 1.0;
		double b = 1.0;
		x = goal - drive.distanceSensor.getDistance();
		if (x < goal/1.02) {
			a = 1.0;
			b = 1.0;
		}
		if (x < goal/1.0526) {
			a = .54;
			b = .54;
		}
		if (x < goal/1.25) {
			a = -0.50;
			b = -0.50;
		}
		if (x < goal/1.5) {
			a = .05;
			b = .05;
		}
		if (x < goal/2.5) {
			a = .00;
			b = .00;
		}

		if (goal < drive.distanceSensor.getDistance()) {
			a = 0.0;
			b = 0.0;
		}
		drive.tankDrive(a, b);
	
		if(drive.distanceSensor.getDistance() >= goal) {
			isFinished = true;
		}
		else {
			isFinished = false;
		}
	}

		// Here you'll need to figure out a technique that:
		// - Gets the robot to move to the target position 
		// - Hint: use drive.distanceSensor.get() to find out where you are
		// - Gets the robot stop (or at least be moving really really slowly) at the target position
		
		// How you do this is up to you. If you get stuck, ask a mentor or student for some hints!
	
	
	@Override
	public boolean isFinished() {
		// Modify this to return true once you have met your goal, 
		// and you're moving fairly slowly (ideally stopped)
		if(isFinished) {
		return true;
		}
		else {
			return false;
		}
	}

}
