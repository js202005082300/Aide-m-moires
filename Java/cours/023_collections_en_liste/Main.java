/*
Java #23 - collections en liste
Bonjour � tous bienvenue pour cette 23e s�ance en Java. 
La derni�re fois nous avions fait une introduction assez rapide sur les collections dans ce langage de programmation.
Nous allons aborder ensemble quelques exemples de classes que vous allez pouvoir utiliser. 
Je vais vous montrer un petit peu de code sur ces derni�res, je vous expliquerai, on passera un bon petit moment pour en parler, sur les sp�cificit�s de chaque classe de collection en Java pour savoir dans quel contexte plut�t utiliser l'une que l'autre parce que c'est g�n�ralement le genre d'erreur que l'on va tr�s tr�s souvent donc c'est bien de partir l�-dessus pour que vous sachiez que dans tel contexte, vous utiliserez plut�t telle collection Et dans un autre contexte plut�t une autre. 
On va partir sur un exemple ou en tout cas sur un code tr�s tr�s simple, tr�s basique, je veux agrandir mon �diteur pour que vous ayez quelque chose de suffisamment grand. Je vous montre �a rapidement, tr�s rapidement. 
Main.java
-------------
public class Main
{
	public static void main(String[] args)
	{
		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
}
}
Cat.java
----------
public class Cat
{
	private String mName;
	public Cat(String name)
	{
		this.mName = name;
	}
	public void meow()
	{
		System.out.println(this.mName + ": Meow !");
	}
}
Je vous montre �a rapidement tr�s tr�s rapidement, une simple classe Cat avec un attribut mName "private String mName", un constructeur ici "public Cat(String name)". Et une m�thode meow() qui fait simplement afficher le nom du chat et qui le fait miauler.

Au niveau de notre classe ici main, J'ai instanci� et au travers de 3 variables, 3 chats.  Nous avons donc 3 chats qui existent maintenant toutdoux, papi et maki.

� partir de l� on va pouvoir aborder ensemble tout �a. 

Petit rappel 
==========

Petit rappel, pr�c�demment je vous avais montr� quelques sch�mas sur la vid�o d'introduction. �a a �t� mis bien s�r sur le github puisque que je vous en avais parl� donc vous avez tout dans le d�p�t FormationVideo/ressources/Java.
Et ensuite vous trouver Collection - Interface avec ce petit sch�ma que je vous avais montr� et ce qui va �tre int�ressant aussi, c'est la partie Collection - Classes parce que vous allez retrouver un petit peu l'ensemble des classes, une bonne partie de l'ensemble que nous allons voir et notamment un tableau qui nous indiquera tout un tas d'�l�ments qui sont sp�cifiques � chacune des classes. 
Je vais r�sumer tr�s tr�s rapidement comme �a m'�vitera de revenir dessus et on en parlera ensuite par apr�s. 

Collection - Classes
-------------------------

Il y a certaines collections qui sont ordonn�es � ne pas confondre avec une affaire de tri, le fait de trier les donn�es, mais ce sera une affaire de donn�es qui seront ordonn�es, bien organis�.
Il y a certaines collections qui peuvent accepter ou non les doublons, la pr�sence ou non de valeurs identiques. 
L'acc�s direct, je vais en parler par la suite, c'est le fait qu'en lecture de pouvoir acc�der � l'�l�ment directement ou alors en effectuant un parcours pour le trouver. 
Le fait d'accepter ou non des valeurs nulles, �a c'est tr�s important aussi de le savoir. 
Et le fait de savoir si la collection permet de travailler dans un environnement Thread-safe ou non. C'est-�-dire thread-safe, c'est pour travailler dans du multi-thread� et quand ce n'est pas thread-safe, c'est tout simplement sur du mono-thread�, avec un multicoeur. 
Donc �a c'�tait pour les diff�rents �l�ments que je voulais vous donner, vous avez tout sur le github si besoin Comme �a vous pourrez le consulter comme bon vous semble. 

Par rapport � �a, nous allons voir ensemble 4 des classes que je vous ai montr�es. 
4 qui sont quand m�me assez importantes, je vais d'ailleurs les mettre ici en commentaire comme �a vous aurez quelques notes, voil� : 

	/
		ArrayList	:
		LinkedList 	:
		Vector		:
		Stack		:
	/

Nous allons voir ArrayList, Vector, LinkedList et un cas un peu particulier qui est Stack.
Stack est d'ailleurs une classe sp�cialis�e de Vector, Stack h�rite de Vector, pour information. �a c'est bien de le savoir aussi.  
Donc c'est un Vector mais un peu plus sp�cialis�. 
Voil� comment �a fonctionne. 
Pour faire simple, pour r�sumer un petit peu, ces 4 classes permettre de travailler avec des informations ordonn�es, d'accord. 
Elles acceptent aussi de travailler avec des doublons I elles acceptent �galement les valeurs nulles. 
Tr�s important car c'est plus tard vous travaillez avec des donn�es qui pourrait �ventuellement �tre nulles, si vous travaillez avec une collection qui ne les acceptent pas, vous aurez bien �videmment des probl�mes au niveau votre programmation. Attention � ce niveau mais �a ce sont les particularit�s de ces 4 l�. 
Donc informations ordonn�es, acceptent les doublons et acceptent les valeurs nulles. 
Donc �a c'est quelque chose reconna�tre. 
Pour la suite, on va de toute fa�on r�sum� pour la suite et on verra un petit peu ce qu'il en est. 

On y va, donc ici j'ai 3 chats qu'on a instanci�s l� et nous allons cr�er un ensemble. 

Main.java
-------------
public class Main
{
	public static void main(String[] args)
	{
		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Souvenez vous pr�c�demment virgule on avait vu ensemble dans les premi�res vid�os du cours, les tableaux. Les tableaux, si vous vous souvenez, �a fera une petite piq�re de rappel, permettent de stocker des informations de mani�re fixe c'est � dire que nous avons un conteneur , une sorte de connexion, on peut l'appeler comme �a mais on va �viter ce terme l�  pour ne pas trop vous embrouiller qui est � taille fixe. 
On va dire par exemple qu'on r�serve 4 emplacements pour stocker 4 instances de chat, de Cat, et on ne pourra pas en stocker en plus. Si on veut en stocker une 5e, et bien dommage, on avait un container � taille fixe, il va falloir cr�er un nouveau container � partir de l�. 
Pour pallier � ce probl�me qui n'en est pas forc�ment un Parce que dans certains cas �a peut �tre utile et m�me recommand� de travailler avec des conteneurs � taille fixe. 
On a besoin �ventuellement d'avoir un conteneur, en tout cas une connexion, un conteneur � taille dynamique c'est-�-dire qu'il peut �voluer au fur et � mesure de l'ex�cution du programme. 
De se dire, peut �tre qu'au d�part, on aura 3 emplacements mais peut �tre que au cours de l'ex�cution va devoir passer � 5 � 6 � 10 et cetera. 
Il faut que nous ayons un containeur dynamique et pour cela il y a des classes ici et en l'occurrence ces 4 l� : 
	/
		ArrayList	:
		LinkedList 	:
		Vector		:
		Stack		:
	/
Et en l'occurrence ces 4 l� qui vont impl�menter l'interface List donc cette interface (sch�ma collection interface) qui elle-m�me h�rite de collection. Tr�s important � ce niveau l�. 
Donc �a les 4 classes que je vous montre appartient � �a, � List. 

Interfaces
==========
 
+--------------------------+		+-----------+
|       Collection         |		|   Map     |
+------+-----------+-------+		+-----------+
| List |    Set    | Queue |		| SortedMap |
+------+-----------+-------+		+-----------+
       | SortedSet | Deque |
       +-----------+-------+
Ces classes appartiennent � list sur lequel nous allons nous int�resser pour le moment. 
� partir de l�, diff�rents �l�ments vont pouvoir �tre utilis�s. 
Pour faire tr�s simple, histoire de ne pas trop vous perte � ce niveau-l�, ArrayList, vous pouvez le voir comme les tableaux, ce sont les tableaux mais dynamique en Java. D'accord, pour faire tr�s tr�s simple, voil� comme �a fonctionne. 
�a reprend notamment tout un tas de propri�t� comme l'acc�s direct, ce genre de choses, comme je vous l'avais d'ailleurs indiqu�. 
En exemple assez similaire, nous avons Vector mais Vector va permettre de travailler dans un environnement multi-thread. C'est � dire qu'il est thread-safe. 
Donc ici on va avoir :

	/
		ArrayList	:	mono-thread
		LinkedList 	:
		Vector		:	multi-thread
		Stack		:
	/

D'accord, tr�s important. 

	/
		ArrayList	:	mono-thread, acc�s direct,
		LinkedList 	:
		Vector		:	multi-thread, acc�s direct,
		Stack		:
	/

Ce qui est important aussi de savoir, c'est qu'on va avoir pour ces deux-l� un acc�s direct aux informations comme je l'ai dit, ils sont assez similaires sachant qu'ici on va avoir surtout une distinction entre mono-thread et multi-thread finalement. Dans tel cas, on utilise l'un ou l'autre. Si on est sur du mono-thread�, on va plut�t utiliser ArrayList sinon on utilisera un Vector. Donc �vitez d'utiliser un Vector dans un programme quelconque Et je pense qu'en majorit� vous allez �tre sur un environnement mono-thread sinon vous allez tout simplement perdre en performance, donc vous allez plut�t travailler l�-dessus, �a c'est � savoir.
Ici nous n'avons pas d'acc�s en direct et au niveau de la Stack non plus c'est-�-dire que pour chercher une information, il va falloir parcourir le conteneur, parcourir la Collection jusqu'� trouver la valeur que nous voulons lire. Ce n'est pas un acc�s direct avec un indice comme on a dans les tableaux, donc �a c'est des informations � prendre en compte.
Pour la suite on va faire un petit peu au fur et � mesure et je vous donnerai des commentaires pour vous donner de plus amples informations sur ces diff�rentes classes. 

ArrayList
=========
On va commencer par ArrayList donc je vais faire ici en gros un tableau, un simple tableau dynamique pour pouvoir y stocker ici les chats (Main.java). 

Main.java
---------

public class Main
{
	public static void main(String[] args)
	{
		ArrayList

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Vous indiquez d'abord le nom de la classe (ArrayList). Comme c'est une classe particuli�re qui n'est pas pr�sente de base, il faut l'importer, c'est notamment dans java.util, il y a beaucoup de choses dans la classe utilitaire de Java. Et ici on va mettre directement java.util.ArrayList.

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Encore une fois, je vous ai donn� l'habitude d'importer que le strict n�cessaire pour vos programmes. On pourrait tr�s bien faire : 

	import java.util.*;

On pourrait tr�s bien faire .* mais �a veut dire qu'on n'apporte absolument tout. Personnellement je pr�f�re importer seulement ce dont on a besoin Et en plus �a permet de voir directement le nom de mani�re plus explicite et identifier ce dont on a import� directement au niveau de notre programme. Je trouve personnellement que c'est beaucoup plus lisible beaucoup plus clair. 

� partir de l� nous allons devoir indiquer entre chevrons le type de donn�es que nous allons pouvoir stocker l�-dedans et l� c'est aussi encadreur assez fr�quent que l'on retrouve en Java puisqu'on ne va pas pouvoir utiliser des types primitifs. Rappelez-vous les primitifs se sont int, float, double et cetera et ceter. Tout ceux qui s'�crivent notamment en minuscules. 
Ces types primitifs ne fonctionnent pas, vous devrez travailler directement avec les classes correspondantes si besoin. 
On peut travailler avec Float, Boolean, Integer, pourquoi pas avec String. On peut parfaitement faire une ArrayList de cha�ne de caract�res et nous, c'est l'int�r�t de la vid�o, c'est de faire �a au niveau de nos chat "ArrayList<Cat>".

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat>

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

On met un nom, je vais appeler cela un groupe "group" et on va faire "new ArraList<Cat>()". Ici au niveau de notre constructeur, on indique aucun argument. Vous verrez que pour certaines classes, il y a un argument qui peut �tre assez int�ressant � utiliser au niveau de l'appel au constructeur mais on abordera, en fait c'est ici qu'on pourra le voir. Je confondais avec LinkedList, mais effectivement ArrayList, on va pouvoir passer un argument �ventuellement. 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>();

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Au niveau des collections il va y avoir 2 informations � prendre en compte qui sont tr�s importantes. Vous allez avoir la capacit� qui finalement se distingue (!=) de la taille. 

	/
		ArrayList	:	mono-thread, acc�s direct,
		LinkedList 	:
		Vector	:	multi-thread, acc�s direct,
		Stack		:

		Capacit� != Taille
	/


La capacit� c'est le nombre d'emplacement disponible pour votre collection. Par exemple si je fais �a :

	ArrayList<Cat> group = new ArrayList<Cat>(5);

J'indique ici que je cr�� une ArrayList qui poss�de une capacit� de 5, qui va pouvoir accepter finalement 5 chats mais n'oubliez pas ce sont des collections dynamiques c'est-�-dire que si � un moment donn�, j'en ai d�j� 5 et que je vais en ajouter un 6e, automatiquement �a va fonctionner c'est dynamique c'est-�-dire que la machine virtuel va voir pour allouer un espace suppl�mentaire pour pouvoir ajouter un nouveau chat et automatiquement comme il y a une nouvelle allocation � faire, il y a des traitements suppl�mentaires. 

L� o� il est int�ressant parfois de pr�ciser la capacit� au d�part au niveau du constructeur, �a va �tre tout simplement au cas par cas.

Admettons ici que vous savez au niveau de l'ex�cution de votre programme, qui si votre groupe "group", il sera au minimum de 10, �a veut dire que vous savez qu'il y aura au minimum 10 chats � stocker Eh bien ce sera plus int�ressant de faire ceci "<Cat>(10)" : 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");
	}
}

Il est plus int�ressant de faire ceci, tout simplement parce que vous allez �viter de faire des traitements suppl�mentaires inutiles. Si vous ne mettez rien, �a va prendre une taille par d�faut. �a va prendre 1, Ce genre de chose. Et lorsque vous allez vouloir ajouter le 2e, �a va faire une allocation suppl�mentaire, le 3e une allocation suppl�mentaire et cetera et cetera. 
On va enfaite rajouter des traitements suppl�mentaires pour la location Qui vont permettre d'agrandir la capacit� de notre collection. 
Alors d�s le d�part on aurait pu dire bon On sait qu'il y en aura au moins 10 donc on peut faire �a "<Cat>(10)", d'accord il n'y a pas de probl�me l� dessus. 
Attention, la capacit� c'est toujours sup�rieur (>), je met l'inverse, ce serra mieux (Taille <= Capacit�). La taille est toujours inf�rieure ou �gale � la capacit�. 

	/
		ArrayList	:	mono-thread, acc�s direct,
		LinkedList 	:
		Vector		:	multi-thread, acc�s direct,
		Stack		:

		Taille <= Capacit�
	/


La taille c'est le nombre d'�l�ments que vous avez effectivement dans votre collection La capacit�, c'est le nombre d'emplacement qu'elle peut accepter au maximum. 
Donc quand on aura ajout� nos 3 chats, la taille ce sera 3 et la capacit� ce sera 10 si on prend l'exemple ici.

add()
=====

Et nous allons les ajouter, � partir de l� comment on travaille sur notre interface de liste ArrayList. ArrayList Impl�mente notre interface de liste, on va avoir acc�s � tout un tas de m�thodes et la m�thode pour ces collection-l� qui impl�mente List, c'est la m�thode add(). Donc c'est tr�s facile � faire, on fait "group.add" : 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);
	}
}

C'est tr�s facile � faire, on aurait pu faire une boucle, �ventuellement mais bon cette histoire que vous comprenez bien. On ajoute les 3 �l�ments et apr�s comme on avait d�j� vu comment faire dans la s�ance pr�c�dente. On fait une petite boucle foreach, donc on va faire chat sur group :

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
On fait une petite boucle foreach, et on fait chat sur group et comme la m�thode meow(), print directement, donc pour chaque chat on appelle la m�thode meow(). J'esp�re que l� vous avez bien pig� le principe, c'est vraiment tr�s tr�s simple. Normalement l� vous ne devez pas �tre perdu si vous ne comprenez pas l'usage, les instanciations, l'usage de m�thodes, la boucle foreach, ce que vous avez alors beaucoup beaucoup d'autres choses � revoir sur les vid�os pr�c�dentes. 

On y va, on fait une petite compilation Il a vouvoy� chacun des chats Toudoux, Popy, Maki, effectivement �a appelle bien la m�thode, �a fonctionne, OK.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

OK pas de probl�me � ce niveau-l�. �a appelle bien la m�thode, pratique au niveau de ces informations. 
Ce qui est g�nial et c'est l� tout l'int�r�t de toujours pareil, des classes, du polymorphisme, des interfaces, tout �a que Java utilise � foison, il y a beaucoup beaucoup de classe, beaucoup d'interface qui sont utilis�s, impl�ment� et cetera pour pouvoir le code le plus simple possible c'est-�-dire qu'on travaille toujours au niveau des interfaces. D'ailleurs ici j'ai mis ArrayList "ArrayList<Cat>...", J'aurais pu carr�ment passer par un autre nom, un nom beaucoup plus abstrait pour faire ce genre de choses et pr�ciser un peu plus au niveau du constructeur mais bon �a, c'est un d�tail, ce n'est pas tellement le probl�me.
L'avantage ici c'est qu'on va pouvoir faire tout un tas de choses comment passe virgule on impl�mente la m�me interface "import java.util.ArrayList;", on sait automatiquement que tous ceux qui impl�mente cette interface de liste poss�de les m�thodes de cette interface qui elles sont marqu�es, c'est comme un contrat, rappelez-vous les interfaces qui disent voil� que si tu impl�mente tes interfaces, tu as forc�ment toutes les m�thodes qui sont impl�ment�es de cette interface. 

Donc ici admettons si je passe bient�t sur un environnement multi-thread, Eh bien ici je vais simplement remplacer ma ArrayList par Vector.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Vector<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
Et ce qui est bien, petite recompilation, �a fonctionne.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

�a fonctionne, vous voyez que je n'ai pas touch� au reste du code, c'est les m�mes m�thodes tout pareil. 
C'est juste le nom de la classe qui change mais c'est le m�me fonctionnement. 
C'est pour �a que les d�butants, les gens qui d�butent et cetera se m�lange parce qu'ils se disent "je ne comprends pas" car finalement ils voient que ces 2 classes sont la m�me chose et font la m�me chose Ben au final ils se disent qu'ils ont fait une classe de trop en Java. 
Non, ils n'ont pas fait une classe en trop en Java, elles ont chacune leur sp�cificit� et il faut les conna�tre. 
ArrayList, c'est du mono-thread et Vector, c'est pour du multi-thread. 
Moi dans mon cas, c'est du mono-thread donc �videmment utiliser un Vector ici n'est vraiment pas une bonne id�e. 
Donc on revient sur ArrayList. 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

		for(Cat c : group)
			c.meow();
	}
}

Okay, donc �a c'est tr�s simple. 
Ce qu'on va pouvoir faire aussi, tr�s rapidement je vais aller assez vite. 
Donc tout ce que je vous ai montr�, c'est pour tout ces �l�ments comme �a et notamment en acc�s directe pour ArrayList et Vector, on peut afficher un �l�ment en particulier. Une fois qu'on a ajout� tout �a (retir� la boucle foreach). 

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

	}
}

Une fois qu'on a ajout� tout �a, on peut par exemple dire "System.out.println()" et de faire un group.get() et tu m'affiche par exemple l'�l�ment � l'indice 0, �a va afficher une chose un peu bizarre comme on avait vu pr�c�demment, souvenez-vous. 
�a a marqu� Cat@ et une adresse.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//		
//		System.out.println(group.get(0));
//	}
//}
/*
Voil�, vous voyez cat@ et une adresse. 

	>javac Main.java
	>java Main
	Cat@5ca881b5

Donc il a bien acc�d� � l'�l�ment d'o� encore une fois ce fameux acc�s direct. On met en index comme le tableau � taille fixe qu'on avait pr�c�demment, on acc�de � l'�l�ment rapidement. Pas de parcours � faire, on demande d'acc�der directement � cet index, c'est un appel direct c'est tr�s tr�s rapide et c'est vraiment fait pour �a. 
C'est aussi ce c�t� important, c'est que ce fameux ArrayList est justement optimis� pour la lecture, d'accord et �a il faut vraiment vraiment y pr�ter attention. Je vais vous noter ici si vous avez bien compris, c'est la m�me chose aussi pour Vector parce que c'est de l'acc�s direct.

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:

		Taille <= Capacit�
	/

Forc�ment � contrario on n'aura pas la m�me chose avec LinkedList et Stack. Ces 2 l� n'�tant pas en acc�s direct, ils ne sont absolument pas optimis�s pour de la lecture. 
Par contre, on va le voir un peu ici, elles sont optimis�es pour l'�criture, on va mettre plut�t insertions rapides, ce sera plus logique. 

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	

		Taille <= Capacit�
	/

Les Stack, on va en parler un peu, c'est un cas particulier.
Voil�, qu'est-ce qu'on a comme m�thode aussi ? Parce que je vous en avais montr� plein. On a la m�thode remove qui permet de retirer des �l�ments, qu'est-ce qu'on peut faire ? Apr�s au niveau du parcours je vais vous montrer aussi quelque chose mais on va rester sur quelque chose d'assez simple que vous saviez faire d�j� (remettre la boucle foreach).   

Main.java
---------

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		ArrayList<Cat> group = new ArrayList<Cat>(10);

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Popy");
		Cat c3 = new Cat("Maki");

		group.add(c1);
		group.add(c2);
		group.add(c3);

		for(Cat c : group)
			c.meow();
	}
}

remove()
========

Et hop, pareil ici on va enlever un �l�ment. Comme c'est pour de l'acc�s, si on fait remove().
Si on fait remove de 1, c'est cens� enlever Popy, je crois. 

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.remove(1);
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
Voil� l'affichage et Popy a disparu. D�sol� Popy, ne vous inqui�tez pas il va bien.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !
	Toudoux: Meow !
	Maki: Meow !


On a pas mal de m�thode et je vous invite comme toujours parce que je ne peux bien �videmment pas tout vous �num�rer et surtout que �a ne servira � rien de vous �num�rer tout ce qui existe comme m�thodes issues de la documentation. Vous avez une documentation Java et vous allez retrouver tout un tas de m�thodes qui sont disponibles. 

Apr�s il y a les m�thodes pour r�cup�rer l'index, pour dire un tien � quel index est situ� lui. Bref on a plein de m�thodes qui sont utiles � ce niveau-l�. 

Vous avez toutes les m�thodes qui sont bien s�r assez g�n�rique c'est-�-dire propre � ces 4 classes, notamment add() que vous allez retrouver, addAll(), c'est par exemple, va pas toutes les voir surtout que j'en avais apport� quelques-unes dans la vid�o d'introduction pr�c�dente.

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	insertions rapides

		Taille <= Capacit�

		add(), addAll(), remove()
		clear(), size()
	/


add(), �a c'est pour ajouter un �l�ment pr�cis.
addAll(), C'est si vous voulez carr�ment ajouter une collection dans une autre. Si vous avez plusieurs collections que vous voulez fusionner et cetera. �a peut �tre pas mal pratique. 
remove(), qui est �videmment g�n�rique c'est-�-dire propre � ces 4 classes. 
clear(), qui permet d'effacer et cetera. 

D'ailleurs si je fais un clear() pour �ffacer quelque chose qui n'existe plus. 

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.clear();
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
Voil� pas de probl�me par rapport � �a.

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !

Pareil, petite parenth�se, Ben vous voyez que les vid�os sont de plus en plus longues � mesure qu'on avance dans les notions, je ne fait pas forc�ment v�rification de tout ce qui se passe mais comme je voulais expliquer notamment sur la vid�o sur les exceptions, je voulais dire � partir du moment vous manipulez des classes n'importe quoi en fait notamment des appels de m�thode qui peuvent �ventuellement d�clencher des exceptions et �a bah le seul moyen de le savoir ce n'est pas le deviner, c'est encore une fois se renseigner au niveau de la documentation. 
Vous isoler �a (les group.add) dans un bloc try catch pour traiter les erreurs �ventuelles qui pourrait se produire. 

Donc l� �videmment il n'y a aucun bloc try catch qui a �t� fait l� mais il faudra le faire parce que si par exemple j'essaie de retirer un �l�ment qui n'existe pas Ben automatiquement on se doute bien que �a ne va pas le faire. Bah c'est par exemple je veux dire tire moi l'�l�ment d'indice 10. Je sais qu'il n'y a pas d'�l�ments d'indice 10 parce qu'on n'a pas autant de choses.

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(10);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//
//		group.remove(10);
//
//		for(Cat c : group)
//			c.meow();
//
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Popy: Meow !
	Maki: Meow !
	Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 10 out of bounds for length 3

Il a forc�ment une grosse exception qui a �t� g�n�r�e qui n'est absolument pas trait�e donc attention M�me si vous voyez que je ne le fais pas en vid�o parce que �a rallongerait �norm�ment �norm�ment, tout ce que je vous ai dit pr�c�demment sur les choses � faire et cetera et cetera. Eh bien ce n'est pas parce qu'on aborde d'autres notions que ce n'est plus � expliquer.

C'est toujours le cas, lorsque vous travaillez ici avec le code, diff�rentes interfaces de classe de Java, s'il y a possibilit� que des exceptions soient g�n�r�s, il faut les prendre en compte et les traiter. 

Minimum c'est un bloc try catch sur la capture d'exception, Vraiment la plus globale si vous voulez et bien s�r dans le meilleur des cas de faire des choses beaucoup plus pr�cises, d'affiner les exceptions que vous capturez alors �a c'est � vous de le faire sur vos vrais programmes, de ne pas vous contenter de faire des appels de m�thode o� l'on v�rifie rien du tout donc attention � �a. 

Apr�s il y a plein de m�thodes, Par exemple il y a une m�thode pour transformer une collection en tableau c'est-�-dire en Array en taille fixe en Java ou l'inverse, on peut passer d'un tableau en taille fixe � une collection. 

capacity() et size()
====================

Il n'y a pas mal de choses comme �a "toArray()" et autres. On a size() qui va �tre pas mal utile notamment. 

On va faire genre, capacit� de 5 �l�ments et on va en ajouter 2.
C'est �a que je cherche � faire et on peut faire :

       System.out.println("Capacite : " + group.capacity());

Ce qui est bien c'est que les noms sont suffisamment clairs, capacity(), on peut pas faire plus simple plus explicite. C'est quand m�me bien choisi au niveau du nommage. On se retrouve bien et l'avantage c'est qu'on va retrouver le m�me dommage d'une collection � l'autre. �a c'est quand m�me bien pratique. 
Et l� c'est size() :

       System.out.println("Taille : " + group.size());

Main.java
---------
*/
//import java.util.ArrayList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>(5);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		//group.add(c3);
//
//       	System.out.println("Capacite : " + group.capacity());
//       	System.out.println("Taille : " + group.size());
//
//
//	}
//}
/*
	>javac Main.java
	Main.java:721: error: cannot find symbol
			System.out.println("Capacite : " + group.capacity());
													^
	  symbol:   method capacity()
	  location: variable group of type ArrayList<Cat>
	1 error

Qu'est-ce que j'ai fais ? �a n'a pas �t� capacity.
Pourtant je suis bien s�r une ArrayList. 
�a devrait fonctionner...
Peut-�tre que je suis juste sur Vector.capacity

Main.java
---------
*/
//import java.util.Vector;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Vector<Cat> group = new Vector<Cat>(5);
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		//group.add(c3);
//
//       	System.out.println("Capacite : " + group.capacity());
//       	System.out.println("Taille : " + group.size());
//	}
//}
/*
Peut-�tre sur Vector.capacity, �ffectivement...

	>javac Main.java
	>java Main
	Capacite : 5
	Taille : 2

Vous voyez capacit� de 5 et taille de 2, okay. �a c'est important.
Je vous confie quand m�me que dans tous les cas Vector et ArrayList sont les deux �l�ments o� l�on peut mettre une capacit� au niveau du constructeur.

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	LIFO

		add(), addAll(), remove()
		clear(), size()
	/


Ce qui ne sera pas le cas pour LinkedList et Stack, Notamment ici les collections que l'on parcourt. 
J'essaierai de vous montrer pourquoi Vector plut�t que ArrayList. 
J'essaie de vous passer en revue ce qui peut �tre un petit peu int�ressant. 
Apr�s il y a peut-�tre le tri. Le tri je vais peut-�tre le garder, on en parlera en d�tail surtout en annexe dans les tutos Parce qu'il y a pas mal de choses � aborder concernant le tri.
�a fait �galement appel aux interfaces qui sont impl�ment�es, apr�s on a une m�thode qui fait un tri naturel qui s'appelle sort() mais �a �ventuellement je peux vous montrer.

sort()
======

�a je peux vous montrer pour trier diff�rents �l�ments parce qu'on a des cha�nes de caract�res. �a va �tre tri� l�-dessus, �a va faire un tri naturel. 
On fait un petit import de Collections avec un s�:

	import java.util.Collections;

Et on fait un petit Collections.sort().
Il y a �norm�ment de choses � aborder sur une seule vid�o. 
�a devient assez complet virgule il y a �norm�ment d'informations mais j'essaie de vous en passer un maximum sans pour autant vous noyer dans les m�thodes diff�rentes parce qu'il en existe par dizaines et �a ne serait pas forc�ment utile de toutes les �num�rer. 
Il faut aussi remplacer Vector par ArrayList. 
On change 15000 fois moi aussi. On va faire les choses proprement, on va reprendre ce qu'on avait au d�but. 
On vire l'histoire de capacit�, on s'en fiche. 
//Il faut que j'importe le comparateur aussi java.util.Comparator. 
Non, il me semblait bien que le comparateur n'avait rien � voir.

Main.java
---------
*/
//import java.util.ArrayList;
//import java.util.Collections;
////import java.util.Comparator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<Cat> group = new ArrayList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Popy");
//		Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		Collections.sort(group);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*

	>javac Main.java
	Main.java:819: error: no suitable method found for sort(ArrayList<Cat>)
                Collections.sort(group);
