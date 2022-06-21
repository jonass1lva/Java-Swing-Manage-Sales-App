package pt.ipleiria.ViewManagers;

public class Transaction {
    private int transaction;
    private String name;

    public String getIcon() {
        if(transaction == TransactionType.BUY) {
            return "src/resources/buy.png";
        } else {
            return "src/resources/sell.png";
        }
    }

    public void setTransaction(int transaction) {
        this.transaction = transaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
