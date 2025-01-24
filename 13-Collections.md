# 13 - Les Collections : principes des collections en Java

Les **Collections** en Java sont des structures de données prêtes à l’emploi qui permettent de stocker, d’organiser et de manipuler des groupes d’objets. Elles sont définies au sein du framework des Collections (Java Collections Framework) introduit à partir de Java 1.2 et continuellement amélioré depuis.

## 1. Introduction au framework Collections

Le framework **Java Collections** propose une hiérarchie d’interfaces et de classes concrètes pour gérer des données. Les principales catégories de collections sont :

- **List** : gère une collection ordonnée d’objets (ex. : `ArrayList`, `LinkedList`).  
- **Set** : représente un ensemble d’éléments uniques (ex. : `HashSet`, `LinkedHashSet`, `TreeSet`).  
- **Queue** : représente une file d’attente (ex. : `LinkedList`, `PriorityQueue`).  
- **Map** : gère des paires clé/valeur (ex. : `HashMap`, `LinkedHashMap`, `TreeMap`). (Techniquement, `Map` ne fait pas partie de l’interface `Collection` mais fait partie du framework global.)

L’objectif principal de ces collections est de fournir des méthodes et des comportements standardisés (comme l’ajout, la suppression ou la recherche d’éléments) tout en laissant au programmeur le choix de l’implémentation répondant le mieux à ses besoins en termes de performances et d’ordonnancement.

## 2. L’interface Collection

L’interface **Collection<E>** est la racine de la plupart des collections (sauf `Map`).  
Elle définit des méthodes générales comme :

- `boolean add(E e) :` ajoute un élément.  
- `boolean remove(Object o) :` enlève un élément.  
- `boolean contains(Object o) :` vérifie si un élément est présent.  
- `int size() :` retourne le nombre d’éléments.  
- `void clear() :` supprime tous les éléments.  
- `boolean isEmpty() :` vérifie si la collection est vide.  
- `Iterator<E> iterator() :` retourne un itérateur pour parcourir la collection.

Les collections java utilisent généralement une forme **générique** (générésics) comme : `Collection<String>` pour stocker des `String`, `Collection<Integer>` pour stocker des `Integer`, etc.

## 3. Les Listes (List)

### 3.1 Caractéristiques

Une **List** est une collection ordonnée d’éléments qui autorise les doublons. Les éléments sont accessibles par un index (position).  
Principales implémentations :

- **ArrayList** : basée sur un tableau dynamique. L’accès à un élément par indice est rapide (O(1)), mais l’insertion ou la suppression d’éléments en milieu de liste peut être plus coûteuse (O(n)).  
- **LinkedList** : basée sur une liste chaînée. L’insertion et la suppression d’éléments en milieu de liste sont rapides (O(1) pour manipuler les maillons), mais l’accès par indice est plus lent (O(n)).

### 3.2 Exemples de code

```java
import java.util.ArrayList;
import java.util.List;

public class ExempleList {
    public static void main(String[] args) {
        // Déclaration et instanciation d’une ArrayList de String
        List<String> prenoms = new ArrayList<>();

        // Ajout d’éléments
        prenoms.add("Alice");
        prenoms.add("Bob");
        prenoms.add("Claire");

        // Parcours
        for (String prenom : prenoms) {
            System.out.println(prenom);
        }

        // Accès par index
        System.out.println("Premier élément : " + prenoms.get(0));
        System.out.println("Taille : " + prenoms.size());

        // Suppression
        prenoms.remove("Bob");
        System.out.println("Après suppression : " + prenoms);
    }
}
```

## 4. Les Ensembles (Set)

### 4.1 Caractéristiques

Un **Set** est une collection **sans doublons**. Les principales implémentations :

- **HashSet** : basé sur une table de hachage (HashTable). L’ordre n’est pas garanti, et les opérations d’ajout/recherche/suppression sont en général O(1).  
- **LinkedHashSet** : dérivé de `HashSet` mais conserve l’ordre d’insertion.  
- **TreeSet** : basé sur un `TreeMap` (arbre rouge-noir). Les éléments sont triés dans l’ordre naturel ou selon un comparateur. Les opérations d’ajout/recherche/suppression sont en O(log n).

### 4.2 Exemples de code

