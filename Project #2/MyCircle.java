package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class MyCircle extends MyOval {
   public MyCircle(double x, double y, double radius, Color color) {
       this.x = x - radius;
       this.y = y - radius;
       this.color = color;
       this.radius = radius;
       this.width = radius * 2;
       this.height = radius * 2;

   }
   
   public void setRadius(double radius) {
       this.radius = radius;
   }
   
   public double getRadius() {
       return radius;
   }
   
   @Override
   public void draw(GraphicsContext gc) {
       //super.draw(gc);
	   gc.setFill(color);
       gc.fillArc(x, y, radius * 2, radius * 2, 0f, 360, ArcType.OPEN);
   }
   
   @Override
   public String toString() {
       double perimeter = 2 * Math.PI * radius;
       double area = Math.PI * (radius * radius);
       return "Radius: " + radius + " Perimeter: " + perimeter + " Area: " + area;
   }

   //private double radius;
   
   public boolean doOverlap(MyOval b) {
       if (distanceTo(b.getX(), b.getY()) < (this.radius + b.radius))
           return true;
       return false;
   }

}