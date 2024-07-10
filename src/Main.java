import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Main {
    public static void main(String args[]) {
        Database DB = new Database();
        PersonalAlgorithm PA_reflection = new PersonalAlgorithm("reflection");
        PersonalAlgorithm PA_nutrition = new PersonalAlgorithm("nutrituion");
        PersonalAlgorithm PA_cleaning = new PersonalAlgorithm("cleaning");
        PersonalAlgorithm PA_nature = new PersonalAlgorithm("nature");
        PersonalAlgorithm PA_fitness = new PersonalAlgorithm("fitness");
        PersonalAlgorithm PA_social = new PersonalAlgorithm("social");
        PersonalAlgorithm PA_talking = new PersonalAlgorithm("talking");
        PersonalAlgorithm PA_mindfulness = new PersonalAlgorithm("mindfulness");
        PersonalAlgorithm PA_thankfulness = new PersonalAlgorithm("thankfulness");

        Double reflectionProp = PA_reflection.calculateProbability(PA_reflection, LocalDate.now().minusDays(1));
        Double nutritionProp = PA_nutrition.calculateProbability(PA_nutrition, LocalDate.now().minusDays(2));
        Double cleaningProp = PA_cleaning.calculateProbability(PA_cleaning, LocalDate.now().minusDays(1));
        Double natureProp = PA_nature.calculateProbability(PA_nature, LocalDate.now().minusDays(2));
        Double fitnessProp = PA_fitness.calculateProbability(PA_fitness, LocalDate.now().minusDays(1));
        Double socialProp = PA_social.calculateProbability(PA_social, LocalDate.now().minusDays(1));
        Double talkingProp = PA_talking.calculateProbability(PA_talking, LocalDate.now().minusDays(1));
        Double mindfulnessProp = PA_mindfulness.calculateProbability(PA_mindfulness, LocalDate.now().minusDays(1));
        Double thankfulness = PA_thankfulness.calculateProbability(PA_thankfulness, LocalDate.now().minusDays(1));

        ArrayList<Double> allProbs = new ArrayList<>();
        allProbs.add(reflectionProp);
        allProbs.add(nutritionProp);
        allProbs.add(cleaningProp);
        allProbs.add(natureProp);
        allProbs.add(fitnessProp);
        allProbs.add(socialProp);
        allProbs.add(talkingProp);
        allProbs.add(mindfulnessProp);
        allProbs.add(thankfulness);
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
                    PA_reflection.setPickAmountCounter(PA_reflection.getPickAmountCounter()+1);
                    PA_reflection.setPickrateAmountEligibleModifier(PA_reflection.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 2:
                    chosenCategories.add("nutrition");
                    PA_nutrition.setPickAmountCounter(PA_nutrition.getPickAmountCounter()+1);
                    PA_nutrition.setPickrateAmountEligibleModifier(PA_nutrition.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 3:
                    chosenCategories.add("cleaning");
                    PA_cleaning.setPickAmountCounter(PA_cleaning.getPickAmountCounter()+1);
                    PA_cleaning.setPickrateAmountEligibleModifier(PA_cleaning.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 4:
                    chosenCategories.add("nature");
                    PA_nature.setPickAmountCounter(PA_nature.getPickAmountCounter()+1);
                    PA_nature.setPickrateAmountEligibleModifier(PA_nature.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 5:
                    chosenCategories.add("fitness");
                    PA_fitness.setPickAmountCounter(PA_fitness.getPickAmountCounter()+1);
                    PA_fitness.setPickrateAmountEligibleModifier(PA_fitness.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 6:
                    chosenCategories.add("social");
                    PA_social.setPickAmountCounter(PA_social.getPickAmountCounter()+1);
                    PA_social.setPickrateAmountEligibleModifier(PA_social.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 7:
                    chosenCategories.add("talking");
                    PA_talking.setPickAmountCounter(PA_talking.getPickAmountCounter()+1);
                    PA_talking.setPickrateAmountEligibleModifier(PA_talking.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 8:
                    chosenCategories.add("mindfulness");
                    PA_mindfulness.setPickAmountCounter(PA_mindfulness.getPickAmountCounter()+1);
                    PA_mindfulness.setPickrateAmountEligibleModifier(PA_mindfulness.getPickrateAmountEligibleModifier()+0.02);
                    break;
                case 9:
                    chosenCategories.add("thankfulness");
                    PA_thankfulness.setPickAmountCounter(PA_thankfulness.getPickAmountCounter()+1);
                    PA_thankfulness.setPickrateAmountEligibleModifier(PA_thankfulness.getPickrateAmountEligibleModifier()+0.02);
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
            finalChosenTasks.add(chosenTask);
        }

        System.out.println(finalChosenTasks);
    }
}


