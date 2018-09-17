package svg;
import java.text.MessageFormat;

public class Ellipse extends Rectangle{
	public String toString(){
		// modifier les coordonnees pour les adapter a l'ecriture du cercle
		width /=2; height /=2;
		posX += width; posY += height;
		String strFigure = MessageFormat.format ("<ellipse cx=\"{0}\" cy=\"{1}\" rx=\"{2}\" ry=\"{3}\"", posX, posY, width, height);
		if (width == height) strFigure = MessageFormat.format ("<circle cx=\"{0}\" cy=\"{1}\" r=\"{2}\"", posX, posY, width);
		strFigure = toStringData (strFigure);
		return strFigure;
	}
	public Ellipse  (double posX, double posY, double width, double height, String colFill, String colStroke, int strokeWidth){
		super (posX, posY, width, height, colFill, colStroke, strokeWidth); }
	public Ellipse  (double posX, double posY, double width, double height, String colFill, String colStroke){
		super (posX, posY, width, height, colFill, colStroke); }
	public Ellipse  (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Ellipse (){ super(); }
}