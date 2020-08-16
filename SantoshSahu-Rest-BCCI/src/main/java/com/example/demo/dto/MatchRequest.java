package com.example.demo.dto;

import com.example.demo.model.Series;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatchRequest {

	private Series series;

	public Series getSeries() {
		//System.out.println(series);
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}
	
}
