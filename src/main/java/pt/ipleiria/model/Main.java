package pt.ipleiria.model;

import pt.ipleiria.managers.ClientManager;
import pt.ipleiria.managers.UserManager;
import pt.ipleiria.managers.VehicleManager;
import pt.ipleiria.views.LoginView;


public class Main {
    public static LoginView loginView;
    public static void main(String[] args) {
        // Manager Sets
        UserManager userManager = new UserManager();

        ClientManager clientManager = new ClientManager();
        clientManager.seedClients(10);

        VehicleManager vehicleManager = new VehicleManager();
        vehicleManager.seedVehicles(30, clientManager);

        vehicleManager.printVehicles();


        // Initial View Load
        loginView = new LoginView();
        loginView.setVisible(true);
    }
}
