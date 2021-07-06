/*

Java #17 - exceptions

Bonjour sur ce cours Java. Nous arrivons avec la s�ance 17 pour parler des exceptions Pour faire suite directement avec ce qu'on avait termin� dans la s�ance pr�c�dente, avec la lecture de donn�es au clavier.
Les exceptions, c'est tout simplement une mani�re dans quelque langage � paradigme objet, � technologie orient�e objet, � programmation orient�e objet pour pouvoir g�rer des erreurs qui pourrait arriver, qui pourrait �tre lev� au cours de l'ex�cution d'un programme et pouvoir les g�rer, les traiter. On va regarder comment on peut faire �a en Java.
Vous verrez que c'est tr�s tr�s simple, c'est aussi tr�s important de prendre en compte tout �a lors de d�veloppement de nos applications, de nos programmes, de bien g�rer les exceptions qui peuvent survenir au cours de l'ex�cution. 

Rappel de Scanner
=================

Pour cela on va reprendre un code assez similaire � ce qu'on a vu pr�c�demment pour l'utilisation de scanner. On demande une date de naissance, qui est une information du coup bien pr�cises et on veut la stocker dans une variable de type entier (integer). 

Du coup on fera appel � la m�thode nextIn() et � partir de l� on affichera tout simplement cette date de naissance.

*/

//import java.util.Scanner;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Annee de naisance : ");
//		int yearOfBirth = sc.nextInt();
//		System.out.println(yearOfBirth);
//	}
//}

