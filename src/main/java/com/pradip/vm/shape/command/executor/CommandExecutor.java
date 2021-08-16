package com.pradip.vm.shape.command.executor;

import com.pradip.vm.shape.command.Command;

public abstract class CommandExecutor {
	public CommandExecutor() {
	}

	public abstract String getName();

	public boolean validateCommand(Command command) {
		if(!command.getCommandName().equals(getName()))
			return false;
		return validate(command);
	}

	protected abstract boolean validate(Command command);

	public abstract void executeCommand(Command command);
}
