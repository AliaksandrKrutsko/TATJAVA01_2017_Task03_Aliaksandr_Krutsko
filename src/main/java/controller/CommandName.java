package controller;


public class CommandName {

    public CommandName() {

    }

    public static CommandName ADD_NEWS;
    public static CommandName WRONG_REQUEST;
    public static CommandName SEARCH_NEWS;

    public static CommandName valueOf(String s) {
        return new CommandName();
    }
}
