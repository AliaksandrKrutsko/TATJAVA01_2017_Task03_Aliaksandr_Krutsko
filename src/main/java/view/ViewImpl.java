package view;

import controller.Controller;
import controller.ControllerFactory;
import java.io.IOException;
import java.util.Scanner;

public class ViewImpl implements View {


    @Override
    public void enterCommand() {

        Scanner scanner = new Scanner(System.in);
        String request = scanner.nextLine();


        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        Controller controller = controllerFactory.getController();
        try {
            controller.executeTask(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