Alors qu'est-ce que j'ai fait ? 
On va faire �a sur une liste cha�n�e ? Non On va garder comme �a. 
Ne vous inqui�tez pas, c'est normal, voil� il ne sait absolument pas comment trier les chats. 
On ne lui a pas dit comment trier des chats donc �a justement on r�servera cette partie-l� en annexe au niveau des tuto parce qu'il faudra bien faire une vid�o compl�te ne serait-ce que sur la comparaison d'objets en Java. 
Donc vous oubliez ce que je viens de faire, jusque-l� par contre ce qu'on va faire, on va cr�er un ensemble de cha�nes "String c..." pour s'assurer que l'autre le tri se fait bien. 
Parce qu'apr�s il faut passer par une interface comparatrice, enfin tout un tas de choses et �a ferait trop de choses � voir dans une seule vid�o donc je pr�f�re garder �a en annexe pour avoir une vid�o compl�te ne serait-ce que sur le sujet. C'est pareil c'est souvent tr�s probl�matique mais l� �videmment nous n'aurons plus de chat mais des cha�nes.
Et les cha�nes, on a plus qu'� faire :
		for(String c : group)
			System.out.println(c);

Main.java
---------
*/
//import java.util.ArrayList;
//import java.util.Collections;
////import java.util.Comparator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		ArrayList<String> group = new ArrayList<String>();		
//		//ArrayList<Cat> group = new ArrayList<Cat>();
//
//		String c1 = "C";
//		String c2 = "A";
//		String c3 = "B";
//
//		//Cat c1 = new Cat("Toudoux");
//		//Cat c2 = new Cat("Popy");
//		//Cat c3 = new Cat("Maki");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		Collections.sort(group);
//
//		for(String c : group)
//			System.out.println(c);
//	}
//}
/*
	>javac Main.java
	>java Main
	A
	B
	C

Voil�, vous voyez qu'on a ins�r� d'abord C puis A, puis bien B Et avec Collection.sort, on a op�r� un tri naturel. C'est assez simple, j'avais assez faire un tri sur des cha�nes de caract�res de mani�re lexicographique et nous trie �a en tout cas visuellement par ordre alphab�tique. Pas de probl�me � ce niveau-l�. 

Par curiosit�, en passant "a", "A" et "a", on retourne "A", "a", "a".
C'est bien c'est que c'est lexico. 
Tr�s bien donc �a on reviendra dessus, ne vous inqui�tez pas si vous avez besoin de faire du tri, vous trouverez, ce n'est pas encore le cas au moment o� je fais cette vid�o mais il y aura une vid�o bien s�r en tutoriel sur tout ce qui est comparaison d'objets en Java pour effectuer du tri parce que �a demande tout un tas de v�rification pour des types particuliers. 

OK donc comme vous l'avez vu ArrayList, tr�s pratique. Vector pour la lecture et en gros pour faire simple, �videmment avec leur pratique l'exp�rience, vos choix sont peut-�tre un peu plus r�fl�chi mais au d�part quand on ne sait pas trop quoi choisir, si on est dans un besoin de faire beaucoup de lecture, beaucoup de lecture de donn�es, le choix va se faire principalement pour tout ce qui est issue de l'interface List entre ces 2 classes.
Et apr�s si vous �tes dans un environnement multi-thread, vous choisissez Vector et si vous �tes dans un environnement mono-thread, vous choisissez ArrayList. 

Honn�tement si vous ne pouvez pas vous tromper, le choix est vite fait. Pas de probl�me � ce niveau-l�. 

Liste chain�e
=============

Maintenant il n'y a pas forc�ment besoin de faire beaucoup de lecture mais qu'il y a besoin de faire beaucoup d'insertion, C'est l� que la liste cha�n�e entre en jeu. Et qu'elle se montre beaucoup plus efficace � ce niveau-l�. Alors pourquoi ? On va regarder �a. 

Je vous avais montr� la m�thode get() pour acc�der � un �l�ment, inutile de pr�ciser que get(), on �vitera sur une liste cha�n�e tout simplement parce que on va devoir parcourir tout un tas de choses. On va �ventuellement recherchez un �l�ment bien pr�cis, on verra de toute fa�on que suivant l'environnement, utiliser get() n'est pas forc�ment l'id�al.

Utiliser get() pour parcourir n'est peut-�tre pas le mieux et vous allez comprendre pourquoi. 

Qu'est-ce que je voulais vous montrer aussi ? Voil� il fallait qu'on parle aussi des it�rateurs dans cette vid�o. Il faut qu'on la porte maintenant. Je ne peux pas trop faire attendre avec �a car plus on va attendre et plus �a va �tre compliqu�. Donc va falloir qu'on l'aborde l�. �a va faire une vid�o un peu longue mais de toute fa�on il le faut, c'est important. On ne peut pas passer � c�t� de certaines choses essentielles. 

Okay on va faire �a. On va virer cette partie l� :

	import java.util.ArrayList;
       import java.util.Collections;
       
Les listes cha�n�es :

	import java.util.LinkedList;

�a il faut qu'on va m'en parler un petit peu. On ne peut pas passer � c�t� non plus. Et on terminera rapidement sur la pile � la fin. Ce sera assez court.



	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	LIFO

		add(), addAll(), remove()
		clear(), size()
	/

On met nos petit chat "<String> --> <Cat>".
On remet comme avant "String c1 = "C"; --> Cat c1 = new Cat("Toudoux");".
En c2, on va mettre Pilou, peu importe les noms.
En c3, c'�tait Popy. 
On vire Collections.sort(group).
On remplace les String par Cat.
Pour la boucle foreach "System.out.println(c); --> c.meow();"

Main.java
---------
*/
//import java.util.LinkedList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.add(c1);
//		group.add(c2);
//		group.add(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

