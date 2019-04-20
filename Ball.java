public class Ball {

   private double x;
   private double y;
   private double vx = 1;
   private double vy = 1;

   public Ball(){
      this.x = 50;
      this.y = 0;
      drawBall();  
      move();
   }
   
   // getters for x and y 
   public double getX(){
      return this.x;
   }
         
   public double getY(){
      return this.y;
   } 
   
   public void drawBall(){
      
      PennDraw.setPenRadius(2);
      PennDraw.filledCircle(x, y, 2);
   
   }
     
   public void paddleCheck(Paddle p){
   // this will be a helper method and ill add this to move
   //this function will calculate based on the center of the paddle
   // set level in paddle we might have to change the math based on l  
       
    int w = p.getL();    
      if ((this.x >= (p.getX() - .5*w)) && (this.x <= (p.getX() + .5*w))
         && (this.y <= p.getY())){
            this.vy= -this.vy;  
      }
   }

       

   public void move() {
      while (true){
         if (PennDraw.hasNextKeyTyped() == true){ 
            x += vx;
            y += vy;
            PennDraw.clear();
            drawBall();
            
            if (x > 99 || x < 1)
               vx= -vx;
         
            if (y > 99 || y < 1)
               vy= -vy;
          
         }
      }
   }
   public static void main(String[] args) {
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
      Ball ball = new Ball();   
   }
}
