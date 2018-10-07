package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class Ellipse extends Rectangle{
	MessageFormat template = new MessageFormat ("<ellipse cx=\"{0}\" cy=\"{1}\" rx=\"{2}\" ry=\"{3}\" {4}/>");

	public String toString(){
		// modifier les coordonnees pour les adapter a l'ecriture du cercle
		width /=2; height /=2;
		posX += width; posY += height;
		Object[] listFields = setFields();
		String strFigure = template.format (listFields);
		return strFigure;
	}
	public void fromString (String strRectangle){
		Object[] listFields = template.parse (strRectangle, new ParsePosition(0));
		getFields (listFields);
		posX -= width; posY -= height;
		width *=2; height *=2;
	}
	public Ellipse  (double posX, double posY, double width, double height, String colFill, String colStroke, int strokeWidth){
		super (posX, posY, width, height, colFill, colStroke, strokeWidth); }
	public Ellipse  (double posX, double posY, double width, double height, String colFill, String colStroke){
		super (posX, posY, width, height, colFill, colStroke); }
	public Ellipse  (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Ellipse (){ super(); }
}