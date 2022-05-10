package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {
	
	List<ScoreInfo> scoreData = new ArrayList<>();
	Stream<ScoreInfo> scoreStream;
	
	public void addData(ScoreInfo data) {
		scoreData.add(data);
	}
	
	public int getNumScores() {
		scoreStream = scoreData.stream();
		
		return (int) scoreStream.count();
	}
	
	public double getAverage() {
		scoreStream = scoreData.stream();
		
		Function<ScoreInfo, Integer> mapScoreInfoToInteger = (s) -> {
			return s.getScore();
		};
		
		double avgScore = scoreStream.map(mapScoreInfoToInteger)
				.mapToInt(Integer::intValue).average().orElse(0);
		
		return avgScore;
	}
	
	public int getNumberAListers() {
		scoreStream = scoreData.stream();
		
		Predicate<ScoreInfo> filterGreaterThanOrEqual90 = (s) -> {
			if(s.getScore() >= 90) {
				return true;
			}
			return false;
		};
		
		return (int) scoreStream.filter(filterGreaterThanOrEqual90).count();
	}
	
	public List<String> getFailingStudentList() {
		scoreStream = scoreData.stream();
		
		Predicate<ScoreInfo> filterLessThan70 = (s) -> {
			if(s.getScore() < 70) {
				return true;
			}
			return false;
		};
		
		Function<ScoreInfo, String> mapSIToString = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};
		
		return scoreStream.filter(filterLessThan70).map(mapSIToString)
				.collect(Collectors.toList());
	}
	
	public void printPassingStudents() {
		scoreStream = scoreData.stream();
		
		Predicate<ScoreInfo> filterGreaterThanOrEqual70 = (s) -> {
			if(s.getScore() >= 70) {
				return true;
			}
			return false;
		};
		
		Function<ScoreInfo, String> mapSIToString = (s) -> {
			return String.join(" ", s.getFirstName(), s.getLastName());
		};
		
		scoreStream.filter(filterGreaterThanOrEqual70).map(mapSIToString).forEach((s) -> {
			System.out.println(s);
		});
		
	}
	
	public void displayAllStudents() {
		scoreStream = scoreData.stream();
		
		Comparator<ScoreInfo> sortedAscLastName = (s1, s2) -> {
			if(s1.getLastName().compareTo(s2.getLastName()) == 0) {
				return 0;
			} else if(s1.getLastName().compareTo(s2.getLastName()) > 0) {
				return 2;
			} else {
				return -2;
			}
		};
		
		scoreStream.sorted(sortedAscLastName).forEach((s) -> {
			System.out.println(String.join(" ", s.getFirstName(), s.getLastName(), String.valueOf(s.getScore())));
		});
	}
	
	public List<ScoreInfo> getStudentRecords() {
		scoreStream = scoreData.stream();
		
		Comparator<ScoreInfo> sortedAscScore = (s1, s2) -> {
			if(s1.getScore() == s2.getScore()) {
				return 0;
			} else if(s1.getScore() > s2.getScore()) {
				return 2;
			} else {
				return -2;
			}
		};
		
		return scoreStream.sorted(sortedAscScore).collect(Collectors.toList());
	}
	
}
