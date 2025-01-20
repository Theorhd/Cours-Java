package fr.dawan.javabases.variables;

public class Application {

    public static void main(String[] args) {
         /*
         * Variables :
         *
         * Une valeur est une zone mémoire qui contient une donnée typée.
         * Pour déclarer une variable, on utilise le mot-clé "type" suivi du nom de la variable.
         *
         * Types : Voir cours 04, partie Types de données
         */

        System.out.println("___________Les Variables et les Types ___________");

        System.out.println("___________Les entiers : ___________");

        /* Byte :  */
        System.out.println("Byte : ");
        byte age = 25;
        System.out.println("J'ai " + age + " ans");

        /* Short :  */
        System.out.println("Short : ");
        short distance = 10_000;
        System.out.println("La distance est de " + distance + " km");

        /* int :  */
        System.out.println("Int : ");
        int population = 67_000_000;
        System.out.println("La population est de " + population + " habitants");

        /* Long :  */
        System.out.println("Long : ");
        long distanceTerreSoleil = 9_460_730_472_580l;
        System.out.println("La distance Terre-Soleil est de " + distanceTerreSoleil + " km");

        System.out.println("___________Les nombres décimaux : ___________");

        /* Float :  */
        System.out.println("Float : ");
        float pi = 3.141592653589793238462643383279502884197169399375105820974944f;
        System.out.println("La valeur de Pi est " + pi);

        /* Double :  */
        System.out.println("Double : ");
        double piDouble = 3.141592653589793238462643383279502884197169399375105820974944;
        System.out.println("La valeur de Pi est " + piDouble);
    }

}
