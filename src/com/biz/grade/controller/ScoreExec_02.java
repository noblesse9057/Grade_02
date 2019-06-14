package com.biz.grade.controller;

import java.io.FileNotFoundException;

import com.biz.grade.service.ScoreService;
import com.biz.grade.service.ScoreServiceImp_04;

public class ScoreExec_02 {
	
	public static void main(String[] args) {
		String scoreFile = "src/com/biz/grade/data/score.tet";
		
		/* try ������ ����ߵǴ� ��ɹ��� �������
		 * try �� �ȿ��� ��ü��, ������ �����ϸ�
		 * try ���ȿ� ��� �ڵ带 ���߽��Ѿ� �Ѵ�.
		 * 
		 * �׷��� ���𹮰� �������� ������ �и��ϴ°��� ����.
		 */
		ScoreService sService = null; //����
		try {
			
			// ������
			 sService = new ScoreServiceImp_04(10, scoreFile);
			 sService.inputScore(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sService.inputScore(0);
		sService.viewList();
		
		
		
		
	}

}
