/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Travis
 */
public class Enemy extends GameObject{
    
    public Enemy(int x, int y, ID id){
        super(x, y, id);
            
        Random rand = new Random();
        
        velX=rand.nextInt(9)+1;
        velY=rand.nextInt(9)+1; 
   
    }
    
    @Override
    public void tick(){

        x+= velX;
        y+= velY;
        
        if(x<0 || x>(Game.WIDTH - 21))velX *= -1;
        if(y<0 || y>(Game.HEIGHT - 47))velY *= -1;  

    }
    
    @Override
    public void render(Graphics g){
       if(id == ID.Enemy) g.setColor(Color.red);
        
        g.fillOval((int)x, (int)y, 16, 16);
    }
}
