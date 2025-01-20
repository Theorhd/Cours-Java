# Cours sur les Héritage et le Polymorphisme en Java

Bienvenue dans le huitième chapitre de notre cours Java dédié à l'héritage et au polymorphisme. Ces concepts fondamentaux de la programmation orientée objet (POO) permettent de créer des applications modulaires, extensibles et maintenables. 

## Table des Matières

1. [Introduction à l'Héritage](#1-introduction-à-lhéritage)
2. [Les Concepts de Base de l'Héritage](#2-les-concepts-de-base-de-lhéritage)
    - 2.1 [Classes et Sous-classes](#21-classes-et-sous-classes)
    - 2.2 [Mot-clé `extends`](#22-mot-clé-extends)
    - 2.3 [Constructeurs et Héritage](#23-constructeurs-et-héritage)
3. [Le Polymorphisme en Java](#3-le-polymorphisme-en-java)
    - 3.1 [Définition du Polymorphisme](#31-définition-du-polymorphisme)
    - 3.2 [Types de Polymorphisme](#32-types-de-polymorphisme)
        - 3.2.1 [Polymorphisme de Surcharge](#321-polymorphisme-de-surcharge)
        - 3.2.2 [Polymorphisme de Redéfinition](#322-polymorphisme-de-redéfinition)
4. [Le Mot-clé `super`](#4-le-mot-clé-super)
5. [Classes Abstraites et Interfaces](#5-classes-abstraites-et-interfaces)
6. [Exemples Pratiques](#6-exemples-pratiques)
7. [Bonnes Pratiques](#7-bonnes-pratiques)
8. [Exercices](#8-exercices)
9. [Conclusion](#9-conclusion)

---

## 1. Introduction à l'Héritage

L'héritage est un mécanisme fondamental de la POO qui permet de créer une nouvelle classe basée sur une classe existante. La classe existante est appelée **classe parente** ou **superclasse**, et la nouvelle classe est appelée **classe enfant** ou **sous-classe**. Grâce à l'héritage, la sous-classe hérite des attributs et des méthodes de la superclasse, favorisant ainsi la réutilisation du code et la création de hiérarchies de classes logiques.

## 2. Les Concepts de Base de l'Héritage

### 2.1 Classes et Sous-classes

Considérons un exemple simple :

```java
// Classe parente
public class Animal {
    public void manger() {
        System.out.println("Cet animal mange.");
    }
}

// Classe enfant
public class Chien extends Animal {
    public void aboyer() {
        System.out.println("Le chien aboie.");
    }
}
```

Dans cet exemple, `Chien` est une sous-classe de `Animal`. Elle hérite de la méthode `manger()` et dispose également de sa propre méthode `aboyer()`.

### 2.2 Mot-clé `extends`

Le mot-clé `extends` est utilisé pour indiquer qu'une classe hérite d'une autre. La syntaxe générale est la suivante :

```java
public class SousClasse extends SuperClasse {
    // Corps de la classe
}
```

### 2.3 Constructeurs et Héritage

Les constructeurs ne sont pas hérités, mais une sous-classe peut invoquer le constructeur de sa superclasse en utilisant le mot-clé `super`. Cela permet d'initialiser les attributs de la superclasse.

```java
public class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public void manger() {
        System.out.println(nom + " mange.");
    }
}

public class Chien extends Animal {
    private String race;

    public Chien(String nom, String race) {
        super(nom); // Appel au constructeur de la superclasse
        this.race = race;
    }

    public void aboyer() {
        System.out.println(race + " aboie.");
    }
}
```

## 3. Le Polymorphisme en Java

### 3.1 Définition du Polymorphisme

Le polymorphisme, du grec *poly* (plusieurs) et *morph* (formes), permet à une même référence d'objet de prendre différentes formes. En Java, cela signifie qu'une référence de type superclasse peut référencer des objets de n'importe quelle sous-classe.

### 3.2 Types de Polymorphisme

#### 3.2.1 Polymorphisme de Surcharge

La surcharge de méthode permet de définir plusieurs méthodes avec le même nom mais des paramètres différents au sein d'une même classe.

```java
public class Calculatrice {
    public int additionner(int a, int b) {
        return a + b;
    }

    public double additionner(double a, double b) {
        return a + b;
    }

    public int additionner(int a, int b, int c) {
        return a + b + c;
    }
}
```

#### 3.2.2 Polymorphisme de Redéfinition

La redéfinition (ou override) permet à une sous-classe de fournir une implémentation spécifique d'une méthode déjà définie dans sa superclasse.

```java
public class Animal {
    public void faireDuBruit() {
        System.out.println("Cet animal fait du bruit.");
    }
}

public class Chien extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

public class Chat extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chat miaule.");
    }
}
```

## 4. Le Mot-clé `super`

Le mot-clé `super` est utilisé pour référencer les membres (attributs ou méthodes) de la superclasse depuis la sous-classe. Cela est particulièrement utile lorsque les noms des membres des deux classes sont identiques ou lors de l'invocation du constructeur de la superclasse.

### Utilisation pour accéder aux membres de la superclasse

```java
public class Animal {
    protected String nom;

    public void afficherNom() {
        System.out.println("Nom de l'animal : " + nom);
    }
}

public class Chien extends Animal {
    public Chien(String nom) {
        super.nom = nom;
    }

    @Override
    public void afficherNom() {
        super.afficherNom(); // Appel de la méthode de la superclasse
        System.out.println("Ceci est un chien.");
    }
}
```

## 5. Classes Abstraites et Interfaces

### Classes Abstraites

Une classe abstraite est une classe qui ne peut pas être instanciée directement et peut contenir des méthodes abstraites (sans implémentation). Elle sert de base pour d'autres classes.

```java
public abstract class Forme {
    public abstract double calculerAire();

    public void afficherType() {
        System.out.println("Je suis une forme.");
    }
}

public class Cercle extends Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }
}
```

### Interfaces

Une interface définit un contrat que les classes doivent respecter, sans fournir d'implémentation (jamais avant Java 8). Depuis Java 8, les interfaces peuvent contenir des méthodes par défaut avec une implémentation.

```java
public interface Volant {
    void voler();
}

public class Oiseau implements Volant {
    @Override
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}
```

## 6. Exemples Pratiques

### Exemple 1 : Hiérarchie de Véhicules

```java
public class Vehicule {
    private String marque;

    public Vehicule(String marque) {
        this.marque = marque;
    }

    public void demarrer() {
        System.out.println(marque + " démarre.");
    }
}

public class Voiture extends Vehicule {
    private int nombrePortes;

    public Voiture(String marque, int nombrePortes) {
        super(marque);
        this.nombrePortes = nombrePortes;
    }

    public void klaxonner() {
        System.out.println("La voiture klaxonne.");
    }
}

public class Camion extends Vehicule {
    private double capaciteCharge;

    public Camion(String marque, double capaciteCharge) {
        super(marque);
        this.capaciteCharge = capaciteCharge;
    }

    public void charger() {
        System.out.println("Le camion charge " + capaciteCharge + " kg.");
    }
}
```

### Exemple 2 : Polymorphisme avec Méthodes Redéfinies

```java
public class Animal {
    public void seDeplacer() {
        System.out.println("L'animal se déplace.");
    }
}

public class Poisson extends Animal {
    @Override
    public void seDeplacer() {
        System.out.println("Le poisson nage.");
    }
}

public class Cheval extends Animal {
    @Override
    public void seDeplacer() {
        System.out.println("Le cheval galope.");
    }
}

public class TestPolymorphisme {
    public static void main(String[] args) {
        Animal monAnimal;

        monAnimal = new Poisson();
        monAnimal.seDeplacer(); // Affiche "Le poisson nage."

        monAnimal = new Cheval();
        monAnimal.seDeplacer(); // Affiche "Le cheval galope."
    }
}
```

## 7. Bonnes Pratiques

- **Utiliser l'héritage de manière judicieuse**: L'héritage doit représenter une relation "est-un", par exemple, un `Chien` est un `Animal`. Ne pas forcer l'héritage si la relation n'est pas pertinente.
  
- **Favoriser la composition sur l'héritage**: Plutôt que d'hériter pour réutiliser du code, considère utiliser la composition (posséder des instances d'autres classes).

- **Utiliser des classes et méthodes abstraites**: Pour définir des comportements communs tout en laissant la flexibilité aux sous-classes.

- **Respecter l'encapsulation**: Utiliser les modificateurs d'accès (`private`, `protected`, `public`) de manière appropriée pour protéger les données.

- **Documenter les classes et méthodes**: Facilite la maintenance et la compréhension du code.

## 8. Exercices

### Exercice 1 : Création d'une Hiérarchie de Formes

1. Créez une classe abstraite `Forme` avec une méthode abstraite `calculerAire()`.
2. Implémentez des sous-classes `Cercle`, `Rectangle` et `Triangle` qui héritent de `Forme` et fournissent une implémentation de `calculerAire()`.
3. Dans une classe `TestFormes`, créez des instances de chaque forme et affichez leur aire.

### Exercice 2 : Polymorphisme avec Animaux

1. Créez une classe `Animal` avec une méthode `faireDuBruit()`.
2. Créez des sous-classes `Chien`, `Chat` et `Vache` qui redéfinissent `faireDuBruit()`.
3. Dans une classe `TestAnimaux`, créez un tableau d'`Animal` contenant différentes instances et appelez `faireDuBruit()` sur chacune d'elles.

### Exercice 3 : Utilisation de `super`

1. Créez une classe `Employe` avec des attributs `nom` et `salaire`, ainsi qu'une méthode `afficherDetails()`.
2. Créez une sous-classe `Manager` qui ajoute un attribut `departement` et redéfinit la méthode `afficherDetails()` en appelant `super.afficherDetails()`.

## 9. Conclusion

L'héritage et le polymorphisme sont des piliers de la programmation orientée objet en Java. Ils permettent de créer des systèmes logiciels flexibles et extensibles en favorisant la réutilisation du code et en facilitant la maintenance. En comprenant et en maîtrisant ces concepts, vous êtes mieux équipé pour concevoir des applications robustes et évolutives.

N'oubliez pas de pratiquer régulièrement ces concepts à travers des exercices et des projets concrets pour renforcer votre compréhension et votre expertise en Java.

---