package LLD.A_OOP_SOLID.A00_Code.C2_Bank;

public class BankAccount {
    int accountNumber;
    String holderName;
    double balance;
    String accountType;

    BankAccount(int accountNumber,String holderName,double balance,String accountType){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }
}
