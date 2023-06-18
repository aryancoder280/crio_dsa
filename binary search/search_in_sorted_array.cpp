#include "../crio/cpp/io/FastIO.hpp"
#include "../crio/cpp/io/PrintMatrix.hpp"
#include "../crio/cpp/io/ReadMatrix.hpp"
#include <bits/stdc++.h>
using namespace std;

class SearchInRotatedSortedArray {
  public:
    int search(vector<int>& arr, int target) {
        // Your implementation goes here
        int ans= -1;
        int l = 0, r = arr.size()-1;
        while(l<r) {

            int mid = l + (r-l)/2;
            //cout<<"new "<<l<<" "<<r<<" "<<mid<<endl;
            if(arr[mid] == target) {
                ans = mid;
                break;
            }
            //cout<<l<<" "<<r<<" "<<mid<<endl;
            if(arr[l]<=arr[mid]) {
                //cout<<"in 1"<<endl;
                if(arr[l]<=target && target<arr[mid]) {
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            else if(arr[r]>=arr[mid]) {
                //cout<<"in 2"<<endl;
                //cout<<arr[mid]<<" "<<target<<" "<<arr[r]<<endl;
                if(arr[mid]<target && target<=arr[r]) {
                    l = mid+1;
                    //cout<<"l="<<l<<endl;
                }
                else {
                    r = mid-1;
                }
            }
        }
        if(arr[l] == target) ans = l;
    	return ans;
    }
};

int main() {
    FastIO();
    int n;
    cin >> n;
    vector<int> nums;
    ReadMatrix<int>().OneDMatrix(n, nums);

    int queries;
    cin >> queries;
    for (int i = 0; i < queries; i++) {
        int target;
        cin >> target;
        int result = SearchInRotatedSortedArray().search(nums, target);
        cout << result << "\n";
    }

    return 0;
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
