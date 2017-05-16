package ua.training.credits;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class of choosing program language
 */
public enum LanguageManager {
    LANGUAGE;


    ResourceBundle resourceBundle;
    private final String resourceName = "resource_bundle";

    LanguageManager(){
        resourceBundle = ResourceBundle.getBundle(resourceName, new Locale("en","GB"));
    }

    public void changeLanguage(Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    public String getString(String... s){
        StringBuffer stringBuffer = new StringBuffer();
        for(String string: s){
            stringBuffer.append(resourceBundle.getString(string));
        }
        return stringBuffer.toString();
    }
}
