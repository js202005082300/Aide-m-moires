/* 
Java #16 - lecture au clavier
Bonjour bienvenue sur la s�ance 16 en Java.
Il est temps pour nous d'aborder la saisie ou du moins la lecture de donn�es Et en l'occurrence la saisie de donn�es par l'utilisateur au clavier.
Nous allons voir quelques classes et quelques petits outils que nous allons utiliser pour r�aliser ce genre d'op�ration l� sur notre code.
On aborde la lecture au clavier seulement maintenant ce qui change des autres formations o� l'on abordait la saisie de donn�es assez t�t Mais ici Java est un langage qui poss�de pas mal de classes et de notions sous-jacentes. il fallait qu'on les abordent avant de passer � la lecture de donn�es.
On va revenir sur un code tr�s sobre pour le coup o� l'on retrouve pour le coup Notre classe principale et notre m�thode statique main() pour le point d'entr�e de notre programme.
public class App
{
	public static void main(String[] args)
	{	
}
}
2 classes pour lire des donn�es
=========================
Et � partir de l� nous allons parler de 2 classes principales, De 2 mani�res pour pouvoir justement lire des donn�es sur un flux d'entr�e normalement le clavier.
On demande � l'utilisateur une information au clavier.
Pour rappel, comme on avait vu derni�rement pour tout ce qui est cha�ne de caract�res, on a parl� de Stringbuilder et Stringbuffer. Il y avait des diff�rences sur le fonctionnement et le contexte d'utilisation de ces diff�rentes classes. 

BufferedReader
==============

Ici on va retrouver un peu la m�me chose. On va avoir un cas o� on va avoir une classe qui va travailler uniquement avec des cha�nes de caract�res. Vous savez ce que c'est une cha�ne de caract�res on a fait une vid�o en 2 parties l�-dessus. Ce sera d'ailleurs plus simple pour poursuivre � pr�sent. Et ce genre de donn�es va juste se charger de faire de la lecture, on va lire les donn�es et on va utiliser pour cela, la classe qui s'appelle BufferedReader : 
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
	}
}
O� l'on appelle par exemple ici br pour rester simple dans le terme ici.
BufferedReader va permettre de lire des cha�nes de caract�res, donc de type String comme ici String[] args.
Il ne fera rien d'autre que de la lecture de donn�es de ce genre-l�. 
C'est quelque chose qui est synchroniser c'est-�-dire qui est thread-safe, terme qu'on a employ� lorsqu'on avait parl� des cha�nes de caract�res.
Mais vous allez voir ici, l'exception voudra que cette m�thode ci Soit plus rapide que la suivante, celle que nous verrons en 2e partie de la vid�o. On expliquera pourquoi. 
�a c'est la premi�re partie, lecture de cha�nes de caract�res, thread-safe donc c'est synchronis�.

Scanner
=======

On va voir un 2e objet dont on parlera par la suite qui est Scanner qui lui n'est pas thread-safe donc il est asynchrone. 
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
		Scanner sc;
	}
}
L'utilisation de scanner sera plus lente. Cette classe est plus lente que BufferedReader, tout simplement parce qu'en plus d'avoir de la lecture �

BufferedReader vs Scanner
=========================

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de cha�ne de caract�res 

/
On va avoir BufferedReader qui est donc synchrone et comme il est synchrone il est thread-safe. On ne reviendra pas sur ce d�tail l� puisqu'on les a expliqu� pr�c�demment. Il faudra revenir sur les vid�os pr�c�dente pour savoir � quoi �a fait r�f�rence. Mais voil� il n'y a qu'une lecture de cha�ne de caract�res.
Voil� pour le premier cas, celui qu'on va voir au d�but de la vid�o. 

Pour l'autre, scanner, on va avoir quelque chose d'asynchrone.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de cha�ne de caract�res 

	Scanner -> 		asyncrhome
				not thread-safe
					lecture de donn�es + parsing

/
Qui du coup n'est pas thread-safe. Il y a du coup ici une lecture de donn�es de n'importe quel type que ce soit cha�ne de caract�res, un int, un short, un booleen, et cetera. Plus �ventuellement un parsing, parsing des donn�es. Du coup 2 �tapes, pour ce qui est de l'�tape du parsing est une op�ration tr�s co�teuse. Et donc �a rend l'usage de cette classe Scanner beaucoup plus lente que BufferedReader.
M�me si on nous avait expliqu� pr�c�demment Que quand on a des classes avec par exemple une diff�rence que l'une est synchrone et l'autre asynchrone, g�n�ralement la classe qui est asynchrone sera plus rapide.
Si on travaille dans un environnement multi-thread�, elle n'a pas besoin d'attendre la finalisation des t�ches d'un thread pour qu'un autre thread puisse continuer � travailler. 
On n'a pas comme �a de thread-safe, donc tout se fait de mani�re asynchrone et tout travaille beaucoup plus vite. 
L'exception qui fait que pour le coup c'est invers�, C'est �a qui est important ce qu'il faut savoir qu'il y a une �tape suppl�mentaire. 
On ne se cherche pas de lire une cha�ne de caract�res sans se poser de questions, on va lire n'importe quel type de donn�es et en plus de ��, on aura la possibilit� de parser les donn�es.
Parce que les donn�es �a peut �tre tout simplement le fait, de v�rifier le type de donn�es qui est lu, par exemple lire en entier ce n'est pas comme lire une cha�ne de caract�res ou un bool�en et en plus on peut travailler avec des expressions rationnelles . Par exemple v�rifier qu'un mot contient un certain nombre de caract�res pr�cis ou par exemple l'exactitude d'une adresse IP ou d'une adresse mail , d'une adresse ou d'un code postal pour avoir un format bien sp�cifique et correct par rapport � la saisie qui est faite .
Tout �a repr�sente pas mal d'op�ration Et de v�rifications suppl�mentaires de toute cette partie que l'on appelle le parsing qui va faire de la v�rification, qui va modifier certaines donn�es et faire des contr�les dessus.
Tout �a est co�teux, rajoute des op�rations compl�mentaires et rend la classe plus lente .
C'est tr�s important en Java comme il y a beaucoup de classe possible, il est pr�f�rable de nous expliquer le fonctionnement de chacune en fonction du contexte qu'il faut. On ne va pas s'amuser � utiliser scanner si on n'a pas besoin de lire autre chose que des cha�nes de caract�res et qu'il n'y a pas de parking � faire. ce serait un petit peu dommage d'utiliser ce genre de classe.

La classe BufferedReader
========================

On va d'abord commencer par celle-ci. On utilise BufferedReader qui lit les cha�nes de caract�res.
Donc tout sera lu comme une cha�ne de caract�res.

public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br;
	}
}
Si vous venez d'un autre langage de programmation tel que python. Par exemple python lorsqu'on fait appel � la fonction input() pour la saisie de donn�es justement au clavier, tout est consid�r� comme �tant une cha�ne de caract�res. buffer Reader c'est un peu pareil, il consid�re que toute saisie qui sera faites m�me si la personne entre sur son clavier � un nombre sera consid�r� comme �tant une cha�ne de caract�res de ce nombre et non pas comme un nombre arithm�tique avec lequel on pourrait faire des calculs, toujours ce genre de choses.
Ce sera beaucoup plus rapide parce qu'on va juste avoir de la lecture de cha�ne de caract�res, on peut mettre un String : 
/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de cha�ne de caract�res (String)

	Scanner -> 		asyncrhome
				not thread-safe
				lecture de donn�es + parsing

/
Lecture d'un String sans faire de conversion, sans devoir contr�ler, De contr�le pour faire des conversions type puisqu'on travaillera directement avec des cha�nes de caract�res. 
Comment �a se passe en termes de code? �a va �tre tr�s tr�s simple. La premi�re chose on va cr�er notre constructeur, on va instancier notre classe et en param�tres, elle va avoir besoin d'un Reader, c'est une metaclass, c'est une tr�s tr�s grande classe de Java. 

	BufferedReader br = new BufferedReader();

Quand on abordera la vid�o sur l'h�ritage virgule on reviendra en d�tail l�-dessus. C'est-�-dire les classes les sous-classes et cetera. 
On va avoir besoin ici d'une classe pour la lecture c'est-�-dire o� ce que ce buffer de lecture va-t-il lire ? Par d�faut il ne sait pas vraiment o� est-ce qu'il doit lire et on peut lire sur pas mal de choses, un p�riph�rique d'entr�e, un flux bien particulier est un fichier. Bref il y a plusieurs types de flux et d'entr�es disponible.
Et nous on veut lire justement sur notre clavier. Pour faire �a on va avoir besoin d'un Reader et notamment de Reader particulier qui est le InputStreamReader, un lecteur pour le flux d'entr�e et �a tombe bien parce que notre clavier est un p�riph�rique d'entr�e donc il permet de saisir dans le flux d'entr�e.
Alors d�j� on va ajouter cette premi�re classe et maintenant qu'on sait ce que c'est un package qu'on a vu dans une vid�o un petit peu avant, Il devient plus facile maintenant de pouvoir expliquer le import de certaines classes Parce que BufferedReader n'est pas compris par d�faut dans un code en Java. Il faut l'importer nous m�me. 
Donc on commence par faire un importe java.io et ici pour le coup, on met BufferedReader.
Et pour la partie concernant le lecteur, le fameux InputStreamReader, c'est dans le m�me package.

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		BufferedReader br = new BufferedReader();
	}
}

Pour rappel on peut mettre une �toile si on veut importer tout ce qu'il y a dans IO mais on ne le fait pas parce qu'on pr�f�re importer seulement ce dont on a besoin. Et surtout plut�t �viter d'importer 20 ou 50 classes si au final on utilise que 2 classes. �a c'est vous qui voyez En fonction de vos pr�f�rences.
� partir de l� on va avoir besoin d'un InputStreamReader, On va cr�er l'instance directement � l'int�rieur de BufferedReader. vous savez ce que c'est une m�thode, une fonction. Comment fonctionnent les param�tres ou les arguments quand on fait ici des d'instanciations mais nous on va le faire avec une �tape suppl�mentaire pour que ce soit plus lisible au niveau de la vid�o. 
Donc on fait un InputStreamReader :

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader();
       BufferedReader br = new BufferedReader();
	}
}

On fait notre InputStreamReader que l'on va appeler ISR Et on va l'instancier comme ceci : = new InputStreamReader();
Et lui ne prend pas un Reader ici comme argument lorsqu'on va faire l instanciation Mais il attend comme donn�e tout simplement un flux que l'on veux. Et le flux que l'on veut, on en conna�t un qui est d�j� pas mal qui est Systeme.out 
Rappelez vous quand on utile Systeme.out et qu'on fait ensuite un println("Hello") pour afficher un message.

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader();
       BufferedReader br = new BufferedReader();
       
       System.out.println("Hello ")
	}
}
� Et bien vous avez l'inverse, au lieu de Systeme.out, on a system.in Qui est le flux de base, le flux standard pour l'entr�e. Alors on fait �a, attention il y a une majuscule � System. Tr�s important.

	InputStreamReader isr = new InputStreamReader(System.in);

Et du coup mon buffer, va prendre cette information.

       BufferedReader br = new BufferedReader(isr);

Il va utiliser ce lecteur de flux d'entr�e : 

	InputStreamReader isr = new InputStreamReader(System.in);

� lors de la cr�ation du constructeur, l'appel au constructeur de cette classe pour pouvoir �tre utilis�.
C'est tr�s simple mais voyez comme ce que l'on dit du langage Java, ce que c'est un langage tr�s verbeux c'est � dire que d�s qu'on va vouloir utiliser quelque chose en particulier, on doit tout renseigner en fait. Il n'y a pas forc�ment des usages implicites qui sont faits, c'est l� qu'on voit qu'on a besoin d'un certain type de donn�es en particulier :

	(isr);

Un type de donn�es particulier pour le buffer, et bien on doit cr�er cette donn�e l�.

Alors soit on fait comme �a de mani�re interm�diaire, soit on fait directement �a :

BufferedReader br = new BufferedReader(new InputStreamReader());

Si vous n'avez pas encore compris �a, ce qu'il y a des choses que vous n'avez pas encore compris au niveau de la programmation objet et qu'il faudra revenir dessus. 
Ce qu'on vient d'�crire ici, c'est exactement la m�me chose bien que ce soit peut-�tre un peu moins lisible mais il est recommand� de faire en 2 �tapes : 

	InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);

Une fois qu'on a notre buffer qui est pr�t, on va pouvoir tout simplement commencer � l'utiliser. 

On rappelle que tout est cha�ne de caract�res quoi qu'il arrive, peu importe l'information que l'on va demander, ce sera � stocker dans une cha�ne de caract�res obligatoirement.

       System.out.print("Comment t'appelles-tu ?");

Donc on fait la fameuse question comment t'appelles-tu? On va rester sur quelque chose notre simple. On va faire un simple print sans retour � la ligne.
	
       String name = br.(...)

On pr�pare ensuite la donn�e String name et on va le stocker dans br.
On va utiliser une m�thode par rapport � la lecture.
Pour �a nous en avons quelques unes :
- on a read() qui va lire un caract�re 
- On a readLine(), avec un L majuscule pour tout simplement lire un mot complet par rapport � ce que l'on r�cup�re, pour une cha�ne.
De toute fa�on il travaille toujours sur des cha�nes de caract�re compos� que d'un seul caract�re read() ou d'une cha�ne compos�e de plusieurs caract�res readLine(). Mais �a reste la m�me chose.
Ensuite on peut ignorer certains caract�res, pour une raison ou une autre ignorer un certain nombre de caract�res, on peut le faire. Il y a un certain nombre de caract�res � passer dans la m�thode skip(). Par exemple, skip(N) ignore N caract�res.

/
	BufferedReader -> 	synchrone
						thread-safe
						lecture de cha�ne de caract�res (String)
		- read() : lire un caract�re
		- readLine() : lire une cha�ne
		- skip(N) : ignore N caract�res

	Scanner -> 	asyncrhome
				not thread-safe
				lecture de donn�es + parsing
/
Ici quelques m�thodes utiles, qu'on a souvent besoin en programmation et il y en a forc�ment d'autres mais celle l� en tout cas sont les principales.

Donc ici on veut r�cup�rer un nom au complet, donc on va faire simplement un readLine() et � la fin on va l'afficher, on affichera directement name avec la m�thode println().

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{
	public static void main(String[] args)
	{	
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
       
		System.out.print("Comment t'appelles-tu ?");
		String name = br.readLine();
       
		System.out.println(name);
	}
}

On compile javac App.java et l� on va avoir un message d'erreur :

	error: unreported exception IOException; must be caught or declared 	to be thrown
                String name = br.readLine();
                                         ^

� qui veut tout simplement dire que notre m�thode ici readLine() peut �ventuellement lever une exception mais on ne sait pas � ce stade de la formation ce que c'est mais �a tombe bien parce que �a fera la transition avec la prochaine s�ance. Il dit qu'on va devoir capturer cette exception Ou alors d�clar� que notre code peut �ventuellement lever une exception. �a ne veut pas dire qu'il a fait, �a veut tout simplement dire que c'est un risque potentiel qui arrive ainsi � la compilation Java, on nous pr�vient que cette m�thode ne va pas forc�ment faire ou r�cup�rer la donn�e que nous attendons et elle peut dans ce cas-l� lever une exception.

Sans entrer dans les d�tails, une exception Une exception va permettre notamment de soulever une erreur au niveau de notre programme et c'est ce que nous verrons dans la prochaine vid�o. pour le moment qu'on n'a pas encore abord� cela, on va juste s'occuper d'ajouter throws et Exception avec un E majuscule.
*/

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class App
//{
//	public static void main(String[] args) throws Exception
//	{	
//		InputStreamReader isr = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(isr);
//       
//		System.out.print("Comment t'appelles-tu ? ");
//		String name = br.readLine();
//       
//		System.out.println(name);
//	}
//}

