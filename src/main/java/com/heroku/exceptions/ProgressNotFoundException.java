/*
 * Created on 2018-09-20 ( Time 12:34:31 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package com.heroku.exceptions;

public class ProgressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1L;

	public ProgressNotFoundException(Integer id) {
		super("Progress not found with id: " + id.toString());
	}

	public ProgressNotFoundException(String progress) {
		super("Progress " + progress + " not found!");
	}
}