```java
import java.util.HashSet;
import java.util.Set;

public class ExempleSet {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        fruits.add("Pomme");
        fruits.add("Banane");
        fruits.add("Pomme"); // ignoré car déjà présent
        fruits.add("Poire");

        System.out.println("Taille du set : " + fruits.size());
        System.out.println("Contenu : " + fruits);

        if (fruits.contains("Banane")) {
            System.out.println("Banane est présente !");
        }
    }
}
```

## 5. Les Files d’attente (Queue)

### 5.1 Caractéristiques

Une **Queue** (file d’attente) suit généralement une logique **FIFO** (First In First Out). Les principales implémentations :

- **LinkedList** (implémente aussi `Queue`) : permet aussi d’utiliser les méthodes d’une liste chaînée.  
- **PriorityQueue** : Les éléments sont triés selon un ordre naturel ou un comparateur. L’élément en tête est celui qui a la priorité la plus élevée.

### 5.2 Exemples de code

```java
import java.util.LinkedList;
import java.util.Queue;

public class ExempleQueue {
    public static void main(String[] args) {
        Queue<Integer> fileAttente = new LinkedList<>();

        // Ajout d’éléments dans la queue
        fileAttente.offer(10);
        fileAttente.offer(20);
        fileAttente.offer(30);

        System.out.println("Contenu de la queue : " + fileAttente);

        // Accès à la tête sans suppression
        System.out.println("Tête de la queue : " + fileAttente.peek());

        // Retrait de la tête
        System.out.println("Élément retiré : " + fileAttente.poll());
        System.out.println("Contenu après retrait : " + fileAttente);
    }
}
```

## 6. Les Maps (Map)

### 6.1 Caractéristiques

Une **Map** n’hérite pas de l’interface `Collection`, mais fait partie du framework des Collections. Elle stocke des **paires clé–valeur**, sans clé dupliquée. Principales implémentations :

- **HashMap** : basé sur une table de hachage, ordre non garanti.  
- **LinkedHashMap** : garde l’ordre d’insertion.  
- **TreeMap** : trie selon l’ordre naturel de la clé ou un comparateur.

### 6.2 Exemple de code

```java
import java.util.HashMap;
import java.util.Map;

public class ExempleMap {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Claire", 28);

        System.out.println("Âge de Bob : " + ages.get("Bob"));
        System.out.println("Toutes les clés : " + ages.keySet());
        System.out.println("Toutes les valeurs : " + ages.values());

        if (ages.containsKey("Alice")) {
            System.out.println("Alice est présente dans la Map !");
        }

        // Parcours
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " a " + entry.getValue() + " ans.");
        }
    }
}
```

## 7. Parcours des collections

### 7.1 Boucle For-Each

La boucle **for-each** (introduite en Java 5) est une syntaxe simplifiée pour itérer sur n’importe quel objet qui implémente `Iterable`.

```java
List<String> noms = List.of("Alice", "Bob", "Claire");
for (String nom : noms) {
    System.out.println(nom);
}
```

### 7.2 Iterateur (Iterator)

Toutes les collections implémentant l’interface `Collection` disposent d’un itérateur via la méthode `.iterator()`. L’itérateur permet de parcourir la collection et de supprimer éventuellement des éléments pendant le parcours.

```java
import java.util.Iterator;

List<String> noms = new ArrayList<>(List.of("Alice", "Bob", "Claire"));
Iterator<String> it = noms.iterator();
while (it.hasNext()) {
    String nom = it.next();
    if (nom.equals("Bob")) {
        it.remove(); // suppression de "Bob"
    }
}
System.out.println(noms); // [Alice, Claire]
```

### 7.3 Méthodes avancées (Streams)

À partir de Java 8, vous pouvez également parcourir les collections via les **Streams**, qui fournissent un ensemble de méthodes pour filtrer, trier et transformer les données de manière fonctionnelle.

```java
List<Integer> nombres = List.of(1, 2, 3, 4, 5);
nombres.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println); // affiche 2 et 4
```

## 8. Comparaison des principales implémentations

