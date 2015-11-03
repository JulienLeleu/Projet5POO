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

	public boolean isNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	public double calculer(String s) throws CalculatriceException {
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			//Si c'est un symbole d'opération
			if (operations.containsKey(token)) {
				Operation.getOperateur(token).execute(resultat);
			}
			else if (isNumber(token)) {
				resultat.push(Double.parseDouble(token));
			}
			else {
				throw new CalculatriceException("Operation inconnue");
			}
		}
		return resultat.pop();
	}
}