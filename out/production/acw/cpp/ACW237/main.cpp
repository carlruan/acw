#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10, M = 1e5 + 10;
int p[N];
int t, m;

struct Rule
{
    int a;
    int b;
    int c;
    bool operator<(const Rule &oth) const
    {
        return c < oth.c;
    }
} r[M];

int find(int x)
{
    if (x != p[x])
        p[x] = find(p[x]);
    return p[x];
}

int main()
{
    cin >> t;
    while (t--)
    {
        bool valid = true;
        for (int i = 1; i < N; i++)
        {
            p[i] = i;
        }
        cin >> m;
        for (int i = 0; i < m; i++)
        {
            int a, b, c;
            cin >> a >> b >> c;
            r[i] = {a, b, c};
        }
        sort(r, r + m);
        for (int i = 0; i < m; i++)
        {
            int a = r[i].a, b = r[i].b, c = r[i].c;
            a = find(a);
            b = find(b);
            if (!c)
            {
                if (a != b)
                {
                    p[a] = b;
                }
            }
            else
            {
                if (a == b)
                {

                    valid = false;
                    break;
                }
            }
        }
        if (valid)
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
    }
    return 0;
}