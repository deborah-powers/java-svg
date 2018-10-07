package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class Rectangle{
	double posX=0, posY=0, width=10, height=10;
	int strokeWidth;
	String colFill, colStroke;
	MessageFormat template = new MessageFormat ("<rect x=\"{0}\" y=\"{1}\" width=\"{2}\" height=\"{3}\" {4}/>");

	public void scale (double propX, double propY){ width *= propX; height *= propY; }
	public void scale (double prop){ this.scale (prop, prop); }
	public void move (double posX, double posY){ this.posX += posX; this.posY += posY; }
	public void move (double pos){ this.move (pos, pos); }

	public String toString(){
		Object[] listFields = setFields();
		String strFigure = template.format (listFields);
		return strFigure;
	}
	public void fromString (String strRectangle){
		Object[] listFields = template.parse (strRectangle, new ParsePosition(0));
		getFields (listFields);
	}
	protected Object[] setFields(){
		String strStyle = setStyle();
		Object[] listFields ={ posX, posY, width, height, strStyle };
		return listFields;
	}
	protected void getFields (Object[] listFields){
		// récupérer les dimensions
		posX = Double.parseDouble ((String) listFields[0]);
		posY = Double.parseDouble ((String) listFields[1]);
		width = Double.parseDouble ((String) listFields[2]);
		height = Double.parseDouble ((String) listFields[3]);
		// récupérer le style
		String strStyle = (String) listFields[4];
		getStyle (strStyle);
	}
	protected String setStyle(){
		String strStyle ="";
		if (strokeWidth !=2 || colStroke != "maroon" || colFill != "pink"){
			strStyle = "style=\"";
			if (strokeWidth !=2) strStyle = strStyle + "stroke-width:" + strokeWidth +';';
			if (colStroke != "maroon") strStyle = strStyle + "stroke:" + colStroke +';';
			if (colFill != "pink") strStyle = strStyle + "fill:" + colFill +';';
			strStyle = strStyle +"\" ";
		}
		return strStyle;
	}
	protected void getStyle (String strStyle){
		if (strStyle.equals ("")) return;
		// préparer la chaine de style, éliminer style="truc important;"
		int endString = strStyle.length() -3;
		strStyle = strStyle.substring (7, endString);
		// créer les variables utilisées plus loin
		Scanner style = new Scanner (strStyle).useDelimiter (";");
		Scanner tmpStyle =null;
		String strTmp =null;
		String[] listTmp =null;
		String field =null;
		while (style.hasNext()){
			strTmp = style.next();
			listTmp = strTmp.split (":");
			field = listTmp[0];
			switch (field){
				case "stroke-width":
					strokeWidth = Integer.parseInt (listTmp[1]);
					break;
				case "stroke":
					colStroke = listTmp[1];
					break;
				case "fill":
					colFill = listTmp[1];
			}
		}
		style.close();
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