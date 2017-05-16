package ua.training.credits.view;

import ua.training.credits.GlobalStringConst;
import ua.training.credits.LanguageManager;
import ua.training.credits.model.credit.Target;

public class View implements GlobalStringConst {

    public void printLanguageQuestion(){
        printMessage(LANGUAGE_QUESTION);
        printMessage(LANGUAGES);
    }

    public void printErrorLanguage(){
        printMessage(ERROR_LANGUAGE);
    }

    public void printTargetQuestion(){
        printMessage(LanguageManager.LANGUAGE.getString(INPUT_TARGET));
        printMessage(concatArray(Target.getNames()));
    }

    public void printErrorTarget(){
        printMessage(LanguageManager.LANGUAGE.getString(ERROR_TARGET));
    }

    public void printPrepaymentQuestion(){
        printMessage(LanguageManager.LANGUAGE.getString(PREPAYMENT_QUESTION));
        printMessage(concatenation(LanguageManager.LANGUAGE.getString(YES,SLASH,NO)));
    }

    public void printCreditLineIncreasingQuestion(){
        printMessage(LanguageManager.LANGUAGE.getString(CREDIT_LINE_INCREASING_QUESTION));
        printMessage(concatenation(LanguageManager.LANGUAGE.getString(YES,SLASH,NO)));
    }

    public void printErrorAnswer(){
        printMessage(LanguageManager.LANGUAGE.getString(ERROR_ANSWER));
    }

    public void printBankQuestion(String[] banks){
        printMessage(LanguageManager.LANGUAGE.getString(INPUT_BANK));
        printMessage(concatArray(banks));
    }

    public void printErrorBank(){
        printMessage(LanguageManager.LANGUAGE.getString(ERROR_BANK));
    }

    public void printMessage(String message){
        System.out.println(message);
    }
    
    public String concatArray(String[] array){
        String result = LanguageManager.LANGUAGE.getString(LEFT_BRACKET);
        for(String s: array){
            result = concatenation(result,LanguageManager.LANGUAGE.getString(s,COMMA));
        }
        result=result.substring(0,result.length()-1);
        result = concatenation(result,LanguageManager.LANGUAGE.getString(RIGHT_BRACKET));
        return result;
    }

    public String concatenation(String... input){
        StringBuffer result = new StringBuffer();
        for(String s: input){
            result.append(s);
        }
        return new String(result);
    }
}
