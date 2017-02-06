package controller;


import controller.commands.AddNews;
import controller.commands.SearchNews;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();

    CommandProvider() {

        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.SEARCH_NEWS, new SearchNews());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {

            command = repository.get(CommandName.WRONG_REQUEST);
            System.out.println("Wrong request");
        }
        return command;


    }


}

