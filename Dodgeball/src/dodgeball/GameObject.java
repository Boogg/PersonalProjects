/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeball;

import java.awt.Graphics;

/**
 *
 * @author Travis
 */
public abstract class GameObject {
    
    protected float x, y, mouseX, mouseY;
    protected ID id;
    protected float velX, velY;
    
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
    
}
