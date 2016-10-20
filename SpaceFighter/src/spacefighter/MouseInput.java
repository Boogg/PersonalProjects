
package spacefighter;

/**
 *
 * @author Travis Hajagos
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseMotionListener{
    
    private Handler handler;
    
 
    
    public MouseInput(Handler handler){
        this.handler = handler;
        
        
        
    }
    
    public void tick(){
        
    }   
    
    
    @Override
    public void mouseMoved(MouseEvent e){
    int x = e.getX();
    int y = e.getY();
        for(int i=0;i<handler.objects.size();i++){
            GameObject tempObject = handler.objects.get(i);
            
            if(tempObject.getID() == ID.Player){
            //    key Events
            tempObject.setMouseX(x);
            tempObject.setMouseY(y);
            

            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    
    
}

