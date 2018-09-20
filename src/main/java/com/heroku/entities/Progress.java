/*
 * Created on 2018-09-20 ( Time 12:34:31 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.heroku.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;


/**
 * Persistent class for entity stored in table "progress"
 *
 * @author rtorres (Heroku)
 *
 */

@Entity
@Table(name="progress", schema="public" )
@Immutable

// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Progress.countAll", query="SELECT COUNT(x) FROM Progress x" )
} )
public class Progress implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private Long id; // The row number!
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    @Column(name="owner", length=18)
    private String     owner        ;


    @Column(name="status", length=255)
    private String     status       ;


    @Column(name="goals_amount")
    private Double     amount       ;


    @Column(name="goals")
    private Long       count        ;


    @Column(name="progress")
    private Double     progress     ;


    @Temporal(TemporalType.DATE)
    @Column(name="start_date")
    private Date       start        ;


    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date       end          ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Progress()
    {
		super();
    }

    public Progress update(Progress a) {
        this.owner = a.owner;
        this.status = a.status;
        this.amount = a.amount;
        this.count = a.count;
        this.progress = a.progress;
        this.start = a.start;
        this.end = a.end;



		return a;
	}

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : owner ( varchar ) 
    public void setOwner( String owner )
    {
        this.owner = owner;
    }
    public String getOwner()
    {
        return this.owner;
    }

    //--- DATABASE MAPPING : status ( varchar ) 
    public void setStatus( String status )
    {
        this.status = status;
    }
    public String getStatus()
    {
        return this.status;
    }

    //--- DATABASE MAPPING : goals_amount ( float8 ) 
    public void setAmount( Double amount )
    {
        this.amount = amount;
    }
    public Double getAmount()
    {
        return this.amount;
    }

    //--- DATABASE MAPPING : goals ( int8 ) 
    public void setCount( Long count )
    {
        this.count = count;
    }
    public Long getCount()
    {
        return this.count;
    }

    //--- DATABASE MAPPING : progress ( float8 ) 
    public void setProgress( Double progress )
    {
        this.progress = progress;
    }
    public Double getProgress()
    {
        return this.progress;
    }

    //--- DATABASE MAPPING : start_date ( date ) 
    public void setStart( Date start )
    {
        this.start = start;
    }
    public Date getStart()
    {
        return this.start;
    }

    //--- DATABASE MAPPING : end_date ( date ) 
    public void setEnd( Date end )
    {
        this.end = end;
    }
    public Date getEnd()
    {
        return this.end;
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
        sb.append(owner);
        sb.append("]:"); 
        sb.append(status);
        sb.append("|");
        sb.append(amount);
        sb.append("|");
        sb.append(count);
        sb.append("|");
        sb.append(progress);
        sb.append("|");
        sb.append(start);
        sb.append("|");
        sb.append(end);
        return sb.toString(); 
    } 

}