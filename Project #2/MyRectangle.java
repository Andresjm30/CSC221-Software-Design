package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyShape {
   private double width, height;
   public MyRectangle(double originX, double originY, double width, double height, Color color) {
       this.x = originX - (width / 2);     
       this.y = originY - (height / 2);
       this.width = width;
       this.height = height;
       this.color = color;
   }
   
   @Override
   public void draw(GraphicsContext gc) {
       gc.setFill(color);
       gc.fillRect(x, y, width, height);
   }

   @Override
   public String toString() {
       return "Center: (" + x + ", " + y + ") " +
               "Width: " + width +
               "Height: " + height +
               "Area: " + width * height;
   }
   
   @Override
   public MyPolygon getBoundingBox() {
       MyPolygon rec = new MyPolygon(x, y, 5, height, color, color );
       return rec;
   }

   
}