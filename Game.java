   
public class Game{
   Ball ball;
   Paddle paddle; 
   Block block;
   Node first;
   Node last;
   boolean hasWon = false;   
  
   // a is y coordinate of row 1, b is row two
   public Game (Ball ball, Paddle paddle, int a, int b){ 
      PennDraw.clear(PennDraw.BLACK);
      PennDraw.setXscale(0,100);
      PennDraw.setYscale(0,100);
      this.ball = ball;
      this.paddle = paddle; 
      this.first = new Node(0,0,null);
      
      
      Node[] node = new Node[18];
      last = new Node(95, a, null);
      Node head = new Node(5, a, last);
      first.next = head;
   
      int x = 15;
      int y = a;
      int i = 0;
      
      for (Node n = head; n.next!= null; n = n.next){
         if (i < 17) { 
            if (i == 8){
               x = 3;
               y = b;
            }           
            node[i] = new Node(x, y, null);
            n.insertNode(node[i]);
            x+=10;
            i++;  
         }
         
      
      }
         
      /*   if(first.recursiveSize() == 1)
            hasWon = true;
      }
         
     /* while (hasWon == true){
         PennDraw.disableAnimation();
         PennDraw.clear();
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.setFontSize(20);
         PennDraw.setFontBold();
         PennDraw.text(50, 50, "YOU WIN !!! :(");
      }*/  
          
   } 
     
   
   // a is y cordinate 4 units lower than the lowest row
   public void build(int a){             
      if (ball.getY() >= 87){
         Node k = first.isHit(ball.getX(), ball.getY());
         //System.out.println(k); debugging
         first.deleteNode(k);
         
         if (k != null){ 
            ball.bounceUp();
         }
         //System.out.println(first);
      }
       
      block = new Block(first);
      block.draw(first.next);   
   }
   
   // this method actually runs the game.
  // the ball, paddle and blocks are made to interact here. 
   public void simulate(){
     
      while (ball.getX() <= 100 && paddle.getY() <=100 && ball.getY() > 0){
         paddle.move();
         if (ball.getY() < 5) paddleCheck(); // only want to check below 5
         ball.move();          
         PennDraw.enableAnimation(30); 
         PennDraw.clear(PennDraw.BLACK);
         build(96);
         ball.drawBall(); 
         paddle.draw();
         PennDraw.advance();
      }
      PennDraw.disableAnimation();
      if (ball.getY() < 1){
         PennDraw.clear();
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.setFontSize(20);
         PennDraw.setFontBold();   
         PennDraw.text(50, 50, "YOU LOSE !!! :(");
      }
         
   }

   public void paddleCheck(){
   // this will be a helper method for simulate
   //this function will calculate based on x and y as the center of the paddle      
      int w = paddle.getW();
      if ((ball.getX() >= (paddle.getX() - w)) && (ball.getX() <= (paddle.getX() + w))
         && (ball.getY() <= 5)){
         ball.bounceUp();  
      }
   }
  


   public static void main(String[] args){
      Ball baller = new Ball();
      Paddle paddle = new Paddle(50,0,0); 
      Game game = new Game(baller, paddle, 96, 91);     
      game.simulate();
   }
}
