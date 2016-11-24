
package spacefighter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class SpriteLibrary {
    
    BufferedImage asteroids = null;
    BufferedImage fighter = null;
    BufferedImage laserBeam = null;
    public BufferedImage background, space1 = null, space2 = null,
                         space3 = null,space4 = null, space5 = null,
                         space6 = null;
    public BufferedImage[] space = new BufferedImage[6];
    
    public SpriteLibrary(){
        
        //load the sprite sheet
        
        //asteroids sprite
        try {
         asteroids = ImageIO.read(new File("src/spacefighter/sprites/asteroids.png"));
        } catch (IOException e) {}
        
        //fighter sprite
        try {
         fighter = ImageIO.read(new File("src/spacefighter/sprites/fighter.png"));
        } catch (IOException e) {}
        
        //laser sprite
        try {
         laserBeam = ImageIO.read(new File("src/spacefighter/sprites/laser_beam.png"));
        } catch (IOException e) {
            System.out.println("Cannot open laser_beam.png");
        } 
        
        //load backgrounds
        try {
            space1 = ImageIO.read(new File("src/spacefighter/sprites/nebula1.jpg"));
            space2 = ImageIO.read(new File("src/spacefighter/sprites/nebula2.jpg"));
            space3 = ImageIO.read(new File("src/spacefighter/sprites/nebula3.jpg"));
            space4 = ImageIO.read(new File("src/spacefighter/sprites/unicorn1.png"));
            space5 = ImageIO.read(new File("src/spacefighter/sprites/galaxy1.jpg"));
            space6 = ImageIO.read(new File("src/spacefighter/sprites/galaxy2.jpg"));
        } catch (IOException e) {}
        
        
    }
    
    public BufferedImage getAsteroid(){
        return asteroids;
    }
    public BufferedImage getFighter(){
        return fighter;
    }
    public BufferedImage getLaserBeam(){
        return laserBeam;
    }
    public BufferedImage getSpace(int x){
        switch(x){
            case 1:
                return space1;
            case 2:
                return space2;
            case 3:
                return space3;
            case 4:
                return space4;
            case 5:
                return space5;
            case 6:
                return space6;
            default:
                return null;
        }
    }

    
    
    
}
