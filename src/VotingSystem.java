import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    public VotingSystem() {
        votingList = new ArrayList<>();
    }
    public void createVoting(String question, int type, ArrayList<String> polls) {
        Voting voting = new Voting(type, question);
        for (String poll:
             polls) {
            voting.createPoll(poll);
        }
        votingList.add(voting);
    }
    public void printListOfVoting() {
        int maxSize = votingList.size(); // The size of the voting list for later use
        for (int i = 0; i < maxSize; ++i) {
            System.out.println(i + 1 + ". " + votingList.get(i).getQuestion());
        }
    }
    public void printVoting(int votingNumber) {
        System.out.println(votingList.get(votingNumber).getQuestion() +
                " (Select " + (votingList.get(votingNumber).getType() == 0 ? "one" : "some") + " of below)" );
        for (Map.Entry<String, HashSet<Vote>> poll:
             votingList.get(votingNumber).getPolls().entrySet()) {
            System.out.println("    " + poll.getKey());
        }
    }
    public void vote(int votingNumber, Person person, ArrayList<String> votes) {
        if(votingList.size() == 0) {
            System.err.println("There is not any active voting for now");
            return;
        }
        for (Person voter:
             votingList.get(votingNumber).getVoters()) {
            if(voter.toString().equals(person.toString())) {
                System.err.println("Duplicate voting");
                return;
            }
        }
        if(votingList.get(votingNumber).getType() == 0 && votes.size() > 1) {
            System.err.println("Selecting multiple polls for a single-choice voting");
            return;
        }
        votingList.get(votingNumber).vote(person, votes);
    }
    public void printResult(int votingNumber) {
        votingList.get(votingNumber).printVotes();
    }
    public void deleteVoting(String question) {
        Iterator<Voting> iterator = votingList.iterator();
        //noinspection LoopStatementThatDoesntLoop
        while (iterator.hasNext()) {
            if(iterator.next().getQuestion().contains(question)) iterator.remove();
            System.out.println("Successfully deleted!");
            return;
        }
    }
}
