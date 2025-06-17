import java.util.Scanner;

// Node class for LinkedList
class Node {
    double data;
    Node next;

    Node(double data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List class for storing numbers
class LinkedList {
    Node head;

    // Add a number to the end of the list
    public void add(double data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Display all numbers in the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.print("Numbers in list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Calculate sum of numbers in the list
    public double sum() {
        double sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    // Calculate product of numbers in the list
    public double product() {
        if (head == null) return 0;
        double product = 1;
        Node current = head;
        while (current != null) {
            product *= current.data;
            current = current.next;
        }
        return product;
    }

    // Clear the linked list
    public void clear() {
        head = null;
    }
}

public class LinkedListCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice;

        do {
            System.out.println("\n--- Linked List Calculator Menu ---");
            System.out.println("1. Add number");
            System.out.println("2. Display numbers");
            System.out.println("3. Calculate sum");
            System.out.println("4. Calculate product");
            System.out.println("5. Clear list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to add: ");
                    double num = scanner.nextDouble();
                    list.add(num);
                    System.out.println(num + " added to the list.");
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.println("Sum of numbers: " + list.sum());
                    break;

                case 4:
                    System.out.println("Product of numbers: " + list.product());
                    break;

                case 5:
                    list.clear();
                    System.out.println("List cleared.");
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
