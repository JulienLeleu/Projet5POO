package calculatrice;

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
				Double x = resultat.pop();
				Double y = resultat.pop();
				Double res = Operation.getOperateur(token).eval(x,y);
				resultat.push(res);
			}
			else {
				resultat.push(Double.parseDouble(token));
			}
		}
		return resultat.pop();
	}
}