package svg;
import java.text.MessageFormat;

public class Rectangle{
	double posX=0, posY=0, width=10, height=10;
	int strokeWidth;
	String colFill, colStroke;

	public void scale (double propX, double propY){ width *= propX; height *= propY; }
	public void scale (double prop){ this.scale (prop, prop); }
	public void move (double posX, double posY){ this.posX += posX; this.posY += posY; }
	public void move (double pos){ this.move (pos, pos); }

	protected String toStringData (String strRectangle){
		/*
		if (strokeWidth !=2) strRectangle = strRectangle +" stroke-width=\""+ strokeWidth +"\"";
		if (colStroke != "maroon") strRectangle = strRectangle +" stroke=\"" + colStroke +"\"";
		if (colFill != "pink") strRectangle = strRectangle +" fill=\"" + colFill +"\"";
		*/
		if (strokeWidth !=2 || colStroke != "maroon" || colFill != "pink"){
			strRectangle = strRectangle +" style=\"";
			if (strokeWidth !=2) strRectangle = strRectangle + "stroke-width:" + strokeWidth +';';
			if (colStroke != "maroon") strRectangle = strRectangle + "stroke:" + colStroke +';';
			if (colFill != "pink") strRectangle = strRectangle + "fill:" + colFill +';';
			strRectangle = strRectangle +'"';
		}
		strRectangle = strRectangle +"/>";
		return strRectangle;
	}
	public String toString(){
		String strRectangle = MessageFormat.format ("<rect x=\"{0}\" y=\"{1}\" width=\"{2}\" height=\"{3}\"", posX, posY, width, height);
		strRectangle = toStringData (strRectangle);
		return strRectangle;
	}
	public Rectangle (double posX, double posY, double width, double height, String colFill, String colStroke, int strokeWidth){
		this.posX =posX; this.posY =posY; this.width =width; this.height =height;
		this.colFill = colFill; this.colStroke = colStroke;
		this.strokeWidth = strokeWidth;
	}
	public Rectangle (double posX, double posY, double width, double height, String colFill, String colStroke){
		this (posX, posY, width, height, colFill, colStroke, 2); }
	public Rectangle (double posX, double posY, double width, double height){
		this (posX, posY, width, height, "pink", "maroon"); }
	public Rectangle(){ this (0,0,10,10); }
}