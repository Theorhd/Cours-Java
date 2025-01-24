# Exercices de Java - Fin de Cours

Ces exercices sont conçus pour évaluer votre compréhension des concepts clés de Java abordés tout au long du cours. Veuillez lire attentivement chaque énoncé et implémenter les solutions en respectant les consignes.

---

## **Exercice 1 : Classes et Objets**

**Enoncé :**

Créez une classe `Livre` avec les attributs suivants :
- `titre` (String)
- `auteur` (String)
- `anneePublication` (int)

**Instructions :**
1. Définissez un constructeur qui initialise tous les attributs.
2. Implémentez les getters et setters pour chaque attribut.
3. Ajoutez une méthode `afficherDetails()` qui affiche les informations du livre de manière lisible.

**Objectifs :**
- Comprendre la définition d'une classe et de ses attributs.
- Maîtriser la création de constructeurs, getters et setters.
- Savoir implémenter des méthodes au sein d'une classe.

---

## **Exercice 2 : Héritage et Polymorphisme**

**Enoncé :**

Créez une classe de base `Animal` avec une méthode `faireDuBruit()`.

**Instructions :**
1. Définissez la classe `Animal` et la méthode `faireDuBruit()`. Cette méthode peut être abstraite ou avoir une implémentation par défaut.
2. Créez deux classes dérivées : `Chien` et `Chat`, qui héritent de `Animal`.
3. Redéfinissez la méthode `faireDuBruit()` dans chaque classe dérivée pour afficher respectivement "Le chien aboie" et "Le chat miaule".
4. Dans une classe principale (`Main`), créez un tableau ou une liste d'objets `Animal` contenant des instances de `Chien` et `Chat`.
5. Parcourez ce tableau et appelez `faireDuBruit()` pour chaque élément.

**Objectifs :**
- Comprendre le concept d'héritage en Java.
- Maîtriser le polymorphisme et la redéfinition des méthodes.
- Savoir manipuler des collections d'objets polymorphes.

---

## **Exercice 3 : Gestion des Exceptions**

**Enoncé :**

Écrivez une méthode `diviser` qui prend deux entiers en paramètres et retourne le résultat de la division du premier par le second.

**Instructions :**
1. Implémentez la méthode `diviser(int a, int b)` qui retourne un `double`.
2. Gérez l'exception `ArithmeticException` en cas de division par zéro.
3. Dans le cas d'une exception, affichez un message d'erreur approprié et retournez 0.

**Objectifs :**
- Comprendre la gestion des exceptions en Java.
- Savoir utiliser les blocs `try-catch`.
- Apprendre à prévenir les erreurs d'exécution.

---

## **Exercice 4 : Collections**

**Enoncé :**

Utilisez une `ArrayList` pour gérer une liste de noms.

**Instructions :**
1. Créez une `ArrayList<String>` et ajoutez-y au moins cinq noms.
2. Parcourez la liste et affichez chaque nom en majuscules.
3. Supprimez un nom spécifique de la liste et affichez la liste mise à jour.

**Objectifs :**
- Maîtriser l'utilisation des collections, en particulier `ArrayList`.
- Savoir manipuler les éléments d'une liste (ajout, suppression, parcours).
- Comprendre les méthodes disponibles dans les collections Java.

---

## **Exercice 5 : Streams**

**Enoncé :**

Utilisez les Streams pour traiter une liste de nombres entiers.

**Instructions :**
1. Créez une `List<Integer>` contenant une série de nombres (au moins 10).
2. Utilisez les Streams pour filtrer les nombres pairs.
3. Triez les nombres pairs par ordre croissant.
4. Affichez les résultats filtrés et triés.

**Objectifs :**
- Comprendre l'API Streams de Java.
- Savoir effectuer des opérations de filtrage et de tri.
- Apprendre à manipuler les données de manière fonctionnelle.

---

## **Exercice 6 : Interfaces et Classes Abstraites**

**Enoncé :**

Créez une interface `Volant` et implémentez-la dans différentes classes.

**Instructions :**
1. Définissez une interface `Volant` avec une méthode `voler()`.
2. Créez une classe `Oiseau` qui implémente `Volant` et définit la méthode `voler()` pour afficher "L'oiseau vole".
3. Créez une classe `Avion` qui implémente également `Volant` et définit la méthode `voler()` pour afficher "L'avion décolle".
4. Dans une classe principale, créez une liste de `Volant` contenant des instances de `Oiseau` et `Avion`.
5. Parcourez cette liste et appelez `voler()` sur chaque élément.

