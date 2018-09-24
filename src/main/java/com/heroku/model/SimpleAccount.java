package com.heroku.model;

import java.util.ArrayList;
import java.util.List;

import com.heroku.entities.Accounttransaction;
import com.heroku.entities.FinancialAccount;

public class SimpleAccount {

	private Double balance;
	private String type;
	private String status;
	private Boolean lock;
	private String name;
	
	private List<SimpleTransaction> transactions;
	
	public SimpleAccount(){
		super();
		transactions = new ArrayList<SimpleTransaction>();
	}
	
	public SimpleAccount(FinancialAccount fa) {
		transactions = new ArrayList<SimpleTransaction>();
		this.balance = fa.getBalance();
		this.type = fa.getFinservAccountType();
		this.status = fa.getStatus();
		this.name = fa.getName();
		
		this.lock = !fa.getStatus().equals("Open");
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getLock() {
		return lock;
	}

	public void setLock(Boolean lock) {
		this.lock = lock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SimpleTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<SimpleTransaction> transactions) {
		this.transactions = transactions;
	}

	public void add(Accounttransaction t) {
		SimpleTransaction st = new SimpleTransaction(t);
		
		
		st.setAmount(t.getAmount());
		st.setDate(t.getTransactionDate());
		st.setStatus(t.getTransactionStatus());
		st.setSubType(t.getTransactionSubType());
		st.setType(t.getTransactionType());
		
		st.setDescription(t.getDescription());
		
		transactions.add(st);
	}
	
	
	
}
