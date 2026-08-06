package LLD.A_OOP_SOLID.Practice.P2_Bank;

public class Main {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.accountNumber = 3212321;
        b1.balance = 3212213.12;
        b1.holderName = "Om";
        b1.accountType = "Saving";
        System.out.println("Account Number : " +b1.accountNumber +"\nHolder Name   : "  + b1.balance + "\nBalance       : "  + b1.holderName + "\nType          : " + b1.accountType +"\n");
        BankAccount b2 = new BankAccount();
        b2.accountNumber = 32123231;
        b2.balance = 32132.12;
        b2.holderName = "Sahil";
        b2.accountType = "Current";
        System.out.println("Account Number : " +b2.accountNumber + "\nHolder Name   : "+ b2.balance +"\nBalance       : "+ b2.holderName + "\nType          : "  + b2.accountType+"\n");
        BankAccount b3 = new BankAccount();
        b3.accountNumber = 322113231;
        b3.balance = 32133312.12;
        b3.holderName = "Pavan";
        b3.accountType = "Saving";
        System.out.println("Account Number : " +b3.accountNumber + "\nHolder Name   : " + b3.balance + "\nBalance       : " + b3.holderName + "\nType          : "  + b3.accountType);

        //each object stored in heap and the referce is stored in stack pointing toward object
    }
}
