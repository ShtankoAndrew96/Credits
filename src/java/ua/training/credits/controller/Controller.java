package ua.training.credits.controller;

import ua.training.credits.GlobalStringConst;
import ua.training.credits.LanguageManager;
import ua.training.credits.controller.chooser.*;
import ua.training.credits.model.Bank;
import ua.training.credits.model.Model;
import ua.training.credits.model.credit.Credit;
import ua.training.credits.model.credit.Target;
import ua.training.credits.view.View;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Main controller class. It have verify methods for client input.
 */
public class Controller implements GlobalStringConst {

    private Model model;
    private View view;


    private boolean prepayment;
    private boolean lineIncrease;

    private Scanner scanner;

    public Controller (Model model, View view){
        this.model=model;
        this.view=view;
        scanner = new Scanner(System.in);
    }

    private void languageChoose(int choose){
        if(choose == 0){
            LanguageManager.LANGUAGE.changeLanguage(new Locale("en","GB"));
        }
        if(choose == 1){
            LanguageManager.LANGUAGE.changeLanguage(new Locale("ru","RU"));
        }
        if(choose == 2){
            LanguageManager.LANGUAGE.changeLanguage(new Locale("uk", "UA"));
        }
    }

    /**
     * Main method of controller, that describe process of all program
     */
    public void processUser(){
        view.printLanguageQuestion();
        languageChoose(verifyLanguageChoose(readIntFromScanner()));
        view.printBankQuestion(model.getBankNames());
        Bank selectedBank = model.getBankByName(getBankNameFromScanner());

        view.printTargetQuestion();
        Target selectedTarget = getTargetByName(getTargetFromScanner());

        view.printPrepaymentQuestion();
        prepayment = isYes();
        view.printCreditLineIncreasingQuestion();
        lineIncrease = isYes();
        Capabilities selectedCapabilities = capabilitiesChoosing();

        ArrayList<Credit> selectedCredits = model.getBankCreditsByTargetAndCapabillities(selectedBank,selectedTarget,selectedCapabilities);
        for (Credit credit: selectedCredits){
            view.printMessage(credit.toString());
        }
    }

    /**
     * Selector of credit capabilities
     * @return object, that defines, which capabilities credit have
     */
    private Capabilities capabilitiesChoosing(){
        if(!prepayment && !lineIncrease){
            return new SimpleCapabilities();
        }else if(prepayment && !lineIncrease){
            return new PrepaymentCapabilities();
        }else if(!prepayment && lineIncrease){
            return new LineIncreaseCapabilities();
        }else{
            return new FullCapabilities();
        }
    }

    /**
     * Define client answer on the yes/no questions
     * @return true, if answer is 'yes', if 'no' - false
     */
    private boolean isYes(){
        String answer = scanner.next();
        while (!answer.equals(LanguageManager.LANGUAGE.getString(YES)) && !answer.equals(LanguageManager.LANGUAGE.getString(NO)) ){
            view.printErrorAnswer();
            answer = scanner.next();
        }
        if(answer.equals(LanguageManager.LANGUAGE.getString(YES))){
            return true;
        }else{
            return false;
        }
    }

    private Target getTargetByName(String name){
        for(Target target: Target.values()){
            if(LanguageManager.LANGUAGE.getString(target.getName()).equals(name)){
                return target;
            }
        }
        throw new RuntimeException("No such target with name" + name);
    }

    private String getTargetFromScanner(){
        String name = scanner.next();
        while(!verifyTarget(name)){
            view.printErrorTarget();
            name = scanner.next();
        }
        return name;
    }

    /**
     * Check, is client enter correct target name
     * @param target - client target name input
     * @return - true, if is all ok
     */
    private boolean verifyTarget(String target){
        String [] targetNames = Target.getNames();
        for(int i = 0; i < targetNames.length; i++){
            if(target.equals(LanguageManager.LANGUAGE.getString(targetNames[i]))){
                return true;
            }
        }
        return false;
    }

    private String getBankNameFromScanner(){
        String name = scanner.next();
        while(!verifyBankName(name)){
            view.printErrorBank();
            name = scanner.next();
        }
        return name;
    }

    /**
     * Check, is client enter name of bank, that available in model
     * @param name - client bank name input
     * @return - true, if is all ok
     */
    private boolean verifyBankName(String name){
        String [] bankNames = model.getBankNames();
        for(int i = 0; i < bankNames.length; i++){
            if(name.equals(LanguageManager.LANGUAGE.getString(bankNames[i]))){
                return true;
            }
        }
        return false;
    }

    private int readIntFromScanner(){
        while(!scanner.hasNextInt()){
            scanner.next();
        }
        return scanner.nextInt();
    }

    private int verifyLanguageChoose(int input){
        int result = input;
        while(!(result <= 2 && result >= 0)){
            view.printErrorLanguage();
            view.printLanguageQuestion();
            result = readIntFromScanner();
        }
        return result;
    }
}
