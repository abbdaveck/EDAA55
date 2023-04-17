public class BankAccount {
    String holderName;
    long holderIdNr;
    long holderCustomerNr;
    double amount = 0;
    int accountNr;
    int accountIndex;

    public BankAccount(Customer holder){
        holder.accountCounter++;
        this.holderName = holder.getName();
        this.holderCustomerNr = holder.getCustomerNr();
        this.holderIdNr = holder.getidNr();
        this.accountNr = 1000 + holder.accountCounter;
    }   

    public double getAmount(){
        return amount;
    }

    public void deposit(double deposition){
        amount += deposition;
    }

    public void withdraw(double withdrawal){
        amount -= withdrawal;
    }

    public String toString(){
        // System.out.println("konto " + accountNr + " (" + holderName + ", id " + holderIdNr + ", kundnr " + holderCustomerNr + "): " + amount + " kr");
        return "konto " + accountNr + " (" + holderName + ", id " + holderIdNr + ", kundnr " + holderCustomerNr + "): " + amount + " kr";
    }

    public String getName(){
        return holderName;
    }

    public long getidNr(){
        return holderIdNr;
    }

    public long getCustomerNr(){
        return holderCustomerNr;
    }

    public long getAccountNr(){
        return accountNr;
    }
}
