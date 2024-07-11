import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Main {
    public static void main(String args[]) {
        Database DB = new Database();
        CategoryProbability GenreProbability_reflection = new CategoryProbability("reflection");
        CategoryProbability GenreProbability_nutrition = new CategoryProbability("nutrition");
        CategoryProbability GenreProbability_cleaning = new CategoryProbability("cleaning");
        CategoryProbability GenreProbability_nature = new CategoryProbability("nature");
        CategoryProbability GenreProbability_fitness = new CategoryProbability("fitness");
        CategoryProbability GenreProbability_social = new CategoryProbability("social");
        CategoryProbability GenreProbability_talking = new CategoryProbability("talking");
        CategoryProbability GenreProbability_mindfulness = new CategoryProbability("mindfulness");
        CategoryProbability GenreProbability_thankfulness = new CategoryProbability("thankfulness");

        ArrayList<Double> allProbs = new ArrayList<>();
        allProbs.add(GenreProbability_reflection.calculateProbability(GenreProbability_reflection, false,"Good"));
        allProbs.add(GenreProbability_nutrition.calculateProbability(GenreProbability_nutrition, false,"Good"));
        allProbs.add(GenreProbability_cleaning.calculateProbability(GenreProbability_cleaning, false,"Good"));
        allProbs.add(GenreProbability_nature.calculateProbability(GenreProbability_nature, false,"Good"));
        allProbs.add(GenreProbability_fitness.calculateProbability(GenreProbability_fitness, false,"Good"));
        allProbs.add(GenreProbability_social.calculateProbability(GenreProbability_social, false,"Good"));
        allProbs.add(GenreProbability_talking.calculateProbability(GenreProbability_talking, false,"Good"));
        allProbs.add(GenreProbability_mindfulness.calculateProbability(GenreProbability_mindfulness, false,"Good"));
        allProbs.add(GenreProbability_thankfulness.calculateProbability(GenreProbability_thankfulness, false,"Good"));
        Double totalProb = 0.0;
        for (Double prob : allProbs) {
            totalProb += prob;
        }
        ArrayList<String> chosenCategories = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            double p = Math.random();
            double cumulative = 0.0;
            int counter = 0;
            for (Double prob : allProbs) {
                prob = prob / totalProb;
                cumulative += prob;
                counter += 1;
                if (p <= cumulative) {
                    break;
                }
            }
            switch (counter) {
                case 1:
                    chosenCategories.add("reflection");
                    GenreProbability_reflection.setPickAmountCounter(GenreProbability_reflection.getPickAmountCounter()+1);
                    break;
                case 2:
                    chosenCategories.add("nutrition");
                    GenreProbability_nutrition.setPickAmountCounter(GenreProbability_nutrition.getPickAmountCounter()+1);
                    break;
                case 3:
                    chosenCategories.add("cleaning");

                    GenreProbability_cleaning.setPickAmountCounter(GenreProbability_cleaning.getPickAmountCounter()+1);
                    break;
                case 4:
                    chosenCategories.add("nature");
                    GenreProbability_nature.setPickAmountCounter(GenreProbability_nature.getPickAmountCounter()+1);
                    break;
                case 5:
                    chosenCategories.add("fitness");
                    GenreProbability_fitness.setPickAmountCounter(GenreProbability_fitness.getPickAmountCounter()+1);
                    break;
                case 6:
                    chosenCategories.add("social");
                    GenreProbability_social.setPickAmountCounter(GenreProbability_social.getPickAmountCounter()+1);
                    break;
                case 7:
                    chosenCategories.add("talking");
                    GenreProbability_talking.setPickAmountCounter(GenreProbability_talking.getPickAmountCounter()+1);
                    break;
                case 8:
                    chosenCategories.add("mindfulness");
                    GenreProbability_mindfulness.setPickAmountCounter(GenreProbability_mindfulness.getPickAmountCounter()+1);
                    break;
                case 9:
                    chosenCategories.add("thankfulness");
                    GenreProbability_thankfulness.setPickAmountCounter(GenreProbability_thankfulness.getPickAmountCounter()+1);
                    break;
                default:
                    System.out.println("WTF!"+ counter);
            }
        }
        System.out.println(chosenCategories);
        ArrayList<TaskModel> dataList = DB.dummyData();
        ArrayList<TaskModel> finalChosenTasks = new ArrayList<>();
        ArrayList<TaskModel> relevantTaskModels = new ArrayList<>();
        Random rand = new Random();
        for(String category : chosenCategories){
            for(TaskModel taskModel : dataList){
                if(category.equals(taskModel.getCategory())){
                    relevantTaskModels.add(taskModel);
                }
            }
        }
        System.out.println(relevantTaskModels.size());
        for( int i = 0; i < relevantTaskModels.size(); i++){
            int index = rand.nextInt(relevantTaskModels.size());
            TaskModel chosenTask = relevantTaskModels.get(index);
            if(!finalChosenTasks.contains(chosenTask)){
                finalChosenTasks.add(chosenTask);
            } else {
                while(finalChosenTasks.contains(chosenTask)){
                    index = rand.nextInt(relevantTaskModels.size());
                    chosenTask = relevantTaskModels.get(index);
                }
                chosenTask = relevantTaskModels.get(index);
                finalChosenTasks.add(chosenTask);
            }

        }

        System.out.println(finalChosenTasks);
    }
}


