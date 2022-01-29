package Shape;

public interface MyShapePositionInterface extends MyPositionInterface{
	   MyPolygon getBoundingBox();
	   boolean doOverlap();
	}
