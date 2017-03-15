import java.awt.BorderLayout;
import javax.swing.JFrame;

public class fractalViewer {
   public static void main(String[] args){
   
      JFrame viewerFrame = new JFrame("Fractal viewer");
      viewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      viewerFrame.setLayout(new BorderLayout());
      
      FractalPanel fPanel = new FractalPanel();
      viewerFrame.add(fPanel,BorderLayout.CENTER);
      
      viewerFrame.setSize(1000,1000);
      viewerFrame.setVisible(true);
   
   }

}