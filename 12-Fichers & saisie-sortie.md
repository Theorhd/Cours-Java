# 12 - Fichier et Saisie-Sortie en Java

Bienvenue dans le douzième chapitre de notre cours Java, consacré à la **gestion des fichiers et aux opérations de saisie-sortie (I/O)**. La lecture et l'écriture de fichiers sont des tâches courantes dans le développement d'applications, permettant de stocker des données de manière persistante, de charger des configurations, de manipuler des fichiers texte, et bien plus encore. Dans ce chapitre, nous explorerons les différentes classes et API offertes par Java pour gérer les opérations de fichiers et de saisie-sortie, ainsi que des exemples pratiques pour illustrer leur utilisation.

## Table des Matières

1. [Introduction à la Saisie-Sortie en Java](#1-introduction-à-la-saisie-sortie-en-java)
2. [Manipulation des Fichiers avec `java.io`](#2-manipulation-des-fichiers-avec-javaio)
    - 2.1 [Classes de Base pour les Fichiers](#21-classes-de-base-pour-les-fichiers)
    - 2.2 [Lire et Écrire des Fichiers Texte](#22-lire-et-écrire-des-fichiers-texte)
    - 2.3 [Lire et Écrire des Fichiers Binaires](#23-lire-et-écrire-des-fichiers-binaires)
3. [NIO : New I/O (`java.nio`)](#3-nio-new-io-java.nio)
    - 3.1 [Introduction à NIO](#31-introduction-à-nio)
    - 3.2 [Classe `Path` et `Files`](#32-classe-path-et-files)
    - 3.3 [Lecture et Écriture avec NIO](#33-lecture-et-écriture-avec-nio)
    - 3.4 [Gestion des Canaux et Buffers](#34-gestion-des-canaux-et-buffers)
4. [Saisie et Sortie Standard](#4-saisie-et-sortie-standard)
    - 4.1 [Utilisation de `System.in` et `System.out`](#41-utilisation-de-systemin-et-systemout)
    - 4.2 [Scanner pour la Saisie Utilisateur](#42-scanner-pour-la-saisie-utilisateur)
    - 4.3 [Formatage de la Sortie avec `PrintStream`](#43-formatage-de-la-sortie-avec-printstream)
5. [Gestion des Exceptions I/O](#5-gestion-des-exceptions-io)
    - 5.1 [Types d'Exceptions I/O](#51-types-dexceptions-io)
    - 5.2 [Gestion avec `try-with-resources`](#52-gestion-avec-try-with-resources)
6. [Bonnes Pratiques pour la Gestion des Fichiers et I/O](#6-bonnes-pratiques-pour-la-gestion-des-fichiers-et-io)
7. [Exemples Pratiques](#7-exemples-pratiques)
8. [Exercices](#8-exercices)
9. [Conclusion](#9-conclusion)

---

## 1. Introduction à la Saisie-Sortie en Java

La **saisie-sortie (I/O)** en Java englobe toutes les opérations liées à l'entrée et à la sortie de données. Cela inclut la lecture et l'écriture de fichiers, la communication réseau, et l'interaction avec les périphériques. Java propose deux principaux packages pour gérer les I/O :

- **`java.io`** : Fournit des classes de bas niveau pour manipuler les flux de données.
- **`java.nio`** (New I/O) : Introduit dans Java 1.4, offre des fonctionnalités plus avancées et performantes, telles que le traitement non bloquant et la gestion efficace des canaux de données.

Ce chapitre se concentrera principalement sur la manipulation des fichiers et les opérations de saisie-sortie standard.

## 2. Manipulation des Fichiers avec `java.io`

### 2.1 Classes de Base pour les Fichiers

Le package **`java.io`** fournit plusieurs classes essentielles pour la gestion des fichiers :

- **`File`** : Représente un fichier ou un répertoire dans le système de fichiers.
- **`FileReader` et `FileWriter`** : Pour la lecture et l'écriture de fichiers texte.
- **`BufferedReader` et `BufferedWriter`** : Pour la lecture et l'écriture efficaces avec tampon.
- **`FileInputStream` et `FileOutputStream`** : Pour la lecture et l'écriture de fichiers binaires.
- **`DataInputStream` et `DataOutputStream`** : Pour lire et écrire des données primitives.
- **`ObjectInputStream` et `ObjectOutputStream`** : Pour la sérialisation et la désérialisation d'objets.

### 2.2 Lire et Écrire des Fichiers Texte

**Lecture de fichiers texte avec `BufferedReader` :**

```java
import java.io.*;

public class LectureFichierTexte {
    public static void main(String[] args) {
        String cheminFichier = "exemple.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Écriture dans des fichiers texte avec `BufferedWriter` :**

```java
import java.io.*;

public class EcritureFichierTexte {
    public static void main(String[] args) {
        String cheminFichier = "exemple.txt";
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(cheminFichier, true))) { // 'true' pour append
            bw.write("Nouvelle ligne de texte.");
            bw.newLine();
            bw.write("Une autre ligne de texte.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2.3 Lire et Écrire des Fichiers Binaires

**Lecture de fichiers binaires avec `FileInputStream` :**

```java
import java.io.*;

public class LectureFichierBinaire {
    public static void main(String[] args) {
        String cheminFichier = "image.png";
        
        try (FileInputStream fis = new FileInputStream(cheminFichier)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Traiter les données lues
                System.out.println("Lu " + bytesRead + " bytes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Écriture dans des fichiers binaires avec `FileOutputStream` :**

```java
import java.io.*;

public class EcritureFichierBinaire {
    public static void main(String[] args) {
        String cheminFichier = "nouvelleImage.png";
        byte[] donnees = { (byte)0x89, 0x50, 0x4E, 0x47 }; // Example bytes (PNG header)
        
        try (FileOutputStream fos = new FileOutputStream(cheminFichier)) {
            fos.write(donnees);
            System.out.println("Données écrites dans le fichier binaire.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 3. NIO : New I/O (`java.nio`)

### 3.1 Introduction à NIO

**NIO** (New I/O), introduit dans Java 1.4 et amélioré dans les versions suivantes, offre des fonctionnalités avancées pour les opérations de saisie-sortie, notamment :

- **Canaux (Channels)** : Représentent des connexions vers des entités telles que les fichiers ou les sockets.
- **Buffers** : Stockent les données à transférer via les canaux.
- **Selectors** : Permettent de gérer plusieurs canaux en utilisant une seule thread (I/O non bloquant).

### 3.2 Classe `Path` et `Files`

Le package **`java.nio.file`** introduit la classe `Path` pour représenter les chemins de fichiers et la classe `Files` pour effectuer des opérations courantes sur les fichiers.

**Exemple d'utilisation de `Path` et `Files` :**

```java
import java.nio.file.*;

public class PathFilesExample {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        
        // Vérifier si le fichier existe
        if (Files.exists(chemin)) {
            System.out.println("Le fichier existe.");
        } else {
            System.out.println("Le fichier n'existe pas.");
        }
        
        // Créer un fichier
        try {
            Files.createFile(Paths.get("nouveauFichier.txt"));
            System.out.println("Fichier créé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Supprimer un fichier
        try {
            Files.delete(Paths.get("nouveauFichier.txt"));
            System.out.println("Fichier supprimé.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 3.3 Lecture et Écriture avec NIO

**Lecture de fichiers avec NIO :**

```java
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class LectureNIO {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple.txt");
        
        try {
            List<String> lignes = Files.readAllLines(chemin);
            for (String ligne : lignes) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**Écriture de fichiers avec NIO :**

```java
import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;

public class EcritureNIO {
    public static void main(String[] args) {
        Path chemin = Paths.get("exemple_nio.txt");
        List<String> lignes = Arrays.asList("Ligne 1 avec NIO", "Ligne 2 avec NIO");
        
        try {
            Files.write(chemin, lignes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Données écrites avec NIO.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 3.4 Gestion des Canaux et Buffers

**Exemple de copie de fichier avec Canaux et Buffers :**

```java
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopieFichierNIO {
    public static void main(String[] args) {
        String source = "source.txt";
        String destination = "destination.txt";
        
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination);
             FileChannel sourceChannel = fis.getChannel();
             FileChannel destChannel = fos.getChannel()) {
             
             destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
             System.out.println("Fichier copié avec succès.");
             
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 4. Saisie et Sortie Standard

### 4.1 Utilisation de `System.in` et `System.out`

Java fournit les flux standards `System.in`, `System.out` et `System.err` pour l'entrée et la sortie de données.

**Exemple de lecture depuis `System.in` :**

```java
import java.io.IOException;

public class LectureSystemIn {
    public static void main(String[] args) {
        System.out.print("Entrez une ligne de texte : ");
        try {
            int data = System.in.read();
            while (data != -1 && data != '\n') {
                System.out.print((char) data);
                data = System.in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 4.2 Scanner pour la Saisie Utilisateur

La classe **`Scanner`** simplifie la lecture des entrées utilisateur depuis différents supports, y compris `System.in`.

**Exemple d'utilisation de `Scanner` :**

```java
import java.util.Scanner;

public class UtilisationScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        
        System.out.print("Entrez votre âge : ");
        int age = scanner.nextInt();
        
        System.out.println("Bonjour, " + nom + ". Vous avez " + age + " ans.");
        
        scanner.close();
    }
}
```

### 4.3 Formatage de la Sortie avec `PrintStream`

La classe **`PrintStream`** permet de formater les sorties, par exemple en affichant des nombres avec un nombre précis de décimales.

**Exemple d'utilisation de `PrintStream` :**

```java
import java.io.PrintStream;

public class FormatageSortie {
    public static void main(String[] args) {
        double valeur = 1234.56789;
        
        // Afficher avec 2 décimales
        System.out.printf("Valeur formatée : %.2f%n", valeur);
        
        // Utiliser PrintStream directement
        PrintStream ps = System.out;
        ps.printf("Valeur formatée avec PrintStream : %.3f%n", valeur);
    }
}
```

## 5. Gestion des Exceptions I/O

### 5.1 Types d'Exceptions I/O

Les exceptions courantes dans les opérations I/O incluent :

- **`FileNotFoundException`** : Lorsqu'un fichier spécifié est introuvable.
- **`IOException`** : Pour les erreurs d'entrée-sortie génériques.
- **`EOFException`** : Lorsqu'une fin de fichier est atteinte de manière inattendue.

### 5.2 Gestion avec `try-with-resources`

Introduite dans Java 7, la déclaration **`try-with-resources`** simplifie la gestion des ressources en les fermant automatiquement après utilisation.

**Exemple :**

```java
import java.io.*;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        String cheminFichier = "exemple.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 6. Bonnes Pratiques pour la Gestion des Fichiers et I/O

- **Utiliser `try-with-resources`** : Pour garantir la fermeture des ressources automatiquement.
- **Valider les Chemins de Fichiers** : Vérifier l'existence et l'accès aux fichiers avant de les manipuler.
- **Gérer les Exceptions Appropriately** : Fournir des messages d'erreur clairs et des mesures correctives.
- **Optimiser les Lectures et Écritures** : Utiliser des classes tamponnées (`BufferedReader`, `BufferedWriter`) pour améliorer les performances.
- **Sécuriser les I/O** : Protéger les fichiers sensibles avec des autorisations appropriées et éviter les injections de chemin.
- **Utiliser des API Modernes** : Privilégier NIO pour des opérations plus performantes et flexibles.
- **Documenter le Code** : Ajouter des commentaires pour expliquer les opérations de I/O complexes.
- **Tester les Opérations de Fichier** : Assurer que les opérations fonctionnent correctement dans différents environnements.

## 7. Exemples Pratiques

### Exemple 1 : Lecture et Écriture de Fichiers Log avec `java.io`

```java
import java.io.*;

public class GestionLogs {
    public static void main(String[] args) {
        String fichierLog = "app.log";
        
        // Écriture dans le fichier log
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichierLog, true))) {
            bw.write("Application démarrée.");
            bw.newLine();
            bw.write("Une opération a été effectuée.");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lecture du fichier log
        try (BufferedReader br = new BufferedReader(new FileReader(fichierLog))) {
            String ligne;
            System.out.println("Contenu du fichier log :");
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Exemple 2 : Copie de Fichiers avec NIO

```java
import java.nio.file.*;

public class CopieFichierNIO {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path destination = Paths.get("destination.txt");
        
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Fichier copié avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Exemple 3 : Application de Suivi des Utilisateurs avec Saisie Utilisateur

```java
import java.util.*;
import java.io.*;

public class SuiviUtilisateurs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> utilisateurs = new ArrayList<>();
        String fichier = "utilisateurs.txt";
        
        // Charger les utilisateurs existants
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                utilisateurs.add(ligne);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier utilisateur non trouvé. Création d'un nouveau fichier.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Interaction utilisateur
        System.out.println("Bienvenue dans l'application de suivi des utilisateurs.");
        boolean continuer = true;
        while (continuer) {
            System.out.println("1. Ajouter un utilisateur");
            System.out.println("2. Afficher tous les utilisateurs");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");
            
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne
            
            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom de l'utilisateur : ");
                    String nom = scanner.nextLine();
                    utilisateurs.add(nom);
                    // Écriture dans le fichier
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichier, true))) {
                        bw.write(nom);
                        bw.newLine();
                        System.out.println("Utilisateur ajouté.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Liste des utilisateurs :");
                    for (String user : utilisateurs) {
                        System.out.println(user);
                    }
                    break;
                case 3:
                    continuer = false;
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
        
        scanner.close();
        System.out.println("Application terminée.");
    }
}
```

## 8. Exercices

### Exercice 1 : Création d'une Application de Gestion de Notes avec `java.io`

1. **Créer une classe `Note` avec les attributs `id`, `nomEtudiant`, `matiere`, et `note`.**
2. **Écrire un programme Java qui permet d'ajouter, de lire, de mettre à jour et de supprimer des notes stockées dans un fichier texte `notes.txt`.**
3. **Utiliser `BufferedReader` et `BufferedWriter` pour la lecture et l'écriture.**
4. **Assurer la gestion correcte des exceptions et la fermeture des ressources.**
5. **Ajouter une fonctionnalité pour calculer la moyenne des notes d'un étudiant.**

### Exercice 2 : Manipulation de Fichiers avec NIO

1. **Écrire un programme Java qui recherche tous les fichiers `.txt` dans un répertoire donné et les copie dans un autre répertoire.**
2. **Utiliser les classes `Path`, `Files` et les méthodes de NIO pour réaliser ces opérations.**
3. **Implémenter une gestion des erreurs appropriée (par exemple, si un fichier existe déjà dans le répertoire de destination).**
4. **Afficher un résumé des opérations effectuées (nombre de fichiers copiés, erreurs rencontrées, etc.).**

### Exercice 3 : Création d'un Système de Log avec Saisie Standard

1. **Créer une application Java qui prend des messages de l'utilisateur via la console et les enregistre dans un fichier log `app.log`.**
2. **Utiliser la classe `Scanner` pour la saisie et `PrintWriter` pour l'écriture dans le fichier.**
3. **Ajouter une option pour afficher le contenu actuel du fichier log.**
4. **Implémenter une commande spéciale (par exemple, `exit`) pour terminer l'application.**
5. **Assurer la gestion des exceptions et la fermeture des ressources.**

## 9. Conclusion

La gestion des fichiers et les opérations de saisie-sortie sont des éléments cruciaux dans le développement d'applications Java, permettant de stocker, de récupérer et de manipuler des données de manière efficace. Les classes fournies par les packages **`java.io`** et **`java.nio`** offrent une vaste gamme d'outils pour répondre à divers besoins en matière de I/O.

En maîtrisant ces outils, vous serez capable de développer des applications robustes capables de gérer des données persistantes, de communiquer avec les utilisateurs via la console, et d'interagir avec le système de fichiers de manière sécurisée et performante. N'oubliez pas d'appliquer régulièrement vos connaissances à travers des exercices pratiques et des projets concrets pour renforcer votre compréhension et votre expertise en gestion des fichiers et I/O en Java.

---
```
