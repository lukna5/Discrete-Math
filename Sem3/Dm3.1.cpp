
#include <iostream>
#include <queue>
#include <string>
#include <stack>
#include <deque>
using namespace std;
int n;
bool matrix[20002][20002];
deque<int> q;
int getDeq(int index) {
    stack<int> q2;
    for (size_t i = 0; i < index; i++)
    {
        q2.push(q.front());
        q.pop_front();
    }
    int res = q.front();
    //cout << q.size() << " " << q2.size() << "\n";
    while (!q2.empty())
    {
        q.push_front(q2.top());
        q2.pop();
        //cout << q.size() << "\n";
    }
    return res;
}
void reverse(int first, int second) {
    deque<int> q3 = q;
    stack<int> start;
    queue<int> q2;
    for (size_t i = 0; i < first; i++)
    {
        start.push(q.front());
        q.pop_front();
    }
    for (size_t i = first; i < second + 1; i++)
    {
        q2.push(q.front());
        q.pop_front();
    }
    while (!q2.empty())
    {
        q.push_front(q2.front());
        q2.pop();
    }
    while (!start.empty()) {
        q.push_front(start.top());
        start.pop();
    }
    int c;
}
void findHam() {
    for (size_t i = 0; i < n * (n - 1); i++)
    {
        if (matrix[q.front()][q[1]]) {
            q.push_back(q.front());
            q.pop_front();
        }
        else {
            int revers = 2;
            for (; !(matrix[q.front()][q[revers]]) || !(matrix[q[1]][q[revers+1]]); revers++)
            {

            }
            reverse(1, revers);
            q.push_back(q.front());
            q.pop_front();
        }
    }
    while (!q.empty()) {
        cout << q.front() << " ";
        q.pop_front();
    }
}
int main()
{
    cin >> n;
    string next;
    for (size_t i = 2; i < n + 1; i++)
    {
        cin >> next;
        for (size_t j = 1; j < next.length() + 1; j++)
        {
            if (next[j - 1] == '1')
            {
                matrix[i][j] = true;
                matrix[j][i] = true;
            }
            else {
                matrix[i][j] = false;
                matrix[j][i] = false;
            }

        }
    }
    /*for (size_t i = 1; i < n + 1; i++)
    {
        for (size_t j = 1; j < n + 1; j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << "\n";
    }
    */
    for (size_t i = 1; i < n + 1; i++)
    {
        q.push_back(i);
    }
    findHam();
}