import calculatrice.* ;

public class Test {
    public static void main(String [] args) {
        if (args.length < 3) 
            System.err.println("Au moins deux nombres et une opérande sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            double x = new Double(args[0]) ;
            String operande = args[1];
            double y = new Double(args[2]) ;
            Operation o = Operation.getOperateur(operande);

            if(o != null) {
                System.out.println(x + " " + operande + " " + y + " = " + o.eval(x,y));
            }
            else {
                System.out.println("Erreur : opérande inconnu");
            }

            // la liste des opérations disponibles
            /*for (Operation o: Operation.values())
                System.out.println(x + " " + o + " " + y + " = " + o.eval(x,y)) ;*/
        }
    }
}
