package com.heroku.entities;


import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "account"
 *
 * @author Rodrigo Torres (Heroku)
 *
 */

@Entity
@Table(name="account", schema="salesforce" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Account.countAll", query="SELECT COUNT(x) FROM Account x" )
} )
public class Account implements Serializable
{
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="cumulusbankdemo__nationality__pc", length=255)
    private String     nationality ;


    @Column(name="lastname", length=80)
    private String     lastname     ;


    @Column(name="name", length=255)
    private String     name         ;


    @Transient
    @JsonIgnore
    @Column(name="isdeleted")
    private Boolean    isdeleted    ;


    @Transient
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="systemmodstamp")
    private Date       systemmodstamp ;


    @Column(name="cumulusbankdemo__place_of_birth__pc", length=255)
    private String     placeOfBirth ;


    @Column(name="external_id__c", length=255)
    private String     externalId ;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createddate")
    private Date       createddate  ;


    @Column(name="accountnumber", length=40)
    private String     accountnumber ;


    @Column(name="cumulusbankdemo__social_security_number__pc", length=20)
    private String     ssn ;


    @Column(name="cumulusbankdemo__facebook_id__pc", length=255)
    private String     facebookId ;


    @Column(name="firstname", length=40)
    private String     firstname    ;


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
    public Account()
    {
		super();
    }

    public Account update(Account a) {
		this.id = a.id;
        this.nationality = a.nationality;
        this.lastname = a.lastname;
        this.name = a.name;
        this.isdeleted = a.isdeleted;
        this.systemmodstamp = a.systemmodstamp;
        this.placeOfBirth = a.placeOfBirth;
        this.externalId = a.externalId;
        this.createddate = a.createddate;
        this.accountnumber = a.accountnumber;
        this.ssn = a.ssn;
        this.facebookId = a.facebookId;
        this.firstname = a.firstname;
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
    //--- DATABASE MAPPING : cumulusbankdemo__nationality__pc ( varchar ) 
    public void setNationality( String nacionality )
    {
        this.nationality = nacionality;
    }
    public String getNationality()
    {
        return this.nationality;
    }

    //--- DATABASE MAPPING : lastname ( varchar ) 
    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }
    public String getLastname()
    {
        return this.lastname;
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

    //--- DATABASE MAPPING : isdeleted ( bool ) 
    public void setIsdeleted( Boolean isdeleted )
    {
        this.isdeleted = isdeleted;
    }
    public Boolean getIsdeleted()
    {
        return this.isdeleted;
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

    //--- DATABASE MAPPING : cumulusbankdemo__place_of_birth__pc ( varchar ) 
    public void setPlaceOfBirth( String placeOfBirth )
    {
        this.placeOfBirth = placeOfBirth;
    }
    public String getPlaceOfBirth()
    {
        return this.placeOfBirth;
    }

    //--- DATABASE MAPPING : external_id__c ( varchar ) 
    public void setExternalId( String externalIdCustom )
    {
        this.externalId = externalIdCustom;
    }
    public String getExternalId()
    {
        return this.externalId;
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

    //--- DATABASE MAPPING : accountnumber ( varchar ) 
    public void setAccountNumber( String accountnumber )
    {
        this.accountnumber = accountnumber;
    }
    public String getAccountnumber()
    {
        return this.accountnumber;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__social_security_number__pc ( varchar ) 
    public void setSocialSecurityNumber( String cumulusbankdemoSocialSecurityNumberPc )
    {
        this.ssn = cumulusbankdemoSocialSecurityNumberPc;
    }
    public String getSocialSecurityNumber()
    {
        return this.ssn;
    }

    //--- DATABASE MAPPING : cumulusbankdemo__facebook_id__pc ( varchar ) 
    public void setFacebookId( String cumulusbankdemoFacebookIdPc )
    {
        this.facebookId = cumulusbankdemoFacebookIdPc;
    }
    public String getFacebookId()
    {
        return this.facebookId;
    }

    //--- DATABASE MAPPING : firstname ( varchar ) 
    public void setFirstName( String firstname )
    {
        this.firstname = firstname;
    }
    public String getFirstname()
    {
        return this.firstname;
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
        sb.append(nationality);
        sb.append("|");
        sb.append(lastname);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(isdeleted);
        sb.append("|");
        sb.append(systemmodstamp);
        sb.append("|");
        sb.append(placeOfBirth);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(createddate);
        sb.append("|");
        sb.append(accountnumber);
        sb.append("|");
        sb.append(ssn);
        sb.append("|");
        sb.append(facebookId);
        sb.append("|");
        sb.append(firstname);
        sb.append("|");
        sb.append(sfid);
        sb.append("|");
        sb.append(hcLastop);
        sb.append("|");
        sb.append(hcErr);
        return sb.toString(); 
    } 

}