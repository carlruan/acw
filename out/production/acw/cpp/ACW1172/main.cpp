#include <iostream>
#include <cstring>
#include <queue>

using namespace std;
const int N = 40010, M = 2 * N;
int h[N], e[M], ne[M], idx;
int depth[N];
int root;

int fa[N][16];
int n, m;

void add(int a, int b)
{
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
}

void bfs()
{
    memset(depth, 0x3f, sizeof depth);
    depth[0] = 0;
    depth[root] = 1;
    queue<int> q;
    int tt = 0, hh = 0;
    q.push(root);
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
                q.push(j);
                fa[j][0] = t;
                for (int k = 1; k <= 15; k++)
                    fa[j][k] = fa[fa[j][k - 1]][k - 1];
            }
        }
    }
}

int lca(int a, int b)
{
    if (depth[a] < depth[b])
        swap(a, b);
    for (int k = 15; k >= 0; k--)
    {
        if (depth[fa[a][k]] >= depth[b])
        {
            a = fa[a][k];
        }
    }
    if (a == b)
        return a;
    for (int k = 15; k >= 0; k--)
    {
        if (depth[fa[a][k]] != depth[fa[b][k]])
        {
            a = fa[a][k];
            b = fa[b][k];
        }
    }
    return fa[a][0];
}

int main()
{
    cin >> n;
    memset(h, -1, sizeof h);
    while (n--)
    {
        int a, b;
        cin >> a >> b;
        if (b == -1)
            root = a;
        else
        {
            add(a, b);
            add(b, a);
        }
    }
    bfs();
    cin >> m;
    while (m--)
    {
        int a, b;
        cin >> a >> b;
        int t = lca(a, b);
        if (t == a)
            puts("1");
        else if (t == b)
            puts("2");
        else
            puts("0");
    }
}