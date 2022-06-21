package pt.ipleiria.model;

import pt.ipleiria.managers.*;
import pt.ipleiria.views.LoginView;


public class Main {
    public static LoginView loginView;
    public static void main(String[] args) {
        // Manager Sets
        UserManager users = new UserManager();

        ClientManager clients = new ClientManager();
        clients.seedClients(10);

        VehicleManager vehicles = new VehicleManager();
        vehicles.seedVehicles(30, clients);

        PartManager registeredParts = new PartManager(); //Fazer seeder
        BranchManager branches = new BranchManager(); //Fazer seeder

        vehicles.printVehicles();


        // Initial View Load
        loginView = new LoginView();
        loginView.setVisible(true);
    }


}
