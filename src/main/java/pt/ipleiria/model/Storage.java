package pt.ipleiria.model;

import pt.ipleiria.managers.BranchManager;
import pt.ipleiria.managers.ClientManager;
import pt.ipleiria.managers.PartManager;
import pt.ipleiria.managers.VehicleManager;

public class Storage {
    private static Storage instance = null;

    private ClientManager clientManager;
    private BranchManager branchManager;
    private PartManager partManager;
    private VehicleManager vehicleManager;

    private Storage() {
        clientManager = new ClientManager();
        clientManager.seedClients(10);
        vehicleManager = new VehicleManager();
        vehicleManager.seedVehicles(30, clientManager);
        vehicleManager.printVehicles();
        branchManager = new BranchManager();
        partManager = new PartManager();
    }

    public static Storage getInstance() {
        if(instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}

