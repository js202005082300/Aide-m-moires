/*
	Java #15 - packages

Bonjour bienvenue pour cette 15e s�ance en Java.

La derni�re fois nous avions abord� �norm�ment de classe Si vous vous souvenez Concernant les cha�nes de caract�res.

On a d'ailleurs eu 2 parties sur cette notion tr�s importante Parce qu'il y a des manipulations bien pr�cises � faire en fonction du type de donn�es que l'on veut g�rer et de quelle mani�re on veut le g�rer.

On a parl� de monothreader, multithreader, et cetera.

Et l� on va faire une petite pause et revenir sur quelques notions propres � la programmation orient�e objet qu'on verra par la suite.

et l� une petite pause avec cette vid�o concernant les paquets et c'est propre ici � Java puisqu'on va voir comment cr�er des modules ou des package, on peut leur donner le nom que l'on veut.

ce serait l'�quivalent des modules pour ceux qui programment en Python Pour avoir diff�rentes classes que l'on peut organiser de la mani�re que l'on veut au sein d'un projet.

la vid�o sera assez courte, il n'y aura pas grand-chose � apprendre Mais c'est quand m�me un passage important car on verra par la suite et on l'a vu dans la vid�o sur les cha�nes de caract�res qu'on a import� des paquets propre � Java quand on utilise certains objets.

Notamment lorsqu'on se souvient de Stringbuilder et cetera, on avait comme �a des imports � faire.

De d�part nous avons un seul fichier, notre seul fichier Java, et par la suite je veux cr�er un Package.

Un package c'est tout simplement un r�pertoire, un dossier que vous allez cr�er et qui va contenir une ou plusieurs classes. G�n�ralement quand on fait un package c'est dans l'id�e d'inclure une ou plusieurs classes.

Apr�s nous allons voir comment faire au niveau du nommage des package en question Mais l� on va rester sur quelque chose d'assez simple. 

Faire un package
================

Moi j'aimerais tout simplement faire un package. On commence par faire un import, ce serait tout simplement de pouvoir faire un paquet qui S'appellerait mypackage, pour garder un truc tr�s simple au d�part.
On fait un point et on dit alors que j'inclus toutes les classes qu'il contient en mettant un point et une �toile. Et on termine avec un ; 

public class App
{
	Public static void main(String[] args)
	{
		
	}
}

Une * pour dire qu'on inclut Absolument toutes les classes que contient ce r�pertoire mypackage. 
A partir de l� o� se situe mon fichier je vais pouvoir cr�er mon r�pertoire directement.

Au niveau des noms, tout ce qui est nommage, on ne va pas voir tout ce qui est nommage conventionnel, On en parlera un petit peu apr�s. 
 
Mais quand vous avez ce genre de chose vous devez tout �crire de pr�f�rence en minuscule, pas de caract�res sp�ciaux, pas d'espace, pas de caract�res accentu�s, et cetera. 
Et si vous utilisez un mot qui est utilis� par Java o� qui est r�serv� par Java, vous pouvez exceptionnellement le faire � condition de le faire suivre avec un underscore :

	Import mypackage.*;

Si par exemple vous utilisez le mot package ou encore une fois comme class par exemple ou public, c'est-�-dire des mots qui font partie de la syntaxe du langage Java, Il faudra � ce moment-l� rajout� un underscore � la suite. apr�s dans l'id�al c'est de carr�ment ne pas utiliser des mots r�serv�s Ou bien rajouter quelque chose devant.
par exemple comme package est un mot r�serv�, vous mettez un petit MY devant et comme �a vous n'aurez pas de probl�me. 

Cr�er une autre classe dans le r�pertoire mypackage
---------------------------------------------------

On cr�e une autre classe. Ok on va utiliser un exemple qu'on utilise dans d'autres cours, on va faire par exemple un player.java Qui serait par exemple de quoi repr�senter un joueur et on aurait par exemple item.java pour repr�senter un objet. On fait donc ces 2 classes l�. 
� partir du moment o� on a une classe qui fait partie d'un package, il s'agit tout simplement ici de ne pas faire un import, de ne pas mettre un import �videmment. 
Import, c'est pour utiliser en important, en ajoutant dans App.java, Le package en question.
Mais dans Player.java, on dit qu'il en fait partie.
Donc on met package dans Player.Java et on remet du coup le nom, mypackage. 

package mypackage;

On le met pour les deux et ensuite on ajoute une classe � Player.java.

public class Player
{
	public class Player()
	{
		System.out.println("Player instancie !");
       }
}

Cette classe porte le m�me nom que le fichier. Ensuite on va faire quelque chose de tr�s simple pour le constructeur. Le but �tant de voir que �a a bien �t� construit, on affiche "Player instancie !".

Ensuite on fera juste un copier-coller de public class Player{} pour Item.java. 

package mypackage;

public class Item
{
	public class Player()
	{
		System.out.println("Item instancie !");
	}
}

En esp�rant que item.java ne soit pas en nous r�server. 

Inclusion de la classe Player
=============================

Pour l'instant, nous allons juste inclure la classe Player du package.
Du coup on fait � Player.

import mypackage.Player;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}

Dans le constructeur par d�faut, on n'avait rien mis. 
Et du coup on fait ce genre de chose: 

		Player p = new Player();
		Item it = new Item();

� partir de l�, nous allons directement compiler ce code. 
Pour compiler, on �crit: 
	
	javac App.java
	
On compile le fichier App.java qui apr�s sera capable d'aller rechercher les autres packages puisqu'on fait tous les imports n�cessaires.
On compile mais on se rend compte qu'on a un souci: 

  		symbol:   class out
  		location: class System
		App.java:99: error: cannot find symbol
                Item it = new Item();
                ^
  		symbol:   class Item
  		location: class App
		App.java:99: error: cannot find symbol
  		Item it = new Item();

On se rend compte que Item n'est pas trouv�.
Encore une fois, si je veux �ventuellement n'inclure que ces 2 classes Et admettons que j'avais dans mon package une dizaine de classes, il faudrait bien �videmment faire ce genre de choses: 

	import mypackage.Player;
	import mypackage.Item;
Et si on veut tout inclure o� �viter de faire des inclusions comme ci-dessus unique, Encore une fois on passe par le symbole �toile, l'ast�risque, pour pouvoir faire l'inclusion totale: 

	import mypackage.*;

On revient sur notre code et on compile :
*/

