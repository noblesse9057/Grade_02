package com.biz.grade.controller;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWriter_01 {

	public static void main(String[] args) {

		String scoreFile = "src/com/biz/grade/data/score_01.txt";

		FileWriter fileWriter;
		PrintWriter printer;
		try {
			fileWriter = new FileWriter(scoreFile);
			printer = new PrintWriter(fileWriter);
			
			for(int i =0; i< 100; i++) {
				System.out.println(i);
			}
			printer.flush();
			printer.close();
			fileWriter.close();
			System.out.println("파일기록완료");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("알수없는 이유로 파일생성못함");
		}
	}
}