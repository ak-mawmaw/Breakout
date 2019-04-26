public class Ball {

   public double x;
   public double y;
   public double vx = 1;
   public double vy = 1;
   
   public Ball(){
      this.x = 50;
      this.y = 0;
   }

   public void drawBall(){
   
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
      PennDraw.setPenRadius(2);
      PennDraw.setPenColor(PennDraw.BLACK);
      PennDraw.filledCircle(x, y, 2);
   
   }
       

   public void move() {
      PennDraw.enableAnimation(30);         
            x += vx;
            y += vy;
            drawBall();
            
            if (x > 99 || x < 1)
               vx= -vx;
         
            if (y > 99 || y < 1)
               vy= -vy;
          
          PennDraw.advance();
      
      
   }
   public static void main(String[] args) {
      Ball ball = new Ball();
      while (true)
      ball.move();   
   }
   public void paddleCheck(Paddle p){
   // this will be a helper method and ill add this to move
   //this function will calculate based on the center of the paddle
   // set level in paddle we might have to change the math based on l        
   int w = p.getL();    
      if ((this.x >= (p.getX() - .5 * w)) && (this.x <= (p.getX() + .5 * w))
         && (this.y <= p.getY())){
            this.vy= -this.vy;  
      }
   }

}
