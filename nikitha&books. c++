#include <iostream>
#include <vector>
using namespace std;
void solve(){
    int N; cin>>N;
    vector<int> a(N+1);
    for(int i=1;i<=N;i++) cin>>a[i];
    int bal=0;
    bool ok=true;
    for(int stk=1;stk<=N;stk++){
        if(a[stk]>=stk) bal+=(a[stk]-stk);
        else{
            int need=stk-a[stk];
            if(bal<need){
                ok=false;
                break;
        } 
        bal-=need;
    }
}
    if(ok) cout<<"YES"<<endl;
    else cout<<"NO"<<endl;
}
