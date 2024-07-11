import java.time.LocalDate;

public class CategoryProbability {
    String category;
    int pickAmountCounter;
    Boolean pickedLastTime;



    public CategoryProbability(String category){
        this.category = category;
        this.pickAmountCounter = 0;
        this.pickedLastTime = false;
    }

    public Double calculateProbability(CategoryProbability algo, Boolean pickedLastTime, String pickrateAmountEligibleModifierString){
        Double finalProbability = 0.0;
        Double baseProbability = 0.5;
        Double pickedYesterdayModifier = -0.2;
        Double goodRatingModifier = 0.01;
        Double okayRatingModifier = 0.02;
        int habitStartInt = 30;
        int habitEndInt = 60;

        finalProbability = finalProbability + baseProbability;
        if (algo.pickedLastTime){
            finalProbability = finalProbability + pickedYesterdayModifier;
        }
        if(algo.pickAmountCounter < habitStartInt){
            if(pickrateAmountEligibleModifierString.equals("Okay") ){
                finalProbability = finalProbability + (okayRatingModifier *pickAmountCounter);
            } else if (pickrateAmountEligibleModifierString.equals("Good")) {
                finalProbability = finalProbability + (goodRatingModifier *pickAmountCounter);
            }
        }
         else if (algo.pickAmountCounter >= habitStartInt && algo.pickAmountCounter < habitEndInt) {
            if(pickrateAmountEligibleModifierString.equals("Okay")){
                finalProbability = finalProbability + (okayRatingModifier *habitStartInt);
            } else if (pickrateAmountEligibleModifierString.equals("Very good")) {
                finalProbability = finalProbability + (goodRatingModifier *habitStartInt);
            }
        } else {
            algo.setPickAmountCounter(0);
        }
        return finalProbability;
    }

    public String getCategory() {return category;}
    public int getPickAmountCounter() {return pickAmountCounter;}

    public void setCategory(String category) {this.category = category;}
    public void setPickAmountCounter(int PickAmountCounter) {this.pickAmountCounter = PickAmountCounter;}
}
