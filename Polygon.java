package svg;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Polygon extends Rectangle{
	ArrayList<Double> listPointX = new ArrayList<Double>();
	ArrayList<Double> listPointY = new ArrayList<Double>();

	public String toString(){
		// modifier les coordonnees pour les adapter a l'ecriture de la forme
		int lenListPoint = listPointX.size();
		// recuperer le premier point, à part afin d'avoir un bel affichage
		double tmpPointX = listPointX.get (0);
		double tmpPointY = listPointY.get (0);
		tmpPointX *= width;
		tmpPointX += posX;
		tmpPointY *= height;
		tmpPointY += posY;
		String strListPoint = tmpPointX +","+ tmpPointY;
		for (int p=1; p< lenListPoint; p++){
			tmpPointX = listPointX.get (p);
			tmpPointY = listPointY.get (p);
			tmpPointX *= width;
			tmpPointX += posX;
			tmpPointY *= height;
			tmpPointY += posY;
			strListPoint = strListPoint +' '+ tmpPointX +','+ tmpPointY;
		}
		String strFigure = MessageFormat.format ("<polygon points=\"{0}\"", strListPoint);
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
		for (int p=0; p< lenListPoint; p++){
			double tmpPointX = listPointX[p];
			double tmpPointY = listPointY[p];
			tmpPointX -= posX;
			tmpPointX /= width;
			tmpPointY -= posY;
			tmpPointY /= height;
			this.listPointX.add (tmpPointX);
			this.listPointY.add (tmpPointY);
		}
	}

	public Polygon (double[] listPointX, double[] listPointY, String colFill, String colStroke, int strokeWidth){
		super (0,0,1,1, colFill, colStroke, strokeWidth);
		setPoints (listPointX, listPointY);
	}
	public Polygon (double[] listPointX, double[] listPointY, String colFill, String colStroke){
		super (0,0,1,1, colFill, colStroke);
		setPoints (listPointX, listPointY);
	}
	public Polygon (double[] listPointX, double[] listPointY){
		super (0,0,1,1);
		setPoints (listPointX, listPointY);
	}
	public Polygon(){ super (0,0,1,1); }

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