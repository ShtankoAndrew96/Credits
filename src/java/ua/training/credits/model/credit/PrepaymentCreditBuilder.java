package ua.training.credits.model.credit;

public class PrepaymentCreditBuilder extends CreditBuilder {


    void buildLineIncreaseCapability() {
        getCredit().setLineIncreaseCapability(false);
    }

    void buildPrepaymentCapability() {
        getCredit().setPrepaymentCapability(true);
    }
}
