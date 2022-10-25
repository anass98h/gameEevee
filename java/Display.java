package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Display extends JPanel  {
    public static final int width = 1920;
    public static final int hight = 1080;
    public static JFrame frame;
    public output output;

    public static boolean Story;

    public Display() {
        super();
        this.setFocusable(true);
        this.addKeyListener(new input());
        this.output = new output();
    }


    public static void intionlize() {
        frame = new JFrame("Eevee's adventure");
        //Moves and resizes this component. The new location of the top-left corner is specified by x and y, and the new size is specified by width and height.
        //This method changes layout-related information, and therefore, invalidates the component hierarchy.
        frame.setBounds(25,25,width,hight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Display display = new Display();
        frame.add(display);



    }
    public static void setVisible() {
        if (frame!=null) frame.setVisible(true); {
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, hight);

            if(GameActions.isStory()) {
                output.starttext(g);
            } else {
                output.outputLevel(GameActions.getRoom(), GameActions.getEevee(),g);
                output.outputEevee(GameActions.getEevee(), g);
                output.outputstats(GameActions.getEevee(),GameActions.getRoom(),(Graphics2D) g);
                output.Textoutput(GameActions.getText(),g);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        repaint();
    }




}
