/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeball;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author Travis
 */
public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 2322472837614L;
    
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    
    private Handler handler;
    
    public Game(){   
        Random rand = new Random();
        
        handler = new Handler();
        
 //       this.addKeyListener(new KeyInput(handler));
    this.addMouseMotionListener(new MouseInput(handler));
        
        new Window(WIDTH, HEIGHT, "Dodge Ball", this);
        requestFocus();
        for(int i=0;i<10; i++){
     //       int x=rand;
        handler.addObject(new Enemy(rand.nextInt(WIDTH) -32, rand.nextInt(HEIGHT)-32, ID.Enemy));
        }
        handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2-32, ID.Player));
        
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
     public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
    public void run(){
    
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        handler.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Game();
        
    }
    
}
