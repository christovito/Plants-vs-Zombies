import java.awt.*;
import javax.swing.*;

public interface BackyardMaterials {
    public int getX(); 
    public int getY();
    public Image getImage();
    public abstract void act(GameBoard gameBoard);
}