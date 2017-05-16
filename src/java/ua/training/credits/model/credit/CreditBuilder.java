package ua.training.credits.model.credit;


public abstract class CreditBuilder extends Credit {
    private Credit credit;

    void createCredit(){
        credit = new Credit();
    }

    void buildPercent(int percent){
        credit.setPercent(percent);
    }
    void buildMaturity(int maturity){
        credit.setMaturity(maturity);
    }
    void buildSumm(double amount){
        credit.setAmount(amount);
    }

    void buildTarget(Target target){
        credit.setTarget(target);
    }

    abstract void buildLineIncreaseCapability();
    abstract void buildPrepaymentCapability();

    public Credit getCredit(){
        return credit;
    }
}
