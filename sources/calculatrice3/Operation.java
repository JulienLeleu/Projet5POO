package calculatrice3;

import java.util.Stack;

public enum Operation {
    PLUS("+",2), MOINS("-",2), FOIS("*",2), DIV("/",2), PUISS("^",2), SQRT("V",1), ABS("ABS",1), NOT("NOT",1), IF("IF",3), DROP, DUP, SWAP, COUNT;

    private final String code_operation;
    private final int arite;

    Operation() {
    	this.code_operation = "";
        this.arite = 0;
    }

    Operation(String code_operation) {
    	this.code_operation=code_operation;
        this.arite = 2;
    }

    Operation(String code_operation, int arite) {
        this.code_operation = code_operation;
        this.arite = arite;
    }

    public String toString() {
    	if (code_operation!="") {
    		return code_operation;
    	}
    	else return super.toString();
    }

    public Double eval(Double [] operandes) {
        switch (this) {
            case PLUS:
                return operandes[0] + operandes[1];

            case MOINS:
                return operandes[0] - operandes[1];
            
            case FOIS:
                return operandes[0] * operandes[1];
           
            case DIV:
                return operandes[0] / operandes[1];
           
            case PUISS:
                return Math.pow(operandes[0],operandes[1]);

            case SQRT:
                return Math.sqrt(operandes[0]);

            case ABS:
                return Math.abs(operandes[0]);

            case NOT:
                if (operandes[0] == 0.0) {
                    return 1.0;
                }
                else {
                    return 0.0;
                }

            case IF:
                if (operandes[0] != 0.0) {
                    return operandes[1];
                }
                else {
                    return operandes[2];
                }

            default:
                return null;
        }
    }

    public static Operation getOperateur(String code_operation) {
    	for (Operation o : Operation.values()) {
    		if (o.toString().equals(code_operation)) {
    			return o;
    		}
    	}
    	return null;
    }

    public int getArite() {
        return this.arite;
    }

    public void execute(Stack<Double> pile) {
        if (arite != 0) {
            Double [] tab = new Double[arite];
            for (int i = 0; i < tab.length; i++) {
                tab[i] = pile.pop();
            }
            pile.push(eval(tab));
        }
        else {
            switch (this) {
                case DROP:
                    pile.pop();
                break;

                case DUP:
                    Double tmp = pile.pop();
                    pile.push(tmp);
                    pile.push(tmp);
                break;

                case SWAP:
                    Double tmp1 = pile.pop();
                    Double tmp2 = pile.pop();
                    pile.push(tmp1);
                    pile.push(tmp2);
                break;

                case COUNT:
                    Stack<Double> pileTmp = new Stack<Double>();
                    Integer compteur = 0;
                    while (!pile.isEmpty()) {
                        pileTmp.push(pile.pop());
                        compteur++;
                    }
                    while (!pileTmp.isEmpty()) {
                        pile.push(pileTmp.pop());
                    }
                    pile.push((compteur.doubleValue()));
                break;
            }
        }
    }
}
