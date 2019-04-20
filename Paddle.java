public class Paddle{
// x , y are the coordinates of the left side of the bat
   public double x;
   public double y = 0;
   public int level;
   
   public Paddle(double x, double y){
      this.x = x;
      this.y = y;
      draw();
      move();
   }
   
 // getters for x and y 
   public double getX(){
      return this.x;
   }

   public double getY(){
      return this.y;
   } 
   
   public int getL(){
      return this.level;
   } 
   
   public void draw(){
      PennDraw.clear();
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.setPenRadius(0.02);
      PennDraw.line(x - 10 , y, x + 10, y);
   }
   
   //moves the bat along the screen
   public void move(){
   
      while (true){
         char k;
         String s;
         if (PennDraw.hasNextKeyTyped() == true){
            k = PennDraw.nextKeyTyped();
            s = String.valueOf(k);
            if ((s.equals("l") || s.equals("L") )&& x != 90){
               x+= 10;
               draw();
            }
            else if ((s.equals("j") || s.equals("J")) && x != 10){
               x-= 10; 
               draw();
            }
         }
      }
   }
   public static void main (String[] args){
   //PennDraw.enableAnimation(30);
      Paddle longbat = new Paddle(50, 0);
      //Ball ball = new Ball();
      //PennDraw.advance();
      
      
   }
}


