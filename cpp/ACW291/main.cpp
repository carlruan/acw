#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;
const int N = 12, M = 1 << 12;
int n, m;
long f[N][M];
bool st[M];
vector<vector<int>> al(M);

int main()
{
    while (cin >> n >> m, n || m)
    {
        for (int i = 0; i < 1 << n; i++)
        {
            bool f = true;
            int cnt = 0;
            for (int j = 0; j < n; j++)
            {
                if (i >> j & 1)
                {
                    if (cnt > 0 && cnt % 2)
                    {
                        f = false;
                        break;
                    }
                    cnt = 0;
                }
                else
                {
                    cnt++;
                }
            }
            if (cnt > 0 && cnt % 2)
            {
                f = false;
            }
            st[i] = f;
        }

        for (int i = 0; i < 1 << n; i++)
        {
            al[i].clear();
            for (int j = 0; j < 1 << n; j++)
            {
                if ((i & j) == 0 && st[i | j])
                    al[i].push_back(j);
            }
        }
        memset(f, 0, sizeof f);
        f[0][0] = 1;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 0; j < 1 << n; j++)
            {
                for (int ne : al[j])
                {
                    f[i][j] += f[i - 1][ne];
                }
            }
        }
        cout << f[m][0] << endl;
    }

    return 0;
}