package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyShape {

   protected double width, height, radius;

   public MyOval(){}
   public MyOval(double originX, double originY, double width, double height, Color color) {
       this.x = originX - (width / 2);     //(x, y) is actually the upper left bound so it is converted
       this.y = originY - (height / 2);
       this.height = height;
       this.width = width;
       this.color = color;
       this.radius = Math.min(width, height);
   }
   
   @Override
   public void draw(GraphicsContext gc) {
       gc.setFill(color);
       gc.fillOval(x, y, width, height);
   }

   @Override
   public String toString() {
       return "Center: (" + x + ", " + y + ") " +
               "Width: " + width +
               "Height: " + height;
   }
   
   @Override
   public MyPolygon getBoundingBox() {
       MyPolygon poly = new MyPolygon(x, y, 5, height, color, color);
       return poly;
   }


   
}
