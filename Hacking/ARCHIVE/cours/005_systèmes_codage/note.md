# [[ARCHIVE] Hacking #5 - systèmes codage](https://www.youtube.com/watch?v=Ant1vqXVVYM&list=PLrSOXFDHBtfG0Fb0g--43a0b47e9hrwlB&index=12)

## Différentes bases
```txt
    + Décimale (10) : de 0 à 9

    + Binaire (2)   : 0 et 1 (valeurs booléennes)
                      -> 0 1 10 11 100 101 111 1000 1001 1010 1011 1100 1110 1111
                      langage des machines

                      (!)   bit != byte = octet
                            1 octet = 8 bits

    + Octale (8)    : de 0 à 7
                      -> 0 1 2 3 4 5 6 7 10 11 12 13 14 15 16 17 20 21 22...
                      gestion des droits UNIX ou permissions des fichiers (rwx - 755, 644, 700, 777)
                      Read - Write - eXécution (rwx)
                      utilisateur - groupe - autres         //Un rwx pour chacun
                      111           101      101            //droits binaires
                      7             5        5              //droits octales

    + Héxadécimales (16)    : de 0 à F
                              -> 0 1 2 3 4 5 6 7 8 9 A B C D E F 10 11 12...
                              couleur (RGB -> A5D844)       //000000=Noir, FFFFFF=blanc, FF0000=rouge

    + Autres :  duodécimale (12 : années, fractions)
                sexagésimale (60 : heure)
```

Nb. On parlera de bit de poids fort, bit de poids faible au niveau du binaire, complément à deux, addition et soustraction dans les différentes bases, conversions...