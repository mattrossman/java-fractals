public class Pixel implements Comparable<Pixel>{
   
   public int x,y;
   
   public Pixel(int x, int y){
      this.x = x;
      this.y = y;
   }

   public int compareTo(Pixel p) {
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
   
   public boolean equals(Pixel p) {
      return (x==p.x && y==p.y);
   }

}