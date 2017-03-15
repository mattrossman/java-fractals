// Complex number object
// Real and imaginary component

public class Complex {

   private double r;
   private double i;
   
   public Complex(double real, double imaginary){
      r = real;
      i = imaginary;
   }
   
   public double abs(){
       return Math.sqrt(r*r + i*i);
   }

}