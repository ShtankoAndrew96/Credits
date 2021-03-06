package ua.training.credits.controller.chooser;

import ua.training.credits.model.credit.Credit;

/**
 * Chooser of credits, with all available capabilities
 */
public class FullCapabilities extends Capabilities {

    public boolean isCorrectCapabilities(Credit credit) {
        return credit.isPrepaymentCapability() && credit.isLineIncreaseCapability();
    }
}
