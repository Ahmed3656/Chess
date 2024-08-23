package main;

import java.awt.*;

public class Board
{
    final int COL = 8, ROW = 8;
    public static int SQUARE_SIZE;
    public static int HALF_SQUARE_SIZE;

    public void draw(Graphics2D g2, int panelHeight)
    {
        SQUARE_SIZE = panelHeight / ROW;
        HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

        for(int row = 0; row < ROW; row++)
        {
            int alternatingColor = row % 2;
            for (int col = 0; col < COL; col++) {
                if (alternatingColor == 0) g2.setColor(new Color(180,151,114));
                else g2.setColor(new Color(112,79,56));
                alternatingColor = (alternatingColor + 1) % 2;
                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }
}