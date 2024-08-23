package main;

import piece.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GamePanel extends JPanel implements Runnable
{
    public static final int WIDTH = 1100;
    public static final int HEIGHT = 800;
    protected int FPS = 60;

    Thread gameThread;
    Board board = new Board();

    //Pieces
    public static ArrayList<Piece> pieces = new ArrayList<>();
    public static ArrayList<Piece> simPieces = new ArrayList<>();

    //Color
    public static final int WHITE = 1, BLACK = 0;
    int currColor = WHITE;

    public GamePanel()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);

        setPieces();
        setSimPieces(pieces, simPieces);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start(); // automatically calls run method
    }

    public void setPieces()
    {
        //White
        pieces.add(new Pawn(WHITE, 0, 6));
        pieces.add(new Pawn(WHITE, 1, 6));
        pieces.add(new Pawn(WHITE, 2, 6));
        pieces.add(new Pawn(WHITE, 3, 6));
        pieces.add(new Pawn(WHITE, 4, 6));
        pieces.add(new Pawn(WHITE, 5, 6));
        pieces.add(new Pawn(WHITE, 6, 6));
        pieces.add(new Pawn(WHITE, 7, 6));
        pieces.add(new Rook(WHITE, 0, 7));
        pieces.add(new Rook(WHITE, 7, 7));
        pieces.add(new Knight(WHITE, 1, 7));
        pieces.add(new Knight(WHITE, 6, 7));
        pieces.add(new Bishop(WHITE, 2, 7));
        pieces.add(new Bishop(WHITE, 5, 7));
        pieces.add(new Queen(WHITE, 3, 7));
        pieces.add(new King(WHITE, 4, 7));

        //Black
        pieces.add(new Pawn(BLACK, 0, 1));
        pieces.add(new Pawn(BLACK, 1, 1));
        pieces.add(new Pawn(BLACK, 2, 1));
        pieces.add(new Pawn(BLACK, 3, 1));
        pieces.add(new Pawn(BLACK, 4, 1));
        pieces.add(new Pawn(BLACK, 5, 1));
        pieces.add(new Pawn(BLACK, 6, 1));
        pieces.add(new Pawn(BLACK, 7, 1));
        pieces.add(new Rook(BLACK, 0, 0));
        pieces.add(new Rook(BLACK, 7, 0));
        pieces.add(new Knight(BLACK, 1, 0));
        pieces.add(new Knight(BLACK, 6, 0));
        pieces.add(new Bishop(BLACK, 2, 0));
        pieces.add(new Bishop(BLACK, 5, 0));
        pieces.add(new Queen(BLACK, 3, 0));
        pieces.add(new King(BLACK, 4, 0));
    }

    private void setSimPieces(ArrayList<Piece> src, ArrayList<Piece> target)
    {
        target.clear();
        for(int i = 0; i < src.size(); i++) target.add(src.get(i));
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000 / FPS, delta = 0;
        long lstTime = System.nanoTime(), currTime;

        while(gameThread != null)
        {
            currTime = System.nanoTime();
            delta += (currTime - lstTime) / drawInterval;
            lstTime = currTime;

            if(delta >= 1)
            {
                // update game info
                update();

                // draw the screen with the updated info
                repaint();
                delta--;
            }
        }
    }

    private void update()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int panelHeight = getHeight();

        //Draw board
        board.draw((Graphics2D) g, panelHeight);

        //Draw pieces
        for(Piece p : simPieces)
        {
            p.draw((Graphics2D) g);
        }
    }
}
