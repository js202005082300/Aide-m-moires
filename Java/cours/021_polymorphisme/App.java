/*

Java #21 - polymorphisme

Bonjour et bienvenue sur cette 21e s�ance o� nous allons parler de polymorphisme. 
On a vu pr�c�demment o� en tout cas on va pouvoir clore une grosse grosse  partie de ce cours en Java concernant les classes, la construction de classe, le principe d'h�ritage et les 2 derni�res vid�os qu'on a vues � savoir les classes abstraites et les interfaces Pour appliquer pas mal de nouveaux principes au niveau de votre code en programmation orient� objet. 
On va du coup, terminer avec le polymorphisme qui �tait un petit peu l� finalit� de l'utilisation de ces classes abstraites et de ces interfaces. 
J'esp�re que � ce stade de la formation Vous avez bien compris la diff�rence entre les 2 donc quel cas on va se servir d'une classe abstraite et dans quel cas on va se servir d'une interface.
Et l� je vais vous montrer ce qui est le polymorphisme, en quoi �a consiste et qu'est-ce que �a va vous permettre de faire au niveau de votre code. 
On va reprendre le m�me sch�ma vu pr�c�demment :

	Vehicule (abstract)		Flyable	Building (abstract)
		^				  ^	^		^
		|				  |	|		|
Glider ----+-------- Ship --------- +	+----	Cottage 

Le m�me sch�ma vu pr�c�demment c'est-�-dire les 2 classes abstraites, Vehicle et Building, On va voir des classes concr�tes qui h�ritent pour chacune de ces classes abstraites donc Ship, Glider et Cottage. 
Et on aura une interface donc toujours pareil Flyable et avec 2 classes concr�tes qui les impl�mentent. 
Donc on consid�re dans notre impl�mentation, dans notre code, quel navire est capable de voler. C'est pour �a qu'il impl�mente cette interface (Flyable) et � l'instar la chaumi�re �galement est capable de voler donc elle impl�mente cette interface.
En terme de code, j'ai l�g�rement r�duit ce dernier pour le surplus qui n'�tait pas utile pour cette s�ance, je remonte tr�s rapidement. 
Vous avez l'interface Flyable.

Flyable.java
------------

package jachampagne;

public interface Flyable
{
	public void fly();
}

Vous avez l'interface Flyable, pas de souci par rapport � �a. Notre Vehicle, tr�s rapidement.

Vehicle.java
------------

package jachampagne;

abstract public class Vehicle // extends Object
{
	protected int mMovementSpeed;

	abstract public void moveXY(int x, int y);
}

Notre v�hicule, tr�s rapidement. On va par parler des petites m�thodes ici "abstract public void moveXY()". C'est pour avoir un minimum de code quand m�me, ne pas avoir des classes vide non plus. 

On a tout �a (Ship.java), je rappelle la m�thode Fly parce que le navire peut voler. 

Ship.java
---------

package jachampagne;

public class Ship extends Vehicle implements Flyable
{
	public Ship()
	{
		this.mMovement = 16;
	}

	public void moveXY(int x, int y)
	{
		System.out.println("Le navire brasse les flots et se d�place en " + x + ", " + y);
	}

	public void fly()
	{
		System.out.println("Le navire est propulse dans les airs");
	}
}

Le navire peut voler. Bon je rappelle �a c'est son comportement � lui, je rappelle que le principe de l'interface, c'est de fournir une � API en surcouche O� l'on dit que cette API, si tu l'impl�mente tu vas �tre du coup capable de faire ceci ceci et cela Mais si tu veux impl�menter cette API, il faudra que tu expliques comment tu le fais. 
Donc il faudra d�finir pr�cis�ment concr�tement le comportement pour chacune des m�thodes de l'interface donc ici on en avait qu'une pour rester sur quelque chose d'assez court donc on l'a bien impl�ment� l�.
Et la chaumi�re, m�me chose, on lui a impl�ment� son propre comportement personnel, � elle, dans sa mani�re de pouvoir voler, d'�tre capable de voler.

Cottage.java
------------

package jachampagne;

public class Cottage extends Building implements Flyable
{
	public Cottage()
	{
       	
    }

    public void build(String material)
    {
       	System.out.print("Constraction du batiment en " + material);
	}

	public void fly()
	{
		System.out.println("La chaumiere s'eleve peu a peu dans les airs");
	}
}

Donc �a c'est un m�lange, parce qu'il ne faut pas h�siter � m�langer classe abstraite et interface parce que �a a vraiment une utilit� diff�rente donc on peut parfaitement les associer tous les 2 et vous allez voir ce que �a permet par la suite. 

Alors le polymorphisme, premier point tr�s important et souvent qui pr�te � confusion Pour les gens qui d�butent en programmation et surtout en programmation orient�e objet, c'est que les gens ont a l'impression que le polymorphisme en tout cas l'utilisation de classe abstraite et de l'interface parce que c'est la base de polymorphisme vont lui permettre de gagner du temps en termes de code, de lignes de code, ou de rendre les choses plus pratique au niveau m�me de la d�finition des fameuses classes et des interfaces alors que pas du tout. 

Certes au niveau de classe abstraite comme je l'ai expliqu�, donc l� ces classes abstraites permettent de factoriser le code donc d'�viter la r�p�tition de code entre classes concr�tes �troitement li�es entre elles donc on va forc�ment gagner quelques lignes de code, c'est �vident. 

Mais ce n'est pas le principe m�me du polymorphisme ou en tout cas du polymorphisme et des interfaces qui m�ne au polymorphisme. 

Le polymorphisme �a va beaucoup plus loin que �a et �a intervient surtout c'est-�-dire que l'utilit� m�me et l'application m�me du polymorphisme va arriver et va se voir au moment de l'utilisation de vos classes et de ces diff�rentes classes qui soit h�ritent de classe abstraite, soit impl�mentent des interfaces.

Cela en fait, lors de l'usage que vous allez voir la puissance est l'utilit� du polymorphisme.

Et c'est justement ce que nous allons faire :


Premi�rement, on va faire :

App.java
--------


import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		
    }
}

Premi�rement on va faire comme si on n'avait pas pr�vu d'architecture (sch�ma), pr�vu d'architecture � base de classe abstraite et interface grosso modo ou en tout cas juste le point basique. 

	Vehicule (abstract)		Flyable	Building (abstract)
		^				  ^	^		^
		|				  |	|		|
Glider ----+-------- Ship --------- +	+----	Cottage 

D�j� si on n'avait pas le lien, ce serait assez compliqu� car comme je vous l'avais expliqu� il faudrait que toutes les classes concr�te aient en fait leurs m�thodes impl�ment�es. Il faudrait que v�hicule aient toutes les m�thodes impl�ment�es parce que ce serait une classe concr�te si on prenait un autre exemple, il faudrait tout refaire pour Ship, Glider et cetera et cetera. Donc plein de r�p�tition Le code, pas de chose tr�s pratique et comme je l'avais expliqu� sur la s�ance concernant les interfaces, si on peut se on n'utilise pas d'interface, en gros il faut qu'on mette du coup la capacit� de vol dans certaines classes mais il faudrait quand m�me de l'h�ritage pour que �a puisse profiter � l'autre donc bref soit on aura de la r�p�tition de code soit on avait tr�s mauvaise conception en fait au niveau du code. 

Et si on veut faire �voluer ce code par la suite, ajouter de nouveaux �l�ments, on devra tout recommencer, on devra m�me retouch� aux anciennes classes pour ajouter des nouvelles. 

Ce n'est absolument pas int�ressant et surtout pas coh�rent dans la mani�re de programmer. Si par exemple demain, Je veux ajouter une moto comme v�hicule, si je dois commencer � modifier le code du navire, du planeur ou m�me du v�hicule si on avait une classe abstraite encore une fois. Ce n'est pas bon du tout. Une moto, elle devrait �tre ind�pendante, elle va profiter de tout ce que poss�de un v�hicule mais m�me si elle a des relations �troites avec le navire, on ne devrait pas avoir � toucher au code du navire si on a cr�� moto.

Qui plus est, si admettons vous en tant que d�veloppeur d�velopper justement une classe pour repr�senter une moto et admettons que c'est un autre d�veloppeur qui poss�de ce code l� :

Glider ----+-------- Ship

Si c'est un autre d�veloppeur qui poss�de ce code-l�, vous allez faire comment ? Vous allez demander � l'autre d�veloppeur ? Tu m'explique comment, navires et cetera je dois modifier ton code ? C'est juste pas possible et impensable.
Du coup on a r�solu le probl�me, je l'ai bien expliqu�. C'est pour �a que je fais un petit rappel ici avant de continuer sur la suite du principe m�me des classes abstraites, des interfaces qui ont permises de r�soudre pas mal de probl�mes de ce c�t� l�. 
Et voici � l'usage ce que �a va donner.
D�j� � partir sur la base m�me, le minimum qu'on puisse faire gr�ce aux interfaces et aux classes abstraites pour appliquer un d�but de polymorphisme, vraiment doucement. 

2 navires, 1 planeur et 2 chaumi�res
====================================

Premi�re chose qu'on savait faire, moi j'aimerais par exemple cr�� par exemple en tant qu utilisateur, Ben je voudrais qu'il y ait 2 navires, un planeur et 2 chaumi�res. On peut faire �a comme �a. 
Au strict minimum si m�me � la limite on n'avait pas d'interface ou de classe abstraite admettons que ici Vehicle n'existe pas et que building n'existe pas. Comment est-ce qu'on ferait tout cela? 2 navires, un planeur, 2 chaumi�res ? Eh bien on ferait beaucoup de r�p�titions de code. 
Donc en gros, je vais le faire rapidement comme �a on modifiera au fur et � mesure Pour que vous voyez petit � petit ce qu'am�ne les classes abstraites et les interfaces et du coup ce qu'on appelle le polymorphisme et vous allez vite comprendre l'utilit� et tout ce que �a va vous faire gagner et tout les b�n�fices Que �a va apporter au niveau de votre code. 


App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
       }
}

Bon j'ai mes deux navires. Qu'est-ce qu'avait demand� le client ? Le client avait demand� un planeur virgule il veut un planeur, donc on lui donne un planeur, pas de probl�me.

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
    }
}

Et les 2 chaumi�res :

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();
    }
}

Pour �tre plus rapide, on fait du copi�-coll�, on n'h�site pas.
Comme j'�cris suffisamment vite je me permets de ne pas en faire. 
Voil� okay, on a cr�� des objets on a instanci� de ce qu'on voulait. 
Maintenant ton navire, enfin le premier navire je veux qu'il se d�place et je veux ensuite qu'il vol, admettons OK. 
Tu veux faire �a virgule pas de probl�me. L� encore on part du principe on n'a pas de classe abstraite et pas d'interface, on part vraiment ce principe l�. 
Donc le premier, on voulait quoi ? On voulait le d�placer. 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
    }
}

Je vais mettre n'importe quoi "s1.moveXY(145, 85)", c'est pour l'exemple. 
Ils veulent ensuite le faire voler. Rappelez-vous j'avais mis une �nergie pour les param�tres de Fly, je le enlever pour ne pas perdre de temps sur cette vid�o. 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();
    }
}


On va rester comme �a. Pas de probl�me c'est fait.
Bon le navire num�ro 2, on ne fait rien avec. Pas de probl�me. 
Le Glider, on va le d�placer. 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);
    }
}

Ensuite comme j'ai d�j� �crit une classe abstraite (Vehicle.java > moveXY), �a va utiliser une classe abstraite mais on part du principe qu'il n'y en avait pas donc il aurait fallu �crire du code, r�p�ter du code � droite � gauche partout et partout. 

Et pour cottage, d�j� j'avais une r�p�tition ici (Cottage c1/c2 = new Cottage). On va faire voler les 2 chaumi�res. C'est deux points Fly.

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}

J'ai pas fait grand chose Si vous regardez bien. je n'ai pas eu grand chose � faire. On n'a pas demand� de cr�er grand-chose, on n'a pas demand� beaucoup d'action pourtant �a fait d�j� pas mal de code et on voit tr�s vite beaucoup de r�p�titions aussi. Nous, le principe avec le classe abstraite et notamment les interfaces, on a vu qu'on avait des �l�ments en fait g�n�rique, des fonctionnalit�s g�n�riques. Par exemple le vol, c'est une capacit� qu'on a mis au point (Flyable.java). Il y a des �l�ments qui peuvent partager cette capacit�, et qui en plus n'ont pas forc�ment de lien parce que encore une fois notre chaumi�re n'est absolument pas li�e �troitement avec notre navire pourtant ils ont tous les 2 quand m�me une fonctionnalit� commune qu'on leur a permis d'impl�menter qui est le vol. Ceux qui m'emb�te, c'est que je ne profite pas de tout �a (App.java), c'est-�-dire que sans interface en classe abstraite, je suis oblig� pour chaque �l�ment de faire �a : 

		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();

		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();

Et si demain encore une fois on veut cr�er une nouvelle classe, on va devoir rajouter tout un tas ... on va devoir d�j� modifier, cr�er une nouvelle classe. �a c'est d�j� une chose, ce n'est pas un souci de cr�er une nouvelle classe quand on a une nouvelle entit�, �a c'est normal, on le ferait dans tous les cas par contre on va devoir modifier �galement d'autres classes et dans App.java, On va devoir faire tout un tas d'utilisation, bref on va m�langer plein d'informations et on ne va pas forc�ment respecter chaque donn�e. En gros on va commencer, la chaumi�re va m�ler des informations propres navires et inversement alors qu'ils ne sont pas cens�s faire �a. Ce n'est pas parce que tous les 2 ont la capacit� de voller que du coup le navire doit accepter et doit avoir des informations sur la chaumi�re et inversement. On peut pas commencer � tout m�langer. 

Donc premi�re chose qu'on pourrait faire et �a c'est gr�ce en classe abstraite, on a un d�but de polymorphisme et on va s'en servir. On va se servir du principe de polymorphisme li� pour le coup juste � nos classe abstraite donc au lieu de faire �a :

		Ship s1 = new Ship();
		Ship s2 = new Ship();

et �a : 
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

Nous ce qu'on a dit et on va au niveau du chemin, c'est en fait que �a :

Glider ----+-------- Ship

... Que ce soit les navires ou les planeurs et �ventuellement d'autres classes, il faut toujours penser � l'�volution future que pourrait avoir notre projet, notre code. 
Ce sont quoi en fait ? Ce sont des v�hicules. Si on dit que ce sont des v�hicules, c'est parlant en termes de code. 
Que dans les v�hicules il peut y avoir des navires, il peut y avoir des planeurs et peut-�tre que dans un an il y aura encore autre chose. 
Voil� �a au niveau du code, je veux le voir appara�tre et l� je ne le vois pas et c'est un peu dommage parce que si on utilise pas, on ne fait pas de polymorphisme alors pourquoi on s'en batte � cr�er cette classe (Vehicle.java) qui a par, mettre des �l�ments l� quel factorise. Elle ne servirait qu'� �a, qu'� factoriser du code. C'est un petit peu dommage de faire une classe juste pour factoriser du code, nous on cherche � plus d'avantages plus de b�n�fices donc on va rajouter quelque chose donc pour moi tout �a ce sont des v�hicules :

		Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();

Tout �a ce sont des v�hicules. Donc moi ce que je vais faire, ce que j'ai appris en tant que d�veloppeur et vous l'avez appris aussi � faire ... � ce stade de la formation vous n'avez pas vu d'autres types de stockage et de collection, On a appris � faire des tableaux Eh bien pour moi �a ce sont des v�hicules, pourquoi je ne pourrais pas faire un tableau de v�hicule apr�s tout ? je peux faire �a. 
Vous savez qu'un tableau g�n�ralement �a ne peut porter qu'un seul type, soit vous faites un tableau d'entiers soit un tableau de cha�nes de caract�res et pour le class, la r�gle, il n'y a pas d'exception C'est soit vous allez devoir faire un tableau de navires ou un tableau de planeurs ou un tableau de chaumi�res mais �a encore une fois �a ne va pas r�soudre le probl�me parce que �a veut dire que je vais devoir faire un tableau pour stocker mes 2 navires, un tableau pour stocker un seul planeur et un tableau pour stocker 2 chaumi�res. 

La syntaxe du polymorphisme
===========================

Les V�hicules
-------------

Et c'est l� notamment qu'intervient la classe abstraite et l� on attaque le polymorphisme vraiment au niveau de la syntaxe. 
Vous allez pouvoir faire ceci : 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

       Ship s1 = new Ship();
		Ship s2 = new Ship();
		Glider g1 = new Cottage();
		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}

Je met Vehicle[] someVehicles, on nomme la variable pour monter qu'il y en a plusieurs et ici, j'en ai 3 donc je vais mettre ceci : new Vehicle[3].

Il y en a peut �tre en voyant �a qu'ils vont se dire bah je ne comprends pas : "l� tu cr�e des v�hicules alors que c'est une classe abstraite (abstract public class Vehicle), Tu nous a expliqu� avant qu'une classe abstraite on pouvait pas l'instancier.".

Si vous regardez le code, je ne l'ai pas instancier :

	Vehicle[] someVehicles = new Vehicle[3];

Je ne l'ai pas instancier, j'ai d�clar� un tableau de type Vehicle et l� je dis que mon tableau je lui alloue 3 espaces pour pouvoir stocker des v�hicules. C'est tout � fait coh�rent puisqu'on a vu qu'en termes d'h�ritage ici (sch�ma), notre navire c'est un v�hicule. C'est absolument vrai. 

Notre planeur c'est un v�hicule aussi donc il n'y a pas de probl�me en termes de code de dire, on va stocker 3 v�hicules. Aucun souci. 

L� o� par contre �a va changer, c'est � l'instanciations. Ce que vous faites directement ici apr�s la d�claration, pour l'affectation.

Moi je vais le faire � la ligne pour que ce soit beaucoup plus lisible pour vous, je vais faire simplement ceci :

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

		Cottage c1 = new Cottage();
		Cottage c2 = new Cottage();

		s1.moveXY(145, 85);
		s1.fly();

		g1.moveXY(169, 26);

		c1.fly();
		c2.fly();
    }
}

Et bien someVehicle[0], c'est mon premier navire. Je fait �a :

	someVehicle[0] = new Ship();

On va copier coller pour gagner du temps. Il n'y a quand m�me pas mal de code � faire sur cette vid�o mine de rien.

et hop pour le 2e et ensuite pour le 3e �l�ment de ce tableau de v�hicule, je fait le planeur et l� pas de probl�me. on instancie pas des v�hicules parce qu'on ne peut pas. Si vous mettez new Vehicle(), �a ne marchera pas parce que c'est une classe abstraite.

Par contre on dit que l� (Vehicle[] someVehicles = new Vehicle[3]) tu r�serve 3 emplacements. Imaginez un parking, un garage, ce sera un peu bizarre. Vous dites qu'il y a de la place pour trouver v�hicule quelconque. On sait qu'il y a de la place pour 3 v�hicules et au moment on a besoin de r�server ces places, l� on est oblig� de dire concr�tement quel v�hicule va occuper chaque place (someVehicle[0] = new Ship()). C'est pour �a qu'on ne peut pas instance une classe abstraite, une classe abstraite c'est trop vague �a ne veut rien dire en termes de concret. 

Par contre on dit que la premi�re classe on va les r�server pour un navire (someVehicle[0] = new Ship()) qui est v�hicule donc c'est bon, La 2e pour un navire aussi, c'est un v�hicule et la 3e pour un planeur, c'est un v�hicule et c'est bon. �a c'est ce qu'on appelle du surclassement :

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

En gros �a reviendrait � dire que dans un emplacement de v�hicule, tu stock un navire et le v�hicule c'est la super classe, c'est la classe parentes d'un navire donc on fait du surclassement ou le terme anglais Upcasting s'il y en a qui s'int�ressent un petit peu au terme anglais par rapport � �a. Donc les 3 lignes ci-dessus, c'est de Upcasting. 

Et c'est un des premiers principes, c'est du polymorphisme. �a veut dire qu � partir d'un �l�ment g�n�rique, notre classe abstraite, on peut r�server un tableau de cette classe abstraite et ensuite on y stock tous les �l�ments concrets que l'on veut. 

Si demain, j'ai un d�veloppeur qui sort une moto. Pas de probl�me si j'ai besoin d'une moto par exemple ici � la place de someVehicle[1] = new Ship() :

		someVehicle[0] = new Ship();
		someVehicle[1] = new Moto();
		someVehicle[2] = new Cottage();

On ferra new Moto() et c'est tout. Termin� parce que le v�hicule ne changera pas, que si j'avais fait un tableau de planeur Glider[], d�j� on pourra y stocker que des planeurs, on ne pourrait pas stocker de navires essaye plus tard il y a des motos on pourra encore moins stocker des motos donc ce n'est du coup pas du tout pratique au niveau de l'utilisation Et au niveau de l'application d'un code. De cette mani�re on utilise le polymorphisme, pour dire que nos v�hicules ont un comportement g�n�rique et quand on a besoin d'avoir quelque chose de concret, c'est leur comportement concret qui sera appliqu� la en l'occurrence c'est leur constructeur pr�cis, sp�cifique (Ship, Moto, Glider) qui sera appel� pour le stocker. 

Voil� pour la premi�re chose. 

Les b�timents
-------------

Ensuite on va faire �a pour les b�timents. Vous avez pig� le principe, on fera �a pareil pour les b�timents. 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

		Building[] someBuildings = new Building[2];

		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		s1.moveXY(145, 85);
       g1.moveXY(169, 26);
       
		s1.fly();
		c1.fly();
		c2.fly();
    }
}

Je pense que vous avez pig� le principe, le b�timent vous ferez �a pareil. Building[] someBuildings �gal new Building et on en met 2 parce que j'en ai fait que 2. Et on fait le m�me principe :

		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

Et � partir de l�, j'ai 2 �l�ments qui doivent se d�placer :

		s1.moveXY(145, 85);
       g1.moveXY(169, 26);

Vous avez appris en informatique, que r�p�ter du code, qu'il faut �viter. Eh bien �a, on va le factorise. On peut factoriser ce genre de chose. 

Et bien ici on ne va pas forc�ment factoriser parce que �a ne concerne pas tous les �l�ments. En gros on va changer un petit peu par rapport � �a pour que �a correspond bien �videmment � notre code. 

		someVehicles[0].moveXY(145, 85);
       someVehicles[2].moveXY(169, 26);

Pareil, ici on va reprendre le m�me �l�ment en essayant de pas se tromper par rapport aux noms qu'on avait mis :

		s1.fly();
		c1.fly();
		c2.fly();

On fait juste des remplacements pour virer les noms qui n'existent plus par rapport � mon code. 

		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();


Pour s'y retrouver un peu mieux on va faire les choses comme �a.
Donc on a d'abord lettre v�hicule et ensuite on a des cons et voler le premier qui est un navire et les 2 chaumi�res qui devaient voler. Pas de probl�me, �a c'�tait juste de remplacement. 

App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Vehicle[] someVehicles = new Vehicle[3];
		Building[] someBuildings = new Building[2];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		someVehicles[0].moveXY(145, 85);
       someVehicles[2].moveXY(169, 26);
       
		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
    }
}

Donc �a vous voyez c'�tait un d�but, �a c'est le b�n�fice de votre classe abstraite. Gr�ce � la classe abstraite Vehicle et votre classe abstraite Building, vous pouvez faire �a. si vous n'avez pas de classe abstraite et que vous essayer de faire ce genre de code son classe abstraite, �a ne marchera pas. 

Vous n'avez qu'a tester de votre c�t�, vous pouvez essayer et vous comprendrez que sans classe abstraite tout ceci est impossible. Vous serez oblig� de cr�er encore une fois un tableau pour 2 navires, un tableau pour un planeur et cetera et cetera. Et faire tout un tas d'actions pour chacun Et si demain il y a un nouveau v�hicule qui est cr�� Eh bien il faudra faire un nouveau tableau et cetera et cetera. 

Alors qu'ici on travaille toujours sur le m�me tableau mais plus tard vous apprendrez � g�rer des espaces de stockage dynamique. Donc on pourrait se dire : "tiens maintenant il y a des motos dans mon v�hicule c'est bien facile tu agrandis ton garage". C'est quand m�me plus simple de faire �a que de dire bah tiens on va cr�er un tout nouveau garage juste pour les motos mais du coup si on avait besoin d'une petite place pour un navire Ah bah tant pis, il faudra recr�er un tout nouveau garage pour les navires et je pense que vous comprenez un petit peu le probl�me que �a ferait donc l� en termes de co�t, de ressources, utilisation de ressources informatiquement parlant, c'est juste pas possible. Ce n'est pas du tout �conome de ce c�t�-l�. 

Donc �a c'est le premier principe et encore une fois le b�n�fice de la classe abstraite. 

Nous on va aller plus loin.

Pour le moment, je n'ai pas envie de faire tout de suite d�placer �a :

		someVehicles[0].moveXY(145, 85);
       someVehicles[2].moveXY(169, 26);

Je vais juste faire voler tous ces �l�ments comme ceci : 

		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();


Je vais avoir un navire et 2 chaumi�res que je vais vouloir faire voler. 
Il y a un truc pratique qu'on a inclus ici dans notre impl�mentation, c'est l'interface Flyable. Est-ce qu'il n'y a pas moyen via l'interface d'avoir un b�n�fice suppl�mentaire qui est de dire : ce n'est pas en fait des navires qu'on veut faire voler, ce n'est pas des chaumi�res que l'on veut faire voler ou je ne sais quoi qu'il y aurait beaucoup plus tard. Encore une fois on pense � l'�volutivit� du code. On veut juste faire voler tout ce qui est capable de voler. Je pense que c'est suffisamment clair pour tout le monde. Tout ce qui est capable de voler on va leur dire tu voles. Termin� et sans savoir ce qui peut vraiment voler, ind�pendamment de sa. 

C'est si t'es capable de voler, tu voles. Si t'es pas capable de toute fa�on tu ne voleras pas. Ce sera aussi simplement r�gler. 

Donc gr�ce � l'interface, on peut aussi b�n�ficier du polymorphisme et aller encore plus loin. 

Cr�er un tableau de notre interface
===================================

Donc on va faire tout �a. On va cr�er un tableau de notre interface. Tout �a, c'est assez nouveau pour vous. 

On va mettre Flyable[] elements parce que je n'ai pas de nom pr�cis pour �a et je vais dire, on stocke 3 �l�ments capable de voler.


App.java
--------

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = new Flyable[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();
		someBuildings[0] = new Cottage();
		someBuildings[1] = new Cottage();

		someVehicle[0].fly();
		someBuildings[0].fly();
		someBuildings[1].fly();
    }
}

En stock 3 �l�ments capables de voler. On aura 3 emplacements 3 �l�ments quelconque, capable de voler. On est d'accord qu'en terme de classe, nos b�timents sont ind�pendants des v�hicules :

	Vehicule (abstract)		Flyable	Building (abstract)
		^				  ^	^		^
		|				  |	|		|
Glider ----+-------- Ship --------- +	+----	Cottage 

Nos b�timents, ils sont ind�pendants des v�hicules. 
Pourtant l'interface ici (sch�ma) comme elle impl�mente certains v�hicules et certains b�timents impl�mente cette interface H� bien On a quelque part , indirectement, un lien entre ces derniers. 
Ils ont un point commun, c'est que le navire et la chaumi�re peuvent voler et on va se servir de ce point commun dans la syntaxe du langage Java pour faire du polymorphisme et gagner encore ici en ligne de code, on aura moins de lignes de code il y en aura quelque chose qui �volue plus facilement et sans se poser la question Qu'est-ce que tu as comme v�hicule ? qu'est-ce que tu as comme b�timent ?
on sen fiche, nous tout ce qu'on veut savoir ...on sait qu'il y a des �l�ments qui veulent voler et on veut aller faire voler. Apr�s on se d�brouille c'est derri�re ce sont des chaumi�res o� peu importe, de toute fa�on on a expliqu� ou un d�veloppeur quelconque, ext�rieur � nous, � impl�menter leur comportement � eux, personnel. 

Mais nous on veut juste les faire voler virgule on s'en fiche de savoir comment est-ce que le navire va se d�brouiller pour voler. Moi je veux juste le faire voler, je ne veux pas savoir comment ils le font. Je veux juste qu'ils veulent ! 

Donc pour faire �a, on va d�j� virer le code ici :

		Vehicle[] someVehicles = new Vehicle[3];
		Building[] someBuildings = new Building[2];

Je fais �a et d'ailleurs je vais faire directement pour changer un petit peu l� syntaxe, pour que vous ayez les 2 possibilit�s :

		Flyable[] elements = new Flyable[3];

		someVehicle[0] = new Ship();
		someVehicle[1] = new Ship();
		someVehicle[2] = new Cottage();

ou

		Flyable[] elements = {new Ship(), new Cottage(), new Cottage()};

Entre accolades, le premier c'est un navire, le 2e c'est une chaumi�re et le 3e c'est encore une chaumi�re. L� je le mets directement ici apr�s la d�claration Plut�t que de le faire � la ligne d'apr�s histoire que vous ayez 2 syntaxes possibles pour faire �a. 

Premi�re chose et je veux que ces 3 v�hicules volent. 

Donc vous voyez ici je me suis amus� presque � tout effacer.

Je vais dire, pour chaque �l�ment qui veulent donc c'est de Flyable, je vais mettre 'e' qui sont dans (:) le tableau �l�ments. Donc �a vous savez faire c'est la boucle for un peu sp�cial qu'on a vu.

Eh bien ces �l�ments-l� tu vas les faire voler : e.fly();

Termin�.

App.java
--------


import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = {new Ship(), new Cottage(), new Cottage()};
		
		for(Flyable e : elements)
			e.fly();
    }
}

Voil�, imaginez que ce code l� je n'ai pas, imaginez que tous les autres fichiers (Flyable, Cottage, Glider, Ship et Vehicle.java), c'est un autre d�veloppeur qui les a. Eh bien je n'ai pas besoin de les avoir ces fichiers, moi tout ce que je voulais ou en tout cas ce que le client voulait, c'�tait un navire et 2 chaumi�res et il veut les voler ces 3 �l�ments. Eh bien voil� juste en faisant �a (code ci-dessus) parce que je sais qu'ils sont dot�s de la capacit� de vol et qu'il y a une m�thode qui s'appelle Fly qui permet de les faire voler, et bien en 3 lignes de code je peux faire voler 3 �l�ments qui sont dans des classes concr�tes diff�rentes qui n'ont aucun lien �troit, qui appartiennent h�ritent ou en tout cas qui h�ritent chacun � leur mani�re d'une classe abstraite distincte mais qui ont un �l�ment commun C'est � dire l'impl�mentation d'une interface qui leur donne la capacit� de voler. 

Mais gr�ce � toutes ces relations (sch�ma) que ce soit de la hi�rarchie via l'h�ritage (Vehicle > Ship ou Building > Cottage) o� l'impl�mentation (Ship > Flyable < Cottage), le profil de cette API viens en surcouche pour la chaumi�re et le navire. On est capable en moins de code possible et amp quelque chose de beaucoup plus g�n�rique, de dire, tu vas voler. 

Et bien �videmment comme il faut toujours montrer que �a marche, on va compiler tout �a :

	>javac App.java
	>java App
	Le navire est propulse dans les airs
	La chaumiere s'eleve peu a peu dans les airs
	La chaumiere s'eleve peu a peu dans les airs

Donc tous les �l�ments sont en train de voler sans probl�me, ind�pendamment. Demain je veux rajouter un autre navire Eh bien pas de probl�me, je fais: 
App.java
--------
*/

