package ua.training.credits.controller.chooser;


import ua.training.credits.model.credit.Credit;

/**
 * Chooser of credits with line increase capabilities
 */
public class LineIncreaseCapabilities extends Capabilities {

    public boolean isCorrectCapabilities(Credit credit) {
        return credit.isLineIncreaseCapability() && !credit.isPrepaymentCapability();
    }
}
