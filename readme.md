Descripció de com funciona el servei.

En primer lloc tenim 3 essencials que són Alumne, Institut i Operació, que podríem dir que són models de dades.
Després tenim tot un conjunt de classes i interfícies (MathMaganaer i ReversePolishNotation + Implementacions) que s'encarreguen de la gestió de les dades i el processat de les demandes del client.
La classe ServeiREST proporciona gràcies a les llibreries 'jersey' i 'jackson'funcions que són invocades a través d'HTTP, on es reben demandes i es retornen en format JSON.

Potser és interessant explicar com funciona dins el programa la relació entre Operacions, Alumnes i Instituts:
    Una instància d'Alumne tindrà carregat en una variable d'instància tant les Operacions que ha fet com l'Institut en el que està.
    A més, un Institut també tindrà una llista d'Operacions que alumnes d'aquest centre han sol·licitat.
La funció on es rep la sol·licitud d'operació és  MathManagerImpl-->realitzarOperacio(Operacio op, Alumne p) i és aquesta operació en concret on s'avalua de quin Institut és l'alumne i es busca a la llista d'Instituts.
Si es troba l'Institut, se li afegeix 1 al comptador d'operacions (per més tard poder ordenar); si no es troba, s'afageix un nou Institut a la llista amb el comptador iniciat a 1.


*A la funció de buscar operacions fetes segons un Institut no entenc què passa que el programa peta a la línia 61. He provat canvis però compliquen com es relacionen els atributs de cada Model.
