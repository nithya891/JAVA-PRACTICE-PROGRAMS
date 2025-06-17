import java.util.*;

public class HelpdeskManagementSystem {

    static class Ticket {
        static int count = 1;
        int id;
        String issue;
        String status;

        Ticket(String issue) {
            this.id = count++;
            this.issue = issue;
            this.status = "Open";
        }
    }

    static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void createTicket(String issue) {
        tickets.add(new Ticket(issue));
        System.out.println("Ticket created successfully.");
    }

    public static void resolveTicket(int id) {
        for (Ticket t : tickets) {
            if (t.id == id) {
                t.status = "Resolved";
                System.out.println("Ticket ID " + id + " resolved.");
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    public static void listTickets() {
        System.out.println("\n--- Ticket List ---");
        for (Ticket t : tickets) {
            System.out.println("ID: " + t.id + ", Issue: " + t.issue + ", Status: " + t.status);
        }
    }

    public static void main(String[] args) {
        createTicket("System not starting");
        createTicket("Printer not working");

        listTickets();
        resolveTicket(1);
        listTickets();
    }
}
