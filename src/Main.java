import java.io.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class 팀이름정하기{
	public static int [] 개수구하기(String line) { 
		String [] name = "LOVE".split("");
		String [] Line =  line.split("");
		
		int [] array = new int [name.length];
		
		for(int i = 0; i < name.length; i++) {  // for each문에는 배열, 리스트 등만 들어갈 수 있다.
			for(int j = 0; j < line.length(); j++) {
				if(name[i].equals(Line[j])) array[i]+=1;
			}
		}
		return array;
	}
	
	public static int 확률구하기(int [] love개수구하기) {
		
		int L = love개수구하기[0];
		int O = love개수구하기[1];
		int V = love개수구하기[2];
		int E = love개수구하기[3];
		
		int result = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100 ;
		return result;
	}
	
}

public class Main{
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner (System.in);
		
		String name = sc.nextLine();
		int num = sc.nextInt();
		sc.nextLine();

		
		int [] total = new int[4]; 
		int [] result = new int[num];
		String [] TeamName = new String[num];
		
		for(int i=0; i<num; i++) {
			TeamName[i] =sc.nextLine();
		}
		
		Arrays.sort(TeamName);
		String answer = "";
		int maxScore = -1;
		
		for(int i = 0; i < num; i++) {
			int [] love개수구하기 = 팀이름정하기.개수구하기(TeamName[i]);
			int [] love이름개수구하기 = 팀이름정하기.개수구하기(name);
			for(int j = 0; j<4; j++) {
				total[j] = love개수구하기[j]+love이름개수구하기[j];
			}
			int score = 팀이름정하기.확률구하기(total);
			
			if(score>maxScore) {
				maxScore = score;
				answer = TeamName[i];
			}
		}
		System.out.println(answer);
		
	}
}
