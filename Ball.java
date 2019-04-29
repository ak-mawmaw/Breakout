public class Ball {

   private double x;
   private double y;
   private double vx = 1;
   private double vy = 1;
   
   public Ball(){
      this.x = 50;
      this.y = 5;
   }

   public void drawBall(){
   
      //PennDraw.setXscale(0,100);
      //PennDraw.setYscale(0,100);
      PennDraw.setPenRadius(2);
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.filledCircle(x, y, 2);
   
   }
   
   public double getX(){
   return this.x;
   }
   
   public double getY(){
   return this.y;
   }
   
   public void bounce(){
   vy = -vy;
   }  

   public void move() {
      //PennDraw.enableAnimation(30);         
      x += vx;
      y += vy;
      //drawBall();
      
      if (x > 100) {
         x = 100;
         vx = -vx;
      } else if (x < 0) {
         x = 0;
         vx = -vx;
      } else if (y > 100) {
         y = 100;
         vy = -vy;
      }
      
      //if (x > 99 || x < 1)
      //   vx= -vx;
         
      //if (y > 99)
      //   vy= -vy;
          
      //PennDraw.advance();
      
      
   }
   public static void main(String[] args) {
      Ball ball = new Ball();
      while (true)
         ball.move();   
   }
   
   }
