#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

const int N = 1e5 + 10, M = 2 * N;
int h[N], e[M], ne[M], idx;
int depth[N], d[N], fa[N][17];
int n, m, ans;

void add(int a, int b)
{
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

void bfs()
{
    memset(depth, 0x3f, sizeof 0x3f);
    queue<int> q;
    q.push(1);
    depth[0] = 0;
    depth[1] = 1;
    while (q.size())
    {
        int t = q.front();
        q.pop();
        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (depth[j] > depth[t] + 1)
            {
                depth[j] = depth[t] + 1;
                fa[j][0] = t;
                for (int k = 1; k < 17; k++)
                {
                    fa[j][k] = fa[fa[j][k - 1]][k - 1];
                }
            }
        }
    }
}

int lca(int a, int b)
{
    if (depth[a] < depth[b])
        swap(a, b);
    for (int k = 16; k >= 0; k--)
    {
        if (depth[fa[a][k]] >= depth[b])
        {
            a = fa[a][k];
        }
    }
    if (a == b)
        return a;
    for (int k = 16; k >= 0; k--)
    {
        if (fa[a][k] != fa[b][k])
        {
            a = fa[a][k];
            b = fa[b][k];
        }
    }
    return fa[a][0];
}

int dfs(int u, int f)
{
    int res = d[u];
    for (int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if (j == f)
            continue;
        int s = dfs(j, u);
        if (s == 0)
            ans += m;
        else if (s == 1)
            ans++;
        res += s;
    }
    return res;
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        add(a, b);
        add(b, a);
    }
    bfs();
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        int p = lca(a, b);
        d[a]++;
        d[b]++;
        d[p] -= 2;
    }
    dfs(1, -1);
    cout << ans;
    return 0;
}