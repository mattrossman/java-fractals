import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FractalPanel extends JPanel { 

   private double graphWidth = 3;
   private double graphHeight = graphWidth;
   private Complex origin = new Complex(-2,-1.5);
   
   int pixSize = 1;
   int maxIterations = 15;

   public FractalPanel() {
   
   
   }
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      
      drawFractal(g);
   }
   
   private void drawFractal(Graphics g){
      Complex thisPoint;
      for (int x=pixSize/2; x<getWidth(); x+=pixSize){
         for (int y=pixSize/2; y<getHeight(); y+=pixSize){
            thisPoint = new Complex(origin.getX()+(double)x/getWidth()*graphWidth,
                                    origin.getY()+(double)y/getHeight()*graphHeight);
            
            setFractalColor(g,thisPoint);
            
            g.fillRect(x-pixSize/2,y-pixSize/2,pixSize,pixSize);      
         
         }
      
      }
   }
   
   private void setFractalColor(Graphics g, Complex c) {
      if (c.iterateMandlebrot(maxIterations)<=maxIterations)
         g.setColor(Color.RED);
      else
         g.setColor(Color.BLACK);
   }

}