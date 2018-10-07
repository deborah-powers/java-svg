package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class Line extends Rectangle{
	MessageFormat template = new MessageFormat ("<line x1=\"{0}\" y1=\"{1}\" x2=\"{2}\" y2=\"{3}\" {4}/>");

	public String toString(){
		// modifier les coordonnees pour les adapter a l'ecriture de la ligne
		width += posX; height += posY;
		Object[] listFields = setFields();
		String strFigure = template.format (listFields);
		return strFigure;
	}
	public void fromString (String strRectangle){
		Object[] listFields = template.parse (strRectangle, new ParsePosition(0));
		getFields (listFields);
		width -= posX; height -= posY;
	}
	public Line (double posX, double posY, double width, double height, String colStroke, int strokeWidth){
		super (posX, posY, width, height, "pink", colStroke, strokeWidth); }
	public Line (double posX, double posY, double width, double height, String colStroke){
		this (posX, posY, width, height, colStroke, 2); }
	public Line (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Line(){ super(); }
}