OK on est revenu au.de d�part sauf qu'on a remplac� par une liste cha�n�e. 
La liste cha�n�e comme je viens de vous l'indiquer, son int�r�t c'est les insertions rapides. Tr�s tr�s rapide � ce niveau-l� parce qu'elle est faites pour �a. 
Il faut la voir pour ceux qui ne seraient pas ce que c'est qu'une liste cha�n�e. En gros, c'est un ensemble, imaginez une cha�ne par exemple une cha�ne de v�lo, vous avez plusieurs maillons donc l'avantage c'est qu'on peut s�parer par exemple deux maillons entre eux � n'importe quel endroit. On peut ajouter des �l�ments au d�but, � la fin de cette cha�ne, et carr�ment en plein milieu � n'importe quel endroit en fait. 
On coupe simplement 2 maillons et on ajoute un nouveau maillon entre ces 2 l� qu'on vient de couper. 
Et on peut comme �a ins�rer un nouvel �l�ment. 
C'est pour �a que les insertions sont tr�s rapides � ce niveau-l�, la o� pour un ArrayList ou un Vector, il faudrait pour le coup faire un parcours d'�l�ments en fonction, faire des d�calages de valeur et cetera dans la collection et peut �tre s�rement d'ailleurs une r� allocation de m�moire pour pouvoir avoir un espace suppl�mentaire pour l'insertion. 
Bref ce n'est pas forc�ment le plus optimis� ArrayList et Vector, pour faire de l'insertion de donn�es. 
Donc si vous devez faire beaucoup beaucoup d'insertion et qu'il n'y a pas besoin de faire beaucoup de lecture, �videmment travailler plut�t avec une liste cha�n�e. �a c'est beaucoup, la partie qui sera la plus int�ressante. 

