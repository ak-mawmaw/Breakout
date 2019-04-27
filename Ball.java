
   public class Paddle{
   // x , y are the coordinates of the left side of the bat
      private double x;
      private double y = 0;
      private int level;
      public int width = 10 - level; 
      
      public Paddle(double x, double y, int level){
         this.x = x;
         this.y = y;
         this.level = level;
      }
        public double getX(){
      return this.x;
       }

      public double getY(){
         return this.y;
      } 
      
      public int getW(){
         return this.width;
      } 
   
      
      public void draw(){
      PennDraw.clear();
         PennDraw.setXscale(0,100);
         PennDraw.setYscale(0,100);
         PennDraw.setPenColor(PennDraw.RED);
         PennDraw.setPenRadius(0.02);
         PennDraw.line(x - width , y, x + width, y);
      }
      
      //moves the bat along the screen
      public void move(){
         char k;
         String s;
         draw();
         PennDraw.enableAnimation(30);
         if (PennDraw.hasNextKeyTyped() == true){
            k = PennDraw.nextKeyTyped();
            s = String.valueOf(k);
            if ((s.equals("l") || s.equals("L") )&& x != 90){
               x+= 10;
               draw();
            }
            else if ((s.equals("j") || s.equals("J")) && x != 10){
               x-= 10; 
               draw();
            }
            PennDraw.clear();
            PennDraw.advance();
         }
         
      }
   public static void main(String[] args){
      Paddle paddle = new Paddle(50, 0, 0 );
      while (true)
      paddle.move();
   }
   
   }


