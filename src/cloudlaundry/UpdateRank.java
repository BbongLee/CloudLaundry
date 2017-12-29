package cloudlaundry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


class RankReadWrite {
	String[] user = new String[6];
	int[] score = new int[6];
	int[] num = new int[6];
	private BufferedReader br;

	public void readingData(String fname, String user1, int score1) throws IOException {
		try {
			FileReader fr = new FileReader(new File(fname));
			br = new BufferedReader(fr);
			String csvStr = "";
			String tmpStr = "";
			do {
				tmpStr = br.readLine();
				if (tmpStr != null) {
					csvStr += tmpStr + "\t";
				}
			} while (tmpStr != null);
			StringTokenizer parse = new StringTokenizer(csvStr, "\t");

			for (int j = 0; j < 5; j++) {
				parse.nextToken();
				num[j] = 0;
				user[j] = parse.nextToken();
				score[j] = Integer.parseInt(parse.nextToken());

			}
			user[5] = user1;
			score[5] = score1;
			System.out.println("" + user[5] + " " + score[5]);
		} catch (FileNotFoundException e) {
			System.out.println("잘못된 파일이름입니다.");
		}
	}

	public void CompareScore() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (score[i] > score[j]) {
					num[j]++;
				}
			}
			System.out.println(score[i] + "  점 " + num[i]);
		}
	}

	public void writingData(String fname, boolean append) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(fname));
			bw = new BufferedWriter(fw);

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j <= 5; j++) {
					if ((i) == num[j]) {
						bw.write((i + 1) + "\t" + user[j] + "\t" + score[j]);
						System.out.println((num[j] + 1) + "\t" + user[j] + "\t" + score[j]);
						bw.newLine();
					}
				}
			}
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			System.out.println("잘못된 파일 이름을 입력했습니다.");
		}
	}
}

public class UpdateRank {
	String user = "user";
	int score = 0;

	public UpdateRank(String user, int score) {
		this.user = user;
		this.score = score;

		RankReadWrite rw = new RankReadWrite();
		try {
			rw.readingData("rank.txt", user, score);
			rw.CompareScore();
			rw.writingData("rank.txt", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}