package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Match implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "team1")
	String team1;
	@Column(name = "team2")
	String team2;
	@Column(name = "city")
	String city;
	@Column(name = "date")
	String date;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "series_id")
	private Series series;
	
	
	public Match() {
		super();
	}

	public Match(String team1, String team2, String city, String date) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.city = city;
		this.date = date;
	}





	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTeam1() {
		return team1;
	}


	public void setTeam1(String team1) {
		this.team1 = team1;
	}


	public String getTeam2() {
		return team2;
	}


	public void setTeam2(String team2) {
		this.team2 = team2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Series getSeries() {
		return series;
	}


	public void setSeries(Series series) {
		this.series = series;
	}


	@Override
	public String toString() {
		return "Match [id=" + id + ", team1=" + team1 + ", team2=" + team2 + ", city=" + city + ", date=" + date
				+ ", series=" + series + "]";
	}
	
	
}
