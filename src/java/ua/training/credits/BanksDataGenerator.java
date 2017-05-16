package ua.training.credits;

import ua.training.credits.model.Bank;
import ua.training.credits.model.credit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Created by andrew on 08.05.17.
 */
public class BanksDataGenerator implements  GlobalStringConst{

    public ArrayList<Bank> buildModel(){
        ArrayList<Bank> banks = new ArrayList<Bank>();
        Bank privat = new Bank(PRIVAT);
        Bank oshad = new Bank(OSHAD);
        Bank pumb = new Bank(PUMB);
        Bank praveks = new Bank(PRAVEKS);

        banks.add(praveks);
        banks.add(privat);
        banks.add(oshad);
        banks.add(pumb);

        for(Bank bank: banks){
            randomCreditsGeneration(bank);
        }
        return banks;
    }

    private void randomCreditsGeneration(Bank bank){
        int number = randomChoosing(1000);
        for(int i=0; i<number; i++){
            Target target = randomTargetGeneration();
            double amount = target.getMinAmount() + Math.random()*(target.getMaxAmount()-target.getMinAmount());
            amount = new BigDecimal(amount).setScale(2, RoundingMode.UP).doubleValue();
            int percent = randomizeProperty(target.getMinPercent(), target.getMaxPercent());
            int maturity = randomizeProperty(target.getMinMaturity(), target.getMaxMaturity());
            CreditBuilder creditBuilder = randomAbilitiesGeneration(bank);
            bank.addCredit(target,percent,maturity,amount,creditBuilder);
        }
    }

    private Target randomTargetGeneration(){
        int choose = randomChoosing(Target.values().length);
        return Target.values()[choose];
    }

    private CreditBuilder randomAbilitiesGeneration(Bank bank){
        int choose = randomChoosing(4);
        if(choose == 0){
            return new SimpleCreditBuilder();
        }else if(choose == 1){
            return new PrepaymentCreditBuilder();
        }else if(choose == 2){
            return new LineIncreaseCreditBuilder();
        }else{
            return new AllCapabilitiesCreditBuilder();
        }
    }

    private int randomizeProperty(int min, int max){
        return  (int) (min + Math.random()*(max-min));
    }

    private int randomChoosing(int number){
        return (int) Math.ceil(Math.random()*(number-1));
    }
}
