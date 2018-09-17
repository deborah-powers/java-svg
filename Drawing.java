package svg;
import java.text.MessageFormat;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.List;
import java.util.ArrayList;

public class Drawing extends Rectangle{
	ArrayList<Rectangle> listRectangle = new ArrayList<Rectangle>();

	public void draw (String svgFile){
		String strDrawing = toString();
		try{
			FileWriter file = new FileWriter (svgFile);
			BufferedWriter tmpFile = new BufferedWriter (file);
			tmpFile.write (strDrawing);
			tmpFile.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}
	public String toString(){
	String strListRectangle ="";
	for (Rectangle fig: listRectangle) strListRectangle = strListRectangle + fig.toString();
	String strStyle = MessageFormat.format ("\n\tfill: {0};\n\tstroke: {1};\n\tstroke-width: {2};\n\t", colFill, colStroke, strokeWidth);
	strStyle = "{"+ strStyle +"}";
	String strDrawing = MessageFormat.format ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"{0}\" height=\"{1}\">\n<style type=\"text/css\"><![CDATA[\n* {2}\n]]></style>\n{3}\n</svg>", width, height, strStyle, strListRectangle);
	return strDrawing;
	}
	public void addFigure (Rectangle fig){ listRectangle.add (fig); }
	public void addFigure(){
		Rectangle fig = new Rectangle();
		addFigure (fig);
	}
	public Drawing(){ super (0,0,800,500); }
}