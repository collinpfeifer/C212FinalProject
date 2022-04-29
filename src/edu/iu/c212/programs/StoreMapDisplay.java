package edu.iu.c212.programs;

import javax.swing.*;
import java.util.ArrayList;

public class StoreMapDisplay {

    public static void display(String title, int aisleToHighlight){
        JFrame frame = new JFrame(title);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //UNCOMMENT THE LINE BELOW!!!!
        frame.add(new StoreMap(aisleToHighlight));
        //frame.pack();
        frame.setVisible(true);
    }
}
