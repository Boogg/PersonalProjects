
package spacefighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Travis
 */
public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i=0;i<handler.objects.size();i++){
            GameObject tempObject = handler.objects.get(i);
            
            if(tempObject.getID() == ID.Player){
                //key Events
                
                if(key == KeyEvent.VK_SPACE){
                    if(!tempObject.fired){
                        tempObject.setFired(true);

                    }
                }
                
//                if(key == KeyEvent.VK_W){
//                    tempObject.setAcceleration(0.5f);
//                }
//                
//                if(key == KeyEvent.VK_S){
//                    tempObject.setAcceleration(0.5f*(-1));
//                }
                
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i=0;i<handler.objects.size();i++){
            GameObject tempObject = handler.objects.get(i);
            
            if(tempObject.getID() == ID.Player){
                //key Events
                
                if(key == KeyEvent.VK_SPACE){
                    tempObject.setFired(false);
                }
                
//                if(key == KeyEvent.VK_W){
//                    tempObject.setAcceleration(0);
//                }
//                if(key == KeyEvent.VK_S){
//                    tempObject.setAcceleration(0);
//                }
 
            }
        }
    }
}