� partir de l�, on r� ex�cute � nouveau :

Vous voyez que �a fonctionne: 

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

J'ai pas chang� c'est le m�me code que tout � l'heure, c'est encore add(), la m�me boucle l'avantage, on a juste chang� LinkedList (ArrayList --> LinkedList) et le code fonctionne. 
Encore une fois, le fait que �a impl�mente l'interface List, me permet en fait au travers de 4 classes diff�rentes d'utiliser les m�mes m�thodes de travail et un peu de la m�me mani�re sauf que bien �videmment ces classes ont des sp�cificit�s diff�rentes. 

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	LIFO

	/


Donc �a, �a nous fait gagner un temps consid�rable et c'est super super important. 

L� o� �a va �tre utile et apr�s on terminera, on parlera des it�rateurs, vous allez comprendre pourquoi parce que c'est quand m�me important de l'aborder, c'est tr�s tr�s puissant � ce niveau-l�. 

Au niveau de la liste cha�n�e puisque c'est une collection un peu particuli�re, on va avoir acc�s � certaines m�thodes qui pour le coup vont pas mal nous servir. 

On va pouvoir notamment parce que l� finalement on fait add(), on ajoute les �l�ments tels quels, de dire enfin je veux ajouter l'�l�ment en d�but de la liste c'est � dire que finalement je fais �a "Group.add(c1); --> Group.addFirst(c1);"
On y va, je ne veux pas que la vid�o dure 2h.

