package calculatrice3;

import java.util.StringTokenizer;
import java.util.Stack;
import java.util.HashMap;

public class Calculatrice {
	Stack<Double> resultat;
	HashMap<String, Operation> operations;

	public Calculatrice() {
		resultat = new Stack<Double>();
		operations = new HashMap<String, Operation>();

		for (Operation o : Operation.values()) {
			operations.put(o.toString(), o);
		}
	}

	public double calculer(String s) throws CalculatriceException {
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			//Si c'est un symbole d'opération
			if (operations.containsKey(token)) {
				//if (Operation.getOperateur(token).getArite() > 0) {
					//Double [] tab = new Double[Operation.getOperateur(token).getArite()];
					/*for (int i = 0; i < tab.length; i++) {
						tab[i] = resultat.pop();
					}*/
				//}
				Operation.getOperateur(token).execute(resultat);
			}
			else {
				resultat.push(Double.parseDouble(token));
			}
		}
		return resultat.pop();
	}
}