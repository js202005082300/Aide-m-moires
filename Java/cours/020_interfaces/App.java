/*
Java #20 - interfaces

Bonjour bienvenue sur la s�ance 20 pour parler des interfaces en Java, une s�ance qui fait suite tr�s directement avec les classes abstraites. Notion qu'on a vu pr�c�demment et on va compl�ter un petit peu en fait tout ce qu'on a vu concernant les classes abstraites pour vous parler un petit peu des interfaces et voir un petit peu ce qui est diff�rent de la classe abstraite parce que vous verrez qu'il n'y a pas forc�ment �norm�ment de choses donc on peut du coup souvent confondre les 2. Et on verra comme �a un petit usage, je vous montrerais un usage des interfaces que l'on peut retrouver.
On va partir sur un code un peu sp�cifique par rapport � �a :

App.java
--------
*/

//import jachampagne.*;
//
//public class App
//{
//	public static voir main(String[] args)
//    {
//		Cottage c = new Cottage();
//		c.build("bois");
//		
//		Ship s = new Ship();
//		Glider g = new GLider();
//		s.moveXY(146, 97);
//		g.moveXY(88, 23);
//	}
//}

/*
On part sur un code un peu sp�cifique par rapport � �a que je vais vous d�tailler tr�s simplement et puis je vais m�me faire un petit sch�ma pour que vous puissiez comprendre. 
Donc en gros, je vais vous montrer comme �a. 

	Vehicule (abstract)			Building (abstract)
		^						^
		|						|
Ship ------------- Glider			Cottage

Nous avons une classe abstraite qui repr�sente un v�hicule et de cette classe abstraite nous avons �tendue deux classes, donc cr�er deux classes, une qui repr�sente un navire et notre qui va repr�senter un planeur. Ce sont des sortes de v�hicules qui retrouve comme �a ce lien, Cette hi�rarchie li� � l'h�ritage justement.
Et de l'autre c�t�, l� on n'est pas du tout avec quelque chose li� �troitement v�hicules, c'est vraiment autre chose. Nous avons une classe, pareil, qui est abstraite qui repr�sente un b�timent une construction fait (Building).
Et issu de �a, J'en ai fait qu'une seule parce que je n'allais pas faire 300 fichiers de classe diff�rente mais je voulais juste en faire quelques-uns pour l'exercice pour que vous ayez un exemple suffisamment parlant.
Et on a un cottage qui repr�sentera une chaumi�re, une sorte de b�timent enfaite tout simplement qui est ici concret. 
Voil� un petit peu ce que �a repr�sente en termes de sch�ma ce que �a repr�sente. 
Donc on a se classe l� (Ship et Guilder), 2 classes �troitement li�es via h�ritage sur une classe abstraite et � c�t� une classe toute seule (Cottage) mais j'aurais pu en cr�er 2, 3, 4, plein d'autres si j'avais voulu pour compl�ter un peu plus. 
Donc en termes de code, �a se pr�sente comme �a :

App.java
--------

import jachampagne.*;

public class App
{
	public static voir main(String[] args)
    {
		Cottage c = new Cottage();
		c.build("bois");
		
		Ship s = new Ship();
		Glider g = new GLider();
		s.moveXY(146, 97);
		g.moveXY(88, 23);
	}
}

Donc pour v�hicule : 

Vehicle.java
-------------

package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;
	abstract public voir moveXY(int x, int y);
}

Donc pour le v�hicule, je vais aller tr�s tr�s vite parce que ce sont des choses qu'on a d�j� vu plein de fois et voil� maintenant au niveau des classes abstraites, on l'a abord� aussi mais en gros ici notre v�hicule poss�de qu'un seul �tat, donc ici un seul attribut qui est une vitesse de d�placement et on indique apr�s, une m�thode abstraite, c'est le cas parce qu'on ne l'impl�mente pas ici. Cette m�thode va permettre de d�placer ce v�hicule a une position XY.

De l� notre navire :

Ship.java
---------

package jachampagne;

public class Ship extends Vehicle
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se d�place en " + x + ", " + y);
    }
}

De l� notre navire, quand on cr�e un bateau, il a une vitesse par d�faut qui est indiqu�e Et moi je me suis d�cid�e pour l'exemple que la vitesse de d�placement, c'est du kilom�tre par heure et comme un bateau se d�place en n�uds, ici on aurait quelque chose qui se d�place aux alentours de 9 n�uds �a correspond � grosso modo pour ceux qui seraient curieux, � du 16 kilom�tres heure � peu pr�s.
Et ensuite le d�placement, pour faire quelque chose de tr�s simple pour notre exemple ici, j'ai simplement un texte qui indique que le navire voil� brasse les flots, se d�place et il affiche les coordonn�es.

Pour le planeur : 

Glider.java
-----------

package jachampagne;

public class Glider extends Vehicle
{
	public Glider()
	{
		this.mMovementSpeed = 28;
	}
	public void moveXY(int x, int y)
	{
		System.out.println("Le planeur fend l'air vers " + x + ", " + y);
    }
}

Pour le planeur, �videmment donc lui, au niveau de la construction il a une autre vitesse de d�placement, donc lui il se d�place plus vite, � 28 kilom�tres heure donc voil� c'est un planeur propuls�, tr�s rapide.
Et pareil, comme dans Vehicule.java, au niveau des v�hicules, nous avions une m�thode abstraite "abstract public voir moveXY(int x, int y)", elle doit �tre obligatoirement impl�ment� dans les classes concr�tes puisque ici notre planeur ne se d�place pas pareil. 
Et naturellement comme ici un planeur et un navire sont �troitement li�s par le fait qu'ils ont ici un m�me �tat, c'est-�-dire notamment leur vitesse de d�placement "mMovementSpeed". Voil� c'est un �l�ment commun � ces deux classes et notamment au moyen de se d�placer. Donc on a une classe abstraite et ensuite on cr�e comme �a des classes concr�te (voir sch�ma). Donc �a c'est le principe et ce qu'on avait vu pr�c�demment de la classe abstraite. Encore une fois �a permet de factoriser du code quand on trouve des liens �troits entre plusieurs classes et des �l�ments communs, C'est � �a que sert une classe abstraite et c'est � �a qu'elle doit servir. 

Pour le Building :

Building.java
-------------

package jachampagne;

abstract public class Building
{
	abstract void build(String material);
}

� c�t�, pour building donc ici pour repr�senter un b�timent une construction, J'ai quelque chose de plus court, c'est simplement une m�thode abstraite pour construire un b�timent et qui indiquera et l� il aurait fallu �ventuellement faire une autre classe encore � part mais je ne voulais pas trop en rajouter donc j'ai mis � la place une cha�ne de caract�res pour dire que voil� je construis un b�timent "build" selon un type de mat�riau "String material".

Et pour la chaumi�re :

Cottage.java
------------

package jachampagne;

public class Cottage extends Building
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
}
 
Et pour la chaumi�re, donc ce qui repr�sente une chaumi�re. Donc on a le constructeur avec une parcelle qui se met en place comme si on construisait la mise en place de la parcelle et on impl�mente la m�thode qui � la base est abstraite par rapport � un certain type de mat�riau donc �a permettra de construire le b�timent en bois, en pierre et cetera de cette mani�re. 

J'esp�re qu'ici c'est clair jusqu'� pr�sent, s'il y a des choses qui ne sont d�j� pas clair � partir de l�, vous revenez sur la vid�o d'avant concernant la construction d'une classe, les classes abstraites, les attributs, les m�thodes, il faut revoir toutes ces choses-l� s'il a tout de suite vous �tes d�j� perdu. 

Et maintenant, il faut imaginer que c'est la repr�sentation de mon projet et moi j'ai envie de faire un truc, on est d'accord qu'ici en planeur c'est quelque chose qui peut planer donc en gros c'est quelque chose qui peut voler, qui a possibilit� de se d�placer dans les airs. 
Donc on pourrait se dire naturellement, ici je vais permettre � mon planeur de voler tout simplement (fly).

Glider.java
-----------

package jachampagne;

public class Glider extends Vehicle
{
	public Glider()
	{
		this.mMovementSpeed = 28;
	}
	public void moveXY(int x, int y)
	{
		System.out.println("Le planeur fend l'air vers " + x + ", " + y);
    }
	public void fly()
    {
       	//il vole...
    }
}

On ne sait pas comment mais en gros, il vole d'une certaine mani�re. C'est un peu emb�tant, maintenant, plus tard, dans une �volution future, je pourrais avoir un autre v�hicule genre en avion, quelque chose qui repr�senterait un avion Virgule quelque chose qui repr�senterait un vaisseau spatial ou une soucoupe volante o� je-ne-sais-quoi il faudrait forc�ment lui permettre de voler donc qu'est-ce qu'on s'amuserait � faire ? Eh bien on serait en train de cr�er une classe concr�te qui devrait voler aussi mais on a une r�p�tition de code. 
Vous voyez il y aura le probl�me parce qu'on aurait ici la r�p�tition du code Fly pour �a (Glider.java) et on aurait une r�p�tition ailleurs.
La logique de la classe abstraite voudrais que quand on a comme �a des choses communes, des liens �troits en fait, on utilise cette fameuse classe abstraite donc on serait tent� de se dire bah que dans la classe abstraite qui repr�sente un v�hicule (Vehicule.java), on va faire fly() : 

Vehicle.java
-------------

package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public voir moveXY(int x, int y);
	abstract public void fly();
}

On y fait fly(), on s'en fiche comment il vole mais l� en terme d'impl�mentation, l� o� on essaie de r�soudre un probl�me, on en a ajout� un nouveau c'est-�-dire que l� on consid�re (Vehicule.java) que tous nos v�hicules que nous allons concr�tement cr�er, devront impl�menter une m�thode pour se d�placer donc �a OK ils devront impl�menter une m�thode pour voler. Le probl�me, on va partir du principe que nos navires, nos bateaux vont voler, c'est un petit peu emb�tant car si nous on veut des bateaux normaux qui se d�placent sur les eaux, on ne veut pas des bateaux qui veulent. On n'est pas dans Petter Pan. C'est un petit peu emb�tant par rapport � �a. Donc l� on voit tout de suite qu'il y a un probl�me dans la conception d'une impl�mentation ce n'est pas possible, on ne peut pas faire comme �a (retirer abstract public void fly()).

Vehicle.java
-------------

package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public voir moveXY(int x, int y);
}

Autre possibilit�, autre sc�nario. Tout ce qu'on vient de faire on peut l'oublier. On prend un autre sc�nario, que ce soit quelqu'un de l'ext�rieur, que vous travaillez pour un client ou m�me vous-m�me, vous �tes sur un jeu et on peut dire que cela ce sont des classes pour un jeu vid�o, admettons. Et vous voulez justement vous tapez le d�lire et Ben tiens, le planeur, on est d'accord, il vole et puis �ventuellement mais l� je n'ai que deux classes mais imaginer qu'il pourrait y en avoir beaucoup plus, on pourrait avoir plein d'autres types de v�hicules, tout �a. Puis l� je me dis, apr�s tout faire un navire volant, �a peut �tre sympa, �a peut �tre cool comme id�e et m�me sans parler de �a, juste le planeur, le planeur �a vol. On peut faire un planeur qui veulent, un planeur autopropuls� qui du coup ne ferait pas que de planer mais volerait vraiment et on peut se taper le d�lire de se dire aussi que j'aimerais bien dans mon jeu me faire une maison, une construction qui est dans les airs, une construction volante qui pourrait se d�placer dans les airs donc moi ici ma chaumi�re j'aimerais qu'elle puisse voler. 

Alors il y aura peut-�tre d'autres types d'habitation, des chalets, des manoirs mais je ne veux pas qu'ils volent mais la chaumi�re que je repr�sente ici avec la classe Cottage, j'ai envie qu'elle vol.

J'ai envie que Cottage vole comme un Glider autopropuls� pourrait voler. 

On pourrait d'ailleurs faire une classe sp�cialis�e pour dire que le Glider, le planeur, il ne fait que planer tel quel, et on cr�e une version plus sp�cifique avec un planeur avec un syst�me de propulsion mais on ne va pas non plus trop compliquer, on va dire l'exemple (Sch�ma). 

Donc l� il y a autre chose, mon planeur, je veux qu'il vole et �ventuellement le navire, et je veux que ma chaumi�re, elle vol sauf qu'on a bien vu et en tout cas on le voit ici au niveau du sch�ma que ce sont 2 choses s�par�es, ce sont 2 choses ind�pendantes donc �videmment et c'est le principe de tout ce que je vous ai expliqu� concernant la classe abstraite, il ne serait absolument pas possible et absolument pas coh�rent d'un point de vue lien �troit de se dire : 

FlyingElement
^		^
|		|

Ship		Cottage




En gros, par exemple, on aurait FlyingElement pour dire qu'on a un �l�ment fait quelque chose qui vol, un truc comme �a. Et apr�s on aurait un truc du genre, on va prendre le navire et au m�me niveau on va avoir notre chaumi�re et alors ici pas de probl�me on se dit qu'on va faire une classe abstraite. 

FlyingElement, ce sera une classe abstraite. On pourrait se dire �a, apr�s tout il y a un �l�ment commun Est-ce qu'on voudrait que tous les 2 vollent donc pourquoi est-ce qu'on ne pourrait pas faire �a.

Le probl�me, c'est que Cottage, une chaumi�re par rapport � la repr�sentation :

	Vehicule (abstract)			Building (abstract)
		^						^
		|						|
Ship ------------- Glider			Cottage

En tout cas par rapport � cette repr�sentation, ce ne sont pas des choses �troitement li�es. On est parfaitement d'accord pour se dire qu'une chaumi�re c'est carr�ment diff�rent d'un navire dans ce cas l�. 

Et si on commence a tout li�s, on va se retrouver avec toutes les classes de notre projet qui seront absolument toutes li�es ensemble. Et ce ne serait absolument pas du tout coh�rent parce qu'on pourrait trouver si on veut, si on chipotte, on pourrait trouver des liens en tout. On pourrait par exemple trouver un lien Entre un planeur et une chaumi�re, entre une construction et un v�hicule, si on veut on peut le trouver. 

On peut toujours trouver un lien quelconque, pas forc�ment coh�rent mais il y a toujours moyen de trouver un lien.

Donc ce n'est pas possible parce que la classe encore une fois abstraite permet elle doit servir � factoriser du code, encore une fois quand il y a des classes qui sont �troitement li�s. 

L� pour moi la chaumi�re, ce n'est pas �troitement li� � un navire, ce n'est pas �troitement li� � un planeur donc la solution de la classe abstraite ne va pas. 

Et c'est l� qu'intervient le sujet de cette s�ance, les interfaces. 

En gros je vais d�j� faire un petit sch�ma pour vous montrer en quoi �a consisterait simplement. Je vais fournir ce qu'on appelle un contrat, c'est le terme qu'on emploie g�n�ralement quand on parle d'interface. 

Quand on parle d'interface, on parle de contrat, moi je n'aime pas sp�cialement ce mot parce que je trouve qu'expliquer �a � quelqu'un qui d�bute en lui disant bah tiens voil� "une interface c'est un contrat", je pense qu'il y a plein de gens qui ne vont pas forc�ment comprendre. 

Donc on va d�velopper un peu plus cela mais le contrat c'est un peu quoi ? Ben moi, l'interface je pr�f�re dire, l'interface est un petit peu comme la carte d'un menu dans un restaurant.

En gros on vous fournit une carte, et en gros il y a tout un tas de choses qui sont indiqu�es l�-dessus. Et quand on va dans un restaurant vous comprenez un petit peu le principe non, Vous pouvez demander n'importe quoi de ce qui est indiqu� sur votre carte et il y a un cuisinier qui va cuisiner le plat. Donc si vous voulez un pav� de boeuf, si vous voulez une salade, il le fera et cetera.

Donc il y a un contrat engagement, bah tiens on vous fournit une liste de choses et vous choisissez l�-dedans et on va pouvoir nous en faire quelque chose et vous fournir ceci. Donc il y a un contrat. 

Donc comment �a se fait en termes d'informatique de programmation ? Parce que l� c'est un peu plus autre chose. Vous avez certainement d�j� entendu parler vous avez d�j� entendu le nom d'API, A.P.I. Si on emploie le terme anglais qui est en fait une simple interface qui des fois �a a l'air d'un mot compliqu� mais pas du tout. 

Une API, en fait, c'est une interface, C'est un contrats. En gros on va vous dire ici elle a pour rejoindre l'exemple de ce que je voulais faire( sch�ma). Moi je veux faire une interface donc voyez je fais une grosse interface (sch�ma d'un carr�). 

Je vais appeler cette interface volante, Flyable. Je vais dire voil�, je fournis un contrat qui dit voil� on va pouvoir avoir quelque chose de volant mais encore une fois lorsque vous allez dans un restaurant pour une carte, quand vous voyez marquer pav� de saumon, tagliatelles et cetera. Vous ne savez pas comment cuisinier va pr�parer et � la rigueur vous vous en fichez. Vous vous allez payer votre menu. Vous voulez votre pav� de saumon et votre tagliatelles, peu importe comment le cuisinier le pr�pare, il faut que ce soit bon, il faut que ce soit frais parce que c'est quand m�me mieux dans un resto est termin�e. Vous ne vous occupez pas de la mani�re dont le cuisinier va en fait impl�menter la recette. Vous vous savez juste qui peut vous faire un pav� de saumon Avec des tagliatelles comme menu et c'est tout. 

Moi je vous fournis une API, on va cr�er puisqu'on a le d�veloppeur ici, on va cr�er une interface en Java puisqu'on parle de Java qui est en fait une API pour cr�er quelque chose de volant, on ne sait pas quoi. C'est juste une interface comme �a : 

+--------------------------------------------+
|								|
|			Flyable				|
|								|
+--------------------------------------------+

Volant, on a une interface comme �a et cette interface.
Cette interface elle sera compl�tement � part, elle va avoir tout un tas de chose mais l� on ne parle pas vraiment de code, on sch�matise juste un peu la chose. Tout �l�ment qui aura besoin D'impl�menter �a (Flyable) comme fonctionnalit� c'est � dire que tu aurais besoin de voler, d'�tre volant, et bien on va lui dire tu vas l'impl�menter. 

C'est bien parce que c'est exactement ce que j'ai. Donc si je voulais sch�matiser en gros. 

Je dirais qu'ici ma chaumi�re (Cottage), je veux qu'elle puisse voler donc elle va impl�menter mon interface Flyale.


	Vehicule (abstract)		Flyable	Building (abstract)
		^					^		^
		|					|		|
Glider ------------- Ship			+----	Cottage 

On impl�mente l'interface Flyable, attention ce n'est pas de l'h�ritage, cette l'impl�mentation Mais comme ici je ne veux pas forc�ment faire des fl�ches diff�rentes comme de toute fa�on je vous parle en m�me temps que je fais les fl�ches, vous comprenez bien ce que je veux dire. 

Et la pareil, mon navire il fait �a. 

	Vehicule (abstract)		Flyable	Building (abstract)
		^				^	^		^
		|				|	|		|
Glider ------------- Ship --------+	+----	Cottage 

Donc Flyable, c'est vraiment une interface donc une surcouche d'abstractions, �a veut dire on te dit juste qu'on va faire voler, il y a une interface pour permettre le vol mais sans forc�ment se poser la question De comment on va le faire. Parce qu'on est d'accord qu'on ne fera pas voler un b�timent comment on va faire voler un navire et on s'en fiche puisque c'est dans la classe du navire qu'on va impl�menter cette interface. Qu'on va dire le navire, pour voler, pour �tre quelque chose de volant, il va le faire de telle mani�re et la chaumi�re, elle va le faire de telle mani�re et si un jour parce que c'est important la programmation objet encore une fois permet de �a, elle sert � r�utiliser le code et faire �voluer le code. Et si un jour, que ce soit vous en tant que d�veloppeur ou n'importe qui en tant que d�veloppeur qui viendrait � reprendre votre code, ce dit bah moi, �a y est je veux faire une voiture ; admettons il fait une nouvelle classe voiture je veux qu'elle puisse �tre une voiture volante, et bien il fera pareil : "ma voiture, elle va impl�menter cette interface Flyable." 

Et il dirait lui dans son code, vous voyez il n'a pas besoin de retoucher au code dans l'interface Flyable ou du code dans Vehicule ou je ne sais quoi. C'est juste lui dans son propre code sans avoir � casser le reste sans m�me savoir � la rigueur ce qu'il y a dans le reste du code. Il dira : "Ben moi, voil�,  ma voiture elle vole." et comment elle vol? "Et bien, de telle mani�re." Et il le fera dans sa propre impl�mentation. 

Voil� le principe d'une interface, c'est une couche d'abstraction qui �tablit en fait un contrat et qui du coup vous pouvez impl�menter dans n'importe quelle classe, n'importe quelle entit�, concept et cetera dans votre code, qui aurait besoin d'utiliser en fait cette fonctionnalit�, de se servir de cette API. 

Ici l'API, c'est le fait d'avoir quelque chose de volant, c'est un petit peu quelque chose de compliqu� � expliquer parce que volant c'est un terme un peu sp�cial. Pourquoi est-ce que j'ai marqu� Flyable de telle sorte comme �a ? 

+--------------------------------------------+
|								|
|			Flyable				|
|								|
+--------------------------------------------+

Pourquoi est-ce que j'ai marqu� Flyable de telle sorte comme �a ? Parce que j'avais utilis� un petit peu ce principe, parce que si on regarde la doc de Java, vous allez retrouver par exemple : une classe qui s'appelle, c'est une interface en r�alit� mais c'est un petit peu une classe un peu sp�ciale en fait les interfaces, je pense que vous avez un petit peu pig� le truc. Et donc ici on a une interface � Java qui s'appelle Comparable :

	https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

Et donc Comparable, juste par le nom, je pense que vous avez compris � quoi allait servir cette interface. Je pense que vous avez bien compris que �a allait permettre de comparer des �l�ments, des choses. On n'a pas encore vu les template, tout �a, on en a pas encore parl� sur ce cours mais en gros �a veut dire que cette interface, elle va permettre de comparer des �l�ments de n'importe quel type et on ne sait pas � l'avance quels seront ces types mais c'est pas grave. 

Et si on veut un peu plus loin dans cette doc, on va trouver par exemple une classe, par exemple la classe double pour les nombres � virgule, Calendar, Byte, Vous voyez on retrouve un petit peu tous les types de donn�es, qu'est-ce qu'on retrouve aussi ? On retrouve Year, Date, On retrouve des choses concernant la manipulation date. On a time par exemple, ce genre de chose. 

Et du coup dans ces classes qui vont impl�menter les interfaces, on dira et bah voil� un temps on va le comparer de telle mani�re mais le temps virgule on ne va pas le comparer comme des ann�es, on ne va pas non plus le comparer comme un nombre, un Byte, on va pas le comparer comme un double, on va pas le comparer comme un calendrier, on va pas le comparer comme un caract�re et cetera et cetera et cetera. 

Et peu importe, nous tout ce qu'on veut savoir, c'est juste qu'il y a une API qui nous dit que l'on va pouvoir ajouter une fonctionnalit� � n'importe quelle classe que l'on veut pour lui permettre comme �a de comparer des �l�ments. Voil� le principe donc �a c'est un exemple suffisamment parlant et en Java. 

Dans d'autres langages pour indiquer le nom d'une interface, on met souvent I majuscule devant ici en Java vous remarquerez que les interfaces ont souvent le terme "able" � la fin, quelque chose comme �a en able. C'est un objectif pour dire comparable, clonable, r�alisable, readable pour dire lisible par exemple et on retrouve toujours un petit peu ce terme-l�. 

Pour qu'on reste un petit peu dans les conventions de nommage de Java, nous avons appel� notre interface Flyable pour dire volant, c'est un objectif par rapport � �a.

Interface en termes de code
===========================

Voil� �a ce sont des explications, c'est le sch�ma c'est bien beau Mais maintenant en termes de code comment est-ce que �a se met en place. Comment est-ce qu'on met en place cette interface ? 

Maintenant vous savez qu'il faut faire comme �a et cette interface va permettre de corriger le probl�me qu'on avait montr� tout � l'heure, la fameuse m�thode abstraite Fly qui du coup n'irai pas du tout parce que �a nous obligerait � rendre tous nos v�hicules volants. En gros, si vous faites une moto il faudrait quel vol, si vous faites une voiture il faudra quel vol et ce n'est pas du tout ce qu'on veut.

Donc on va faire une interface. 

Donc une interface en fait c'est comme une classe quelque part, on ne va pas trop s'emb�ter l�-dessus. 

Comment est-ce que je peux faire �a ? 

On va cr�er notre fichier qu'on va appeler Flyable.java

Vous voyez je le mets dans le fichier de classe, je laisse �a l�-dessus, toujours dans mon package.

       package jachampagne;

Et � partir de l�, il va y avoir des petits changements en termes de syntaxe.

Donc l� on attaque vraiment la syntaxe :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	
}


On n'est pas sur le terme classe parce qu'il faut bien les diff�rencier. 
D�j� une interface, il faut savoir que il y a en terme de syntaxe, des r�gles importantes.
une interface c'est, en terme de syntaxe seulement, pas dans le comportement dans la mani�re dans lequel on doit s'en servir, c'est pour �a qu'on ne doit pas confondre les 2 mais juste en terme de syntaxe pure Et bien une interface est simplement une classe abstraite dans toutes les m�thodes sont abstraites d'accord c'est-�-dire qu'il n'y a pas de m�thode qui serait d�j� impl�ment� o� ce genre de chose m�me s'il y a une petite exception depuis la version 8 de Java mais on va en parler sur la s�ance. 
En gros tout est public et tout est abstrait par d�faut donc vous n'avez pas besoin de mettre le mot-cl� abstract pour m�thode et vous n'avez pas besoin non plus mais vous pouvez toujours le mettre � titre indicatif, le mot cl� publique. 
Moi par exemple je ne mettrais que le mot public, C'est assez rare qu'on met le mot cl� abstract dans les interfaces mais si vous voulez le mettre il n'y a pas de probl�me. Si pour vous c'est plus compr�hensible de faire comme �a pour �tre s�r que vous comprenez bien les choses, mettez le il n'y a aucun probl�me avec �a. 
Et comment �a fonctionne ? Eh bien dans cette interface je vais dire que on aura diff�rentes choses, diff�rentes m�thodes, diff�rents comportements qui vont permettre de faire voler, on ne sait pas quoi mais au final on pourra faire voler une chaumi�re (Cottage), un navire (Ship), peut �tre une moto, ce qu'on veut en fait, peu importe. 
Donc moi je vais rester sur quelque chose de tr�s simple parce que pour le moment je ne vais pas faire non plus 15 milles exemples mais je vais juste dire que j'ai une m�thode Fly. 

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
}

J'ai donc une m�thode Fly et par exemple je vais utiliser une cha�ne de caract�res parce que je ne vais pas cr�er une autre classe non plus mais genre quelque chose qui repr�senterait une �nergie pour pouvoir voler et c'est tout, mon interface est termin�e.

Mon interface est termin�e, alors une interface pour information c'est, comme une classe abstraite peut �tendre une autre classe abstraite comme je l'avais d�j� dit sur la s�ance pr�c�dente. Une interface peut �tendre une autre interface pour cela il faudra utiliser comme pour la classe le mot-cl� "extends"

Flyable.java
------------

package jachampagne;

interface Flyable extends ...
{
	public void fly(String energy);
}

Donc voil� si vous avez une hi�rarchie d'interfaces comme on aurait une hi�rarchie de classes, vous utilisez comme pour les classes, le mots cl�s extends. par contre d�s qu'une classe doit utiliser une interface donc l'impl�menter obligatoirement, il faudra utiliser le mot cl� "implements".
Donc �a c'est simple m�me si ce sont des mots-cl�s anglais, c'est facilement lisible m�me pour nous fran�ais, francophone, c'est facile d'utiliser ce terme l�. 

Maintenant comment j'impl�mente cette interface ? Comment je peux rendre mon navire volant ? Regarder c'est tr�s tr�s simple en termes de code, c'est juste �a.

On met d'abord tout ce qui est extension d'abord, c'est important il faut toujours mettre l'extension d'une classe. D'ailleurs en Java et puisqu'il y a des langages qui font un peu exception Mais on ne peut pas faire d'h�ritage multiple c'est-�-dire qu'une classe peut en �tendre qu'une seule. On ne peut pas avoir une classe qui h�rit� de 2 ou 3 ou 4 ou plus de classe, il n'y en a qu'une seule. 
Par contre et c'est aussi l'avantage de l'interface, c'est une classe elle peut impl�menter autant d'interfaces que vous voulez donc on peut faire de l'impl�mentation multiple d'interfaces et on les met toujours en dernier, donc on fait :

Ship.java
---------

package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se d�place en " + x + ", " + y);
    }
}

Donc l�, on mais implements Flyable. s'il y en avait d'autres on en mettre d'autres, on mettra une virgule puis autre chose, n'importe quelle autre interface comme �a vous les s�par�s par des virgules et c'est tout. 

�a c'est la syntaxe (implements Flyable) pour dire mon avis va impl�menter l'interface Flyable par contre comme �a, envoyer que rien n'est impl�ment� (Flyable.java) :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
}

Vous voyez que rien n'est impl�ment�, c'est le principe d'une interface, il n'y a aucune impl�mentation Ici (Flyable.java). On verra encore une fois qu'il y a une petite exception pour terminer la vid�o.

Eh bien il va falloir l'impl�menter. Donc ici c'est bien, tu as dit que tu voulais que ton navire vole, maintenant il faudrait que tu nous expliques comment il vole ? Quand je dis qu'il faudrait que tu nous expliques, c'est le compilateur, il va avoir besoin De dire comment est-ce qu'on va faire voler le navire.

Donc comme pour une classe abstraite, o� on aurait pour le coup une classe concr�te o� Il faudrait impl�menter les m�thodes abstraite, ici (Ship.java), impl�mente la m�thode abstraite de l'interface pour dire Ben voil� le navire il va voler comme �a.

Donc on va mettre un petit texte simple pour faire quelque chose de pas trop compliqu�. par exemple on va mettre, je me propulse dans les airs et cetera.

Ship.java
---------

package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovementSpeed = 16;
    }
    
    public void moveXY(int x, int y)
    {
    	System.out.println("Le navire brasse les flots et se d�place en " + x + ", " + y);
    }
    
    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
       
}

Donc on est tr�s, je me propose dans les airs avec du et on mettrait tout simplement le nom de l'�nergie. Je fais tr�s tr�s simple internet exemple pour le code. Je ne vais pas en faire plus je pense qu'un texte est suffisamment explicite pour �a.

Et voil� c'est bon, vous avez impl�ment� le vol pour votre v�hicule. Et voyez, je n'ai jamais eu besoin de toucher � Vehicle.java, ni � quoi que ce soit. 

C'est juste que si j'ai un �l�ment ou je dis celui-l�, cet �l�ment-l�, cette classe, je veux qu'elle puisse voler que mon navire puisse voler Eh bien c'est lui (Ship.java) que je modifie. 

Et si � un moment donn� on a besoin de rajouter d'autres possibilit�s (Flyable.java) Eh bien on rajoutera une autre m�thode. Je ne sais pas, on pourra dire par exemple boost, un truc qui permettrais de booster la vitesse :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
	public void boost(int x);
}

Et puis par exemple, on pourrait rajouter un multiplicateur de vitesse, quelque chose pour vous dire tiens je boost par 2, par 3, par 10 et cetera. 

Et � partir de l�, en changeant l'interface, il faudrait �videmment l'impl�menter (Shipt.java), alors ton navire comment est-ce qu'il se boost, comment est-ce qu'il boost sa vitesse? Et si tu veux que ta chaumi�re vole, comment est-ce qu'elle boosterait stress � vitesse ? D'accord c'est important. � partir du moment o� vous avez diff�rentes m�thodes, il faut comme pour les classes abstraites, obligatoirement, qu'est-ce qui les impl�mente, impl�mente �galement toutes ces m�thodes. Donc s'il y a 10 m�thodes dans votre interface, il faudrait impl�menter 10 m�thodes dans chaque classe qui impl�mente cette interface, tr�s important. De toute fa�on si vous ne le faites pas vous aurez une erreur � la compilation. Java vous le rappellera tr�s tr�s vite.

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
}

C'est pas tout c'est pas fini, ici il faut pareil. On fait un copier coller de Ship.java � Cottage.java. 

       void fly(String energy)
       {
       	System.out.println("Je me propulse dans les airs avec du " + energy);
       }

On aime bien faire un copier coller en informatique parce que je veux que Cottage.java l'utiliser aussi. Donc tr�s simple aussi, regarder je veux que ma chaumi�re vole et bien je lui impl�mente l'interface pour voler (implements Flyable). 

Cottage.java
------------

package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
}

Elle impl�mente l'interface pour voler � la classe Cottage. On l'a propuls� dans les airs avec quelque chose, on verra comment. 

Du coup (App.java), on va peut-�tre juste enlever ces exemples l� (voir pr�c�dent).

App.java
--------

import jachampagne.*;

public class App
{
	public static voir main(String[] args)
     {
		Cottage c = new Cottage();
		Ship s = new Ship();
	}
}

Et on va les faire voler, on va faire voler notre chaumi�re. Vous voyez tr�s simple.

App.java
--------
*/

