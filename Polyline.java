package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class Polyline extends Polygon{
	MessageFormat template = new MessageFormat ("<polyline points=\"{0}\" {1}/>");

	public String toString(){
		Object[] listFields = setFields();
		String strFigure = template.format (listFields);
		return strFigure;
	}
	public void fromString (String strFigure){
		Object[] listFields = template.parse (strFigure, new ParsePosition (0));
		getFields (listFields);
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