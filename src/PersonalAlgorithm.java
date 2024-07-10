import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PersonalAlgorithm {
    String category;
    Double baseProbability;
    int pickAmountCounter;
    Double pickrateAmountEligibleModifier;
    Double pickedYeasterdayModifier;


    public PersonalAlgorithm(String category,Double baseprobability,int pickAmountCounter,Double pickrateAmountEligible, Double pickedYeasterdayModifier){
        this.category = category;
        this.baseProbability = 0.5;
        this.pickAmountCounter = 0;
        this.pickrateAmountEligibleModifier = 0.01;
        this.pickedYeasterdayModifier = -0.2;
    }
    public PersonalAlgorithm(String category){
        this.category = category;
        this.baseProbability = 0.5;
        this.pickAmountCounter = 0;
        this.pickrateAmountEligibleModifier = 0.02;
        this.pickedYeasterdayModifier = -0.2;
    }

    public Double calculateProbability(PersonalAlgorithm algo, LocalDate lastPicked){
        LocalDate today = LocalDate.now();
        Double finalProbability = 0.0;

        finalProbability = finalProbability + algo.baseProbability;
        if (lastPicked.plusDays(1).equals(today)){
            finalProbability = finalProbability + pickedYeasterdayModifier;
        }
        if(algo.pickAmountCounter < 30){
            finalProbability = finalProbability + algo.pickrateAmountEligibleModifier;
        }
         else if (algo.pickAmountCounter >= 30 && algo.pickAmountCounter < 60) {
            finalProbability = finalProbability + 0.6;
        } else {
            algo.setPickAmountCounter(0);
        }


        return finalProbability;
    }
    public String getCategory() {return category;}
    public Double getBaseProbability() {return baseProbability;}
    public int getPickAmountCounter() {return pickAmountCounter;}
    public Double getPickrateAmountEligibleModifier() {return pickrateAmountEligibleModifier;}

    public void setCategory(String category) {this.category = category;}
    public void setBaseProbability(Double Baseprobability) {this.baseProbability = Baseprobability;}
    public void setPickAmountCounter(int PickAmountCounter) {this.pickAmountCounter = PickAmountCounter;}
    public void setPickrateAmountEligibleModifier(Double pickrateAmountEligibleModifier) {this.pickrateAmountEligibleModifier = pickrateAmountEligibleModifier;}
}
