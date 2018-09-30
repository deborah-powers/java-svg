Réaliser des dessins svg simples.

J'utilise une classe myUtils.File afin d'écrire facilement les données dans un .svg.

Les formes dessinables:
	Rectangle (double posX, double posY, double largeur, double hauteur, [String couleur, String couleurBordure], [int épaisseurBordure])
	Ellipse (idem)
		si largeur et hauteur sont identiques, l'ellipse est transformée en cercle.
	Line (double posX, double posY, double largeur, double hauteur, [String couleurBordure], [int épaisseurBordure])
	Polygon (double[] listPosX, double[] listPosY, [String couleur, String couleurBordure], [int épaisseurBordure])
	Polyline (idem)

Rectangle est la forme par défaut, dont les autres héritent les propriétés.

Dessiner:
	Drawing dessin = new Drawing();
	Ellipse ellipse = new Ellipse (150,90,30,40, "green", "blue");
	dessin.addFigure (ellipse);
	dessin.addFigure();		// créer un rectangle par défaut
	dessin.toFile ("fileName.svg");

Récupérer un dessin:
	En cours d'écriture
