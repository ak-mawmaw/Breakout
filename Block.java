public class Block{
    //instance variables 
   private int x;
   private int y;
   private int xlc = x - 5; // because full width of block is ten 
   private int xrc = x + 5; 
   private int ytc = y + 2; // because full height of block is 4 
   private int ybc = y - 2;

    // getters for left corner and right corner
   public int getLc() { 
      return this.xlc;
   }

   public int getRc() { 
      return this.xrc;
   }

    //getters for top y coordinate and bottom y coordinate of block 
   public int getTy() { 
      return this.ytc;
   }

   public int getBy() { 
      return this.ybc;
   }
   public int getX(){
      return x;
   }
    
   public int getY(){
      return y;
   }

    //constructor 
   public Block(int x, int y){
      this.x = x;
      this.y = y;
   }
   
   public void draw(int x, int y){
   
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0, 100);
      double z = Math.random();
      if (z < .33 ) { 
         PennDraw.setPenColor(PennDraw.GREEN);
         PennDraw.filledRectangle (x, y, 5, 2);
      } 
   
      if (z < .66 && z >= .33 ) {   
         PennDraw.setPenColor(PennDraw.RED);
         PennDraw.filledRectangle (x, y, 5, 2);
      }
   
      if (z >= 0.66 && z < 1) {
         PennDraw.setPenColor(PennDraw.YELLOW);
         PennDraw.filledRectangle (x, y, 5, 2);
      }
   
   
   }
   public String toString(){
      String s = "";
   
      s += x + " " + y + " ";
   
      return s; 
   }
   

   public static void main(String[] args){
      Block block = new Block(50, 50);
      System.out.println(block);
   } 
}