package src.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class TheGame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            GameActions.testing();
            if (input.isKeyDown(KeyEvent.VK_W)) {
                GameActions.moveEevee(0, -1); //Up
            } else if (input.isKeyDown(KeyEvent.VK_A)) {
                GameActions.moveEevee(-1, 0); //Left
                GameActions.getEevee().setDirection(Direction.Left);
            } else if (input.isKeyDown(KeyEvent.VK_S)) {
                GameActions.moveEevee(0, 1); //Down
            } else if (input.isKeyDown(KeyEvent.VK_D)) {
                GameActions.moveEevee(1, 0); //Right
                GameActions.getEevee().setDirection(Direction.Right);
//            } else if (input.isKeyDown(KeyEvent.VK_H)) {
//                GameActions.getEevee().usePotion();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }


}
