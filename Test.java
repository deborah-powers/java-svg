package svg;

public class Test{
	public static void main (String[] args){
		Drawing dessin = new Drawing();
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
		Polygone polygona = new Polygone();
		posTraitX[0] = 140;
		polygona.setPoints (posTraitX, posTraitY);
		dessin.addFigure (polygona);
		dessin.draw ("dessin.svg");
	}
}
