package ua.training.credits.controller.chooser;

import ua.training.credits.model.credit.Credit;

import java.util.ArrayList;

/**
 * Chooser of capabilities. Abstract class of Template method pattern.
 */
public abstract class Capabilities {
    /**
     * Search credits with selected capabilities
     * @param searchCreditsPool - ArrayList of credits, where we search credits
     * @return ArrayList of credits with selected capabilities
     */
    public ArrayList<Credit> getCredits(ArrayList<Credit> searchCreditsPool){
        ArrayList<Credit> abilityCredits = new ArrayList<Credit>();
        for(Credit credit: searchCreditsPool){
            if(isCorrectCapabilities(credit)){
                abilityCredits.add(credit);
            }
        }
        return abilityCredits;
    }

    /**
     * Method of choosing credits by capabilities
     * @param credit - input credit for selection
     * @return true, if credit are compatible with 
     */
    public abstract boolean isCorrectCapabilities(Credit credit);
}
