package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.geom.Line2D;

public class MyLine extends MyShape {
   public MyLine(double x1, double y1, double x2, double y2, Color color) {
       this.x = x1;
       this.y = y1;
       this.x2 = x2;
       this.y2 = y2;
       this.color = color;
   }

   @Override
   public void draw(GraphicsContext gc) {
       gc.setStroke(color);
       gc.strokeLine(x, y, x2, y2);
   }
   
   @Override
   public String toString() {
       double length = Math.sqrt(((x2 - x) * (x2 - x)) * ((y2 - y) * (y2 - y)));
       double theta = (Math.atan2((y2 - y), (x2 - x)))/(Math.PI/180);
       return "Length: " + length + "px, Angle: " + theta;
   }
   
   public boolean doOverlap(MyLine b) {
       return Line2D.linesIntersect(this.x, this.y, this.x2, this.y2, b.x, b.y, b.x2, b.y2);
   }
   
   private double x2, y2;
}
