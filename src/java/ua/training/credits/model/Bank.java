package ua.training.credits.model;

import ua.training.credits.controller.chooser.Capabilities;
import ua.training.credits.model.credit.*;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Credit> allCredits;



    public Bank(String name){
        this.name = name;
        allCredits = new ArrayList<Credit>();
    }

    public ArrayList<Credit> getAllCredits() {
        return allCredits;
    }

    public void addCredit(Target target, int percent, int maturity, double summ, CreditBuilder creditBuilder){
        CreditDirector creditDirector = new CreditDirector();
        creditDirector.setCreditBuilder(creditBuilder);
        allCredits.add(creditDirector.buildCredit(target, percent, maturity, summ));
    }


    public ArrayList<Credit> getCreditsForTargetAndCapabilities(Target target, Capabilities capabilityGetter){
        return capabilityGetter.getCredits(getCreditsForTarget(target));
    }

    private ArrayList<Credit> getCreditsForTarget(Target target){
        ArrayList<Credit> result = new ArrayList<Credit>();
        for(Credit credit: allCredits){
            if(credit.getTarget().equals(target)){
                result.add(credit);
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }
}

