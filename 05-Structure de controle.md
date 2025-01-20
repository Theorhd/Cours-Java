# Cours sur les Structures de Contrôle en Java

Bienvenue dans le cinquième cours de notre série sur l'apprentissage de Java. Aujourd'hui, nous allons explorer les **structures de contrôle** en Java, qui permettent de diriger le flux d'exécution de vos programmes. Vous apprendrez à utiliser les instructions conditionnelles (`if`, `switch`) et les boucles (`for`, `while`, `do-while`, etc.), ainsi que d'autres structures de contrôle essentielles telles que `break` et `continue`.

---

## Table des Matières

1. [Introduction aux Structures de Contrôle](#introduction-aux-structures-de-contrôle)
2. [Structures Conditionnelles](#structures-conditionnelles)
    - [Instruction `if`](#instruction-if)
    - [Instruction `if-else`](#instruction-if-else)
    - [Instruction `else-if`](#instruction-elseif)
    - [Instruction `switch`](#instruction-switch)
3. [Boucles en Java](#boucles-en-java)
    - [Boucle `for`](#boucle-for)
    - [Boucle `while`](#boucle-while)
    - [Boucle `do-while`](#boucle-do-while)
    - [Boucle `for-each`](#boucle-for-each)
4. [Autres Structures de Contrôle](#autres-structures-de-contrôle)
    - [`break`](#break)
    - [`continue`](#continue)
    - [`return`](#return)
5. [Exemples et Cas Pratiques](#exemples-et-cas-pratiques)
6. [Bonnes Pratiques](#bonnes-pratiques)
7. [Exercices Pratiques](#exercices-pratiques)
8. [Conclusion et Ressources Complémentaires](#conclusion-et-ressources-complémentaires)

---

## Introduction aux Structures de Contrôle

Les **structures de contrôle** déterminent l'ordre dans lequel les instructions d'un programme Java sont exécutées. Elles permettent de gérer les décisions et de répéter des actions, rendant ainsi votre code dynamique et interactif. Les principales structures de contrôle en Java se divisent en deux catégories :

1. **Structures conditionnelles** : Permettent de prendre des décisions en fonction de conditions spécifiques.
2. **Boucles** : Facilitent la répétition d'un bloc de code tant qu'une condition est vraie.

Maîtriser ces structures est essentiel pour écrire des programmes efficaces et maintenables.

---

## Structures Conditionnelles

Les **structures conditionnelles** permettent d'exécuter des blocs de code spécifiques en fonction de conditions données. En Java, les principales structures conditionnelles sont `if`, `if-else`, `else-if` et `switch`.

### Instruction `if`

L'instruction `if` est utilisée pour exécuter un bloc de code si une condition spécifique est vraie.

#### Syntaxe

```java
if (condition) {
    // Bloc de code à exécuter si la condition est vraie
}
```

#### Exemple

```java
int score = 85;

if (score >= 50) {
    System.out.println("Vous avez réussi !");
}
```

#### Sortie

```
Vous avez réussi !
```

### Instruction `if-else`

L'instruction `if-else` permet d'exécuter un bloc de code si la condition est vraie, et un autre bloc si elle est fausse.

#### Syntaxe

```java
if (condition) {
    // Bloc de code si la condition est vraie
} else {
    // Bloc de code si la condition est fausse
}
```

#### Exemple

```java
int age = 16;

if (age >= 18) {
    System.out.println("Vous êtes majeur.");
} else {
    System.out.println("Vous êtes mineur.");
}
```

#### Sortie

```
Vous êtes mineur.
```

### Instruction `else-if`

L'instruction `else-if` permet de vérifier plusieurs conditions séquentiellement.

#### Syntaxe

```java
if (condition1) {
    // Bloc de code si condition1 est vraie
} else if (condition2) {
    // Bloc de code si condition2 est vraie
} else {
    // Bloc de code si aucune condition n'est vraie
}
```

#### Exemple

```java
int note = 75;

if (note >= 90) {
    System.out.println("Mention : A");
} else if (note >= 75) {
    System.out.println("Mention : B");
} else if (note >= 60) {
    System.out.println("Mention : C");
} else {
    System.out.println("Mention : D");
}
```

#### Sortie

```
Mention : B
```

### Instruction `switch`

L'instruction `switch` permet de sélectionner l'un des nombreux blocs de code à exécuter en fonction de la valeur d'une expression.

#### Syntaxe

```java
switch (expression) {
    case valeur1:
        // Bloc de code si expression == valeur1
        break;
    case valeur2:
        // Bloc de code si expression == valeur2
        break;
    // ...
    default:
        // Bloc de code si aucune case ne correspond
}
```

#### Exemple

```java
int jour = 3;
String nomJour;

switch (jour) {
    case 1:
        nomJour = "Lundi";
        break;
    case 2:
        nomJour = "Mardi";
        break;
    case 3:
        nomJour = "Mercredi";
        break;
    case 4:
        nomJour = "Jeudi";
        break;
    case 5:
        nomJour = "Vendredi";
        break;
    case 6:
        nomJour = "Samedi";
        break;
    case 7:
        nomJour = "Dimanche";
        break;
    default:
        nomJour = "Jour invalide";
}

System.out.println("Le jour " + jour + " est " + nomJour + ".");
```

#### Sortie

```
Le jour 3 est Mercredi.
```

---

## Boucles en Java

Les **boucles** permettent de répéter un bloc de code tant qu'une condition spécifiée est vraie. Java propose plusieurs types de boucles : `for`, `while`, `do-while` et `for-each`.

### Boucle `for`

La boucle `for` est souvent utilisée lorsque le nombre d'itérations est connu à l'avance.

#### Syntaxe

```java
for (initialisation; condition; incrément/decrément) {
    // Bloc de code à répéter
}
```

#### Exemple

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Compteur : " + i);
}
```

#### Sortie

```
Compteur : 1
Compteur : 2
Compteur : 3
Compteur : 4
Compteur : 5
```

### Boucle `while`

La boucle `while` répète un bloc de code tant qu'une condition est vraie. Elle est utilisée lorsque le nombre d'itérations n'est pas connu à l'avance.

#### Syntaxe

```java
while (condition) {
    // Bloc de code à répéter
}
```

#### Exemple

```java
int i = 1;

while (i <= 5) {
    System.out.println("Compteur : " + i);
    i++;
}
```

#### Sortie

```
Compteur : 1
Compteur : 2
Compteur : 3
Compteur : 4
Compteur : 5
```

### Boucle `do-while`

La boucle `do-while` est similaire à la boucle `while`, mais elle garantit que le bloc de code est exécuté au moins une fois, même si la condition est fausse.

#### Syntaxe

```java
do {
    // Bloc de code à répéter
} while (condition);
```

#### Exemple

```java
int i = 6;

do {
    System.out.println("Compteur : " + i);
    i++;
} while (i <= 5);
```

#### Sortie

```
Compteur : 6
```

### Boucle `for-each`

La boucle `for-each` est utilisée pour itérer facilement sur des collections telles que des tableaux ou des listes.

#### Syntaxe

```java
for (type élément : collection) {
    // Bloc de code à répéter
}
```

#### Exemple

```java
String[] fruits = {"Pomme", "Banane", "Orange"};

for (String fruit : fruits) {
    System.out.println("Fruit : " + fruit);
}
```

#### Sortie

```
Fruit : Pomme
Fruit : Banane
Fruit : Orange
```

---

## Autres Structures de Contrôle

### `break`

L'instruction `break` permet de sortir immédiatement d'une boucle ou d'un `switch`, interrompant ainsi son exécution.

#### Exemple avec une boucle `for`

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        break; // Sort de la boucle lorsque i vaut 3
    }
    System.out.println("Compteur : " + i);
}
```

#### Sortie

```
Compteur : 1
Compteur : 2
```

### `continue`

L'instruction `continue` saute l'itération en cours et passe à la suivante dans une boucle.

#### Exemple avec une boucle `for`

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue; // Saute l'affichage lorsque i vaut 3
    }
    System.out.println("Compteur : " + i);
}
```

#### Sortie

```
Compteur : 1
Compteur : 2
Compteur : 4
Compteur : 5
```

### `return`

L'instruction `return` termine l'exécution d'une méthode et retourne une valeur (si spécifié) au point où la méthode a été appelée.

#### Exemple

```java
public class Calculatrice {
    public int addition(int a, int b) {
        return a + b; // Retourne la somme de a et b
    }
}
```

---

## Exemples et Cas Pratiques

### Exemple 1 : Classification des Températures

Écrivez un programme qui demande à l'utilisateur de saisir la température actuelle et qui affiche une classification basée sur la température (ex : froid, doux, chaud).

#### Exemple de Code

```java
import java.util.Scanner;

public class ClassificationTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la température (en degrés Celsius) : ");
        double temperature = scanner.nextDouble();

        if (temperature < 0) {
            System.out.println("Il fait très froid !");
        } else if (temperature >= 0 && temperature < 15) {
            System.out.println("Il fait froid.");
        } else if (temperature >= 15 && temperature < 25) {
            System.out.println("Il fait doux.");
        } else {
            System.out.println("Il fait chaud !");
        }
    }
}
```

#### Sortie (Exemple)

```
Entrez la température (en degrés Celsius) : 20
Il fait doux.
```

### Exemple 2 : Boucle Infini avec `while`

Créez un programme qui affiche les nombres de 1 à 10 en utilisant une boucle `while`.

#### Exemple de Code

```java
public class BoucleWhile {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 10) {
            System.out.println("Nombre : " + i);
            i++;
        }
    }
}
```

#### Sortie

```
Nombre : 1
Nombre : 2
Nombre : 3
Nombre : 4
Nombre : 5
Nombre : 6
Nombre : 7
Nombre : 8
Nombre : 9
Nombre : 10
```

### Exemple 3 : Utilisation de `switch` pour les Jours de la Semaine

Écrivez un programme qui demande à l'utilisateur de saisir un numéro de jour (1-7) et affiche le nom correspondant du jour.

#### Exemple de Code

```java
import java.util.Scanner;

public class JoursSemaine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un numéro de jour (1-7) : ");
        int numero = scanner.nextInt();
        String nomJour;

        switch (numero) {
            case 1:
                nomJour = "Lundi";
                break;
            case 2:
                nomJour = "Mardi";
                break;
            case 3:
                nomJour = "Mercredi";
                break;
            case 4:
                nomJour = "Jeudi";
                break;
            case 5:
                nomJour = "Vendredi";
                break;
            case 6:
                nomJour = "Samedi";
                break;
            case 7:
                nomJour = "Dimanche";
                break;
            default:
                nomJour = "Numéro de jour invalide";
        }

        System.out.println("Le jour " + numero + " est " + nomJour + ".");
    }
}
```

#### Sortie (Exemple)

```
Entrez un numéro de jour (1-7) : 5
Le jour 5 est Vendredi.
```

---

## Bonnes Pratiques

1. **Clarté et Lisibilité** : Utilisez des indentations appropriées et des noms de variables explicites pour rendre le code plus compréhensible.
   
   ```java
   // Mauvaise pratique
   if(x>0){
   System.out.println("Positif");
   }else{
   System.out.println("Négatif ou nul");
   }
   
   // Bonne pratique
   if (x > 0) {
       System.out.println("Positif");
   } else {
       System.out.println("Négatif ou nul");
   }
   ```

2. **Éviter les Boucles Infini** : Assurez-vous que les conditions de sortie des boucles sont correctement définies pour éviter que le programme ne se bloque.
   
   ```java
   // Boucle infinie si 'i' n'est jamais incrémenté
   while (i < 10) {
       System.out.println(i);
   }
   ```

3. **Utilisation judicieuse de `break` et `continue`** : Utilisez `break` pour sortir des boucles ou des `switch` lorsque nécessaire, et `continue` pour sauter certaines itérations.

4. **Limiter l'Imbrication** : Évitez d'imbriquer trop de structures conditionnelles ou de boucles, ce qui peut compliquer la lecture et la maintenance du code.

5. **Commentaires Pertinents** : Commentez le code pour expliquer les parties complexes ou les décisions de conception, mais évitez les commentaires évidents.

6. **Utilisation de `switch` pour les Valeurs Discrètes** : Préférez `switch` lorsque vous avez plusieurs cases basées sur des valeurs discrètes plutôt que de multiples `if-else`.

7. **Préférer les Boucles Appropriées** : Utilisez le type de boucle qui correspond le mieux à votre besoin. Par exemple, utilisez `for-each` pour itérer sur des collections lorsque vous n'avez pas besoin de l'index.

---

## Exercices Pratiques

### Exercice 1 : Calculateur de Remise

Créez un programme qui demande à l'utilisateur de saisir le montant d'un achat et la catégorie du produit (1: Électronique, 2: Vêtements, 3: Alimentaire). Appliquez une remise en fonction de la catégorie :
- Électronique : 10%
- Vêtements : 20%
- Alimentaire : 5%

Affichez le montant final après remise.

#### Exemple de Code

```java
import java.util.Scanner;

public class CalculateurRemise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le montant de l'achat : ");
        double montant = scanner.nextDouble();

        System.out.print("Entrez la catégorie du produit (1: Électronique, 2: Vêtements, 3: Alimentaire) : ");
        int categorie = scanner.nextInt();
        double remise = 0;

        switch (categorie) {
            case 1:
                remise = 0.10;
                break;
            case 2:
                remise = 0.20;
                break;
            case 3:
                remise = 0.05;
                break;
            default:
                System.out.println("Catégorie invalide.");
                System.exit(0);
        }

        double montantFinal = montant - (montant * remise);
        System.out.println("Montant après remise : " + montantFinal + " €");
    }
}
```

#### Sortie (Exemple)

```
Entrez le montant de l'achat : 200
Entrez la catégorie du produit (1: Électronique, 2: Vêtements, 3: Alimentaire) : 2
Montant après remise : 160.0 €
```

### Exercice 2 : Somme des Nombres Pairs

Écrivez un programme qui calcule la somme de tous les nombres pairs entre 1 et 100 en utilisant une boucle `for`.

#### Exemple de Code

```java
public class SommePairs {
    public static void main(String[] args) {
        int somme = 0;

        for (int i = 2; i <= 100; i += 2) {
            somme += i;
        }

        System.out.println("La somme des nombres pairs entre 1 et 100 est : " + somme);
    }
}
```

#### Sortie

```
La somme des nombres pairs entre 1 et 100 est : 2550
```

### Exercice 3 : Validation d'Identifiants

Créez un programme qui demande à l'utilisateur de saisir un identifiant candidat. Le programme doit vérifier si l'identifiant correspond à l'un des identifiants valides (par exemple : "admin", "user", "guest") en utilisant une instruction `switch`.

#### Exemple de Code

```java
import java.util.Scanner;

public class ValidationIdentifiant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre identifiant : ");
        String identifiant = scanner.nextLine();

        switch (identifiant) {
            case "admin":
                System.out.println("Bienvenue, administrateur !");
                break;
            case "user":
                System.out.println("Bienvenue, utilisateur !");
                break;
            case "guest":
                System.out.println("Bienvenue, invité !");
                break;
            default:
                System.out.println("Identifiant invalide.");
        }
    }
}
```

#### Sortie (Exemple)

```
Entrez votre identifiant : user
Bienvenue, utilisateur !
```

---

## Conclusion et Ressources Complémentaires

Vous avez maintenant une compréhension approfondie des structures de contrôle en Java, essentielles pour la création de programmes dynamiques et réactifs. Ces structures vous permettent de prendre des décisions, de répéter des actions et de gérer le flux d'exécution de manière efficace.

### Ressources Recommandées

- **Livres** :
    - *Effective Java* par Joshua Bloch
    - *Java: The Complete Reference* par Herbert Schildt
- **Sites Web** :
    - [Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html)
    - [W3Schools Java Tutorial](https://www.w3schools.com/java/)
    - [GeeksforGeeks Java](https://www.geeksforgeeks.org/java/)
- **Cours en Ligne** :
    - [Codecademy - Learn Java](https://www.codecademy.com/learn/learn-java)
    - [Coursera - Java Programming and Software Engineering Fundamentals](https://www.coursera.org/specializations/java-programming)
    - [edX - Introduction to Java Programming](https://www.edx.org/course/introduction-to-java-programming-2)

### Conseils pour Continuer

1. **Pratiquez Régulièrement** : La maîtrise des structures de contrôle vient avec la pratique. Essayez de résoudre différents problèmes en utilisant les structures apprises.
2. **Résolvez des Problèmes Complexes** : Utilisez des plateformes comme [LeetCode](https://leetcode.com/), [HackerRank](https://www.hackerrank.com/domains/java) ou [Codewars](https://www.codewars.com/) pour appliquer vos connaissances à des problèmes variés.
3. **Lire du Code Source** : Analysez le code d'autres développeurs pour voir comment ils utilisent les structures de contrôle dans des projets réels.
4. **Participer à des Projets Open Source** : Contribuez à des projets open source pour acquérir une expérience pratique et collaborer avec d'autres développeurs.
5. **Rejoindre des Communautés** : Participez à des forums, des groupes de discussion ou des meetups pour échanger des idées et obtenir de l'aide lorsque nécessaire.

Continuez à explorer et à pratiquer, et vous développerez rapidement vos compétences en programmation Java. Bon apprentissage !