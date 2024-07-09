import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
                    System.out.println("Reflection");
                    break;
                case 2:
                    System.out.println("Nutrition");
                    break;
                case 3:
                    System.out.println("Nature");
                    break;
                case 4:
                    System.out.println("Cleaning");
                    break;
                case 5:
                    System.out.println("Fitness");
                    break;
                case 6:
                    System.out.println("Social");
                    break;
                case 7:
                    System.out.println("Talking");
                    break;
                case 8:
                    System.out.println("Mindfulness");
                    break;
                case 9:
                    System.out.println("Thankfulness");
                    break;
                default:
                    System.out.println("WTF!"+ counter);

            }

        }
    }
}
class Algorithm{

}
class DataHandler{

}

