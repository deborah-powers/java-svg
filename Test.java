package svg;

public class Test{
	public static void main (String[] args){
		String dessinNom = "dessin.svg";
		Drawing dessin = new Drawing();
		dessiner (dessinNom, dessin);
		dessin.fromFile (dessinNom);
	}
	public static void recuperer (String dessinNom, Drawing dessin){}


	public static void dessiner (String dessinNom, Drawing dessin){
		dessin.addFigure();
		Ellipse ellipse = new Ellipse (150,90,30,40, "green", "blue");
		dessin.addFigure (ellipse);
		Ellipse rond = new Ellipse (20,120,40,40, "red", "yellow");
		dessin.addFigure (rond);
		Polyline trait = new Polyline();
		double[] posTraitX ={100,20,30};
		double[] posTraitY ={1,40,70};
		trait.setPoints (posTraitX, posTraitY);
		dessin.addFigure (trait);
		Polygon polygona = new Polygon();
		posTraitX[0] = 140;
		polygona.setPoints (posTraitX, posTraitY);
		dessin.addFigure (polygona);
		dessin.toFile (dessinNom);
	}
}
