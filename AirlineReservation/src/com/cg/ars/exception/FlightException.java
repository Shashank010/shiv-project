package com.cg.ars.exception;

public class FlightException extends Exception{
		
		
		String message;

		public FlightException(String message) {
			
			this.message = message;
		}
		
		@Override
		public String getMessage() {
			return this.message;
		}

	


}
