package rekrytering;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        FileReader f = new FileReader();
        // Applicant a = new Applicant();
        Applicant[] gradesAndNames = f.readFromFile("C:/Users/david/Documents/LTH/Programmering - EDAA55/pt-workspace/Lab07-rekrytering/applications_small.txt", 7);
        // gradesAndNames.
        System.out.println(gradesAndNames[6]);
        Applicant a = new Applicant("David", "5,5,4,3,3");
        double t = a.getAvgGrade();
        double avg = gradesAndNames[0].getAvgGrade();

        System.out.println("Avarage: " + t);
        
    }
   }
