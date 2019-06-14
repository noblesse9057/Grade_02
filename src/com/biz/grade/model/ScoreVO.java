package com.biz.grade.model;

public class ScoreVO {

	private int Number;
	private int kor;
	private int Eng;
	private int Math;
	private int Totel;
	private int Average;
	private int Rank;
	
	
	
	
	
	
	public ScoreVO(int number, int kor, int eng, int math, int totel, int average, int rank) {
		super();
		Number = number;
		this.kor = kor;
		Eng = eng;
		Math = math;
		Totel = totel;
		Average = average;
		Rank = rank;
	}
	public ScoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return Eng;
	}
	public void setEng(int eng) {
		Eng = eng;
	}
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		Math = math;
	}
	public int getTotel() {
		return Totel;
	}
	public void setTotel(int totel) {
		Totel = totel;
	}
	public int getAverage() {
		return Average;
	}
	public void setAverage(int average) {
		Average = average;
	}
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}
	@Override
	public String toString() {
		return "ScoreVO [Number=" + Number + ", kor=" + kor + ", Eng=" + Eng + ", Math=" + Math + ", Totel=" + Totel
				+ ", Average=" + Average + ", Rank=" + Rank + "]";
	}
	
	
	
}