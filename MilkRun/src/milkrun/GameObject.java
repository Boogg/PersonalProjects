
package milkrun;

import java.awt.Graphics;

public abstract class GameObject {
    

    protected float x, y, mouseX, mouseY;
    protected ID id;
    protected float velX, velY;
    protected boolean jump;
    protected boolean boost;
    
    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id= id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    
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
    public void setId(ID id){
        this.id = id;
    }    
    public ID getId(){
        return id;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
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
    public void setJump(boolean j){
        this.jump = j;
    }
    public void setBoost(boolean b){
        this.boost = b;
    }
}
