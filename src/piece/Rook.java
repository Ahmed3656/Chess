package piece;

import main.GamePanel;

public class Rook extends Piece{
    public Rook(int color, int col, int row)
    {
        super(color, col, row);

        if(color == GamePanel.WHITE)
        {
            image = getImg("piece/wR");
        }
        else
        {
            image = getImg("piece/bR");
        }
    }
}
