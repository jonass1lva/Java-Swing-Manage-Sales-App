package pt.ipleiria.managers;

import pt.ipleiria.model.Client;
import pt.ipleiria.model.Main;
import pt.ipleiria.model.User;
import java.util.LinkedList;
import java.util.Objects;

public class ClientManager {
    LinkedList<Client> clients = new LinkedList<>();
    public void addClient(Client client) {
        if (getClient(client.getNif()) == null) clients.add(client);
    }
    public Client getClient(int nif) {
        for( Client client: this.clients){
            if (client.getNif() == nif) return client;
        }
        return null;
    }
    public void seedClients(int numClients){
        for (int i = 1; i <= numClients; i++) {
            String name = "Cliente" + i;
            int nif = 258000000 + i;
            int phoneNumber = 910000000 + i;

            addClient(new Client(name, nif, phoneNumber));
        }
    }
    public Client getRandomClient(){ //Todo Só para testes ou seeder de veiculos, esta função devia ser privada
        return clients.get((int)(Math.random() * clients.size()));
    }
}
