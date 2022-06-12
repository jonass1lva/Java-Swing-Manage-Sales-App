package pt.ipleiria.model;

public class Part {
    private final String designation;
    private final int reference;
    private final String description;
    private int stock;

    public Part(String designation, int reference, String description) {
        this.designation = designation;
        this.reference = reference;
        this.description = description;
        this.stock = 0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int addStock(int quantity) {
        return this.stock+= quantity;
    }

    public int removeStock(int quantity) {
        if (quantity<=this.stock){
            return this.stock-= quantity;
        }
        return -1;
    }

    public String getDesignation() {
        return designation;
    }

    public int getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

}
