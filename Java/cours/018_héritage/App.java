/*
Java #18 - h�ritage

Bonjour � tous et bienvenue sur ce cours de Java. 
Comme promis nous allons aborder une autre notion du langage et plus particuli�rement de la programmation orient�e objet, puisque nous allons parler d'h�ritage.
J'en avais l�g�rement parl� dans les vid�os pr�c�dentes avec toutes les notions que l'on a d�j� abord�es jusqu'� pr�sent, je vous expliquais que ce principe, cette notion d'h�ritage �tait d�j� pr�sente par rapport aux diff�rentes classes que nous avons utilis� jusqu'� pr�sent notamment pour la cha�ne de caract�res, tout ce qui est lecture de donn�es et ce genre de chose.
Je vais vous montrer au travers d'un code et au travers de pas mal d'exemples pour pouvoir illustrer ce principe l� et que vous voyez � quoi �a sert et comment �a se pr�sente et comment on met en place un syst�me d'h�ritage au niveau de notre code.
Alors l'h�ritage en programmation, c'est un petit peu comme l'h�ritage entre des personnes, c'est pour cr�er en fait une relation entre diff�rentes classes. Nous allons voir comment.
Nous allons repartir d'un exemple de d�part tr�s simple :
*/
//import jc.entities.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Horse h = new Horse("Guero");
//		h.move(167, 428);
//		
//		Pegasus p = new Pegasus("Titanus");
//		p.move(33, 146);
//		p.fly(466);	
//	}
//}
/*
D�j� en termes de fichier, on a d'abord un fichier pour l'application App.java, C'est une simple classe habituelle avec la m�thode main.
Et j'ai 2 classes, une classe pour repr�senter un cheval et une classe pour repr�senter un P�gase.
Toutes les choses qui sont marqu�s ici ne sont que des notions qui ont d�j� �t� vues. s'il y a des parties au niveau de ce code que vous ne comprenez pas, il faudra penser � revenir sur les anciennes vid�os parce que ce sont que des choses qui ont �t� abord�es dans la vid�o pr�c�dente et que normalement vous �tes cens� savoir-faire est cens� avoir assimil�.
Pour montrer vite fait au niveau de l'architecture ou en tout cas au niveau de l'organisation des fichiers, j'ai simplement fait un package entities et j'ai mis mes 2 classes dedans.
Ici les sous dossiers j'aurais pu tr�s bien m'en passer mais puisqu'on a appris � utiliser des package, �a ne faisait pas de mal de faire un petit rappel l�-dessus, la syntaxe tout �a. 
Voil� pour cette partie. 

Horse.java
==========

Comment �a se pr�sente? En gros, nous avons une classe qui va repr�senter une entit�, un cheval (Horse) avec un constructeur tr�s tr�s simple :

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}
On peut cr�er des instances de ce cheval en mettant tout simplement un nom et il va avoir une position Avec des coordonn�es XY.
on peut imaginer par exemple un cheval positionn� sur une interface � 2 dimensions et du coup cette interface 2 dimensions pour le positionner, on aura du coup sa position en x et en y. 

� partir de l� la seule chose qui est capable de faire ce cheval, c'est de se d�placer. 

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
		System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

Il poss�de une m�thode move() Qui lui permet de se d�placer avec une autre coordonn�e par rapport � XY et on affiche un petit message pour s'assurer qu'on a bien fait le changement au niveau des attributs qui sont disponibles ici :

	private String mName;
	private int mPosX;
	private int mPosY;

Mais � la rigueur, on n'a m�me pas besoin de les voir pour comprendre comment fonctionne cette classe.

Pegasus.java
============

Pour le p�gase, on se retrouve un petit peu avec la m�me chose, avec un nom pour le constructeur :

	public Pegasus(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
		this.posZ = 100;
	}

� Mais nous avons une nouvelle coordonn�e qui arrive, la coordonn�e, la position en Z. 

Ce p�gase peut �galement se d�placer donc � terre de mani�re terrestre, en XY, mais il peut aussi voler. 

	public void fly(int z)
	{
		this.mPosX = z;
		this.mPosY = y;
		System.out.println("Le Pegase s'eleve dans les airs (Z = "+this.mPosZ+")");
	}

Mais � partir du moment o� il vole, il va commencer � prendre de l'altitude elle se d�pla�er sur cette coordonn�e Z donc lui il sera sur un environnement en 3 dimensions.

Donc il peut se d�placer en 2 dimensions mais il peut �galement prendre de l'altitude et voler contrairement au cheval.

Donc voil� comment se repr�sente ce code, au niveau de ma m�thode main, j'ai tout simplement cr�� une instance de cheval :

	Horse h = new Horse("Guero");

Je l'ai fait se d�placer avec la m�thode qu'on a ici move() : 

       h.move(167, 428);

J'ai fait la m�me chose pour un p�gase :

	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);

C'est-�-dire se d�placer et voler tout simplement.
Encore une fois, tout �a c'est juste du rappel, �a permet encore une fois, j'en ai profit� avec cet exemple de code pour faire pas mal de rappels sur la syntaxe et pas mal de choses qu'on a vu pr�c�demment, la cr�ation de classe, les attributs, les m�thodes et l'utilisation de package, d'organiser tout �a sous forme de package.

Pour l'h�ritage voil� du coup le sch�ma qu'on obtiendrait au niveau de Cette organisation.

			Object
				^
				|
	Horse ------+------ Pegasus
	move()				move()
						fly()
	
Au niveau de Java, on va utiliser pas mal d'objets d'ailleurs vous l'avez vu on a utilis� pas mal de classe StringBuilder, StringBuffer.
On avait pas mal d'exemples comme �a et au niveau de Java comme c'est un langage qui utilise le paradigme objet, toutes classes de ce type h�ritent� c'est-�-dire qu'elle appartient � une classe qui est au-dessus de toutes, tout simplement la classe object.
On l'a repr�sent� ici parce que c'est la classe de Java d'ailleurs si on consulte la documentation officielle, vous verrez qui si vous aller faire rechercher une classe de la documentation, on vous indiquera qu'elle sp�cialise, qu'elle s'�tend par rapport � cette classe object qui est vraiment la classe de d�part pour toutes.
Donc comment est-ce qu'il faut le comprendre ? C'est simplement de dire que les classes qui appartiennent � Java h�ritent de cette classe et vous aussi.
Quand vous allez en fait cr�er une classe, m�me si dans votre code vous ne l'indiquez pas, nulle part on a dit qu'on �tend ou qu'on a une classe qui h�ritent de object, elle se fait automatiquement, implicitement au niveau de la compilation.
Java tout simplement rajout� la sp�cialisation depuis cette classe object donc voil� comment on peut repr�senter cela sous forme de sch�ma c'est-�-dire de dire que nos classes ici Horse et Pegasus sont en fait des classes qui h�ritent de object.
Donc tout ce que poss�de cette classe object, qui est une classe de Java, nos classes � nous pourrons en tout cas les utiliser que ce soit les attributs, elles ont les m�mes attributs et les m�mes m�thodes.
Il faut imaginer que Object est une classe m�re et que toutes les classes fille poss�de tout ce que la m�re c'est-�-dire ses attributs, son comportement, ses m�thodes c'est-�-dire les services qu'elle peut faire.
Voil� c'est une chose tr�s importante.

Voil� la relation que l'on aurait non Sans parler de cet h�ritage l�. Pour le moment cet h�ritage l� nous ne nous int�resse pas parce qu'il faut que vous sachiez que au niveau de Java quand vous cr�ez une classe tout ce temps � partir de objects � chaque fois que vous cr�ez une nouvelle classe, parce qu'on abordent le sujet sur l'h�ritage.

Mais nous ce qui nous int�resse, c'est qu'on n'a pas vraiment de relation d'h�ritage entre un cheval et un p�gase pourtant on se rend tr�s vite compte rien que au niveau du code qu'un cheval et qu'un p�gase par rapport � la repr�sentation (Horse.java et Pegasus.java) que l'on a faites sont assez similaires.

On pourrait tr�s bien se dire qu'en fait un p�gase est une sorte de cheval mais qui a des choses en plus. Donc il peut tout faire et poss�de le comportement d'un cheval � la diff�rence que lui en plus de �a, il peut voler. C'est une petite chose qu'il a en plus, suppl�mentaire.

Donc moi j'aimerais changer cette relation et c'est l� que va intervenir justement ce principe d'h�ritage de ne pas dire que je cr�e des chevaux, un cheval � part et je cr�e un p�gase � part mais je veux pouvoir cr�er un cheval et si je cr�e un p�gase je veux que mon p�gase, ce soit un super cheval. En gros, c'est un cheval qui a pas mal de choses y compris des m�thodes et �ventuellement un comportement en plus du cheval que lui n'aurait pas.

Au niveau du sch�ma, je vais obtenir tout simplement :

			Object
				^
				|
			Horse
			move()				
				^
				|
			Pegasus
			move()
			fly()

En gros voil� le genre de sch�ma qu'on aimerait avoir.
Alors il faut fonctionner v�ritablement peut-�tre � l'envers de ce que vous pourriez penser en termes de logique, vous seriez peut-�tre tent� de vous dire comme le p�gase a plus de choses, c'est qu'il serait mieux que le cheval entre guillemets donc il serait au-dessus.
Il faut fonctionner diff�remment, plus vous allez en haut et plus vous avez les entit�s les plus basiques Et plus on descend dans l'arbre de l'h�ritage et plus les classes qui en sortent en bas sont sp�cialis�s, poss�de de plus en plus de choses donc en gros ici Horse � tout ce que poss�de object et ici Pegase aura tout ce que poss�de Horse qui lui-m�me poss�de d�j� tout ce qu'a object.
Donc p�gase poss�de d'ores et d�j� bien tout object. Donc il y a vraiment comme �a un principe de hi�rarchie ou plus vous allez comme �a au plus bas dans les classes et plus elle poss�de tout ce qu'on les classe en haut dont elles d�pendent et comme on va cr�er cette relation au niveau du code parce que maintenant on vient d'expliquer le principe, le sch�matis� maintenant, il faut voir au niveau du code Java comment est-ce qu'on va repr�senter �a en termes de syntaxe. 

Repr�sentation au niveau des classes
====================================

C'est tr�s simple, on va garder nos 2 fichiers de classe par contre au niveau du p�gase on va dire qu'il �tend, "extends". On va utiliser ce mot cl� l� au niveau de la d�finition de la classe :

	package jc.entities;

       public class Pegasus extends Horse
       {
		public Pegasus(String name)
		{
			�
Va utiliser ce mot cl� pour �tendre notre classe cheval et l� il va y avoir pas mal de petits changements au niveau de cette notation Et �galement pas mal de choses qui vont changer. 

Premi�rement comme on l'a indiqu� dans le sch�ma, du coup, on peut enlever la m�thode move() parce que implicitement � partir du moment o� on a cette relation d'h�ritage, on sait que pegasus poss�de la capacit� de se d�placer de mani�re terrestre c'est � dire avec move() donc ici pas besoin quelque part de le refaire donc pour l'instant on va mettre se bloque entre commentaire au niveau du p�gase.

//public void move(int x, int y)
//{
//	this.mPosX = x;
//	this.mPosY = y;
//	System.out.println("Le Pegase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
//}

Je vais vous expliquer pourquoi je le commente et je ne supprime pas tout simplement parce qu'on va revenir un petit peu dessus apr�s.
alors comment �a se passe ? On est d'accord que le cheval, il demande simplement un nom, il va se construire suivant un nom et plus loin on a pass� des valeurs brutes pour la position XY, et On voit que ces informations sont dans le bloc :

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}
Ensuite on voit que les attributs sont pass�s en priv�, le probl�me c'est que s'ils sont priv�s, �a on en avait parl�, ils vont en fait �tre priv� suivant la classe c'est-�-dire que la classe gardera ses attributs pour elle mais nous on veut pouvoir comme �a pouvoir cr�er cette relation :

			Horse
			move()				
				^
				|
			Pegasus
			move()
			fly()

V�ritablement cr�er cette relation d'h�ritage. Donc un cheval, pour nous ce n'est pas choquant qu'un p�gase et acc�s aux attributs du cheval puisqu'il est cens� lui-m�me les avoir. Notre p�gase doit avoir les coordonn�es XY et un nom que poss�de de base le cheval.

Donc plut�t que d'utiliser le mot cl� private, on va introduire un nouveau mot-cl� par rapport � l'acc�s aux attributs. On avait vu private, on avait vu public, J'en avais parl� concernant les m�thodes notamment, y compris le constructeur ou les classes ici. Et le nouveau mot cl� qui va �tre introduit est protected.

protected c'est tout simplement le m�me niveau d'acc�s que private sauf qu'on va permettre d'ouvrir l'acc�s aux classes qui font partie comme �a d'une hi�rarchie d'h�ritage.

Donc c'est priv� sauf pour les classes qui h�ritent entre les autres, qui ont comme �a un lien d'h�ritage, une relation d'h�ritage entre elles. Donc on va le mettre pour tous les attributs parce qu'on veut que notre p�gase et ces 3 informations l� :

Horse.java

	protected String mName;
	protected int mPosX;
	protected int mPosY;

Du coup pas besoin ici de faire de la redondance, c'est-�-dire que comme pegasus poss�de tout ce qu'a le cheval donc toutes ces informations suivantes peuvent �tre enlev�es :

Pegasus.java

	//private String mName;
	//private int mPosX;
	//private int mPosY;
	private int mPosZ;

On garde simplement l'attribut que lui en plus parce qu'on est bien d'accord que le cheval n'a pas de coordonn�e Z mais pour le p�gase on met juste cette information-l� : 

	private int mPosZ;

Et au niveau de cette cr�ation, au niveau de construction on a un petit peu la m�me chose : 

Pegasus.java

		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;

Ca on niveau de la construction dans Pegasus.java, on le fait d�j� dans Horse.java, au niveau de la cr�ation du cheval, au niveau de son  constructeur.

En gros ce que l'on va faire au niveau du code, quand vous allez instancier au niveau de la programmation� Quand on va cr�er un p�gase, en r�alit�, on va appeler le constructeur de cheval qui va cr�er en fait toute la partie cheval et ensuite on ajoutera �ventuellement ce qui permet la construction d'un p�gase puisqu'en fait un p�gase se construit en partie suivant la construction d'un cheval.

j'essaie d'�tre assez clair, c'est pas �vident de trouver les bons mots  pour l'expliquer mais heureusement avec le code et le sch�ma, on peut le faire comprendre. 

En gros, on va pas dire que tu cr�es un cheval qui poss�de une coordonn�e XY et un nom et ensuite tu cr�es le p�gase qui aura un nom et les coordonn�es XY Sinon on aurait 2 instances ou en tout cas 2 animaux diff�rents donc �a n'irait pas.

on dit simplement que notre p�gase poss�de une partie des choses d'un cheval c'est � dire un nom, une coordonn�e x et une coordonn�e y donc on va utiliser le constructeur de cheval puisqu'il cr�� d�j� tout �a mais par contre comme le p�gase a besoin d'une coordonn�e Z, on l'ajoutera en plus.

Donc c'est tr�s simple pour faire tout �a, vous voyez qu'on a d�j� toutes les informations : 

Horse.java

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

Eh bien il suffit tout simplement non pas de passer tout le code ci-dessus mais d'utiliser le mot super(); qui va tout simplement faire r�f�rence au constructeur sup�rieur.

Pegasus.java

	public Pegasus(String name)
	{
		super();
		//this.mName = name;
		//this.mPosX = 50;
		//this.mPosY = 50;
		this.mPosZ = 100;
	}

Super, �a veut dire sup�rieur. super �a veut dire en fait que quand on utilise super pour le p�gase, �a signifie que tu vas utiliser le constructeur sur la classe qui vient tout juste au-dessus donc la classe parente, donc il va utiliser le constructeur pour le cheval et on lui passe le nom.

Pourquoi est-ce qu'on lui passe le nom ? Parce que je rappelle que pour construire un cheval, on a besoin d'un nom :
	
       public Horse(String name)

On a besoin d'un homme pour construire un cheval, c'est tr�s important.
Et les positions XY, on ne le donne pas parce qu'on les met dans le block Horse, arbitrairement, on ne les fait pas passer en param�tre pour avoir quelque chose de dynamique.

Donc on a juste 2 instructions pour le constructeur de pegasus :

Pegasus.java

	public Pegasus(String name)
	{
		super();
		this.mPosZ = 100;
	}

donc m�me si on a l'impression Que ce n'est pas pr�sent pour le code, � la fin notre p�gase il aura bien un nom, une position en x, une position en y et une position en z.

c'est juste que pour la position en t�te on l'a fait directement ici et pour le reste des informations, comme un cheval et d�j� construit avec ces informations-l�, on passe par son constructeur.

�a �vite de r�p�ter le code et �a �vite comme �a d'avoir des choses toutes m�lang�es. 

Dans Pegasus.Java, on peut laisser l'attribut en private parce que je ne vais pas cr�er, je ne vais pas �tendre la classe p�gase, en gros.

Quand je dis que je ne vais pas �tendre la classe p�gase, je veux dire qu'il n'y aura rien qui va se sp�cialiser par rapport � un p�gase. Elle sera en fait une classe terminale, il n'y aura rien de plus.

On verra d'ailleurs qu'il y ait il y a des petits mots cl�s pour dire qu'une classe n'est pas �tandable. On peut utiliser un certain mot-cl� en Java pour faire �a.

Donc l� on a du coup un meilleur comportement.

On a g�r� au niveau de la construction des objets et notamment au niveau des attributs et on va passer maintenant au niveau des m�thodes.

Horse.java
----------

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
		System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

App.java
--------

public class App
{
	Horse h = new Horse("Guero");
	h.move(167, 428);
	
	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);
}

Ici, on voit que mon p�gase au niveau de App.java, � un moment, on utilise la m�thode move().
C'est pour �a qu'on a comment� la m�thode move() de Pegasus.App parce que on a pas besoin de la r��crire parce que quand on va vouloir �crire que le P�gase utilise la m�thode move(), qu'est-ce qu'il va se passer ?

Le langage vas chercher une m�thode move() au niveau de Pegasus.java et s'il n'en trouve pas, on va voir si ta classe m�re en a une donc il va remonter � la classe m�re comme si il faisait un super et il va chercher une m�thode move() pour Horse :

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Et �galement, s'il n'y avait pas de m�thode move(), il y aurait une erreur mais l� il va la trouver donc il va utiliser la m�thode move() de Horse.java
Par contre si on veut faire d�placer le p�gase diff�remment, l� du coup il faudra r��crire la m�thode et on fera du coup une red�finition, On va red�finir la m�thode move() pour dire que notre p�gase peut se d�placer comme un cheval mais il va faire diff�remment donc du coup on r��crit la m�thode, donc il faut pas qu'on ait le m�me code.
Si vous avez le m�me code dans la classe Horse et Pegasus alors �a n'ira pas, �a ne servira � rien de refaire une red�finition, autant supprimer la m�thode move() dans la classe Pegasus.
Par contre si le code dans la m�thode move() de la class Pegasus diff�re de ce que vous avez dans la classe m�re, vous pouvez faire une red�finition mais il faudra le r��crire.
Rem. On constate que le texte est un petit peu diff�rent dans la m�thode move() dans le fichier Horse.java parce qu'on pr�cise cheval (m�me pour P�gase maintenant) dans println() donc c'est pas g�nial, j'aurais d� utiliser une information pour �a parce que du coup on va avoir pour p�gase, la phrase avec le cheval se d�place alors que c'est un p�gase. Je n'aurais pas d� mettre mon texte ici mais on va laisser comme �a et en effet puisqu'il s'agit de code identique, nous ne devrions pas refaire une red�finition Mais on va laisser. On peut n�anmoins remplacer par � l'animal se d�place � parce que nous aurions d� sortir le texte pour ne pas l'avoir dans le bloc Move. 

//System.out.println("Le cheval se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");

System.out.println("L'animal se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");

En effet, on veut �viter � refaire une red�finition dans pegasus.java
Donc nos m�thodes move(), fly() avec le cheval qui ne peut pas voler mais p�gase pas de probl�me il pourra l'utiliser donc il faut bien comprendre que quand on fait un move() dans App.java, c'est pas quelque chose qui appartient directement au p�gase, �a appartient � sa classe m�re donc la classe Cheval, Horse, mais comme il en h�rites, comme la classe Pegase �tend la classe Cheval, Horse, et bien il peut utiliser les classes de Horse, il n'y a aucun probl�me par rapport � �a.

On va proc�der � un test maintenant, on aurait pu tester le code avant mais ce n'est pas grave. Normalement si on a bien import� les package, c'est bon �a devrait fonctionner�

	>javac App.java
	>java App
	L'animal se deplace (X = 167, Y = 428)
	L'animal se deplace (X = 33, Y = 146)
	Le Pegase s'eleve dans les airs (Z = 466)
	
� L'animal se d�place �, c'est le d�placement du cheval donc le premier move() dans main :

	Horse h = new Horse("Guero");
	h.move(167, 428);

Ensuite on a cr�� un p�gase qu'on fait d�placer en 33/146.
Et apr�s on voit qu'on le fait voler.

	Pegasus p = new Pegasus("Titanus");
	p.move(33, 146);
	p.fly(466);	

Donc le p�gase s'�l�ve dans les airs, z �gal 466.
Voil� on a donc v�ritablement cette relation qui se fait : 


On n'a plus cette fois-ci 2 classes qui sont ind�pendantes, on a une relation d'h�ritage pour dire que le p�gase est une sorte de cheval. 
Et si vous �tes capable de dire quand vous avez un code qu'une classe est une sorte d'une autre classe, c'est que g�n�ralement dont 99 pour 100 des cas, vous allez pouvoir cr�er, d�finir une relation d'h�ritage.

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Un autre exemple ce serait de dire qu'un v�hicule volant et une sorte de v�hicule, si par exemple vous avez fait une classe v�hicule, une classe v�hicule volant, ben tout de suite on comprend que v�hicule volant va �tendre v�hicule pour ce genre de choses.

ou par exemple dans un jeu vid�o, vous avez un combattant et puis vous avez un magicien. Si votre magicien est une sorte de combattant et bien magicien est une classe qui va �tendre la classe combattant. voil� un petit peu le principe et �a fonctionne pour tout.

Et l� �a repr�sente des entit�s, l'h�ritage, c'est-�-dire que vous voyez des choses bien d�finies mais on n'est pas oblig� de repr�senter les entit�s, �a peut �tre des concepts, des id�es o� ce genre de chose. 
Par exemple si vous voulez d�velopper un lecteur audio, vous pourriez avoir une classe pour la partie gestion du son Ou alors pour la partie ensuite au niveau des diff�rents �tats du son. On n'est pas oblig� d'avoir que des entit�s. On peut avoir par exemple pour un jeu aussi, on aurait une classe qui va g�rer le r�seau, on peut avoir une classe qui va g�rer tout ce qui est enregistrement dans des fichiers pour faire des sauvegardes, une classe pour g�rer du classement, une classe pour g�rer le multijoueur. 

Bref on n'est pas oblig� d'avoir forc�ment une classe qui repr�senterait une entit� qu'on pourrait concr�tiser r�ellement : on cr�e un joueur, on cr�e une maison, on cr�e une voiture. On voit pas forc�ment une classe pour ce genre de chose, on l'avait d'ailleurs expliqu� sur la vid�o pour la construction d'une classe, on peut vraiment cr�er plein d'autres choses et apr�s d�s que vous voyez qu'une relation peut se faire entre 2 classes, il n'y a pas de probl�me par rapport � �a.

Petite indication par contre, on ne peut pas dire qu'une classe �tant plusieurs classes � la fois. Par exemple il ne serait pas possible ici de de cr�er une autre classe : 

					Object
^
       -----------|-----------
       ^				^
       |				|
			Horse				Autre classe
			move()				
			^
			|
			Pegasus
			fly()

� Donc il ne serait pas possible de cr�er une autre classe et de dire que p�gase et une classe sp�cialis�e de Horse et d'une autre en m�me temps, ce qu'on appelle l'h�ritage multiple en programmation. Il y a des langages qui le proposent meilleur Java on ne peut pas par contre plus tard on verra, on aura une vid�o d�di�e sur ce qu'on appelle les interfaces qui permet un petit peu si vous voulez dire qu'une classe impl�mente, donc l� on ne parle pas d'�tendre mais d'impl�mentation.
Et une classe pourra appeler monter plusieurs interfaces � la fois donc c'est un petit peu un syst�me qui �vite tout simplement de faire l'h�ritage multiples parce que �a peut poser beaucoup de probl�mes au niveau du code par contre avec les interfaces vous verrez qu'on peut faire des impl�mentations multiples mais on fera une vid�o dessus et on reviendra dans le d�tail pour parler des interfaces plus tard.
Voil� pour tous ceux qui �taient au niveau de l'h�ritage. 
Nous n'avons pas encore fait le tour de tout ce que l'on voulait aborder mais en gros vous savez comment cr�er une classe, dit une classe m�re, la superclasse si vous voulez donc ici c'�tait Horse, vous savez comment cr�er une de ces classe fille donc �ventuellement une classe fille donc ici c'est notre classe Pegasus. � partir de l�, on a vu qu'on pouvait acc�der aux choses de la classe au-dessus avec super(). 

Si on veut par exemple forcer, Si on a fait par exemple move dans Horse et ensuite admettons qu'on ai red�fini la classe move dans Pegasus. On pourrait dire qu'un cheval n'affiche pas les infos et ensuite de dire que p�gase va appeler la m�thode move() de Horse et apr�s il affiche quand m�me le message � Le p�gase se d�place � :

Horse.java

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Pegasus.java

	public void move(int x, int y)
	{
		super.move(w, y);
System.out.println("Le p�gase se deplace (X = "+this.mPosX+", Y = "+this.mPosY+")");
	}

Donc on dira ici que c'est le p�gase qui se d�place.
et du coup, on part du principe que pour le cheval on n'affiche rien et ensuite quand on utilise cette m�thode move() red�finie, on dit tu vas utiliser tout, tu vas faire un appel � la m�thode move() de la classe parente donc on utilise encore une fois le mot-cl� super. On peut le faire comme �a pour appeler une m�thode d'une classe parente et ensuite on a rajout� autre chose dans cette m�thode pour afficher du texte.
donc on peut tout � fait utiliser �a, super peux permettre d'appeler en utilisant tout seul le constructeur de la classe parente mais si vous mettez super suivi d'un point et suivi d'un autre m�thode, ben �a va chercher une m�thode dans la classe parente.
Encore un nouveau mot-cl� l�.

On avait This, this qui fait r�f�rence � l'instance courante lorsqu'on avait vu la construction d'une classe. et maintenant nous avons un nouveau mot-cl�, super, qui permet d'acc�der � une information Du constructeur ou une m�thode autre que le constructeur d'une classe parentes lorsqu'il y a une relation d'h�ritage.

J'essaie encore de rien oublier parce qu'il y a encore une fois il y a tellement de choses qu'il faudra aborder, il va y avoir pas mal de d'autres vid�os qui vont r�utiliser l'h�ritage. On va voir d'autre chose, notamment on va parler des interfaces, on va parler des classes abstraites et on parlera du polymorphisme. Ce sera sur d'autres vid�os parce que si on avait tout mis en une seule vid�o, on aurait une vid�o de 4h pour parler de tout �a.

Le mot cl� instanceof
=====================

Sur quoi peut-on terminer, on peut �galement v�rifier puisque on cr�e diff�rentes instances de quelque chose dans App.java :

import jc.entities.*;

public class App
{
	public static void main(String[] args)
	{
		Horse h = new Horse("Guero");
		h.move(167, 428);
		
		Pegasus p = new Pegasus("Titanus");
		p.move(33, 146);
		p.fly(466);	
	}
}

Pour v�rifier diff�rentes instances de quelque chose, il y a un petit mot cl� tr�s pratique en Java si par exemple � un moment donn� vous avez besoin de v�rifier si un objet est propre � une instance particuli�re. En gros, par exemple, ci-dessus, est-ce qu'on a bien un p�gase et pas autre chose ? 

Ce mot cl� est instanceof qui est tr�s simple � utiliser. 
Vous pouvez par exemple vous en servir dans une condition Et vous pouvez par exemple faire ceci :
*/

