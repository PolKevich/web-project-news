package by.htp.ex.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ex.controller.impl.DoAddNews;
import by.htp.ex.controller.impl.DoRegistration;
import by.htp.ex.controller.impl.DoSIgnIn;
import by.htp.ex.controller.impl.DoSignOut;
import by.htp.ex.controller.impl.GoToAddNewsPage;
import by.htp.ex.controller.impl.GoToBasePage;
import by.htp.ex.controller.impl.GoToErrorPage;
import by.htp.ex.controller.impl.GoToNewsList;
import by.htp.ex.controller.impl.GoToRegistrationPageCommand;
import by.htp.ex.controller.impl.GoToViewNews;


public class CommandProvider {
	
public Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

public CommandProvider() {
	commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
	commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
	commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPageCommand());
	commands.put(CommandName.DO_SIGN_IN, new DoSIgnIn());
	commands.put(CommandName.DO_SIGN_OUT, new DoSignOut());
	commands.put(CommandName.GO_TO_NEWS_LIST, new GoToNewsList());
	commands.put(CommandName.GO_TO_VIEW_NEWS, new GoToViewNews());
	commands.put(CommandName.DO_ADD_NEWS, new DoAddNews());
	commands.put(CommandName.GO_TO_ADD_NEWS_PAGE, new GoToAddNewsPage());
	commands.put(CommandName.GO_TO_ERROR_PAGE, new GoToErrorPage());
}

public Command getCommand(String name) {
	CommandName commandName = CommandName.valueOf(name.toUpperCase());
	Command command = commands.get(commandName);
	return command;
	
}
}
