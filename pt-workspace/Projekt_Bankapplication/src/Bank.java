import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Bank {
    String bankName;
    int customerCounter = 100;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public Bank(String bankName){
        this.bankName = bankName;
    }

    void createCustomer(String name, long id){
        customerCounter++;
        customers.add(new Customer(name, customerCounter, id));
    }

    public Boolean createAccount(String name, long id){
        Boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name) && String.valueOf(customers.get(i).getidNr()).contains(String.valueOf(id))){
                accounts.add(new BankAccount(customers.get(i)));
                exists = true;
            }
        }
        return exists;
    }

    public Boolean removeAccount(String name, long id, long accountNr){
        Boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name)  && String.valueOf(customers.get(i).getidNr()).contains(String.valueOf(id))){
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNr() == accountNr && !exists){
                        accounts.remove(j);
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }

    public Boolean deposit(String name,long id, long accountNr, double amount){
        Boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            String fetchedName = customers.get(i).getName() + ".";
            if (fetchedName.contains(name + ".")  && String.valueOf(customers.get(i).getidNr() + ".").contains(String.valueOf(id) + ".")){
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNr() == accountNr && customers.get(i).getCustomerNr() == accounts.get(j).holderCustomerNr){
                        accounts.get(j).deposit(amount);
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }
    public Boolean withdraw(String name,long id, long accountNr, double amount){
        Boolean exists = false;
        for (int i = 0; i < customers.size(); i++) {
            String fetchedName = customers.get(i).getName() + ".";
            if (fetchedName.contains(name + ".")  && String.valueOf(customers.get(i).getidNr() + ".").contains(String.valueOf(id) + ".")){
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNr() == accountNr && customers.get(i).getCustomerNr() == accounts.get(j).holderCustomerNr){
                        accounts.get(j).withdraw(amount);
                        exists = true;
                    }
                }
            }
        }
        return exists;
    }
    public void transfer(String name,long id, long accountNr1, long accountNr2, double amount){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name)  && String.valueOf(customers.get(i).getidNr()).contains(String.valueOf(id))){
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNr() == accountNr1 && customers.get(i).getCustomerNr() == accounts.get(j).holderCustomerNr){
                        accounts.get(j).withdraw(amount);
                    }
                    else if(accounts.get(j).getAccountNr() == accountNr2 && customers.get(i).getCustomerNr() == accounts.get(j).holderCustomerNr){
                        accounts.get(j).deposit(amount);
                    }
                }
            }
        }
    }

    public double getAmount(String name,long id, long accountNr){
        double sum = 0;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name)  && String.valueOf(customers.get(i).getidNr()).contains(String.valueOf(id))){
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNr() == accountNr  && String.valueOf(accounts.get(j).holderIdNr).contains(String.valueOf(id))){
                        sum = accounts.get(j).getAmount();
                    }
                }
            }
        }
        return sum;
    }

    public ArrayList<String> toString(String name, long id){
        Boolean exists = false;
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(name) && String.valueOf(customers.get(i).getidNr()).contains(String.valueOf(id))){
                for (int j = 0; j < accounts.size(); j++) {
                    if (customers.get(i).getidNr() == accounts.get(j).getidNr() && accounts.get(j).holderName.contains(name)){
                        // temp = accounts.get(j).toString();
                        al.add(accounts.get(j).toString());
                        exists = true;
                    }
                }
            }
        }
        return al;
    }
    
    public String[] getAllAccounts() {
        String temp;
        boolean swapped = true;
        String[] accs = new String[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            accs[i] = "konto " + accounts.get(i).getAccountNr() + " (" + accounts.get(i).getName() + ", id " + accounts.get(i).getidNr() + ", kundnr " + accounts.get(i).getCustomerNr() + "): " + accounts.get(i).getAmount() + " kr";
        }
        
        for (int i = 0; i < accs.length - 1 && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < accs.length - i - 1; ++j) {
                String str1 = accs[j].split("\\(")[1];
                String str2 = accs[j+1].split("\\(")[1];
                if (str1.compareToIgnoreCase(str2) > 0) {
                    temp = accs[j];
                    accs[j] = accs[j+1];
                    accs[j+1] = temp;
                    swapped = true;
                }
            }
        }
        return accs;
    }

    public ArrayList<String> searchNames(String input){
        Boolean exists = false;
        ArrayList<String> al = new ArrayList<>(customers.size());
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().contains(input)){
                al.add(customers.get(i).getName() + ", id: " + customers.get(i).getidNr() + ", kundnummer: " + customers.get(i).getCustomerNr());
                exists = true;
            }
        }
        if (!exists){
            al.add("Inga resultat :(");
        }
        return al;
    }
}