/*


Jusqu � pr�sent ce qu'on avait vu et notamment dans la s�ance pr�c�dente qu'il y avait un risque que cette donn�e ne soit pas bonne. C'est d'ailleurs pour �a que scanner est un peu plus longue parce que c'est une m�thode qui va lire une donn�e et qui va ensuite effectuer des conversions via des contr�les, des v�rifications et cetera pour le type de donn�es que nous voulons parser, que nous voulons r�cup�rer.

Tant que je rentre en tout cas une donn�e qui va bien, il n'y a pas de probl�me, la donn�e sera �videmment lu, stock� et on pourra l'afficher :

       Annee de naisance : 1994
       1994
       
Et � partir du moment o� on rentre autre chose qu'un entier, on aura une exception qui sera lever :

	Annee de naisance : jason
       Exception in thread "main" java.util.InputMismatchException

Notamment une exception ici : InputMismatchException qui appartient au paquet java.util
Attention il faudra penser lorsque vous travaillez avec certaines choses de ne pas oublier d'importer les bons package si vous voulez.
� partir de l�, en tant qu'utilisateur, si on a ce genre de r�sultats � l'ex�cution, � l'utilisation d'un programme que ce soit un jeu ou une application Pour un site ou pour n'importe quoi, ce n'est �videmment pas logique et pas du tout coh�rent et acceptable. On ne peut pas laisser ce genre de choses-l� � l'utilisateur, c'est aux d�veloppeurs de g�rer ces exceptions c'est-�-dire que si on risque une exception soit lever dans un programme, il faut absolument la g�rer. 
Quand on n'a vraiment pas besoin de g�rer une exception et qu'on a une bonne raison de le faire, simplement laisser des exceptions se lever sans �tre traiter plut�t que de laisser par d�faut. 
Et g�n�ralement, le compilateur, on avait vu dans la vid�o pr�c�dente pourra nous indiquer qu'une exception pourra �tre lever, qu'elle n'est ni captur�, on verra en quoi �a consiste apr�s, o� alors que vous n'indiquez pas simplement qu'une partie de notre code peut lever une exception.

C'est pour �a qu'on s'�tait amus� � faire : throws Exception et on avait dit du coup que �a ferait un peu la transition avec ce que nous allons voir prochainement. C'est un petit peu le sujet ici.

throws Exception est un petit peu la m�thode de secours et pas forc�ment la meilleure, de dire que voil� cette m�thode main ici, il est possible qu'� un endroit au cours de l'ex�cution, l�ve une exception, elle 'throws' une 'Exception', mais �a �a ne nous int�resse pas. On veut pouvoir g�rer justement ces exceptions qui risque d'�tre potentiellement lev�.

Le bloc try catch
=================

Et pour se faire nous allons d�couvrir un nouveau bloc tr�s simple d'instruction, qui est le bloc try catch qui va permettre de g�rer un certain nombre d'op�rations et au cours de cette diff�rentes op�rations si une exception est lever, g�n�ralement on le fait quand on sait qu'il y a un risque que �a arrive.

Si vous savez qu'il y a une partie de votre code et vous savez qu'il n'y a aucun risque qu'une exception soit lever, �a ne sert � rien de mettre un bloc try catch.

Et dans ce cas-l�, on va laisser certaines op�rations, si une exception est lev�e, on traitera l'exception qui a �t� lev�e. Et si il n'y en a pas l'exception continuera.
�a fait un peu penser au bloc if else, ou par exemple, on a une condition, une expression qui est v�rifi�e, si elle est valide �a va et si elle ne l'est pas, on va passer dans le bloc, dans la partie du else et �a rejoint un petit peu ce genre de choses-l�.

Ici la partie un petit peu sensible, la partie qui nous int�resse ou en tout cas qu'on veut contr�ler c'est : 

	System.out.print("Annee de naisance : ");
	int yearOfBirth = sc.nextInt();
	System.out.println(yearOfBirth);

C'est-�-dire qu'on va demander une info, attendre sa saisie et l'afficher. C'est-�-dire qu'elles sont un petit peu d�pendant. �a sert � rien d'afficher un texte qui demande l'ann�e de naissance si vous ne demandez rien derri�re Comme en m�me temps on ne peut pas simplement derri�re demander une saisie si la personne ne sait pas ce qu'il doit saisir et en m�me temps on ne pourra jamais afficher une date de naissance si elle n'a pas �t� saisie et afficher une date de naissance qui ne serait pas correct. Vous voyez donc que ces 3 instructions, ces lignes de code, sont assez d�pendantes les unes des autres, son coh�rentes entre elles donc elles font partie d'un bloc homog�ne, elles vont ensemble et c'est cette partie-l� qui est sensible de notre code.
c'est cette m�thode nextInt() qui dans certains cas, pas tout le temps merci on fait pas que ce soit volontaire o� involontaire, la saisie d'une donn�e qui est correcte, qui est valide, une exception sera toujours lever et notamment InputMismatchException.

Dans ce cas, nous allons mettre cette partie-l� dans un bloc try catch :

import java.util.Scanner;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
       try
       {
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
       }
       catch()
	}
}

Voil� comment �a se fait, tout simplement comme pour les if else ou les boucles, on utilise des accolades avec notre try. �a ce sera la partie qu'on va essayer, try pour essayer, c'est-�-dire la partie des op�rations que nous allons tenter d'effectuer au niveau du programme. 

Et ensuite un bloc minimum, il nous en faut au moins un, un premier catch avec le titre d'exception qui peut arriver.

Comment fait-on Lorsqu'on utilise tout un tas de m�thodes qu'on ne conna�t forc�ment pas coeur mais qu'on est en train de les d�couvrir, comment on fait Pour savoir dans les m�thodes qu'on utilise, d�j� est-ce qu'il y a des m�thodes qui peuvent �tre lev�es et si oui lequel, comment elles s'appellent ? Par exemple, InputMismatchException, �a n'a aucun int�r�t de l'apprendre par coeur et en plus il existe tellement de type d'exception Diff�rents pour chaque classe, chaque m�thode et cetera, que �a n'aurait aucun int�r�t , une perte de temps et �a finirait de toute fa�on � devenir impossible de tout conna�tre et de se souvenir de tout �a c'est pour �a qu'il faut absolument encore une fois prendre l'habitude de nous r�f�rer � la documentation, la javadoc. Par exemple si on veut des informations sur InputMismatchException, on le fait suivre de javadoc dans notre moteur de recherche et on retombera sur la documentation Officiel qui nous donnera toute l'information dessus.

ou bien alors vous Notez tout simplement un nom de m�thode comme nextInt() Et sur la documentation en Java, vous indiquera clairement quel type d'exception exact, avec les noms exacts, peut lever, peut g�n�rer l'usage de ce genre de m�thode, tout simplement. 

� partir de l�, vous pouvez d�j� traiter dans votre code les choses comme il faut. 

A l'ex�cution, on a java.util.InputMismatchException donc du coup on va l'ajouter.

	import java.util.Scanner;
	import java.util.InputMismatchException;
	
La du coup exceptionnellement comme on est sur le m�me package, on peut encore une fois raccourcir tout �a en mettant une �toile. Donc on l'a �crit manuellement pour que ce soit lisible au niveau de la vid�o.

	import java.util.*;

Mais ici on rajoute une �toile pour pas s'amuser � rajouter tout � chaque fois surtout s'il y avait d'autres types d'exceptions � ajouter, on va �viter de le faire parce que l� on va commencer � avoir beaucoup de imports. Donc on peut s'amuser � importer de cette mani�re-l�.

A partir de cette partie, on peut du coup dire je pr�vois de capturer au niveau de mon code, ce type d'exception: 

	catch(InputMismatchException)

� On va le englober dans une variable et par convention on l'appelle g�n�ralement e. On l'appelle comme on veut, on met absolument le nom que l'on veut. 

	catch(InputMismatchException e)

C'est juste un nom de variable, on est libre de choisir, et nous avons du coup ce nouveau bloc de code.

encore une fois on retrouve un petit peu ce genre de comportement qu'on avait avec un bloc if else qu'on a d�j� vu avant. 

en gros on fait : 

	System.out.print("Annee de naisance : ");
	int yearOfBirth = sc.nextInt();
	System.out.println(yearOfBirth);

Et si tout se passe bien, toute la partie du catch ou des catch parce vous verrez qu'on peut en avoir plusieurs, sera parfaitement ignor�. On passera � la suite du code par contre si un certain type d'exception est �lev�, le compilateur, durant l'ex�cution c'est-�-dire la machine virtuelle plus exactement de Java verra quel type a �t� lev�e Il va ensuite sauter directement au cash qui correspond avec le type d'exception.
Donc dans notre cas-ci il y a un InputMismatchException Qui a �t� lever, il va trouver un catch qui poss�de justement ce type l� donc il va entrer dans ce bloc de code et effectuer certaines choses.

Donc le minimum � faire si on ne veut pas vraiment trop s'arr�ter, c'est de pr�ciser quelque chose pour l'utilisateur qui soit coh�rent par rapport � ce qui est arriv�. En gros ici, � la date de naissance est invalide ou incorrecte �.

*/