Main.java
---------
*/
//import java.util.LinkedList;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		for(Cat c : group)
//			c.meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !
	Pilou: Meow !
	Toudoux: Meow !

Et l� on voit ils sont ajout�s dans cet ordre-l�. 
Donc c'est plut�t pas mal.
Vous voyez on a ajout� Toudoux en premier.
Comme on a dit qu'on ajoutait en premier ensuite et bien Pilou � �t� mis devant Toudoux.
Et ensuite Popy qui a �t� le dernier ins�r� mais en passant par le devant de la liste et bien se retrouve � �tre le premier. 

On a Last qui existe mais on a toujours add(), vous savez que c'est la m�thode g�n�rique mais si vous voulez utiliser une m�thode sp�cifique � la liste cha�n�e (LinkedList), vous avez addFirst(), addLast() et cetera. 

On a �galement la m�me chose pour remove(), removeFirst(), removeLast(), bref je ne vais pas vous faire un dessin, C'est tr�s tr�s simple � utiliser. 

Et pour get(), pareil. 

	Group.getFirst(c1);

Si vous voulez acc�der au premier �l�ment ou au dernier, si vous faites un getFirst() pour avoir un premier �l�ment ou bien getLast(), �a va tr�s vite parce que automatiquement on a un pointeur qui arrive dessus donc �a va tr�s tr�s vite � ce niveau-l�.  

