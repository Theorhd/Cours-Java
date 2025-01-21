# 11 - Gestion de Données en Java

Bienvenue dans le onzième chapitre de notre cours Java, dédié à la **gestion des données**. La gestion des données est cruciale pour la plupart des applications, qu'il s'agisse de stocker des informations utilisateur, de gérer des transactions financières ou de manipuler des données scientifiques. En Java, plusieurs mécanismes et frameworks facilitent l'interaction avec les bases de données et le stockage de données. Dans ce chapitre, nous aborderons les concepts fondamentaux des bases de données, ainsi que les outils tels que **JDBC** et **Hibernate** pour gérer efficacement les données dans vos applications Java.

## Table des Matières

1. [Introduction à la Gestion des Données](#1-introduction-à-la-gestion-des-données)
2. [Bases de Données : Concepts de Base](#2-bases-de-données-concepts-de-base)
    - 2.1 [Bases de Données Relationnelles](#21-bases-de-données-relationnelles)
    - 2.2 [SQL : Structured Query Language](#22-sql-structured-query-language)
    - 2.3 [Modélisation des Données](#23-modélisation-des-données)
3. [JDBC : Java Database Connectivity](#3-jdbc-java-database-connectivity)
    - 3.1 [Introduction à JDBC](#31-introduction-à-jdbc)
    - 3.2 [Configuration de JDBC](#32-configuration-de-jdbc)
    - 3.3 [Opérations CRUD avec JDBC](#33-opérations-crud-avec-jdbc)
    - 3.4 [Gestion des Connexions](#34-gestion-des-connexions)
4. [Hibernate : ORM (Object-Relational Mapping) en Java](#4-hibernate-orm-object-relational-mapping-en-java)
    - 4.1 [Introduction à l'ORM](#41-introduction-à-lorm)
    - 4.2 [Configuration de Hibernate](#42-configuration-de-hibernate)
    - 4.3 [Mapping des Entités](#43-mapping-des-entités)
    - 4.4 [Opérations CRUD avec Hibernate](#44-opérations-crud-avec-hibernate)
5. [Comparaison entre JDBC et Hibernate](#5-comparaison-entre-jdbc-et-hibernate)
6. [Bonnes Pratiques pour la Gestion des Données](#6-bonnes-pratiques-pour-la-gestion-des-données)
7. [Exemples Pratiques](#7-exemples-pratiques)
8. [Exercices](#8-exercices)
9. [Conclusion](#9-conclusion)

---

## 1. Introduction à la Gestion des Données

La gestion des données concerne toutes les opérations liées au stockage, à la manipulation et à l'accès aux données dans une application. En Java, cela implique souvent la connexion à des bases de données, l'exécution de requêtes, la gestion des transactions et la manipulation des résultats. Deux des principales approches pour gérer les données en Java sont l'utilisation directe de **JDBC** et l'emploi de **frameworks ORM** comme **Hibernate**.

## 2. Bases de Données : Concepts de Base

### 2.1 Bases de Données Relationnelles

Les **bases de données relationnelles** (RDBMS) stockent les données sous forme de tables liées entre elles par des relations. Chaque table est composée de lignes (**enregistrements**) et de colonnes (**champs**).

**Exemple : Table `Employes`**

| ID | Nom     | Poste      | Salaire |
|----|---------|------------|---------|
| 1  | Alice   | Développeur| 60000   |
| 2  | Bob     | Analyste   | 55000   |
| 3  | Charlie | Manager    | 75000   |

### 2.2 SQL : Structured Query Language

**SQL** est le langage standard utilisé pour interagir avec les bases de données relationnelles. Il permet de définir, manipuler et gérer les données.

**Opérations SQL courantes :**

- **SELECT** : Récupérer des données.
- **INSERT** : Ajouter de nouvelles données.
- **UPDATE** : Modifier des données existantes.
- **DELETE** : Supprimer des données.
- **CREATE** : Créer des tables ou des bases de données.
- **DROP** : Supprimer des tables ou des bases de données.

**Exemples :**

```sql
-- Sélectionner tous les employés
SELECT * FROM Employes;

-- Ajouter un nouvel employé
INSERT INTO Employes (Nom, Poste, Salaire) VALUES ('David', 'Designer', 50000);

-- Mettre à jour le salaire d'un employé
UPDATE Employes SET Salaire = 65000 WHERE ID = 1;

-- Supprimer un employé
DELETE FROM Employes WHERE ID = 2;
```

### 2.3 Modélisation des Données

La **modélisation des données** consiste à structurer les données de manière logique et efficace. Elle implique la création de schémas de base de données, la définition des relations entre les tables et l'optimisation pour les requêtes.

**Principaux éléments :**

- **Entités** : Représentées par des tables.
- **Attributs** : Représentés par des colonnes dans les tables.
- **Relations** : Liens entre les tables (1:1, 1:N, N:M).
- **Contraintes** : Règles applicables aux données (clés primaires, clés étrangères, etc.).

**Exemple de Modèle Entité-Relation :**

```
Employes (ID, Nom, Poste, Salaire, DépartementID)
Départements (ID, Nom)
```
- **Relation** : Chaque employé appartient à un département (N:1).

## 3. JDBC : Java Database Connectivity

### 3.1 Introduction à JDBC

**JDBC** est une API Java qui permet à Java de se connecter à des bases de données relationnelles en exécutant des requêtes SQL et en récupérant les résultats. Il sert de pont entre l'application Java et le RDBMS.

### 3.2 Configuration de JDBC

Pour utiliser JDBC, vous devez :

1. **Ajouter le pilote JDBC au projet** : Chaque RDBMS (comme MySQL, PostgreSQL) a son propre pilote JDBC.
2. **Établir une connexion** : Utiliser `DriverManager` pour se connecter à la base de données.
3. **Créer des objets `Statement` ou `PreparedStatement`** : Pour exécuter des requêtes SQL.
4. **Exécuter les requêtes** : Utiliser les méthodes appropriées (`executeQuery`, `executeUpdate`).
5. **Traiter les résultats** : Parcourir les `ResultSet`.
6. **Fermer les ressources** : Libérer les connexions, statements, et resultsets.

**Exemple de connexion à une base de données MySQL :**

```java
import java.sql.*;

public class ConnexionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/maBaseDeDonnees";
        String utilisateur = "root";
        String motDePasse = "password";

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Établir la connexion
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
            
            // Fermer la connexion
            connexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion !");
            e.printStackTrace();
        }
    }
}
```

### 3.3 Opérations CRUD avec JDBC

**CRUD** signifie **Create, Read, Update, Delete** et représente les opérations de base sur les données.

**Exemple d'opérations CRUD :**

```java
import java.sql.*;

public class OperationsCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/maBaseDeDonnees";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "password";

    public static void main(String[] args) {
        try (Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            // CREATE
            String insertSQL = "INSERT INTO Employes (Nom, Poste, Salaire) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connexion.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Eve");
                pstmt.setString(2, "Architecte");
                pstmt.setDouble(3, 80000);
                pstmt.executeUpdate();
                System.out.println("Employé ajouté.");
            }

            // READ
            String selectSQL = "SELECT * FROM Employes";
            try (Statement stmt = connexion.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("ID") + " - " + rs.getString("Nom") + " - " + rs.getString("Poste") + " - " + rs.getDouble("Salaire"));
                }
            }

            // UPDATE
            String updateSQL = "UPDATE Employes SET Salaire = ? WHERE Nom = ?";
            try (PreparedStatement pstmt = connexion.prepareStatement(updateSQL)) {
                pstmt.setDouble(1, 85000);
                pstmt.setString(2, "Eve");
                pstmt.executeUpdate();
                System.out.println("Salaire mis à jour.");
            }

            // DELETE
            String deleteSQL = "DELETE FROM Employes WHERE Nom = ?";
            try (PreparedStatement pstmt = connexion.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Eve");
                pstmt.executeUpdate();
                System.out.println("Employé supprimé.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### 3.4 Gestion des Connexions

Gérer efficacement les connexions est vital pour la performance et la stabilité de l'application. Il est recommandé d'utiliser un **pool de connexions** pour réutiliser les connexions existantes plutôt que d'en créer de nouvelles à chaque opération.

**Exemple avec HikariCP (un pool de connexions populaire) :**

```java
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class PoolConnexions {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/maBaseDeDonnees");
        config.setUsername("root");
        config.setPassword("password");
        config.setMaximumPoolSize(10);
        
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {
        try (Connection connexion = getConnection()) {
            System.out.println("Connexion via pool réussie !");
            // Effectuer des opérations
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## 4. Hibernate : ORM (Object-Relational Mapping) en Java

### 4.1 Introduction à l'ORM

**ORM** (Object-Relational Mapping) est une technique qui permet de mapper des objets orientés objet aux tables d'une base de données relationnelle. **Hibernate** est l'un des frameworks ORM les plus populaires pour Java, facilitant la gestion des données et réduisant le code boilerplate associé à JDBC.

### 4.2 Configuration de Hibernate

Pour configurer Hibernate :

1. **Ajouter les dépendances Hibernate au projet** (via Maven, Gradle, etc.).
2. **Créer le fichier de configuration `hibernate.cfg.xml`**.
3. **Définir les mappings entre les classes Java et les tables de la base de données**.

**Exemple de `hibernate.cfg.xml` :**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!-- Connexion à la base de données -->
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/maBaseDeDonnees</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>

        <!-- Dialecte SQL -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>

        <!-- Afficher les requêtes SQL -->
        <property name="show_sql">true</property>

        <!-- Mappings -->
        <mapping class="com.example.Employe"/>
    </session-factory>
</hibernate-configuration>
```

### 4.3 Mapping des Entités

Chaque classe Java représentant une table de la base de données doit être annotée pour définir les mappings.

**Exemple de classe `Employe` :**

```java
package com.example;

import javax.persistence.*;

@Entity
@Table(name = "Employes")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Nom", nullable = false)
    private String nom;
    
    @Column(name = "Poste")
    private String poste;
    
    @Column(name = "Salaire")
    private double salaire;

    // Constructors
    public Employe() {}

    public Employe(String nom, String poste, double salaire) {
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
    
    @Override
    public String toString() {
        return "Employe [id=" + id + ", nom=" + nom + ", poste=" + poste + ", salaire=" + salaire + "]";
    }
}
```

### 4.4 Opérations CRUD avec Hibernate

**Exemple d'opérations CRUD avec Hibernate :**

```java
package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCRUD {
    public static void main(String[] args) {
        // Créer le SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employe.class).buildSessionFactory();
        
        try (factory) {
            // CREATE
            Session sessionCreate = factory.getCurrentSession();
            sessionCreate.beginTransaction();
            
            Employe employe = new Employe("Fiona", "Consultante", 70000);
            sessionCreate.save(employe);
            
            sessionCreate.getTransaction().commit();
            System.out.println("Employé ajouté : " + employe);
            
            // READ
            Session sessionRead = factory.getCurrentSession();
            sessionRead.beginTransaction();
            
            List<Employe> employes = sessionRead.createQuery("from Employe").getResultList();
            for (Employe emp : employes) {
                System.out.println(emp);
            }
            
            sessionRead.getTransaction().commit();
            
            // UPDATE
            Session sessionUpdate = factory.getCurrentSession();
            sessionUpdate.beginTransaction();
            
            Employe employeToUpdate = sessionUpdate.get(Employe.class, employe.getId());
            employeToUpdate.setSalaire(75000);
            sessionUpdate.update(employeToUpdate);
            
            sessionUpdate.getTransaction().commit();
            System.out.println("Salaire mis à jour pour : " + employeToUpdate);
            
            // DELETE
            Session sessionDelete = factory.getCurrentSession();
            sessionDelete.beginTransaction();
            
            Employe employeToDelete = sessionDelete.get(Employe.class, employe.getId());
            sessionDelete.delete(employeToDelete);
            
            sessionDelete.getTransaction().commit();
            System.out.println("Employé supprimé : " + employeToDelete);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 5. Comparaison entre JDBC et Hibernate

| **Caractéristique**      | **JDBC**                              | **Hibernate**                                |
|--------------------------|---------------------------------------|----------------------------------------------|
| **Niveau d'Abstraction** | Bas niveau                            | Haut niveau                                  |
| **Boilerplate Code**     | Beaucoup de code répétitif            | Réduit le code répétitif grâce à l'ORM        |
| **Gestion des Transactions** | Manuelle                           | Automatique avec gestion intégrée des transactions |
| **Mapping Objet-Relation** | Manuel                             | Automatisé avec annotations ou XML            |
| **Performance**          | Peut être optimisé avec soin          | Optimisé par défaut mais peut nécessiter des réglages |
| **Portabilité**          | Dépend du code SQL spécifique         | Plus portable grâce au mapping abstrait       |
| **Support des Relations** | Nécessite des jointures explicites   | Gère automatiquement les relations entre les entités |
| **Courbe d'Apprentissage** | Relativement simple                 | Peut être plus complexe à maîtriser           |

**Conclusion :**  
JDBC offre un contrôle fin sur les opérations de base de données mais nécessite plus de code et une gestion manuelle. Hibernate simplifie grandement la gestion des données en fournissant un niveau d'abstraction plus élevé, réduisant ainsi le code boilerplate et facilitant les opérations complexes.

## 6. Bonnes Pratiques pour la Gestion des Données

- **Utiliser les PreparedStatements** : Pour prévenir les attaques par injection SQL et optimiser les performances.
- **Gérer les Transactions** : Assurer la cohérence des données en utilisant des transactions appropriées.
- **Fermer les Ressources** : Toujours fermer les connexions, statements et resultsets pour éviter les fuites de ressources.
- **Utiliser un Pool de Connexions** : Optimiser la gestion des connexions en réutilisant les connexions existantes.
- **Utiliser des Frameworks ORM** : Simplifier la gestion des données et réduire le code boilerplate avec des frameworks comme Hibernate.
- **Valider les Entrées** : Toujours valider les données entrantes avant de les stocker dans la base de données.
- **Optimiser les Requêtes SQL** : Écrire des requêtes efficaces pour améliorer les performances.
- **Sécuriser les Données** : Utiliser des mécanismes de chiffrement et des contrôles d'accès appropriés.

## 7. Exemples Pratiques

### Exemple 1 : Application de Gestion de Produits avec JDBC

```java
import java.sql.*;

public class GestionProduitsJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/maBaseDeDonnees";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "password";

    public static void main(String[] args) {
        try (Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            // CREATE
            String insertSQL = "INSERT INTO Produits (Nom, Prix, Quantite) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connexion.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Laptop");
                pstmt.setDouble(2, 1200.50);
                pstmt.setInt(3, 10);
                pstmt.executeUpdate();
                System.out.println("Produit ajouté.");
            }

            // READ
            String selectSQL = "SELECT * FROM Produits";
            try (Statement stmt = connexion.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("ID") + " - " + rs.getString("Nom") + " - " + rs.getDouble("Prix") + " - " + rs.getInt("Quantite"));
                }
            }

            // UPDATE
            String updateSQL = "UPDATE Produits SET Quantite = ? WHERE Nom = ?";
            try (PreparedStatement pstmt = connexion.prepareStatement(updateSQL)) {
                pstmt.setInt(1, 15);
                pstmt.setString(2, "Laptop");
                pstmt.executeUpdate();
                System.out.println("Quantité mise à jour.");
            }

            // DELETE
            String deleteSQL = "DELETE FROM Produits WHERE Nom = ?";
            try (PreparedStatement pstmt = connexion.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Laptop");
                pstmt.executeUpdate();
                System.out.println("Produit supprimé.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

### Exemple 2 : Application de Gestion des Utilisateurs avec Hibernate

**Classe `Utilisateur` :**

```java
package com.example;

import javax.persistence.*;

@Entity
@Table(name = "Utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Nom", nullable = false)
    private String nom;
    
    @Column(name = "Email", unique = true)
    private String email;

    // Constructors
    public Utilisateur() {}

    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + "]";
    }
}
```

**Application Hibernate (`GestionUtilisateursHibernate.java`):**

```java
package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GestionUtilisateursHibernate {
    public static void main(String[] args) {
        // Créer le SessionFactory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Utilisateur.class).buildSessionFactory();
        
        try (factory) {
            // CREATE
            Session sessionCreate = factory.getCurrentSession();
            sessionCreate.beginTransaction();
            
            Utilisateur user = new Utilisateur("Grace", "grace@example.com");
            sessionCreate.save(user);
            
            sessionCreate.getTransaction().commit();
            System.out.println("Utilisateur ajouté : " + user);
            
            // READ
            Session sessionRead = factory.getCurrentSession();
            sessionRead.beginTransaction();
            
            List<Utilisateur> utilisateurs = sessionRead.createQuery("from Utilisateur").getResultList();
            for (Utilisateur u : utilisateurs) {
                System.out.println(u);
            }
            
            sessionRead.getTransaction().commit();
            
            // UPDATE
            Session sessionUpdate = factory.getCurrentSession();
            sessionUpdate.beginTransaction();
            
            Utilisateur userToUpdate = sessionUpdate.get(Utilisateur.class, user.getId());
            userToUpdate.setEmail("grace.new@example.com");
            sessionUpdate.update(userToUpdate);
            
            sessionUpdate.getTransaction().commit();
            System.out.println("Email mis à jour pour : " + userToUpdate);
            
            // DELETE
            Session sessionDelete = factory.getCurrentSession();
            sessionDelete.beginTransaction();
            
            Utilisateur userToDelete = sessionDelete.get(Utilisateur.class, user.getId());
            sessionDelete.delete(userToDelete);
            
            sessionDelete.getTransaction().commit();
            System.out.println("Utilisateur supprimé : " + userToDelete);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 8. Exercices

### Exercice 1 : Création d'une Application de Gestion des Étudiants avec JDBC

1. **Créer une base de données `Universite` avec une table `Etudiants` contenant les colonnes : `ID`, `Nom`, `Prenom`, `Age`, `Filiere`.**
2. **Écrire un programme Java utilisant JDBC pour effectuer les opérations CRUD sur la table `Etudiants`.**
3. **Ajouter des fonctionnalités pour rechercher des étudiants par nom ou par filière.**
4. **Implémenter une gestion des exceptions appropriée.**
5. **Optimiser les requêtes SQL pour de meilleures performances.**

### Exercice 2 : Utilisation de Hibernate pour une Application de Gestion des Produits

1. **Créer une classe `Produit` mappée à une table `Produits` avec les attributs `id`, `nom`, `prix`, `quantite`.**
2. **Configurer Hibernate avec `hibernate.cfg.xml` pour se connecter à votre base de données.**
3. **Écrire un programme Java pour ajouter, lire, mettre à jour et supprimer des produits en utilisant Hibernate.**
4. **Mettre en place des validations pour les attributs (par exemple, le prix ne doit pas être négatif).**
5. **Afficher les produits dans l'ordre croissant de prix.**

### Exercice 3 : Migration de JDBC vers Hibernate

1. **Créer une application Java utilisant JDBC pour gérer une base de données de bibliothèques avec des tables `Livres` et `Auteurs`.**
2. **Migrer l'application pour utiliser Hibernate à la place de JDBC.**
3. **Configurer les mappings entre les entités `Livre` et `Auteur`.**
4. **Optimiser les requêtes pour minimiser les accès à la base de données.**
5. **Ajouter des fonctionnalités avancées telles que la pagination et les tris.**

## 9. Conclusion

La gestion des données est un aspect essentiel du développement d'applications Java. **JDBC** offre une méthode directe et flexible pour interagir avec les bases de données, tandis que **Hibernate** simplifie cette interaction en fournissant un niveau d'abstraction plus élevé grâce à l'ORM. En comprenant les différences entre ces outils et en maîtrisant leurs utilisations, vous pouvez choisir la meilleure approche en fonction des besoins de votre projet.

L'adoption de bonnes pratiques, comme l'utilisation de pools de connexions et la validation des données, garantit que vos applications sont performantes, sécurisées et maintenables. N'hésitez pas à explorer davantage ces outils et à les intégrer dans vos projets pour renforcer vos compétences en gestion des données en Java.
