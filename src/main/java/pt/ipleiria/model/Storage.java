package pt.ipleiria.model;

import pt.ipleiria.managers.*;

public class Storage {
    private static Storage instance = null;

    private ClientManager clientManager;
    private BranchManager branchManager;
    private PartManager partManager;
    private VehicleManager vehicleManager;

    private UserManager userManager;

    private Storage() {
        userManager = new UserManager();
        clientManager = new ClientManager();
        clientManager.seedClients(10);
        vehicleManager = new VehicleManager();
        vehicleManager.seedVehicles(30, clientManager);
        vehicleManager.printVehicles();
        branchManager = new BranchManager();
        partManager = new PartManager();
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public BranchManager getBranchManager() {
        return branchManager;
    }

    public PartManager getPartManager() {
        return partManager;
    }

    public VehicleManager getVehicleManager() {
        return vehicleManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public static Storage getInstance() {
        if(instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}

