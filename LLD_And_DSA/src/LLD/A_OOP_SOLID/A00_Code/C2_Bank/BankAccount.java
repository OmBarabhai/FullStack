package LLD.A_OOP_SOLID.A00_Code.C2_Bank;

public class BankAccount {
   /* int accountNumber;
    String holderName;
    double balance;
    String accountType;

    BankAccount(int accountNumber,String holderName,double balance,String accountType){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }*/

    private int accountNumber;
    private String accountHolder;
    private double balance;

    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }
    public double getBalance(){

        return balance;
    }
    public void deposit(double amount){
        if(amount > 0){
            this.balance = balance + amount;
        }
    }
    public void withdraw(double amount){
        if(amount > 0 && amount<=balance){
            this.balance = balance - amount;
        }
    }
}
