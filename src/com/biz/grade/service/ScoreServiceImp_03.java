package com.biz.grade.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_03 implements ScoreService {
	
	List<ScoreVO> scList;
	Random  rnd;
	
	public ScoreServiceImp_03() {
		scList = new ArrayList<ScoreVO>();
		rnd =new Random();
	}

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		
		int intKor =rnd.nextInt(50)+51;
		int intEng =rnd.nextInt(50)+51;
		int intMath =rnd.nextInt(50)+51;
		
		
		
		return false;
	}

	@Override
	public void total() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rank() {
		
		Collections.sort(scList, new Comparator<ScoreVO>() {
			
			// first가 앞에오면 ASC
			// second가 앞에오면 DESC
			
			@Override
			public int compare(ScoreVO first, ScoreVO second) {
				// TODO Auto-generated method stub
				return second.getTotel() - first.getTotel();
			}
		});
		int rank =0;
		for(ScoreVO vo : scList) {
			vo.setRank(++rank);
		}
		Collections.sort(scList, new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO first, ScoreVO second) {
				// TODO Auto-generated method stub
				return first.getNumber() - second.getNumber();
			}
		});
	}

	@Override
	public void viewList() {
		System.out.println("빅데이터반 성적표");
		System.out.println("=====================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t순위;");
		for (ScoreVO vo : scList) {
			System.out.print(vo.getNumber() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.print(vo.getMath() + "\t");
			System.out.print(vo.getTotel() + "\t");
			System.out.print(vo.getAverage() + "\t");

			System.out.println(vo.getRank() + "\n");
		}
	}
		
	

	@Override
	public int deptAvg() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deptAvgView() {
		// TODO Auto-generated method stub
		
	}
	

}