//import jachampagne.*;
//
//public class App // extends Object
//{
//	public static void main(String[] args)
//	{
//		Flyable[] elements = {new Ship(), new Ship(), new Cottage(), new Cottage()};
//		
//		for(Flyable e : elements)
//			e.fly();
//    }
//}

/*

Vous voyez une petite modification et termin�e. 

       >javac App.java
       >java App
       Le navire est propulse dans les airs
       Le navire est propulse dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       La chaumiere s'eleve peu a peu dans les airs

Et voil� �a vole. 
Et on s'arr�tera l�. C'est tout ce que je voulais vous montrer. C'est �a le polymorphisme, c'est vraiment la finalit� de tout ce qu'on a vu pr�c�demment sur les classes abstraites et les interfaces, on a vu qu'il y avait du polymorphisme dans les 2 cas. On va cr�er l'id�e que plus tard, on va am�liorer ce code c'est-�-dire qu'on rajoute autre chose. Allons-y. 

Ajouter autre chose
===================

Eh bien mes Glider, mes planeurs. Les planeurs, on va partir du principe qu'ils planent mais ne peuvent pas voler qu'ils n'ont pas de syst�me de propulsion, de syst�me pour stabiliser et cetera. 

On va juste dire, on va faire, rajouter la moto qui fait partie, qui va h�riter de v�hicule.

	Vehicule (abstract)		 Flyable	Building (abstract)
		^				 ^	^ ^		^
		|				 |	| |		|
Glider ----+-------- Ship ---------	| ---- Cottage 
		|				    	|
		Moto ------------------------

Moto, elle va h�riter de Vehicle comme les autres et je veux qu'elle aussi, elle soit capable de voler.

Donc on y va, on veut cr�er une moto. Pareil, ici c'est moi qui travaille tout seul sur le m�me code mais dites-vous que dans des cas plus r�el, on n'est pas forc�ment un d�veloppeur � travailler sur un projet tout seul. Il y a plein d'exemples de projets ou c'est une entreprise compl�te o� il y a 10 20 50 250 personnes qui travaillent sur le m�me projet donc vous vous doutez bien que les gens ne travaillent pas sur les m�mes fichiers. Chacun a des fichiers � lui et jamais il va avoir besoin d'aller voir ce que fait l'autre donc ces fichiers. C'est important tout fonctionne bien ensemble � la base m�me si bon Il y a �videmment des bugs comme partout mais on arrive � faire fonctionner tout ce que d'ensemble. 

Donc on y va, on cr�e une classe moto, on cr�e Moto.java (copie de Ship.java, renomm� en Moto.java).

Moto.java
---------

package jachampagne;

public class Moto extends Vehicle implements Flyable
{
	public Moto()
	{
		this.mMovementSpeed = 250;
	}

	public void moveXY(int x, int y)
	{
		System.out.println("je vais super vite !!");
	}

	public void fly()
	{
		System.out.println("Plein gaz, la moto decolle et s'en va dans les nuages");
	}
}

Ce n'est plus Ship mais Moto.
Elle h�rite bien de la classe Vehicle. 
Elle impl�mente la capacit� (Fly) elle est capable de voler par rapport � �a.
La moto se d�place assez vite, allez on est � fond, la moto c'est 250 kilom�tres heure. On est fou apr�s c'est pas beaucoup un 250 pour une moto, on a des motos qui vont beaucoup plus vite que �a. 
MoveXY provient de Vehicle. Il faut obligatoirement la re-impl�menter. Enfin bref on va dire que la moto se d�place : "je vais super vite !!". 
Attention c'est dangereux si vous roulez en vrai sur une moto, ne pas d�passer la limite autoris�e sur la route. 
Et pour le vol, la moto elle va voler un peu � sa mani�re. On dira : "Plein gaz, la moto d�colle et s'en va dans les nuages" et cetera et cetera. 
On fait �a et l� en tant qu'utilisateur, on se dit Ben l� maintenant je veux pouvoir faire voler une moto. 
Et l� encore une fois tel que je l'ai montr� tout � l'heure, on ajoute une moto :

App.java
--------
*/