//import java.util.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		try
//		{
//			System.out.print("Annee de naisance : ");
//			int yearOfBirth = sc.nextInt();
//			System.out.println(yearOfBirth);
//		}
//		catch(InputMismatchException e)
//		{
//			System.out.println("La date de naissance est incorrecte.");
//		}
//	}
//}

/*

Donc vous voyez ici qu'il y a une variable pour l'exception, on ne s'en sert pas mais on va revenir dessus. l� on ne s'en sert pas mais il faut quand m�me englober l'exception dans une variable 'e'.

Donc on fait �a et maintenant on passe � nouveau � l'ex�cution Qui est un peu plus correct.

Encore une fois si on saisit une date de naissance valide il n'y aura pas de probl�me :

	Annee de naisance : 1991
	1991

Si par contre je saisi autre chose qu'une donn�e qui puisse �tre converti en entier. Cette fois-ci on n'aura plus tous ces messages bizarres et on a quelque chose de bien plus coh�rent et compr�hensible pour l'utilisateur, "La date de naissance est incorrecte".

	Annee de naisance : jason
	La date de naissance est incorrecte.

Le programme est bien �videmment arr�t� parce qu'on n'a rien d'autre apr�s, je n'ai pas autre chose de fait de toute fa�on Et nous avons cette partie l�. 

Voil� comment �a fonctionne.

on peut �galement avoir plusieurs types d'exceptions, on pourrait avoir plus 5 - 6 lignes de code Dans le bloc try les 2 lignes qui pourraient lever chacune 2 exceptions diff�rentes mais comment on fait pour trait� ce cas ? Eh bien il suffit de cumuler les catch.

Cumuler les catch
-----------------

Par exemple on peut mettre un autre nom, "RuntimeException", Mais �a on l'utilisera pas. c'est une partie assez g�n�rale du coup c'est pas forc�ment une bonne id�e. Bref mettons un nom qui n'existe pas pourquoi nous embrouiller. En gros on aura un autre type d'exception "OtherExeption" et qui serra traiter dans ce nouveau bloc.

import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println("La date de naissance est incorrecte.");
		}
		catch(OtherExeption e)
		{
			
		}
	}
}

Donc qu'est-ce qui va se passer ? Certaines lignes de code vont �tre faites, certaines op�rations, et il y a un moment donn� un risque InputMismatchException qu'il soit lev� et dans ce cas-l� on va faire ce qu'il y a dans le catch :

	catch(InputMismatchException e)
       {
		System.out.println("La date de naissance est incorrecte.");
	}
Si �a n'arrive pas, tant mieux et en admettant une autre ligne, une autre op�ration qui va lever OtherExeption, mais de toute fa�on c'est un mot qui n'existe pas on vient de l'inventer, et dans ce cas-l� on rentrera dans ce bloc catch 

	catch(OtherExeption e)
	{
		
	}

C'est-�-dire qu'on ne va pas tous les faire, c'est en fonction du type d'exception qui aura �t� lever et donc on les traite comme �a. On met les plus potentiels en premier et on met les autres apr�s, sur la fin .

	catch(Exception e)
	{
		
	}

G�n�ralement si vous avez un type d'exception bien sp�cifique, on le met d'abord et on termine avec la classe exception Quel temps fait une classe g�n�rale mais on en parlera dans une prochaine vid�o quand on abordera notamment l'h�ritage et on verra notamment qu'il y a des familles de classes en programmation objet c'est-�-dire que vous avez des classes qui peuvent permettre de cr�er d'autres classes qui sont un peu plus sp�cialis�s et qui poss�de tout ce que les autres ont. Donc par exemple ici "InputMismatchException", est une sorte d'exception comme "Exception". C'est un peu imaginer un enfant, un type d'exception qui est enfant de cette classe qui est tr�s g�n�rale, qui est un peu abstraite un peu vague. Une exception �a veut tout dire et rien dire, c'est trop vague pour savoir quel type pr�cis mais �a existe aussi.
les types plus pr�cis d'abord et on termine ensuite par quelque chose de g�n�ral, en gros.
Quand vous mettez " Exception ", c'est un type qui existe pour le coup en Java. �a veut dire tout ce qui est un type d'exception Que tu n'as pas encore indiqu� avant dans un catch en particulier donc on ne rentrera jamais dans ce bloc :

	catch(Exception e)
	{
		
	}

� Si on a une InputMismatchException puisqu'on l'a marqu� au-dessus, par contre si c'est une arithm�tique donc si c'est une IO exception, si c'est une NullPointerException, ou n'importe quoi d'autre, �a rentrera dans catch(Exception e){} Puisque �a ne concerne pas le "InputMismatchException". Je ne sais pas si vous comprenez un petit peu ce que je veux dire mais voil� en gros comment on traite les choses.

Donc �a c'�tait Donc �a c'est un cas et �a ne sert � rien de vous donner un exemple qui peut avoir plusieurs lev�s d'exception mais en gros voil� comment on peut les accumuler.

Et maintenant, on peut aussi songer� c'est lequel lorsqu'on veut �crire un fichier, on veut tenter d'ouvrir un fichier ou alors on a un fichier d�j� ouvert, on travaille dessus et quand on veut� qu'on a par exemple une erreur, une exception survient, on n'a pas envie de quitter le programme sans fermer le fichier donc il faudra dire que si il y a une exception qui est lev�, il y a quand m�me des choses, des op�rations qu'on veut faire malgr� l'exception qui a pu �tre lev� et du coup captur�. 

Et pour sa, on aura un autre type de bloc qui s'appelle finally :

	finally
	{
		
	}
� Blog qui veut dire que peu importe qu'il y ait une exception ou pas de lever bref dans tous les cas quoi qu'il arrive, quel que soit le sc�nario au moment de l'ex�cution du programme, on fera ce qu'il y a dans le bloc finally{}.

On va juste faire un affichage pour voir que c'est le cas :

*/

