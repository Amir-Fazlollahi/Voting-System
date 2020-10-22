import ir.huri.jcal.JalaliCalendar;

import java.util.*;

/**
 * Documenting additional methods only
 */
public class Voting {
    private int type;
    private HashMap<String, HashSet<Vote>> polls;
    private String question;
    private ArrayList<Person> voters;

    /**
     * Creates an object of the class and instantiating the variables
     * @param type The type of the voting
     * @param question The question for the voting
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        polls = new HashMap<>();
        voters = new ArrayList<>();
    }
    public String getQuestion() {
        return question;
    }
    public void createPoll(String poll) {
        polls.put(polls.size() + 1 + ". " + poll, new HashSet<>());
    }
    public void vote(Person person, ArrayList<String> votedPolls) {
        int maxSize = votedPolls.size(); // The size of the votedPolls
        voters.add(person);
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < maxSize; ++i) {
            for (Map.Entry<String, HashSet<Vote>> poll:
                    polls.entrySet()) {
if(poll.getKey().contains(votedPolls.get(i))) {
                    poll.getValue().add(new Vote(person, new JalaliCalendar(new GregorianCalendar()).toString()));
                }
            }
        }
    }
    public ArrayList<Person> getVoters() {
        return voters;
    }
    public void printVotes() {
        System.out.println(question);
        for (Map.Entry<String, HashSet<Vote>> entry:
             polls.entrySet()) {
            System.out.println(entry.getKey() + "--- " + entry.getValue().size());
        }
    }
    public HashMap<String, HashSet<Vote>> getPolls() {
        return polls;
    }

    /**
     * returns the voting model, 0 for single-choice and 1 for multiple-choice
     * @return int type
     */
    public int getType() {
        return type;
    }
}
