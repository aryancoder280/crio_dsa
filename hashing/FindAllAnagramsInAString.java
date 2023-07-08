package hashing;

import java.util.*;
import java.util.Map.Entry;
// Implement your solution here
class FindAllAnagramsInAString {

        Map<Character,Integer>stringMap = new HashMap<Character,Integer>();
        Map<Character,Integer>patternMap = new HashMap<Character,Integer>();
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int window = p.length();
        
        List<Integer>list = new ArrayList<Integer>();
        if(window>n) {
            return list;
        }
        for(int i=0;i<window;i++) {
            Character stringChar = s.charAt(i);
            Character patternChar = p.charAt(i);
            
            stringMap.putIfAbsent(stringChar,0);
            stringMap.put(stringChar,stringMap.get(stringChar)+1);

            patternMap.putIfAbsent(patternChar,0);
            patternMap.put(patternChar,patternMap.get(patternChar)+1);
        }
        if(stringMap.equals(patternMap)) {
            list.add(0);
        }
        //System.out.println(list);
        for(int i=window;i<s.length();i++) {
            int ind = i-window;
            Character c = s.charAt(ind);
            int val = stringMap.get(c);
            if(val == 1) {
                stringMap.remove(c);
            }
            else {
                stringMap.put(c,val-1);
            }
            stringMap.putIfAbsent(s.charAt(i),0);
            stringMap.put(s.charAt(i),stringMap.get(s.charAt(i))+1);
            if(stringMap.equals(patternMap)) {
                list.add(i-window+1);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String[] input = new String[2]; 
	    input = scanner.nextLine().split(" ");
        String s = input[0];
        String p = input[1];
        scanner.close();

        List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s,p);
	    System.out.println(result.size());
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d ", result.get(i));
        }
    }
}

/* 
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output

Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving and see if you can recollect solving similar problems in the past
      a. Obvious logic (this would only test ability to convert logic to code)
      b. Figuring out logic
      c. Knowledge of specific algorithm, data structure or pattern
      d. Knowledge of specific domain or concepts
      e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one based on the TC/SC requirements
3. Get to a point where you can explain your approach to a 10 year old

Milestone 3 : Come up with an Instruction Manual for a 10 year old
1. Take a stab at the high-level logic & write it down like a detailed Instruction Manual for a 10 Year old where each line of the manual can be expanded into a logical line(s) of code.
2. Try to offload logic out of the main section as much as possible by delegating to functions.

Milestone 4: Code by expanding your 10 Year Olds "Instruction Manual
1. Run your code snippets at every logical step to test correctness (Helps avoid debugging larger pieces of code later)
2. Make sure you name the variables, functions clearly.
3. Use libraries as much as possible

Milestone 5: Prove that your code works using custom test cases
1. Make sure you check boundary conditions and other test cases you noted in Milestone 1
      a. If compiler is not available, dry run your code on a whiteboard or paper
2. Suggest optimizations if applicable during interviews
*/