package ua.training.credits.model.credit;


public class AllCapabilitiesCreditBuilder extends CreditBuilder {

    void buildLineIncreaseCapability() {

        getCredit().setLineIncreaseCapability(true);
    }

    void buildPrepaymentCapability() {
        getCredit().setPrepaymentCapability(true);
    }
}
