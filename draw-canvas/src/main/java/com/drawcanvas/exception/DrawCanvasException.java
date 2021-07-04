package com.drawcanvas.exception;


import lombok.Getter;

@Getter
public class DrawCanvasException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DrawCanvasErrorCodes errorCodes;

    public DrawCanvasException(DrawCanvasErrorCodes errorCodes, String message){
        super(message);
        this.errorCodes = errorCodes;
    }
    
	public DrawCanvasException(DrawCanvasErrorCodes errorCodes, String message, Throwable th) {
		super(message, th);
		this.errorCodes = errorCodes;
	}
}
