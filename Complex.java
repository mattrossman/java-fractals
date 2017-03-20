// Complex number object
// Real and imaginary component

public class Complex {

   private double x,y;
   
   public Complex(){}
   
   public Complex(double x, double y){
      this.x = x;
      this.y = y;
   }
   
   public double abs(){
       return Math.sqrt(x*x+y*y);
   }
   
   public double getX(){ return x; }
   public double getY(){ return y; }
   
   public void setX(double x){ this.x=x; }
   public void setY(double y){ this.y=y; }
   
   public int iterateMandlebrot(int totalIterations){
      Complex z = new Complex(0,0);
      int iterationCount = 0;
      do {
         z = multiply(z,z);
         z = add(z,this);
         iterationCount++;
      } while (z.abs()<2 && iterationCount<=totalIterations);
      
      return iterationCount;
   
   }
   
   public static Complex multiply(Complex a, Complex b){
      Complex out = new Complex();
      
      out.setX(a.getX()*b.getX()-a.getY()*b.getY());
      out.setY(a.getX()*b.getY()+a.getY()*b.getX());
      
      return out;
   }
   
   public static Complex add(Complex a, Complex b) {
      Complex out = new Complex();
      
      out.setX(a.getX()+b.getX());
      out.setY(a.getY()+b.getY());
      
      return out;
   }

}