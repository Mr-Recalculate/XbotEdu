package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.rotation.MockHeadingSensor;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TurnLeft90DegreesCommand extends BaseCommand {
	
	DriveSubsystem drive;
	MockHeadingSensor gyro;

	MockHeadingSensor x;
	
	@Inject
	public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
		this.drive = driveSubsystem;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		x = drive.gyro;
		
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}



}
