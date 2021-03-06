
package spacefighter;

/**
 *
 * @author Travis Hajagos
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player extends GameObject{
    
    
  
    public float moveSpeed=7, delX, delY, width, height, direction;
    float scale = (float)0.5;
    
    Graphics2D g2d;
    BufferedImage fighter = null;     
//    int cellWidth = fighter.getWidth(null);
//    int cellHeight = fighter.getHeight(null); 

    public Player(float x, float y, ID id){
        super(x, y, id);
        

        try {
         fighter = ImageIO.read(new File("fighter.png"));
        } catch (IOException e) {
        }
        height = fighter.getHeight(null)*scale;
        width = fighter.getWidth(null)*scale;
    }
    
    @Override
    public void tick(){
     
        
        velX=0;
        velY=0;
               //calculate difference of the player and curser in x and y 
        delX = (mouseX - (x+width/2));
        delY = (mouseY - (y+height/2));
        
        //claculate the angle between player and curser in radians
        direction = (float)Math.atan2(delY,delX);

       //if the curser is farther than 1/2 the diameter away, move 
        if(delX>width/2 || delX<-width/2){
            velX = (float)(moveSpeed * Math.cos(direction));
        }
        if(delY>height/2 || delY<-height/3){
            velY = (float)(moveSpeed * Math.sin(direction));
        }
        
        if(delX*delX+delY*delY < 10000){
            velX *= (delX*delX+delY*delY)/10000;
            velY *= (delX*delX+delY*delY)/10000;
        }

        //move the player sprite
        x+=velX;
        y+=velY;
        
    }
    
    @Override
    public void render(Graphics2D g){
//        if(id == ID.Player) g.setColor(Color.blue);
//        
//        g.fillRect((int)x, (int)y, (int)width, (int)height);

//        g2d = (Graphics2D)g;


        
        
        g.rotate(this.direction+Math.PI/2,(int)x+width/2,(int)y+height/2);
        g.drawImage(fighter,
                    (int)x, (int)y,
                    (int)(x+width), (int)(y+height),
                    0, 0, 96, 96,
                    null);
        g.rotate(this.direction+Math.PI/2*(-1),(int)x+width/2,(int)y+height/2);
    }
}
        
    
    
    
    
