package ua.training.credits.model.credit;

import ua.training.credits.GlobalStringConst;
import ua.training.credits.LanguageManager;
import ua.training.credits.model.Bank;

import java.math.BigDecimal;

public class Credit implements GlobalStringConst {

    private Target target;

    private int percent;
    private int maturity;

    private double amount;

    private boolean lineIncreaseCapability;
    private boolean prepaymentCapability;


    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setLineIncreaseCapability(boolean lineIncreaseCapability) {
        this.lineIncreaseCapability = lineIncreaseCapability;
    }

    public boolean isLineIncreaseCapability() {
        return lineIncreaseCapability;
    }

    public void setMaturity(int maturity) {
        this.maturity = maturity;
    }

    public void setPrepaymentCapability(boolean prepaymentCapability) {
        this.prepaymentCapability = prepaymentCapability;
    }

    public boolean isPrepaymentCapability() {
        return prepaymentCapability;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return LanguageManager.LANGUAGE.getString(FOR,SPACE,target.getName(),
                COMMA,SPACE,PERCENT,SPACE)+percent+
                LanguageManager.LANGUAGE.getString(PERC,COMMA,SPACE,MATURITY,SPACE)+
                maturity + LanguageManager.LANGUAGE.getString(COMMA,SPACE,AMOUNT,SPACE)+
                amount + LanguageManager.LANGUAGE.getString(DOLLAR);
    }
}
