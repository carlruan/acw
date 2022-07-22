#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

using namespace std;

const int N = 2e4 + 10, M = 2 * N;

typedef pair<int, int> PII;

int h[N], e[M], ne[M], w[M], idx;
int dist[N], p[N], res[N], st[N];
vector<PII> query[N];
int n, m;

void dfs(int u, int f)
{
    for (int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if (j == f)
            continue;
        dist[j] = dist[u] + w[i];
        dfs(j, u);
    }
}

void add(int a, int b, int c)
{
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

int find(int x)
{
    if (x != p[x])
        p[x] = find(p[x]);
    return p[x];
}

void tarjan(int u)
{
    st[u] = 1;
    for (int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if (!st[j])
        {
            tarjan(j);
            p[j] = u;
        }
    }
    // cout << query[u].size() <<" ";
    for (auto item : query[u])
    {
        int ver = item.first, id = item.second;
        // cout << ver << ' ' <<id << ' ';
        if (st[ver] == 2)
        {
            int anc = find(ver);
            res[id] = dist[u] + dist[ver] - 2 * dist[anc];
        }
    }
    st[u] = 2;
}

int main()
{
    cin >> n >> m;
    memset(h, -1, sizeof h);
    for (int i = 0; i < n - 1; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        add(a, b, c);
        add(b, a, c);
    }
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        if (a != b)
        {
            query[a].push_back({b, i});
            query[b].push_back({a, i});
        }
    }
    for (int i = 1; i <= n; i++)
        p[i] = i;
    dfs(1, -1);
    tarjan(1);
    for (int i = 0; i < m; i++)
    {
        cout << res[i] << endl;
    }
    return 0;
}