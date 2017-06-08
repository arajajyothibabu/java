import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String[] output = null;
        int ip1_size = 0;
        ip1_size = Integer.parseInt(in.nextLine().trim());
        String[] ip1 = new String[ip1_size];
        String ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            try {
                ip1_item = in.nextLine();
            } catch (Exception e) {
                ip1_item = null;
            }
            ip1[ip1_i] = ip1_item;
        }
        int ip2_size = 0;
        ip2_size = Integer.parseInt(in.nextLine().trim());
        String[] ip2 = new String[ip2_size];
        String ip2_item;
        for(int ip2_i = 0; ip2_i < ip2_size; ip2_i++) {
            try {
                ip2_item = in.nextLine();
            } catch (Exception e) {
                ip2_item = null;
            }
            ip2[ip2_i] = ip2_item;
        }
        output = warehouseScalability(ip1,ip2);
        for(int output_i=0; output_i < output.length; output_i++) {
            System.out.println(String.valueOf(output[output_i]));
        }
    }

    public static String[] warehouseScalability(String[] input1,String[] input2) {

        final String DELIMITER = "#";

        HashMap<String, String> empSkills = new HashMap<String, String>();
        HashMap<String, ArrayList<String>> skillToEmploys = new HashMap<String, ArrayList<String>>();
        String[] employAndSkills;
        ArrayList<String> tempEmploys;
        for(int i = 0; i < input1.length; i++){
            employAndSkills = input1[i].split(DELIMITER);
            empSkills.put(employAndSkills[0], employAndSkills[1]);
            tempEmploys = skillToEmploys.getOrDefault(employAndSkills[1], new ArrayList<String>());
            tempEmploys.add(employAndSkills[0]);
            skillToEmploys.put(employAndSkills[1], tempEmploys);
        }

        String[] skillsAndWork;
        ArrayList<Work> skillsWithWorks = new ArrayList<Work>();
        for(int i = 0; i < input2.length; i++){
            skillsAndWork = input2[i].split(DELIMITER);
            skillsWithWorks.add(new Work(skillsAndWork[0], Integer.parseInt(skillsAndWork[1]), Integer.parseInt(skillsAndWork[2]), skillsAndWork[3]));
        }

        Collections.sort(skillsWithWorks, new Comparator<Work>() {
            @Override
            public int compare(Work a, Work b) {
                if(a.skill.equals(b.skill) && a.priority == b.priority) return Integer.compare(a.time, b.time);
                return -Integer.compare(a.priority, b.priority);
            }
        });

        HashMap<String, String> empWorks = new HashMap<String, String>();
        HashMap<String, Integer> empWorkTimes = new HashMap<String, Integer>();

        ArrayList<String> employs = new ArrayList<String>(empSkills.keySet());
        Work currentWork;
        ArrayList<String> employsWithCurrentSkill;
        Integer currentEmployTaskTime;
        Boolean isWorkUnfit;
        while(skillsWithWorks.size() > 0){
            for(String currentEmploy: employs){
                isWorkUnfit = false;
                for(int i = 0; i < skillsWithWorks.size(); i++){
                    currentWork = skillsWithWorks.get(i);
                    employsWithCurrentSkill = skillToEmploys.getOrDefault(currentWork.skill, new ArrayList<String>());
                    currentEmployTaskTime = empWorkTimes.getOrDefault(currentEmploy, 0);
                    for(String employ: employsWithCurrentSkill){
                        if(currentEmployTaskTime > empWorkTimes.getOrDefault(employ, 0)){
                            isWorkUnfit = true;
                            break;
                        }
                    }
                    if(isWorkUnfit){
                        break;
                    }
                    if(empSkills.get(currentEmploy).equals(currentWork.skill)){
                        empWorkTimes.put(currentEmploy, currentEmployTaskTime + currentWork.time);
                        empWorks.put(currentEmploy, empWorks.getOrDefault(currentEmploy, "") + DELIMITER + currentWork.id);
                        skillsWithWorks.remove(i);
                        break;
                    }
                }   
            }
        }

        String[] empWithWorkList = new String[input1.length];
        int indexOfEmploys = 0;
        for (Map.Entry<String, String> entry : empWorks.entrySet()) {
            empWithWorkList[indexOfEmploys++] = entry.getKey() + entry.getValue();
        }
        return empWithWorkList;
    }

    static class Work {
        int priority, time;
        String id, skill;

        public Work(String skill, int priority, int time, String id) {
            this.skill = skill;
            this.priority = priority;
            this.time = time;
            this.id = id;
        }

    }

}