import mypackage.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}

/* 
On compile javac App.java et on ex�cute java App
On ex�cute notre fichier et on remarque que nos 2 constructeurs ont bien �t� instanci�. On a les 2 constructeurs qui ont �t� appel�s, on a bien r�ussi � trouver nos 2 classes quoi. 

Donc voil� comment fonctionne la cr�ation d'un package. 

C'est tr�s simple et l'utilisation est tr�s simple aussi.

Port�e des classes 
==================
On va revenir sur la port�e des classes, Il y a des choses qu'on n'avait pas forc�ment pr�cis� o� notamment on avait dit qu'on reviendrait sur certaines choses. Quand on utilisait en fait le mot cl� public, On se disait que c'�tait accessible de partout Et au niveau du package il y a un type de port�e � prendre en compte.
En gros si je mets ce mot cl� public pour la class ou autre pour d'autres �l�ments, �a signifie public pour tout. �a veut dire pour tout ce qui fait partie � la fois du package Mais aussi tout ce qui est � l'ext�rieur. 
En revanche si je m'amuse � faire ce genre de chose : 

public class Player > class Player

package mypackage;

class Player
{
	public Player()
	{
		System.out.println("Player instancie !");
	}
}

Dans ce cas, en r�alit� je n'aurais pas vraiment une classe priv�e. J'aurai une classe qui sera public seulement pour le package Mais pas depuis l'ext�rieur. Donc tout ce qui fait partie du Package pourra se servir de cette classe mais tout ce qui n'en fait pas partie, ne pourra pas par rapport justement � cette histoire de port�e. 

Donc si on veut quelque chose de vraiment accessible partout, On mettra �videmment la classe public.

Sinon C'est une port�e visible uniquement pour le package Seulement. Donc attention � �a. 
Si des fois vous avez des petites erreurs O� vous avez des acc�s qui ne fonctionnent pas, ce sera tr�s certainement un probl�me comme �a o� l'on oubliera De sp�cifier la port�e de notre classe Ou d'une m�thode Ou d'un attribut d'une classe. Donc tr�s important. 
Pareil si par exemple vous avez une classe publique et qu'on d�finit Un �l�ment ici qui aurait juste une valeur ;

package mypackage;

public class Player
{
	
	int data;

       public Player()
	{
		System.out.println("Player instancie !");
	}
}

"int data" puis sans sp�cifier de port�e, M�me chose cet �l�ment-l� ne pourra pas �tre modifi� et ne pourra pas �tre accessible depuis l'ext�rieur du package. Tr�s important, il faut g�rer la port�e par rapport � �a. 

Il faut bien prendre en compte tout ce qui est port� li� aux membres, aux classes, aux m�thodes, et cetera, Pour que tout soit accessible en fonction soit pour le package soit pour l'ext�rieur du paquet.

� nous de bien g�rer cela et de v�rifier encore une fois l'encapsulation des donn�es Comme on l'avait d�j� vu pr�c�demment.

Convention de nommage
=====================

On va revenir maintenant sur la convention de nommage. 

import mypackage.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}

"import mypackage.*;" �a c'est quand on veut par exemple faire un package tr�s simple. 
On a peut �tre d�j� vu en Java lorsqu'on veut importer des choses, on a ce genre de format : 

	import java.util.*;

En g�n�ral, on �vite de faire un �toile parce que dans les classes utilitaires on en a quand m�me beaucoup Donc �a peut charger plein de fichiers inutiles Donc en g�n�ral on est plut�t en nombre pr�cis. 
Donc l� on avait un nom du genre: 

	import java.util.SomeClasse;

Et du coup on utilisait Stringbuilder ou autre en fonction.
Du coup on voit ici qu'il y a plusieurs noms s�par�s par des points et en fait en termes d�j� hi�rarchie, c'est simplement des sous package et qui sont repr�sent�es au niveau de notre explorateur par des sous dossiers. 
Donc si on veut faire ce genre de choses, il y a une convention en Java qui est tr�s utilis�e qu'on retrouve un petit peu partout, c'est en gros avoir une extension de domaine c'est-�-dire comme pour les sites web .com, .fr, .Org et cetera.
Par exemple mettons fr. :
	/ 
		fr.
	/  
Donc on met fr, on peut mettre ensuite un nom de domaine, �a peut par exemple �tre notre nom, pr�nom o� ce que vous voulez, �a peut �tre un nom de site ou n'importe quoi, c'est un identificateur. 

	/ 
		fr.jachampagne
	/  
On peut mettre par exemple son pseudonyme et ensuite on peut mettre �ventuellement le nom du package :
	/ 
		fr.jachampagne.mypackage
	/  
Par exemple le fameux package qu'on avait o� directement dans fr.jachampagne, j'aurais toute mes classes. Et du coup � ce moment l� je pourrais juste garder :
	/ 
		fr.jachampagne
	/  
et du coup je ferais un import de fr.jachampagne :

	import fr.jachampagne.*;

� si je ne veux pas encore avoir d'autres parties et que je veux tout mettre dans fr.jachampagne
et au niveau hi�rarchie, le changement se fera de cette mani�re. Donc au lieu d'avoir : 

C:.
?   App.class
?   App.java
?
????mypackage
        Item.class
        Item.java
        Player.class
        Player.java

On va appeler notre r�pertoire fr et dans fr, on va justement avoir le domaine et on ajoute nos classe dans le domaine en virant les .class

C:.
?   App.class
?   App.java
?
????fr
    ????jachampagne
            Item.java
            Player.java

Et le changement va bien s�r s'op�rer dans les fichiers Item.java et Player.java o� le paquet deviendra tout �a : fr.jachampagne

Il faut vraiment partir du point racine, l� o� on a notre fichier App.java Et ensuite chacun des sous dossiers qui doit bien s�r �tre �videmment renseign�. 

Donc pour l'import, on a ce format l� :

       import fr.jachampagne.*;

Et du coup on a acc�s au r�pertoire jachampagne Et donc si on met �toile, il est logique qu'on importe tout ce qu'il y a dans ce dossier. Sinon on met le nom du fichier, de la classe en particulier qui sera �videmment identique au nom de la classe qu'il y a � l'int�rieur.

Et dans les classes � l'int�rieur du package, on indique bien le mot cl� package, Tout le chemin aussi. Donc �a c'est important sinon on risque d'avoir des erreurs � la compilation. Donc si on a des erreurs par rapport � un package inaccessible, une classe qui n'est pas trouv�e, c'est qu'a priori on s'est tromp� dans un de ces chemins. Donc attention par rapport � �a.

Et du coup ici je peux refaire une nouvelle compilation, une nouvelle ex�cution. 

App_fr.java
-----------

import fr.jachampagne.*;

public class App
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Item it = new Item();
	}
}

Une nouvelle compilation et une nouvelle ex�cution et on voit que �a fonctionne avec ce principe-l�.

Donc tout simplement, �a c'est plus conventionnel au niveau de Java. On retrouvera plus souvent ce genre de choses. Pareil si on passe par un environnement de d�veloppement Qui permet de cr�er un package automatiquement en quelques clics, g�n�ralement il nous propose des noms de ce genre aussi parce que �a nous fait la cr�ation des r�pertoires et tout �a.

donc voil�, soit on utilise cette m�thode conventionnelle soit on peut simplement avoir juste un dossier, un r�pertoire qui contiendra nos classes Et dans ce cas on fait ce qu'on a vu au d�but de la vid�o. 

Donc voil� nous aurons vu la mani�re standard et la mani�re conventionnelle en fonction de ce que l'on veut faire. 

Donc voil� pour tous les points qu'on aura voulu aborder durant cette vid�o, encore une fois le plus important l�-dedans c'est de pouvoir organiser nos diff�rents fichiers lorsqu'on aura un projet assez cons�quent donc c'est l� o� c'est int�ressant de ne pas avoir tout dans un seul fichier et encore une fois de ne pas avoir toutes les classes dans un seul r�pertoire ou tout est m�lang�.

On va pouvoir organiser comme �a notre projet au sein de plusieurs package et sous package �ventuellement.

Et apr�s au niveau de la port�e , de bien prendre en compte chaque port�e pour essayer un maximum de respecter encore une fois le encapsulation Des donn�es et bien garder chaque chose, de permettre l'ind�pendance de chaque package et puis qu'un package ne puisse pas communiquer avec un autre ou en tout cas qu'on limite un maximum �a pour encore une fois bien prot�ger la coh�rence et l'int�grit� des donn�es.

Vous voyez c'�tait quelque chose de tr�s simple � prendre en main Par rapport aux vid�os pr�c�dentes, la prochaine fois on va parler de pas mal de notion, on va parler d'h�ritage, on va parler de polymorphisme, on va �galement aborder les exceptions parce que ce sont des choses que l'on doit conna�tre, que l'on va devoir apprendre de mani�re g�n�rale et aussi ici en Java parce qu apr�s on va revenir en fait sur de la saisie utilisateur et sur d'autres choses comme �a qui n�cessitent au moins de comprendre ce qu'est l'h�ritage et ce que sont les exceptions, c'est pour �a que ces vid�os vont �tre vus avant de voir comment saisir des donn�es plus tard pourquoi pas, manipuler des fichiers.

Donc on regardera tout �a un petit peu au niveau de ce cours.

� bient�t pour la prochaine s�ance.
*/

