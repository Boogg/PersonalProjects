
package spacefighter;

/**
 *
 * @author Travis Hajagos
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Travis
 */
public class Enemy extends GameObject{
    
    BufferedImage asteroids = null;
    
    int srcX, srcY;
    int speed=5;
    int sheetSize = 256;
    float rotate, rotateSpeed, height,width,scale=(float)0.25;
    
    
    public Enemy(int x, int y, ID id){
        super(x, y, id);
        //set up for using random method
        Random rand = new Random();
        
        //load the sprite sheet
        try {
         asteroids = ImageIO.read(new File("src/spacefighter/sprites/asteroids.png"));
        } catch (IOException e) {
        }   
        
        //random scale of sprite to be drawn between 0.25 and 0.50
        scale = (float)(rand.nextInt(25)+25)/(float)100.0;
        
        //set the height and width of the sprite to be drawn
        height = (asteroids.getHeight(null)/2)*scale;
        width = (asteroids.getWidth(null)/2)*scale;
            
        //set random velocities in X and Y direction that are not zero
        do{
            velX=rand.nextInt(speed)- (speed/2);
            velY=rand.nextInt(speed)- (speed/2);
        } while(velY == 0 && velX == 0); 
   
        //randomly assign an asteroid from the asteroid sprite sheet using its
        //coordinates on the sprite sheet
        srcX = rand.nextInt(2) * 128;
        srcY = rand.nextInt(2) * 128;
        
        //set the initial rotation of the asteroid to zero
        rotate = 0;
        //randomly set the rotate speed of the asteroid from 30-60 either direction
        do{
            rotateSpeed = rand.nextInt(121)-60;
        }while(rotateSpeed < 29 && rotateSpeed > -29);
        
        hitbox = new Rectangle((int)x, (int)y, (int)(x+width),(int)(y+height));
        
       
     
    }
    
    @Override
    public void tick(){

        //moves the enemy
        x+= velX;
        y+= velY;
        
        //rotates the enemy
        rotate+=(Math.PI/rotateSpeed);
        
        //keeps the asteroids within the window
//        if(x<0 || x>(Game.WIDTH - width))velX *= -1;
//        if(y<0 || y>(Game.HEIGHT - height))velY *= -1;  
        
        if(x<-width) x=Game.WIDTH;
        if(x>Game.WIDTH) x= -width;
        if(y<-height) y=Game.HEIGHT;
        if(y>Game.HEIGHT) y= -height;
        
        

    }
    
    @Override
    public void render(Graphics2D g){
//       if(id == ID.Enemy) g.setColor(Color.red);
//        
//        g.fillOval((int)x, (int)y, 16, 16);

        //rotate the image
        g.rotate(this.rotate, x+width/2, y+height/2);
        //draw the image from the sprite sheet
        g.drawImage(asteroids,
                (int)x, (int)y, 
                (int)(x+width), (int)(y+height),
                srcX, srcY, srcX+128, srcY+128,
                null);
        //rotate the draw function back to normal 
        //or it will effect the other objects
        g.rotate(this.rotate*(-1),x+width/2,y+height/2);



    }
}
