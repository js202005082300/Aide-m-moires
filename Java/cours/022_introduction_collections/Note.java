/*
Java #22 - introduction collections

Bonjour � tous et bienvenue pour cette vingt-deuxi�me s�ance en Java. 

Petite introduction Pour un grand chapitre qui arrive sur ce cours avec toutes les collections, la collection qu'on ne va pas aborder dans la globalit� parce qu'il y en a vraiment �norm�ment mais on va en aborder pas mal. 

Je voulais justement faire une petite vid�o d'introduction Pour revenir sur certaines choses et notamment des vid�os des s�ances qu'on n'a pu aborder pr�c�demment et qui vont nous servir. 

Pour suivre ce nouveau chapitre, il est inutile de suivre le cours si vous n'avez pas assimil� des notions comme l'h�ritage, le polymorphisme, le fonctionnement et l'utilit� des interfaces, on en a longuement parl�, Je vais essayer d'�tre un maximum complet et de vous donner un maximum de d�tails sur cette partie-l� pour que vous puissiez comprendre le principe et � quoi �a sert, dans quels cas vous allez pouvoir les employer.

Encore une fois comme je vous l'avais dit pr�c�demment, le langage Java est tr�s tr�s riche, riche en contenu et riche en classe qu'il poss�de d'une mani�re native que l'on utilise que l'on peut r�utiliser que l'on peut �tendre pour ajouter des fonctionnalit�s. 

Les interfaces permettent de garantir certaines fonctionnalit�s au niveau de nos programmes, c'est tr�s important. 

Si vous avez des probl�mes avec ces diff�rentes notions, ces diff�rents concepts en programmation et plus exactement le langage Java, �a sert � rien de poursuivre car tout ce que vous avez vu �videmment jusqu'� pr�sent va vous servir pour la suite et va vous aider un petit peu � comprendre tout �a. 

Les collections, il faut le voir comme des interfaces en principe parce que ce sont notamment les interfaces qui proposent la garantie qui en fait �tablissent un certain nombre de fonctionnalit�s d'accord. 
C'est en fait un contrat, une sorte de contrat pour dire que telle interface garantie que toute ces fonctionnalit�s, ces m�thodes en l'occurrence vont �tre disponibles, utilisable pour toutes les classes qui l'impl�menterons. 
Vous allez retrouver tout un tas de classes que vous allez pouvoir directement utiliser en programmation qui vont impl�menter ces diff�rentes interfaces et proposer diff�rentes mani�res de manipuler, de g�rer, de stocker des donn�es. 
Les collections c'est un terme qu'on utilise en Java pour pr�senter pour parler de tout ce qui est structure de donn�es. 

Vous avez peut-�tre vu dans d'autres langages de programmation Ou simplement en informatique de mani�re g�n�rale, entendu parler de pile, de liste, de file, on a vu pr�c�demment comme manipuler des tableaux � taille fixe notamment sur les premi�res s�ances du cours lorsqu'on a parl� des tableaux. 

Et l� on va manipuler des structures un petit peu plus complexe et surtout des structures dynamiques, l'avantage de ces diff�rentes structures c'est qu'elles pourront accueillir une taille variable d'�l�ments. 

Parce que en fait des collections permettent de stocker ce qu'on appelle des �l�ments, des diff�rentes donn�es et on peut ajouter de nouveaux �l�ments, en supprimer, on peut acc�der � ces diff�rents �l�ments, supprimer m�me un endroit bien pr�cis de la structure et tout �a est g�r� de mani�re dynamique au niveau de la m�moire. C'est tout l'int�r�t d'ailleurs de se servir de ses collections. 

Prise de note
==============

On va passer un petit peu � ce qui vous attend pour la suite, j'ai pr�par� de quoi prendre des notes en tout cas pour vous noter quelques petites choses par rapport � �a, mais on reviendra dessus. 
La premi�re chose � savoir ce sont les interface. 

En Java il y a �norm�ment d'interface qui sont rattach�s aux collections et je vais vous en pr�senter quelques-unes au travers d'un sch�ma pour faire tr�s simple et faire cette petite introduction Aux collections que nous allons voir en Java. 

On commence par ici avec ce petit sch�ma Qui vous pr�sente en tout cas rapidement 4 grandes familles de collection. 

+--------------------------+		+-----------+
|       Collection         |		|   Map     |
+------+-----------+-------+		+-----------+
| List |    Set    | Queue |		| SortedMap |
+------+-----------+-------+		+-----------+
       | SortedSet | Deque |
       +-----------+-------+

Alors toutes les interfaces ne sont pas repr�sent�s. Je vous invite d'ailleurs � aller voir sur la documentation de Java, vous trouverez comme �a tout le d�tail de chaque interface disponible et si d'ailleurs vous gal�rez un petit peu avec les documentations, j'ai fait une vid�o d'aide qui vous permet d'ailleurs de voir un petit peu la mani�re dont vous avez � consulter les documentations en ligne. 

A partir de l�, j'ai mis une interface ...Encore une fois je n'ai pas mis toutes les interfaces qui existent, j'ai mis surtout celles qui �taient le plus pertinentes pour vous faire cette introduction � savoir cette interface collection, d'accord, qui est vraiment une interface m�re Et qui va avoir diff�rentes interfaces, ici des sous interfaces de celle-ci. 

On retrouve une premi�re grande famille qui est l'interface des listes (List). Il y aura tout un tas de structures sous forme de liste et vous verrez que beaucoup beaucoup de classe peuvent impl�menter cette interface l�. 

On a ensuite l'interface de type Set ou �ventuellement Set qui sont ordonn�s (SortedSet).

On a Queue qui correspond au fil et ici on a Deque, �a c'est autre chose c'est pour les fils doublement cha�n�es. Nous ne rentrerons pas dans les d�tails pour le moment pour la 3e famille. 

Et une 4e famille, qui est ta part, qui n'appartient pas directement � collection, ici comme interface. On a une interface Map et notamment comme �a une autre interface qui est SortedMap qui est en fait une map ordonn�. 

On retrouve comme �a pas mal d'�l�ments. 

Dans la description de la vid�o vous retrouverez comme d'habitude, comme c'est souvent le cas sur d'autres vid�os, un lien vers mon github et vous avez comme �a la possibilit� de retrouver les diff�rents sch�mas pr�sent� en vid�o. Vous pouvez retrouver aussi pas mal d'informations aussi sur la mani�re que vous aurez de stocker vos informations, vos �l�ments, vos donn�es selon le type de structure, type de collection utilis� mais c'est des choses qu'on va voir au fur et � mesure dans les prochaines vid�os. 

L� c'est vraiment une vid�o d'introduction Et ensuite on va aborder pas mal de types de collections diff�rentes pour voir comment fonctionne ces diff�rentes collections-l�. 

� partir de ces interfaces on va pouvoir retrouver des classes qui vont les impl�menter. 

Encore une fois, les interfaces vous garantissent un certain nombre de m�thodes. Par contre on saura que pour collection, On va retrouver tout un tas de m�thodes qui sont garanties pour cette interface. �a peut �tre tout simplement, j'ai mis �a dans un fichier Java pour voir.

	/
		Quelques m�thodes de l'interface Collection

	/

	add()
	addAll()
	clear()
	contains()
	isEmpty()
	remove()
	size()


On va retrouver par exemple la m�thode add(element) qui permettra d'ajouter un �l�ment. Je ne vais pas mettre les valeurs de retour et cetera, le but ce n'est pas de vous �num�rer ce que l'on retrouve dans une documentation Mais simplement que vous puissiez voir quelques m�thodes. Je vais d'ailleurs ne pas mettre de param�tres. 
Vous avez add qui permet d'ajouter un �l�ment, Vous allez d'ailleurs voir que dans une collection vous allez pouvoir en ajouter une autre. Vous allez pouvoir ajouter une collection dans une autre collection addAll().
Vous allez pouvoir �ventuellement supprimer clear() Pour supprimer le contenu de votre collection. 
V�rifiez si votre collection contient des �l�ments en particulier contains().
Sachant que l'on peut ajouter des �l�ments ou vider une collection, On a de quoi v�rifier si elle poss�de des �l�ments ou pas isEmpty(). Donc si si elle est vide. Tr�s simplement. 
Et on va retrouver d'autres choses, oui si on a fait add(), on a aussi remove() pour supprimer des �l�ments. 
Vous verrez que selon le type de collection, Les comportements sont bien �videmment diff�rents, c'est aussi tout l'int�r�t de passer par une interface et ensuite on a par exemple des m�thodes comme size() pour avoir le nombre d'�l�ments de notre collection. 

Sa notre interface collection garantie encore une fois et c'est l� qu'il faut avoir compris le principe des interfaces et de tout ce que je vous expliquais pr�c�demment sur toutes ces notions d'interface, d'h�ritage, de polymorphisme et cetera. 
C'est � partir de cette interface l� (Collection), on garantit que toutes les classes qui vont l'impl�menter doivent forc�ment impl�menter ces m�thodes (add(), remove(), ...).
Vous savez d'avance que toutes les classes qui vont l'utiliser qui impl�mente �ventuellement cette interface collection ou une autre interface auront toutes ces m�thodes-la qui seront disponibles. 
�a �a va �tre tr�s pratique parce que en apprenant � utiliser une collection, �a va d�j� vous apprendre � utiliser plein d'autres collections parce que vous allez vraiment retrouver des m�thodes qui sont disponibles sur l'ensemble, la quasi-totalit� des corrections que vous allez utiliser en Java donc �a c'est vraiment tr�s tr�s pratique virgule il n'y aura pas besoin D'apprendre pour chaque Collection, toutes les m�thodes de chaque collection. 
Vous allez retrouver pas mal de choses qui sont similaires et qui sont m�me identiques de l'une � l'autre. 
� partir de l�, revenons sur le sch�ma.

Interfaces
==========
 
+--------------------------+		+-----------+
|       Collection         |		|   Map     |
+------+-----------+-------+		+-----------+
| List |    Set    | Queue |		| SortedMap |
+------+-----------+-------+		+-----------+
       | SortedSet | Deque |
       +-----------+-------+

Chaque sous interface ici (List, Set, Queue, Map) propose un contrat un peu plus sp�cialis� c'est-�-dire qu'elles poss�dent toutes les informations de l'interface collection Mais �galement des m�thodes qui sont peut-�tre un peu plus sp�cifiques on s'imagine bien qu'on ne va peut-�tre pas manipuler une file (Queue) comment on va manipuler une liste (List), on aura peut-�tre des choses qui vont diff�rer o� qui vont s'ajouter et ainsi de suite. 

Pareil pour les Map. 

� partir de l�, si j'ai par exemple une classe plus tard qui impl�mente cette interface liste (List) qui elle-m�me est une sous interface de collection, On sait que dans notre sous-classe de List on aura, nous aurons toutes ces informations l� (Collection + List). �a va nous permettre d'utiliser �norm�ment �norm�ment de m�thodes de manipulation de nos donn�es avec ses diff�rentes collections.

Puisque je vous parlais justement de classe pour manipuler directement nos collections, on va les retrouver ici (nouveau sch�ma) : 

Classes
=======

+-------------+--------------+
| Arraylist   | LinkedList   |
+--------+----+----+---------+
| Vector | HashSet | TreeSet |
+----^---+---------+---------+
| Stack  | HashMap | TreeMap |
+--------+---------+---------+

Voici parmi les classes pour manipuler directement nos colections, on les retrouve ici. On les retrouve ici, je vous en ai �num�r� quelques-unes. 

Est-ce qu'on va tous les aborder en vid�o ? Honn�tement au moment o� je fais cette vid�o je n'en sais rien. Je sais qu'on va en aborder pas mal. Au moins 4 ou 5 dans le tableau ci-dessus apr�s peut �tre qu'on les fera toutes je n'en sais rien. 

Mais en tout cas voil� � peu pr�s un ordre d'id�e. 

ArrayList, on reviendra de toute fa�on dessus. LinkedList, Vector, Stack et cetera. 

Le but, c'est de ne pas avoir des collections � taille fixe mais des collections beaucoup plus complexe et dynamique notamment pour se d�barrasser de "comment g�rer la m�moire ?" Ou bien on a un tableau qui fait tant, qui peut contenir tant d'�l�ments... on ne pourra pas aller au-del�. On pourrait pas aller au-del� virgule sinon on aurait tout simplement des exceptions qui serait provoqu�e. 

� partir d'ici on a des collections dynamiques donc c'est un moment au d�part on a 5 �l�ments de notre collection, si plus tard on se retrouve avec des �l�ments dans la collection, la taille de la capacit� de la collection en elle-m�me, du conteneur, va �voluer dynamiquement sans probl�me et tout sera g�r� au niveau de ces diff�rentes classes, nativement impl�ment�e dans Java, c'est l� encore Une fois tout l'int�r�t.

Donc on verra pas mal de chose, d'accord. On reviendra de toute fa�on en fonction des classes qui vont �tre abord�s sur chacune d'entre elles par exemple vous serez lesquels permettent d'avoir des donn�es, des informations qui sont ordonn�es. Celles qui permettent ou qui autorisent ou qui interdisent la pr�sence de doublons dans les diff�rentes structures. Est-ce qu'on a un fonctionnement par couple cl� valeur comme on a notamment dans les Maps, �a vous connaissez un petit peu pour certains. 

On a abord� �a quand on a parl� des cha�nes de caract�res, je vous ai beaucoup parl� de tout ce qui �tait acc�s concurrents ou non, vous savez ThreadSafe ou non, c'est � dire ce qui va �tre synchroniser il se fait Multi threading et ce sera forc�ment plus long � l'usage parce que �a fonctionne dans un environnement multi threading. Et ce qui est en mono thread sont des choses qui elles ne sont pas synchroniser et qui sont forc�ment plus rapides par rapport � �a. 

Rappelez-vous de StringBuilder, StringBuffer, je vous avais expliqu� la diff�rence entre ces 2 classes et dans quel cas il fallait utiliser l'une et dans quel cas il fallait utiliser l'autre. 

Mais l� c'est un petit peu pareil, pour ceux qui vous attendent pour la suite du cours en fonction des diff�rentes classes de collection Que nous verrons, je vous expliquerais dans quel cas on va plut�t utiliser ArrayList, dans quel cas on va plut�t utiliser Vector et cetera et cetera. 

Parce que vous allez voir qu'il y en a certaines qui sont un assez similaire et sur le coup on peut se demander pourquoi il en existe 3 diff�rentes, pour citer ces 3 l� : ArrayList, Vector et LinkedList. On peut v�ritablement y stocker la m�me chose, C'est v�ritablement en fonction de leur sp�cificit� qui va faire la diff�rence � l'usage afin de se dire que pour tel cas, je dois plut�t utiliser �a et dans tel ou tel autre qu je vais plut�t utiliser Vector parce que �a r�pond � des besoins bien pr�cis en fonction. 

Voil� pour cette introduction Et je pense que je ne vais pas faire plus long parce qu'on aura bien l'occasion de revenir dans le d�tail sur toutes les autres choses donc on a fait le tour. 
Il n'y avait pas grand chose � noter seulement quelques m�thodes par-ici.

Si vous voulez en savoir plus par avance vous pouvez toujours aller consulter de la documentation mais on verra dans le d�tail, �norm�ment de classe, comment on les utilise, on parlera notamment des it�rateurs parce que vous verrez que les it�rateurs c'est une notion qui va rentrer en jeu au niveau de c'est collections mais qui a vraiment son importance par rapport � �a.

Je ne pense pas que je ferais une vid�o it�rateurs � part, je pense que ce sera directement int�gr� quand on abordera la premi�re collection que nous verrons qui sera peut-�tre avec Vector ou ArrayList, une de ces 2 probablement.
Comme �a vous verrez ce qui vous attend un petit peu pour la suite. 

S'il y a des questions par rapport � �a m�me si c'est juste une vid�o d'introduction, n'h�sitez pas bien �videmment si vous voulez en savoir un peu plus par rapport � �a. 

Moi je vous retrouve prochainement pour une nouvelle s�ance en Java et � priori on commencera par ArrayList et Vector parce qu'il y a d�j� pas mal de choses � dire l� dessus et ces 2 classes en l'occurrence s'utilise dans des caves bien sp�cifique, bien pr�cis, parce qu'elles font globalement la m�me chose mais elles ne s'utilisent pas de la m�me mani�re ou en tout cas dans le m�me contexte.

Je vous dis � bient�t pour la suite de cette formation si y a des questions en commentaires n'h�sitez pas � les poser. 

� bient�t tout le monde  
*/
