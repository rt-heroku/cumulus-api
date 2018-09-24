/*
 * Created on 2018-09-24 ( Time 11:58:14 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package com.heroku.exceptions;

public class AccounttransactionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1L;

	public AccounttransactionNotFoundException(Long id) {
		super("Accounttransaction not found with id: " + id.toString());
	}

	public AccounttransactionNotFoundException(String accounttransaction) {
		super("Accounttransaction " + accounttransaction + " not found!");
	}
}