Donc �a ce sont des m�thodes qui permettent de travailler rapidement et qui sont con�us pour �a. 

Maintenant comment va avoir besoin De faire du parcourt, on va optimiser un petit peu. 

Ce que je vais vous montrer ici n'est pas propre qu'� la liste cha�n�e, �a fonctionne pour n'importe quelle collection Et vous allez m�me dans les prochaines vid�os quand on abordera d'autres collection de Java, on pourra parfaitement utiliser ces exemples l� aussi. 

Les it�rateurs
==============

Il existe pour l'interface liste la possibilit� d'utiliser un List d'it�rateurs.
Bien �videmment vous ne savez pas ce que c'est qu'un it�rateur. 
Un itt�rateur va vous permettre de parcourir une collection c'est � dire qu'on a un conteneur qui contient des informations et on va lui permettre en fait de parcourir ces �l�ments. 

Pour ceux qui viennent d'autres langages, vous pouvez voir �a un petit peu comme un pointeur ou en curseur. 

Si vous faites de la base de donn�es vous avez probablement d�j� entendu parler des curseurs et bien c'est un petit peu le m�me principe. 

C'est un petit peu le m�me principe, on va avoir un �l�ment, on va lui dire de se fixer sur notre collection Ici "group" en l'occurrence et il va pouvoir par exemple se fixer d�s le premier �l�ment de la collection, il va pouvoir se d�placer l�-dedans, il va pouvoir ensuite indiquer les �l�ments que l'on veut, v�rifiez s'il existe des �l�ments apr�s et cetera et cetera. 

Bref un it�rateur est parfaitement con�u pour ici le parcours dans une collection Et vraiment optimis� pour cela donc on va pr�f�rer utiliser un it�rateur plut�t que de faire cette fameuse boucle foreach "for(Cat c : group) c.meow();" Qu'on faisait jusqu � pr�sent ici pour les collections. 

Ici (Main.java), on a un cas particulier, Alors on pourrait utiliser un it�rateur g�n�rique qui est tout simplement iterator. Nous comme on travaille sur des classes qui impl�mente l'interface List, que je ne dise pas de b�tises, on va utiliser un ListIterator. Il est vraiment con�u, optimis� pour �a donc autant en profiter. 

Donc on y va, d�j� on n'oublie pas de l'importer : 

	import java.util.ListIterator;

On le cr�e ici (ListIterator avant For) et l�, il y a diff�rentes informations � prendre en compte. D�j� le type, moi c'est un it�rateurs sur chat <Cat> (ListIterator<Cat>) puisqu'on va travailler l�-dessus. 
On va l'appeler "lit", comme ListIterator.
Il ce que l'on va faire puisqu'il est � fixer sur une collection, Notre collection c'est group, on fait �a "ListIterator<Cat> lit = group"
On met un point ListIterator<Cat> lit = group.
Et attention il ne faut pas se gourer avec les minuscules majuscules, c'est l'appel � une m�thode donc il n'y a pas de l majuscule au d�but de listIterator " ListIterator<Cat> lit = group.listI..."
Ne confondez pas avec l'appel d'une classe "ListIterator<Cat>..."
Et voil� "ListIterator<Cat> lit = group.listIterator();" 
Et l� c'est bon, Nous avons notre it�rateurs "lit" sur notre collection "group" qui est je rappelle, une liste cha�n�e.
Et l� on va pouvoir changer la partie de la boucle foreach. 
On va pouvoir changer cette partie-l�, notamment en l'occurrence �a "c.meow();". 
Pour le faire, c'est vraiment tr�s tr�s simple � ce niveau-l�. 
On va v�rifier d�j� s'il existe un autre �l�ment. 
Donc on va faire simplement :

	if(lit.hasNext());

"lit.hasNext());", si l'itt�rateur trouve un �l�ment suivant et si c'est le cas, on le fait "lit.next();" :

	if(lit.hasNext())
		lit.next();

" lit.next();", on le fait sur l'itt�rateur "lit" et pas sur "c".
Donc "lit.next" Et ici � partir de l�, on a notre instance de chat.
Encore une fois ici il ne faut pas se tromper, on ne travaille pas sur des simples cha�nes de caract�res ou autres, on travaille ici sur des instances. 

Donc ici si je fais :

