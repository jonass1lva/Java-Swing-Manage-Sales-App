package pt.ipleiria.managers;

import pt.ipleiria.model.Part;

import java.util.LinkedList;

public class PartManager {
    private LinkedList<Part> registeredParts = new LinkedList<>();

    public void registerPart(Part part, BranchManager branches) {
        if (getPart(part.getReference()) == null){
            registeredParts.add(part);
            branches.addPartToBranches(part);
        }
    }

    public Part getPart(int reference) {
        for( Part part: this.registeredParts){
            if (part.getReference() == reference) return part;
        }
        return null;
    }

    public LinkedList<Part> getRegisteredParts() {
        return registeredParts;
    }

}