//import jachampagne.*;
//
//public class App
//{
//	public static void main(String[] args)
//    {
//		Cottage c = new Cottage();
//		Ship s = new Ship();
//
//		c.fly("Carbone");
//		s.fly("Mana");
//	}
//}
/*
on va faire voler notre chaumi�re. Vous voyez tr�s simple. On va faire c.fly(""). Ensuite en termes de nom pour l'�nergie, ok allez on va dire au carbone, c.fly("Carbone"). Et le navire, on a qu'a dire, lui son �nergie c'est de la magie s.fly("Mana"), Comme dans les jeux vid�o la mana c'est de la magie. 

C'est quelque chose de magique, c'est la mana qui lui permet de voler. 
Et vous voyez c'est tout, juste �a. 
J'ai pas eu besoin moment de dire Eh bien dire que le v�hicule � un moment donn� il va devoir changer car comme Ship est une sorte de v�hicule donc du coup il faut bien indiquer que v�hicule peut voler, et bien non car tout nos v�hicules, on ne veut pas qu'il vol.
Donc il n'y a aucune raison de toucher � �a mais comme il y a des cas, des exceptions o� on veut que �a vole et bien il y a des caves on passe par une interface. 
Et on n'a plus du coup ce probl�me qu'on avait avec les classes abstraites. Et n'oubliez pas une classe peut impl�menter plusieurs interfaces. �a veut dire que vous pouvez du coup, rajouter plein de fonctionnalit� � vos classes en impl�mentant tout un tas d'interfaces comme vous le voulez, �a peut �tre vraiment pour plein de choses. 
Donc on va quand m�me compiler pour montrer que �a marche. 
Et voil�, j'ai fait une b�tise bien �videmment. 

	>javac App.java

--------------------------------------------------------------------

App.java:568: error: fly(String) is not public in Cottage; cannot be accessed from outside package
                c.fly("Carbone");
                 ^
App.java:569: error: fly(String) is not public in Ship; cannot be accessed from outside package
                s.fly("Mana");
                 ^
.\jachampagne\Cottage.java:13: error: fly(String) in Cottage cannot implement fly(String) in Flyable
    void fly(String energy)
         ^
  attempting to assign weaker access privileges; was public
.\jachampagne\Ship.java:15: error: fly(String) in Ship cannot implement fly(String) in Flyable
    void fly(String energy)
         ^
  attempting to assign weaker access privileges; was public
4 errors

--------------------------------------------------------------------

C'est quoi fly(String) is not public ? 
Qu'est-ce que j'ai mis comme b�tise ? 
Mais oui voil�, on a copier coller :

Cottage.java et Ship.java
-------------------------

    void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
Il faut public devant :

    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }

C'est n'importe quoi, vous voyez c'est le Copi�-coll�. Faites attention parce que quand il y a d�j� une faute dans ce que vous copi�-coll�, dommage! 

	>javac App.java
       >java App
       Parcelle en place...
       Je me propulse dans les airs avec du Carbone
       Je me propulse dans les airs avec du Mana

Et voil�, la personne en place c'est la construction de la chaumi�re. Je me propulse dans les airs avec du carbone donc �a c'est la chaumi�re qui est en train de voler et la derni�re ligne c'est le navire.

Et l� �a fonctionne, tout vol. Pas de probl�me ! 
Et si demain je veux rajouter un nouveau b�timent ou un nouveau v�hicule et je veux qu'ils volent, Eh bien pas de probl�me. C'est-�-dire que s'il n'y a rien qui change par rapport � la mani�re de voler, en tout cas ce contrat, cette interface (interface Flyable).

Eh bien je cr�e une classe concr�te qui h�rite de la classe abstraite qui a des liens avec s. Si c'est un v�hicule il faut que �a h�rites de v�hicules. Si c'est une sorte de b�timents, il faut que �a h�rites de building. Et si je veux que �a vole, j'impl�mente tout simplement l'interface Flyable (Fyable.java). Et c'est tout, termin�! 
J'ai pas eu besoin de toucher quoi que ce soit d'autres par rapport � �a. 

Voil� si vous avez compris ce que j'ai dit jusqu � pr�sent parce que je sais que la vid�o pour le cours va �tre un peu longue parce qu'il y a beaucoup de choses � expliquer. Vous avez d�j� compris 99 pour 100 2 interfaces en programmation de mani�re g�n�rale, y compris sur d'autres langages. Parce que le principe encore une fois ce sont des notions �l�mentaire qui fonctionne de la m�me mani�re sur d'autres langages. Apr�s ce qui va changer selon le langage, c'est la syntaxe o� comment fonctionne des fois les acc�s ou autre dans le langage � l'autre. 

Donc �a fait attention Selon le langage de programmation, il y a des choses qui diff�rent mais la notion elle est l� : � quoi sert une interface ? C'est ce que je viens de vous dire, c'est exactement pareil pour le c plus plus ou d'autres langages qui par avoir des interfaces. Tout est a fait pareil, il n'y a vraiment pas de diff�rence de ce c�t� l�. 

Du coup, du coup du coup, par exemple on va repartir sur l'exemple de Java, Java poss�de pas mal d'interface comme par exemple pour copier des objets, copier des �l�ments pour les comparer j'appelle pour tout �a. Et d�s qu'on veut avoir une classe et c'est comme �a que �a fonctionne ... que le langage Java est con�u comme �a avec plein d'interface, plein de classe abstraite et du coup tout est fait, toute la logique du langage, avec toutes les classes que vous allez utiliser du langage sont construites de cette mani�re. 

Donc si � un moment donn� vous voulez par exemple pouvoir comparer des �l�ments d'une classe que vous avez cr��e, Eh bien il faudra tu vas te faire votre propre interface si c'est bien quelque chose de sp�cifique sinon tout simplement impl�menter l'interface de Java (Interface Comparable), et c'est tout.

	Interface Comparable<T>
	https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html

Interface qui permettra � la place du T, de comparer des dates, des maisons, des navires voil� on peut comparer plein de choses Parce que �videmment en termes de code pur "comparer des bateaux", ce n'est pas si simple que �a, �a c'est vraiment humain, il faut r�fl�chir humainement parlant � comment est-ce qu'on compare de navires? 

OK pour �a, un autre �l�ment aussi parce que je vous avais dit qu'une interface en termes de syntaxe pure, c'est une classe abstraite mais qui ne poss�de que des choses abstraites donc en gros il n'y aura jamais de impl�mentation de quoi que ce soit.

Dans tous les cas une interface ne se instancie pas, ce n'est pas une classe en plus dans ce cas l�, il n'y a �videmment pas de constructeur dans une interface. Comme dans une classe abstraite, on ne fait pas d'instances d'une interface, �videmment pas. 

Par contre il y a un �l�ment tr�s important, comme on avait vu que la classe abstraite permet de factoriser du code c'est-�-dire comme quand on a des �l�ments communs avec des classes �troitement li�e, en cr�er une abstraction Pour faire justement cette fameuse classe abstraite et on pouvait utiliser justement des �l�ments non statiques, on pouvait utiliser des choses qui ne sont pas constantes, on peut par exemple avoir des attributs prot�g�s o� ce genre de chose. 

Par contre vous voyez que je l'ai fait ici, protected, pas de probl�me (Vehicule.java).

Par contre, pour l'interface (Flyable.java) :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
}

Par contre, pour l'interface (Flyable.java), c'est public donc on ne peut pas faire un attribut priv�, on ne peut pas faire un attribut protected m�me si c'est comme une classe, ce n'est pas compl�tement comme une classe. En termes de syntaxe, ce n'est pas du tout pareil et au niveau comportement non plus donc il y a bien une diff�rence entre classe abstraite et interface. Ce n'est absolument pas la m�me chose.  

Par contre m�me si on ne peut pas utiliser de mots d'acc�s (public, private, protected), On peut quand m�me, dans une interface utiliser des m�thodes statiques parce qu'une interface de toute fa�on, �a ne s'instancie pas.

Donc on pourrait indiquer, pour le coup ce n'est pas forc�ment int�ressant, mais on peut par exemple avoir public ... :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public

	public void fly(String energy);
}

On peut mettre par exemple public parce que personnellement je pr�f�re le mettre et avoir, je ne sais pas, Flyable ... mais l� c'est parce que pour le coup, mon v�hicule, j'ai mis une vitesse :

Vehicle.java
------------

package jachampagne;

abstract public class Vehicle
{
	protected int mMovementSpeed;

	abstract public void moveXY(int x, int y);
}

Pour mon v�hicule, j'ai mis une vitesse mais �a (mMovementSpeed), on pourrait se dire que c'est la vitesse de d�placement du v�hicule en normal et l�, on pourrait par exemple dire. On aurait admettons un int suivi d'un flySpeed :

Flyable.java (erreur)
------------

package jachampagne;

interface Flyable
{
	public int flySpeed =

	public void fly(String energy);
}

Non, ce n'est pas comme �a, ce serait plut�t "public static final int" ou "public final int" parce qu'on peut avoir un �l�ment final parce que c'est une constante en fait, voil� c'est "public final int" et on aurait, je ne sais pas, une vitesse de vol pour tous les �l�ments... je n'ai franchement pas d'id�e ... on va mettre 20, allez 20 kilom�tres heure.

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public void fly(String energy);
}

on va mettre 20, allez 20 kilom�tres heure, �a va vite, 20 kilom�tres heure, �a va vite, c'est d�j� pas mal.
Et voil�, on peut bien �videmment mettre des �l�ments, des constantes, rappelez-vous le mot-cl� final, on l'a d�j� emport� dans la s�ance pr�c�dente.
On peut avoir des �l�ments statiques sans probl�me, m�me de m�thode.
On peut faire des m�thodes statiques qui permettent comme �a de passer par l'interface comme vous l'avez vu avec la classe, les classes qui ont des m�thodes statiques. 

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public static void fly(String energy);
}

On peut faire des m�thodes statiques qui permettent comme �a de passer par l'interface comme vous l'avez vu avec la classe, les classes qui ont des m�thodes statiques, sans cr�er d'instance de quoi que ce soit. 
Donc Flyable, on utilisera la m�thode statique, je ne reviens pas dessus on en a d�j� parl� tout ce qui �tait m�thode statique. C'est la m�me chose pour les interfaces. Tout ce que vous savez sur la m�thode statique fonctionne pareil pour les interfaces mais c'�tait quand m�me bien de le rappeler et pourquoi c'est important ? parce que avant Java 8, Java 7 et les versions ant�rieures, on ne pouvait pas faire une m�thode statique dans une interface c'est pour �a que j'en ai parl� mais de toute fa�on vous �tes au minimum sur Java 8, voir m�me Java 10 parce que je ne vous avais dit de ne pas partir sur une version qui date de 5 ou 10 ans. Faut pas non plus d�conner donc vous avez quand m�me une version un minimum r�cente et c'est pour �a qu'il y a ces petites choses � prendre en compte. 

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public final int flySpeed = 20;

	public void fly(String energy);
}

Normalement j'ai fait le tour, il n'y a qu'une derni�re chose dont je dois encore vous parler pour la fin de la vid�o mais je regarde si je n'ai pas oubli� autre chose de ce que je voulais vous dire, les �l�ments, on a parl� de �a et cetera. On a fait le tour de tout donc c'est bien. 

Parfait parfait donc on va pouvoir terminer avec ce que je voulais vous dire. Ah non, il y a un petit point que je voulais vous dire, Que je n'ai pas not� en plus, c'est quand m�me important parce que c'est arriv� aussi avec Java vite 8 si je ne dis pas de b�tises.

Interface fonctionnelle
=======================

Il y avait la notion d'interface fonctionnel c'est-�-dire qu'avec Java 8, on a inclus, on a introduit en tout cas ce qu'on appelle les interfaces fonctionnelles. 

Et l'interface fonctionnelle, c'est tr�s simple, c'est une interface qui ne qu'une seule et unique m�thode abstraite. 

En gros, moi ce que j'ai fait si vous voulez savoir �a. 

Flyable.java
------------

package jachampagne;

interface Flyable
{
	public void fly(String energy);
}

Donc du coup je regarde puisqu'on a modifi� des trucs apparemment c'est bon.
Il n'y a pas le mot-cl� abstract, je rappel. j'aurais m�me pu mettre comme �a :

Flyable.java
------------

package jachampagne;

interface Flyable
{
	void fly(String energy);
}

J'aurais pu mettre �a comme �a (sans public) parce que de toute fa�on dans une interface c'est public qu'on le veuille ou pas, c'est comme �a. 

Mais ici comme il n'y a qu'une seule m�thode abstraite dans mon interface, on dit que c'est une interface fonctionnelle. 

Et d'ailleurs souvent on peut utiliser, �a me fera parce que c'est pas fait au moment o� je fait la vid�o mais on abordera pas mal de notation comme �a (@FunctionalInterface).

Flyable.java
------------

package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);
}

On verra pas mal de notation comme �a (@FunctionalInterface), ouvrez qu'en Java on a des notations comme �a avec un @ et on a un mot pr�cis suivant des endroits du code avec des choses bien sp�cifiques pour indiquer des choses au compilateur. 

je n'ai pas fait au moment o� cette vid�o est faite, la vid�o le tuto n'a pas �t� fait mais de toute fa�on vous aurez un tutos sur tous ces �l�ments l�, c'est petit mot que l'on peut mettre � droite � gauche pour indiquer tout un tas de choses au compilateur et vous verrez de quoi il retourne bien en d�tail dans ce tutoriel. 

FunctionalInterface, Pour dire simplement que l� on a une interface fonctionnelle et �a permet simplement apr�s au compilateur, � la compilation, de voir que si jamais on s'est gour� quelque part, il vous dira : "bah hein tu t'es tromp�, ton interface fonctionnelle n'est pas vraiment fonctionnelle donc il y a quelque chose qui ne va pas ". 

en gros si vous voulez par exemple vous dire : "je veux absolument faire une interface fonctionnelle " Eh bien en utilisant ce genre de terme (FunctionalInterface), �a permet de forcer � avoir effectivement une interface fonctionnelle. Je ne rentre pas tellement dans les d�tails parce qu'on le verra bien � part dans une autre vid�o d�di� notamment pour ces choses-l�, notamment les mots : override et cetera. 

On l'abordera aussi donc ce genre de tutoriel l�. 

Donc en gros c'est �a puisqu'on parle simplement de m�thode abstraite, rien n emp�cherait de faire aussi pour une interface fonctionnelle, des m�thodes statiques parce qu'une m�thode statique peut �tre utilis� sans utiliser une classe qui impl�mente et sans instancier quoi que ce soit. 

Rappelez-vous, une m�thode statique c'est juste "tu mets le nom de l'�l�ment en question, tu mets 2 petits points et le nom de ta m�thode, voil� et tu peux l'appeler sans probl�me". �a fonctionne �videmment de cette mani�re donc il faut bien le prendre en compte. 

Les m�thodes par d�faut
=======================

Nous avons �galement un autre cas qui est arriv�. Je vais terminer cette s�ance, on va terminer cette s�ance avec �a concernant les m�thodes par d�faut. �a a �t� �galement introduit, j'esp�re ne pas me tromper de ce que je me souviens Mais si je me trompe pour ceux qui font d�j� du Java, si je me suis gour� dans le num�ro de version, Vous pourrez �ventuellement me faire le retour dans les commentaires, n'h�sitez pas mais pareil il me semble qu'avec Java 8, on a aussi introduit en plus de pouvoir utiliser des m�thodes statiques dans les interfaces... on a vu aussi les interfaces fonctionnelles, ce nouveau concept on va dire. On a aussi la possibilit� de faire des m�thodes par d�faut. 

La m�thode par d�faut c'est assez simple aussi, On va faire, on va mettre n'importe quoi. On fait "default public void test()".

Flyable.java
------------

package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);
       default public void test();
}

C'est vraiment juste pour tester pour vous montrer comment �a marche. 
En gros on va voir �a exceptionnellement parce que c'est une m�thode par d�faut, je vais pouvoir impl�menter dans l'interface. 

Flyable.java
------------

package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);

    default public void test()
    {
		System.out.println("Test"); 
    }
}

je vais pouvoir impl�menter dans l'interface. Avant � l'�poque �a n'existait pas. Il y a m�me des langages d'ailleurs, c'est pour �a que je vous dis que c'est diff�rent, il y a d'autres langages de programmation avec du paradigme objet qui ne permettent pas de faire �a donc �a c'est vraiment propre � Java. Java permet de faire des m�thodes par d�faut, ce qu'on n'aurait pas forc�ment dans tous les langages qui permettent de faire de la programmation Objet donc attention ici c'est une exception o� les m�thodes par d�faut dans une interface ne fonctionnera pas dans tous les langages la programmation orient�e objet qui permettent d'utiliser les interfaces, attention. 

Donc ici en gros on a �a, on utilise ce mot cl� default qui veut dire ben j'impl�mente mais exceptionnellement, c'est une exception, j'impl�mente du code dans une interface, chose qui avant Java encore une fois  si je ne me trompe pas, ne permettait pas de le faire. 

Et comment �a fonctionne bien tout simplement, si la classe qui impl�mente notre interface, red�finisse donc impl�mente cette m�thode test et bien elles utiliseront leur propre m�thode de test et sinon C'est cette impl�mentation l� :

    default public void test()
    {
		System.out.println("Test"); 
    }

Eh bien c'est cette impl�mentation l� qui sera ex�cut� par d�faut, c'est tout c'est juste �a. 

C'est par exemple je fais c.test() et s.test() :


App.java
--------
*/
import jachampagne.*;

