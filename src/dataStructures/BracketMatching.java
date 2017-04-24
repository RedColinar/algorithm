package dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//括号匹配
public class BracketMatching {
	public static void main(String[] args) throws Exception {
		System.out.println("先输入一组括号组合，以0表示结束。支持的括号包括：{},(),[],<>。");
		matching();
	}
	
	public static void matching() throws Exception{
		Stack<Character> s = new Stack<>();
		s.setSize(0);
		char ch,temp;
		int match;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ch = (char)reader.read();
		while(ch != '0'){
			if(s.isEmpty()){
				s.push(ch);
			}else{
				temp = s.pop();
				match = 0;
				if(temp == '(' && ch ==')'){
					match = 1;
				}
				if(temp == '[' && ch ==']'){
					match = 1;
				}
				if(temp == '<' && ch =='>'){
					match = 1;
				}
				if(temp == '{' && ch =='}'){
					match = 1;
				}
				if(match == 0){
					s.push(temp);
					s.push(ch);
				}
			}
			ch = (char)reader.read();
		}
		if(s.isEmpty()){
			System.out.println("完全匹配！");
		}else{
			System.out.println("不完全匹配！");
		}
	}
}
