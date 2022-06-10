package pt.ipleiria.model;

public class Part {
    private final String designation;
    private final int reference;
    private final String description;

    public Part(String designation, int reference, String description) {
        this.designation = designation;
        this.reference = reference;
        this.description = description;
    }
}
