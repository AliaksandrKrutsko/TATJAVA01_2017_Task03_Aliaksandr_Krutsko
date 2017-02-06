package controller;



import java.io.IOException;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public String executeTask(String request) throws IOException {

        String commandName;
        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimeter));//somehow it doesn't work
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;

    }



}
