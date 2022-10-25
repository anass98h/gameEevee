package src.main.java;

import static src.main.java.Display.frame;

public class Main {
    public static void main(String[] args){
        try {
            Display.intionlize();
            GameActions.start();
            Display.setVisible();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


    }
}

