public class Game{
   Ball ball;
   Paddle paddle; 
   Block block;
   Node head;
   Node last;

   public Game( Ball ball, Paddle paddle){
      this.ball = ball;
      this.paddle = paddle; 
      head = new Node(Block a, null);
      
   }
   // call new node make recursive call 
   public void build(Node n, int a){
      r = a/10; 
      c = a;
      if ( r ==0 ){
         return; 
      }
      if (c % 10 == 0 ) {
         y -= 4;
      }
      if (n.block.getx() == 95){
         r-=1;
      }
      c--; 
   }
// if the x coordinate of the block is 95, end,

   public void simulate(){
   
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);  
      while (ball.getX() <= 100 && paddle.getY() <=100){
         //PennDraw.setXscale(0, 100);
         //PennDraw.setYscale(0,100);
         paddle.move();
         if (ball.getY() < 5) paddleCheck(); 
         ball.move();
         
         PennDraw.enableAnimation(30); 
         PennDraw.clear();
         ball.drawBall();
         paddle.draw();
         PennDraw.advance();
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
   // we will check the height of the ball before we call this, not inside
   // cchange this to check with the nodes, not a block 
   public void blockCheck(){
      if (ball.getX() >= block.getLc()) && (ball.getX() <= block.getRc()) && (ball.getY() 
      >= block.getBy()) && (ball.getY() <= block.getTy()) {
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
