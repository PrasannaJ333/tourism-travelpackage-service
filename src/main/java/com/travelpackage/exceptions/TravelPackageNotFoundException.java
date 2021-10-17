/**
 * 
 */
package com.travelpackage.exceptions;

/**
 * @author PrasannaJ
 *
 */
public class TravelPackageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TravelPackageNotFoundException() {
		super();
	}

	public TravelPackageNotFoundException(String message) {
		super(message);
	}

}
