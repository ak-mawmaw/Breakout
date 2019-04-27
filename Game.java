public class Game{
   Ball ball;
   Paddle paddle; 

   public Game( Ball ball, Paddle paddle){
      this.ball = ball;
      this.paddle = paddle;
   }

   public void simulate(){
      while (ball.getX() <= 100 && paddle.getY() <=100){
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0,100);
         paddle.move();
         if (ball.getY()< 5) paddleCheck(); 
         ball.move();
      }
   }
    public void paddleCheck(){
   // this will be a helper method and ill add this to move
   //this function will calculate based on the center of the paddle
   // set level in paddle we might have to change the math based on l        
      int w = paddle.getW();
      if ((ball.getX() >= (paddle.getX() - w)) && (ball.getX() <= (paddle.getX() + w))
         && (ball.getY() <= 5)){
         ball.bounce();  
      }
   }

   public static void main(String[] args){
      Ball baller = new Ball();
      Paddle paddle = new Paddle(50,0,0); 
      Game game = new Game(baller, paddle);
      game.simulate();
   }
}