/*
throws Exception, C'est simplement une petite indication pour dire que ma m�thode statique main, Elle peut �ventuellement dans son code un moment donn� lever une exception C'est-�-dire il peut y avoir une erreur qui survient lors de l'ex�cution Du programme. �a peut arriver et notamment � cause de cette m�thode readLine().

Donc juste avec �a on va pouvoir �viter le petit warning et on va pouvoir recompiler et m�me tester notre programme. 

	>javac App.java
	>java App
	Comment t'appelles-tu ? Samuel
	Samuel

On test notre programme, on met l'information et celle-ci est bien r�cup�r�e.
Comme tout est consid�r� comme �tant une cha�ne de caract�res, Pour rappel si on met un nombre: 

	Comment t'appelles-tu ? 64949
	64949

� Ce sera r�cup�r� comme une cha�ne de caract�res, �a fonctionnera aussi. 

Notion de tampon
================

Autre information aussi tr�s importante, d�s qu'il y a une lecture, on a une histoire de m�moire tampon, de buffer et ce buffer a aussi une petite diff�rence.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de cha�ne de caract�res (String)
					tampon de 8192 caract�res
		- read() : lire un caract�re
		- readLine() : lire une cha�ne
		- skip(N) : ignore N caract�res

	Scanner -> 	asyncrhome
			not thread-safe
			lecture de donn�es + parsing
			tampon de 
/

Si on ne se trompe pas, le tampon de BufferedReader est un peu plus important parce que ici on est sur de la simple lecture et non pas sur du parsing. Pour BufferedReader le tampon est de 8192 caract�res Donc �a ce n'est pas une valeur prise par hasard, tout simplement des multiples comme on le retrouve beaucoup en informatique. Si on voit la taille de notre m�moire vive, de notre disque dur et cetera, �a fait 8 16 32 64 128 256 512 1024 2048 4096 8192 et cetera. 

Donc ils ont choisi arbitrairement cette taille pour se dire on cr�era un nouveau tampon, un nouveau buffer, si le nombre de caract�res entr�s d�passe cette longueur de 8192 caract�res.

Donc �a laisse quand m�me pas mal de marge avant de remplir le premier tampon de lectures, donc 8192.

Or scanner on peut le noter l� mais on verra son utilisation apr�s. lui c'est un tampon par contre 1024 caract�res, un peu plus petit.

Conc en gros si on atteint les 1024 caract�res, un 2e tampon est cr�� et cetera et cetera.

Ca aide de cr�er un tampon de 1 caract�re et du coup de faire imaginer plein d'op�rations de cr�ation de tampon par caract�re lu, Parce qu'il serait �videmment tr�s tr�s co�teux. C'est souvent un probl�me sans en �tre un mais il y a une chose sur lequel il faut pas mal r�fl�chir quand on fait de la programmation Ou quand quelqu'un cr�e un langage, de se dire que au niveau des tampons de lecture, quelle taille je choisie ? 

Parce que si on prend trop grand, ce sera peut �tre trop en m�moire r�serv�e. Si on prend trop petit, il faudra cr�er plus souvent des tampons et �a va demander pas mal d'op�rations co�teuses. Il faut essayer de trouver le juste milieu.

voil� par rapport � la formation sur la taille de tampon Pour BufferReader.

� partir d'ici nous pouvons lire n'importe quel type de donn�es qui sera encore une fois consid�r� comme une cha�ne de caract�res. N'essayez pas de faire un read ou un readLine Dans une donn�e de type int, �a ne marchera pas. Vous aurez une erreur par rapport ici au type :

       String name = br.readLine(); -> OK
       int name = br.readLine(); -> NOK

On ne peut pas convertir, on ne peut pas caster notre cha�ne en entier. 
Ca ne peut pas aller si on attend un entier et qu'on essaye de passer une cha�ne de caract�res.
Dans quel cas utiliser cette m�thode l� ? Je vous l'ai dit tout est indiqu� en commentaire, BufferedReader est utilis� si on veut lire de la cha�ne de caract�res sans avoir besoin de v�rifier un type particulier, donc juste pour de la lecture. Si on veut juste lire de la cha�ne de caract�res, la solution et c'est du coup la plus rapide des 2 pr�sent� dans cette s�ance, c'est BufferedReader. C'est pour �a qu'on la pr�sente en premier.

La classe Scanner
=================

Maintenant si on a besoin de v�rifier un type pr�cis et qu'on a besoin de r�cup�rer une donn�e, absolument un nombre, et qu'on ne veut pas que ce soit une cha�ne mais juste un nombre arithm�tique qui permettra et qui servira dans la base d'un calcul admettons. On utilisera plut�t la classe scanner.

Cette classe Scanner va dans java.util qui regroupe toutes les classes utilitaires de Java, qui sont toutes stock�es dans java.util
On a pas mal de classe l� dedans. 

       import java.util.Scanner;

Pour Scanner l'utilisation est tr�s simple. Donc �a va aller tr�s vite.
On a encore une fois toutes les informations utiles, scanner et asynchrone, du coup ce n'est pas thread-safe par contre c'est beaucoup plus lourd � l'usage que BufferedReader Parce qu'il y a une lecture de donn�es avec v�rification du type en fonction de la m�thode utilis�e et un parking puisqu'il va falloir contr�ler justement, faire des conversions par rapport � �a. Le tampon est plus petit, on vient de le dire tout � l'heure donc on ne reviendra pas l�-dessus. 

Ici l'usage est un petit peu plus court, on fait simplement : 

public class App
{
	public static void main(String[] args) throws Exception
	{	
		Scanner sc = new Scanner();
	}
}

Scanner() Va directement prendre le feu sur lequel on veut travailler Donc pas besoin de passer par InputStreamReader ou autre. Il prend un Input String Directement en param�tre, il attend un argument pour le constructeur. et on fait ceci :

public class App
{
	public static void main(String[] args) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
	}
}

� partir de l� il y a plusieurs possibilit�s de lecture parce qu'on avait dit qu'il y avait plusieurs m�thodes �ventuelles par rapport au type de donn�es que nous voulons lire et �a c'est tr�s important.

/
	BufferedReader -> 	synchrone
					thread-safe
					lecture de cha�ne de caract�res (String)
					tampon de 8192 caract�res
		- read() : lire un caract�re
		- readLine() : lire une cha�ne
		- skip(N) : ignore N caract�res

	Scanner -> 	asyncrhome
			not thread-safe
			lecture de donn�es + parsing
			tampon de 
		- nextLine()
		- nextChar()
		- nextByte()
		- nextFloat()
		- nextDouble()
		- nextInt()
		- nextBoolean()
/

On peut lire �ventuellement une simple cha�ne donc on peut tr�s bien dire tu lis la chose comme �tant une cha�ne, il peut attendre un bool�en, un entier ou n'importe quoi. 
On va avoir en gros plein plein plein de m�thode c'est-�-dire nextLine() au plus simple, au plus standard. On a �galement nextChar(), nextByte(), nextFloat(), nextDouble(), nextInt(), et cetera et cetera. Histoire de comprendre le principe. 
C'est pour �a que cette classe est un peu plus gourmande � l'utilisation et sera plus lente parce qu'en plus de faire de la lecture de donn�es, il faut qu'elle v�rifie �galement le type de donn�es qu'on lui donne et si la donn�e attendue n'est pas bonne, une erreur sera soulev�e, donc justement une exception Qui interviendra � ce moment-l�.

On enl�ve throws Exception, on verra si on le remet apr�s.
Ensuite du coup qu'est-ce que je peux faire ? Je vais faire un println() Et on demande par exemple:� acceder a quel niveau ?�. 

public class App
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Acceder a quel niveau ?");

	}
}

Si on �tait dans un jeu, ce ne serait pas forc�ment quelque chose qui servirait comme calcul, ce ne serait pas vraiment une valeur qui serait arithm�tique peu importe. On va dire qu'on attend absolument un nombre et pas autre chose et ensuite on affichera du coup game_level.

Du coup ici on pourra dire sans probl�me qu'on attend un entier. Donc j'�crit simplement nextInt(). Donc ici c'est une m�thode qui a comme op�ration une lecture et du contr�le de la v�rification, donc du parsing.
Donc elle va parser les donn�es pour s'assurer que en faisant la conversion n�cessaire, que l� donn�e est bien valide, un entier et pas autre chose. Donc il y a plus d'op�rations, plus gourmand du coup � l'utilisation.
Si nous n'avons rien oubli� nous allons pouvoir l'utiliser �
*/

