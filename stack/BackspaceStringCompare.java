package stack;

import java.util.*;

class BackspaceStringCompare {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            String S = sc.next();
            String T = sc.next();

            boolean res = backspaceStringCompare(S, T);

            if (res)
                System.out.println(true);
            else
                System.out.println(false);

        }
    }

    static boolean backspaceStringCompare(String S, String T) {
        Stack<Character>s1 = new Stack<Character>();
        Stack<Character>s2 = new Stack<Character>();
        int i=0;
        while(i<S.length()) {
        	char c = S.charAt(i);
        	if(c == '#') {
        		if(!s1.empty()) s1.pop();
        	}
        	else {
        		s1.push(c);
        	}
        	i++;
        }
        i = 0;
        while(i<T.length()) {
        	char c = T.charAt(i);
        	if(c == '#') {
        		if(!s2.empty()) s2.pop();
        	}
        	else {
        		s2.push(c);
        	}
        	i++;
        	
        }
        if(s1.size() == s2.size()) {
        	while(!s1.empty() && !s2.empty() && s1.peek() == s2.peek()) {
        		
        		s1.pop();
        		s2.pop();
        	}
        	if(s1.size()==0 && s2.size()==0) {
        		return true;
        	}
        }
        
        	return false;
    }

}