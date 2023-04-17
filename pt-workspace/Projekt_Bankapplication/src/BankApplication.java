import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args){
        Bank b = new Bank("Handelsbanken");                 //Skapar banken
        b.createCustomer("David Eckemark", 11223344);      //Skapar medlemmar samt konton så det finns data när jag startar programmet
        b.createAccount("David Eckemark", 11223344);
        b.createAccount("David Eckemark", 11223344);
        b.deposit("David Eckemark", 11223344, 1001, 100);
        b.createCustomer("Lindrit Koxha", 99887766);
        b.createAccount("Lindrit Koxha", 99887766);
        
        System.out.print("\033[H\033[2J");                          //Rensar konsollen
        System.out.flush();

        Scanner s1 = new Scanner(System.in);
        
        while (true){
            System.out.println("1. Hitta konto utifrån innehavare \n2. Sök kontoinnehavare utifrån (del av) namn \n3. Sätt in \n4. Ta ut \n5. Överföring \n6. Skapa konto \n7. Ta bort konto \n8. Skriv ut konton \n9. Avsluta");
            System.out.print("Val: ");
            double nbr1 = s1.nextDouble();
            s1.nextLine();
            if (nbr1 == 1){                     //Val 1, hittar konton med hjälp av ett id
                Boolean exists = false;
                System.out.print("Id: ");
                long inpt = s1.nextLong();
                
                for (int i = 0; i < b.customers.size(); i++) {
                    if (b.customers.get(i).getidNr() == inpt){
                        ArrayList<String> output = b.toString(b.customers.get(i).getName() , inpt);
                        for (int j = 0; j < output.size(); j++) {
                            System.out.println(output.get(i));
                        }
                        exists = true;
                    }
                }
                if (!exists){
                    System.out.println("Det finns inget konto med id-nummret: " + inpt);
                }
            }
            else if (nbr1 == 2){                    //Letar efter användare som har den av namn
                System.out.print("Namn: ");
                String inpt = s1.nextLine();
                ArrayList<String> temp = b.searchNames(inpt);
                for (int i = 0; i < temp.size(); i++) {
                    System.out.println(temp.get(i));
                }
            }
            else if (nbr1 == 3){                //Sätt in pengar
                Boolean exists = false;
                System.out.print("Namn: ");
                String nameInpt = s1.nextLine();
                System.out.print("Id: ");
                long idInpt = s1.nextLong();
                ArrayList<String> output = b.toString(nameInpt, idInpt);
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j));
                }
                if (b.toString(nameInpt, idInpt).size()>0){
                    System.out.print("Välj konto: ");
                    long accInpt = s1.nextLong();
                    System.out.print("Summa: ");
                    long sumInpt = s1.nextLong();
                    for (int i = 0; i < b.customers.size(); i++) {
                        String fetchedName = b.customers.get(i).getName() + ".";        //För att hela strängen ska vara korrekt lägger jag till en punkt i slutet
                        if (fetchedName.contains(nameInpt + ".") && String.valueOf(b.customers.get(i).getidNr() + ".").contains(String.valueOf(idInpt) + ".")){
                            if (b.deposit(nameInpt, idInpt, accInpt, sumInpt)){
                            System.out.println("Du har satt in: " + sumInpt + " kr på konto " + accInpt);
                            ArrayList<String> output2 = b.toString(nameInpt, idInpt);
                            for (int j = 0; j < output2.size(); j++) {
                                System.out.println(output2.get(j));
                            }                            
                            exists = true;
                            }
                        }
                    }
                }
                if (!exists){           //Om den inte når koden som bekräftar att en insättning gjorts skrivs detta ut
                    System.out.println("Något blev fel, är du säker på att du skrev in rätt uppgifter?");
                }
            }
            else if (nbr1 == 4){        //Ta ut pengar
                Boolean exists = false;
                System.out.print("Namn: ");
                String nameInpt = s1.nextLine();
                System.out.print("Id: ");
                long idInpt = s1.nextLong();
                ArrayList<String> output = b.toString(nameInpt, idInpt);
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j));
                }
                if (output.size()>0){
                    System.out.print("Välj konto: ");
                    long accInpt = s1.nextLong();
                    System.out.print("Summa: ");
                    long sumInpt = s1.nextLong();
                    for (int i = 0; i < b.customers.size(); i++) {
                        String fetchedName = b.customers.get(i).getName() + ".";
                        if (fetchedName.contains(nameInpt + ".") && String.valueOf(b.customers.get(i).getidNr() + ".").contains(String.valueOf(idInpt) + ".")){
                            if (sumInpt-1 < b.getAmount(nameInpt, idInpt, accInpt)){
                                if (b.withdraw(nameInpt, idInpt, accInpt, sumInpt)){
                                    System.out.println("Du har tagit: " + sumInpt + " kr från konto " + accInpt);
                                    ArrayList<String> output2 = b.toString(nameInpt, idInpt);
                                    for (int j = 0; j < output2.size(); j++) {
                                        System.out.println(output2.get(j));
                                    }
                                    exists = true;
                                }
                            }
                            else{
                                System.out.println("Du saknar tillräckligt med pengar på konto " + accInpt + " :(");
                            }
                        }
                    }
                }
                if (!exists){
                    System.out.println("Något blev fel, är du säker på att du skrev in rätt uppgifter?");
                }
            }
            else if (nbr1 == 5){                //För över pengar mellan konton tillhörande samma person
                System.out.print("Namn: ");
                String nameInpt = s1.nextLine();
                System.out.print("Id: ");
                long idInpt = s1.nextLong();
                ArrayList<String> output = b.toString(nameInpt, idInpt);
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j));
                }
                System.out.print("Ta ut från konto: ");
                long accInpt1 = s1.nextLong();
                System.out.print("Sätt in på konto: ");
                long accInpt2 = s1.nextLong();
                System.out.print("Summa: ");
                long sumInpt = s1.nextLong();
                for (int i = 0; i < b.customers.size(); i++) {
                    if (b.customers.get(i).getName().contains(nameInpt) && String.valueOf(b.customers.get(i).getidNr()).contains(String.valueOf(idInpt))){
                        if (sumInpt-1 < b.getAmount(nameInpt, idInpt, accInpt1)){
                            b.transfer(nameInpt, idInpt, accInpt1, accInpt2, sumInpt);
                            System.out.println("Du har flyttat: " + sumInpt + " kr från konto " + accInpt1 + " till konto " + accInpt2);
                            ArrayList<String> output2 = b.toString(nameInpt, idInpt);
                            for (int j = 0; j < output2.size(); j++) {
                                System.out.println(output2.get(j));
                            }
                        }
                        else{
                            System.out.println("Du saknar tillräckligt med pengar på konto " + accInpt1 + " :(");
                        }
                    }
                }
            }
            else if (nbr1 == 6){                //Skapa konto
                System.out.print("Namn: ");
                String nameInpt = s1.nextLine();
                System.out.print("Id: ");
                long idInpt = s1.nextLong();
                Boolean exists = false;
                for (int i = 0; i < b.customers.size(); i++) {
                    if (b.customers.get(i).getName().contains(nameInpt) && String.valueOf(b.customers.get(i).getidNr()).contains(String.valueOf(idInpt))){
                        exists = true;
                    }
                }
                if (exists){
                    b.createAccount(nameInpt, idInpt);
                    System.out.println("Du är redan kund, skapr ytterliggare ett bankkonto för dig :)");
                }
                else {
                    b.createCustomer(nameInpt, idInpt);
                    b.createAccount(nameInpt, idInpt);
                    System.out.println("\nDu är ny kund, skapar ett meddlemskap och ett nytt konto åt dig :)");
                }
                
                ArrayList<String> output = b.toString(nameInpt, idInpt);
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j));
                }
                // b.toString(nameInpt, idInpt);
            }
            else if (nbr1 == 7){            //Ta bort konto
                System.out.print("Namn: ");
                String nameInpt = s1.nextLine();
                System.out.print("Id: ");
                long idInpt = s1.nextLong();
                ArrayList<String> output = b.toString(nameInpt, idInpt);
                for (int j = 0; j < output.size(); j++) {
                    System.out.println(output.get(j));
                }
                System.out.println("Vilket bankkonto vill du ta bort?");
                long accInpt = s1.nextLong();
                Boolean exsists = false;
                for (int i = 0; i < b.customers.size(); i++) {
                    if (b.customers.get(i).getName().contains(nameInpt) && String.valueOf(b.customers.get(i).getidNr()).contains(String.valueOf(idInpt))){
                        if (b.removeAccount(nameInpt, idInpt, accInpt)){
                            exsists = true;
                            System.out.println("Du tog bort konto " + accInpt + " från användrare " + nameInpt);
                        }
                    }
                }
                if(!exsists){
                    System.out.println("Något blev fel, är du säker på att du skrev in rätt uppgifter?");
                }

            }
            else if (nbr1 == 8){            //Skriver ut alla konton
                String[] temp = b.getAllAccounts();
                for (int i = 0; i < temp.length; i++) {
                    System.out.println(temp[i]);
                }
            }
            else if (nbr1 == 9){
                break;
            }
            else {
                System.out.println("Vänligen välj ett av de tillgängliga alternativen");
            }
            
            System.out.println("\nKlicka på valfri knapp och sedan efter för att gå till huvudmenyn :)");
            String temp1 = s1.next();
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            }
        }
    }
