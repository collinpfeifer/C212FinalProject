package edu.iu.c212.programs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreMap extends JComponent {
    private final int aisleNum;
    public StoreMap(int aisleNumberToHighlight) {
        this.aisleNum = aisleNumberToHighlight;
    }

    public void paintComponent(Graphics g) {
        // Drawing the map
        // No need to touch the code in this section of the method
        // Set StoreMapDisplay.WIDTH to 700 and StoreMapDisplay.HEIGHT to 500 for this to display properly!

        // StoreMapDisplay.WIDTH - 10;
        // StoreMapDisplay.HEIGHT - 37;

        int canvasWidth = 690;
        int canvasHeight = 463;
        int aisleWidth = 200;
        int aisleHeight = 40;
        // draw the map
        // perimeter walls
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, canvasWidth, 10); // north
        g.fillRect(0, canvasHeight-10, canvasWidth, 10); // south
        g.fillRect(0, 0, 10, canvasHeight-10); // west
        g.fillRect(canvasWidth-13, 0, 10, canvasHeight-10); // east
        // draw gardening section walls
        g.fillRect(450, 0, 10, canvasHeight/2); // west
        g.fillRect(450, canvasHeight/2-10, canvasHeight/2, 10);
        // draw shelves
        g.setColor(Color.BLUE);

        ArrayList<Integer> yArrayList = new ArrayList<>();
        ArrayList<Integer> aisleWidthArrayList = new ArrayList<>();
        ArrayList<Integer> aisleHeightArrayList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            g.fillRect(30, 30 + 60 * i, aisleWidth, aisleHeight);
            if (i > 3) g.fillRect(450, 30 + 60 * i, aisleWidth, aisleHeight);
        }
        // draw planter boxes in gardening section
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.fillRect(490 + 60 * i, 30 + 60 * j, 40, 40);
            }
        }
        // draw aisle numbers
        // shelves
        g.setColor(Color.BLACK);
        for (int i = 0; i < 12; i++) {
            if (i < 8) {
                g.drawString("Aisle " + (i+1), 110, 25 + 60 * i);
            } else {
                g.drawString("Aisle " + (i+1), 530, 25 + 60 * (i-4));
            }
        }
        // planter boxes
        g.setColor(Color.WHITE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.drawString("A " + (12 + (i+1) + 3 * j), 500 + i * 60, 60 + 60 * j);
            }
        }

        // TODO: draw the box appropriately around the aisle. You'll need to define these boundaries yourself for each one!
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.GREEN);
        //g2d.drawRect(100, 100, 200, 40);
        if(aisleNum == 1){
            g2d.drawRect(30, 30 + 60 * 0, aisleWidth, aisleHeight);
        } else if(aisleNum == 2){
            g2d.drawRect(30, 30 + 60 * 1, aisleWidth, aisleHeight);

        } else if(aisleNum == 3){
            g2d.drawRect(30, 30 + 60 * 2, aisleWidth, aisleHeight);
        }else if(aisleNum == 4){
            g2d.drawRect(30, 30 + 60 * 3, aisleWidth, aisleHeight);
        }else if(aisleNum == 5){
            g2d.drawRect(30, 30 + 60 * 4, aisleWidth, aisleHeight);
        }else if(aisleNum == 6){
            g2d.drawRect(30, 30 + 60 * 5, aisleWidth, aisleHeight);
        }else if(aisleNum == 7){
            g2d.drawRect(30, 30 + 60 * 6, aisleWidth, aisleHeight);
        }else if(aisleNum == 8){
            g2d.drawRect(30, 30 + 60 * 7, aisleWidth, aisleHeight);

        }else if(aisleNum == 9){
            g2d.drawRect(450, 30 + 60 * 4, aisleWidth, aisleHeight);

        }else if(aisleNum == 10){
            g2d.drawRect(450, 30 + 60 * 5, aisleWidth, aisleHeight);

        }else if(aisleNum == 11){
            g2d.drawRect(450, 30 + 60 * 6, aisleWidth, aisleHeight);

        }else if(aisleNum == 12){
            g2d.drawRect(450, 30 + 60 * 7, aisleWidth, aisleHeight);

        }else if(aisleNum == 13){
            g.drawRect(490 + 60 * 0, 30 + 60 * 0, 40, 40);

        }else if(aisleNum == 14){
            g.drawRect(490 + 60 * 0, 30 + 60 * 1, 40, 40);

        }else if(aisleNum == 15){
            g.drawRect(490 + 60 * 0, 30 + 60 * 2, 40, 40);

        }else if(aisleNum == 16){
            g.drawRect(490 + 60 * 1, 30 + 60 * 0, 40, 40);

        }else if(aisleNum == 17){
            g.drawRect(490 + 60 * 1, 30 + 60 * 1, 40, 40);
        }else if(aisleNum == 18){
            g.drawRect(490 + 60 * 1, 30 + 60 * 2, 40, 40);
        }else if(aisleNum == 19){
            g.drawRect(490 + 60 * 2, 30 + 60 * 0, 40, 40);
        }else if(aisleNum == 20){
            g.drawRect(490 + 60 * 2, 30 + 60 * 1, 40, 40);

        }else if(aisleNum == 21){
            g.drawRect(490 + 60 * 2, 30 + 60 * 2, 40, 40);
        }


    }

}
