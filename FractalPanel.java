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
   private boolean isCalculated = false;
   
   int pixSize = 4;
   int maxIterations = 255;
   int fps = 20;
   
   TreeMap<Pixel,Integer> fracTable = new TreeMap<Pixel,Integer>();
   
   public FractalPanel() {
      Timer timer = new Timer(1000/fps,this);
      timer.start();
   }
   
   
   public void paintComponent(Graphics g){
      super.paintComponent(g); //render first so calculations can access height and width values
      if (isCalculated==false)
         calculateMandlebrot();
      drawFractal(g,pixSize);
   }
   
   private void calculateMandlebrot(){
      Complex thisPoint;
      for (int x=0; x<getWidth(); x+=pixSize){
         for (int y=0; y<getHeight(); y+=pixSize){
            thisPoint = new Complex(origin.getX()+(double)x/getWidth()*graphWidth,
                                    origin.getY()+(double)y/getHeight()*graphHeight);
            fracTable.put(new Pixel(x,y),thisPoint.iterateMandlebrot(maxIterations));
         }   
      }
      isCalculated = true; 
   }
   
   private void refineMandlebrot(){
      pixSize/=2;
      Complex thisPoint;
      
   }
   
   private void oldDrawFractal(Graphics g){
      Complex thisPoint;
      for (int x=0; x<getWidth(); x+=pixSize){
         for (int y=0; y<getHeight(); y+=pixSize){
            thisPoint = new Complex(origin.getX()+(double)x/getWidth()*graphWidth,
                                    origin.getY()+(double)y/getHeight()*graphHeight);
            
            setFractalColor(g,thisPoint);
            
            g.fillRect(x,y,pixSize,pixSize);      
         
         }
      
      }
   }
   
   private void drawFractal(Graphics g, int pSize){
   
      for (int x=0; x<getWidth(); x+=pixSize){
         for (int y=0; y<getHeight(); y+=pixSize){
            if (fracTable.containsKey(new Pixel(x,y))) {
               int iterationsHere = fracTable.get(new Pixel(x,y));
               if (iterationsHere<=maxIterations)
                  g.setColor(new Color(iterationsHere,0,0));
               else
                  g.setColor(Color.BLACK);
                  
               g.fillRect(x,y,pSize,pSize);
            }   
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
      /*
      if (pixSize>1){
         pixSize/=2;
         repaint();
      }
      */
   }

}