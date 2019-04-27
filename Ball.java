public class Ball {

   private double x;
   private double y;
   private double vx = 1;
   private double vy = 1;
   private Paddle p = new Paddle(50,0,0); 
   
 public Ball(){
      this.x = 50;
      this.y = 60;
   }

   public void drawBall(){
   
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
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
      PennDraw.enableAnimation(30);         
      x += vx;
      y += vy;
      drawBall();
            
      if (x > 99 || x < 1)
         vx= -vx;
         
      if (y > 99)
         vy= -vy;
          
      PennDraw.advance();
      
      
   }
   public static void main(String[] args) {
      Ball ball = new Ball();
      while (true)
         ball.move();   
   }
   /*public void paddleCheck(Paddle p){
   // this will be a helper method and ill add this to move
   //this function will calculate based on the center of the paddle
   // set level in paddle we might have to change the math based on l        
      int w = p.getW;
      if ((this.x >= (p.getX() - w)) && (this.x <= (p.getX() + w))
         && (this.y <= 2)){
         this.vy= -this.vy;  
      }
   }*/

}
