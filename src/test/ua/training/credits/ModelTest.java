package ua.training.credits;

import org.junit.Test;
import ua.training.credits.controller.chooser.SimpleCapabilities;
import ua.training.credits.model.Bank;
import ua.training.credits.model.Model;
import ua.training.credits.model.credit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ModelTest {

    private Bank bank;
    private Target target;
    private int maturity;
    private int percent;
    private double amount;
    private CreditDirector creditDirector;
    private CreditBuilder creditBuilder;
    private Model model;

    @Test (expected = RuntimeException.class)
    public void getBankCreditsByTargetCapabilitiesTest(){
        initialize();
        model = new Model();
        ArrayList<Credit> credits = model.getBankCreditsByTargetAndCapabillities(bank,target,new SimpleCapabilities());
        fail();
    }


    @Test
    public void getCreditsByTargetAndCapabilitiesTest(){
        initialize();
        for(int i=0; i<5; i++) {
            bank.addCredit(target, percent, maturity, amount, creditBuilder);
        }
        creditBuilder = new AllCapabilitiesCreditBuilder();
        bank.addCredit(target, percent, maturity, amount, creditBuilder);
        ArrayList<Credit> credits = bank.getCreditsForTargetAndCapabilities(target,new SimpleCapabilities());
        int testCounter = 0;
        int expectedNumber = 5;
        for(Credit credit: credits){
            if(credit.getTarget().equals(target)
                    && !credit.isLineIncreaseCapability()
                    && !credit.isPrepaymentCapability()){
                testCounter++;
            }
        }
        assertTrue(testCounter==expectedNumber);
    }

    private void initialize(){
        bank = new Bank("bank");
        target = Target.CAR;
        maturity = 1;
        percent = 2;
        amount = 10.0;
        creditBuilder = new SimpleCreditBuilder();
        creditDirector = new CreditDirector();
        creditDirector.setCreditBuilder(creditBuilder);
    }


}