import jachampagne.*;

public class App // extends Object
{
	public static void main(String[] args)
	{
		Flyable[] elements = {new Ship(), new Ship(), new Cottage(), new Cottage(), new Moto()};
		
		for(Flyable e : elements)
			e.fly();
    }
}
/*

Comme je l'ai montr� tout � l'heure, on fait �a (new Moto()). C'est tout.

Il y a eu besoin de cr�er un nouvel �l�ment, termin�. 
Je n'ai jamais retouch� � la classe v�hicule, je n'ai pas eu besoin d'aller voir les autres types de v�hicule et je n'ai pas eu besoin non plus de toucher � l'interface Flyable. 
J'ai juste cr�� mon nouvel �l�ment, la moto. 
J'ai cr�� ma nouvelle classe, �a il faut bien le faire on ne peut pas l'�viter. On cr�e une nouvelle entit�, il faut bien cr�er le fichier et faire la classe et apr�s l� o� j'en ai besoin Donc l� c'est dans ma m�thode main Mais �a peut �tre ailleurs Dans un autre code, n'importe o�, dans n'importe quel fichier. 
D�s que j'ai envie d'utiliser une moto, voil� comme la moto fait partie des �l�ments capables de voler, pas de probl�me �a fonctionne.
On peut produire un code g�n�rique et vous voyez sans modifier quoi que ce soit ... je vais ex�cuter �a :

       >javac App.java
	>java App
       Le navire est propulse dans les airs
       Le navire est propulse dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       La chaumiere s'eleve peu a peu dans les airs
       Plein gaz, la moto decolle et s'en va dans les nuages

Et voil�, " Plein gaz, la moto decolle et s'en va dans les nuages".
Voil� la moto vol comme le reste des �l�ments qui sont capables de voler. 
�a c'est le polymorphisme, tout simplement. 
Je pense qu'on va pouvoir s'arr�ter l� parce que de toute fa�on on a fait le tour de tout, c'est pour �a que j'avais r�parti toutes ces notions a plusieurs vid�os car comme �a on termine la dessus et je trouve que c'�tait bien de finir cette grosse partie du cours Java sur le polymorphisme pour dire que oui tout ce que vous avez vu avant sur les classes abstraites, les interfaces, l'h�ritage et cetera vous permet � l'usage, attention ce n'est pas dans les d�finitions, dans les impl�mentations dans tous les fichiers mais dans l'utilisation, c'est de la r�utilisation de code dans l'utilisation de ces �l�ments (App.java) et l� vous allez gagner du temps en termes de code mais �galement en terme d'�volution de votre code parce que tel que je voulais montrer avec la moto, je peux faire �voluer mon programme et il y a plein de choses o� je n'aurai pas besoin de retoucher. 
Parce que si vous recommencer encore une fois � devoir retoucher tous les v�hicules parce que vous ajoutez une moto, c'est un d�faut de conception. 
C'est que d�j� � la base vous avez mal pens� votre code et qu'il y a un probl�me de ce c�t� et peut �tre faut-il mettre en place une relation d'h�ritage, classe abstraite o� l'ajout d'une fonctionnalit� enfaite, d'un ensemble de fonctionnalit�s en surcouche c'est-�-dire une interface. 
Je vous laisse avec cette partie-l�, j'esp�re que la vid�o �tait suffisamment explicite, suffisamment d�taill�e. 
L� pour le coup il y a eu beaucoup beaucoup d'exemples que je vous ai donn� sur cette derni�re vid�o parce qu'il en fallait. Il y a des notions tr�s rapide tr�s simple � expliquer et il y en a d'autres ou je pr�f�re multiplier le nombre d'exemples et les modifications pour que vous puissiez voir plusieurs sc�narios possibles et pour qu � la fin de cette vid�o vous vous dites : "OK c'est bon, j'ai compris, je sais ce qu'est une interface, une classe abstraite, j'ai compris le polymorphisme et si un jour je fais encore en Java, je serai exactement quand est-ce que je dois utiliser et je sais surtout � quoi �a va me servir et ce que �a va m'apporter au niveau de mon code."
� bient�t pour une nouvelle vid�o sur la cha�ne et n'h�sitez pas � r�agir dans les commentaires si vous avez une question ou quoi que ce soit et � partager bien �videmment ce contenu pour d'autres d�veloppeurs qui pourrait se mettre comme vous au langage Java. 
Ciao 
*/
