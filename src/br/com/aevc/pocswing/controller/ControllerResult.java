package br.com.aevc.pocswing.controller;


public class ControllerResult<T> {

    private final T result;
    private final Exception exception;

	public static ControllerResult success(){
    	return new ControllerResult(null);
	}

	public ControllerResult(T result) {
		super();
		this.result = result;
		this.exception = null;
	}

	public ControllerResult(Exception exception) {
		super();
		this.result = null;
		this.exception = exception;
	}

    public T getResult() {
        return result;
    }

	public Exception getException() {
		return exception;
	}

	public boolean errorHappened(){
    	return this.exception != null;
	}
}
