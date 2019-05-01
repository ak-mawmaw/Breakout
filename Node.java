public class Node {
    
   private int x;
   public int y;
   public Node next; 
   private int size;
 
   public void setup(int x, int y, Node next) {
      this.x = x;
      this.y = y;
      this.next = next; 
   } 
    
    // constructor 
   public Node(int x, int y, Node next){
      setup(x, y, next);
   }
   public Node (int x, Node next){
      setup(x, 0, next);
   }
    
   public Node(Node next){
      setup(0,0, next);
   }

   public void insertNode(Node n){
      n.next = next;
      next = n;
   }
   public int getX(){
      return x;
   }
   
   public int getY(){
      return y;
   } 

   public void deleteNode(Node n){    
      if (this == null){
         return;
      }
      for (Node d = this; d.next != null; d = d.next) {
         if( d.next.equals(n)){
            d.next = d.next.next;
         }
      }
           
   }
    
   public String toString(){
      String s = "(" + x + "," + y + ")";
      if (next != null)
         s +=  "->" + next;
      return s;
   }
   
   // returns the node of the block that has been hit
   public Node isHit(double x, double y){
      for (Node d = this; d.next!= null; d = d.next){
         if (d.equals(null)) 
            return null;
         System.out.println(d.x + " " + x +" " + d.y + " " + y);
         if (Math.abs(d.x - x) <= 4 && Math.abs(d.y - y) <= 5){
         size --;
          return d;
         } 
      }
      return null;
   }
   
   public int recursiveSize(){
   if (this == null) return 0;
   if (next == null) return 1;
   size = 1 + next.recursiveSize();
   return size;
   }

   public static void main (String[] args){
      Node[] node = new Node[10];
      Node last = new Node(95, 96, null);
      Node head = new Node(5, 96, last);
      //Node k = new Node(1,1,null);
      int x = 15;
      int y = 96;
      int i = 0;
      
      for (Node n = head; n.next!=null; n = n.next){
         if (i != 8){
            node[i] = new Node(x, y, null);
            n.insertNode(node[i]);
            x+=10;
            i++;
         }
         
        
         
      }
      head.deleteNode(node[5]);
      System.out.println(head.recursiveSize());
      System.out.println(head);
   }
}

    











