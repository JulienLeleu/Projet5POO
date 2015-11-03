package calculatrice;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^") ;

    private final String code_operation;

    Operation() {
    	this.code_operation="";
    }

    Operation(String code_operation) {
    	this.code_operation=code_operation;
    }

    public String toString() {
    	if (code_operation!="") {
    		return code_operation;
    	}
    	else return super.toString();
    }

    public double eval(double x, double y) {
    	if (this == this.PLUS) {
    		return x + y;
    	}
    	else if (this == this.MOINS) {
    		return x - y;
    	}
    	else if (this == this.FOIS) {
    		return x * y;
    	}
    	else if (this == this.DIV) {
    		return x / y;
    	}
    	else if (this == this.PUISS) {
    		return Math.pow(x,y);
    	}
    	return 0.0;
    }

    public static Operation getOperateur(String code_operation) {
    	for (Operation o : Operation.values()) {
    		if (o.code_operation.equals(code_operation)) {
    			return o;
    		}
    	}
    	return null;
    }
}
