#include <iostream>
#include <algorithm>

using namespace std;

const int N = 3e4 + 10, M = 5e5 + 10;
int p[N], d[N], sz[N];
int n, m;

int find(int x)
{
    if (x != p[x])
    {
        int root = find(p[x]);
        d[x] += d[p[x]];
        p[x] = root;
    }

    return p[x];
}

int main()
{
    cin >> m;
    for (int i = 1; i <= N; i++)
    {
        p[i] = i;
        sz[i] = 1;
    }

    while (m--)
    {
        char op;
        int a, b;
        cin >> op >> a >> b;
        int x = find(a), y = find(b);
        if (op == 'M')
        {
            if (x != y)
            {
                p[x] = y;
                d[x] = sz[y];
                sz[y] += sz[x];
            }
        }
        else
        {
            if (x != y)
                cout << -1 << endl;
            else
            {
                cout << max(0, abs(d[a] - d[b]) - 1);
            };
        }
    }
    return 0;
}
