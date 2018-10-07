package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class Polygon extends Rectangle{
	MessageFormat template = new MessageFormat ("<polygon points=\"{0}\" {1}/>");
	double[] listPointX;
	double[] listPointY;

	public String toString(){
		Object[] listFields = setFields();
		String strFigure = template.format (listFields);
		return strFigure;
	}
	public void fromString (String strFigure){
		Object[] listFields = template.parse (strFigure, new ParsePosition (0));
		getFields (listFields);
	}
	public void fromListPoint (double[] listPointX, double[] listPointY){
		int lenListPoint = listPointX.length;
		this.listPointX = new double [lenListPoint];
		this.listPointY = new double [lenListPoint];
		// récupérer les dimensions de la forme
		double[] minmaxX = minmax (listPointX);
		double[] minmaxY = minmax (listPointY);
		posX = minmaxX[0];
		posY = minmaxY[0];
		width = minmaxX[1] - posX;
		height = minmaxY[1] - posY;
		// récupérer les points
		for (int p=0; p< lenListPoint; p++){
			double[] tmpPoint = getPoint (listPointX, listPointY, p);
			this.listPointX[p] = tmpPoint[0];
			this.listPointY[p] = tmpPoint[1];
		}
	}
	protected String setPoint (int pos){
		double pointX = listPointX[pos];
		double pointY = listPointY[pos];
		pointX *= width;
		pointX += posX;
		pointY *= height;
		pointY += posY;
		String strPoint = pointX +","+ pointY;
		return strPoint;
	}
	protected double[] getPoint (double[] listPointX, double[] listPointY, int pos){
		double pointX = listPointX[pos];
		double pointY = listPointY[pos];
		pointX -= posX;
		pointX /= width;
		pointY -= posY;
		pointY /= height;
		double[] point = { pointX, pointY };
		return point;
	}
	protected Object[] setFields(){
		// modifier les coordonnees pour les adapter a l'ecriture de la forme
		int lenListPoint = listPointX.length;
		// recuperer le premier point, à part afin d'avoir un bel affichage
		String strListPoint = setPoint (0);
		for (int p=1; p< lenListPoint; p++) strListPoint = strListPoint +" "+ setPoint (p);
		// récupérer le style
		String strStyle = setStyle();
		Object[] listFields ={ strListPoint, strStyle };
		return listFields;
	}
	protected void getFields (Object[] listFields){
		// récupérer les points
		String strListPoint = (String) listFields[0];
		String[] listPoint = strListPoint.split (" ");
		double[] listPointX = new double [listPoint.length];
		double[] listPointY = new double [listPoint.length];
		for (int p=0; p< listPoint.length; p++){
			String[] tmpStr = listPoint[p].split (",");
			listPointX[p] = Double.parseDouble (tmpStr[0]);
			listPointY[p] = Double.parseDouble (tmpStr[1]);
		}
		fromListPoint (listPointX, listPointY);
		// récupérer le style
		String strStyle = (String) listFields[1];
		getStyle (strStyle);
	}
	public Polygon (double[] listPointX, double[] listPointY, String colFill, String colStroke, int strokeWidth){
		super (0,0,1,1, colFill, colStroke, strokeWidth);
		fromListPoint (listPointX, listPointY);
	}
	public Polygon (double[] listPointX, double[] listPointY, String colFill, String colStroke){
		super (0,0,1,1, colFill, colStroke);
		fromListPoint (listPointX, listPointY);
	}
	public Polygon (double[] listPointX, double[] listPointY){
		super (0,0,1,1);
		fromListPoint (listPointX, listPointY);
	}
	public Polygon(){ super (0,0,10,10); }

	// comprendre les points d'une liste
	protected double[] minmax (double[] tabPoints){
		double min = tabPoints[0];
		double max = tabPoints[0];
		for (double pos: tabPoints){
			if (pos < min) min = pos;
			else if (pos > max) max = pos;
		}
		double[] res = {min, max};
		return res;
	}
}