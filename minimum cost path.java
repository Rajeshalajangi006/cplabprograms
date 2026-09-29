import sys

def solve():
    tokens = sys.stdin.read().split()
    if not tokens:
        return
   
    it = iter(tokens)
   
    while True:
        try:
            N = int(next(it))
         
            M = int(next(it)) if len(tokens) > 1 else N
        except StopIteration:
            break
           
        g = [[int(next(it)) for _ in range(N)] for _ in range(N)]
        dp = [[0] * N for _ in range(N)]

        dp[0][0] = g[0][0]
        for j in range(1, N): dp[0][j] = dp[0][j - 1] + g[0][j]
        for i in range(1, N): dp[i][0] = dp[i - 1][0] + g[i][0]

        for i in range(1, N):
            for j in range(1, N):
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + g[i][j]

        print(dp[N - 1][N - 1])

solve()
