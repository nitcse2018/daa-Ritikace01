#include<iostream>
using namespace std;

int main()
{
    int n, a[10000], sum=0, i, ans=0, j, low=0, high=0, k=0;
    cout << "Enter the size of the array:";
    cin >> n;
    cout << "Enter the array:";
    for(i=0; i<n; i++)
        cin >> a[i];

    ans = 0;
    for(i=0; i<n; i++)
        {
            sum = 0;
        for(j=0; j<n; j++)
        {
            sum = sum + a[j];
            if(sum>ans)
                {
                    ans = sum;
                low = i;
                high = j;
                }
        }
        }
    cout << "The max-sum subarray is:";
    for(k=low; k<=high; k++)
        cout << a[k] << endl;
    cout << "The max sum is:" << ans << endl;
    return 0;
}
