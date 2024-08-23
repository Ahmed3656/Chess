package piece;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece
{
    public BufferedImage image;
    public int col, row, preCol, preRow, color;

    public Piece(int color, int col, int row)
    {
        this.color = color;
        this.col = col;
        this.row = row;
        preCol = col;
        preRow = row;
    }

    public BufferedImage getImg(String imgPath)
    {
        BufferedImage img = null;

        try
        {
            img = ImageIO.read(getClass().getResourceAsStream("/" + imgPath + ".png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return img;
    }

    public void draw(Graphics2D g2)
    {
        int x = col * Board.SQUARE_SIZE;
        int y = row * Board.SQUARE_SIZE;

        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
