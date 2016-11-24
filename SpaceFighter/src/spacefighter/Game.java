 
package spacefighter;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Travis Hajagos
 */
public class Game extends Canvas implements Runnable{


    private static final long serialVersionUID = 2322472837614L;
    
    public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9;
    
    //background images
    public BufferedImage[] space = new BufferedImage[6];
    public BufferedImage background = null;
    
    private Thread thread;
    private boolean running = false;
    
    private Handler handler;
    
    public Game(){   
        Random rand = new Random();
        
        handler = new Handler();
        
        this.addKeyListener(new KeyInput(handler));
        this.addMouseMotionListener(new MouseInput(handler));
        
//        //load backgrounds
//        try {
//            space1 = ImageIO.read(new File("src/spacefighter/sprites/nebula1.jpg"));
//            space2 = ImageIO.read(new File("src/spacefighter/sprites/nebula2.jpg"));
//            space3 = ImageIO.read(new File("src/spacefighter/sprites/nebula3.jpg"));
//            space4 = ImageIO.read(new File("src/spacefighter/sprites/unicorn1.png"));
//            space5 = ImageIO.read(new File("src/spacefighter/sprites/galaxy1.jpg"));
//            space6 = ImageIO.read(new File("src/spacefighter/sprites/galaxy2.jpg"));
//        } catch (IOException e) {
//        }

        SpriteLibrary sprites = new SpriteLibrary();
        
        for(int i=0;i>6;i++){
            space[i] = sprites.getSpace(i+1);
        }
        
        int backgroundSelect = rand.nextInt(6);
        
        
        background = space[backgroundSelect];
        
        new Window(WIDTH, HEIGHT, "Space Fighter", this);
        requestFocus();
        
        
        handler.addObject(new Player(WIDTH/2 -32, HEIGHT/2-32, ID.Player, sprites.getFighter())); 
        
        for(int i=0;i<15; i++){
     //       int x=rand;
        handler.addObject(new Asteroid(rand.nextInt(WIDTH-40)+5, rand.nextInt(HEIGHT-40)+5, ID.Asteroid, sprites.getAsteroid()));
        }
       
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
                System.out.println("FPS: " + frames);
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
        
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        
        g.setColor(Color.black);
       g.fillRect(0, 0, WIDTH, HEIGHT);
    g.drawImage(background,
                    0, 0, WIDTH, HEIGHT,
                    null);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
        
    }
    

    public static void main(String[] args) {
        
        new Game();
        
    }
    

    
}
