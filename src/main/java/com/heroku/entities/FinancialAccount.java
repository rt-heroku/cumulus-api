/*
 * Created on 2018-09-24 ( Time 11:58:14 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.heroku.entities;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "finserv__financialaccount__c"
 *
 * @author RTORRES
 *
 */

@Entity
@Table(name="finserv__financialaccount__c", schema="salesforce" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="FinancialAccount.countAll", query="SELECT COUNT(x) FROM FinancialAccount x" )
} )
public class FinancialAccount implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="finserv__availablecredit__c")
    private Double     availableCredit ;


    @Column(name="finserv__financialaccountsource__c", length=255)
    private String     accountSource ;


    @Column(name="cumulusbankdemo__primary_goal__c", length=255)
    private String     primaryGoal  ;


    @Column(name="finserv__financialaccounttype__c", length=255)
    private String     finservAccountType ;


    @Column(name="cumulusbankdemo__account_type__c", length=255)
    private String     accountType  ;


    @Column(name="finserv__balance__c")
    private Double     balance      ;


    @Column(name="finserv__type__c", length=255)
    private String     type         ;


    @Column(name="finserv__productname__c", length=18)
    private String     productName  ;


    @Column(name="cumulusbankdemo__account_subtype__c", length=255)
    private String     accountSubType ;


    @Column(name="finserv__minimumpayment__c")
    private Double     minimumPayment ;


    @Column(name="name", length=80)
    private String     name         ;


    @Column(name="cumulusbankdemo__available_balance__c")
    private Double     availableBalance ;


    @Transient
    @JsonIgnore
    @Column(name="isdeleted")
    private Boolean    isdeleted    ;


    @Column(name="cumulusbankdemo__my_card__c", length=255)
    private String     myCard       ;


    @Transient
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="systemmodstamp")
    private Date       systemmodstamp ;


    @Column(name="finserv__status__c", length=255)
    private String     status       ;


    @Column(name="finserv__primaryowner__c", length=18)
    private String     owner ;


    @Column(name="cumulusbankdemo__primary_access__c", length=255)
    private String     primaryAccess ;


    @Column(name="external_id__c", length=255)
    private String     externalId   ;


    @Column(name="finserv__financialaccountnumber__c", length=80)
    private String     accountNumber ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createddate")
    private Date       createddate  ;


    @Column(name="finserv__interestrate__c")
    private Double     interestRate ;


    @Column(name="cumulusbankdemo__account_number__c", length=30)
    private String     cumulusAccountNumber ;


    @Column(name="sfid", length=18)
    private String     sfid         ;


    @Transient
    @JsonIgnore
    @Column(name="_hc_lastop", length=32)
    private String     hcLastop     ;


    @Transient
    @JsonIgnore
    @Column(name="_hc_err", length=2147483647)
    private String     hcErr        ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public FinancialAccount()
    {
		super();
    }

    public FinancialAccount update(FinancialAccount a) {
		this.id = a.id;
        this.availableCredit = a.availableCredit;
        this.accountSource = a.accountSource;
        this.primaryGoal = a.primaryGoal;
        this.finservAccountType = a.finservAccountType;
        this.accountType = a.accountType;
        this.balance = a.balance;
        this.type = a.type;
        this.productName = a.productName;
        this.accountSubType = a.accountSubType;
        this.minimumPayment = a.minimumPayment;
        this.name = a.name;
        this.availableBalance = a.availableBalance;
        this.isdeleted = a.isdeleted;
        this.myCard = a.myCard;
        this.systemmodstamp = a.systemmodstamp;
        this.status = a.status;
        this.owner = a.owner;
        this.primaryAccess = a.primaryAccess;
        this.externalId = a.externalId;
        this.accountNumber = a.accountNumber;
        this.createddate = a.createddate;
        this.interestRate = a.interestRate;
        this.cumulusAccountNumber = a.cumulusAccountNumber;
        this.sfid = a.sfid;
        this.hcLastop = a.hcLastop;
        this.hcErr = a.hcErr;



		return a;
	}

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Long id )
    {
        this.id = id ;
    }
    public Long getId()
    {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : finserv__availablecredit__c ( float8 ) 
    public void setAvailableCredit( Double availableCredit )
    {
        this.availableCredit = availableCredit;
    }
    public Double getAvailableCredit()
    {
        return this.availableCredit;
    }

    //--- DATABASE MAPPING : finserv__financialaccountsource__c ( varchar ) 
    public void setAccountSource( String accountSource )
    {
        this.accountSource = accountSource;
    }
    public String getAccountSource()
    {
        return this.accountSource;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__primary_goal__c ( varchar ) 
    public void setPrimaryGoal( String primaryGoal )
    {
        this.primaryGoal = primaryGoal;
    }
    public String getPrimaryGoal()
    {
        return this.primaryGoal;
    }

    //--- DATABASE MAPPING : finserv__financialaccounttype__c ( varchar ) 
    public void setFinservAccountType( String finservAccountType )
    {
        this.finservAccountType = finservAccountType;
    }
    public String getFinservAccountType()
    {
        return this.finservAccountType;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__account_type__c ( varchar ) 
    public void setAccountType( String accountType )
    {
        this.accountType = accountType;
    }
    public String getAccountType()
    {
        return this.accountType;
    }

    //--- DATABASE MAPPING : finserv__balance__c ( float8 ) 
    public void setBalance( Double balance )
    {
        this.balance = balance;
    }
    public Double getBalance()
    {
        return this.balance;
    }

    //--- DATABASE MAPPING : finserv__type__c ( varchar ) 
    public void setType( String type )
    {
        this.type = type;
    }
    public String getType()
    {
        return this.type;
    }

    //--- DATABASE MAPPING : finserv__productname__c ( varchar ) 
    public void setProductName( String productName )
    {
        this.productName = productName;
    }
    public String getProductName()
    {
        return this.productName;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__account_subtype__c ( varchar ) 
    public void setAccountSubType( String accountSubType )
    {
        this.accountSubType = accountSubType;
    }
    public String getAccountSubType()
    {
        return this.accountSubType;
    }

    //--- DATABASE MAPPING : finserv__minimumpayment__c ( float8 ) 
    public void setMinimumPayment( Double minimumPayment )
    {
        this.minimumPayment = minimumPayment;
    }
    public Double getMinimumPayment()
    {
        return this.minimumPayment;
    }

    //--- DATABASE MAPPING : name ( varchar ) 
    public void setName( String name )
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__available_balance__c ( float8 ) 
    public void setAvailableBalance( Double availableBalance )
    {
        this.availableBalance = availableBalance;
    }
    public Double getAvailableBalance()
    {
        return this.availableBalance;
    }

    //--- DATABASE MAPPING : isdeleted ( bool ) 
    public void setIsdeleted( Boolean isdeleted )
    {
        this.isdeleted = isdeleted;
    }
    public Boolean getIsdeleted()
    {
        return this.isdeleted;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__my_card__c ( varchar ) 
    public void setMyCard( String myCard )
    {
        this.myCard = myCard;
    }
    public String getMyCard()
    {
        return this.myCard;
    }

    //--- DATABASE MAPPING : systemmodstamp ( timestamp ) 
    public void setSystemmodstamp( Date systemmodstamp )
    {
        this.systemmodstamp = systemmodstamp;
    }
    public Date getSystemmodstamp()
    {
        return this.systemmodstamp;
    }

    //--- DATABASE MAPPING : finserv__status__c ( varchar ) 
    public void setStatus( String status )
    {
        this.status = status;
    }
    public String getStatus()
    {
        return this.status;
    }

    //--- DATABASE MAPPING : finserv__primaryowner__c ( varchar ) 
    public void setOwner( String owner )
    {
        this.owner = owner;
    }
    public String getOwner()
    {
        return this.owner;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__primary_access__c ( varchar ) 
    public void setPrimaryAccess( String primaryAccess )
    {
        this.primaryAccess = primaryAccess;
    }
    public String getPrimaryAccess()
    {
        return this.primaryAccess;
    }

    //--- DATABASE MAPPING : external_id__c ( varchar ) 
    public void setExternalId( String externalId )
    {
        this.externalId = externalId;
    }
    public String getExternalId()
    {
        return this.externalId;
    }

    //--- DATABASE MAPPING : finserv__financialaccountnumber__c ( varchar ) 
    public void setAccountNumber( String accountNumber )
    {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    //--- DATABASE MAPPING : createddate ( timestamp ) 
    public void setCreateddate( Date createddate )
    {
        this.createddate = createddate;
    }
    public Date getCreateddate()
    {
        return this.createddate;
    }

    //--- DATABASE MAPPING : finserv__interestrate__c ( float8 ) 
    public void setInterestRate( Double interestRate )
    {
        this.interestRate = interestRate;
    }
    public Double getInterestRate()
    {
        return this.interestRate;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__account_number__c ( varchar ) 
    public void setCumulusAccountNumber( String cumulusAccountNumber )
    {
        this.cumulusAccountNumber = cumulusAccountNumber;
    }
    public String getCumulusAccountNumber()
    {
        return this.cumulusAccountNumber;
    }

    //--- DATABASE MAPPING : sfid ( varchar ) 
    public void setSfid( String sfid )
    {
        this.sfid = sfid;
    }
    public String getSfid()
    {
        return this.sfid;
    }

    //--- DATABASE MAPPING : _hc_lastop ( varchar ) 
    public void setHcLastop( String hcLastop )
    {
        this.hcLastop = hcLastop;
    }
    public String getHcLastop()
    {
        return this.hcLastop;
    }

    //--- DATABASE MAPPING : _hc_err ( text ) 
    public void setHcErr( String hcErr )
    {
        this.hcErr = hcErr;
    }
    public String getHcErr()
    {
        return this.hcErr;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(availableCredit);
        sb.append("|");
        sb.append(accountSource);
        sb.append("|");
        sb.append(primaryGoal);
        sb.append("|");
        sb.append(finservAccountType);
        sb.append("|");
        sb.append(accountType);
        sb.append("|");
        sb.append(balance);
        sb.append("|");
        sb.append(type);
        sb.append("|");
        sb.append(productName);
        sb.append("|");
        sb.append(accountSubType);
        sb.append("|");
        sb.append(minimumPayment);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(availableBalance);
        sb.append("|");
        sb.append(isdeleted);
        sb.append("|");
        sb.append(myCard);
        sb.append("|");
        sb.append(systemmodstamp);
        sb.append("|");
        sb.append(status);
        sb.append("|");
        sb.append(owner);
        sb.append("|");
        sb.append(primaryAccess);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(accountNumber);
        sb.append("|");
        sb.append(createddate);
        sb.append("|");
        sb.append(interestRate);
        sb.append("|");
        sb.append(cumulusAccountNumber);
        sb.append("|");
        sb.append(sfid);
        sb.append("|");
        sb.append(hcLastop);
        sb.append("|");
        sb.append(hcErr);
        return sb.toString(); 
    } 

}