public class Customer {
    String name;
    long customerId;
    long customerNr;
    int accountCounter = 0;
    
    public Customer(String name, long customerNr, long customerId){
        this.name = name;
        this.customerNr = customerNr;
        this.customerId = customerId;
    }

    public String getName(){
        return name;
    }

    public long getidNr(){
        return customerId;
    }

    public long getCustomerNr(){
        return customerNr;
    }
}
