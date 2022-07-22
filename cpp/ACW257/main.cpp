#include <iostream>
#include <cstring>

using namespace std;
const int N = 20010, M = 200010;
int h[N], ne[M], e[M], w[M], idx;
int color[N];
int n, m;

void add(int a, int b, int c)
{
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

bool dfs(int u, int c, int mid)
{
    color[u] = c;
    for (int i = h[u]; i != -1; i = ne[i])
    {
        if (w[i] <= mid)
            continue;
        int j = e[i];
        if (!color[j])
        {
            if (!dfs(j, c * -1, mid))
                return false;
        }
        else if (color[j] == color[u])
            return false;
    }
    return true;
}

bool check(int mid)
{
    memset(color, 0, sizeof color);
    for (int i = 1; i <= n; i++)
    {
        if (!color[i])
        {
            if (!dfs(i, 1, mid))
                return false;
        }
    }
    return true;
}

int main()
{
    cin >> n >> m;
    memset(h, -1, sizeof h);
    while (m--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        add(a, b, c);
        add(b, a, c);
    }
    int l = 0, r = 1e9;
    while (l < r)
    {
        int mid = l + r >> 1;
        if (check(mid))
            r = mid;
        else
            l = mid + 1;
    }
    cout << l << endl;
    return 0;
}