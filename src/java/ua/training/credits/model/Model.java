package ua.training.credits.model;

import ua.training.credits.BanksDataGenerator;
import ua.training.credits.LanguageManager;
import ua.training.credits.controller.chooser.*;
import ua.training.credits.model.credit.*;

import java.util.ArrayList;


public class Model {
    ArrayList <Bank> banks;

    public Model(){
        banks = new BanksDataGenerator().buildModel();
    }

    public String[] getBankNames(){
        String [] bankNames = new String[banks.size()];
        for(int i=0; i<bankNames.length; i++){
            bankNames[i] = banks.get(i).getName();
        }
        return bankNames;
    }

    public Bank getBankByName(String name){
        for (Bank bank: banks){
            if(LanguageManager.LANGUAGE.getString(bank.getName()).equals(name)){
                return bank;
            }
        }
        throw new RuntimeException("There is no such a bank with name: " + name);
    }



    public ArrayList<Credit> getBankCreditsByTargetAndCapabillities(Bank bank, Target target, Capabilities capabilities){
        if(banks.contains(bank)) {
            return bank.getCreditsForTargetAndCapabilities(target, capabilities);
        }else{
            throw new RuntimeException("There is no such bank in the model: "+ bank.getName());
        }
    }

}
