import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
        public static final int NUMBERS = 6;
        public static final int MAX_number = 36;
        public static final int PRIZE = 1000;
        public static final int EPRIZE = 100000;

    public static void main(String[] args) {
        Set<Integer> winning = createWinningNumbers();
        Set<Integer> ticket = getTicket();
        Set<Integer> eTicket = getETicket();
        Set<Integer> eWinning = createEkstraNumber();
        System.out.println();

        Set<Integer> matches = new TreeSet<>(ticket);
        matches.retainAll(winning);

        System.out.println("Your ticket was: " + ticket);
        System.out.println("Winning numbers: " + winning);
        if (matches.size() > 0){
            double prize = PRIZE * Math.pow(2, matches.size());
            System.out.println("Matched numbers: " + matches);
            System.out.printf("Your prize is $%.2f\n", prize);
        }
        System.out.println("Your ekstra number was " + eTicket);
        System.out.println("Winning ekstra number: " + eWinning);
        if (eTicket == eWinning){
            double ePrize = EPRIZE * Math.pow(2, 1);
            System.out.println("Machted ekstra number: " + eWinning);
            System.out.printf("Your new prize is $%.2f\n", ePrize);
        }

    }

    public static Set<Integer> createWinningNumbers(){
        Set<Integer> winning = new TreeSet<>();
        Random r = new Random();
        while (winning.size() < NUMBERS){
            int number = r.nextInt(MAX_number) + 1;
            winning.add(number);
        }
        return winning;
    }
    public static Set<Integer> getTicket(){
        Set<Integer> ticket = new TreeSet<>();
        Scanner console = new Scanner(System.in);
        System.out.print("type " + NUMBERS + " Lotto numbers: ");
        while (ticket.size() < NUMBERS){
            int number = console.nextInt();
            ticket.add(number);
        }
        return ticket;
    }

    public static Set<Integer> createEkstraNumber(){
        Set<Integer> eWinning = new TreeSet<>();
        Random r = new Random();
        int eNumber = r.nextInt(MAX_number);
        eWinning.add(eNumber);
        return eWinning;
    }

    public static Set<Integer> getETicket(){
        Set<Integer> eTicket = new TreeSet<>();
        Scanner console = new Scanner(System.in);
        System.out.print("type 1 ekstra number: ");
        int eNumber = console.nextInt();
        eTicket.add(eNumber);
        return eTicket;
    }
}
