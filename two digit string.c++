#include <vector>
#include <unordered_map>
#include <iostream>
using namespace std;
void solve(){
    string x,y; cin>> x >> y;
    int R=x.length(), C=y.length();
    vector<int> mx(R),my(C);
    mx[0]=x[0]-'0';
    my[0]=y[0]-'0';
    for(int i=1;i<R;i++){
        mx[i]=(mx[i-1]+(x[i]-'0'))%10;
    }
    for(int i=1;i<C;i++){
        my[i]=(my[i-1]+(y[i]-'0'))%10;
    }
    if(mx[R-1]!=my[C-1]){
        cout<<-1<<endl;
        return;
    }
    vector<vector<int>> dp(R+1,vector<int>(C+1,0));
    for(int row=1;row<=R;row++){
        for(int col=1;col<=C;col++){
            if(mx[row-1]==my[col-1]){
                dp[row][col]=dp[row-1][col-1]+1;
            }else{
                dp[row][col]=max(dp[row-1][col],dp[row][col-1]);
            }
        }
    }
    cout<<dp[R][C]<<endl;
}
int main(){
    int t; cin>>t;
    while(t--){
        solve();
    }
}
