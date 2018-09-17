package svg;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Polygone extends Polyline{
	public String toString(){
		String strFigure = super.toString();
		strFigure = strFigure.replaceAll ("polyline", "polygon");
		return strFigure;
	}
	public Polygone  (double posX, double posY, double width, double height, String colFill, String colStroke, int strokeWidth){
		super (posX, posY, width, height, colFill, colStroke, strokeWidth); }
	public Polygone  (double posX, double posY, double width, double height, String colFill, String colStroke){
		super (posX, posY, width, height, colFill, colStroke); }
	public Polygone  (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Polygone (){ super(); }
}