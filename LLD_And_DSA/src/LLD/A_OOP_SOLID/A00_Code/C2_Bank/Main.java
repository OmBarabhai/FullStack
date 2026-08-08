package LLD.A_OOP_SOLID.A00_Code.C2_Bank;

public class Main {

    public static void main(String[] args) {

        BankAccount b1 = new BankAccount(3212321,"Om",3212213.12,"Saving");
        System.out.println(STR."""
Account Number : \{b1.accountNumber}
Holder Name   : \{b1.holderName}
Balance       : \{b1.balance}
Type          : \{b1.accountType}
""");

        BankAccount b2 = new BankAccount(32123231,"Sahil",32132.12,"Current");
        System.out.println(STR."""
Account Number : \{b2.accountNumber}
Holder Name   : \{b2.holderName}
Balance       : \{b2.balance}
Type          : \{b2.accountType}
""");

        BankAccount b3 = new BankAccount(322113231,"Pavan",32133312.12,"Saving");
        System.out.println(STR."""
Account Number : \{b3.accountNumber}
Holder Name   : \{b3.holderName}
Balance       : \{b3.balance}
Type          : \{b3.accountType}""");

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ BankAccount is a Class (Blueprint).

        ✔ b1, b2 and b3 are Objects (Instances).

        ✔ Every call to new BankAccount() creates a
          new object in Heap Memory.

        ✔ b1, b2 and b3 are reference variables stored
          in the Stack Memory (inside main()).

        ✔ Every BankAccount object stores its own
          independent information.

        ✔ One object's data does not affect another
          object's data.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

              +----------------------+
              | main()               |
              |                      |
              | b1 ------+           |
              | b2 ----+ |           |
              | b3 --+ | |           |
              +------|-|-|-----------+
                     | | |
                     | | |
                     V V V

                    Heap Memory

        b1 -----------> BankAccount Object 1
                        accountNumber = 3212321
                        holderName    = "Om"
                        balance       = 3212213.12
                        accountType   = "Saving"

        b2 -----------> BankAccount Object 2
                        accountNumber = 32123231
                        holderName    = "Sahil"
                        balance       = 32132.12
                        accountType   = "Current"

        b3 -----------> BankAccount Object 3
                        accountNumber = 322113231
                        holderName    = "Pavan"
                        balance       = 32133312.12
                        accountType   = "Saving"

        ==================================================
        Interview Answer
        ==================================================

        Q. Where is each object stored in memory?

        Ans:

        Every time new BankAccount() is executed,
        Java creates a new BankAccount object in
        Heap Memory.

        The reference variables (b1, b2 and b3)
        are stored in the stack frame of the
        main() method.

        Each reference points to a different
        BankAccount object.

        Since every object has its own memory
        location, each object stores its own
        independent data.

        ==================================================
        */
    }
}