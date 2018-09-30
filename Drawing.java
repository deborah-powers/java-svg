package svg;

import myUtils.File;
import myUtils.Text;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Drawing extends Rectangle{
	ArrayList<Rectangle> listRectangle = new ArrayList<Rectangle>();


	public void toFile (String svgFile){
		String strDrawing = toString();
		File file = new File (svgFile, strDrawing);
		file.toFile();
	}
	public String subString (String text, String wordStart, String wordEnd){
		int d= text.indexOf (wordStart);
		int f= text.indexOf (wordEnd, d);
		String subStr = text.substring (d,f);
		return subStr;
	}

	public String fromFile (String svgFile){
		// récupérer le texte
		File file = new File (svgFile);
		String strDrawing = file.fromFile();
		// découper le texte pour extraire les lignes
		Scanner scnDrawing = new Scanner (strDrawing).useDelimiter ("<");
		String strTmp = scnDrawing.next();	// en-tête xml
		// les dimension de l'image
		strTmp = scnDrawing.next();			// en-tête svg avec les dimension de l'image
		Text textTmp = new Text (strTmp);
		strTmp = textTmp.subString ("width", ">");
		Scanner reader = new Scanner (strTmp).useDelimiter ("\"");
		strTmp = reader.next();
		width = reader.nextInt();
		strTmp = reader.next();
		height = reader.nextInt();
		reader.close();
		// le css
		// 1) éliminer les marqueurs inutiles
		strTmp = scnDrawing.next();			// en-tête style
		strTmp = scnDrawing.next();
		textTmp = new Text (strTmp);
		strTmp = textTmp.subString ("{", "}");
		// 2) récupérer les valeurs
		reader = new Scanner (strTmp).useDelimiter (": ");
		strTmp = reader.next();
		strTmp = reader.next();
		int f= strTmp.indexOf (";");
		colFill = strTmp.substring (0,f);
		strTmp = reader.next();
		f= strTmp.indexOf (";");
		colStroke = strTmp.substring (0,f);
		strTmp = reader.next();
		f= strTmp.indexOf (";");
		strTmp = strTmp.substring (0,f);
		strokeWidth = Integer.parseInt (strTmp);
		reader.close();
		// les formes




	//	System.out.println (strDrawing);
		scnDrawing.close();
		return strDrawing;
	}

	public void fromString(){}
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