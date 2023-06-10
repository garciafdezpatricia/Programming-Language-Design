package parser;

import ast.types.Int;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public static char lexemeToChar(String str){
		try{
			int length = str.length();
			char first = str.charAt(0); // first character (must be ')
			char last = str.charAt(length-1); // last character (must be ')
			char apostrophe = '\'';

			// the syntax is right
			if (first == apostrophe && last == apostrophe){
				// just one character
				if (length == 3 && str.charAt(1) != '\''){
					return str.charAt(1);
				}
				// special characters \n, \t and \'
				if (length == 4 && str.charAt(1) == '\\'){
					if (str.charAt(2) == 'n')
						return '\n';
					else if (str.charAt(2) == 't')
						return '\t';
					else if (str.charAt(2) == '\'')
						return '\'';
				}
				// ascii code
				if (length > 4 && str.charAt(1) == '\\'){
					String num = "";
					for (int i = 2; i < str.toCharArray().length -1; i++){
						num += str.charAt(i);
					}
					int n = Integer.parseInt(num);
					return (char) n;
				}
			}
		} catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		return '0';
	}
}
