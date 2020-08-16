package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "series")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Series implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "series_name")
	String series_name;
	
	@Column(name = "start_date")
	java.util.Date start_date;
	
	@Column(name = "end_date")
	java.util.Date end_date;
	
	@OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
	private List<Match> match;

	public Series() {
		super();
	}

	

	public Series(String series_name, Date start_date, Date end_date) {
		super();
		this.series_name = series_name;
		this.start_date = start_date;
		this.end_date = end_date;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String series_name) {
		this.series_name = series_name;
	}

	public java.util.Date getStart_date() {
		return start_date;
	}

	public void setStart_date(java.util.Date start_date) {
		this.start_date = start_date;
	}

	public java.util.Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}

	

	public List<Match> getMatch() {
		return match;
	}



	public void setMatch(List<Match> match) {
		this.match = match;
	}



	@Override
	public String toString() {
		return "Series [id=" + id + ", series_name=" + series_name + ", start_date=" + start_date + ", end_date="
				+ end_date + ", match=" + match + "]";
	}
		
	
	}
