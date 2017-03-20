import java.awt.Point;

public class Pixel extends Point implements Comparable<Point>{
   
   public Pixel(int x, int y){
      super(x,y);
   }

   public int compareTo(Point p) {
      if (y < p.y) 
         return -1;
      if (y > p.y)
         return 1;
      if (x < p.x)
         return -1;
      if (x > p.x)
         return 1;
      return 0;
   }

}