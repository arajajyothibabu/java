import java.util.*;
import java.util.stream.Stream;

/**
 * Created by jyothi on 15/6/17.
 */
public class WorkAllocator {

    private Map<Integer, ArrayList<String>> prioritisedSkills = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder()); //Map<P, List<S>> Sorted By Key
    private Set<Integer> priorities; //Set<P>
    private HashMap<String, String> skillsOfWorkers;
    private ArrayList<String> workers;
    private int pendingWorks = 0;
    private boolean stopAllocation = false; //flag to stop allocation

    /**
     * Initializes with set of priorities and skills of all available workers
     *
     * @param priorities
     * @param skillsOfWorkers
     * We can also provide API for taking new workers into allocator, not in scope of this problem
     */
    WorkAllocator(Set<Integer> priorities, HashMap<String, String> skillsOfWorkers){ //initialise allocator with set of priorities
        this.priorities = priorities; //sorted in descending order for priorities
        this.skillsOfWorkers = skillsOfWorkers;
        this.workers = new ArrayList<String>(skillsOfWorkers.keySet());
    }

    /**
     * Generally updates the new stream of work into local buffer {prioritisedSkills} and serves the allocator
     * Typically works as a Consumer for Stream Producer
     * @param workStream
     */
    void readFromStream(Stream<Work> workStream){ //generally accepts stream of work
        workStream.forEach(work -> {
            ArrayList<String> tempSkillsList = prioritisedSkills.getOrDefault(work.priority, new ArrayList<String>());
            tempSkillsList.add(work.skill);
            prioritisedSkills.put(work.priority, tempSkillsList);
            pendingWorks++; //increases the pending works
        });
    }

    /**
     * A method that starts the streaming process by connecting Producer with Consumer
     */
    void startStream() { //can have any params or Configuration for Streaming Producer
        List<Work> works = Arrays.asList(new Work("s1", 10)); // stream from example "Kafka Producer"
        readFromStream(works.stream()); //eg: Kafka Consumer
    }

    /**
     * Key method that runs until we have stream of works
     */
    void startAllocatingWork(){
        while (true){ //works on infinite stream until stream stops
            if(stopAllocation){ //explicit flag to stop work allocation
                break;
            }
            if(pendingWorks > 0) { //allocates only if there is work to do in stream
                for (String worker : workers) {
                    for (Integer priority : prioritisedSkills.keySet()) {
                        if (prioritisedSkills.get(priority).contains(skillsOfWorkers.get(worker))) {
                            prioritisedSkills.get(priority).remove(skillsOfWorkers.get(worker)); //allocated with work
                            if(prioritisedSkills.get(priority).size() == 0){
                                prioritisedSkills.remove(priority); //removing priority if no skills present
                            }
                            pendingWorks--; //decreasing pending works
                            break; //breaking after allocating a work to one worker, since stream may get updates in the mean while
                        }
                    }
                }
            }
        }
    }

    class Work {
        String skill;
        int priority;

        /**
         * Work Model
         * @param skill
         * @param priority
         */
        public Work(String skill, int priority) {
            this.priority = priority;
            this.skill = skill;
        }
    }

}
