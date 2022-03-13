class CCircle   {
    final double pi = 3.14159;    
    double radius;
    double square;

    CCircle(int r)
    {
        radius = r;
    }
    double getSquare()
    {
        return pi* radius*radius;
    }
    double getRadius(){
        return radius;
    }
      void setCircle(double r)
    {     
          radius=r;   
    }
    }

    public class TestCCircle{
        public static void main(String args[])   {
           CCircle cir1=new CCircle();   
           cir1.setCircle(2.0);
           System.out.println("radius="+cir1.getRadius()); 
        }
     }