**Objectifs :**
- Comprendre la définition et l'utilisation des interfaces en Java.
- Savoir implémenter plusieurs classes partageant une même interface.
- Apprendre à utiliser le polymorphisme avec les interfaces.

---

## **Exercice 7 : Programmation Orientée Objet Avancée**

**Enoncé :**

Implémentez un système de gestion de comptes bancaires avec héritage.

**Instructions :**
1. Créez une classe `CompteBancaire` avec les attributs :
   - `solde` (double)
   - `numeroCompte` (String)
2. Ajoutez les méthodes suivantes :
   - `deposer(double montant)` : ajoute le montant au solde.
   - `retirer(double montant)` : retire le montant du solde s'il est suffisant, sinon affiche un message d'erreur.
   - `afficherSolde()` : affiche le solde actuel.
3. Créez une sous-classe `CompteEpargne` qui hérite de `CompteBancaire` et ajoute un attribut `tauxInteret` (double).
4. Ajoutez une méthode `appliquerInteret()` dans `CompteEpargne` qui calcule les intérêts et les ajoute au solde.
5. Dans la classe principale, créez une instance de `CompteEpargne`, effectuez des opérations de dépôt, retrait et appliquez les intérêts. Affichez le solde après chaque opération.

**Objectifs :**
- Approfondir la compréhension de l'héritage et des classes dérivées.
- Savoir ajouter des fonctionnalités spécifiques dans les sous-classes.
- Maîtriser la gestion de l'état interne des objets.

---

## **Exercice 8 : Traitement de Fichiers**

**Enoncé :**

Écrivez un programme qui lit et traite des données à partir d'un fichier texte.

**Instructions :**
1. Créez un fichier texte nommé `noms.txt` contenant une liste de noms, un par ligne.
2. Écrivez un programme Java qui :
   - Lit le contenu de `noms.txt`.
   - Stocke les noms dans une `List<String>`.
   - Trie la liste par ordre alphabétique.
   - Affiche les noms triés à l'écran.
3. Gérez les exceptions potentielles liées aux opérations de fichier (par exemple, fichier non trouvé).

**Objectifs :**
- Apprendre à lire des fichiers en Java.
- Savoir manipuler les données lues à partir d'un fichier.
- Comprendre la gestion des exceptions spécifiques aux opérations de fichier.

---

## **Exercice 9 : Programmation Générique**

**Enoncé :**

Implémentez une classe générique `Paire` qui peut stocker deux objets de types différents.

**Instructions :**
1. Créez une classe générique `Paire<T, U>` avec les attributs :
   - `premier` (T)
   - `second` (U)
2. Définissez un constructeur pour initialiser les deux attributs.
3. Implémentez les getters et setters pour chaque attribut.
4. Dans la classe principale, créez plusieurs instances de `Paire` avec différents types (par exemple, `Paire<String, Integer>`, `Paire<Double, Double>`).
5. Affichez les valeurs stockées dans chaque paire.

**Objectifs :**
- Comprendre les concepts de programmation générique en Java.
- Savoir créer et utiliser des classes génériques.
- Apprendre à manipuler différents types de données de manière flexible.

---

## **Exercice 10 : Expressions Lambda et Fonctionnalités Avancées**

**Enoncé :**

Utilisez les expressions lambda pour simplifier le traitement des collections.

**Instructions :**
1. Créez une `List<String>` contenant une série de mots.
2. Utilisez une expression lambda avec la méthode `forEach` pour afficher chaque mot suivi de sa longueur. Par exemple : `Mot (Longueur)`.
3. Utilisez une expression lambda avec la méthode `filter` pour sélectionner et afficher uniquement les mots commençant par une lettre spécifique (par exemple, 'A').
4. Comparez cette approche avec une implémentation utilisant des classes anonymes.

**Objectifs :**
- Maîtriser l'utilisation des expressions lambda en Java.
- Savoir simplifier le code en utilisant des fonctionnalités avancées de Java.
- Comprendre les avantages des lambdas par rapport aux classes anonymes.

---

# Conclusion

Ces exercices couvrent une large gamme de concepts fondamentaux et avancés de Java. Ils visent à renforcer votre compréhension et à vous préparer à des situations réelles de programmation. N'hésitez pas à tester différentes approches et à approfondir chaque sujet pour maîtriser pleinement le langage Java.

Bonne programmation !
