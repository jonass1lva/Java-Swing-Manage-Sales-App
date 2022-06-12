package pt.ipleiria.managers;

import pt.ipleiria.model.Branch;
import pt.ipleiria.model.Part;

import java.util.LinkedList;

public class BranchManager {
    LinkedList<Branch> branches = new LinkedList<>();

    public void registerBranch(Branch branch, PartManager registeredParts) {
        if (getBranch(branch.getName()) == null){
            for (Part part : registeredParts.getRegisteredParts()) {
                branch.registerPartToBranch(part);
            }
            branches.add(branch);
        }
    }

    public Branch getBranch(String name) {
        for( Branch branch : this.branches){
            if (branch.getName().equalsIgnoreCase(name)) return branch;
        }
        return null;
    }

    public void addPartToBranches(Part part){
        for (Branch branch : branches) {
            branch.registerPartToBranch(part);
        }
    }
}
