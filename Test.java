package svg;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;

public class Test{
	public static void main (String[] args){
		String dessinNom = "dessin.svg";
		String dessin2Nom = "dessin2.svg";
		Drawing dessin = new Drawing();
	//	dessiner (dessinNom, dessin);
		recuperer (dessinNom, dessin2Nom, dessin);
	}
	public static void testMessage(){
		String strBlankMessage = "bonjour {0}, mon ami no {1}";
		MessageFormat blankMessage = new MessageFormat (strBlankMessage);
	//	String message = MessageFormat.format (blankMessage, "David", 2);
		Object[] objectList ={ "David", 2 };
		String message = blankMessage.format (objectList);
		System.out.println (message);
		Object[] dataList = blankMessage.parse (message, new ParsePosition(0));
		System.out.println (dataList[1]);
	}
	public static void recuperer (String srcNom, String dstNom, Drawing dessin){
		dessin.fromFile (srcNom);
		dessin.toFile (dstNom);
	}
	public static void dessiner (String dessinNom, Drawing dessin){
		dessin.addFigure();
		Ellipse ellipse = new Ellipse (150,90,30,40, "green", "blue");
		dessin.addFigure (ellipse);
		Ellipse rond = new Ellipse (20,120,40,40, "red", "yellow");
		dessin.addFigure (rond);
		Polyline trait = new Polyline();
		double[] posTraitX ={100,20,30};
		double[] posTraitY ={1,40,70};
		trait.fromListPoint (posTraitX, posTraitY);
		dessin.addFigure (trait);
		Polygon polygona = new Polygon();
		polygona.strokeWidth =8;
		posTraitX[0] = 140;
		polygona.fromListPoint (posTraitX, posTraitY);
		dessin.addFigure (polygona);
		dessin.toFile (dessinNom);
	}
}
