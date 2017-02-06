package controller;


public class ControllerFactory {

    private static final ControllerFactory instance = new ControllerFactory();

    private final Controller controller = new Controller();

    public static ControllerFactory getInstance() {return instance;}

    public Controller getController() {return controller;}


}
