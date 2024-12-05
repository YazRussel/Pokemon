import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public abstract class Pokemon {
    private static final ArrayList<Integer> userID = new ArrayList<>();
    private ImageIcon img;
    private Point location;
    private int idNumber;


    public Pokemon(){
        Random rand = new Random();
        do {
            this.idNumber = rand.nextInt(10);
        } while (!userID.add(this.idNumber));
        this.location = new Point(rand.nextInt(801), rand.nextInt(801));
    }
    public void setImage(String image){
        this.img = new ImageIcon(image);
    }
    public int getId(){
        return this.idNumber;
    }
    public void draw(Graphics e){
        if(img!=null){
            img.paintIcon(null, e, location.x, location.y);
        }
        e.drawString(String.valueOf(idNumber), location.x, location.y);
    }




}
