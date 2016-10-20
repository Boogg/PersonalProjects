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
    LinkedList<GameObject> object = new LinkedList<>();
    
    public void tick(){
        for(int i = 0; i< object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
            collision(i, tempObject);
        }
 //       collision();
    }
    
    public void render(Graphics2D g){
        for(int i = 0; i< object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
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
//        for(int i = 0; i< object.size(); i++){
//            GameObject tempObject = object.get(i);
            if(tempObject.getID() == ID.Enemy){
                for(int j = 0; j< object.size(); j++){
                    GameObject tempObject2 = object.get(j);
                    if((tempObject2.getID() == ID.Enemy) && (i != j)){
                        if(tempObject.hitbox.intersects(tempObject2.getHitbox())){

                            System.out.println(tempObject.hitbox.intersection(tempObject2.hitbox));
                            if(tempObject.getVelX() >= tempObject.getVelY()){
                                tempObject.setVelY(tempObject.velY * -1);
                               // removeObject(tempObject2);
                                System.out.println("2");
                            }else tempObject.setVelX(tempObject.velX * -1);
                            if(tempObject2.getVelX() >= tempObject2.getVelY()){
                                tempObject2.setVelY(-tempObject2.velY);
                             //   System.out.println("1");
                            }else tempObject2.setVelX(tempObject2.velX * -1);
                            
                            
                        }
                       
                           
                    }
                }
            
            }
        }

    
    
    
}
