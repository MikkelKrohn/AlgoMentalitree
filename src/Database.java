import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    public List<Map<String, String>> allWorkbookTasks(){
        Map<String, String> t_1001 = new HashMap<String, String>();
        t_1001.put("additionalText", "Ex. I am a good listener");
        t_1001.put("category", "reflection");
        t_1001.put("shortDescription", "What is a positive affirmation, that reminds you of your worth and your strength?");
        t_1001.put("taskId", "1001");
        t_1001.put("taskName", "Affirmations about yourself");
        Map<String, String>t_1101 = new HashMap<String, String>();
        t_1101.put("additionalText", "Feel free to write down what you enjoyed for your healthy meal.");
        t_1101.put("category", "nutrition");
        t_1101.put("shortDescription", "Try to incorporate at least 1 healthy meal today");
        t_1101.put("taskId", "1101");
        t_1101.put("taskName", "Eat a healthy meal");
        Map<String, String>t_1201 = new HashMap<String, String>();
        t_1201.put("additionalText", "Go for a walk, short or long, just get those legs moving");
        t_1201.put("category", "nature");
        t_1201.put("shortDescription", "Go for a walk, short or long, just get those legs moving");
        t_1201.put("taskId", "1201");
        t_1201.put("taskName", "Go for a walk");
        Map<String, String>t_1301 = new HashMap<String, String>();
        t_1301.put("additionalText", "Ex. I removed all cups from my room");
        t_1301.put("category", "cleaning");
        t_1301.put("shortDescription", "Pick one thing in your home that you can tidy up a bit");
        t_1301.put("taskId", "1301");
        t_1301.put("taskName", "Tidying up");
        List<Map<String, String>> listOfTasks = new ArrayList<>();
        listOfTasks.add(t_1001);
        listOfTasks.add(t_1101);
        listOfTasks.add(t_1201);
        listOfTasks.add(t_1301);
        return listOfTasks;
    }
    public ArrayList<TaskModel> dummyData(){
        ArrayList<TaskModel> workbookTasks = new ArrayList<>();
        workbookTasks.add(new TaskModel("Affirmations about yourself", "What is a positive affirmation, that reminds you of your worth and your strength? ", "reflection", "helpTextReflection", "1101"));
        workbookTasks.add(new TaskModel("Eat a healthy meal", "Try to incorporate at least 1 healthy meal today", "nutrition", "helpTextNutrition", "1201"));
        workbookTasks.add(new TaskModel("Go for a walk outside", "Enjoy some fresh air with a trip outside", "nature", "helpTextNature", "1301"));
        workbookTasks.add(new TaskModel("Give your kitchen a clean ", "Make it really nice in your kitchen with clean counters", "cleaning", "helpTextcleaning", "1401"));
        workbookTasks.add(new TaskModel("Reach out to a friend or loved one ", "Message or call a friend or family member and have a chat", "fitness", "helpTextfitness", "1501"));
        return workbookTasks;
    }
}
