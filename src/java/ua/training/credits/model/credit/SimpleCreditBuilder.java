package ua.training.credits.model.credit;

public class SimpleCreditBuilder extends CreditBuilder {
    void buildLineIncreaseCapability() {
        getCredit().setLineIncreaseCapability(false);
    }

    void buildPrepaymentCapability() {
        getCredit().setPrepaymentCapability(false);
    }
}
