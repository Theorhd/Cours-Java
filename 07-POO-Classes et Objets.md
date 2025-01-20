# Cours sur les Classes et Objets en Java

Bienvenue dans le septième cours de notre série dédiée à l’apprentissage de Java. Aujourd’hui, nous allons plonger dans les **classes** et les **objets**, les piliers de la **Programmation Orientée Objet (POO)**. Comprendre ces concepts est essentiel pour structurer vos programmes de manière efficace, modulaire et réutilisable. Vous apprendrez à définir des classes, créer des objets, et utiliser les principes fondamentaux de la POO en Java.

---

## Table des Matières

1. [Introduction à la Programmation Orientée Objet (POO)](#introduction-à-la-programmation-orientée-objet-poo)
2. [Définition d'une Classe](#définition-dune-classe)
    - [Structure d'une Classe](#structure-dune-classe)
    - [Attributs et Méthodes](#attributs-et-méthodes)
3. [Création d'Objets](#création-dobjets)
    - [Instanciation d'une Classe](#instanciation-dune-classe)
    - [Accès aux Attributs et Méthodes](#accès-aux-attributs-et-méthodes)
4. [Constructeurs](#constructeurs)
    - [Définition et Utilisation](#définition-et-utilisation)
    - [Constructeurs par Défaut et Surchargés](#constructeurs-par-défaut-et-surchargés)
5. [Encapsulation](#encapsulation)
    - [Principe de l'Encapsulation](#principe-de-lencapsulation)
    - [Getters et Setters](#getters-et-setters)
6. [Le Mot-clé `this`](#le-mot-clé-this)
7. [Méthodes Statiques vs Méthodes d'Instance](#méthodes-statiques-vs-méthodes-dinstance)
8. [Modificateurs d'Accès](#modificateurs-daccès)
    - [Public, Private, Protected et Default](#public-private-protected-et-default)
9. [Concepts Avancés Introduits](#concepts-avancés-introduits)
    - [Héritage](#héritage)
    - [Polymorphisme](#polymorphisme)
    - [Abstraction](#abstraction)
10. [Bonnes Pratiques](#bonnes-pratiques)
11. [Exercices Pratiques](#exercices-pratiques)
12. [Conclusion et Ressources Complémentaires](#conclusion-et-ressources-complémentaires)

---

## Introduction à la Programmation Orientée Objet (POO)

La **Programmation Orientée Objet (POO)** est un paradigme de programmation qui organise le logiciel en **objets**, qui sont des instances de **classes**. Cette approche permet de modéliser des entités du monde réel, facilitant ainsi la conception, le développement et la maintenance des logiciels.

### Principes Fondamentaux de la POO

1. **Encapsulation** : Regrouper les données et les méthodes qui opèrent sur ces données au sein d'une même unité (classe).
2. **Héritage** : Permettre à une classe de dériver des caractéristiques (attributs et méthodes) d'une autre classe.
3. **Polymorphisme** : Permettre à des méthodes d’avoir différents comportements selon les objets qui les invoquent.
4. **Abstraction** : Cacher les détails complexes de l’implémentation et ne montrer que les caractéristiques essentielles.

---

## Définition d'une Classe

Une **classe** est un modèle ou un plan qui définit les propriétés (attributs) et les comportements (méthodes) d’un type d’objet particulier.

### Structure d'une Classe

Voici la structure générale d’une classe en Java :

```java
public class NomDeLaClasse {
    // Attributs (variables d'instance)
    type attribut1;
    type attribut2;
    // ...

    // Constructeurs
    public NomDeLaClasse() {
        // Code d'initialisation
    }

    // Méthodes (comportements)
    public void methode1() {
        // Code de la méthode
    }

    public type methode2() {
        // Code de la méthode
        return valeur;
    }
}
```

#### Exemple Simple de Classe

```java
public class Voiture {
    // Attributs
    String marque;
    String modèle;
    int année;

    // Méthode pour afficher les détails de la voiture
    public void afficherDetails() {
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modèle);
        System.out.println("Année : " + année);
    }
}
```

### Attributs et Méthodes

- **Attributs** : Variables qui représentent les propriétés ou les états de la classe.
- **Méthodes** : Fonctions définies au sein d’une classe qui décrivent les comportements ou les actions que les objets de cette classe peuvent exécuter.

---

## Création d'Objets

Un **objet** est une instance concrète d’une classe. Il possède ses propres valeurs pour les attributs définis dans la classe et peut utiliser les méthodes de cette classe.

### Instanciation d'une Classe

Pour créer un objet, utilisez le mot-clé `new` suivi du constructeur de la classe.

#### Exemple :

```java
public class Main {
    public static void main(String[] args) {
        // Création d'un objet Voiture
        Voiture maVoiture = new Voiture();
        
        // Attribution des valeurs aux attributs
        maVoiture.marque = "Toyota";
        maVoiture.modèle = "Corolla";
        maVoiture.année = 2020;
        
        // Appel de la méthode afficherDetails
        maVoiture.afficherDetails();
    }
}
```

#### Sortie :

```
Marque : Toyota
Modèle : Corolla
Année : 2020
```

### Accès aux Attributs et Méthodes

- **Attributs** : Accédez aux attributs d’un objet en utilisant l’opérateur `.` (point).
- **Méthodes** : Appelez les méthodes d’un objet de la même manière.

#### Exemple :

```java
// Accéder et modifier un attribut
maVoiture.année = 2021;

// Appeler une méthode
maVoiture.afficherDetails();
```

---

## Constructeurs

Les **constructeurs** sont des méthodes spéciales utilisées pour initialiser de nouveaux objets. Ils portent le même nom que la classe et n'ont pas de type de retour.

### Définition et Utilisation

#### Exemple de Constructeur

```java
public class Voiture {
    String marque;
    String modèle;
    int année;

    // Constructeur
    public Voiture(String marque, String modèle, int année) {
        this.marque = marque;
        this.modèle = modèle;
        this.année = année;
    }

    public void afficherDetails() {
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modèle);
        System.out.println("Année : " + année);
    }
}
```

#### Utilisation dans la Classe Main

```java
public class Main {
    public static void main(String[] args) {
        // Création d'un objet Voiture avec le constructeur
        Voiture maVoiture = new Voiture("Honda", "Civic", 2019);
        maVoiture.afficherDetails();
    }
}
```

#### Sortie :

```
Marque : Honda
Modèle : Civic
Année : 2019
```

### Constructeurs par Défaut et Surchargés

- **Constructeur par Défaut** : Si aucun constructeur n'est défini, Java fournit un constructeur sans paramètres par défaut.
- **Constructeurs Surchargés** : Vous pouvez définir plusieurs constructeurs avec des paramètres différents pour initialiser les objets de différentes manières.

#### Exemple de Surcharge de Constructeurs

```java
public class Voiture {
    String marque;
    String modèle;
    int année;

    // Constructeur par défaut
    public Voiture() {
        this.marque = "Non spécifiée";
        this.modèle = "Non spécifié";
        this.année = 0;
    }

    // Constructeur avec marque et modèle
    public Voiture(String marque, String modèle) {
        this.marque = marque;
        this.modèle = modèle;
        this.année = 0;
    }

    // Constructeur avec tous les attributs
    public Voiture(String marque, String modèle, int année) {
        this.marque = marque;
        this.modèle = modèle;
        this.année = année;
    }

    public void afficherDetails() {
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modèle);
        System.out.println("Année : " + année);
    }
}
```

#### Utilisation dans la Classe Main

```java
public class Main {
    public static void main(String[] args) {
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture("Ford", "Mustang");
        Voiture voiture3 = new Voiture("Chevrolet", "Camaro", 2021);
        
        voiture1.afficherDetails();
        System.out.println();
        voiture2.afficherDetails();
        System.out.println();
        voiture3.afficherDetails();
    }
}
```

#### Sortie :

```
Marque : Non spécifiée
Modèle : Non spécifié
Année : 0

Marque : Ford
Modèle : Mustang
Année : 0

Marque : Chevrolet
Modèle : Camaro
Année : 2021
```

---

## Encapsulation

**L'encapsulation** est un principe de la POO qui consiste à restreindre l’accès direct aux attributs d’une classe et à obliger l’utilisation de méthodes (`getters` et `setters`) pour les manipuler. Cela permet de protéger les données et de contrôler comment elles sont modifiées.

### Principe de l'Encapsulation

1. **Déclarer les attributs comme privés** : Utilisez le modificateur `private` pour restreindre l’accès direct.
2. **Fournir des méthodes publiques pour accéder et modifier ces attributs**.

#### Exemple d'Encapsulation

```java
public class Personne {
    // Attributs privés
    private String nom;
    private int age;

    // Getter pour nom
    public String getNom() {
        return nom;
    }

    // Setter pour nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour age
    public int getAge() {
        return age;
    }

    // Setter pour age avec validation
    public void setAge(int age) {
        if (age >= 0) { // Validation pour éviter les âges négatifs
            this.age = age;
        } else {
            System.out.println("Âge invalide !");
        }
    }

    // Méthode pour afficher les détails
    public void afficherDetails() {
        System.out.println("Nom : " + nom);
        System.out.println("Âge : " + age);
    }
}
```

#### Utilisation dans la Classe Main

```java
public class Main {
    public static void main(String[] args) {
        Personne p = new Personne();
        p.setNom("Marie");
        p.setAge(28);
        p.afficherDetails();

        p.setAge(-5); // Tentative de définir un âge invalide
    }
}
```

#### Sortie :

```
Nom : Marie
Âge : 28
Âge invalide !
```

### Avantages de l'Encapsulation

- **Protection des Données** : Empêche la modification accidentelle ou non autorisée des attributs.
- **Contrôle** : Permet de valider ou de modifier les valeurs avant de les affecter aux attributs.
- **Modularité** : Facilite la maintenance et les mises à jour en isolant les modifications possibles.

---

## Le Mot-clé `this`

Le mot-clé `this` fait référence à l'objet actuel. Il est utilisé pour différencier les attributs des paramètres portant le même nom, pour appeler d'autres constructeurs de la même classe, ou pour passer l'objet actuel en tant que paramètre.

### Utilisation de `this` pour les Attributs

#### Exemple :

```java
public class Rectangle {
    private double largeur;
    private double hauteur;

    // Constructeur avec paramètres
    public Rectangle(double largeur, double hauteur) {
        this.largeur = largeur; // 'this.largeur' fait référence à l'attribut
        this.hauteur = hauteur; // 'this.hauteur' fait référence à l'attribut
    }

    public double calculerSurface() {
        return largeur * hauteur;
    }
}
```

### Appel d'une Méthode Interne avec `this`

```java
public class Cercle {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public double calculerSurface() {
        return Math.PI * Math.pow(this.rayon, 2);
    }
}
```

### Appel d'un Constructeur depuis un Autre Constructeur

```java
public class Personne {
    private String nom;
    private int age;

    // Constructeur par défaut
    public Personne() {
        this("Nom Inconnu", 0); // Appel au constructeur paramétré
    }

    // Constructeur paramétré
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public void afficherDetails() {
        System.out.println("Nom : " + nom + ", Âge : " + age);
    }
}
```

#### Utilisation dans la Classe Main

```java
public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne();
        Personne p2 = new Personne("Jean", 35);
        
        p1.afficherDetails(); // Affiche Nom : Nom Inconnu, Âge : 0
        p2.afficherDetails(); // Affiche Nom : Jean, Âge : 35
    }
}
```

---

## Méthodes Statiques vs Méthodes d'Instance

### Méthodes d'Instance

- **Définition** : Méthodes qui nécessitent une instance de la classe pour être appelées.
- **Accès** : Peuvent accéder aux attributs et méthodes d'instance.
- **Utilisation** : Spécifiques à un objet particulier.

#### Exemple :

```java
public class Compteur {
    private int count = 0;

    public void incrementer() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Compteur c1 = new Compteur();
        Compteur c2 = new Compteur();
        
        c1.incrementer();
        c1.incrementer();
        c2.incrementer();
        
        System.out.println("Compteur c1 : " + c1.getCount()); // Affiche 2
        System.out.println("Compteur c2 : " + c2.getCount()); // Affiche 1
    }
}
```

### Méthodes Statiques

- **Définition** : Méthodes qui appartiennent à la classe elle-même plutôt qu'à une instance spécifique.
- **Accès** : Ne peuvent pas accéder directement aux attributs et méthodes d'instance.
- **Utilisation** : Utilisées pour les opérations utilitaires ou globales.

#### Exemple :

```java
public class MathUtil {
    public static int additionner(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        int somme = MathUtil.additionner(5, 7);
        System.out.println("Somme : " + somme); // Affiche 12
    }
}
```

#### Exemple avec Accès Limité

```java
public class Exemple {
    private int instanceVar = 10;
    private static int staticVar = 20;

    public static void methodeStatique() {
        // System.out.println(instanceVar); // Erreur : non accessible
        System.out.println(staticVar); // Correct
    }

    public void methodeInstance() {
        System.out.println(instanceVar); // Correct
        System.out.println(staticVar);   // Correct
    }
}
```

---

## Modificateurs d'Accès

Les **modificateurs d’accès** déterminent la visibilité des classes, attributs, méthodes et constructeurs. Ils sont essentiels pour la **sécurité** et la **maintenabilité** du code.

### Principaux Modificateurs d'Accès

1. **Public (`public`)** : Accessible depuis n’importe quelle autre classe.
2. **Privé (`private`)** : Accessible uniquement au sein de la classe où il est déclaré.
3. **Protégé (`protected`)** : Accessible dans le même package et par les classes dérivées (sous-classes).
4. **Default (Aucun Modificateur)** : Accessible uniquement au sein du même package.

### Exemple avec Modificateurs d'Accès

```java
public class ExempleAcces {
    public String publique = "Accessible partout";
    private String privee = "Accessible uniquement dans la classe ExempleAcces";
    protected String protegee = "Accessible dans le même package et par les sous-classes";
    String packagePrivate = "Accessible uniquement dans le même package";

    public void afficherPublice() {
        System.out.println(publique);
    }

    private void afficherPrivee() {
        System.out.println(privee);
    }

    protected void afficherProtegee() {
        System.out.println(protegee);
    }

    void afficherPackagePrivate() {
        System.out.println(packagePrivate);
    }
}
```

#### Utilisation dans la Classe Main

```java
public class Main {
    public static void main(String[] args) {
        ExempleAcces ex = new ExempleAcces();
        
        System.out.println(ex.publique);          // Correct
        // System.out.println(ex.privee);        // Erreur : inaccessible
        System.out.println(ex.protegee);         // Correct si Main est dans le même package
        System.out.println(ex.packagePrivate);    // Correct si Main est dans le même package

        ex.afficherPublice();                     // Correct
        // ex.afficherPrivee();                  // Erreur : inaccessible
        ex.afficherProtegee();                    // Correct si Main est dans le même package
        ex.afficherPackagePrivate();              // Correct si Main est dans le même package
    }
}
```

### Bonnes Pratiques avec les Modificateurs d'Accès

- **Encapsulation** : Gardez les attributs privés et exposez-les via des méthodes publiques (`getters` et `setters`).
- **Minimisez la Visibilité** : Utilisez le modificateur d’accès le plus restrictif possible pour chaque membre.
- **Interface Publique** : Déclarez clairement les méthodes qui doivent être accessibles depuis l’extérieur.

---

## Concepts Avancés Introduits

### Héritage

**L'héritage** permet à une classe (sous-classe) de hériter des attributs et méthodes d'une autre classe (super-classe). Cela favorise la réutilisabilité et l’organisation logique du code.

#### Exemple d’Héritage

```java
// Super-classe
public class Animal {
    protected String nom;

    public void manger() {
        System.out.println(nom + " mange.");
    }
}

// Sous-classe
public class Chien extends Animal {

    public Chien(String nom) {
        this.nom = nom;
    }

    public void aboyer() {
        System.out.println(nom + " aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Chien monChien = new Chien("Buddy");
        monChien.manger();  // Hérité de Animal
        monChien.aboyer();  // Spécifique à Chien
    }
}
```

#### Sortie :

```
Buddy mange.
Buddy aboie.
```

### Polymorphisme

**Le polymorphisme** permet à une méthode d’avoir différentes implémentations selon l’objet qui l’invoque. Cela permet d’écrire du code plus flexible et extensible.

#### Exemple de Polymorphisme

```java
public class Animal {
    public void faireDuBruit() {
        System.out.println("L'animal fait un bruit.");
    }
}

public class Chat extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chat miaule.");
    }
}

public class Chien extends Animal {
    @Override
    public void faireDuBruit() {
        System.out.println("Le chien aboie.");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal monAnimal = new Animal();
        Animal monChat = new Chat();
        Animal monChien = new Chien();
        
        monAnimal.faireDuBruit(); // Affiche "L'animal fait un bruit."
        monChat.faireDuBruit();   // Affiche "Le chat miaule."
        monChien.faireDuBruit();  // Affiche "Le chien aboie."
    }
}
```

#### Sortie :

```
L'animal fait un bruit.
Le chat miaule.
Le chien aboie.
```

### Abstraction

**L'abstraction** consiste à définir des classes qui capturent les caractéristiques essentielles d’un concept tout en ignorant les détails complexes. Cela se fait souvent à l’aide de classes abstraites et d’interfaces.

#### Exemple d’Abstraction avec Classe Abstraite

```java
// Classe abstraite
public abstract class Forme {
    public abstract double calculerSurface();
    
    public void afficherSurface() {
        System.out.println("La surface est : " + calculerSurface());
    }
}

// Sous-classe concrète
public class Cercle extends Forme {
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerSurface() {
        return Math.PI * rayon * rayon;
    }
}

public class Main {
    public static void main(String[] args) {
        Forme maForme = new Cercle(5.0);
        maForme.afficherSurface(); // Affiche "La surface est : 78.53981633974483"
    }
}
```

---

## Bonnes Pratiques

1. **Encapsulation** : Toujours protéger vos attributs en les déclarant privés et utiliser des getters et setters pour y accéder.
   
   ```java
   public class Personne {
       private String nom;

       public String getNom() {
           return nom;
       }

       public void setNom(String nom) {
           this.nom = nom;
       }
   }
   ```

2. **Nommage Clair et Cohérent** : Utilisez des noms significatifs pour vos classes, attributs et méthodes afin de faciliter la compréhension du code.
   
   ```java
   // Mauvaise pratique
   public class X {
       private int y;

       public int a() {
           return y;
       }
   }

   // Bonne pratique
   public class Voiture {
       private int vitesse;

       public int getVitesse() {
           return vitesse;
       }
   }
   ```

3. **Méthodes Courtes et Simples** : Chaque méthode devrait effectuer une seule tâche spécifique. Si une méthode devient trop complexe, divisez-la en sous-méthodes.
   
   ```java
   // Méthode complexe
   public void traiterDonnees() {
       // Code pour valider les données
       // Code pour transformer les données
       // Code pour enregistrer les données
   }

   // Meilleure pratique
   public void traiterDonnees() {
       validerDonnees();
       transformerDonnees();
       enregistrerDonnees();
   }

   private void validerDonnees() { /* ... */ }
   private void transformerDonnees() { /* ... */ }
   private void enregistrerDonnees() { /* ... */ }
   ```

4. **Utilisation Appropriée des Modificateurs d’Accès** : Restreignez autant que possible la visibilité des membres de classe pour renforcer l'encapsulation.
   
   ```java
   public class Compteur {
       private int count;

       public void incrementer() {
           count++;
       }

       public int getCount() {
           return count;
       }
   }
   ```

5. **Eviter les Redondances** : Utilisez l’héritage et la surcharge de méthodes pour éviter la duplication de code.

6. **Documentation et Commentaires** : Documentez vos classes et méthodes en utilisant des commentaires et des javadocs pour expliquer leur fonctionnalité.
   
   ```java
   /**
    * Classe représentant une voiture avec des attributs de marque, modèle et année.
    */
   public class Voiture {
       // Attributs et méthodes
   }
   ```

7. **Respect des Conventions de Nommage** : Suivez les conventions de Java pour les noms de classes (CamelCase), de méthodes et d’attributs (camelCase).

---

## Exercices Pratiques

### Exercice 1 : Création d'une Classe `Livre`

Créez une classe `Livre` qui possède les attributs suivants :

- `titre` (String)
- `auteur` (String)
- `nbPages` (int)
- `prix` (double)

Incluez les méthodes suivantes :

- Constructeur avec tous les attributs.
- Getters et setters pour chaque attribut.
- Méthode `afficherDetails` qui affiche les informations du livre.

#### Exemple de Code :

```java
public class Livre {
    private String titre;
    private String auteur;
    private int nbPages;
    private double prix;

    // Constructeur
    public Livre(String titre, String auteur, int nbPages, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.prix = prix;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        if (nbPages > 0) {
            this.nbPages = nbPages;
        } else {
            System.out.println("Nombre de pages invalide !");
        }
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        } else {
            System.out.println("Prix invalide !");
        }
    }

    // Méthode pour afficher les détails
    public void afficherDetails() {
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("Nombre de Pages : " + nbPages);
        System.out.println("Prix : " + prix + "€");
    }
}

public class Main {
    public static void main(String[] args) {
        Livre livre1 = new Livre("1984", "George Orwell", 328, 15.99);
        livre1.afficherDetails();

        System.out.println();

        livre1.setNbPages(-50); // Tentative de définir un nombre de pages invalide
        livre1.setPrix(-10.0);  // Tentative de définir un prix invalide
    }
}
```

#### Sortie :

```
Titre : 1984
Auteur : George Orwell
Nombre de Pages : 328
Prix : 15.99€

Nombre de pages invalide !
Prix invalide !
```

### Exercice 2 : Gestion d'un Bank Account

Créez une classe `CompteBancaire` avec les attributs suivants :

- `numeroCompte` (String)
- `solde` (double)

Incluez les méthodes suivantes :

- Constructeur avec `numeroCompte` et `solde` initial.
- Méthode `deposer(double montant)` pour ajouter de l'argent au compte.
- Méthode `retirer(double montant)` pour retirer de l'argent du compte si le solde est suffisant.
- Méthode `afficherSolde` pour afficher le solde actuel.

#### Exemple de Code :

```java
public class CompteBancaire {
    private String numeroCompte;
    private double solde;

    // Constructeur
    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        if (soldeInitial >= 0) {
            this.solde = soldeInitial;
        } else {
            this.solde = 0;
            System.out.println("Solde initial invalide. Le solde est défini à 0.");
        }
    }

    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + "€ effectué.");
        } else {
            System.out.println("Montant de dépôt invalide !");
        }
    }

    // Méthode pour retirer de l'argent
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant + "€ effectué.");
        } else {
            System.out.println("Montant de retrait invalide ou solde insuffisant !");
        }
    }

    // Méthode pour afficher le solde
    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde + "€");
    }
}

public class Main {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire("ABC123", 500.0);
        compte.afficherSolde();

        compte.deposer(150.0);
        compte.afficherSolde();

        compte.retirer(200.0);
        compte.afficherSolde();

        compte.retirer(600.0); // Tentative de retrait excessive
    }
}
```

#### Sortie :

```
Solde du compte ABC123 : 500.0€
Dépôt de 150.0€ effectué.
Solde du compte ABC123 : 650.0€
Retrait de 200.0€ effectué.
Solde du compte ABC123 : 450.0€
Montant de retrait invalide ou solde insuffisant !
```

### Exercice 3 : Création d'une Classe `Personne`

Créez une classe `Personne` avec les attributs suivants :

- `nom` (String)
- `prenom` (String)
- `age` (int)

Incluez les méthodes suivantes :

- Constructeur avec tous les attributs.
- Getters et Setters avec validation pour `age` (doit être ≥ 0).
- Méthode `sePresenter` qui affiche une présentation de la personne.

#### Exemple de Code :

```java
public class Personne {
    private String nom;
    private String prenom;
    private int age;

    // Constructeur
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        setAge(age); // Utilisation du setter avec validation
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Âge invalide ! L'âge est défini à 0.");
            this.age = 0;
        }
    }

    // Méthode pour se présenter
    public void sePresenter() {
        System.out.println("Bonjour, je m'appelle " + prenom + " " + nom + " et j'ai " + age + " ans.");
    }
}

public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne("Doe", "John", 30);
        p1.sePresenter();

        Personne p2 = new Personne("Smith", "Anna", -5); // Âge invalide
        p2.sePresenter();

        p2.setAge(25);
        p2.sePresenter();
    }
}
```

#### Sortie :

```
Bonjour, je m'appelle John Doe et j'ai 30 ans.
Âge invalide ! L'âge est défini à 0.
Bonjour, je m'appelle Anna Smith et j'ai 0 ans.
Bonjour, je m'appelle Anna Smith et j'ai 25 ans.
```

---

## Conclusion et Ressources Complémentaires

Félicitations ! Vous avez maintenant une compréhension approfondie des **classes** et des **objets** en Java, ainsi que des principes fondamentaux de la **Programmation Orientée Objet (POO)**. Ces concepts sont essentiels pour structurer vos programmes de manière efficace, réutilisable et maintenable.

### Ressources Recommandées

- **Livres** :
    - *Effective Java* par Joshua Bloch
    - *Java: The Complete Reference* par Herbert Schildt
    - *Head First Java* par Kathy Sierra et Bert Bates
- **Sites Web** :
    - [Oracle Java Documentation - Classes, Objets et API](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
    - [W3Schools - Java Classes and Objects](https://www.w3schools.com/java/java_classes.asp)
    - [GeeksforGeeks - Object Oriented Programming in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
- **Cours en Ligne** :
    - [Codecademy - Learn Java](https://www.codecademy.com/learn/learn-java)
    - [Coursera - Java Programming and Software Engineering Fundamentals](https://www.coursera.org/specializations/java-programming)
    - [Udemy - Java Programming Masterclass](https://www.udemy.com/course/java-the-complete-java-developer-course/)

### Conseils pour Continuer

1. **Pratiquez Régulièrement** : Créez des classes et manipulez des objets pour renforcer votre compréhension.
2. **Résolvez des Problèmes Complexes** : Utilisez des plateformes comme [LeetCode](https://leetcode.com/), [HackerRank](https://www.hackerrank.com/domains/java) ou [Codewars](https://www.codewars.com/) pour appliquer vos connaissances à des problèmes variés.
3. **Explorez les Concepts Avancés** :
    - **Héritage et Polymorphisme** : Pour comprendre la réutilisation du code et la flexibilité.
    - **Interfaces et Classes Abstraites** : Pour maîtriser l'abstraction et la conception d'architectures flexibles.
    - **Collections et Génériques** : Pour manipuler des groupes d'objets de manière efficace.
4. **Lire du Code Source** : Analysez le code d'autres développeurs pour voir comment ils organisent et utilisent les classes et objets dans des projets réels.
5. **Participer à des Projets Open Source** : Contribuez à des projets open source pour acquérir une expérience pratique et collaborative.
6. **Rejoindre des Communautés** : Participez à des forums, des groupes de discussion ou des meetups pour échanger des idées et obtenir de l'aide lorsque nécessaire. Des forums comme [Stack Overflow](https://stackoverflow.com/questions/tagged/java) ou des groupes sur [Reddit - r/learnjava](https://www.reddit.com/r/learnjava/) peuvent être très utiles.

En continuant à explorer et à pratiquer les concepts de la POO en Java, vous développerez des compétences solides pour créer des applications robustes et maintenables. Bonne programmation !