| **Implémentation**     | **Complexité d’accès** | **Complexité d’insertion/suppression** | **Caractéristiques principales**                         |
|------------------------|------------------------|----------------------------------------|----------------------------------------------------------|
| ArrayList              | O(1) (accès indexé)   | O(n) (en général)                      | Tableau dynamique, rapide pour accès direct              |
| LinkedList             | O(n)                  | O(1) (insertion/suppression)           | Liste chaînée, rapide pour manipulations en milieu de liste |
| HashSet / HashMap      | O(1) (en moyenne)     | O(1) (en moyenne)                      | Basé sur table de hachage, l’ordre n’est pas garanti     |
| LinkedHashSet / LinkedHashMap | O(1) (en moyenne)     | O(1) (en moyenne)                      | Basé sur table de hachage, mais conserve l’ordre d’insertion |
| TreeSet / TreeMap      | O(log n)              | O(log n)                               | Basé sur un arbre (arbre rouge-noir), l’ordre est trié   |
| PriorityQueue          | -                      | O(log n) (insertion)                   | Le retrait se fait par priorité, non par ordre d’insertion |

## 9. Conseils d’utilisation

1. **Bien choisir la structure** : selon que vous ayez besoin d’un accès rapide par index, d’un tri naturel, d’un ensemble sans doublons, d’opérations FIFO, etc.  
2. **Taille attendue** : certaines implémentations (comme `ArrayList`) nécessitent potentiellement un redimensionnement fréquent si la taille varie beaucoup.  
3. **Ordre** : si l’ordre d’insertion est important (`LinkedHashSet`, `LinkedHashMap`), ou si l’ordre doit être trié (`TreeSet`, `TreeMap`).  
4. **Performance** : `HashSet` et `HashMap` sont en général les plus rapides pour des opérations de base, mais ne garantissent pas l’ordre.  
5. **Synchronisation** : si vous manipulez les collections dans un contexte multi-threads, pensez à utiliser des collections synchronisées (par exemple via `Collections.synchronizedList(...)`) ou les classes du package `java.util.concurrent`.

---

# Exercices pratiques

### Exercice 1 : Manipulation de `List`
1. Créez une classe `ExerciceList` avec une méthode `main`.
2. Déclarez une `List<String>` et insérez-y des noms de votre choix.
3. Affichez la liste, puis supprimez le deuxième élément.
4. Affichez à la fois la taille de la liste et la liste finale.

Exemple de résultats attendus :  
- Liste initiale : ["Alice", "Bob", "Claire", "David"]  
- Suppression du deuxième élément ("Bob").  
- Liste finale : ["Alice", "Claire", "David"]  
- Taille : 3.

---

### Exercice 2 : Utilisation de `Set`
1. Dans une classe `ExerciceSet`, déclarez un `Set<Integer>`.
2. Ajoutez plusieurs entiers, dont certains en doublons.
3. Vérifiez si un entier particulier est présent dans le `Set`.
4. Affichez la taille du `Set` et son contenu.

Attendu : le `Set` ne doit pas comporter de doublons et doit correctement indiquer si l’entier recherché est présent.

---

### Exercice 3 : Mise en pratique des `Map`
1. Créez une classe `ExerciceMap` avec un `main`.
2. Déclarez une `Map<String, Double>` pour stocker des produits (clé) et leur prix (valeur).  
3. Ajoutez plusieurs paires clé/valeur (ex. `"Pommes"` -> 2.50, `"Bananes"` -> 1.20, …).
4. Mettez à jour le prix d’un des produits existants.
5. Affichez l’ensemble des produits, leurs prix et vérifiez qu’un produit particulier existe dans votre map.

---

### Exercice 4 : Queue et PriorityQueue
1. Créez une classe `ExerciceQueue`.
2. Déclarez une `Queue<String>` et ajoutez-y des chaînes (ex. noms, tâches, etc.).
3. Affichez la tête de la queue sans la retirer.
4. Retirez progressivement tous les éléments en utilisant `poll()` et affichez l’ordre d’extraction.

Variante : Utilisez une `PriorityQueue<Integer>` pour trier automatiquement vos entiers. Observez l’ordre de sortie.

---

### Exercice 5 : Parcours et filtrage
1. À partir d’une `List<Integer>`, générez des nombres aléatoires entre 1 et 100.
2. Filtrez les nombres pairs et affichez-les à l’aide des Streams.
3. Supprimez éventuellement un nombre précis lors du parcours via un itérateur pour observer la différence avec l’approche Stream.

---

**Bon courage !** Mettez en pratique ces exercices pour acquérir une bonne maîtrise des collections en Java.
