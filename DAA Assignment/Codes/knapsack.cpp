#include<iostream>
using namespace std;

int main()
{
    int p[5] = {1, 2, 5, 6};
    int wt[5] = {2, 3, 4, 5};
    int m = 8;
    int n = 4;
    int k[5][9];
    int i, w;

    for(i=0; i<=n; i++)
    {
        for(w=0; w<=m; w++)
        {
            if(i == 0 || w == 0)
                k[i][w] = 0;
            else if(wt[i] <= w)
                k[i][w] = max(k[i-1][w], (k[i-1][w-wt[i]] + p[i]));
            else
                k[i][w] = k[i-1][w];
        }
    }
    while(i<=n && w<=m)
    {
        if(k[i][w] == k[i-1][w])
    {
        cout << i << "= 0" << endl;
        i--;
    }
    else
    {
        cout << i << "= 1" << endl;
        i--;
        w = w - wt[i];
    }
}
}
