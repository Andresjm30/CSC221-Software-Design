import Shape.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawDesign extends Application {
	
	private Color[] colorsArray = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLUEVIOLET,
	           Color.RED, Color.AQUA, Color.CRIMSON, Color.CHOCOLATE};
	
	public void xWithLines(GraphicsContext gc) {
	       double height = gc.getCanvas().getHeight();
	       double length = gc.getCanvas().getWidth();

	       MyLine line1 = new MyLine(0, 0, 0, height, Color.BLACK);
	       MyLine line2 = new MyLine(0, 0, length, 0, Color.BLACK);
	       MyLine line3 = new MyLine(0, 0, length, height, Color.BLACK);
	       MyLine line4 = new MyLine(length, 0, length, height, Color.BLACK);
	       MyLine line5 = new MyLine(length, 0, 0, height, Color.BLACK);
	       MyLine line6 = new MyLine(0, height, length, height, Color.BLACK);

	       line1.draw(gc);
	       line2.draw(gc);
	       line3.draw(gc);
	       line4.draw(gc);
	       line5.draw(gc);
	       line6.draw(gc);
	   }
	
	public void polygonsCircles(GraphicsContext gc) {
	       double length = gc.getCanvas().getWidth();
	       double height = gc.getCanvas().getHeight();
	       double centerX = length / 2;
	       double centerY = height / 2;
	       double radius;
	       int colorPick = 0, colorPick2 = 7;

	       if(length <= height) {
	           radius = (length / 2) * .95;
	       }
	       else radius = (height / 2) * .95;

	       for(int i = 0; i < 3; i ++) {

	           MyPolygon poly = new MyPolygon(centerX, centerY, 5, radius, colorsArray[colorPick], colorsArray[colorPick2] );
	           poly.draw(gc);
	           radius = radius - .26 * radius;
	           colorPick ++;
	           colorPick2 --;
	       }
	       MyCircle innerCircle = new MyCircle(centerX, centerY, radius, Color.WHITE);
	       innerCircle.draw(gc);


	}


	 public void rectangleOvals(GraphicsContext gc) {
	       double canvasLength = gc.getCanvas().getWidth();
	       double canvasHeight = gc.getCanvas().getHeight();
	       double centerX = canvasLength / 2;
	       double centerY = canvasHeight / 2;
	       double height = canvasHeight * .66;
	       double width = canvasLength * .66;
	       int colorPick = 0, colorPick2 = 7;

	       for(int i = 0; i < 3; i ++) {
	           MyRectangle rect = new MyRectangle(centerX, centerY, width, height, colorsArray[colorPick]);
	           rect.draw(gc);
	           MyOval oval = new MyOval(centerX, centerY, width, height, colorsArray[colorPick2]);
	           oval.draw(gc);
	           height = height * .702;
	           width = width * .702;
	           colorPick ++;
	           colorPick2 --;
	       }
	   }

	
	   @Override
	   public void start(Stage stage)
	   {
	       Canvas canvas = new Canvas(800, 400);
	       GraphicsContext gc = canvas.getGraphicsContext2D();

	       DrawDesign x = new DrawDesign();
	       x.polygonsCircles(gc);
	       x.xWithLines(gc);
	       
	       /*
	       Testing doOverlap() function
	        */
	       MyCircle cir1 = new MyCircle(100, 100, 100, Color.GREEN);
	       MyCircle cir2 = new MyCircle(210, 210, 100, Color.GREEN);
	       MyPolygon r1 = new MyPolygon(300, 300, 5, 200, Color.AQUA, Color.RED);
	       MyPolygon r2 = new MyPolygon(650, 300, 5, 200, Color.BLUE, Color.YELLOW);
	       System.out.println(r1.doOverlap(r2));
	       System.out.println(cir1.doOverlap(cir2));


	       Pane root = new Pane();
	       root.getChildren().add(canvas);
	       Scene scene = new Scene(root);
	       stage.setScene(scene);
	       stage.setTitle("Drawing Shapes");
	       stage.show();
	   }
	}
