import java.util.*;

/**
 * Created by jyothi on 15/6/17.
 */
public class WorkAllocetor {

    private Map<Integer, ArrayList<String>> prioritisedSkills = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder()); //Map<P, List<S>> Sorted By Key
    private Set<Integer> priorities; //Set<P>
    private HashMap<String, String> skillsOfWorkers;
    private ArrayList<String> workers;
    private int pendingWorks = 0;
    private boolean stopAllocation = false; //flag to stop allocation

    WorkAllocater(Set<Integer> priorities, HashMap<String, String> skillsOfWorkers){ //initialise allocator with set of priorities
        this.priorities = priorities; //sorted in descending order for priorities
        this.skillsOfWorkers = skillsOfWorkers;
        this.workers = new ArrayList<String>(skillsOfWorkers.keySet());
    }

    void readFromStream(ArrayList<Work> workStream){ //generally accepts stream of work
        ArrayList<String> tempSkillsList;
        for(Work work: workStream){
            tempSkillsList = prioritisedSkills.getOrDefault(work.priority, new ArrayList<String>());
            tempSkillsList.add(work.skill);
            prioritisedSkills.put(work.priority, tempSkillsList);
            pendingWorks++; //increases the pending works
        }
    }

    void updateStream() { //hope so this function accepts stream
        ArrayList<Work> streamOfWorks = new ArrayList<Work>(); //from stream Eg: Kafka
        readFromStream(streamOfWorks);
    }

    void startAllocatingWork(){
        while (true){ //works on infinite stream until stream stops
            if(stopAllocation){
                break;
            }
            if(pendingWorks > 0) { //allocates only if there is work to do in stream
                for (String worker : workers) {
                    for (Integer priority : prioritisedSkills.keySet()) {
                        if (prioritisedSkills.get(priority).contains(skillsOfWorkers.get(worker))) {
                            prioritisedSkills.get(priority).remove(skillsOfWorkers.get(worker)); //allocated a work
                            if(prioritisedSkills.get(priority).size() == 0){
                                prioritisedSkills.remove(priority); //removing priority if no skills present
                            }
                            pendingWorks--; //decreasing pending works
                        }
                    }
                }
            }
            updateStream(); //checks for new works in stream
        }
    }

    class Work {
        String skill;
        int priority;
        public Work(String skill, int priority) {
            this.priority = priority;
            this.skill = skill;
        }
    }

}
