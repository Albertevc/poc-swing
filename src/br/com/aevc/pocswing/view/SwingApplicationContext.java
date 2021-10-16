package br.com.aevc.pocswing.view;

public class SwingApplicationContext {

    private static SwingApplication swingApplicationReference;

    SwingApplicationContext(){
    }

    public static void initialize(SwingApplication swingApplication){
        swingApplicationReference = swingApplication;
    }

    public static SwingApplication getSwingApplication() {
        return swingApplicationReference;
    }
}
