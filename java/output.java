package src.main.java;

import java.awt.*;
import java.awt.image.BufferedImage;

public class output {
    public static final Rectangle messageBox = new Rectangle(200, 480, 600, 50);
    /**
     * output Eevee on the midle of the screen
     *
     * @param eevee
     * @param graphics
     */

    public void outputEevee(Eevee eevee, Graphics graphics) {
        BufferedImage Eevee = Imges.getTexur("eevee");

        if (eevee.getDirection() == Direction.Left) {

            Eevee = Imges.getTexur("eeveeLeft");
        }
        graphics.drawImage(Eevee, Display.hight/2, Display.width/2, Eevee.getWidth(), Eevee.getHeight(), null);
    }

    public void starttext(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRoundRect(100, 100, Display.width, Display.hight, 25, 25);
        graphics.setFont(new Font("Serif", Font.BOLD, 50));
        graphics.drawString("Rood to godis", 100, 100);
        graphics.setFont(new Font("Serif", Font.PLAIN, 20));
        graphics.drawString("Hello human", 100, 150);
        graphics.drawString("my name is Eevee ", 100, 180);
        graphics.drawString("last night i deamet of getting godis becsue im a good girl", 100, 210);
        graphics.drawString("But today my human was too busy coding java,", 100, 240);
        graphics.drawString("So i decided to get my self a treat will you help me ", 100, 260);
        graphics.drawString("If so press W", 200, 350);
    }

    public void outputstats(Eevee eevee, Level room, Graphics2D g) {
        g.setColor(Color.orange);
        g.fillRoundRect(5, 5, 100, 150, 10, 10);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, 100, 150, 10, 10);
        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        g.drawString("- Player -", 10, 25);
        g.setFont(new Font("Dialog", Font.PLAIN, 12));
        g.drawString("HP: "+ eevee.getHealth(), 10, 45);
        //here add potion key bolion

    }

    public void outputLevel(Level room, Eevee eevee, Graphics g) {
        for (int y = 0; y< room.getlevelX(); y++) {
            for (int x = 0; x< room.getlevelY(); x++) {
                BufferedImage texure = Imges.getTexur(room.getAthing(x, y).getName());
                int PostionX = calculateOffsetX(texure, room.getAthing(x, y), eevee);
                int PostionY = calculateOffsetY(texure, room.getAthing(x, y), eevee);
                g.drawImage(texure, PostionX, PostionY, texure.getWidth(), texure.getHeight(), null);
            }
        }

    }
    private int calculateOffsetX(BufferedImage texure, Athing athing, Eevee eevee) {
        return athing.getPosX()*texure.getWidth()+((Display.hight/2)-eevee.getPosX()*texure.getHeight()-(texure.getHeight()/2))+eevee.getOffSetX();
    }
    private int calculateOffsetY(BufferedImage texure, Athing athing, Eevee eevee) {
        return athing.getPosY()*texure.getWidth()+((Display.hight/2)-eevee.getPosY()*texure.getHeight()-(texure.getHeight()/2))+eevee.getOffSetY();
    }

    public void Textoutput(Text text, Graphics g) {
        if (text.getMessage() == null || text.getTime() <= 0) {
            return;
        }
        g.setColor(Color.BLACK);
        g.fillRoundRect(messageBox.x, messageBox.y, messageBox.width, messageBox.height, 10, 10);
        g.setColor(Color.WHITE);
        g.drawRoundRect(messageBox.x, messageBox.y, messageBox.width, messageBox.height, 10, 10);

        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        //Center text
        try {
            int textPosX = messageBox.x + (messageBox.width - g.getFontMetrics().stringWidth(text.getMessage())) / 2;
            int textPosY = messageBox.y + ((messageBox.height - g.getFontMetrics().getHeight()) / 2) + g.getFontMetrics().getAscent();
            g.drawString(text.getMessage(), textPosX, textPosY);
        } catch(NullPointerException e) {
            return;
        }

    }


}
