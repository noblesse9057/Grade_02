package com.biz.grade.service;

import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd;

	public ScoreServiceImp_01() {

		scArray = new ScoreVO[10];
		rnd = new Random();
	}

	public ScoreServiceImp_01(int arrLen) {
		scArray = new ScoreVO[arrLen];
		rnd = new Random();
	}

	@Override
	public void total() {
		for (ScoreVO vo : scArray) {
			int intTotal = vo.getKor();
			intTotal += vo.getEng();
			intTotal += vo.getMath();

			vo.setTotel(intTotal);
			vo.setAverage(intTotal / 3);

		}

	}

	@Override
	public void rank() {
		// 총점을 기준으로 내림차순 정렬을 수행
		// rank 값을 대입해준다
		for (int i = 0; i < scArray.length; i++) {
			for (int j = i + 1; j < scArray.length; j++) {
				if (scArray[i].getTotel() < scArray[j].getTotel()) {
					ScoreVO _score = scArray[i];
					scArray[i] = scArray[j];
					scArray[j] = _score;
				}
			}

		}
		int rank = 0;
		for (ScoreVO vo : scArray) {
			vo.setRank(++rank);
		}
	}

	@Override
	public int deptAvg() {
		int avgTotal = 0;
		for (ScoreVO vo : scArray) {
			avgTotal += vo.getAverage();
		}
		avgTotal /= scArray.length;
		return avgTotal;

	}

	@Override
	public void deptAvgView() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean inputScore(int number) throws NumberFormatException {

		// 난수를 만들어서 3개의 성적 생성
		// scArray[number] = new ScoreVO();
		ScoreVO vo = new ScoreVO();

		int intKor = rnd.nextInt(50) + 51;
		int intEng = rnd.nextInt(50) + 51;
		int intMath = rnd.nextInt(50) + 51;
		vo.setNumber(number + 1);
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);
		scArray[number] = vo;

		return false;
	}

	@Override
	public void viewList() {

		System.out.println("빅데이터반 성적표");
		System.out.println("=====================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t순위;");
		for (ScoreVO vo : scArray) {
			System.out.print(vo.getNumber() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getTotel() + "\t");
			System.out.print(vo.getAverage() + "\t");

			System.out.println(vo.getRank() + "\n");
		}

	}

}
