#include <bits/stdc++.h>

using namespace std;


class ThreeSum {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int> > answer;
        set<tuple<int,int,int>>s;
        int n = nums.size();
        unordered_map<int,int>mp;
        for(int i=0;i<n;i++) {
            if(mp.find(nums[i]) == mp.end()) mp[nums[i]] = 1;
            else {
                mp[nums[i]]++;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int a = nums[i];
                int b = nums[j];
                int c = a+b;
                int search = -c;
                cout<<a<<" "<<mp[a]<<" "<<b<<" "<<mp[b]<<" "<<c<<endl;
                mp[a]--;
                mp[b]--;

                if(mp.find(search)!=mp.end() && mp[search]!=0) {
                    c = search;
                    cout<<"search ="<<c<<endl;
                    tuple<int,int,int>tp;
                    if(a>b) swap(a,b);
                    if(a>c) swap(a,c);
                    if(b>c) swap(b,c);
                    cout<<"afer swapping="<<a<<" "<<b<<" "<<c<<endl;
                    tp = make_tuple(a,b,c);
                    s.insert(tp);
                }
                mp[a]++;
                mp[b]++;

            }
        }
        for(auto x:s) {
            vector<int>v;
            v.push_back(get<0>(x));
            v.push_back(get<1>(x));
            v.push_back(get<2>(x));
            answer.push_back(v);
        }
        return answer;
    }
};

int main() {
//    FastIO();
    int n;
    cin >> n;
    vector<int> nums;
    ReadMatrix<int>().OneDMatrix(n, nums);

    vector<vector<int>> result = ThreeSum().threeSum(nums);
    for (unsigned int i = 0; i < result.size(); i++) {
        cout << result[i][0] << " " << result[i][1] << " " << result[i][2];
        cout << endl;
    }
    return 0;
}

/*
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. *Type down* an example or two to confirm your understanding of the input/output & extend it to test cases

Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving.
     a. Obvious logic, tests ability to convert logic to code
     b. Figuring out logic
     c. Knowledge of specific domain or concepts
     d. Knowledge of specific algorithm
     e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one
3. Get to a point where you can explain your approach to a 10 year old
4. Take a stab at the high-level logic & *type it down*.
5. Try to offload processing to functions & keeping your main code small.

Milestone 3: Code by expanding your pseudocode
1. Have frequent runs of your code, dont wait for the end
2. Make sure you name the variables, functions clearly.
3. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
4. Use libraries as much as possible

Milestone 4: Prove to the interviewer that your code works with unit tests
1. Make sure you check boundary conditions
2. Time & storage complexity
3. Suggest optimizations if applicable
*/
