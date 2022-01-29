package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyPolygon extends MyShape {

   private int number_sides;
   private double radius;
   private Color color2;
   private double sideLength;

   public MyPolygon(double x, double y, int number_sides, double radius, Color color, Color color2) {
       this.x = x;
       this.y = y;
       this.color = color;
       this.color2 = color2;
       this.number_sides = number_sides;
       this.radius = radius;
   }
   
   @Override
   public void draw(GraphicsContext gc) {
       MyCircle outerCircle = new MyCircle(x, y, radius, color2);
       double[] pointsX = new double[number_sides];
       double[] pointsY = new double[number_sides];

       double angleStep = Math.PI * 2 / number_sides;
       double angle = 0;
       for (int i = 0; i < number_sides; i++, angle += angleStep) {

           pointsX[i] = -Math.sin(angle) * radius + x; // x coordinate of the point, the negative rotates the shape to the correct orientation
           pointsY[i] = -Math.cos(angle) * radius + y;// y coordinate of the point
       }

       outerCircle.draw(gc);
       gc.setFill(color);
       gc.fillPolygon(pointsX, pointsY, number_sides);
   }
   
   @Override
   public String toString() {
       sideLength = 2 * radius * Math.tan(Math.PI / number_sides);
       return  "Side length: " + sideLength +
               " Interior angle: " + (180 - (Math.PI * 2 / number_sides) / (Math.PI/180)) +
               " Perimeter: " + sideLength * number_sides +
               " Area: " + ((radius * radius) * number_sides * Math.sin(360 / number_sides)) / 2;
   }
   
   private boolean valueInRange(double value, double min, double max) {
       return (value >= min) && (value <= max);
   }

   public boolean doOverlap(MyPolygon B) {
       boolean xOverlap = valueInRange(this.x, B.x, B.x + B.radius) ||
               valueInRange(B.x, this.x, this.x + this.radius);

       boolean yOverlap = valueInRange(this.y, B.y, B.y + B.radius) ||
               valueInRange(B.y, this.y, this.y + this.radius);

       return xOverlap && yOverlap;
   }

   
}
