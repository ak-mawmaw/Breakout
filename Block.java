public class Block{
   private Node n;

    //constructor 
    //blocks take in nodes that contain the center coordinates
    //of the block
   public Block(Node n){
      this.n = n;
    
   
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0, 100);
   }
   
   //draw the blocks recursively
   public void draw(Node n){
      if (n.next == null)
         return;
      
      else{
         //draw blocks of different and random colours
         //recursive function here :)
         double x = n.getX();
         if (x < 33 ) { 
            PennDraw.setPenColor(PennDraw.GREEN);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         } 
      
         if (x < 66 && x >= 33 ) {   
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         }
      
         if (x >= 66 && x < 100) {
            PennDraw.setPenColor(PennDraw.YELLOW);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         }
        
      
      }
      
      draw(n.next);
   }   

   /*public Node isHit( int x, int y){
      for ( Node n = head; n.next != null; n = n.next){
         if (Math.abs(n.getX() - x) <= 4 || n.getY() - y <= 2)
         return n;
      } 
   }*/

   public static void main(String[] args){
      Node[] node = new Node[10];
      Node last = new Node(95, 96, null);
      Node head = new Node(5, 96, last);
      int x = 15;
      int y = 96;
      int i= 0;
     
      
      for (Node n = head; n.next!= null; n = n.next){
         if (i != 8) { 
            node[i] = new Node(x, y, null);
            n.insertNode(node[i]);
            x+=10;
            i++; 
         }
      }
      
      System.out.println(head);
      Block b = new Block(head);
      b.draw(head);
      
      
   } 
}




