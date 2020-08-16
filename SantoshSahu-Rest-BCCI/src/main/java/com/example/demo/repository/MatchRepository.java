package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
	List<Match> findBySeriesId(Long seriesId);
}
