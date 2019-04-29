public class Paddle{
// x , y are the coordinates of the left side of the bat 
   public int x;
   public int y = 0;
   public int level;
   public int width = 10 - (2 * level);
   
   public Paddle(int x, int y, int level){
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
      //PennDraw.clear();
      //PennDraw.setXscale(0,100);
      //PennDraw.setYscale(0,100);
      PennDraw.setPenColor(PennDraw.RED);
      PennDraw.setPenRadius(0.02);
      PennDraw.line(x - width, y, x + width , y);
   }
   
   //moves the bat along the screen
   public void move(){
      char k;
      String s;
      //draw();
      //PennDraw.enableAnimation(30);
      if (PennDraw.hasNextKeyTyped() == true){
         k = PennDraw.nextKeyTyped();
         s = String.valueOf(k);
         if ((s.equals("l") || s.equals("L") )&& x != 90){
            x+= 10;
            //draw();
         }
         else if ((s.equals("j") || s.equals("J")) && x != 10){
            x-= 10; 
            //draw();
         }
         //PennDraw.advance();
      }
      //draw();

      
   }
 
}
