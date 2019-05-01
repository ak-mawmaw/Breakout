public class Game{
   Ball ball;
   Paddle paddle; 
   Block block;
  // Node head;
 //  Node last;

   public Game (Ball ball, Paddle paddle){
      this.ball = ball;
      this.paddle = paddle; 
      head = new Node(block, null);
      last = new Node(block);
      
   }
   // call new node make recursive call 
   // we might have to buld the nodes backwards and the one it takes in will be the 
   //next 
   public void build(int a){ // a is number of rows 
   
     //* Node k = new Node(block);
      if (last == null)
         head.next = last;
      
      else{
         PennDraw.enableAnimation(30);
         if (a == 0)
            return;
         for (Node n = head; n.next!= null; n = n.next){
            int i = 0;
            int y = 96;
            Block [] b = rowOfBlocks(y); 
            k = new Node(b[i], n.next);
            n.insertBlock(k);
            if (i == 9){
               y-=4;
               i = 0;
               a--;
            }
               
            i++;
            PennDraw.advance();
         }
      
      }
   }
// if the x coordinate of the block is 95, end,

   

   // this method actually runs the game.
   // tha ball, paddle and blocks are made to interact here. 
   public void simulate(){
      PenDraw.clear(0,0,0)
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
      if (block.getX() >= block.getLc() && (ball.getX() <= block.getRc()) && (ball.getY() 
      >= block.getBy()) && (ball.getY() <= block.getTy())) {
         ball.bounce(); 
      }
   
   }

   public static void main(String[] args){
      Ball baller = new Ball();
      Paddle paddle = new Paddle(50,0,0); 
      Game game = new Game(baller, paddle);
      game.simulate();
      game.build(10);
   }
}
