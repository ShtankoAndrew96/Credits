package ua.training.credits.model.credit;

public class CreditDirector {
    CreditBuilder creditBuilder;

    public void setCreditBuilder(CreditBuilder creditBuilder) {
        this.creditBuilder = creditBuilder;
    }
    
    public Credit buildCredit(Target target, int percent, int maturity, double amount){
        creditBuilder.createCredit();
        
        creditBuilder.buildTarget(target);
        creditBuilder.buildPercent(percent);
        creditBuilder.buildMaturity(maturity);
        creditBuilder.buildSumm(amount);
        creditBuilder.buildLineIncreaseCapability();
        creditBuilder.buildPrepaymentCapability();
        
        return creditBuilder.getCredit();
    }
}
