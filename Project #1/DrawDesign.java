import Shape.MyLine;
import Shape.MyOval;
import Shape.MyRectangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawDesign1 extends Application {
	
	private Color[] colorsArray = {Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLUEVIOLET,
	           Color.RED, Color.AQUA, Color.CRIMSON, Color.CHOCOLATE};
	
	public void xWithLines(GraphicsContext gc) {
	       double height = gc.getCanvas().getHeight();
	       double length = gc.getCanvas().getWidth();

	       MyLine line1 = new MyLine(0, 0, 0, height, Color.BLACK);
	       MyLine line2 = new MyLine(0, 0, length, 0, Color.BLACK);
	       MyLine line3 = new MyLine(0, 0, length, height, Color.BLACK);

	       line1.draw(gc);
	       line2.draw(gc);
	       line3.draw(gc);
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
	       x.rectangleOvals(gc);
	       x.xWithLines(gc);
	       
	       MyRectangle a = new MyRectangle(500, 500, 100, 100, Color.BLACK);
	       MyLine b = new MyLine(0, 0, 45, 45, Color.RED);
	       MyOval c = new MyOval(50, 50, 10, 10, Color.AQUA);
	       System.out.println(a.toString());
	       System.out.println(b.toString());
	       System.out.println(c.toString());

	       Pane root = new Pane();
	       root.getChildren().add(canvas);
	       Scene scene = new Scene(root);
	       stage.setScene(scene);
	       stage.setTitle("Drawing Shapes");
	       stage.show();
	   }
	}