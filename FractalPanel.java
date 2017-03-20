import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.*;


import javax.swing.JPanel;
import javax.swing.Timer;

public class FractalPanel extends JPanel implements ActionListener{ 

   private double graphWidth = 3;
   private double graphHeight = graphWidth;
   private Complex origin = new Complex(-2,-1.5);
   private TreeMap<Pixel,Integer> fracTable = new TreeMap<Pixel,Integer>();
   
   int pixSize = 128;
   int maxIterations = 255;
   int fps = 20;
   
   public FractalPanel() {
      Timer timer = new Timer(1000/fps,this);
      timer.start();
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
      int iterationsHere = c.iterateMandlebrot(maxIterations);
      if (iterationsHere<=maxIterations){
         g.setColor(new Color(iterationsHere,0,0));
      }   
      else
         g.setColor(Color.BLACK);
   }
   
   public void actionPerformed(ActionEvent e){
      if (pixSize>1){
         pixSize/=2;
         repaint();
      }
   }

}