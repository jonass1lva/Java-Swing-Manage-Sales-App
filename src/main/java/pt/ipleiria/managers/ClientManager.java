package pt.ipleiria.managers;

import pt.ipleiria.model.Client;
import pt.ipleiria.model.User;
import java.util.LinkedList;
import java.util.Objects;

public class ClientManager {
    LinkedList<Client> clients = new LinkedList<>();

    private void addClient(Client client) {
        if (getClient(client.getNif()) == null) clients.add(client);
    }

    public Client getClient(int nif) {
        for( Client client: this.clients){
            if (client.getNif() == nif) return client;
        }
        return null;
    }

    public LinkedList<Client> seedClients(int numClients){
        for (int i = 1; i <= numClients; i++) {
            
        }
    }

}
