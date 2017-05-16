package ua.training.credits.model.credit;

public class LineIncreaseCreditBuilder extends CreditBuilder {

    void buildLineIncreaseCapability() {
        getCredit().setLineIncreaseCapability(true);
    }

    void buildPrepaymentCapability() {
        getCredit().setPrepaymentCapability(false);
    }
}