import jc.entities.*;

public class App
{
	public static void main(String[] args)
	{
		Horse h = new Horse("Guero");
		h.move(167, 428);
		
		Pegasus p = new Pegasus("Titanus");
		p.move(33, 146);
		p.fly(466);	

		if(p instanceof Pegasus)
			System.out.println("C'est un pegase");
	}
}

/*
On teste si p est de l'instance p�gase.
On a p qui est l'objet donc la variable qui contient notre objet suivi de instanceof et enfin le nom de la classe en question.
Si cette variable p est bien d'une instance de cette classes, de la classe pegasus et bien �videmment l'expression sera valide donc vous pourrez rentrer dans une condition.
Tr�s pratique.
je vous donne ce petit mot cl� parce que je ne pense pas que je vous l'avais donn� dans une vid�o pr�c�dente donc tant que j'y pense autant que je vous le donne comme �a au moins ce sera fait et �a peut servir dans pas mal des cas et on s'en servira un peu plus lorsqu'on abordera le polymorphisme, comme �a il sera vu en avance.

Voil� pour �a, sur quoi peut-on terminer ?
Tout � l'heure je vous avais dit que pour le cas du p�gase dans le sch�ma et on terminera cette s�ance avec �a, je veux en fait ne pas pouvoir permettre � l'utilisateur de dire que je vais cr�er une classe qui �tend p�gase.

Le mot cl� final
================

Et pour �a nous avons un autre mot-cl� qui est final.
Et final s'utilise de plein de mani�res. 
On peut d�j� l'utiliser pour dire qu'une classe sera finale. 
Une classe finale donc avec le mot-cl� final veut dire en fait qu'elle n'est non �tandable, on ne pourra pas en fait cr�er une classe fille 2 celle-ci, qui va �tendre cette classe-l�.
Par exemple pour mon p�gase, je peux mettre ce mot cl� avant le mot-cl� class et �a veut dire que je ne pourrais jamais, je ne pourrais pas m'amuser � faire une nouvelle classe qui s'appellera SuperPegasus.
En gros, je ne peux pas m'amuser � faire.

SuperPegasus.java

package jc.entities;

public class SuperPegasus extends Pegasus
{
	
}

Je ne pourrais pas du coup dire que j'ai une classe qui �tend Pegasus puisque cette classe est final :

Pegasus.java
	
       public final class Pegasus extends Horse{}

Il est indiqu� final donc elle est finale, elle ne peut pas �tre �tendue ce qui est tr�s important. Si vous voulez emp�cher la possibilit� d'�tendre une classe, il faudra utiliser ce mot cl� et du coup il sera impossible de l'�teindre.

final pour une m�thode
----------------------

On peut �galement utiliser ce mot cl� pour une m�thode.
Admettons ici au niveau du cheval :

	public void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Au niveau du cheval, on dit que cette m�thode move() et final, c'est � dire emp�cher que les classes filles red�finissent cette m�thode. Autrement dit on va emp�cher le fonctionnement de cette m�thode dans les classes filles.
Pour rappel lorsqu'on avait fait le test tout � l'heure cela donnait :

Le pegase se deplace (X = 33, Y = 146)
Le Pegase s'eleve dans les airs (Z = 466)
C'est un pegase

Vous voyez, dans la premi�re ligne, le p�gase utilisait sa m�thode � lui avec la phrase � le p�gase se d�place �. Si je veux emp�cher �a, je peux le faire ici :

Horse.java

	public final void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	} 

Ensuite on va recompiler Et il y a une exception qui est lev�e :

Exception in thread "main" java.lang.VerifyError: class jc.entities.Pegasus overrides final method jc.entities.Horse.move(II)V
       at �

C'est normal qu'il y ait une exception, tout simplement parce qu'on essaie d'overrides, donc on essaie en fait de red�finir une m�thode finale mais c'est pas possible. 
Donc �videmment, on emp�che absolument �a et donc l� on saura qu'on ne peut pas red�finir cette m�thode dans Pegasus.java

	" Supprimer la m�thode move() de pegasus. "

Donc on sera oblig� de R� utiliser la m�thode dans la classe parentes et l� �videmment il n'y aura plus de probl�me il a du coup vous constatez qu'on utilise la m�thode move() du cheval Et non pas une qu'on aurait red�fini. 

Final pour un attribut 
-----------------------

On peut �galement l'appliquer pour un attribut si � un moment donn� vous avez besoin d'avoir un attribut bien pr�cis.
On aurait par exemple :

Horse.java

	protected final int SomeData = 14;

On d�clarer un attribut, peu importe, avec une valeur parce que c'est quelque chose qui ne pourra pas bouger, tu ne pourras pas changer. Par exemple on aura une valeur, on met ici n'importe quoi pour l'exemple mais sachez qu'on peut utiliser final comme �a. 

On peut �galement s'en servir, par exemple dans la cr�ation de valeurs. 
Par exemple on voit qu'ici dans ce code :

	public final void move(int x, int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	} 

On voit dans ce code qu'on ne modifie pas X et Y, jamais, jamais je ne modifie la valeur de X et Y donc rien ne m'emp�cherait de dire ceci :

	public final void move(final int x, final int y)
	{
		this.mPosX = x;
		this.mPosY = y;
	}

Je ne modifie pas les valeurs de ces attributs-l� donc on peut les indiquer final aussi.

Et enfin on peut �galement localement, au sein d'une m�thode, si on avait besoin � un moment donn� de cr�er une variable qu'on ne va jamais modifier :

	public final void move(final int x, final int y)
	{
		final int OTHER_COORD = 178;

		this.mPosX = x;
		this.mPosY = y;
	}

En gros c'est un petit peu comme si on levait une constante. On pourrait m�me la mettre en majuscule pour dire voil� qu'une fois qu'elle est d�clar�e, on ne pourra pas modifier �a. Donc puisqu'elle est final, on ne pourra pas l� modifier. C'est une mani�re d'indiquer, c'est pour ajouter de la lisibilit� au code pour indiquer qu'on fait ces informations-l� Ne pourront pas �tre modifi�s donc on ne changera pas leurs valeurs Donc elles sont final aussi. on utilise du coup le mot-cl� final.

Donc voil� pleins de cas possible. On peut utiliser final pour une classe, pour l'emp�cher d'�tre �tendu. On peut l'utiliser sur une m�thode pour l'emp�cher d'�tre red�finie et sur des param�tres de m�thode ou m�me pour une variable en local pour l'emp�cher tout simplement d'�tre modifi�, pour indiquer qu'elle est final donc non modifiable. 

C'est un petit peu comme un const en C++ si vous faites de la programmation Objet. Vous savez quand programmation objet commencer plus vous pouvez utiliser le mot-cl� const notamment pour faire ce genre de choses donc ici c'est un petit peu pareil donc l� ici on a final qui est propre des exemples comme �a. 

Que faire avec cet h�ritage ?
-----------------------------

Alors que faire avec cet h�ritage pour terminer cette vid�o ? vous voyez que vous pouvez cr�er et quand vous cr�erez plein de classe au niveau de vos projets donc au niveau de votre programme, vous pouvez cr�er des relations d'h�ritage mais l� o� c'est g�nial aussi, ce que vous allez pouvoir sans probl�me prendre une classe de Java tel qu'on avait vu avec StringBuilder, rappelez-vous c'�tait une classe de Java qu'on avait d�j� utilis�. Rien ne m'emp�che, c'est tout � fait possible, sauf si bien s�r la classe c'�tait marqu� final car rappelez-vous qu'une classe finale ne peut pas �tre �tendu mais je peux par exemple cr�er ma classe � moi comme ceci :

MyStringBuilder.java

On prend ici un exemple tout simple avec MyStringBuilder.java
Il faudra bien s�r faire les importes n�cessaire pour StringBuilder
De toute fa�on ce n'est pas pour compiler le code donc c'est pour montrer en gros.
donc ici il faudrait faire le import pour avoir tout ce qu'il faut :

MyStringBuilder.java

//import�

public class MyStringBuilder extends StringBuilder

Et on dirait simplement la classe et bien s�r vous pouvez �tendre une classe native de Java, il n'est pas oblig� que ce soit une classe � vous.
C'est pour dire qu'on va partir de la classe StringBuilder de Java :

MyStringBuilder.java

//import�

public class MyStringBuilder extends StringBuilder
{
	
}

Donc on repart de la classe StringBuilder de Java tels que les faites et �ventuellement red�finir certaines m�thodes pour changer ce comportement, comment elle fonctionne. Vous pouvez faire �a et c'est justement tout le principe, rappelez-vous ce que je vous avais expliqu� concernant l'encapsulation et tout �a, on avait pas besoin de savoir comment a �t� construit une classe. ce que l'on veut juste savoir c'est les m�thodes qu'elles poss�dent, ce qu'elles nous permettent de faire cette classe l�. Et apr�s on peut sans probl�me l'�tendre si on veut pour changer le comportement d'une classe, pour cr�er une classe qui fonctionne un peu diff�remment mais qui se base quand m�me sur un mod�le existant donc voil� comment on peut faire �a.

Et d'ailleurs pour terminer la s�ance, rappelez-vous de tout ce qui concernait les exceptions qu'on avait vu pr�c�demment, Eh bien vous pourrez �ventuellement cr�er une classe. Par exemple vous avez besoin de g�rer un certain type de donn�es particuli�res, par exemple ici on peut dire les coordonn�es. On a des coordonn�es pr�cises :

Horse.java

	public Horse(String name)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

� Et on pourrait par exemple dire, que par exemple on demande une coordonn�e x et si cette coordonn�es x est plus petite que 0 alors elle ne sera pas bonne peu importe la raison :

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;
		this.mPosX = 50;
		this.mPosY = 50;
	}

� Peu importe la raison, On pourrait tr�s bien dire :

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;

		if(x < 0)

		this.mPosX = 50;
		this.mPosY = 50;
	}

En gros si x est plus petit que 0, on dira de lever une exception et �a on ne l'avait pas forc�ment montr� pr�c�demment mais ce n'est pas grave puisqu'on voulait le garder pour ici comme on devait aborder l'h�ritage, c'�tait mieux d'attendre l'explication concernant l'h�ritage pour voir �a. Donc au lieu d'attendre la lev�e d'une exception Faites par une classe en Java automatiquement, �videmment vous pouvez vous-m�me manuellement lever une exception. Donc le plus simple et le plus g�n�rique, cette faire : 

Horse.java

	public Horse(String name, int x)
	{
		this.mName = name;

		if(x < 0)
			throw new Exception("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

on fait donc ceci et on dit voil� un message qui serait explicite par rapport � �a. Et nous levons donc une exception. Dans l'id�al on devrait faire �galement ceci (throws Exception) :

Horse.java

	public Horse(String name, int x) throws Exception
	{
		this.mName = name;

		if(x < 0)
			throw new Exception("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

Et l� o� c'est vraiment int�ressant, ce que vous voyez c'est un petit peu trop g�n�rique :

	Exception("La valeur de X est incorrecte");

C'est un petit peu trop g�n�rique, un petit peu trop vague, j'en avais parl� pr�c�demment rappelez-vous sur les exceptions. J'avais commencer un petit peu � parler d'h�ritage en disant qu'une exception c'est un petit peu trop vague, �a peut tous �tre comme exception " Exception ", �a peut concerner un fichier, �a peut concerner une structure de donn�es, �a peut concerner l'environnement d'ex�cution, �a peut concerner une variable, et cetera et cetera. Enfin tellement des choses que c'est beaucoup trop vague. 

Eh bien rien ne nous emp�cherait encore une fois, par exemple, afficher qui s'appellerait HorseException.java

Pour dire voil� qu'on a une classe pour g�rer les exceptions propres au cheval m�me si �a semble un peu bizarre dit comme �a, on peut tout � fait faire �a et dire Que cette classe �tends la classe Exception du langage Java :

HorseException.java

//import�

public class HorseException extends Exception
{
	//getMessage()
	//printStackTrace()
}

Voil� cette classe d'exception qu'en �tends, ce n'est pas moi qui l'ai cr��, c'est Java qui l'a cr�� mais on est dans cette classe et du coup, on pourra red�finir tout un tas de choses. rappelez-vous que les exceptions notamment 2 m�thodes tr�s pratique parmi tant d'autres, qui sont getMessage(), que vous pouvez red�finir si vous voulez, et printStackTrace(), Soit vous laisser le comportement tel qu'elles ont par d�faut sans probl�me si vous voulez notamment changer la m�thode getMessage() pour qu'elle affiche quelque chose de bien particulier concernant ainsi notre cheval et bien vous pouvez le faire aussi. 

Et � partir de l� au lieu de faire "throw new Exception", on aurait simplement : 

Horse.java

	public Horse(String name, int x) throws HorseException
	{
		this.mName = name;

		if(x < 0)
			throw new HorseException("La valeur de X est incorrecte");

		this.mPosX = 50;
		this.mPosY = 50;
	}

On aurait simplement ceci c'est-�-dire que notre constructeur pourrait lever �ventuellement une HorseException, notre exception � nous, notre classe � nous et dans la condition on �crirait throw new HorseException.

Voil� si vous avez compris ce que j'ai dit et je m'excuse par avance parce que c'est vraiment pas �vident � expliquer et en plus de �a on a parl� d'h�ritage sur pas mal d'autres formations on en a parl� on C++ et Python. Et c'est vrai lorsqu'on parle des m�mes notions, qu'on r�p�te un peu les m�mes notions mais sur pleins de langages diff�rents, du coup on essaie de pas tout dire de la m�me mani�re mais je peux pas non plus r�inventer des nouveaux mots � chaque fois. Voil� c'est pas toujours �vident de l'expliquer mais si vous avez compris toutes mes explications et bien tant mieux.

Si c'est pas suffisamment clair, n'h�sitez pas � revoir la vid�o un peu plus lentement aussi parce qu'on a parl� assez vite pour pas que �a tra�ne trop en longueur.

Et c'est vraiment vous bloquer sur des choses bien sp�cifiques, n'h�sitez pas � poser des questions dans les commentaires parce que c'est tr�s important de comprendre �a.

Et si vous comprenez un petit peu ce principe d'h�ritage, vous aurez compris �norm�ment de choses pour la suite et �a va grandement vous faciliter la vie quand vous allez justement travailler sur de vrais projets. 

Voyez un peu le principe et surtout l'utilit� de l'h�ritage, c'est que � partir de l� on peut r�utiliser du code et c'est justement tout le principe de la programmation objet. Du fait que nous travaillons avec des classes et bien ces classes et �a rejoint tout ce qu'on avait dit, on se fiche de savoir comment est-ce qu'elles ont �t� faites c'est-�-dire que l�, je n'ai pas besoin d'aller voir dans le code Java pour voir comment sont faites la classe de Java. Je peux sans probl�me ici cr�er ma propre classe d'exception :

HorseException.java

//import�

public class HorseException extends Exception
{
	//getMessage()
	//printStackTrace()
}

On peut cr�er ainsi notre propre classe d'exception Sans m�me savoir comment a �t� �crite cette classe Exception qui est native de Java, juste , � partir du moment o� je connais les m�thodes getMessage() et printStackTrace() et �a on le trouve dans la documentation, Il n'y a pas besoin de les apprendre par c�ur.

Eh bien je peux red�finir tous les comportements que je veux et je peux ainsi avoir une classe qui va utiliser toute la puissance d'une classe native de Java mais qui sera adapt� � une partie bien sp�cifique de mon programme parce que bien �videmment vous comprenez bien que le langage Java ne g�re pas d'exception pour un cheval sinon il faudrait cr�er 15000 sc�narios diff�rents, il y aurait des millions et des millions de classes d'exception diff�rentes Et le pire de �a m�me avec des millions et des millions, il en manquerait. 

Vous n'aurez jamais la totalit� des choses puisqu'il existe en fait une infinit� de possibilit�s. du coup voil�, vous pouvez faire �a en tant que d�veloppeur c'est-�-dire �tendre des classes, que ce soit des classes native du langage (Exception) ou m�me vos propres classes et du coup avoir comme �a des relations, une hi�rarchie bien sp�cifique � votre projet.

voil� je pense qu'on a fait un petit peu le tour par rapport � tout �a.

alors on n'aura pas mal d'autres choses, c'est-�-dire que toute cette partie concernant l'h�ritage va introduire d'autres notions tr�s importante en programmation objet qu'on verra bien s�r dans d'autres s�ances.

on va s'arr�ter l� parce que la vid�o a �t� suffisamment longue pour un peu plus d'une demi-heure de vid�o donc c'est pas mal comme �a.

n'h�sitez pas si vous avez des questions ou des petits soucis par rapport � �a et surtout entra�nez-vous. 

L'avantage c'est qu'avec l'h�ritage, vous avez vraiment moyen de vous exercer, de faire votre petit programme.

Voyez qu'ici on a d�velopp� quelque chose de tr�s simple, de simuler des personnages qu'on pourrait d�placer, tout �a.

M�me s'il n'y a pas d'interface graphique, ce n'est pas grave, � partir du moment o� vous avez une console, vous pouvez simuler le d�placement juste avec du texte. D'accord, vous ne verrez peut-�tre pas des animations ou de choses visuelles mais c'est exactement tout pareil. 

La seule diff�rence est qu'il n'y a pas de surcouche graphique et vous pouvez simuler parfaitement tout un tas de choses comme �a au niveau de votre programme donc n'h�sitez pas � vous entra�ner comme �a vous comprendrez bien ce principe d'h�ritage. Vous pouvez toujours r�utiliser ce principe de sch�ma m�me s'il n'y a pas forc�ment grand-chose � montrer 

			Horse
				move()				
				^
				|
			Pegasus
				fly()

Voil� m�me s'il n'y a pas grand-chose � montrer, si vous avez compris que tout ce qu'est une classe �tendue concerne en fait sa classe parente Eh bien au moins vous aurez compris pas mal de choses par rapport � ce concept d'h�ritage en programmation orient�e objet.

je vous dis � bient�t pour la prochaine s�ance de Java. 

Je pense que la prochaine fois nous parlerons de classe abstraite.

en tout cas on va aller un peu plus loin sur l'utilisation de l'h�ritage et des diff�rentes classes en Java.

ciao.
*/
