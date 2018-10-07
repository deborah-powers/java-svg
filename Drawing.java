package svg;

import myUtils.File;
import myUtils.Text;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Scanner;

public class Drawing extends Rectangle{
	ArrayList<Rectangle> listRectangle = new ArrayList<Rectangle>();
	MessageFormat template = new MessageFormat ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"{0}\" height=\"{1}\">\n<style type=\"text/css\"><![CDATA[\n* '{'\n\tfill: {2};\n\tstroke: {3};\n\tstroke-width: {4};\n'}'\n]]></style>\n{5}\n</svg>");

	public void toFile (String svgFile){
		String strDrawing = toString();
		File file = new File (svgFile, strDrawing);
		file.toFile();
	}
	public void fromFile (String svgFile){
		File file = new File (svgFile);
		String strDrawing = file.fromFile();
		fromString (strDrawing);
	}
	public String toString(){
		String strListRectangle ="";
		for (Rectangle fig: listRectangle) strListRectangle = strListRectangle + fig.toString();
		Object[] data ={ width, height, colFill, colStroke, strokeWidth, strListRectangle };
		String strDrawing = template.format (data);
		return strDrawing;
	}
	public void fromString (String strDrawing){
		// récupérer les données de l'image
		Object[] data = template.parse (strDrawing, new ParsePosition(0));
		width = Double.parseDouble ((String) data[0]);
		height = Double.parseDouble ((String) data[1]);
		colFill = (String) data[2];
		colStroke = (String) data[3];
		strokeWidth = Integer.parseInt ((String) data[4]);
		String strListRectangle = (String) data[5];
		// récupérer les formes
		Scanner listRectangle = new Scanner (strListRectangle).useDelimiter ("<");
		String[] tmpList =null;
		String tmpStr =null;
		String tmpFig =null;
		while (listRectangle.hasNext()){
			Rectangle shape = null;
			tmpStr = listRectangle.next();
			tmpList = tmpStr.split (" ");
			tmpFig = tmpList[0];
			switch (tmpFig){
				case "line":
					shape = new Line();
					break;
				case "ellipse":
					shape = new Ellipse();
					break;
				case "polygon":
					shape = new Polygon();
					break;
				case "polyline":
					shape = new Polyline();
					break;
				default:
					shape = new Rectangle();
			}
			shape.fromString ("<"+ tmpStr);
			addFigure (shape);
		}
		listRectangle.close();
	}
	public void addFigure (Rectangle fig){ listRectangle.add (fig); }
	public void addFigure(){
		Rectangle fig = new Rectangle();
		addFigure (fig);
	}
	public Drawing(){ super (0,0,800,500); }
}