package Shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class MyShape implements MyShapePositionInterface {
	
   static boolean doOverLap = false;
   protected double x, y;
   protected Color color;

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
  
   //Methods to be overridden:
  
   public abstract void draw(GraphicsContext gc);
   public abstract String toString();
   
   
   // Interface Methods:
  
   @Override
   public String getPoint() {
       return "(" + getX() + ", " + getY() + ")";
   }
   
   @Override
   public void moveTo(double x, double y) {
       this.x = x;
       this.y = y;
   }
   
   @Override
   public double distanceTo(double x2, double y2) {
       return Math.sqrt(((x2 - x)*(x2 - x))+((y2 - y)*(y2 - y)));
   }

   @Override
   public MyPolygon getBoundingBox() {
       return null;
   }

   public boolean doOverlap() {
       return false;
   }

   
}