package com.pradip.vm.shape.command.factory;

import java.util.HashMap;
import java.util.Map;

import com.pradip.vm.shape.command.Command;
import com.pradip.vm.shape.command.executor.CircleCommandExecutor;
import com.pradip.vm.shape.command.executor.CommandExecutor;
import com.pradip.vm.shape.command.executor.RectangleCommandExecutor;
import com.pradip.vm.shape.command.executor.SquareCommandExecutor;

public class CommandExecutorFactory {
	private static Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();
	
	public CommandExecutorFactory() {
		commandExecutorMap.put(
				"Circle",
				new CircleCommandExecutor());
		commandExecutorMap.put(
				"Square",
				new SquareCommandExecutor());
		commandExecutorMap.put(
				"Rectangle",
				new RectangleCommandExecutor());
	}
	
	/**
	 * Gets {@link CommandExecutor} for a particular command. It basically uses name of command to
	 * fetch its corresponding executor.
	 *
	 * @param command Command for which executor has to be fetched.
	 * @return Command executor.
	 */
	public CommandExecutor getCommandExecutor(final Command command) {
//		System.out.println(command);
		final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
		if (commandExecutor == null) {
			throw new RuntimeException("Invalid Command");
		}
		return commandExecutor;
	}
}
