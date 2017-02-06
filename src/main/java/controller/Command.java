package controller;


import dao.DaoException;

import java.io.IOException;

public interface Command {

    public String execute(String request) throws IOException;


}