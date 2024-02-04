#include <iostream>
#include <string>
using namespace std;

class Queue{
    int n;
    int *q;
    // int front=0;
    int back_index=-1;
    public:
        Queue(int n){q=new int[n];}
        ~Queue(){delete []q;}

        void push(int x){
            q[++back_index]=x;
        }
        void pop(){
            if(back_index==-1)
                cout << -1 << endl;
            else{
                cout << q[0] << endl;
                for(int i=1; i<back_index+1; i++){
                    q[i-1]=q[i];
                }
                q[back_index--]=0;
            }
        }
        void size(){
            cout << back_index+1 << endl;
        }
        void empty(){
            if(back_index==-1)
                cout << 1 << endl;
            else
                cout << 0 << endl;
        }
        void front(){
            if(back_index==-1)
                cout << -1 << endl;
            else
                cout << q[0] << endl;
        }
        void back(){
            if(back_index==-1)
                cout << -1 << endl;
            else
                cout << q[back_index] << endl;
        }

};

int main(){
    
    int count = 0;
    string s;
    cin >> count;
    cin.ignore();

    Queue queue(count);

    for(int i=0;i<count; i++){
        getline(cin,s,'\n');
        int index = s.find(" ");
        if(index ==-1){
            if(s=="pop")
                queue.pop();
            else if(s=="size")
                queue.size();
            else if(s=="empty")
                queue.empty();
            else if(s=="front")
                queue.front();
            else if(s=="back")
                queue.back();
        }
        else{
            int x = stoi(s.substr(index+1));
            queue.push(x);
        }
    }
}