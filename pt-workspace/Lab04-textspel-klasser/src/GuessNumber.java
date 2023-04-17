import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    public static void main(String[] args) {
        Prompts p = new Prompts();
        Scanner sc = new Scanner(System.in);

        System.out.println("Skriv in hur stort spannet du vill gissa i är. Dvs. svårighetsgraden:");

        int range = sc.nextInt();
        int randomNum = ThreadLocalRandom.current().nextInt(0, range + 1);
        int diff;

        System.out.println("Gissa nu talet");

        int guessedNum = sc.nextInt();

        while (guessedNum != randomNum) {
            diff = guessedNum - randomNum;      //Räknar ut hur stor differansen är mellan talen

            if (diff > 5) {
                System.out.println(p.farPos);
                guessedNum = sc.nextInt();
            } else if (diff < -5) {
                System.out.println(p.farNeg);
                guessedNum = sc.nextInt();
            } else if (diff != randomNum && diff > 0) {
                System.out.println(p.closePos);
                guessedNum = sc.nextInt();
            } else if (diff != randomNum && diff < 0) {
                System.out.println(p.closeNeg);
                guessedNum = sc.nextInt();
            }
        }
        System.out.println(p.right);

    }
}
