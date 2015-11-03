package calculatrice2;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^"), SQRT("V",1), ABS("ABS",1), NOT("NOT",1), IF("IF",3);

    private final String code_operation;
    private final int nbOperandes;

    Operation() {
    	this.code_operation = "";
        this.nbOperandes = 2;
    }

    Operation(String code_operation) {
    	this.code_operation=code_operation;
        this.nbOperandes = 2;
    }

    Operation(String code_operation, int nbOperandes) {
        this.code_operation = code_operation;
        this.nbOperandes = nbOperandes;
    }

    public String toString() {
    	if (code_operation!="") {
    		return code_operation;
    	}
    	else return super.toString();
    }

    public Double eval(double [] operandes) {
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
    		if (o.code_operation.equals(code_operation)) {
    			return o;
    		}
    	}
    	return null;
    }

    public int getNbOperandes() {
        return this.nbOperandes;
    }
}
