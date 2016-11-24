/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefighter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author rcc
 */
public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();
    
    int counter = 0;
    
    public void tick(){
        for(int i = 0; i< objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            collision(i, tempObject);
             if(tempObject.getID() == ID.Player){
                
                if(tempObject.fired == true && counter > 15){ 
                   // System.out.println("shoot");
                    shoot(tempObject);  
                    tempObject.setFired(false);
                    counter = 0;
                }else counter++;
                }
             if((tempObject.getX() <= -100)||(tempObject.getY() <= -100)){
                 if((tempObject.getX() >= Window.HEIGHT + 100)||(tempObject.getY() >= Window.WIDTH + 100)){
                     removeObject(tempObject);
                 }
             }
        }
 //       collision();
    }
    
    public void render(Graphics2D g){
        for(int i = 0; i< objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.objects.add(object);
    }
    
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    
//    public boolean intersect(Rectangle r1, Rectangle r2){
//
//        if (Math.min(r1.x + r1.width, r2.x + r2.width) > Math.max(r1.x, r2.x)){
//            
//            if (Math.min(r1.y + r1.height, r2.y + r2.height) > Math.max(r1.y, r2.y)){
//                
//               return true;
//            }
//        }
//        
//        return false;
//    }
     
    
    public void collision(int i, GameObject tempObject){
        
            if(tempObject.getID() == ID.Asteroid){
                for(int j = 0; j< objects.size(); j++){
                    GameObject tempObject2 = objects.get(j);
                    if((tempObject2.getID() == ID.Asteroid) && (i != j)){
                        if(intersect(tempObject.x + tempObject.width /2, tempObject.y + tempObject.height /2, tempObject.radius, 
                             tempObject2.x + tempObject2.height /2, tempObject2.y + tempObject2.height /2, tempObject2.radius)
                                && !tempObject.getCollided() && !tempObject.getCollided()){
                           // System.out.println(tempObject.hitbox.intersection(tempObject2.hitbox));
//                            if(tempObject.scale >= tempObject2.scale){
//                                tempObject.setVelY(tempObject.velY * -1);
//                               // removeObject(tempObject2);
//                                System.out.println("2");
//                            }else   tempObject.setVelX(tempObject.velX * -1);
//                            if(Math.abs(tempObject2.getVelX()) >= Math.abs(tempObject2.getVelY())){
//                                tempObject2.setVelY(-tempObject2.velY);
//                                System.out.println("1");
//                            }else tempObject2.setVelX(tempObject2.velX * -1);

                            tempObject.setVelX((tempObject.getVelX()*tempObject.scale)-(tempObject2.getVelX()*tempObject2.scale));
                            tempObject.setVelY((tempObject.getVelY()*tempObject.scale)-(tempObject2.getVelY()*tempObject2.scale));
                            tempObject2.setVelX((tempObject.getVelX()*tempObject.scale)-(tempObject2.getVelX()*tempObject2.scale));
                            tempObject2.setVelY((tempObject.getVelY()*tempObject.scale)-(tempObject2.getVelY()*tempObject2.scale));
                            tempObject.setCollided(true);
                            tempObject2.setCollided(true);
                            
                            
                        }         
                    }else if(tempObject2.getID() == ID.Bullet){
                        if(intersect(tempObject.x + (tempObject.width /2), tempObject.y + (tempObject.height /2), tempObject.radius, 
                             tempObject2.x + (tempObject2.height/2), tempObject2.y + (tempObject2.height /2), tempObject2.radius)){
                            
                            removeObject(tempObject);
                            removeObject(tempObject2);
                        }
                    }
                }
            
            }
        }

    
        public boolean intersect(float x1, float y1, float radius1, 
                             float x2, float y2, float radius2){
        
        if( (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<=(radius1*radius1 + radius2*radius2)+20)
        {
        return true;
        }else return false;
    }
    
        public void shoot(GameObject tempObject){
            addObject(new Bullet((tempObject.x + tempObject.width/2), (tempObject.y + tempObject.height/2), ID.Bullet, tempObject.direction));
        }
}
