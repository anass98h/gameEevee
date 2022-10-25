package src.main.java;

import javax.swing.*;
import java.io.IOException;

public class GameActions {
    private static House house;
    private static Level room;

    private static Eevee eevee;
    public static boolean Story;
    private static Timer timer;
    private static Text text;

    public static void start() {
        try {
            Imges.intionlize();
            intionlizeGame();
            timer = new Timer(20, new TheGame());
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


    }

    public static void testing() {
        eevee.decreaseMotionOffset();
    }

    public static void intionlizeGame() {
        house = new House();
        System.out.println("this is a test");
        room = house.getLevel(0);
        eevee = new Eevee(4, 5, "eevee");
        text = new Text();
        Story = true;
    }


    public static boolean isStory() {
        return Story;
    }

    public static Eevee getEevee() {
        return eevee;
    }

    private static Athing Whatsinfront(Eevee eevee, int dirictionX, int dirictionY) {
        return room.getAthing(eevee.getPosX()+ dirictionX, eevee.getPosY()+ dirictionY);
    }



    public static void moveEevee(int directionX, int directionY) {
        Story = false;


        switch (Whatsinfront(eevee, directionX, directionY).getName()) {
            case "floor":
                eevee.setPostion(eevee.getPosX()+directionX,eevee.getPosY()+directionY);
                break;
            case "stairs":
                room = house.nextRoom();
                eevee.setPostion(room.getStartPositionX(), room.getStartPositionY());
                text.addMessage("maybe I'll find the bone in this room",150);
                break;
            case "wall":
                text.addMessage("you can't walk through wall's",100);
                break;
            case "chocolate":
            case "chips":
                eevee.damage(10);
                eevee.setPostion(eevee.getPosX()+directionX,eevee.getPosY()+directionY);
                text.addMessage("a good dog shouldn't eat that",100);
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                break;
            case "water":
                eevee.heal(10);
                text.addMessage("water is good for dogs health",100);
                break;
            case "key":
                eevee.pickUPkey();
                eevee.setPostion(eevee.getPosX()+directionX,eevee.getPosY()+directionY);
                text.addMessage("you picked up a key",100);
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                break;
            case "door":
                if (eevee.useKey()) {
                    room.openAdoor(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                    text.addMessage("you used the key to open a door",100);
                } else {
                    text.addMessage("you dont have a key YET!! look around",100);
                }
                break;
            case "health":
                eevee.pickUPpotion();
                eevee.setPostion(eevee.getPosX()+directionX,eevee.getPosY()+directionY);
                text.addMessage("you picked up a health potion",100);
                room.removeconsuble(eevee.getPosX() + directionX, eevee.getPosY() + directionY);
                break;
            case "bone":
                text.addMessage("yay a found the goddies thank you for your help humen",300);
                break;
        }
    }

    public static Level getRoom() {
        return room;
    }

    public static Text getText() {
        return text;
    }

}
