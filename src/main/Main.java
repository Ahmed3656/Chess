package main;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setVisible(true);

        gp.startGameThread();

        window.addComponentListener(new java.awt.event.ComponentAdapter(){
            @Override
            public void componentResized(java.awt.event.ComponentEvent e)
            {
                gp.repaint();
            }
        });
    }
}