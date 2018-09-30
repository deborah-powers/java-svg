package svg;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Polyline extends Polygon{
	public String toString(){
		String strFigure = super.toString();
		strFigure = strFigure.replaceAll ("polygon", "polyline");
		return strFigure;
	}
	public Polyline (double[] listPointX, double[] listPointY, String colFill, String colStroke, int strokeWidth){
		super (listPointX, listPointY, colFill, colStroke, strokeWidth);
	}
	public Polyline (double[] listPointX, double[] listPointY, String colFill, String colStroke){
		super (listPointX, listPointY, colFill, colStroke);
	}
	public Polyline (double[] listPointX, double[] listPointY){
		super (listPointX, listPointY);
	}
	public Polyline(){ super(); }
}