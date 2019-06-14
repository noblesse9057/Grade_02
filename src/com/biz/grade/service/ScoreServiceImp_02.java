package com.biz.grade.service;

import java.util.Random;
import java.util.Scanner;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_02 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd;
	Scanner scan;

	/*
	 * 생성자가 매개변수를 달리해서
	 * 중복되어 만들어지고 있다.
	 * 이렇게 되면 생성자에서 실행할 코드들이
	 * 같은코드가 반복되는 불편한 상황이 된다.
	 * 
	 * 매개변수가 없는 생성자에서
	 * 매개변수(배열의 개수)가 있는 생성자를 호출할수 있는
	 * 방법이 있으면 좋겠다!
	 */
	
	public ScoreServiceImp_02() {

//		scArray = new ScoreVO[10];
//		rnd = new Random();
//		scan = new Scanner(System.in);
		// 나자신에게 10이란 값을 전달하는 생성자를 호출하라
		// 매개변수가 있는 생성자를 호출하는 코드
		this(10);
	}

	// 배열의 개수를 매개변수로 받는 생성자
	public ScoreServiceImp_02(int arrLen) {
		scArray = new ScoreVO[arrLen];
		rnd = new Random();
		scan = new Scanner(System.in);
	}
	/*
	 * 키보드에서 성적을 입력받아서 scArray추가 --End 문자열을 입력받으면 종료
	 */

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		
		System.out.println((number+1)+"번 국어점수(종료:END");
		String strKor = scan.nextLine();
		int intKor = Integer.valueOf(strKor);
		
		System.out.println((number+1)+"번 영어점수");
		String strEng = scan.nextLine();
		int intEng = Integer.valueOf(strEng);
		
		System.out.println((number+1)+"번 수학점수");
		String strMath = scan.nextLine();
		int intMath = Integer.valueOf(strMath);

		ScoreVO vo = new ScoreVO();
		vo.setNumber(number+1)
		;
		vo.setKor(intKor);
		vo.setEng(intEng);
		vo.setMath(intMath);
		
		return false;
	}
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