package org.ssglobal.training.codes;

public class TestScore {

	public static void main(String[] args) {
		Score s = new Score();
		
		s.addData(new ScoreInfo("Smith","John",70));
		s.addData(new ScoreInfo("Doe","Mary",85));
		s.addData(new ScoreInfo("Page","Alice",82));
		s.addData(new ScoreInfo("Cooper","Jill",97));
		s.addData(new ScoreInfo("Flintstone","Fred",66));
		s.addData(new ScoreInfo("Rubble","Barney",80));
		s.addData(new ScoreInfo("Smith","Judy",48));
		s.addData(new ScoreInfo("Dean","James",90));
		s.addData(new ScoreInfo("Russ","Joe",55));
		s.addData(new ScoreInfo("Wolfe","Bill",73));
		s.addData(new ScoreInfo("Dart","Mary",54));
		s.addData(new ScoreInfo("Rogers","Chris",78));
		s.addData(new ScoreInfo("Toole","Pat",51));
		s.addData(new ScoreInfo("Khan","Omar",93));
		s.addData(new ScoreInfo("Smith","Ann",95));
		
		System.out.println(s.getNumScores());
		System.out.println(s.getAverage());
		System.out.println(s.getNumberAListers());
		System.out.println(s.getFailingStudentList());
		s.printPassingStudents();
		s.displayAllStudents();
		System.out.println(s.getStudentRecords());
		
	}

}
