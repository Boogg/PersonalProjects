
package milkrun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player extends GameObject{
    
    int width, height;
        
        
  public Player(float x, float y, ID id){
      super(x,y,id);
  }
    
   
//  private void BufferImage(){
// 
//    BufferedImage  cowImage= null;
//  
//    try{
//     cowImage = ImageIO.read(new File("C:/ImageTest/pic2.jpg"));
//    }
//    catch(IOException e){
//      e.printStackTrace();
//    }
//  }
  
  
    @Override
    public void tick(){
    }
        @Override
    public void render(Graphics g){
        if(id == ID.Player) g.setColor(Color.blue);
        
        g.fillRect((int)x, (int)y, (int)width, (int)height);
        
    }
}

