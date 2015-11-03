package calculatrice2;

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
			if (operations.get(token) != null) {
				double [] tab = new double[Operation.getOperateur(token).getNbOperandes()];
				for (int i = 0; i < tab.length; i++) {
					tab[i] = resultat.pop();
				}
				Double res = Operation.getOperateur(token).eval(tab);
				resultat.push(res);
			}
			else {
				resultat.push(Double.parseDouble(token));
			}
		}
		return resultat.pop();
	}
}