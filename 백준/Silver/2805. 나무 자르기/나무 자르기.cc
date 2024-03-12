#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void bin(long min,long max,long n,long m, vector<long>tree){
    if((max-min)!=1){
        long h = (max+min)/2;
        // cout <<"max:"<<max<<" min:"<<min<<" h:"<<h<<" ";
        long result = 0;
        for(long i=0; i<n; i++){
            if(tree[i]>h)
                result += tree[i]-h;
            
        }
        // cout << result<<" ";

            if(result<m){
                // cout << "< "<< m << "\n";
                // cout << result << " ";
                bin(min,h,n,m,tree);
            }
            else if(result>m){
                // cout <<"> "<< m << "\n";
                // cout << result<< " ";
                bin(h,max,n,m,tree);
            }
            else{
                cout << h;
            }
        }
    else{
        long result_1 = 0;
        long result_2 = 0;
        for(long i=0; i<n; i++){
            result_1 += tree[i]-max;
            result_2 += tree[i]-min;
        }
        if(result_1<result_2){
            if(result_1>=m){
                cout << max;
            }
            else{
                cout <<min;
            }
        }
        else{
             if(result_2>=m){
                cout << min;
            }
            else{
                cout << max;
            }
        }
        
    }
        

}
int main(){
    long n,m;
    vector <long> tree;
    cin >> n >> m;
    for(long i=0; i<n; i++){
        long t;
        cin >> t;
        tree.push_back(t);
    }
    sort(tree.begin(),tree.end());

    // for(long i=0; i<n; i++){

    //     cout<<tree[i] << " ";
    // }
    bin(0,tree[n-1],n,m,tree);
    return 0;
}