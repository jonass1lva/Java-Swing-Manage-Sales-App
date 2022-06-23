package pt.ipleiria.managers;

import pt.ipleiria.model.CarCondition;
import pt.ipleiria.model.Client;
import pt.ipleiria.model.Vehicle;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class VehicleManager {
    LinkedList<Vehicle> vehicles  = new LinkedList<>();

    public void addVehicle(Vehicle vehicle) {
        if (getVehicle(vehicle.getVin()) == null) vehicles.add(vehicle);
    }

    public Vehicle getVehicle(String vin) {
        for( Vehicle vehicle: this.vehicles){
            if (vin.equalsIgnoreCase(vehicle.getVin())) return vehicle;
        }
        return null;
    }

    public void seedVehicles(int numVehicles, ClientManager clients){
        for (int i = 1; i <= numVehicles; i++) {

            String []brands = {"Mercedes", "Volvo", "Volkswagen", "Audi", "Pegeut", "Citroen", "Fiat", "Renault"};
            String []models = {"Benz", "Class A", "V40", "V60", "C40", "Golf", "Polo", "A4", "A5", "R8", "TT", "206", "208","C2", "C3", "C4", "Punto", "500", "Quadra", "Clio"};
            String []colors = {"Branco", "Preto", "Cinza", "Prateado", "Vermelho", "Azul", "Castanho", "Verde", "Beje", "Laranja", "Dourado", "Amarelo", "Roxo"};

            Boolean inOurPosession = i%2==0;

            String brand = brands[i % brands.length];
            String model = models[i % models.length];
            String plate = Integer.toHexString(i);
            String licensePlate = Integer.toHexString(i % 16).repeat(Math.max(0, 6 - plate.length())) +plate;
            int kilometers = (int)(Math.random() * 500000);
            float price = (float)((Math.random() * (50000 - 1000)) + 1000);

            String AlphaNumeric = "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx123456789";
            StringBuilder vin = new StringBuilder();
            for (int j = 0; j < 17; j++) {
                int index = (int)((Math.random() * (AlphaNumeric.length() - 1)) + 1);
                vin.append(AlphaNumeric.charAt(index));
            }

            String color = colors[i % colors.length];
            int year = 2022 - i;
            int nmrOwners = i%5;
            Client lastOwner = clients.getRandomClient();

            //long ms = -946771200000L + ((long)(Math.random() % (70L * 365 * 24 * 60 * 60 * 1000)));
            Date lastInspectionDate = new Date() ;//acho que aqui era para usar o ms mas devo de me ter esquecido por isso comentei o ms tambem e já se vê que data é que está a pôr

            CarCondition condition = CarCondition.GOOD;

            addVehicle(new Vehicle(inOurPosession, brand, model, licensePlate, kilometers, price, vin.toString(), color, year
            , nmrOwners, lastOwner, lastInspectionDate, condition));

        }
    }

    public void printVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.printVehicle();
        }
    }

    public void deleteVehicle(String vin) {
        Vehicle vehicle = getVehicle(vin);
        vehicles.remove(vehicle);

        //todo tirar isto
        printVehicles();
    }
}
