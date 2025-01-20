# Cours sur les bases de Java

Bienvenue dans ce cours dédié aux bases de Java ! Java est un langage de programmation orienté objet, réputé pour sa portabilité, sa robustesse et sa large communauté. L’objectif de ce tutoriel est de vous apprendre les fondamentaux de Java afin de bien démarrer dans ce langage.

## Sommaire

1. [Installation et configuration](#installation-et-configuration)
2. [Gérer les variables d’environnement pour choisir une version précise de Java](#gerer-les-variables-denvironnement-pour-choisir-une-version-précise-de-java)
3. [Structure d’un programme Java](#structure-dun-programme-java)  
4. [Les variables et types de données](#les-variables-et-types-de-données)  
5. [Opérateurs](#opérateurs)  
6. [Chaînes de caractères en Java](#chaînes-de-caractères-en-java)  
7. [Structure conditionnelle](#structure-conditionnelle)  
8. [Boucles](#boucles)  
9. [Tableaux](#tableaux)  
10. [Les classes et la programmation orientée objet (POO)](#les-classes-et-la-programmation-orientée-objet-poo)  
11. [Méthodes](#méthodes)  
12. [Conclusion](#conclusion)  



## Installation et configuration

### Pré-requis
- Installer le [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://openjdk.java.net/install/).  
- Un éditeur de texte ou un IDE (Eclipse, IntelliJ IDEA, NetBeans, VS Code avec le plugin Java, etc.).

Pour vérifier l’installation, ouvrez votre terminal (ou l’invite de commandes sous Windows) et tapez :

```bash
java -version
javac -version
```

- `java` correspond à la machine virtuelle Java (JVM).  
- `javac` est le compilateur Java.  

Si ces commandes ne sont pas reconnues, vérifiez votre installation et que le `PATH` est correctement configuré.

---
## Gérer les variables d’environnement pour choisir une version précise de Java

Il arrive fréquemment d’utiliser plusieurs versions de Java sur une même machine. Pour spécifier la version à employer, vous pouvez configurer les variables d’environnement : notamment `JAVA_HOME`, qui indique l’emplacement du **Java Development Kit (JDK)**, et le `PATH` pour la ligne de commande.

### Sur Windows

1. **Télécharger/Installer** les différentes versions de JDK (Oracle ou OpenJDK).  
2. **Ouvrir** le panneau de configuration :  
   - Panneau de configuration → Système → Paramètres système avancés → Variables d’environnement.  
3. **Créer/Éditer** la variable d’environnement `JAVA_HOME` :  
   - La valeur doit être le chemin d’installation du JDK souhaité (par ex. `C:\Program Files\Java\jdk-17`).  
4. **Modifier** la variable `PATH` :  
   - Ajouter `;%JAVA_HOME%\bin` dans la liste de chemins pour que la console utilise la bonne version.  

Après ces étapes, pour **vérifier la configuration** :

```bash
java -version
javac -version
```

### Sur Linux / macOS

1. **Installer** les versions de Java (via un package manager ou un téléchargement manuel).  
2. **Editer** votre fichier de configuration (exemples : `~/.bashrc`, `~/.zshrc`, `~/.bash_profile`, etc.).  
3. **Définir** la variable `JAVA_HOME` :  

   ```bash
   export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
   export PATH=$JAVA_HOME/bin:$PATH
   ```

4. **Enregistrer** puis **recharger** la configuration (exemple : `source ~/.bashrc`).  

Vous pouvez à présent tester :

```bash
java -version
javac -version
```

Selon le chemin `JAVA_HOME` et l’ordre des chemins dans votre `PATH`, la version de Java renvoyée sera celle que vous avez spécifiée.

## Structure d’un programme Java

Un programme Java basique est composé de classes. Chaque fichier source (dont l’extension est `.java`) contient généralement une classe publique qui porte le même nom que le fichier.

**Exemple** :

```java
public class HelloWorld {
    // Méthode principale (point d’entrée d’un programme Java)
    public static void main(String[] args) {
        System.out.println("Bonjour, monde !");
    }
}
```

- `public class HelloWorld` : on déclare une classe publique nommée `HelloWorld`.  
- `public static void main(String[] args)`: la méthode `main` est le point d’entrée. La JVM exécutera ce code au lancement du programme.  
- `System.out.println(...)` : permet d’afficher un message suivi d’un saut de ligne.  

Pour **compiler** : 
```bash
javac HelloWorld.java
```
Cela génère un fichier `HelloWorld.class`.

Pour **exécuter** :
```bash
java HelloWorld
```

---

## Les variables et types de données

### Les types primitifs
Java possède 8 types primitifs :

- `byte` (1 octet)  
- `short` (2 octets)  
- `int` (4 octets)  
- `long` (8 octets)  
- `float` (4 octets, nombre à virgule flottante)  
- `double` (8 octets, nombre à virgule flottante)  
- `boolean` (valeur `true` ou `false`)  
- `char` (caractère Unicode, 2 octets)

**Exemple :**

```java
int monEntier = 42;
double monReel = 3.14;
boolean estVrai = true;
char lettre = 'A';
```

### Les types non primitifs
Les types non primitifs en Java sont des **objets** ou des **tableaux** :  
- Classes (ex: `String`)  
- Tableaux (`int[]`, `String[]`, etc.)  
- Interfaces  

### Déclaration et initialisation de variables

```java
int x;           // Déclaration
x = 10;          // Initialisation

int y = 20;      // Déclaration + initialisation
```

---

## Opérateurs

Les opérateurs en Java peuvent être classés ainsi :

1. **Opérateurs arithmétiques**  
   - `+` (addition), `-` (soustraction), `*` (multiplication), `/` (division), `%` (modulo)  
   - `++` (incrément), `--` (décrément)  

2. **Opérateurs de comparaison**  
   - `==` (égalité), `!=` (différent)  
   - `>` (supérieur), `<` (inférieur), `>=` (supérieur ou égal), `<=` (inférieur ou égal)  

3. **Opérateurs logiques**  
   - `&&` (ET logique), `||` (OU logique), `!` (NON logique)  

4. **Opérateurs d’affectation**  
   - `=`, `+=`, `-=`, `*=`, `/=`, `%=`, etc.  

**Exemple** :

```java
int a = 10, b = 5;
int somme = a + b;        // 15
boolean resultat = (a > b) && (somme == 15); // true
```

---

## Chaînes de caractères en Java

En Java, les chaînes de caractères sont des objets de type `String` et elles sont **immuables** (leur contenu ne peut pas être modifié après leur création).

**Exemple** :

```java
String s1 = "Bonjour";
String s2 = "Monde";
String s3 = s1 + " " + s2; // "Bonjour Monde"
```

### Méthodes utiles de String
- `length()` : retourne la longueur de la chaîne  
- `charAt(int index)` : retourne le caractère à l’indice indiqué  
- `substring(int beginIndex, int endIndex)` : extrait une sous-chaîne  
- `toLowerCase()` / `toUpperCase()` : renvoie la chaîne en minuscule/majuscule  
- `trim()` : supprime les espaces au début et à la fin  

---

## Structure conditionnelle

### if / else

```java
int age = 20;
if (age >= 18) {
    System.out.println("Majeur");
} else {
    System.out.println("Mineur");
}
```

### if / else if / else

```java
int note = 15;
if (note >= 16) {
    System.out.println("Très bien");
} else if (note >= 12) {
    System.out.println("Assez bien");
} else {
    System.out.println("Peut mieux faire");
}
```

### switch

```java
int jour = 3;
switch(jour) {
    case 1:
        System.out.println("Lundi");
        break;
    case 2:
        System.out.println("Mardi");
        break;
    case 3:
        System.out.println("Mercredi");
        break;
    default:
        System.out.println("Jour inconnu");
}
```

---

## Boucles

### for

```java
for (int i = 0; i < 5; i++) {
    System.out.println("i = " + i);
}
```

### while

```java
int x = 0;
while (x < 5) {
    System.out.println("x = " + x);
    x++;
}
```

### do…while

```java
int y = 0;
do {
    System.out.println("y = " + y);
    y++;
} while (y < 5);
```

---

## Tableaux

Les tableaux (arrays) sont de taille fixe et contiennent des éléments de même type.

### Déclaration et initialisation

```java
int[] tab1 = new int[5];        // déclaration d’un tableau de 5 entiers
int[] tab2 = {1, 2, 3, 4, 5};   // initialisation "littérale"
```

### Parcours d’un tableau

```java
for (int i = 0; i < tab2.length; i++) {
    System.out.println(tab2[i]);
}

// Boucle for-each
for (int element : tab2) {
    System.out.println(element);
}
```

---

## Les classes et la programmation orientée objet (POO)

En Java, tout tourne autour des classes et objets :

### Classes et objets

Une classe définit un plan (ou _blueprint_) pour créer des objets. Elle peut contenir :  
- Des **champs** (ou attributs)  
- Des **méthodes**  
- Des **constructeurs**  

```java
public class Personne {
    // Champs (attributs)
    String nom;
    int age;

    // Constructeur : même nom que la classe
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Méthode
    public void sePresenter() {
        System.out.println("Je m'appelle " + nom + " et j'ai " + age + " ans.");
    }
}
```

Pour créer un objet `Personne` :

```java
Personne p1 = new Personne("Alice", 30);
p1.sePresenter(); // "Je m'appelle Alice et j'ai 30 ans."
```

---

## Méthodes

Une méthode en Java a la structure suivante :

```java
public class Calculatrice {

    // Méthode statique
    public static int addition(int a, int b) {
        return a + b;
    }

    // Méthode d'instance
    public int multiplication(int a, int b) {
        return a * b;
    }
}
```

- **Visibilité** : `public`, `private`, etc.  
- **Type de retour** : `int`, `void`, etc.  
- **Nom de la méthode** : exemple `addition`  
- **Paramètres** : `(int a, int b)`

**Exemple d’appel** :

```java
public class Main {
    public static void main(String[] args) {
        // Appel de la méthode statique
        int somme = Calculatrice.addition(3, 5);
        System.out.println(somme); // 8

        // Appel de la méthode d'instance
        Calculatrice calc = new Calculatrice();
        int produit = calc.multiplication(4, 6);
        System.out.println(produit); // 24
    }
}
```

---

## Conclusion

Vous venez de découvrir les bases du langage Java :  
- Installation et configuration  
- Structure d’un programme  
- Variables et types de données primitifs  
- Opérateurs  
- Chaînes de caractères  
- Structures conditionnelles et boucles  
- Tableaux  
- Programmation orientée objet basique (classes, objets, méthodes)

Ces notions constituent un socle essentiel pour progresser. Pour aller plus loin, vous pouvez vous intéresser à :

- L’héritage, le polymorphisme et les interfaces en POO  
- Les classes internes  
- La gestion des exceptions (`try`, `catch`, `finally`)  
- Les collections (`List`, `Set`, `Map`)  
- Les lambdas et la programmation fonctionnelle en Java  
- Les principes d’architecture (Maven, Gradle, Spring, etc.)

---
### Bonne pratique de Java !
---