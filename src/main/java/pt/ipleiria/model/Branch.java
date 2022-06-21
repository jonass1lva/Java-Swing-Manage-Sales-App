package pt.ipleiria.model;

import java.util.LinkedList;

public class Branch {

    private String tipo;
    private final String name;
    private String location;
    private LinkedList<Part> partsList;
    private LinkedList<Vehicle> vehiclesList;

    public Branch(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LinkedList<Part> getParts() {
        return partsList;
    }

    public void registerPartToBranch(Part part){
        partsList.add(part);
    }

    public void useParts(int partRef, int quantity){
        getPart(partRef).removeStock(quantity);//se se tentar tirar mais do que as que há retorna -1 por isso pode-se aqui fazer alguma validação
    }

    public void receiveParts(int partRef, int quantity){
        getPart(partRef).addStock(quantity);
    }

    public Part getPart(int reference) {
        for( Part part: this.partsList){
            if (part.getReference() == reference) return part;
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }

    public LinkedList<Part> getPartsList() {
        return partsList;
    }

    public LinkedList<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

//TODO falta popular como os users, e fazer os metodos para criar as partes e atualizar todas ao mesmo tempo e assim
}
