package pt.ipleiria.model;

public enum CarCondition {
    FLAWLESS(1.0),
    GOOD(0.9),
    ACCEPTABLE(0.7),
    BAD(0.45),
    HORRIBLE(0.2);

    private double valueMultiplier;

    CarCondition(double valueMultiplier) {
        this.valueMultiplier = valueMultiplier;
    }

    public double getValueMultiplier() {
        return valueMultiplier;
    }
}