//import java.util.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		try
//		{
//			System.out.print("Annee de naisance : ");
//			int yearOfBirth = sc.nextInt();
//			System.out.println(yearOfBirth);
//		}
//		catch(InputMismatchException e)
//		{
//			System.out.println("La date de naissance est incorrecte.");
//		}
//		finally
//		{
//			System.out.println("ok");
//		}
//	}
//}

/*
Vous verrez que peut importe exception ou pas, le mot ok serra affich�.
Si jamais une donn�e valide, le ok bien afficher.

	Annee de naisance : 1991
	1991
	ok

Si je mets une donn�e non valide qui va lever une exception InputMismatchException, on voit que le ok est quand m�me affich�. Voil� comment �a fonctionne. 

	Annee de naisance : ezefzf
	La date de naissance est incorrecte.
	ok

Donc si vous avez absolument besoin de faire quelque chose peu importe ce qu'il se passe avant, vous utilisez un bloc finally. C'est logique il n'y a qu'un seul bloc finally dans toute une structure comme : 

	try
	{
		System.out.print("Annee de naisance : ");
		int yearOfBirth = sc.nextInt();
		System.out.println(yearOfBirth);
	}
	catch(InputMismatchException e)
	{
		System.out.println("La date de naissance est incorrecte.");
	}
	catch(IOException e)
	{
		
	}
	catch(Exception e)
	{
		
	}
	finally
	{
		System.out.println("ok");
	}

On a un seul try, on peut avoir plusieurs catch avec diff�rents types d'exceptions � la suite. Voil� c'est tout � fait un format possible pour traiter des exceptions c'est-�-dire qu'on a un cas bien pr�cis InputMismatchException, autre cas IOException bien pr�cis et si on a ni l'un ni l'autre, C'est-�-dire un autre mais qu'on ne veut pas forc�ment encadrer o� traiter Un type bien sp�cifique d'exception, on dit alors que tous les autres types on les traitera dans Exception De la m�me mani�re, tout le monde sera log� � la m�me enseigne et dans tous les cas qu'on soit pass� par les catch ou non, on fera ce qu'il y a dans le bloc finally. Voil� comment il faut comprendre cela, c'est tr�s simple c'est juste qu'il y a de la syntaxe � conna�tre, que vous apprenez en plus mais il n'y a vraiment rien de compliqu� � l'utilisation des exceptions mais il faut absolument le faire parce que sans �a on peut avoir du coup des erreurs qui arrivent sur notre programme et si elles ne sont pas trait�es Ben tant pis. Le programme s'arr�tera et on pourra plus rien y faire ce qui est un peu dommage pour l'utilisateur quand m�me donc on g�rera tout �a.
voil� pour cette partie.

printStackTrace() et getMessage()
=================================

Alors comment fonctionnent ces exceptions ? parce qu'on avait dit qu'il n'y a juste syntaxe � conna�tre, le try catch, finally et cetera. Le fait de savoir ici qu'il y a une petite variable 'e' et cette variable justement permet via son type InputMismatchException par exemple d'utiliser quelque m�thode particuli�re que je vais vous en donner 2 qui sont les plus utilis�s, et il en existe quelques autres mais celles-l� sont vraiment les plus importantes.
Rappelez-vous tout � l'heure lorsqu'on n'avait pas l'exception, on avait tout un tas de ligne qui �tait affich�, c'est ce qu'on appelle en fait une pile, une pile signifie qu'on a plusieurs informations empiler qui a dit qu'un petit peu toutes les erreurs qui ont pu arriver c'est-�-dire par exemple qu'on a eu un petit probl�me qui a pu en entra�ner un autre qui en a entra�n� un autre qui en a entra�n� un autre. 
Donc chaque partie s'encha�ne et �a forme comme �a une pile d'erreur dans laquelle on peut remonter, on peut retrouver l'origine du probl�me et �a lorsqu'on traite l'exception On a plus cette pile qui est affich�e.
Mais si vous avez absolument besoin malgr� tout de l'afficher Eh bien on peut le faire. 

printStackTrace()
-----------------

Pour revenir encore sur ce qu'on avait tout � l'heure on va utiliser la variable 'e' et appelez la m�thode printStackTrace() avec une majuscule encore une fois � chaque nouveau mot du nom de la m�thode et �a elle affiche directement le r�sultat.
*/

