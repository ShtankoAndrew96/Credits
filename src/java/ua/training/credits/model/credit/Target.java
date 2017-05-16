package ua.training.credits.model.credit;

import ua.training.credits.GlobalStringConst;
import ua.training.credits.LanguageManager;

import java.math.BigDecimal;

public enum Target implements GlobalStringConst {
    CAR(GlobalStringConst.CAR, 5000.0, 40000.0, 3, 10, 5, 25),
    APARTMENTS(GlobalStringConst.APARTMENTS, 40000, 150000, 10, 20, 20, 35),
    BUSINESS(GlobalStringConst.BUSINESS, 10000, 30000, 3, 5, 10, 20),
    HOLIDAY(GlobalStringConst.HOLIDAY, 1000, 10000, 1, 2, 5, 15),
    CONSUMER(GlobalStringConst.CONSUMER, 500, 2000, 1, 3, 1, 15);


    private double minAmount;
    private double maxAmount;
    private int minMaturity;
    private int maxMaturity;
    private int minPercent;
    private int maxPercent;
    private String name;


    public double getMaxAmount() {
        return maxAmount;
    }

    public double getMinAmount() {
        return minAmount;
    }

    public int getMaxPercent() {
        return maxPercent;
    }

    public int getMinPercent() {
        return minPercent;
    }

    public int getMaxMaturity() {
        return maxMaturity;
    }

    public int getMinMaturity() {
        return minMaturity;
    }

    public String getName(){return name;}

    public static String[] getNames(){
        String [] targetNames = new String[values().length];
        for(int i=0; i<targetNames.length; i++){
            targetNames[i] = values()[i].getName();
        }
        return targetNames;
    }

    Target(String name, double minAmount, double maxAmount,
                  int minMaturity, int maxMaturity,
                  int minPercent, int maxPercent){
        this.minAmount=minAmount;
        this.maxAmount=maxAmount;
        this.minMaturity=minMaturity;
        this.maxMaturity=maxMaturity;
        this.minPercent=minPercent;
        this.maxPercent=maxPercent;
        this.name=name;
    }

    @Override
    public String toString(){
        return LanguageManager.LANGUAGE.getString(Target.this.getName());
    }
}
