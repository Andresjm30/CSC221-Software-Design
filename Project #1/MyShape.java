package Shape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public abstract class MyShape {
   public double getX() {
       return x;
   }
   public double getY(){
       return y;
   }
   public Color getColor() {
       return color;
   }
   public void setX(float x) {
       this.x = x;
   }
   public void setY(float y) {
       this.y = y;
   }
   public void setColor(Color color) {
       this.color = color;
   }
   /*
   Methods to be overridden
   */
   public abstract void draw(GraphicsContext gc);
   public abstract String toString();


   protected double x, y;
   protected Color color;

}