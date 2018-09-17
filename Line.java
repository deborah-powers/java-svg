package svg;
import java.text.MessageFormat;

public class Line extends Rectangle{
	public String toString(){
		width += posX; height += posY;	// modifier les coordonnees pour les adapter a l'ecriture de la ligne
		String strFigure = MessageFormat.format ("<line x1=\"{0}\" y1=\"{1}\" x2=\"{2}\" y2=\"{3}\"", posX, posY, width, height);
		strFigure = toStringData (strFigure);
		return strFigure;
	}
	public Line (double posX, double posY, double width, double height, String colStroke, int strokeWidth){
		super (posX, posY, width, height, "pink", colStroke, strokeWidth); }
	public Line (double posX, double posY, double width, double height, String colStroke){
		this (posX, posY, width, height, colStroke, 2); }
	public Line (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Line(){ super(); }
}