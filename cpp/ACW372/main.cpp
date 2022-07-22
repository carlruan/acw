#include <iostream>
#include <cstring>
#define x first
#define y second
using namespace std;
const int N = 110;
typedef pair<int, int> PII;
PII match[N][N];
bool st[N][N], g[N][N];
int n, t;

int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

bool find(int x, int y)
{
    for (int i = 0; i < 4; i++)
    {
        int nr = x + dx[i], nc = y + dy[i];
        if (nc < 1 || nc > n || nr < 1 || nr > n)
            continue;
        if (st[nr][nc] || g[nr][nc])
            continue;
        st[nr][nc] = true;
        auto m = match[nr][nc];
        if (m.x == 0 || find(m.x, m.y))
        {
            match[nr][nc] = {x, y};
            return true;
        }
    }
    return false;
}

int main()
{
    cin >> n >> t;
    while (t--)
    {
        int a, b;
        cin >> a >> b;
        g[a][b] = true;
    }

    int res = 0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {

            if ((i + j) % 2 && !g[i][j])
            {
                memset(st, 0, sizeof st);
                if (find(i, j))
                    res++;
            }
        }
    }
    cout << res << endl;
    return 0;
}