import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Acceder a quel niveau ?");
		int game_level = sc.nextInt();

		System.out.println(game_level);
	}
}

/*

On compile, on ex�cute, On demande quel niveau, on l'inscrit tant que �a reste un entier alors pas de probl�me mais si �a finit par d�passer la taille d'un entier au niveau du langage, on aura une exception de lever :

	>java App
	Acceder a quel niveau ?
	999999999999999776
	Exception in thread "main" java.util.InputMismatchException: For 	input string: "999999999999999776"
        	at java.base/java.util.Scanner.nextInt(Scanner.java:2264)
        	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        	at App.main(App.java:425)

� Une exception de lever, InputMismatchException.
comme on a pas encore abord� des exceptions, en rentre pas encore dans les d�tails l� dessus. On le verra dans la prochaine s�ance. 
On a une erreur qui est indiqu�e , une exception qui est lever et qui provoque l'arr�t du programme. 
Donc tr�s important, on verra que les exceptions sont absolument utiles, il faut s'en servir et c'est pour �a qu'on va faire une vid�o d�di�e � �a pour la prochaine s�ance de secours de Java. 
Donc si on �crit :

	Acceder a quel niveau ?
	64
	64

Comme �a �a marche et si on �crit une cha�ne :

	Acceder a quel niveau ?
	Jason
	Exception in thread "main" java.util.InputMismatchException

Toujours pareil une exception sera lever.
vous voyez il y a une op�ration suppl�mentaire de v�rification de donn�es donc si un jour vous avez besoin d'avoir un type de donn�es bien pr�cis, utiliser scanner, elle est fait pour �a. 
Si c'est juste de la lecture toute b�te, ne vous emb�tez pas avec �a, votre programme sera beaucoup plus lent, utiliser de pr�f�rence BufferReader et ce sera beaucoup plus efficace dans ce cas-l� m�me si elle est synchrone et g�n�ralement pour beaucoup d'autres cas, Quelque chose qui est synchrones sera g�n�ralement beaucoup plus lent une classe qui travaille de mani�re asynchrone donc attention prenez cette habitude aussi surtout en Java parce que le langage est tr�s complet, il y a beaucoup de classes disponibles, de m�thode,de choses disponibles. du coup on ne sait pas toujours quoi utiliser dans quel contexte donc prenez l'habitude avec la documentation De vous renseigner de voir un peu comment et composer une classe, de quelle mani�re elle est utilis�e, comment elle fonctionne derri�re et apr�s ce long contexte d'utilisation , ce long la partie de notre programme bien pr�cises, bien sp�cifique, Vous serez s'il vaut mieux utiliser telle classe ou telle classe. 
Il n'y a malheureusement pas de classe toute faite il fonctionnera tout le temps dans le meilleur des cas, dans tous les contextes d'usage, c'est vraiment cas par cas. c'est � nous en tant que d�veloppeur de savoir dans quel cas on va utiliser �a et dans quel cas on va utiliser �a. 
Sur cette s�ance , je voulais juste qu'on voit de la lecture de donn�es. On a BufferedReader, on a scanner et on sait maintenant les diff�rences entre les 2. �a nous donne d�j� pas mal d'indices sur l'usage que l'on peut en faire avec l'une ou avec l'autre. N'h�sitez pas � faire pas mal de programme pour vous entra�ner et n'h�sitez pas � le coupler avec tout ce que vous avez vu sur les cha�nes de caract�res, �a peut �tre pas mal utile parce qu'ici on ne s'est pas amus� � utiliser du StringBuilder ou du StringBuffer pour faire certaines choses Ou des concat�nations et vous pouvez bien �videmment coupler tout ce que vous avez vu pr�c�demment pour vous entra�ner, pour vous exercer avec ce langage Java.
on se retrouve pour la prochaine s�ance o� on abordera les exceptions. �a fait du coup une bonne transition avec la prochaine s�ance concernant les exceptions virgules pour voir comment g�rer les erreurs en Java. A bient�t.

*/



