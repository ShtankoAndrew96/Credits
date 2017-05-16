package ua.training.credits.controller.chooser;

import ua.training.credits.model.credit.Credit;

/**
 * Chooser of credits, that not have any additional capabilities
 */
public class SimpleCapabilities extends Capabilities {

    public boolean isCorrectCapabilities(Credit credit) {
        return !credit.isLineIncreaseCapability() && !credit.isPrepaymentCapability();
    }
}
