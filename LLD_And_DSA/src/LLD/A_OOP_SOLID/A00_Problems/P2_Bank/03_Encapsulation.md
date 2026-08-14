# P2 — Bank Account Encapsulation

## Objective

Protect the bank account's balance using **Encapsulation**.

---

# Fields

```java
private int accountNumber;
private String accountHolder;
private double balance;
````

---

# Tasks

Create:

```text
getAccountNumber()
setAccountNumber()

getAccountHolder()
setAccountHolder()

getBalance()
```

For `balance`, do **not** create a normal Setter.

Instead create:

```text
deposit()
withdraw()
```

---

# Rules

### deposit(amount)

Allow deposit only when:

```text
amount > 0
```

Then add the amount to `balance`.

---

### withdraw(amount)

Allow withdrawal only when:

```text
amount > 0
AND
amount <= balance
```

Then subtract the amount from `balance`.

Otherwise, do not modify the balance.

---

# Solution

## BankAccount.java

```java
package LLD.A_OOP_SOLID.A00_Code.C2_Bank;

public class BankAccount {

    private int accountNumber;
    private String accountHolder;
    private double balance;

    // Getter
    public int getAccountNumber() {
        return accountNumber;
    }

    // Setter
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter
    public String getAccountHolder() {
        return accountHolder;
    }

    // Setter
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Controlled balance modification
    public void deposit(double amount) {

        if (amount > 0) {
            this.balance = balance + amount;
        }
    }

    // Controlled balance modification
    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            this.balance = balance - amount;
        }
    }
}
```

---

# Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C2_Bank;

public class Main {

    public static void main(String[] args) {

        BankAccount b1 = new BankAccount();

        b1.setAccountNumber(1001);
        b1.setAccountHolder("Om");

        b1.deposit(5000);
        b1.withdraw(1500);

        System.out.println(
                b1.getAccountNumber() + " " +
                b1.getAccountHolder() + " " +
                b1.getBalance()
        );
    }
}
```

---

# Expected Output

```text
1001 Om 3500.0
```

---

# Validation Test

You should also test invalid operations:

```java
b1.deposit(-500);
b1.withdraw(-200);
b1.withdraw(10000);
```

These operations should **not change the balance**.

The balance remains:

```text
3500.0
```

---

# Why No `setBalance()`?

We intentionally do not create:

```java
setBalance()
```

because that would allow outside code to directly decide the balance.

For example:

```java
account.setBalance(100000);
```

would bypass the rules of a bank account.

Instead:

```java
account.deposit(100000);
```

or:

```java
account.withdraw(500);
```

lets the `BankAccount` class control how its balance changes.

---

# Encapsulation Flow

```text
private balance
      ↓
Outside code cannot access directly
      ↓
deposit()
withdraw()
      ↓
Validation
      ↓
balance changes only when rules are satisfied
```

---

# What You Learned

* `private` protects the internal fields.
* Getters provide controlled read access.
* Setters provide controlled write access.
* `balance` does not need a normal Setter.
* `deposit()` controls adding money.
* `withdraw()` controls removing money.
* Validation protects the object's state.
* This is stronger than simply using Getter + Setter.

---

# Interview Questions

### Q1. Why is `balance` private?

To prevent direct modification from outside the class.

### Q2. Why don't we create `setBalance()`?

Because balance should change only through valid banking operations.

### Q3. Why use `deposit()`?

It represents a real operation and can validate the amount before changing the balance.

### Q4. Why use `withdraw()`?

It ensures the withdrawal is valid and prevents the balance from becoming negative.

### Q5. What is the main Encapsulation concept here?

The object controls its own internal state instead of allowing outside code to modify it directly.

---

# Success Checklist

* [x] Made all fields `private`.
* [x] Created `getAccountNumber()`.
* [x] Created `setAccountNumber()`.
* [x] Created `getAccountHolder()`.
* [x] Created `setAccountHolder()`.
* [x] Created `getBalance()`.
* [x] Did not create `setBalance()`.
* [x] Created `deposit()`.
* [x] Created `withdraw()`.
* [x] Added validation.
* [x] Tested valid transactions.
* [x] Tested invalid transactions.
* [x] Understood controlled balance modification.
* [x] Understood real-world Encapsulation.

---

# Concept Demonstrated

```text
Class
  ↓
private data
  ↓
Controlled methods
  ↓
Validation
  ↓
Protected object state
```

---

# Status

**P2 — Bank Account Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P3 — Library Encapsulation**

```