//import java.util.*;
//
//public class App
//{
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		
//		try
//		{
//			System.out.print("Annee de naisance : ");
//			int yearOfBirth = sc.nextInt();
//			System.out.println(yearOfBirth);
//		}
//		catch(InputMismatchException e)
//		{
//			e.printStackTrace();
//		}
//	}
//}

/*
On fait javac App.java et java App et on met une donn�e qui ne va pas :

Annee de naisance : zzef
java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at App.main(App.java:354)

Et voil� on retrouve exactement l'affichage de tout � l'heure, �a c'est la fameuse pile qui nous dit que par exemple ici tout en bas de la pile :

	at App.main(App.java:354)

� que dans le fichier App.java, ligne 354, Il y a eu un probl�me qui du coup faisait r�f�rence� s'�taient encha�n�s � java.util.Scanner.nextInt.

�a semble plut�t coh�rent car le nextInt est en fait un next.

java.util.Scanner.next est une partie globale c'est-�-dire qu'on attend une donn�e et apr�s on a un parse en Int (nextInt). On retrouve un petit peu le fonctionnement de scanner, on comprend qu'il y a une lecture et ensuite un parse "at java.base/java.util.Scanner.nextInt(Scanner.java:2258)".

Et l� on prend un petit peu les informations � l'envers, le parse en Int (nextInt) et avant tout une lecture next. Et ensuite, on a une histoire throwFor, o� throw qui fait penser � lever de throwException, ce qu'on avait avant qui va du coup entra�ner � c�est-�-dire que la lecture ici, le parse n'as pas march�. Comme le parse n'a pas march� et ben �a a �t� du coup, remont� � la lecture, qui a �t� remont� du coup au gestionnaire des exceptions qui a justement lev� une exception InputMismatchException.

On a donc une pile comme �a qui permet d'avoir l'historique de tous les probl�mes qu'il y a eu depuis le d�part et c'est une ligne de code qui entra�nait tous ses soucis. C'est pour �a que c'est important de traiter ses exceptions.

getMessage()
------------

Dans certains cas, vous pouvez avoir une exception qui g�n�re un message, �a peut arriver m�me si ici ce n'est pas forc�ment le cas, ici on aurait un message null.

Mais quand on a un message qui peut �tre g�n�r� on peut le r�cup�rer avec la m�thode getMessage().

	e.getMessage();

Et �a par contre comme �a retourne une cha�ne de caract�res, il faut afficher le retour de cette m�thode, le faire dans un petit println :

	System.out.println(e.getMessage());

Ce n'est pas forc�ment utile, mais on peut bien s�r concat�ner ou utiliser un Stringbuilder o� StringBuffer, ce que l'on veut pour concat�ner notre message avec le message qui a �t� retourn� :

	System.out.println("ERREUR : " + e.getMessage());
	
*/

