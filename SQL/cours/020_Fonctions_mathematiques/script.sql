/*
SQL #20 - fonctions math�matiques
06-01-21

Bonjour � tous, on se retrouve pour cette 20�me s�ance en sql o� nous allons voir ensemble quelques fonctions math�matiques ou fonctions num�riques qui vont permettre d'effectuer quelques op�rations au niveau de vos bases de donn�es.

Petites parenth�ses si vous travaillez avec SQLite, vous verrez qu'il y a tr�s tr�s peu de fonctions qui sont disponibles pour ce sgbd donc c'est souvent l� des fonctions � faire soi m�me ou de passer carr�ment par un langage de programmation pour pouvoir effectuer certains traitements sp�cifiques.

Comme d'habitude je vous montre un petit peu ce qu'il en est, je vous ai mis dans la description de la vid�o parce que c'est ce que j'ai fait pour chaque s�ance sur les fonctions une page ici.
	https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-mathematiques.md

Donc un lien vers cette page qui vous redirigera vers les diff�rentes fonctions math�matiques que vous propose ici avec chaque sgbd �a c'est un petit rappel sur chaque page avec toutes les diff�rentes fonctions pr�sent� de la m�me mani�re avec ce pour les cha�nes de caract�res, ce qu'on a vu avec les fonctions d'agr�gation et autres sont disponibles comme �a.

Vous avez comme �a le nom de la fonction, la description, �ventuellement un usage, �a je ne l'avais pas mis d'ailleurs dans les anciennes s�ances si vous avez d�j� regard� les autres pages des anciennes s�ance vous n'aviez pas les usages donc c'est quelque chose que je rajoute et que je rajouterais au fur et � mesure pour les autres fichiers que vous ayez tout sous la main.

Par exemple si vous regardez vite fait au niveau mysql on a beaucoup de fonctions disponibles, au niveau d'oracle, on en a un petit peu moins mais on en a quand m�me pas mal. postgressql est bien fourni en aussi en fonctions, sql server �galement donc chez microsoft et on voit que chez SQLite on a tr�s peu finalement de fonction comme �a disponibles alors on en a �ventuellement d'autres parce que j'ai pas tout il n'y a pas toutes les fonctions qui sont list�es sur ce document et donc j'ai mis les plus usuels, celles qui me semblait plus int�ressante donc en tout cas les plus importantes. Vous pourrez toujours en trouver encore d'autres mais on va voir un peu tout �a ensemble justement comment qu'est ce qui peut �tre int�ressant � voir.

Alors la fonction qui est disponible partout c'est tout ce qui est calcul de valeur absolue alors je vais me connecter par contre ici et je vais vous montrer directement comme �a � usage.

	serveur
	-------
	> mysqld --console
	
	client
	------
	> mysql -u root -p

Je ne l'ai pas forc�ment dit mais c'est bien de le rappeler si jamais vous ne savez pas pour oracle, si vous travaillez sur oracle par exemple vous avez certaines fonctions que vous ne pouvez pas utiliser quand vous faites un select avec l'usage d'une fonction. Vous ne pouvez pas juste faire un select et l'appel � une fonction sans sp�cifier par exemple un nom de tables d'accord il n'est pas possible de faire juste select et la fonction qu'on va avoir par exemple la fonction absolue de -1 d'accord c'est � dire la valeur absolue du nombre -1.

	SELECT ABS(-1)

On ne peut pas faire seulement �a en Oracle, on sera toujours oblig�s de sp�cifier une table sur laquelle �a provient.

Pour cela d'ailleurs sur Oracle il existe donc une table qui est  p�cialement fait pour ce genre de traitement d'accord si on veut faire une petite requ�te de cette sorte, il suffit simplement de mettre dual comme ceci.
*/
SELECT ABS(-1) FROM dual;
/*
dual, il suffit simplement d'utiliser cette petite table. C'est une table qui est vide en fait, qui a enregistrement une colonne qui est fait sp�cialement pour �a comme on a une requ�te de type select n�cessite obligatoirement ce genre de partie au niveau de la requ�te (from dual), petit rappel en tout cas en petit chose que je voulais dire pour ceux qui travaillerait actuellement sur oracle database. 

Pour les autres vous pourrez tout simplement mettre un select comme �a il n'y aura pas de probl�me donc on va faire �a genre on va voir tr�s rapidement ce que �a fait.
*/
SELECT ABS(-1);
/*
	mysql> SELECT ABS(-1);
	+---------+
	| ABS(-1) |
	+---------+
	|       1 |
	+---------+
	1 row in set (0.00 sec)

Donc l�, il faut en avoir l'utilit� d'accord par rapport � des math�matiques alors la valeur absolue d'un nombre c'est pour obtenir sa valeur positive.

Un nombre arithm�tique donc si on met un nombre n�gatif on obtient l'inverse c'est � dire le signe inverse au lieu d'avoir quelque chose de n�gatif on a une valeur positive.

Si vous faites bien s�r valeur absolue de -5, vous obtenez le nombre 5 donc �a c'est des math�matiques, on est vraiment pour le coup dans des math�matiques donc �a logiquement elles est disponible un peu partout m�me SQLite dispose de cette fonction-l�.

Voil� c'est la m�me un peu partout.

L'avantage aussi c'est pour tout ce qui est valeur, tout ce qui est fonction math�matique, num�rique, on a quand m�me des noms qui sont assez similaires d'un sgbd � l'autre.

Il n'y a pas trop de diff�rence exceptionnellement l� contrairement � d'autres cat�gories de fonction on a des fois des noms qui diff�re assez souvent donc l� c'est plut�t pas mal.

On va retrouver �galement toutes les fonctions trigonom�triques donc quelles fonctions pour calculer des cosinus, des sinus, des tangentes ou les arcs, arc tangente, arc cosinus etc etc donc �a peut �tre tr�s utile et vous savez certainement si vous faites un petit peu de trigonom�trie alors ces fonctions l� grosso modo c'est cos() et vous mettez une valeur en fait � l'int�rieur et vous faites un select, un select cosinus.

	SELECT COS()

et vous pouvez �ventuellement passer d'ailleurs pas des valeurs de pi parce qu'on travaille beaucoup en trigonom�trie avec pi et pour cela vous avez d'ailleurs une fonction.

	PI()

En l'occurrence tout ce que je montre ici est pour mysql encore une fois vous vous adapter si vous voulez utiliser un autre sgbd et vous avez tout ici disponible sous les yeux.
	https://github.com/jasonchampagne/FormationVideo/blob/master/Ressources/SQL/fonctions-mathematiques.md

Et vous allez retrouver de toute fa�on certaines choses par exemple pour mysql, on a donc la fonction PI() d'accord qui permet de r�cup�rer sa valeur et vous verrez qu'on la retrouve pour d'autres outils donc on ne l'a pas forc�ment pour oracle �a veut �ventuellement dire qu'il faut faire vos propres fonctions.

Pour postgressql, on retrouve �galement cette fonction PI() disponible avec le m�me nom donc c'est quand m�me tr�s tr�s tr�s simple de s'y retrouver.

Alors ce qu'on peut faire par exemple simplement, on peut tr�s bien encha�ner les fonctions �a c'est comme dans la programmation.
*/
SELECT COS(PI());
/*
On peut bien s�r dans un appel de fonction en param�tre pass� autre chose par exemple de faire �a et l� �a fait cosinus de pi ce qui donne -1.

	mysql> SELECT COS(PI());
	+-----------+
	| COS(PI()) |
	+-----------+
	|        -1 |
	+-----------+
	1 row in set (0.01 sec)

Si vous faites de la trigonom�trie, vous avez besoin de travailler avec justement des fonctions pour de la trigonom�trie vous pouvez utiliser ces derni�re l�.

Alors on a COS(), SIN(), TAN() et vous avez apr�s les versions en arc ACOS(), ASIN(), ATAN() en rajoutant simplement un A.
*/
COS(), SIN(), TAN(), ACOS(), ASIN(), ATAN()
SELECT COS(PI());
/*
Pareil toutes ces fonctions trigonom�triques ne sont pas forc�ment disponibles en fonction du sgbd que vous utilisez.

Si vous �tes sur mysql, il n'y aura pas de probl�me, si vous �tes ailleurs pensez � bien v�rifier dans les tableaux que je vous met toujours � disposition, voir si c'est disponible et bien s�r � d�faut regardez �galement dans les documentations officiel du syst�me de gestion que vous vous servez pour avoir un maximum d'informations de ce c�t�.

Alors je vais tr�s vite l� dessus parce que tout ce qui est trigonom�trie et cetera, je vais revenir sur des points un peu plus utile pour le coup.

Alors je n'ai pas montr� �a comme �a mais c'est bien �ventuellement que vous ayez quand m�me un petit aper�u pour cette fonction l�, voyez PI pour montrer en fait le nombre de d�cimales d'accord.
*/
SELECT PI();
/*
mysql> SELECT PI();
+----------+
| PI()     |
+----------+
| 3.141593 |
+----------+
1 row in set (0.00 sec)

On affiche 6 d�cimales, on peut �ventuellement en rajouter d'autres.

Si je ne mets pas b�tise, je pense qu'on passe par un op�rateur. On doit pouvoir faire par exemple 2 4 6 8 z�ros (+ 0.00000000) je crois qu'en faisant comme �a, on doit pouvoir lui sp�cifier.
*/
SELECT PI() + 0.00000000;
/*
	mysql> SELECT PI() + 0.00000000;
	+-------------------+
	| PI() + 0.00000000 |
	+-------------------+
	|        3.14159265 |
	+-------------------+
	1 row in set (0.00 sec)

Voyez vous pouvez sp�cifier en mettant z�ro point et un certain nombre de d�cimales, certain nombre de z�ro comme d�cimales pour sp�cifier le nombre de d�cimales pour mysql donc �a ce sont de petites op�rations assez simple qu'on peut faire quand on veut par exemple changer la pr�cision qu'on obtient pour la valeur de pi qui est comme vous le savez infini, on n'a pas de valeur de fin en fait de pi.

Quelque chose a conna�tre aussi qui peut servir encore une fois dans les math�matiques, en trigonom�trie et dans d'autres op�rations de ce genre.

Autre point qui peut �tre utile �galement quand on travaille en trigonom�trie, c'est par exemple la conversion des degr� en radiant d'accord vous pouvez par exemple avoir un angle en degr� et on peut �galement travailler avec des radiants c'est une autre valeur, unit� num�rique et �a peut �tre utile de pouvoir faire des conversions de l'une � l'autre.

Pour �a on a tout simplement la fonction RADIANS() pareil pas forc�ment disponibles partout ce sera � vous de voir par exemple un angle de 60 degr�s d'accord alors combien �a me donne en fait en radiant ?
*/
SELECT RADIANS(60);
/*
	mysql> SELECT RADIANS(60);
	+--------------------+
	| RADIANS(60)        |
	+--------------------+
	| 1.0471975511965976 |
	+--------------------+
	1 row in set (0.00 sec)

Voyez l� �a vous donne une valeur ici et vous allez avoir une inverse alors si je met par exemple comme ceci, vous allez obtenir l'inverse.
*/
SELECT DEGREES(1.0471975511965976);
/*
mysql> SELECT DEGREES(1.0471975511965976);
+-----------------------------+
| DEGREES(1.0471975511965976) |
+-----------------------------+
|           59.99999999999999 |
+-----------------------------+
1 row in set (0.00 sec)

D'ailleurs est-ce que je les ai mis sur Github parce que je vais regarder quand m�me si j'avais bien sp�cifi� �a ? oui qui et elles ne sont pas forc�ment partout voy� par exemple pour Oracle on n'a pas. On va l'avoir pour postgressql par contre, on a bien les deux oui c'est bon. On a quelques fonctions bien pratiques pour pouvoir effectuer comme �a des conversions donc �a c'est des choses qui sont ma foi tr�s utile.

On a aussi un autre point donc l� on quitte un petit peu le c�t� trigonom�trie mais �a �a va �tre tr�s tr�s utile notamment pour pouvoir faire par exemple des calculs d'arrondis si vous faites par exemple si vous avez un nombre je ne sais pas moi vous avez un arrondi sur pi d'ailleurs on pourrait �ventuellement s'en servir mais on verra.

Vous pouvez par exemple faire ceci donc CEIL() qui est un alias de CEILING() en mysql et vous allez faire 14.26334 admettons.
*/
SELECT CEIL(14.26334);
/*
	mysql> SELECT CEIL(14.26334);
	+----------------+
	| CEIL(14.26334) |
	+----------------+
	|             15 |
	+----------------+
	1 row in set (0.00 sec)

L� il vous fait vous voyez un arrondi au dessus d'accord l'entier au dessus c'est 15.

Si vous voulez l'inverse pour avoir un arrondi en fait � la base donc � l'unit�, l'entier inf�rieur, vous allez utiliser FLOOR().
*/
SELECT FLOOR(14.26334);
/*
	mysql> SELECT FLOOR(14.26334);
	+-----------------+
	| FLOOR(14.26334) |
	+-----------------+
	|              14 |
	+-----------------+
	1 row in set (0.00 sec)

Voil� vous utilisez �� et l� vous aurez l'entier inf�rieur donc on va obtenir 14 d'accord si c'est 14 point virgule quelque chose c'est FLOOR() donc on aura 14.

On peut �galement obtenir un arrondi avec ROUND() alors ROUND() fonctionne de deux mani�res selon le sgbd aussi soit vous passez directement le nombre en param�tres et �a va vous tronqu� en fait en r�alit� �a vous vous faire un arrondi en prenant simplement la valeur enti�re.
*/
SELECT ROUND(14.26334);
/*
	mysql> SELECT ROUND(14.26334);
	+-----------------+
	| ROUND(14.26334) |
	+-----------------+
	|              14 |
	+-----------------+
	1 row in set (0.00 sec)

Et vous pouvez �galement choisir le nombre de d�cimales � laquele vous voulez arrondir par exemple si je veux arrondir � 3 d�cimales, je peux faire comme ceci, un deuxi�me argument � ma fonction.
*/
SELECT ROUND(14.26334, 3);
/*
	mysql> SELECT ROUND(14.26334, 3);
	+--------------------+
	| ROUND(14.26334, 3) |
	+--------------------+
	|             14.263 |
	+--------------------+
	1 row in set (0.00 sec)

Et on aura bien ces 3 d�cimales l�, �a c'est des r�visions de math�matique, je ne vous apprends rien, j'apprend rien de nouveau par rapport � �a.

Si on veut en fait arrondir � 3 d�cimales, si la d�cimale suivante est en dessous eh bien on garde le nombre le plus proche.
*/
SELECT ROUND(14.26364, 3);
/*
	mysql> SELECT ROUND(14.26364, 3);
	+--------------------+
	| ROUND(14.26364, 3) |
	+--------------------+
	|             14.264 |
	+--------------------+
	1 row in set (0.00 sec)
 
Automatiquement, on a un arrondi qui est autre puisque le nombre en 4e quatri�me d�cimale d�passe 5, c'est 5 ou sup�rieur.

Voil� un petit arrondi assez utile � utiliser, � servir en tout cas et on peut aussi utiliser TRUNCATE() qui va faire une troncation en l'occurrence le m�me fonctionnement ici donc on ne fait pas d'arrondi ici, elle va simplement tronquer d'accord.
*/
SELECT TRUNCATE(14.26364, 3);
/*
	mysql> SELECT TRUNCATE(14.26364, 3);
	+-----------------------+
	| TRUNCATE(14.26364, 3) |
	+-----------------------+
	|                14.263 |
	+-----------------------+
	1 row in set (0.00 sec)

Ici �videmment il faut directement le deuxi�me param�tre, vous choisissez le nombre de d�cimales que vous voulez d'accord pour faire le pour faire la troncature et on a pas d'arrondi qui est effectu� donc on coupe simplement dans les d�cimales qu'on ne veut pas.
*/
SELECT TRUNCATE(14.26364, 2);
/*
	mysql> SELECT TRUNCATE(14.26364, 2);
	+-----------------------+
	| TRUNCATE(14.26364, 2) |
	+-----------------------+
	|                 14.26 |
	+-----------------------+
	1 row in set (0.00 sec)

Donc pas d'arrondi en dessous ou au dessus, on tronque simplement.

Quelques petites fonctions comme �a qui sont mine de rien tr�s utile.

Voyez donc il y a quand m�me pas mal � faire au niveau des valeurs absolues, de tout ce qui est trigonom�trie, de tout ce qui est arrondi, on a quand m�me pas mal de fonctions dans ce genre qui peuvent �tre utile.

Autre point qu'est ce que je peux vous montrer aussi et je vais aller assez vite de toute fa�on l� on est vraiment sur les derni�res s�ances du cours c'est tout simplement vous montrer quelques usages de fonction dont vous avez pas grand chose � apprendre � part savoir que telle fonction existe et que voir comment elle fonctionne, honn�tement c'est pas �a qui sera le plus compliqu� � apprendre de tout ce que vous avez pu voir en sql.

Vous avez d�j� vu toutes les notions les plus compliqu�s � apprendre, l� on finit vraiment cette formation avec des choses tr�s simples � voir.

On va garder le select, on peut faire le calcul de puissance alors attention selon les versions vous avez pas POW() ou POWER() pour MySQL, vous avez les deux puisque pareil il y a un alias.
*/
SELECT POW(2, 3);
/*
Voil� simplement un calcul de puissance d'accord 2 � la puissance 3 par exemple donc �a va faire 2x2x2 je rappelle donc 8 donc on a bien ce genre de r�sultat. 
	mysql> SELECT POW(2, 3);
	+-----------+
	| POW(2, 3) |
	+-----------+
	|         8 |
	+-----------+
	1 row in set (0.00 sec)

Pareil je ne sais pas s'ils y en avait d'autres qui avaient des param�tres diff�rents et normalement non, c'est g�n�ralement power un peu partout voil� c'est power et il n'y a que MySQL qui propose pow �galement comme alias.

Enfin c'est power qui est alias de pow enfin peu importe �a ne change pas grand chose.

Vous avez comme �a diff�rentes valeurs.

Qu'est ce que je peux vous montrer �galement ? 

Alors �a c'est propre � mysql donc je vous montre rapidement parce que vous serez encore en majorit� � utiliser MySQL, pour faire de la conversion de base donc l� pareil, on ne va pas r�viser des bases mais en gros vous avez la base 10 donc les nombres, les chiffres de 0 � 9.

Vous avez la base binaire donc c'est le 0 1.

Vous avez la base octal qui va de 0 � 7 et vous avez la base h�xad�cimales qui va de 0 � f.

On a diff�rentes valeurs pour ces diff�rentes bases, il peut exister des bases de tout, on peut avoir une base 25, une basse 30 voil� toutes les bases existent en soi parce que c'est en fait un syst�me num�rique parce qu'on passe en fait � la dizaine de cette base l�.

Au niveau de ces bases, il va peut �tre int�ressant de faire des conversions par exemple on peut se dire de convertir en l'occurrence donc la fonction ici CONV() d'accord on va pouvoir convertir un nombre d'une base � une autre donc on va faire tout simplement.
*/
SELECT CONV(145, 10, 2);
/*
Convertir le nombre 145 par exemple de la base 10 donc �a c'est la base d�cimale qu'on utilise tr�s tr�s tr�s souvent en math�matiques, un peu partout, vers par exemple une base binaire qui est compos� seulement de 0 et de 1.

	mysql> SELECT CONV(145, 10, 2);
	+------------------+
	| CONV(145, 10, 2) |
	+------------------+
	| 10010001         |
	+------------------+
	1 row in set (0.01 sec)

Ca c'est bien pratique pour �a que je vous en parle parce que c'est quand m�me assez rare qu'on trouve des langages de programmation ou des syst�mes de gestion de bases de donn�es avec des fonctions permettant d'effectuer des converse des conversions de base, c'est pas toujours le cas donc c'est plut�t bien de savoir que �a existe et qu'on a ce genre de choses, qu'on obtient une valeur et si vous faisiez l'inverse 10010001 de la base 2 � la base 10, vous tomberez sur la valeur 145 en d�cimale.
*/
SELECT CONV(10010001, 2, 10);
/*

	mysql> SELECT CONV(10010001, 2, 10);
	+-----------------------+
	| CONV(10010001, 2, 10) |
	+-----------------------+
	| 145                   |
	+-----------------------+
	1 row in set (0.00 sec)

Petite fonction qui est tr�s pratique qui n'est pas disponible pour les autres sgbd tr�s important donc si vous travaillez sur autre chose, vous ne pourrez pas vous servir de ce genre de fonction donc attention par rapport � �a.

On passe � d'autres choses math�matiques donc les deux calculs math�matiques, les deux choses � conna�tre que vous apprenez g�n�ralement d'ailleurs au lyc�e pour la plupart qui sont l'exponentielle et le logarithme donc pareil tr�s rapidement, exponentielle c'est la fonction EXP() o� vous passer la valeur que vous voulez, l'exponentielle par exemple de 2.
*/
SELECT EXP(2);
/*
	mysql> SELECT EXP(2);
	+------------------+
	| EXP(2)           |
	+------------------+
	| 7.38905609893065 |
	+------------------+
	1 row in set (0.00 sec)

D'accord on a la valeur ici et vous avez l'inverse alors l� je vais montrer notamment le logarithme n�p�rien donc c'est LN() ici en l'occurrence donc la pareil attention au niveau des nommages des fonctions parce que vous verrez que selon les sgbd vous n'avez pas les m�mes.

Ici je vous les montre rapidement sur le tableau parce que je ne vais pas vous les montrer 1 par 1 au niveau du client mysql mais vous avez en gros pour mysql exceptionnellement ici vous avez donc le logarithme n�p�rien qui s'�crit LOG().

Attention pour d'autres sgbd quand vous utiliser LOG() (Oracle Database) en fait c'est un logarithme en base d'accord vous choisissez en fait la base, logarithme en base 10, logarithme en base 2 et cetera. Et le LN() est exclusivement r�serv� au logarithme naturel, au logarithme n�p�rien donc il faut faire attention � �a.

	Oracle Database
	---------------
	Logarithme n�p�rien	LN(n)
	Logarithme en base	LOG(base, n)

Egalement parce qu'on a ici LOG() qui est le logarithme n�p�rien et LN() qui est un alias d'accord donc le comportement ne serra pas forc�ment le m�me et pour mysql il dispose de 2 fonctions qui permet de travailler directement en base 2 ou en base 10.

	MySQL
	-----
	Alias de log()			LN(n)
	Logarithme n�p�rien		LOG(n)
							LOG(n, base)
	Logarithme en base 2	LOG2(n)
	Logarithme en base 10	LOG10(n)

C'est LOG() qu'on va utiliser en fait si on veut travailler dans une autre base que le 2 et 10, on peut utiliser LOG(n, base) et voyez qu'on peut passer la base en deuxi�me argument donc attention j'insiste bien l� dessus et ne pas vous faire avoir en fait selon le sgbd que vous utilisez parce que vous n'aurez pas forc�ment les m�mes noms de fonction ici donc il faut faire gaffe � �a.

Ok donc �a c'est bon donc LOG() encore une fois c'est ce que je vous avez dit, vous passer le nombre que vous voulez et la base que vous voulez par exemple en base 10 et l� vous avez du coup le logarithme de 2 en base 10.
*/
SELECT LOG(2, 10);
/*
	mysql> SELECT LOG(2, 10);
	+--------------------+
	| LOG(2, 10)         |
	+--------------------+
	| 3.3219280948873626 |
	+--------------------+
	1 row in set (0.00 sec)

Je pense que c'est assez clair par rapport � �a.

On a �galement les calculs de racines c'est quelque chose qu'on retrouve beaucoup en maths avec SQRT() g�n�ralement c'est tr�s souvent ce nom-l� que ce soit pour les fonctions dans un sgbd ou des fonctions dans un langage de programmation, vous pouvez par exemple choisir racine carr�e de 4 et nous avons ceci.
*/
SELECT SQRT(4);
/*
	mysql> SELECT SQRT(4);
	+---------+
	| SQRT(4) |
	+---------+
	|       2 |
	+---------+
	1 row in set (0.00 sec)

Dans d'autres sgbd, postgressql propose la racine cubique CBRT(), voil� vous mettez simplement CBRT().
*/
SELECT CBRT(4);
/*
Forc�ment vous n'avez jamais peut-�tre �tudier la racine cubique donc on peut travailler avec ce type de calcul mais l� de toute fa�on �a ne marchera pas.

	mysql> SELECT CBRT(4);
	ERROR 1046 (3D000): No database selected

D'autant l� il me dit No database selected et toute mani�re �a ne fonctionne pas sur mysql c'est pour postgressql.

Voil� donc attention encore une fois tout n'est pas forc�ment dispo partout.

Au niveau calcul, on n'est pas trop sur un langage de programmation ici mais vous avez le calcul de modulo pour ceux qui ne seraient pas ce que c'est si vous n'avez pas �tudi� des formations en langage de programmation, on � l'addition, on � la soustraction, la multiplication, la division qu'on pr�sente en programmation respectivement par ces caract�res l� d'accord.

	-- Fonction : math�matiques et num�riques
	
	+ - * / %

On en a un cinqui�me qui est le modulo repr�sent� par un %.

Le modulo l� vous allez donc avoir la division / qui va vous donner le reste d'une division au client d'accord.

Ca c'est int�ressant par exemple si vous faites 5 % 2 et le reste en fait de cette division c'est 1 parce qu'on fait 2 fois 2 �gal 4 et il reste 1 pour arriver � 5 d'accord c'est le reste en fait qu'on a entier de la division euclidi�ne.

	-- Fonction : math�matiques et num�riques
	
	+ - * / %
	
	5 % 2 = 1

Pour beaucoup de sgbd quand vous voulez calculer le modulo vous avez possibilit� d'utiliser cet op�rateur pour effectuer ce calcul.

En mysql et dans d'autres sgbd, vous avez aussi une fonction qui est simplement la fonction MOD() et vous choisissez ce que voulait faire donc 5 et 2 en deuxi�me argument. Je vais vous montrer parce que c'est quand m�me fait pour �a.
*/
SElECT MOD(5, 2);
/*
	mysql> SElECT MOD(5, 2);
	+-----------+
	| MOD(5, 2) |
	+-----------+
	|         1 |
	+-----------+
	1 row in set (0.01 sec)

Et on obtient bien le reste la division qui est de 1 d'accord.

On peut aussi simplement faire quand comme je vous ai dit 5 % 2 avec peut-�tre un select sinon il ne le prendra pas en compte.
*/
SELECT 5 % 2;
/*
	mysql> select 5 % 2;
	+-------+
	| 5 % 2 |
	+-------+
	|     1 |
	+-------+
	1 row in set (0.00 sec)

Voil� et on obtient la m�me chose d'accord, on passe par un op�rateur et il propose lui aussi un alias.

Des fois vous avez en mysql des noms de fonction qui ne sont pas en fait des insructions c�d que vous n'avez pas d'appel de fonction mais c'est juste un mot qui est g�n�ralement le m�me nom que la fonction et qui fait la m�me op�ration.

Vous mettez 5 MOD 2, voyez qu'il n'y a pas de parenth�ses ou quoi que ce soit, voyez on ne fait pas un appel � une fonction et l� logiquement �a devrait donner la m�me chose voil�.
*/
SELECT 5 MOD 2;
/*
	mysql> SELECT 5 MOD 2;
	+---------+
	| 5 MOD 2 |
	+---------+
	|       1 |
	+---------+
	1 row in set (0.00 sec)

On a trois syntaxes diff�rentes en mysql pour calculer un modulo, dans d'autres sgbd, vous n'avez pas ces trois l�, vous avez g�n�ralement celui l� "%", l'op�rateur fonctionne normalement sur tous je crois et vous avez une fonction comme �a MOD() qui prend la premi�re valeur � passer et la deuxi�me et qui fera donc la division de ces deux l� et vous donnera le reste de la division euclidienne.

Quelque chose � conna�tre aussi et � savoir voil� � conna�tre par rapport � toutes ces informations ici.

Alors je passe tr�s vite, on a aussi des fonctions par exemple pour r�cup�rer le signe d'un nombre si c'est + ou - donc si vous mettez 0 �a vous renverra 0, si c'est un nombre n�gatif �a vous renverra -1 et si c'est un nombre positif �a vous renverra la valeur de 1. 

Des choses pareil tr�s tr�s simple.

Et je voulais terminer avec tout ce qui al�atoire mais est-ce que je ne voulais pas vous montrer autre chose avant ? Normalement non a vu la trigonom�trie, les arrondis, les calculs racine carr� cubique, les logarithme, exponentielle, on a fait le tour de tout donc je vais pour terminer vous montrer surtout en fin de vid�o.

Donc concernant mysql encore une fois il faudra voir parce que ce n'est pas disponible pour tous, vous avez notamment ce genre de fonction RAND() comme je l'ai indiqu� ici �a va vous donner la valeur al�atoire � virgule flottante d'un nombre d'accords.

C'est une simple fonction � utiliser telle quelle.

On va montrer tout simplement en faisant comme ceci.
*/
SELECT RAND();
/*
Et vous allez obtenir un nombre entre 0 et 1 donc m�me entre 0.0 et 1.0 pour �tre plus exact.

	mysql> SELECT RAND();
	+--------------------+
	| RAND()             |
	+--------------------+
	| 0.8866642135071235 |
	+--------------------+
	1 row in set (0.00 sec)

voil� et si je refais �a, voyez que �a change.

	mysql> SELECT RAND();
	+-----------------------+
	| RAND()                |
	+-----------------------+
	| 0.0026330631250823505 |
	+-----------------------+
	1 row in set (0.00 sec)

On peut �ventuellement sp�cifier une graine pour la g�n�ration de ce nombre al�atoire et pareil voil�.
*/
SELECT RAND(15);
/*
	mysql> SELECT RAND(15);
	+--------------------+
	| RAND(15)           |
	+--------------------+
	| 0.9079670691005579 |
	+--------------------+
	1 row in set (0.00 sec)

Et l� comme on a la m�me graine, voyez qu'on garde le m�me nombre.

Il faut faire un cours sur tout ce qui est nombre pseudo al�atoire etc et je l'ai expliqu� dans pas mal d'autres formations de toute mani�re donc vous l'apprendrez � un moment ou un autre si vous l'�tudiez sur d'autres formations.

Dans tous les cas on peut obtenir comme �a des nombres al�atoires.

Petite distinction ici comme je peux vous le montrer ici au niveau ex�cution que je vais vous montrer depuis le document l�.

Vous avez par exemple ici un arrondi, un nombre entier voil� qui
va �tre donn� avec la fonction RANDOM() pour SQLite d'accord c'est un nom qui sera positif au n�gatif donc attention le comportement produits par la fonction ne sera pas le m�me.

Attention un petit peu avec les valeurs al�atoire alors c'est pareil petite information m�me si ce sont des fonctions pour g�n�rer un nombre al�atoire vous pouvez �galement vous en servir dans le cadre d'une requ�te, par exemple vous voulez effectu� une requ�te pour s�lectionner des enregistrements et apr�s vous pouvez �tablir un ordre enfin faut avoir un int�r�t pour le faire mais vous pourriez par exemple vouloir un ordre al�atoire d'affichage ou de r�cup�ration de vos r�sultats de requ�tes. Vous pouvez utiliser cette fonction pour le faire.

H� bien vous faites un ORDER BY avec votre fonction RAND() comme �a alors l'ordre sera compl�tement al�atoire.

Ca peut �ventuellement, si on peut trouver une utilit� � ce genre d'usage, imaginez par exemple une galerie d'image que vous avez par exemple sur votre site web donc l� en passant par un langage de programmation orient� web vous faites une requ�te depuis ce langage sql et dans votre requ�te, dans votre clause partie ORDER BY vous utilisez votre fonction RAND() et comme �a si si vous avez des liens enregistr� en base de donn�es pour afficher des images d'une galerie seront r�cup�r�s al�atoirement �a permettra d'afficher une galerie de mani�re en fait al�atoire au niveau de l'ordre d'affichage des images sur votre page web.

Voil� �a peut �tre un usage comme un autre donc �a c'est � vous de voir �videmment � l'usage et par rapport � ce que vous ferez sur vos projets.

Cette petite parenth�se �tant faite je crois qu'on a fait le tour de ce que je voulais vous montrer donc encore une fois rien de compliqu� vous voyez c'est simplement des fonctions il faut les conna�tre un minimum en tout cas les plus importants.

Apr�s de toute fa�on avec les documentations et avec ce que je vous mets � chaque fois dans les descriptions de vid�o vous avez besoin de vous rappeler de certaines d'entre elles, vous aurez toutes les informations � disposition.

Encore une fois je rappelle parce que c'est important n'h�sitez pas � prendre des notes.

Ca il faut bien y penser prendre des notes sur un cahier, sur un classeur, dans un fichier sur votre ordinateur. Vraiment pas h�siter � avoir tout comme �a de c�t� et moi souvent j'en profite pour faire un petit rappel si vous voulez savoir un petit peu comment vous organiser parce que j'ai des fois des gens qui me demande. Moi je vous conseille c'est de faire un support papier voil� je vous recommanderais plut�t le format papier parce qu'on retient et on assimile plus facilement les choses quand on �crit de sa propre main en fait que depuis un cahier �tonnamment donc pr�f�r� �a et gardez vous en faites un grand cahier, un classeur o� on peut facilement du coup mettre des pochettes n'importe quoi pour pouvoir mettre votre cours en fait, vos notes de cours c�d que tout est bien mis au propre avec toutes les explications maximum que vous voulez mettre bien d�taill�s et apr�s n'h�sitez pas � avoir des brouillons ou d'autres cahiers pour gribouiller, pour faire des sch�mas.

Par exemple vous n'avez pas compris quelque chose, si vous �tes sur sql et vous n'avez pas compris les jointures et bien vous n'avez pas not� toutes vos recherches on va dire l� dessus sur votre cahier ou votre classeur de cours d'accord vos notes de cours mais vous allez le faire sur un brouillon, sur un truc � c�t� pour pouvoir faire tout un tas de sch�mas, pour essayer de bien assimiler tout �a.

Une fois que vous avez compris pour bien que �a rentre justement dans votre t�te et pour que �a reste eh bien vous pourrez le noter dans votre classeur.

Voil� en fait partez du principe que vous alliez finalement enseigner � quelqu'un d'autre aussi et vous verrez comme �a que vous retiendrez bien plus bien plus facilement les choses parce que vous serez oblig�s de les expliquer en fait, d'expliquer ce que vous avez appris et vous saurez tr�s tr�s vite si vous avez compris, si vous avez acquis finalement ces choses l� parce que si vous n'�tes pas capables de l'enseigner, de l'expliquer c'est que finalement vous n'avez pas bien compris comment �a fonctionnait.

Donc n'h�sitez pas � essayer ces petites astuces l� qui permettront de bien assimiler, de bien apprendre et surtout pouvoir garder ces connaissances et cetera et pas tout oublier � chaque fois ou se m�langer un peu les pinceaux en fonction de ce que vous apprenez.

Voil� je vous dis � bient�t en tout cas pour la prochaine vid�o ce sera la derni�re s�ance avant la conclusion d'accords on verra tout ce qui est li� � la s�curit� au niveau de nos bases de donn�es et on en aura termin� avec cette formation.

Je ferais une petite vid�o de conclusion comme je fais � chaque fin de formation sur la cha�ne et vous aurez fait grandement le tours de pas mal de choses en sql.

Je vous dis � bient�t pour la prochaine s�ance sur les fonctions de chiffrement.

A bient�t tout le monde.
*/
