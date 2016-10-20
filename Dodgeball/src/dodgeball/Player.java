/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Travis
 */
public class Player extends GameObject{
    
    
    public float moveSpeed=7, delX, delY, width=32, height=32, direction;    
        
        
    public Player(float x, float y, ID id){
        super(x, y, id);

    }
    
    @Override
    public void tick(){
     
        
        velX=0;
        velY=0;
               //calculate change in  x and y 
        delX = (mouseX - (x+width/2));
        delY = (mouseY - (y+height/2));
        
        //claculate the angle between player and curser in radians
        direction = (float)Math.atan2(delY,delX);

       //if the curser is farther than 1/4 the diameter away, move 
        if(delX>width/4 || delX<-width/4){
            velX = (float)(moveSpeed * Math.cos(direction));
        }
        if(delY>height/4 || delY<-height/4){
            velY = (float)(moveSpeed * Math.sin(direction));
        }

        x+=velX;
        y+=velY;
        
    }
    
    @Override
    public void render(Graphics g){
        if(id == ID.Player) g.setColor(Color.blue);
        
//        g.fillRect((int)x, (int)y, (int)width, (int)height);
//        try {
//      Graphics2D g2D;
//      g2D = (Graphics2D) g;
//      g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//      String fileName = "a.jpg";
//      Image img = getToolkit().getImage(fileName);
//      AffineTransform aTran = new AffineTransform();
//      aTran.translate(50.0f, 20.0f);
//      g2D.transform(aTran);
//      g2D.drawImage(img, new AffineTransform(), this);
//    } catch (Exception e) {
//    }
        
    }
    
    
    
}
