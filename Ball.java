public class Ball {

   private double x;
   private double y;
   private double vx = 1;
   private double vy = 1;
   
   // constructor creates a ball that starts at the bottom 
   //of the screen
   public Ball(){
      this.x = 90 * Math.random();
      this.y = 80 * Math.random();
   }

   // draw the ball on teh screen
   public void drawBall(){
   
      //PennDraw.setXscale(0,100);
      //PennDraw.setYscale(0,100);
      PennDraw.setPenRadius(2);
      //PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.filledCircle(x, y, 2);
   
   }
   
   // return the x value
   public double getX(){
   return this.x;
   }
   
   //return the y value
   public double getY(){
   return this.y;
   }
   
    
   // ball should bounce up if it hits the paddle.
   public void bounceUp(){
   vy = -vy;
   }  

   // ball should move in the opposite direction if we hit the side of a block
   public void bounceDown(){
      vx = -vx;
   }

   public void move() {
      //PennDraw.enableAnimation(30);         
      x += vx;
      y += vy;
      //drawBall();
      // collision logic specifically for the walls
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