If(lit.hasNext())
	System.out.println(lit.next());

C'est next(), comme �a, parce que c'est une m�thode. 
On va faire �a comme �a. 
Comme �a en plus si j'ai fait des erreurs dans le code, au moins voil�, j'ai peut-�tre fait des b�tises. Je pense pas mais on sait jamais. 

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			System.out.println(lit.next());
//	}
//}
/*
Voil� vous voyez qu'on r�cup�re bien notre instance de chat. 

	>javac Main.java
	>java Main
	Cat@24d46ca6

Et � partir de l� on appelle la m�thode meow() que j'avais fait sp�cialement :

		if(lit.hasNext())
			System.out.println(lit.next().meow());

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			System.out.println(lit.next().meow());
//	}
//}
/*
Et l�, il n'est pas content parce que Je le fais dans un println() alors que �a fait d�j� un println().  

>javac Main.java
Main.java:1180: error: 'void' type not allowed here
                        System.out.println(lit.next().meow());

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		if(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !

Et voil�, Popy !
�videmment ce n'est pas un if. Je ne sais pas pourquoi j'ai dit if, c'est un while. 

Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		LinkedList<Cat> group = new LinkedList<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.addFirst(c1);
//		group.addFirst(c2);
//		group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Popy: Meow !
	Pilou: Meow !
	Toudoux: Meow !

Et voil�, nous avons notre parcours, �a fait le m�me r�sultat mais nous passons par un ListIterator, beaucoup plus optimis� et bien plus pratique. 
Alors on peut faire plein d'autres choses avec les it�rateurs mais gardez en t�te que c'est fait principalement pour �a, pour parcourir ici en Java notamment des collections. D'accord, on a plusieurs �l�ments, on va pouvoir les parcourir de mani�re optimis�e tel un curseur, tel un pointeur, bref employer les noms que vous voulez mais faites attention surtout qu'en informatique ou bien dans d'autres langages, on diff�rencie bien chacun. 
Donc l�, c'est un it�rateur et �a sert � �a et vous allez peut �tre en manipuler si vous faites d'autres langages de programmation. 
Donc tr�s pratique, tr�s optimis�, tr�s rapide, tr�s puissant, vraiment fait pour �a. 
Un petit ListIterator, encore une fois sur le type d'�l�ment qu'il s'agit "<Cat>". C'est reli� � �a "lit".
Et l� vous passez directement votre collection "group" et vous appeler la m�thode "listIterator()" et voil�.
Et � partir de l�, vous avez 2 m�thodes � conna�tre vraiment : hasNext() et next(). 

Avant de terminer la vid�o avec la stack, on recherche ListIterator<E> :

	https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html

Vous voyez, on retrouve tout un tas d'�l�ments (Method Summary). hasNext(), �a c'est ce qui nous int�ress�, next() et cetera, previous(), remove(), et cetera. 

Attention (remove) par contre � ne pas faire n'importe quoi au niveau de l'itt�rateur parce que �a fonctionne par it�ration. On est dans des it�rations, dans une boucle donc attention � ne pas supprimer des choses n'importe comment. Et cetera. 

Apr�s vous pouvez toujours tester, manipuler un peu les it�rateurs au voir comment �a se passe, comment �a se comporte mais vous verrez un peu certaines choses et de toute mani�re, on aura l'occasion de les aborder bien encore par la suite donc c'est la premi�re mais ce n'est pas la derni�re fois que nous les utilisons au niveau du cours ou en tout cas au niveau du code que je vous montre. 

Stack()
=======

Voil� et on va terminer enfin avec ce conteneur, cette collection un petit peu particuli�re qui est une collection sous forme de pile (Stack). 

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	LIFO

	/

Pareil si vous n'avez jamais programm� de pile, fait des piles dans un autre langage de programmation.
La pile, c'est tout simplement une structure assez particuli�re qui dit qu'on ne peut ins�rer des �l�ments que au d�but, c'est � dire qu'on ins�re des �l�ments par le haut. On peut imaginer une pile d'assiettes si vous voulez vous repr�senter �a visuellement donc forc�ment si on veut ajouter une assiette � la pile, on l'ajoute par en haut. Pas par en bas voil� on adores les pari risqu�.
Et si on veut retirer une assiette, on retire par le haut donc on parle de structure en LIFO, C'est-�-dire last in first out. 
Le dernier �l�ment qui est ins�r� sera le premier �l�ment qui sera retir�. 
Voil� donc si vous avez besoin de ce genre de structure, vous pouvez utiliser une stack. 
C'est vraiment fait pour �a. 
Stack est thread-safe comme Vector, m�me chose. Donc voil� �a c'est une information � conna�tre. 


Donc �a c'est une information � conna�tre, c'est �galement comme les 3 autres, des donn�es qui sont ordonn�es, qui acceptent les doublons, qui acceptent les valeurs nulles, pas de probl�me. 

Je peux tr�s bien par exemple ici (group.addFirst(null)), faire un null qui sera accept�. 

		group.addFirst(c1);
		group.addFirst(null);
		group.addFirst(c3);

Null, est accept�e par ces 4 l�. Pas de souci � ce niveau-l�. 
Stack comment va-t-on pouvoir pr�senter �a ?
Parce qu'on va montrer vite fait quelque m�thode c'est quand m�me int�ressant de le voir.
On prend place tout dans notre code (LinkedList --> Stack).
Donc on a cr�er les diff�rents chats :

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Pilou");
		Cat c3 = new Cat("Popy");

Ensuite, ici, on a des m�thodes particuli�res parce qu'on n'ajoute pas n'importe comment (on remplace group.addFirst(c1)).

Si vous voulez ajouter un �l�ment, c'est la m�thode push(). Si vous voulez retirer l'�l�ment du haut, c'est la m�thode pop(), qui permet d'ailleurs de r�cup�rer l'�l�ment qui a �t� retir�. 

Si vous voulez acc�der � l'�l�ment qui est le plus en haut, au sommet de la pile, c'est peek(). Il retrouve la m�me chose, on peut faire de la recherche et cetera. C'est comme �a qu'au niveau de recherche, attention comme c'est une structure comme LinkedList sans acc�s direct, il y aura un parcours qui sera effectu� pour faire la recherche. Donc ce n'est pas forc�ment le top pour la lecture. Encore une fois, vous avez bien compris que pour la lecture, ArrayList et Vector okay. 

Pour LinkedList et Stack, faire beaucoup de lecture n'est pas l'id�al. Et on ne les utilise g�n�ralement pas pour �a de toute mani�re. 

Donc ici on va faire "group.push()" et on va ajouter c1 "group.push(c1)" Et faire la m�me chose pour C2, C3.

       group.push(c1);
       group.push(c2);
       group.push(c3);
  
Vous voyez, je ne change pas beaucoup code, � par ici pour le coup.
On ne fait plus de add(), on fait un push() parce que �a fonctionne au niveau de la pile.
Et l� normalement �a doit �tre bon. 


Main.java
---------
*/
//import java.util.LinkedList;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//       group.push(c1); //group.addFirst(c1);
//       group.push(c2); //group.addFirst(c2);
//       group.push(c3); //group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*

>javac Main.java
Main.java:1350: error: cannot find symbol
                Stack<Cat> group = new Stack<Cat>();
                ^
  symbol:   class Stack
  location: class Main
Main.java:1350: error: cannot find symbol
                Stack<Cat> group = new Stack<Cat>();
                                       ^
  symbol:   class Stack
  location: class Main
2 errors

