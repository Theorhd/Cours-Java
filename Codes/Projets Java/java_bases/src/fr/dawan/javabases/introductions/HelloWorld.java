package fr.dawan.javabases.introductions;

/**
 * Classe de test pour afficher un message de bienvenue
 * @author Théo Richard
 * @version 1.0
 */

public class HelloWorld {

    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World !");
        sayHello();
        System.out.println(add(2, 3));
    }

    /**
     * Méthode pour afficher un message de bienvenue
     */
    public static void sayHello() {
        System.out.println("First Java App");
    }

    /**
     * Méthode pour additionner deux nombres
     * @param a
     * @param b
     * @return a + b
     */
    public static int add(int a, int b) {
        /* Additionne deux nombres */
        return a + b;
    }


}
