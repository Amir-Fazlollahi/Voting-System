import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Main class is for running the code. It indicates a list of options
 * on the terminal screen and propmts the user for reaction. (Documenting
 * additional methods only
 */
public class Main {
    /**
     * creates a vote inside the voting system
     * @param system The voting system
     * @param scanner The scanner built and used previously
     */
    public static void createVoting(VotingSystem system, Scanner scanner) {
        System.out.println("Enter the question:");
        String question = scanner.nextLine();
        System.out.println("Specify the type: 0:Single-choice, 1:Multiple-choice");
        int type = scanner.nextInt();
        System.out.println("How many poll are there?");
        int pollNum = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> polls = new ArrayList<>();
        for (int i = 0; i < pollNum; ++i) {
            if(i == 0) System.out.println("Enter the 1st poll:");
            else if(i == 1)System.out.println("Enter the 2nd poll:");
            else if(i == 2)System.out.println("Enter the 3rd poll:");
            else System.out.println("Enter the "+ (i + 1) +"th poll:");
            String poll = scanner.nextLine();
            polls.add(poll);
        }
        system.createVoting(question, type, polls);
    }

    /**
     * Deletes an active voting totally
     * @param system The voting system
     * @param scanner The scanner used previously
     */
    public static void deleteVoting(VotingSystem system, Scanner scanner) {
        System.out.println("Enter the voting title:");
        String question = scanner.nextLine();
        system.deleteVoting(question);
    }

    /**
     * votes in an active voting
     * @param system The voting system
     * @param scanner The scanner built and used previously
     */
    public static void vote(VotingSystem system, Scanner scanner) {
        Person person;
        String firstName;
        String lastName;
        System.out.println("Enter your first name:");
        firstName = scanner.next();
        System.out.println("Enter your last name:");
        lastName = scanner.next();
        person = new Person(firstName, lastName);
        System.out.println("Select a voting below:");
        system.printListOfVoting();
        int votingNumber = scanner.nextInt() - 1;
        scanner.nextLine();
        system.printVoting(votingNumber);
        ArrayList<String> votedPollsList = new ArrayList<>();
        String[] votedPollsArray = scanner.nextLine().split(" ");
        for (String str:
             votedPollsArray) {
            votedPollsList.add(str);
        }
        system.vote(votingNumber, person, votedPollsList);
        system.printResult(votingNumber);
        System.out.println("Press enter to finish...");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        Scanner scanner = new Scanner(System.in);
        String option = "";
        while (!option.equals("Exit")) {
            System.out.println("Type an option:");
            System.out.println("'Create' Voting");
            System.out.println("'Delete' Voting");
            System.out.println("'Vote'");
            System.out.println("'Exit'");
            option = scanner.nextLine();
            switch (option) {
                case "Create":
                    createVoting(system, scanner);
                    break;
                case "Delete":
                    deleteVoting(system, scanner);
                    break;
                case "Vote":
                    vote(system, scanner);
                    break;
            }
        }
    }
}