Du coup, qu'est-ce que j'ai fait ?
Oui en effet, Stack il ne connait pas (LinkedList --> Stack).
	
	import java.util.Stack;

Main.java
---------
*/
//import java.util.Stack;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//       group.push(c1); //group.addFirst(c1);
//       group.push(c2); //group.addFirst(c2);
//       group.push(c3); //group.addFirst(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//	}
//}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !

Hop et �a fonctionne, tr�s rapide. 
Quelques petits remplacements, on travaille �galement avec un ListIterator "ListIterator<Cat>...". Aucun probl�me. 
Si je veux r�cup�rer, pareil, le sommet.

	System.out.println("Sommet : " + group.peek());

Main.java
---------
*/
//import java.util.Stack;
//import java.util.ListIterator;
//
//public class Main
//{
//	public static void main(String[] args)
//	{
//		Stack<Cat> group = new Stack<Cat>();
//
//		Cat c1 = new Cat("Toudoux");
//		Cat c2 = new Cat("Pilou");
//		Cat c3 = new Cat("Popy");
//
//		group.push(c1);
//		group.push(c2);
//		group.push(c3);
//
//		ListIterator<Cat> lit = group.listIterator();
//
//		while(lit.hasNext())
//			lit.next().meow();
//		
//		System.out.println("Sommet : " + group.peek());
//	}
//}
/*

	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !
	Sommet : Cat@63961c42

Je vous montre rapidement et voil�, je rappelle qu'on r�cup�re l'instance puisque on stock une collection d'instances de Cat �videmment. 
Donc � voir � ce niveau-l�.
J'aurais pu faire �galement un meow() pour afficher directement.
Forcement System.out.println("Sommet : " + group.peek().meow()); ne fonctionne pas car println() � nouveau.
et �a non plus "Sommet : " + group.peek().meow().
On fait donc group.peek().meow();

Main.java
---------
*/
import java.util.Stack;
import java.util.ListIterator;

public class Main
{
	public static void main(String[] args)
	{
		Stack<Cat> group = new Stack<Cat>();

		Cat c1 = new Cat("Toudoux");
		Cat c2 = new Cat("Pilou");
		Cat c3 = new Cat("Popy");

		group.push(c1);
		group.push(c2);
		group.push(c3);

		ListIterator<Cat> lit = group.listIterator();

		while(lit.hasNext())
			lit.next().meow();
		
		group.peek().meow();
	}
}
/*
	>javac Main.java
	>java Main
	Toudoux: Meow !
	Pilou: Meow !
	Popy: Meow !
	Popy: Meow !

Forcement System.out.println("Sommet : " + group.peek().meow()); ne fonctionne pas car println() � nouveau.
Je n'aurais pas d� mettre de syst�me println() dans la m�thode. 
�a aurait �vit� quelques soucis mais vous voyez c'est bien Popy, donc ok.
Tout va bien virgule pas de probl�me.

Donc voyez, Toudoux en premier avec push(c1) donc c'est celui qui va se retrouver en bas, apr�s ensuite c'est bien Pilou qui est le 2e et du coup, c'est bien Popy Qui est au sommet de la pile donc c'est normal lorsqu'on fait l'appel � peek(), c'est bien Popy qui nous est retourn�.

C'est bien Popy qui nous est retourn� parce que c'est lui qui est au sommet de notre stack. 

Donc c'est parfaitement logique, tout fonctionne � ce niveau-l�. 

Est-ce que j'ai d'autres choses � voir ? 

On peut v�rifier aussi si une pile vide avec empty mais ce sont des m�thodes qui sont disponibles dans pas mal d'autres cas donc on peut v�rifier �a.

	/
		ArrayList	:	mono-thread, acc�s direct, optimis� pour la lecture
		LinkedList 	:	insertions rapides
		Vector	:	multi-thread, acc�s direct, optimis� pour la lecture
		Stack		:	LIFO, multi-thread

		isEmpty() empty()

	/


Donc de mani�re g�n�rale c'est isEmpty() notamment pour v�rifier si une collection est vide ou non Mais c'est vrai que pour les pilles, on a la m�thode empty() tout simplement.

Parfois on a des petites choses comme �a en doublon Selon le cas, et selon ce qui est r�utiliser ou pas car je rappelle que Stack et une classe sp�cialis�e de Vector. D'accord, �a c'est important de le savoir. 

Ce qui permet d'ailleurs de retenir qu'elles sont toutes les 2, un environnement multi-thread parce que l'une est sp�cialis� de l'autre.

Okay, je pense que j'ai fait tout de tout ce que je voulais vous dire.

On a abord� ces 4 classes de l'interface List, qui impl�mentent l'interface List. Je vous ai donn� chaque sp�cificit� qui me semblait int�ressant pour chacune. 

Je vous ai montr� bien que ce n'�tait pas forc�ment pr�vu mais finalement on a vu du code sur le 4. Je n'avais pas forc�ment pr�vu de montrer du code sur les 4 classes mais on l'a fait.

�a aura fait une vid�o un peu longue mais de toute fa�on Mais comme c'est une vid�o on peut la mettre en pause la regarder en plusieurs fois sur toute la semaine si vous voulez, c'est sur youtube �a ne va pas dispara�tre donc tout va bien. 

On a vu les it�rateurs, on a parl� vite fait de tout ce qui est tri oui mais pas trop parce que je vous ai dit qu'il y aurait une vid�o sp�cifique l� dessus parce qu'il y a beaucoup de choses � dire sur le tri, tout ce qui est comparaison de donn�es en Java. 

Et voil� je pense que j'ai abord� tout ce que je voulais pour ces 4 classes donc vous voyez, une vid�o pour 4 classes. 

�videmment si vous avez compris pour la prochaine s�ance, nous aborderons une autre interface avec d'autres classes qui impl�mente cette interface pour que vous voyez un petit peu comment on va travailler avec elle j'irai forc�ment un petit peu plus vite pour le prochain Collection parce que l� c'est la premi�re fois pour beaucoup que vous les voyez donc c'�tait bien de prendre un petit peu le temps de les aborder avec vous mais pour les autres bien s�r tout ce qui est ajout d'�l�ment, it�rateurs, tout �a, on ira beaucoup plus vite. 

Ce ne sera plus nouveau donc on pourra se permettre d'aller un peu plus vite au niveau des explications. 

S'il y a des questions n'h�sitez pas parce que je pense qu'il y en aura parce que pour certains �a va peut-�tre para�tre tout �vident mais pour d'autres �a va peut-�tre para�tre comme de la grande confusion autour de cette vid�o donc s'il y a des questions n'h�sitez pas parce qu'il y a vraiment beaucoup de choses � voir l�-dessus. 

�a fait une grosse s�ance � dig�rer donc n'h�sitez pas encore une fois entra�ner, � faire du code, faire un petit programme et cetera.

En plus vous avez beaucoup de classe que vous allez pouvoir manipuler avec tout ce qu'on avait jusqu'� pr�sent sur le cours Java, vous avez vu �norm�ment de choses donc vous avez moyen d'utiliser tout un tas de donn�es, de type de donn�es, de classe diff�rente de Java, faire la gestion d'exception et cetera, des listes bref.

Plein de manipulations possibles � faire, plein d'exemples de programme pour vous exercer donc n'h�sitez pas pour vous entra�ner, comprendre un peu ce que vous faites s'il vous bloqu� sur quelque chose et que vous avez besoin d'aide donc n'h�sitez pas � poser des questions en commentaire. 

Je vous dis � bient�t pour la prochaine s�ance o� l'on abordera une autre interface et on continuera sur ces collections en Java.

Ciao tout le monde
*/


