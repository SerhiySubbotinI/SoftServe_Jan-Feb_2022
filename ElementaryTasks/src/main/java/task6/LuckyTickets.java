package task6;

import java.io.IOException;
import java.util.Scanner;

public class LuckyTickets {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        WorkWithFile readtxt = new WorkWithFile();
        System.out.println("Please, enter path to file");
        String fileName = keyboard.nextLine();
        //C:\Users\Admin\IdeaProjects\ElementaryTasks\src\main\java\task6\TicketStore.txt
        //String fileName = "C:\\Users\\Admin\\IdeaProjects\\ElementaryTasks\\src\\main\\java\\task6\\TicketStore.txt";
        String txt = readtxt.readFromFile(fileName);
        TicketsFactory ticket = new TicketsFactory();
        int totalTickets;

        if (!ticket.readMeCheck(txt)) {
            System.out.println("File is empty");
            System.exit(0);
        }

        totalTickets = ticket.ticketQty(txt);
        int [] unckeked = ticket.uncheckedTicket(txt, totalTickets);

        Algorithm metodOfLuck = new Algorithm();

        int metod;
        do {
            String fileRules = "C:\\Users\\Admin\\IdeaProjects\\ElementaryTasks\\src\\main\\java\\task6\\Rules.txt";
            String txtRules = readtxt.readFromFile(fileRules);
            System.out.println(txtRules);
            System.out.print("Please, make your selection: ");
            metod = keyboard.nextInt();
            switch (metod) {
                case 1:
                    metodOfLuck.moskow(unckeked);
                    break;
                case 2:
                    metodOfLuck.piter(unckeked);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}

