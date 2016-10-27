/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefighter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author rcc
 */
public class Bullet extends GameObject{
    
//    BufferedImage laserBeam = null;
    
    int startSrcY, endSrcY;

    public Bullet(float x, float y, ID id, float direction) {
        super(x, y, id);
        this.direction = direction;
        this.speed = 10;
        this.scale = 0.04f;
        

        
        //load the sprite sheet
//        try {
//         laserBeam = ImageIO.read(new File("src/spacefighter/sprites/laser_beam.png"));
//        } catch (IOException e) {
//            System.out.println("Bullet.java:36 Cannot open laser_beam.png");
//        } 
//        
//        this.height = (int)(laserBeam.getHeight(null)*scale);
//        this.width = height/2;
//        this.startSrcY = 0;
//        this.endSrcY = (int)(laserBeam.getWidth(null)/4);
//
        this.height = 8;
        this.width  = 8;        
        this.radius = 4;
                
    }

    @Override
    public void tick() {
        
        velX = (float)(speed * Math.cos(direction));
        velY = (float)(speed * Math.sin(direction));
//        if(endSrcY < 145)endSrcY += speed/scale;
//        if(endSrcY > 72 && startSrcY < 72)startSrcY += speed/scale;
        x += velX;
        y += velY;
        
    }

    @Override
    public void render(Graphics2D g) {
        
        
       g.setColor(Color.blue);

       g.fillOval((int)x, (int)y, (int)this.height, (int)this.width);
  
//       g.rotate(this.direction+Math.PI/2,(int)x+width/2,(int)y+height/2);
//       g.drawImage(laserBeam,
//                    (int)x, (int)y,
//                    (int)(x+width), (int)(y+height),
//                    0, startSrcY, 318, endSrcY,
//                    null);
//       g.rotate(this.direction+Math.PI/2*(-1),(int)x+width/2,(int)y+height/2);
    }
    
    
}
