# Cours sur les Encapsulation et Abstraction en Java

Bienvenue dans le neuvième chapitre de notre cours Java, consacré aux concepts d'**encapsulation** et d'**abstraction**. Ces principes fondamentaux de la programmation orientée objet (POO) sont essentiels pour concevoir des applications robustes, maintenables et évolutives. Dans ce chapitre, nous explorerons en détail ces concepts, leur mise en œuvre en Java, ainsi que des exemples pratiques pour illustrer leur utilisation.

## Table des Matières

1. [Introduction à l'Encapsulation et à l'Abstraction](#1-introduction-à-lencapsulation-et-à-labstraction)
2. [L'Encapsulation en Java](#2-lencapsulation-en-java)
    - 2.1 [Définition de l'Encapsulation](#21-définition-de-lencapsulation)
    - 2.2 [Les Modificateurs d'Accès](#22-les-modificateurs-daccès)
        - 2.2.1 [`private`](#221-private)
        - 2.2.2 [`public`](#222-public)
        - 2.2.3 [`protected`](#223-protected)
        - 2.2.4 [Accès par Défaut](#224-accès-par-défaut)
    - 2.3 [Les Méthodes Getters et Setters](#23-les-méthodes-getters-et-setters)
    - 2.4 [Avantages de l'Encapsulation](#24-avantages-de-lencapsulation)
    - 2.5 [Exemple d'Encapsulation en Java](#25-exemple-dencapsulation-en-java)
3. [L'Abstraction en Java](#3-labstraction-en-java)
    - 3.1 [Définition de l'Abstraction](#31-définition-de-labstraction)
    - 3.2 [Classes Abstraites](#32-classes-abstraites)
    - 3.3 [Interfaces](#33-interfaces)
    - 3.4 [Différences entre Encapsulation et Abstraction](#34-différences-entre-encapsulation-et-abstraction)
    - 3.5 [Avantages de l'Abstraction](#35-avantages-de-labstraction)
    - 3.6 [Exemple d'Abstraction en Java](#36-exemple-dabstraction-en-java)
4. [Bonnes Pratiques](#4-bonnes-pratiques)
5. [Exemples Pratiques](#5-exemples-pratiques)
6. [Exercices](#6-exercices)
7. [Conclusion](#7-conclusion)

---

## 1. Introduction à l'Encapsulation et à l'Abstraction

L'**encapsulation** et l'**abstraction** sont deux des quatre piliers de la programmation orientée objet, avec l'héritage et le polymorphisme. Ces concepts permettent de structurer le code de manière à améliorer sa lisibilité, sa réutilisabilité et sa maintenance.

- **Encapsulation** : C'est le mécanisme qui consiste à regrouper les données (attributs) et les méthodes qui opèrent sur ces données au sein d'une même entité, généralement une classe. Elle vise à restreindre l'accès direct aux données et à protéger l'intégrité de celles-ci.
  
- **Abstraction** : C'est le processus de simplification de la complexité en ne dévoilant que les caractéristiques essentielles d'un objet, tout en cachant les détails d'implémentation. Elle permet de se concentrer sur ce qu'un objet fait plutôt que sur la façon dont il le fait.

## 2. L'Encapsulation en Java

### 2.1 Définition de l'Encapsulation

L'encapsulation est le processus de combinaison des données (attributs) et des méthodes (comportements) dans une seule unité appelée classe. En Java, cela est réalisé en définissant les attributs d'une classe comme `private` et en fournissant des méthodes publiques pour accéder et modifier ces attributs.

### 2.2 Les Modificateurs d'Accès

Java fournit plusieurs modificateurs d'accès pour contrôler la visibilité des classes, des méthodes et des attributs. Les principaux modificateurs d'accès utilisés dans l'encapsulation sont :

#### 2.2.1 `private`

- **Description** : Le modificateur `private` restreint l'accès au membre de la classe uniquement à l'intérieur de cette classe.
- **Utilisation** : Principalement utilisé pour les attributs afin de les protéger contre les modifications directes.

```java
public class Personne {
    private String nom;
    private int age;
}
```

#### 2.2.2 `public`

- **Description** : Le modificateur `public` permet un accès illimité au membre, que ce soit à l'intérieur de la classe, du package ou depuis d'autres packages.
- **Utilisation** : Utilisé pour les méthodes publiques qui permettent d'accéder ou de modifier les attributs privés.

```java
public class Personne {
    private String nom;
    private int age;
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
}
```

#### 2.2.3 `protected`

- **Description** : Le modificateur `protected` permet un accès aux membres de la classe au sein du même package et aux sous-classes, même si elles sont situées dans différents packages.
- **Utilisation** : Utile pour permettre aux classes dérivées d'accéder aux membres de la superclasse.

```java
public class Employe {
    protected double salaire;
}
```

#### 2.2.4 Accès par Défaut

- **Description** : Lorsqu'aucun modificateur d'accès n'est spécifié, l'accès par défaut (ou package-private) est appliqué. Les membres sont accessibles uniquement au sein du même package.
- **Utilisation** : Utile pour limiter l'accès aux classes utilitaires ou helper au sein d'un même package.

```java
class Produit {
    double prix; // Accès par défaut
}
```

### 2.3 Les Méthodes Getters et Setters

Pour permettre un accès contrôlé aux attributs privés, on utilise des méthodes **getters** (accesseurs) et **setters** (mutateurs).

- **Getter** : Méthode qui retourne la valeur d'un attribut.
- **Setter** : Méthode qui permet de définir ou de modifier la valeur d'un attribut.

**Exemple :**

```java
public class Personne {
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
    
    // Setter pour age
    public void setAge(int age) {
        if(age > 0) { // Validation simple
            this.age = age;
        }
    }
}
```

### 2.4 Avantages de l'Encapsulation

- **Contrôle de l'accès** : Limite l'accès direct aux données sensibles, protégeant ainsi l'intégrité des objets.
- **Flexibilité et Maintenabilité** : Permet de modifier l'implémentation interne sans affecter les classes qui utilisent la classe encapsulée.
- **Réutilisabilité** : Facilite la réutilisation des classes encapsulées dans différents contextes.
- **Sécurité** : Empêche les modifications non autorisées des données.

### 2.5 Exemple d'Encapsulation en Java

**Classe `CompteBancaire` encapsulée :**

```java
public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    
    public CompteBancaire(String numeroCompte, double soldeInitial) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
    }
    
    // Getter pour numeroCompte
    public String getNumeroCompte() {
        return numeroCompte;
    }
    
    // Getter pour solde
    public double getSolde() {
        return solde;
    }
    
    // Méthode pour déposer de l'argent
    public void deposer(double montant) {
        if(montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }
    
    // Méthode pour retirer de l'argent
    public void retirer(double montant) {
        if(montant > 0 && solde >= montant) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde : " + solde);
        } else {
            System.out.println("Retrait invalide ou solde insuffisant.");
        }
    }
}
```

**Utilisation de la classe `CompteBancaire` :**

```java
public class TestCompteBancaire {
    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire("123456789", 1000.0);
        
        // Accès aux attributs via getters
        System.out.println("Numéro de Compte : " + compte.getNumeroCompte());
        System.out.println("Solde Initial : " + compte.getSolde());
        
        // Dépôt d'argent
        compte.deposer(500.0);
        
        // Retrait d'argent
        compte.retirer(200.0);
        
        // Tentative de retrait insuffisant
        compte.retirer(1500.0);
    }
}
```

**Sortie :**
```
Numéro de Compte : 123456789
Solde Initial : 1000.0
Dépôt de 500.0 effectué. Nouveau solde : 1500.0
Retrait de 200.0 effectué. Nouveau solde : 1300.0
Retrait invalide ou solde insuffisant.
```

## 3. L'Abstraction en Java

### 3.1 Définition de l'Abstraction

L'abstraction consiste à simplifier la complexité en ne dévoilant que les aspects essentiels d'un objet ou d'un système, en masquant les détails d'implémentation. En Java, l'abstraction est réalisée principalement à travers les **classes abstraites** et les **interfaces**.

### 3.2 Classes Abstraites

Une classe abstraite est une classe qui ne peut pas être instanciée directement. Elle peut contenir des méthodes abstraites (sans implémentation) ainsi que des méthodes concrètes (avec implémentation). Les classes abstraites servent de base pour d'autres classes qui doivent fournir des implémentations spécifiques des méthodes abstraites.

**Exemple de classe abstraite :**

```java
public abstract class Animal {
    private String nom;
    
    public Animal(String nom) {
        this.nom = nom;
    }
    
    public String getNom() {
        return nom;
    }
    
    // Méthode abstraite
    public abstract void faireDuBruit();
    
    // Méthode concrète
    public void dormir() {
        System.out.println(nom + " dort.");
    }
}
```

**Sous-classes concrètes :**

```java
public class Chien extends Animal {
    public Chien(String nom) {
        super(nom);
    }
    
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " aboie.");
    }
}

public class Chat extends Animal {
    public Chat(String nom) {
        super(nom);
    }
    
    @Override
    public void faireDuBruit() {
        System.out.println(getNom() + " miaule.");
    }
}
```

### 3.3 Interfaces

Une interface définit un contrat que les classes doivent respecter, sans fournir d'implémentation (jusqu'à Java 7). Depuis Java 8, les interfaces peuvent contenir des méthodes par défaut avec une implémentation et des méthodes statiques. Les interfaces permettent de définir des comportements que différentes classes peuvent implémenter, favorisant ainsi la flexibilité et la réutilisabilité.

**Exemple d'interface :**

```java
public interface Volant {
    void voler();
}
```

**Classes implémentant l'interface :**

```java
public class Oiseau implements Volant {
    @Override
    public void voler() {
        System.out.println("L'oiseau vole.");
    }
}

public class Avion implements Volant {
    @Override
    public void voler() {
        System.out.println("L'avion vole dans le ciel.");
    }
}
```

### 3.4 Différences entre Encapsulation et Abstraction

| **Encapsulation** | **Abstraction** |
|-------------------|------------------|
| Regroupe les données et les méthodes au sein d'une même classe. | Simplifie la complexité en ne révélant que les aspects essentiels. |
| Protège l'intégrité des données en contrôlant l'accès aux attributs. | Se concentre sur le **quoi** d'un objet plutôt que sur le **comment**. |
| Utilise des modificateurs d'accès comme `private`, `public`, etc. | Utilise des classes abstraites et des interfaces. |

### 3.5 Avantages de l'Abstraction

- **Simplicité** : Réduit la complexité en cachant les détails d'implémentation.
- **Flexibilité** : Facilite la modification de l'implémentation sans affecter les utilisateurs de l'abstraction.
- **Réutilisabilité** : Favorise la réutilisation du code grâce à des interfaces et des classes abstraites bien définies.
- **Maintenance** : Rend le code plus facile à maintenir et à évoluer.

### 3.6 Exemple d'Abstraction en Java

**Classe abstraite `Vehicule` :**

```java
public abstract class Vehicule {
    private String marque;
    
    public Vehicule(String marque) {
        this.marque = marque;
    }
    
    public String getMarque() {
        return marque;
    }
    
    // Méthode abstraite
    public abstract void demarrer();
    
    // Méthode concrète
    public void arreter() {
        System.out.println(marque + " s'est arrêté.");
    }
}
```

**Sous-classes concrètes :**

```java
public class Voiture extends Vehicule {
    public Voiture(String marque) {
        super(marque);
    }
    
    @Override
    public void demarrer() {
        System.out.println(getMarque() + " démarre en douceur.");
    }
}

public class Moto extends Vehicule {
    public Moto(String marque) {
        super(marque);
    }
    
    @Override
    public void demarrer() {
        System.out.println(getMarque() + " démarre avec un vrombissement.");
    }
}
```

**Classe de test :**

```java
public class TestVehicules {
    public static void main(String[] args) {
        Vehicule maVoiture = new Voiture("Toyota");
        Vehicule maMoto = new Moto("Harley-Davidson");
        
        maVoiture.demarrer(); // Affiche "Toyota démarre en douceur."
        maVoiture.arreter();  // Affiche "Toyota s'est arrêté."
        
        maMoto.demarrer();    // Affiche "Harley-Davidson démarre avec un vrombissement."
        maMoto.arreter();     // Affiche "Harley-Davidson s'est arrêté."
    }
}
```

## 4. Bonnes Pratiques

- **Utiliser les Modificateurs d'Accès Judicieux** : Protéger les données sensibles en utilisant `private` et fournir des accès contrôlés via des getters et setters.
- **Favoriser les Interfaces pour l'Abstraction** : Utiliser des interfaces pour définir des contrats clairs et permettre une implémentation flexible par différentes classes.
- **Limiter l'Utilisation des Classes Abstraites** : Utiliser des classes abstraites lorsque des comportements communs doivent être partagés parmi des classes dérivées.
- **Respecter le Principe de Responsabilité Unique** : Chaque classe doit avoir une seule responsabilité, facilitant ainsi l'encapsulation et l'abstraction.
- **Documenter le Code** : Utiliser des commentaires et des annotations pour clarifier les intentions derrière l'encapsulation et l'abstraction.
- **Valider les Entrées dans les Setters** : Assurer l'intégrité des données en validant les paramètres dans les méthodes setters.

## 5. Exemples Pratiques

### Exemple 1 : Gestion des Employés

**Classe `Employe` encapsulée :**

```java
public class Employe {
    private String nom;
    private double salaire;
    
    public Employe(String nom, double salaire) {
        this.nom = nom;
        setSalaire(salaire);
    }
    
    public String getNom() {
        return nom;
    }
    
    public double getSalaire() {
        return salaire;
    }
    
    public void setSalaire(double salaire) {
        if(salaire > 0) {
            this.salaire = salaire;
        } else {
            System.out.println("Salaire invalide.");
        }
    }
    
    public void afficherDetails() {
        System.out.println("Nom : " + nom + ", Salaire : " + salaire);
    }
}
```

### Exemple 2 : Abstraction avec les Dispositifs de Stockage

**Interface `Stockage` :**

```java
public interface Stockage {
    void enregistrer(String data);
    String lire();
}
```

**Classes implémentant l'interface `Stockage` :**

```java
public class DisqueDur implements Stockage {
    private StringBuilder stockage = new StringBuilder();
    
    @Override
    public void enregistrer(String data) {
        stockage.append(data);
        System.out.println("Données enregistrées sur le disque dur.");
    }
    
    @Override
    public String lire() {
        return stockage.toString();
    }
}

public class SSD implements Stockage {
    private StringBuilder stockage = new StringBuilder();
    
    @Override
    public void enregistrer(String data) {
        stockage.append(data);
        System.out.println("Données enregistrées sur le SSD.");
    }
    
    @Override
    public String lire() {
        return stockage.toString();
    }
}
```

**Classe de test :**

```java
public class TestStockage {
    public static void main(String[] args) {
        Stockage monDisqueDur = new DisqueDur();
        Stockage monSSD = new SSD();
        
        monDisqueDur.enregistrer("Fichier1.txt\n");
        monSSD.enregistrer("Fichier2.txt\n");
        
        System.out.println("Contenu du Disque Dur :\n" + monDisqueDur.lire());
        System.out.println("Contenu du SSD :\n" + monSSD.lire());
    }
}
```

**Sortie :**
```
Données enregistrées sur le disque dur.
Données enregistrées sur le SSD.
Contenu du Disque Dur :
Fichier1.txt

Contenu du SSD :
Fichier2.txt
```

## 6. Exercices

### Exercice 1 : Encapsulation d'une Classe `Livre`

1. **Créer une classe `Livre` avec les attributs suivants :**
    - `titre` (String)
    - `auteur` (String)
    - `prix` (double)

2. **Encapsuler les attributs en les déclarant privés.**

3. **Fournir des getters et setters pour chaque attribut, en validant que le prix ne soit pas négatif.**

4. **Ajouter une méthode `afficherDetails()` pour afficher les informations du livre.**

5. **Dans une classe `TestLivre`, créer une instance de `Livre`, définir ses attributs et afficher ses détails.**

### Exercice 2 : Abstraction avec des Formes Géométriques

1. **Créer une classe abstraite `Forme` avec une méthode abstraite `calculerAire()`.**

2. **Créer des sous-classes `Rectangle`, `Cercle` et `Triangle` qui héritent de `Forme` et implémentent la méthode `calculerAire()`.**

3. **Ajouter des attributs spécifiques à chaque forme (par exemple, la longueur et la largeur pour le `Rectangle`).**

4. **Dans une classe `TestFormes`, créer des instances de chaque forme, calculer et afficher leur aire.**

### Exercice 3 : Utilisation des Interfaces

1. **Créer une interface `Imprimable` avec une méthode `imprimer()`.**

2. **Créer des classes `Document`, `Image`, et `Pdf` qui implémentent l'interface `Imprimable`.**

3. **Chaque classe doit fournir une implémentation spécifique de la méthode `imprimer()`.**

4. **Dans une classe `TestImprimable`, créer un tableau d'`Imprimable` contenant différentes instances et appeler la méthode `imprimer()` sur chacune d'elles.**

## 7. Conclusion

L'**encapsulation** et l'**abstraction** sont des concepts clés de la programmation orientée objet en Java qui contribuent à la création de code bien structuré, sécurisé et facile à maintenir. 

- **L'encapsulation** permet de protéger les données en restreignant l'accès direct aux attributs et en fournissant des méthodes contrôlées pour interagir avec ces données.
  
- **L'abstraction** facilite la gestion de la complexité en cachant les détails d'implémentation et en se concentrant sur les fonctionnalités essentielles.

En maîtrisant ces concepts, vous serez en mesure de concevoir des applications modulaires et évolutives, facilitant ainsi le développement et la maintenance de systèmes logiciels robustes.

N'oubliez pas de pratiquer régulièrement ces concepts à travers des exercices et des projets concrets pour renforcer votre compréhension et votre expertise en Java.

---