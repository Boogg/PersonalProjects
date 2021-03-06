
package spacefighter;

/**
 *
 * @author Travis Hajagos
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Travis
 */
public abstract class GameObject {
    
    protected float x, y, mouseX, mouseY;
    protected ID id;
    protected float velX, velY;
    Rectangle hitbox;
    int collide = 0;
    private Handler handler;
    
    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id= id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics2D g);
    
//    public int intersect(Rectangle r1, Rectangle r2){
//
//        if (Math.min(r1.x + r1.width, r2.x + r2.width) >= Math.max(r1.x, r2.x)){
//            if (Math.min(r1.y + r1.height, r2.y + r2.height) >= Math.max(r1.y, r2.y)){
//                if(r1.x != r2.x){
//                    if(r1.y != r2.y)return 1;
//                    else return 3;
//                }else return 2;  
//            }
//        }
//        
//        return 0;
//    }
//     
//    
//    public void collision(){
//        for(int i = 0; i< handler.object.size(); i++){
//            GameObject tempObject = handler.object.get(i);
//            if(tempObject.getID() == ID.Enemy){
//                for(int j = 0; j< handler.object.size(); j++){
//                    GameObject tempObject2 = handler.object.get(j);
//                    if(tempObject2.getID() == ID.Enemy && i!=j){
//                        collide = intersect(tempObject.getHitbox(),
//                                            tempObject2.getHitbox());
//                        
//                        if(collide != 0){
//
//                            switch(collide){
//                                case 1: tempObject.velX *= -1;
//                                        tempObject.velY *= -1;
//                                        tempObject2.velX *= -1;
//                                        tempObject2.velY *= -1;
//                                        break;
//                                case 2: tempObject.velY *= -1;
//                                        tempObject2.velY *= -1;
//                                        break; 
//                                case 3: tempObject.velX *= -1;
//                                        tempObject2.velX *= -1;
//                                        break;
//                                default: break;
//                            }
//
//                        }
//                            
//                    }
//                }
//            
//            }
//        }
//    }
//    
    //setter getters
    public void setX(int x){
        this.x = x;
    }   
    public void setY(int y){
        this.y = y;
    }    
    public float getX(){
        return x;
    }   
    public float getY(){
        return y;
    }   
    public void setID(ID id){
        this.id = id;
    }    
    public ID getID(){
        return id;
    }
    public void setVelX(float velX){
        this.velX = velX;
    }
    public void setVelY(float velY){
        this.velY= velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
    
    public void setMouseX(int x){
        this.mouseX=x;
    }
    public void setMouseY(int y){
        this.mouseY=y;
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
    
}
