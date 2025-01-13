package Assignment1;

import Lecture4_interfaces_abstract_classes.TransactionInterface;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
public class BaseTransaction  implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;
    protected BankAccount changedAccount;
    protected boolean isChanged = false;

    public BaseTransaction(double amount, @NotNull Calendar date, String transactionID) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000);
        this.transactionID = date.toString() + uniq;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    public String getTransactionID() {
        return  transactionID;
    }

    public void printTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("ID: " + getTransactionID());
        System.out.println("Amount: $" + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Processing transaction: " + transactionID);
        System.out.println("Current balance before transaction: $" + ba.getBalance());
        this.changedAccount = ba;
    }
    @Override
    public boolean reverse() {
        System.out.println("Base transactions cannot be reversed");
        return false;
    }
}