public class App
{
	public static void main(String[] args)
    {
		Cottage c = new Cottage();
		Ship s = new Ship();

		c.fly("Carbone");
		s.fly("Mana");

       c.test();
       s.test();
	}
}
/*
Si je fais c.test() et s.test(), comme l� elles ont toutes les 2, pas impl�ment� cette m�thode, Ben ils appelleront �a va afficher test pour les 2.

Donc on va faire un cas � part pour Cottage.java :

Cottage.java
------------

package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
    {
    	System.out.println("Parcelle en place...");
    }
    public void build(String material)
    {
    	System.out.println("Construction du batiment en " + material);
    }
    public void fly(String energy)
    {
    	System.out.println("Je me propulse dans les airs avec du " + energy);
    }
	public void test()
	{
		System.out.println("Mon test � moi !");
	}
}

Donc on va faire un cas � part pour Cottage.java. L'autre disait "test" et si on va mettre "mon test � moi". Vous voyez c'est tr�s Possessive cette classe donc du coup elle fait son propre test.

Donc un compile tout �a ici on n'a pas fait d'erreur. 

	>javac App.java
	>java App
	Parcelle en place...
	Je me propulse dans les airs avec du Carbone
	Je me propulse dans les airs avec du Mana
	Mon test a moi !
	Test

On compile tout �a, on voit qu'on n'a pas fait d'erreur, on voit que la chaumi�re qui a impl�ment� la m�thode test(), utilise sa propre m�thode et l� pour le coup du navire comme il n'a pas impl�ment� cette m�thode et comme elle est marqu�e comme �tant par d�faut (Flyable.java) gr�ce au mot-cl� default. Si il n'y est pas vous aurez une erreur �videmment parce qu'il faut bien tout impl�menter dans une interface si ce n'est pas une m�thode par d�faut mais l� comme s'en est une Eh bien ce sera cette m�thode qui sera utilis�e du coup pour le navire.

Et voil� la m�thode par d�faut comme son nom l'indique, default public void test() donc c'est une m�thode par d�faut. 

Voil� je vais terminer avec �a, c'est un petit bonus. J'aurais pu ne pas vous en parler mais je tenais � vous en parler parce que c'est arriv� avec Java 8 normalement et du coup c'est toujours bien de savoir qu'il y a �a, que vous ne soyez pas surpris si un jour vous tombez dessus en vous disant et Ben mince que j'ai toujours entendu que dans une interface, on impl�mentait rien est bien l�, il y a de l'impl�mentation Donc je ne comprends plus !

Donc c'est un c'est emb�tant, c'est assez confus.

donc l� en tout cas vous avez cet exemple et c'est assez simple � voir parce que l� dessus, le langage Java et tr�s verbeux c'est-�-dire qu'on a des mots pour indiquer tout. 

Donc ici (Flyable.java) :


Flyable.java
------------

package jachampagne;

@FunctionalInterface
interface Flyable
{
	public void fly(String energy);

    default public void test()
    {
		System.out.println("Test"); 
    }
}

Donc ici "public void fly(String energy)", On comprend que ce n'est pas impl�ment� mais l� " default public void test()", on comprend que �a l'est parce qu'il y a ce petit mot cl� magique, le default, qui nous indique que c'est une m�thode par d�faut.

Et je vais en terminer la, �a fait 40 minutes de vid�o, on aura bien fait t�t concernant les interfaces, j'esp�re que �a vous a permis de bien comprendre cette nouvelle notion. 

Ca vous permet aussi de bien l� compl�ter avec les classes abstraites d'accord parce que le principe pour moi en tout cas c'est que vous ayez bien compris quand utiliser l'un et quand utiliser l'autre. 

Si on peut r�sumer le plus simplement m�me si ce n'est pas exhaustif, encore une fois la classe abstraite, vous avez des classes qui ont des liens �troits et donc des �l�ments communs. Vous pouvez les hi�archiser via une classe abstraite et comme vous avez des classes qui peuvent �tre compl�tement ind�pendantes, vous pourriez avoir besoin de leur apporter des fonctionnalit�s bien pr�cises sans qu'elles aient, elle-m�me c'est classe la des liens entre elles. Eh bien on va te passer par une interface. 

N'oubliez pas une interface pour revenir au sch�ma, c'est un contrat qui vous dit je propose une API, donc un ensemble de fonctionnalit�s tout simplement mais sans forc�ment savoir comment je vais le faire. 

	Vehicule (abstract)		Flyable	Building (abstract)
		^				^	^		^
		|				|	|		|
Glider ------------- Ship --------+	+----	Cottage 

Sans forc�ment savoir comment je vais le faire et tous ceux qui veulent l'utiliser, Eh bien ils vous diront comment ils impl�mentent �a, comment est-ce qu'on peut voler. 

C'est un petit peu comme si vous vous disiez que je veux que telle chose fasse telle chose et apr�s vous demandez � quelqu'un de se d�brouiller pour que �a fonctionne. Vous n'avez pas besoin de savoir comment il le fait tant que �a le fait, c'est �a l'interface. Interface c'est vraiment un contrat qui engage donc la classe qui impl�mente (Cottage.java) � devoir impl�menter ce que poss�de l'interface (Flyable.java).

Si vous avez compris tout ce que j'ai dit sur cette vid�o, sur la vid�o concernant la classe abstraite, vous aurez compris pratiquement tout l�-dessus et �a permettra aussi de terminer sur ce gros passage de secours Java avec la prochaine s�ance concernant le polymorphisme c'est-�-dire que tout ce qu'on a vu l� sur les classes abstraites les interfaces permettre de faire du polymorphisme. 

Ce sera le sujet de la prochaine s�ance et vous allez voir c'est tr�s tr�s pratique �a fait gagner beaucoup de lignes de code ensuite pour le d�veloppeur.

Du coup, je vous laisse avec cette fin de vid�o j'esp�re que �a vous a plu. On se retrouvera pour la prochaine s�ance pour le polymorphisme. 

Et s'il y a des questions comme d'habitude, n'h�sitez pas � les laisser dans les commentaires. 

� bient�t tout le monde.

*/
