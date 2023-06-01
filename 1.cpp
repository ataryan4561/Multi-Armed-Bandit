#include<bits/stdc++.h>
#define ll long long 
#define f float 
#define loop(i,n) for(ll i=0; i<n; i++)
using namespace std;
int main()
{
    ll arms,days;
    cin>>arms>>days;
    srand(time(0));
    vector<vector<f>> data(arms,vector<f> (days,0));
    loop(i,arms)
    {
        loop(j,days)
        {
            data[i][j]=((f)(rand()) / (f)(RAND_MAX));
        }
    }
    vector<f> rew(arms,0);
    vector<ll> pulls(arms,0);
    vector<f> ucb(arms,0);
    loop(i,days)
    {
        if(i<arms)
        {
            rew[i]+=data[i][i];
            pulls[i]++;
        }
        else
        {
            f maxi=0;
            ll ml=0;
            loop(g,arms)
            {
                ucb[g]+=((rew[g]/pulls[g])+(2*log(i)/pulls[g]));
                if(ucb[g]>maxi)
                {
                    maxi=ucb[g];
                    ml=g;
                }
            }
            pulls[ml]++;
            rew[ml]+=data[ml][i];
        }
    }
    priority_queue<pair<ll,ll>> gq;
    loop(i,arms)
    {
        gq.push({pulls[i],i+1});
    }
    loop(i,arms)
    {
        cout<<"The pull up are for "<<i+1<<" -> "<<pulls[i]<<endl;
    }
    cout<<gq.top().first<<" "<<gq.top().second<<endl;
}