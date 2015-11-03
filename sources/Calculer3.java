import calculatrice3.* ;

public class Calculer3 {
    public static void main(String [] args) throws CalculatriceException {
        Calculatrice c = new Calculatrice() ;
        if (args.length < 1) {
        	throw new CalculatriceException("Pas assez d'arguments");
        }

        for (int i=0; i<args.length; i++) {
        	if (args[i].length() < 1) {
        		throw new CalculatriceException("Chaine vide");
        	}
        	System.out.println(args[i] + " = " + c.calculer(args[i])) ;
        }
    }
}