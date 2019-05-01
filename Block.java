public class Block{
   private Node n;

    //constructor 
    //blocks take in nodes that contain the center coordinates
    //of the block
   private Block(Node n){
      this.n = n;
    

   public ( Node n) // getter
      PennDraw.setYscale(0, 100);
   }
   
   //draw the blocks recursively
   public void draw(Node n){
      if (n.next == null)
         return;
      
      else{
         double z = Math.random();
         if (z < .33 ) { 
            PennDraw.setPenColor(PennDraw.GREEN);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         } 
      
         if (z < .66 && z >= .33 ) {   
            PennDraw.setPenColor(PennDraw.RED);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         }
      
         if (z >= 0.66 && z < 1) {
            PennDraw.setPenColor(PennDraw.YELLOW);
            PennDraw.filledRectangle (n.getX(), n.getY(), 4, 2);
         }
        
      
      }
      
      draw(n.next);
   }   

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
      
      
      Block b = new Block(head);
      b.draw(head);
      
      
   } 
}
