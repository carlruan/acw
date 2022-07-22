#include <iostream>
#include <algorithm>

using namespace std;

const int N = 40010;
int p[N];
int n, m;
int res;

int find(int x)
{
    if (x != p[x])
        p[x] = find(p[x]);
    return p[x];
}

int get(int x, int y)
{
    return (x - 1) * n + y - 1;
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n * n; i++)
        p[i] = i;
    for (int i = 1; i <= m; i++)
    {
        int x, y;
        char op;
        cin >> x >> y >> op;
        int a = get(x, y);
        int b;
        if (op == 'D')
            b = get(x + 1, y);
        else
            b = get(x, y + 1);
        a = find(a);
        b = find(b);
        if (a != b)
        {
            p[a] = b;
        }
        else
        {
            res = i;
            break;
        }
    }
    if (res > 0)
        cout << res;
    else
        cout << "draw";
    return 0;
}
