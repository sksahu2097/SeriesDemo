package com.example.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MatchRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Match;
import com.example.demo.model.Series;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.SeriesRepository;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/winsoft/BCCI")
public class BCCIController {
	@Autowired
	private SeriesRepository seriesrepository;
	
	@Autowired
	private MatchRepository matchrepository;
	
	
	//getting all series
	@GetMapping("/series")
	public List<Series> getAllSeries(){
		return seriesrepository.findAll();
	}
	
	//getting all the match
	@GetMapping("/match")
	public List<Match> getAllMatch(){
		return matchrepository.findAll();
	}
	
	//specific series
	@GetMapping("/series/{series_id}")
	public ResponseEntity<Series> getSeriesById(@PathVariable(value = "series_id") long series_id) throws Exception{
		Series series = seriesrepository.findById(series_id)
				.orElseThrow(() -> new ResourceNotFoundException("Series Not found : "+series_id));;
		return ResponseEntity.ok().body(series);
		
	}
	
	//creating a series
	@PostMapping("/series")
	public Series createSeries(@Valid @RequestBody Series series) {
		System.out.println(series);
		return seriesrepository.save(series);
	}
	
	//series update
	@PutMapping("/series/{series_id}")
	public ResponseEntity<Series> updateSeries(@PathVariable(value = "series_id") long series_id, @RequestBody Series seriesdetails) throws Exception{
		Series series = seriesrepository.findById(series_id)
				.orElseThrow(() -> new ResourceNotFoundException("Series Not found : "+series_id));
		series.setSeries_name(seriesdetails.getSeries_name());
		series.setStart_date(seriesdetails.getStart_date());
		series.setEnd_date(seriesdetails.getEnd_date());
		seriesrepository.save(series);
		return ResponseEntity.ok().body(series);	
	}
	
	//delete a series
	@DeleteMapping("/series/{series_id}")
	public ResponseEntity<?> deleteSeries(@PathVariable(value = "series_id") long series_id) throws Exception{
		Series series = seriesrepository.findById(series_id)
				.orElseThrow(() -> new ResourceNotFoundException("Series Not Found : "+series_id));
		seriesrepository.delete(series);
		return ResponseEntity.ok().body("Deleted Successfully");
	}
	
	//series info with match
	
	// get match by specific city and date
	//@GetMapping("/match/{series_id}/{city_name}")
	//public List<Match> getSpecificMatch(@PathVariable(value = "series_id") long series_id, @PathVariable(value = "city_name")){
		//Match match = matchrepository.find
	//}
	//public ResponseEntity<>
	
	
}
