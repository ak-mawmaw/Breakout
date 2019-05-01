public class Node {
    
   private int x;
   public int y;
   public Node next; 
 
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


   public Node deleteNode(Node n){    
      if (this.next == null){
         System.out.println("you win");
      }
      if (this.next.equals(n)){
         this.next = this.next.next;
         return n;
      }
      return deleteNode(this.next);
   }
    
   public String toString(){
      String s = "(" + x + "," + y + ")";
   if (next != null)
      s +=  "->" + next;
      return s;
   }

   public static void main (String[] args){
      Node[] node = new Node[10];
      Node last = new Node(95, 96, null);
      Node head = new Node(5, 96, last);
      Node k = new Node(1,1,null);
      int x = 15;
      int y = 96;
      int i = 0;
      
      for (Node n = head; n.next!=null; n = n.next){
         if (i == 10) return;
         k = new Node(x, y, null);
         n.insertNode(k);
         x+=10;
         System.out.print(n);
         i++;
      }
   }
}

    






