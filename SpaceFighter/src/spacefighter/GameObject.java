
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
    protected float velX, velY, direction, radius, height, width, scale;
    protected boolean fired, collided;
    Rectangle hitbox;
    int collide = 0, speed;
   // private Handler handler;
    
    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id= id;
        
    }
    
    public abstract void tick();
    public abstract void render(Graphics2D g);
    

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
    
    public void setFired(boolean fired){
        this.fired = fired;
    }
    
    public void setCollided(boolean collided){
        this.collided = collided;
    }
    public boolean getCollided(){
        return this.collided;
    }
    public boolean intersect(float x1, float y1, float radius1, 
                             float x2, float y2, float radius2){
        
        if(
                ((x1+radius1)-(x2+radius2))*((x1+radius1)-(x2+radius2))+
                ((y1+radius1)-(y2+radius2))*((y1+radius1)-(y2+radius2))
                < (radius1*radius1 + radius2*radius2)
                ){
        return true;
        }else return false;
    }
    
//    public void remove(GameObject object){
//        handler.removeObject(object);
//    }
    
}
