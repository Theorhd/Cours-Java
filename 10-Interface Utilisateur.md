# 10 - Interface Utilisateur en Java

Bienvenue dans le dixième chapitre de notre cours Java, dédié à la **création d'interfaces utilisateur**. Les interfaces utilisateur (UI) permettent aux utilisateurs d'interagir avec vos applications de manière intuitive et conviviale. En Java, plusieurs bibliothèques facilitent la création d'interfaces graphiques, parmi lesquelles **Swing** et **JavaFX** sont les plus couramment utilisées. Dans ce chapitre, nous explorerons ces bibliothèques, leurs fonctionnalités, et comment les utiliser pour développer des applications interactives.

## Table des Matières

1. [Introduction aux Interfaces Utilisateur](#1-introduction-aux-interfaces-utilisateur)
2. [Bibliothèques Java pour les Interfaces Utilisateur](#2-bibliothèques-java-pour-les-interfaces-utilisateur)
    - 2.1 [Swing](#21-swing)
    - 2.2 [JavaFX](#22-javafx)
3. [Création d'une Interface Simple avec Swing](#3-création-dune-interface-simple-avec-swing)
    - 3.1 [Structure de Base d'une Application Swing](#31-structure-de-base-dune-application-swing)
    - 3.2 [Composants de Base](#32-composants-de-base)
    - 3.3 [Gestion des Événements](#33-gestion-des-événements)
4. [Création d'une Interface avec JavaFX](#4-création-dune-interface-avec-javafx)
    - 4.1 [Structure de Base d'une Application JavaFX](#41-structure-de-base-dune-application-javafx)
    - 4.2 [Composants de Base](#42-composants-de-base)
    - 4.3 [Gestion des Événements](#43-gestion-des-événements)
5. [Comparaison entre Swing et JavaFX](#5-comparaison-entre-swing-et-javafx)
6. [Bonnes Pratiques pour la Création d'Interfaces Utilisateur](#6-bonnes-pratiques-pour-la-création-dinterfaces-utilisateur)
7. [Exemples Pratiques](#7-exemples-pratiques)
8. [Exercices](#8-exercices)
9. [Conclusion](#9-conclusion)

---

## 1. Introduction aux Interfaces Utilisateur

Une **interface utilisateur (UI)** est la couche de votre application avec laquelle les utilisateurs interagissent directement. Elle comprend les éléments graphiques tels que les fenêtres, les boutons, les champs de texte, etc. Une UI bien conçue améliore l'expérience utilisateur (UX) et facilite l'utilisation de l'application.

En Java, plusieurs bibliothèques permettent de créer des interfaces graphiques, chacune ayant ses propres avantages et inconvénients. **Swing** et **JavaFX** sont les deux principales bibliothèques utilisées pour le développement d'applications GUI en Java.

## 2. Bibliothèques Java pour les Interfaces Utilisateur

### 2.1 Swing

**Swing** est une bibliothèque GUI mature qui fait partie de la bibliothèque standard de Java depuis la version 1.2. Elle offre une large gamme de composants graphiques et permet une grande personnalisation de l'apparence et du comportement des interfaces.

**Caractéristiques de Swing :**
- **Composants Riches** : Boutons, labels, tables, arbres, onglets, etc.
- **Pluggable Look and Feel** : Possibilité de changer l'apparence de l'UI sans modifier le code source.
- **Support des Événements** : Gestion des interactions utilisateur via des listeners.
- **Personnalisation** : Création de composants personnalisés.

**Limitations de Swing :**
- **Performance** : Peut être moins performant avec des interfaces très complexes.
- **Modernité** : L'apparence par défaut peut sembler datée par rapport aux applications modernes.

### 2.2 JavaFX

**JavaFX** est une bibliothèque GUI moderne introduite dans Java 8. Elle est conçue pour remplacer Swing, offrant des fonctionnalités avancées et une meilleure intégration avec les technologies actuelles.

**Caractéristiques de JavaFX :**
- **Scène Graph** : Modèle basé sur une hiérarchie d'objets graphiques.
- **CSS Styling** : Personnalisation de l'apparence via CSS.
- **Animations et Effets** : Support natif pour les animations et les effets visuels.
- **Intégration Multimédia** : Support de l'audio, de la vidéo et des graphiques vectoriels.
- **FXML** : Langage XML pour définir l'interface utilisateur séparément du code Java.

**Avantages de JavaFX :**
- **Modernité** : Apparence et fonctionnalités alignées avec les standards actuels.
- **Performance** : Meilleure gestion des ressources graphiques.
- **Flexibilité** : Facilité d'intégration avec d'autres technologies.

## 3. Création d'une Interface Simple avec Swing

### 3.1 Structure de Base d'une Application Swing

Une application Swing typique comporte les éléments suivants :
- **JFrame** : La fenêtre principale de l'application.
- **JPanel** : Conteneur pour organiser les composants.
- **Composants Swing** : Boutons, labels, champs de texte, etc.
- **Gestion des Événements** : Répondre aux interactions utilisateur.

**Exemple de base :**

```java
import javax.swing.*;

public class MaPremiereAppSwing {
    public static void main(String[] args) {
        // Création du JFrame
        JFrame frame = new JFrame("Ma Première Application Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Création d'un JPanel
        JPanel panel = new JPanel();
        
        // Ajout d'un composant JButton
        JButton bouton = new JButton("Cliquez-moi!");
        panel.add(bouton);
        
        // Ajout du panel au frame
        frame.add(panel);
        
        // Rendre le frame visible
        frame.setVisible(true);
    }
}
```

### 3.2 Composants de Base

Swing propose une variété de composants graphiques, dont :

- **JButton** : Bouton cliquable.
- **JLabel** : Affiche du texte ou des images.
- **JTextField** : Champ de saisie de texte.
- **JTextArea** : Zone de texte multilignes.
- **JCheckBox** : Case à cocher.
- **JRadioButton** : Bouton radio.
- **JComboBox** : Liste déroulante.
- **JTable** : Tableau de données.
- **JTree** : Arbre hiérarchique.

**Exemple d'utilisation de plusieurs composants :**

```java
import javax.swing.*;
import java.awt.*;

public class InterfaceSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface Swing Avancée");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel labelNom = new JLabel("Nom :");
        JTextField champNom = new JTextField();
        
        JLabel labelAge = new JLabel("Âge :");
        JTextField champAge = new JTextField();
        
        JButton boutonSoumettre = new JButton("Soumettre");
        
        panel.add(labelNom);
        panel.add(champNom);
        panel.add(labelAge);
        panel.add(champAge);
        panel.add(new JLabel()); // Espace vide
        panel.add(boutonSoumettre);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
```

### 3.3 Gestion des Événements

Swing utilise le modèle d'écouteur (**Listener**) pour gérer les événements utilisateur tels que les clics de bouton, les sélections, etc.

**Exemple de gestion d'événements avec un JButton :**

```java
import javax.swing.*;
import java.awt.event.*;

public class GestionEvenementsSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion des Événements Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JButton bouton = new JButton("Cliquez-moi!");
        
        // Ajout d'un ActionListener au bouton
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Bouton cliqué!");
            }
        });
        
        frame.getContentPane().add(bouton);
        frame.setVisible(true);
    }
}
```

## 4. Création d'une Interface avec JavaFX

### 4.1 Structure de Base d'une Application JavaFX

Une application JavaFX suit une structure de base comprenant les éléments suivants :
- **Stage** : La fenêtre principale.
- **Scene** : Conteneur pour les éléments graphiques.
- **Nodes** : Composants graphiques individuels (boutons, labels, etc.).
- **Layout Managers** : Gestion de la disposition des Nodes.

**Exemple de base :**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MaPremiereAppJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ma Première Application JavaFX");
        
        Button bouton = new Button("Cliquez-moi!");
        bouton.setOnAction(e -> System.out.println("Bouton cliqué!"));
        
        StackPane root = new StackPane();
        root.getChildren().add(bouton);
        
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### 4.2 Composants de Base

JavaFX propose une large gamme de composants graphiques, notamment :

- **Button** : Bouton cliquable.
- **Label** : Affiche du texte.
- **TextField** : Champ de saisie de texte.
- **TextArea** : Zone de texte multilignes.
- **CheckBox** : Case à cocher.
- **RadioButton** : Bouton radio.
- **ComboBox** : Liste déroulante.
- **TableView** : Tableau de données.
- **TreeView** : Arbre hiérarchique.

**Exemple d'utilisation de plusieurs composants :**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InterfaceJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interface JavaFX Avancée");
        
        Label labelNom = new Label("Nom :");
        TextField champNom = new TextField();
        
        Label labelAge = new Label("Âge :");
        TextField champAge = new TextField();
        
        Button boutonSoumettre = new Button("Soumettre");
        boutonSoumettre.setOnAction(e -> {
            String nom = champNom.getText();
            String age = champAge.getText();
            System.out.println("Nom : " + nom + ", Âge : " + age);
        });
        
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.add(labelNom, 0, 0);
        grid.add(champNom, 1, 0);
        grid.add(labelAge, 0, 1);
        grid.add(champAge, 1, 1);
        grid.add(boutonSoumettre, 1, 2);
        
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### 4.3 Gestion des Événements

JavaFX utilise des **gestionnaires d'événements** (event handlers) pour répondre aux interactions utilisateur.

**Exemple de gestion d'événements avec un Button :**

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GestionEvenementsJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Événements JavaFX");
        
        Button bouton = new Button("Cliquez-moi!");
        bouton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Événement");
            alert.setHeaderText(null);
            alert.setContentText("Bouton cliqué!");
            alert.showAndWait();
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(bouton);
        
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

## 5. Comparaison entre Swing et JavaFX

| **Caractéristique**      | **Swing**                               | **JavaFX**                                 |
|--------------------------|-----------------------------------------|--------------------------------------------|
| **Date de sortie**       | 1998                                    | 2008                                       |
| **Modèle de rendu**      | Basé sur AWT                            | Basé sur une scène graphique moderne       |
| **Styling**              | Limitations avec Look and Feel          | Styling avancé avec CSS                    |
| **Animations**           | Nécessite des bibliothèques externes    | Support natif des animations               |
| **FXML**                 | Non pris en charge                      | Pris en charge pour la définition d'UI     |
| **Performance**          | Moins performant avec des interfaces lourdes | Meilleure gestion des ressources graphiques |
| **Support multimédia**   | Limité                                  | Support avancé (audio, vidéo, etc.)        |
| **Modularité**           | Moins modulaire                         | Hautement modulaire                        |
| **Apprentissage**        | Simpler pour des petites applications   | Plus riche mais peut être plus complexe     |

**Conclusion :**  
Swing est adapté pour des applications simples ou existantes nécessitant un maintien, tandis que JavaFX est recommandé pour de nouvelles applications nécessitant une interface moderne et riche en fonctionnalités.

## 6. Bonnes Pratiques pour la Création d'Interfaces Utilisateur

- **Séparation de la Logique et de l'UI** : Utilisez des modèles tels que MVC (Modèle-Vue-Contrôleur) pour séparer la logique métier de l'interface utilisateur.
- **Consistance Visuelle** : Maintenez une apparence cohérente à travers toute l'application.
- **Accessibilité** : Assurez-vous que l'application est utilisable par tous les utilisateurs, y compris ceux ayant des handicaps.
- **Performance** : Optimisez les composants UI pour éviter les ralentissements.
- **Responsiveness** : Créez des interfaces réactives qui s'adaptent à différentes résolutions et tailles d'écran.
- **Gestion des Événements** : Gérez efficacement les événements pour une expérience utilisateur fluide.
- **Commentaires et Documentation** : Documentez le code UI pour faciliter la maintenance et l'évolution.

## 7. Exemples Pratiques

### Exemple 1 : Application de Gestion de Contacts avec Swing

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GestionContactsSwing {
    private JFrame frame;
    private JTextField champNom;
    private JTextField champEmail;
    private DefaultListModel<String> listeModel;

    public GestionContactsSwing() {
        frame = new JFrame("Gestion de Contacts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel(new BorderLayout());
        
        // Zone de saisie
        JPanel saisiePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        saisiePanel.add(new JLabel("Nom:"));
        champNom = new JTextField();
        saisiePanel.add(champNom);
        saisiePanel.add(new JLabel("Email:"));
        champEmail = new JTextField();
        saisiePanel.add(champEmail);
        
        panel.add(saisiePanel, BorderLayout.NORTH);
        
        // Liste des contacts
        listeModel = new DefaultListModel<>();
        JList<String> listeContacts = new JList<>(listeModel);
        JScrollPane scrollPane = new JScrollPane(listeContacts);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Bouton Ajouter
        JButton boutonAjouter = new JButton("Ajouter Contact");
        boutonAjouter.addActionListener(e -> ajouterContact());
        panel.add(boutonAjouter, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private void ajouterContact() {
        String nom = champNom.getText().trim();
        String email = champEmail.getText().trim();
        if(!nom.isEmpty() && !email.isEmpty()) {
            listeModel.addElement(nom + " - " + email);
            champNom.setText("");
            champEmail.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionContactsSwing());
    }
}
```

### Exemple 2 : Application de To-Do List avec JavaFX

**FXML (`todo.fxml`):**
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ListView?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.VBox?>

<VBox spacing="10" padding="10" xmlns="http://javafx.com/javafx/8" xmlns:fx="http://javafx.com/fxml/1">
    <TextField fx:id="champTache" promptText="Nouvelle tâche..." />
    <Button text="Ajouter Tâche" onAction="#ajouterTache" />
    <ListView fx:id="listeTaches" />
</VBox>
```

**Contrôleur (`TodoController.java`):**
```java
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TodoController {
    @FXML
    private TextField champTache;
    
    @FXML
    private ListView<String> listeTaches;
    
    @FXML
    private void ajouterTache() {
        String tache = champTache.getText().trim();
        if(!tache.isEmpty()) {
            listeTaches.getItems().add(tache);
            champTache.clear();
        }
    }
}
```

**Application (`TodoApp.java`):**
```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("todo.fxml"));
        primaryStage.setTitle("To-Do List JavaFX");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

## 8. Exercices

### Exercice 1 : Création d'une Calculatrice avec Swing

1. **Créer une fenêtre principale avec un `JFrame`.**
2. **Ajouter un `JTextField` pour afficher les résultats.**
3. **Ajouter des boutons pour les chiffres (0-9) et les opérations (+, -, *, /).**
4. **Gérer les événements pour effectuer les calculs lorsque les boutons sont cliqués.**
5. **Ajouter un bouton "Clear" pour réinitialiser l'affichage.**

### Exercice 2 : Application de Gestion de Livres avec JavaFX

1. **Créer une interface utilisateur avec les champs `Titre`, `Auteur`, `ISBN`.**
2. **Ajouter un bouton "Ajouter" pour enregistrer les informations dans une `ListView`.**
3. **Permettre la suppression d'un livre sélectionné depuis la liste.**
4. **Utiliser FXML pour définir l'interface graphique.**
5. **Implémenter le contrôleur pour gérer les interactions.**

### Exercice 3 : Création d'un Formulaire de Connexion avec Swing

1. **Créer une fenêtre de connexion avec des champs `Nom d'utilisateur` et `Mot de passe`.**
2. **Ajouter des boutons `Connexion` et `Annuler`.**
3. **Valider les informations saisies lorsqu'un utilisateur clique sur `Connexion`.**
4. **Afficher un message de succès ou d'erreur en fonction des données entrées.**
5. **Réinitialiser les champs lorsqu'un utilisateur clique sur `Annuler`.**

## 9. Conclusion

La création d'interfaces utilisateur est une compétence essentielle pour développer des applications Java interactives et conviviales. **Swing** et **JavaFX** offrent des outils puissants pour concevoir des interfaces graphiques riches, chacune avec ses propres avantages. En maîtrisant ces bibliothèques, vous pouvez créer des applications Java attrayantes et fonctionnelles répondant aux besoins des utilisateurs.

N'oubliez pas de pratiquer régulièrement en réalisant des projets concrets et en explorant les fonctionnalités avancées de Swing et JavaFX pour approfondir votre compréhension et améliorer vos compétences en développement d'interfaces utilisateur en Java.
