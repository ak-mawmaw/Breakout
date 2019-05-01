public class Game{
   Ball ball;
   Paddle paddle; 
   Block block;
   Node first;
   boolean hasWon = false;

   
  

   public Game (Ball ball, Paddle paddle, int a){
      PennDraw.clear(PennDraw.BLACK);
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
      this.ball = ball;
      this.paddle = paddle; 
      this.first = new Node(0,0,null);
      
      
      Node[] node = new Node[18];
      Node last = new Node(95, a, null);
      Node head = new Node(5, a, last);
      first.next = head;
   
      int x = 15;
      int y = 96;
      int i = 0;
      
      for (Node n = head; n.next!= null; n = n.next){
         if (i != 8) { 
            node[i] = new Node(x, y, null);
            n.insertNode(node[i]);
            x+=10;
            i++;  
         }
      
         
         if(first.recursiveSize() == 1)
            hasWon = true;
      }
         
      while (hasWon == true){
         PennDraw.disableAnimation();
         PennDraw.clear();
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.setFontSize(20);
         PennDraw.setFontBold();
         PennDraw.text(50, 50, "YOU WIN !!! :(");
      }
   
          
   } 
     
   
   // call new node make recursive call 
   // we might have to buld the nodes backwards and the one it takes in will be the 
   //next 
   public void build(int a){ // a is y cordinate of row
     // PennDraw.enableAnimation(30);
               
      if (ball.getY() >= 92){
         Node k = first.isHit(ball.getX(), ball.getY());
         ball.bounceUp();
         //System.out.println(k);
         first.deleteNode(k); 
         //System.out.println(first);
       
         block = new Block(first);
      //block.draw(head);
         block.draw(first.next);
      //PennDraw.advance();
      }
   }
         

   // this method actually runs the game.
   // the ball, paddle and blocks are made to interact here. 
   public void simulate(){
     
      while (ball.getX() <= 100 && paddle.getY() <=100 && ball.getY() != 0){
         paddle.move();
         if (ball.getY() < 5) paddleCheck(); 
         ball.move();
         
         
         PennDraw.enableAnimation(30); 
         PennDraw.clear(PennDraw.BLACK);
         build(96);
         //block.draw(first.next);
         ball.drawBall(); 
         paddle.draw();
         PennDraw.advance();
      }
      PennDraw.disableAnimation();
      if (ball.getY() == 0){
         PennDraw.clear();
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.setFontSize(20);
         PennDraw.setFontBold();
         PennDraw.text(50, 50, "YOU LOSE !!! :(");
      }
   }

   public void paddleCheck(){
   // this will be a helper method and ill add this to move
   //this function will calculate based on the center of the paddle
   // set level in paddle we might have to change the math based on l        
      int w = paddle.getW();
      if ((ball.getX() >= (paddle.getX() - w)) && (ball.getX() <= (paddle.getX() + w))
         && (ball.getY() <= 5)){
         ball.bounceUp();  
      }
   }
  


   public static void main(String[] args){
      Ball baller = new Ball();
      Paddle paddle = new Paddle(50,0,0); 
      Game game = new Game(baller, paddle, 96);
      //Game gamer = new Game(baller, paddle, 91);
      
      game.simulate();
   }
}