import java.util.*;

public class App
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Annee de naisance : ");
			int yearOfBirth = sc.nextInt();
			System.out.println(yearOfBirth);
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
	}
}

/*

Donc 2 m�thodes, getMessage() et printStackTrace(), Qui permet soit de r�cup�rer le message li� � l'exception Ou alors r�cup�rer toute la pile des soucis qui ont pu arriv� par rapport � cette exception Et qui permettent souvent d'arriver � la source du probl�me, retrouver un petit peu la ligne de code concern�e et de faire ainsi un peu de d�bogage .

voil� pour sa, je pense que tout est dit ici et on va terminer avec une information un peu importante qui va pour le coup faire la transition avec la s�ance suivante c'est-�-dire la hi�rarchie d'exceptions. Comme je vous ai parl� de InputMismatchException, je vous ai dit qu'il y avait la classe Exception qui est beaucoup plus g�n�ral et vous ne savez pas ce que c'est encore l'h�ritage, on n'a pas encore parl� de toute cette notion. On en parlera dans la prochaine s�ance et on verra un petit peu comment �a s'organise en gros. 

Je vous ai fait un petit sch�ma.

				Throwable
					|
	Error ----------+---------- Exception
	AssentionError				DataFormatException
	IOError						IllegalClassFormatException
	ThreadDeath					IOException
	VirtualMachineError			NotBoundException
	...							
								...
	
			RuntimeException
					|
				ArithmeticException
				BufferOverflowException
				IndexOutOfBoundsException
				NullPointerException
				...


On a une classe g�n�rale qui s'appelle Throwable qui est une classe un peu vague c'est-�-dire que si on prend juste le terme de cette classe, elle ne veut pas dire grand chose. C'est trop vague, trop impr�cis pour comprendre en quoi elle consiste. 
Du coup vous verrez dans la prochaine s�ance, on va aborder l'h�ritage qui permet de faire une hi�rarchie, une famille de classe et qui les relie entre elles. 
�a, ce sch�ma, c'est un moyen de sch�matiser l'h�ritage en programmation Objet.
on a plus bas une classe Error et Exception, On retrouve cette fameuse classe g�n�ral dont je vous ai parl� qui h�ritent de Throwable.
Ca veut dire que Exception est une sorte de Throwable, une classe Throwable donc elle poss�de tout ce que � cette classe Throwable, avec des choses en plus.
elle est d�j� un petit peu plus pr�cise que Throwable mais pas suffisamment pour autant donc on a aussi de cette classe Exception, tr�s g�n�ral donc je ne vais pas parler des erreurs �a ne nous int�resse pas ici.
on a plein de classe Exception, un peu plus sp�cialis�, un peu plus pr�cise encore donc on voit qu'on a par exemple pour les entr�es et les sorties IOException, on en a pour l'environnement d'ex�cution RuntimeException, on en a pour le format de donn�es DataFormatException et cetera et cetera.
si je prends l'exemple de RuntimeException, c'est une classe aussi de Java Eh bien on voit que elle aussi comme elle est un peu vague, elle a �galement des classes qui h�ritent, qui sont plus sp�cialis�s et notamment ces derni�res: 

			RuntimeException
					|
				ArithmeticException
				BufferOverflowException
				IndexOutOfBoundsException
				NullPointerException
				...

je vous en ai mis plein ArithmeticException, BufferOverflowException Et cetera et cetera.

plus on descend dans l'arbre, dans la hi�rarchie et plus les choses se pr�cisent, se sp�cialisent et plus on monte vers le haut et plus on a des choses beaucoup plus vague, beaucoup moins explicite on va dire. C'est vague, c'est abstrait, on ne sait pas trop ce que �a signifie et qu'est-ce qui se cache derri�re et �a c'est le principe de l'h�ritage, c'est le principe des classes abstraites, de tout ce qui est polymorphisme. 
On en parlera, on aura pas mal de nouvelles notions qui vont arriver et de la s�ance prochaine on parlera justement de l'h�ritage.
ce sera donc beaucoup plus clair pour vous d'expliquer ce genre de choses-l�.
Et justement que l'on avait cette fameuse erreur :

	java.util.InputMismatchException

� Si je veux savoir o� est-ce qu'elle se trouve dans la famille, la hi�rarchie des exceptions, je vous ai fait un petit sch�ma pour vous montrer comment �a ce passe.
	
			Throwable
				^
			Exception
				^
		RuntimeException
				^
		NoSuchElementException
				^
		InputMismatchException

On a Throwable, Throwable c'est la classe m�re, c'est elle qui est au-dessus de tout le monde au niveau des exceptions, tout ce qui concerne les exceptions ou les erreurs, �a englobe �galement les erreurs. on a juste Throwable.
�a signifie concr�tement que �a ne signifie rien concr�tement, c'est abstrait c'est vague.
On ne peut pas vraiment dire grand-chose de mani�re concr�te, c'est tr�s tr�s abstrait, tr�s g�n�ral.
Dans Throwable, on a les exceptions, il y a d'autres choses mais on ne les montre pas ici et dans Exception, On peut se sp�cialiser en RuntimeException.
Et RuntimeException poss�de d'autres sous-classes tel que NoSuchElementException, et elle poss�de une sous classe qui est InputMismatchException.
Vous voyez il y a vraiment cette hi�rarchie, cette famille de diff�rentes choses et donc �videmment, tout ce que peut faire Throwable, InputMismatchException peut le faire aussi. 
En gros cette classe Throwable, qui est la plus haute, poss�de les fameuses m�thodes tel que getMessage() et printStackTrace() et cetera.
Et comme Throwable, elle a ses m�thodes d�finies, Exceptions, comme elle en h�rite, elle peut les utiliser aussi.
RuntimeException aussi puisqu'elle h�rit� de tout ce qui est Exception, Qui elle-m�me a tout ce que a Throwable. Et ainsi de suite, ainsi de suite.
je ne vais pas trop m'�taler l� dessus parce que c'est ce qu'on verra dans la prochaine vid�o de plus en d�tail, plus pr�cis�ment.
mais voil� le principe de l'h�ritage et comme �a �a fait la transition avec la prochaine s�ance.
j'esp�re que c'�tait suffisamment complet, j'essaie de vous expliquer au mieux pour que vous ayez un maximum d'�l�ments concernant les exceptions.
Donc la r�gle avec les exceptions, peu importe le langage de programmation d'ailleurs, c'est de v�rifier chaque m�thode, chaque classe o� chaque chose qui peut �ventuellement lever une exception, Encore une fois tout indiqu� dans la documentation.
Vous n'avez pas besoin de le deviner ou de l'inventer o� d'apprendre par c�ur, vous utilisez une m�thode donc regarder dans la doc, est-ce qu'elle peut lever des exceptions? Si oui quel type? Et g�rer vos exceptions. 
Il n'y a rien de plus mauvais en programmation qu'un d�veloppeur qui utilise un langage utilise tout un tas de choses qui l�ve des exceptions et ne les g�rent, et ne les traite jamais.
C'est comme �a qu'on a des programmes qui coupe et qu'on n'en fait rien.
Comme on ne fait rien on ne peut absolument rien contr�ler et c'est un peu dommage.
c'est l'avantage des langages objets qui proposent des exceptions, C'est quelque chose qui n'existe pas forc�ment dans d'autres langages de programmation Donc servez-vous en ce n'est pas l� pour ajouter du code inutilement, c'est vraiment la pour g�rer tout un tas d'erreurs, tout un tas d'exceptions qui peuvent arriver au cours de vos programmes et de l'ex�cution de vos programme.
N'h�sitez pas � faire des commentaires ou � partager les vid�os. 
Je vous laisse avec cette petite s�ance pour la prochaine vous savez ce qui vous attend o� nous parlerons d'h�ritage et de polymorphisme. 
Ciao tout le monde.

*/


