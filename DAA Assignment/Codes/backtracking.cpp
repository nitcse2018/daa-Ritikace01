#include <iostream>
#include <stack>
using namespace std;

int set[] = {5,10,12,13,15,18};
int numberOfElements = 6, sum = 30;

class SubSet{
public:
  stack<int> solutionSet;
  bool hasSolution;

  bool solve(int s, int idx){
    //return false if s value exceed sum
    if(s>sum)
        return false;

    //check if stack has the right subsets of numbers
    if(s==sum){
        hasSolution = true;
        //display stack contents
        displaySolutionSet();
        //Though found a solution but deliberately
        //returning false to find more
        return false;
    }

    for(int i=idx; i<numberOfElements; i++){
        //Adding element to the stack
        solutionSet.push(set[i]);
        //add set[i] to the 's' and recusively start from next number
        if(solve(s+set[i],i+1)){
            return true;
        }
        //found false
        //Removing element from stack i.e Backtracking
        solutionSet.pop();
    }
    //no Combination found
    return false;
  }

  //Function to display stack content
  void displaySolutionSet(){
        stack<int> temp;
        while (!solutionSet.empty())
        {
            cout <<  solutionSet.top() << " ";
            temp.push(solutionSet.top());
            solutionSet.pop();
        }
        cout << '\n';
        while (!temp.empty())
        {
            solutionSet.push(temp.top());
            temp.pop();
        }
    }
};

int main()
{
    SubSet ss;
    ss.solve(0,0);
	if(ss.hasSolution == false)
	    cout << "No Solution";

    return 0;
}
