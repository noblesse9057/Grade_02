package com.biz.grade.service;

import java.util.Random;
import java.util.Scanner;

import com.biz.grade.model.ScoreVO;

public class ScoreServiceImp_02 implements ScoreService {

	ScoreVO[] scArray;
	Random rnd;
	Scanner scan;

	/*
	 * �����ڰ� �Ű������� �޸��ؼ�
	 * �ߺ��Ǿ� ��������� �ִ�.
	 * �̷��� �Ǹ� �����ڿ��� ������ �ڵ����
	 * �����ڵ尡 �ݺ��Ǵ� ������ ��Ȳ�� �ȴ�.
	 * 
	 * �Ű������� ���� �����ڿ���
	 * �Ű�����(�迭�� ����)�� �ִ� �����ڸ� ȣ���Ҽ� �ִ�
	 * ����� ������ ���ڴ�!
	 */
	
	public ScoreServiceImp_02() {

//		scArray = new ScoreVO[10];
//		rnd = new Random();
//		scan = new Scanner(System.in);
		// ���ڽſ��� 10�̶� ���� �����ϴ� �����ڸ� ȣ���϶�
		// �Ű������� �ִ� �����ڸ� ȣ���ϴ� �ڵ�
		this(10);
	}

	// �迭�� ������ �Ű������� �޴� ������
	public ScoreServiceImp_02(int arrLen) {
		scArray = new ScoreVO[arrLen];
		rnd = new Random();
		scan = new Scanner(System.in);
	}
	/*
	 * Ű���忡�� ������ �Է¹޾Ƽ� scArray�߰� --End ���ڿ��� �Է¹����� ����
	 */

	@Override
	public boolean inputScore(int number) throws NumberFormatException {
		
		System.out.println((number+1)+"�� ��������(����:END");
		String strKor = scan.nextLine();
		int intKor = Integer.valueOf(strKor);
		
		System.out.println((number+1)+"�� ��������");
		String strEng = scan.nextLine();
		int intEng = Integer.valueOf(strEng);
		
		System.out.println((number+1)+"�� ��������");
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
		// ������ �������� �������� ������ ����
		// rank ���� �������ش�
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

		System.out.println("�����͹� ����ǥ");
		System.out.println("=====================================");
		System.out.println("�й�\t����\t����\t����\t����\t���\t����;");
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