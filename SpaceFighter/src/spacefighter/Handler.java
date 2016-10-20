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
    
    public void tick(){
        for(int i = 0; i< objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            collision(i, tempObject);
             if(tempObject.getID() == ID.Player){
                
                if(tempObject.fired == true){ 
                    System.out.println("shoot");
                    shoot(tempObject);  
                    tempObject.setFired(false);
                }
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
        
            if(tempObject.getID() == ID.Enemy){
                for(int j = 0; j< objects.size(); j++){
                    GameObject tempObject2 = objects.get(j);
                    if((tempObject2.getID() == ID.Enemy) && (i != j)){
                        if(intersect(tempObject.x + tempObject.width /2, tempObject.y + tempObject.height /2, tempObject.radius, 
                             tempObject2.x + tempObject2.height /2, tempObject2.y + tempObject2.height /2, tempObject2.radius)){

                           // System.out.println(tempObject.hitbox.intersection(tempObject2.hitbox));
         //                   if(Math.abs(tempObject.getVelX()) >= Math.abs(tempObject.getVelY())){
                                tempObject.setVelY(tempObject.velY * -1);
                               // removeObject(tempObject2);
                              //  System.out.println("2");
           //                 }else (  tempObject.setVelX(tempObject.velX * -1);
         //                   if(Math.abs(tempObject2.getVelX()) >= Math.abs(tempObject2.getVelY())){
                                tempObject2.setVelY(-tempObject2.velY);
                             //   System.out.println("1");
          //                  }else(tempObject2.setVelX(tempObject2.velX * -1);
                            
                            
                        }
                       
                           
                    }
                }
            
            }
        }

    
        public boolean intersect(float x1, float y1, float radius1, 
                             float x2, float y2, float radius2){
        
        if(
                ((x1+radius1)-(x2+radius2))*((x1+radius1)-(x2+radius2))+
                ((y1+radius1)-(y2+radius2))*((y1+radius1)-(y2+radius2))
                <= (radius1*radius1 + radius2*radius2)
                ){
        return true;
        }else return false;
    }
    
        public void shoot(GameObject tempObject){
            addObject(new Bullet(tempObject.x, tempObject.y, ID.Bullet, tempObject.direction));
        }
}
