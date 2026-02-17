import java.io.*;
import java.util.Scanner;

public class NotesApp {

    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    addNote(sc);
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Method to add note
    public static void addNote(Scanner sc) {

        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(note + "\n");
            fw.close();

            System.out.println("Note saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Method to view notes
    public static void viewNotes() {

        try {
            FileReader fr = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("\n--- Your Notes ---");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("No notes found yet.");
        }
    }
}
