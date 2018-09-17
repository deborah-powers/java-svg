package svg;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Polyline extends Rectangle{
	ArrayList<Double> listPointX = new ArrayList<Double>();
	ArrayList<Double> listPointY = new ArrayList<Double>();
	public String toString(){
		// modifier les coordonnees pour les adapter a l'ecriture de la forme
		int lenListPoint = listPointX.size();
		String strListPoint ="";
		for (int p=0; p< lenListPoint; p++){
			double tmpPointX = listPointX.get (p);
			double tmpPointY = listPointY.get (p);
			System.out.println ("writing d "+ tmpPointX +" "+ tmpPointY);
			tmpPointX *= width;
			tmpPointX += posX;
			tmpPointY *= height;
			tmpPointY += posY;
			System.out.println ("writing f "+ tmpPointX +" "+ tmpPointY);
			strListPoint = strListPoint +' '+ tmpPointX +','+ tmpPointY;
		}
		String strFigure = MessageFormat.format ("<polyline points=\"{0}\"", strListPoint);
		strFigure = toStringData (strFigure);
		return strFigure;
	}
	public void setPoints (double[] listPointX, double[] listPointY){
		int lenListPoint = listPointX.length;
		double[] minmaxX = minmax (listPointX);
		double[] minmaxY = minmax (listPointY);
		posX = minmaxX[0];
		posY = minmaxY[0];
		width = minmaxX[1] - posX;
		height = minmaxY[1] - posY;
		System.out.println ("params "+ posX +" "+ posY +" "+ width +" "+ height);
		for (int p=0; p< lenListPoint; p++){
			double tmpPointX = listPointX[p];
			double tmpPointY = listPointY[p];
			tmpPointX -= posX;
			tmpPointX /= width;
			tmpPointY -= posY;
			tmpPointY /= height;
			System.out.println ("setting "+ tmpPointX +" "+ tmpPointY);
			this.listPointX.add (tmpPointX);
			this.listPointY.add (tmpPointY);
		}
	}
	public Polyline  (double posX, double posY, double width, double height, String colFill, String colStroke, int strokeWidth){
		super (posX, posY, width, height, colFill, colStroke, strokeWidth); }
	public Polyline  (double posX, double posY, double width, double height, String colFill, String colStroke){
		super (posX, posY, width, height, colFill, colStroke); }
	public Polyline  (double posX, double posY, double width, double height){
		super (posX, posY, width, height); }
	public Polyline (){ super (0,0,0,0); }
	// comprendre les points d'une liste
	private double[] minmax (double[] tabPoints){
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