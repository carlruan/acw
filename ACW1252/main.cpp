#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;
typedef pair<int, int> PII;
const int N = 10010;
int p[N], v[N], w[N], f[N];
int n, m, money;
unordered_map<int, PII> mp;

int find(int x)
{
    if (x != p[x])
        p[x] = find(p[x]);
    return p[x];
}

int main()
{
    cin >> n >> m >> money;
    for (int i = 1; i <= n; i++)
    {
        p[i] = i;
        cin >> v[i] >> w[i];
    }
    while (m--)
    {
        int a, b;
        cin >> a >> b;
        a = find(a);
        b = find(b);
        if (a != b)
        {
            p[a] = b;
            w[b] += w[a];
            v[b] += v[a];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        int x = find(i);
        if (!mp.count(x))
            mp[x] = {v[x], w[x]};
    }
    for (auto e : mp)
    {
        for (int j = money; j; j--)
        {
            if (j >= e.second.first)
                f[j] = max(f[j], f[j - e.second.first] + e.second.second);
        }
    }
    cout << f[money];
    return 0;
}