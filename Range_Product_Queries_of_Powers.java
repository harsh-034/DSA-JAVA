class Solution {
    public int[] productQueries(int n, int[][] queries) {
         final int MOD = 1_000_000_007;

         List<Integer> powers = new ArrayList<>();
        for(int bit =0; bit <31; bit++)
        {
            if((n & (1 << bit)) !=0)
            {
                powers.add(1 << bit);
            }

        }

      int m = powers.size();
    long[] prefix = new long[m];
    prefix[0] = powers.get(0) % MOD;
    for (int i = 1; i < m; i++) {
        prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
    }

    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
        int l = queries[i][0];
        int r = queries[i][1];

        if (l == 0) {
            ans[i] = (int) prefix[r];
        } else {
            // Modular inverse to divide under modulo
            long product = (prefix[r] * modInverse(prefix[l - 1], MOD)) % MOD;
            ans[i] = (int) product;
        }
    }

    return ans;
        
    }
    private long modInverse(long a, int MOD) {
    return modPow(a, MOD - 2, MOD);
    }
    private long modPow(long base, long exp, int MOD) {
    long result = 1;
    while (exp > 0) {
        if ((exp & 1) == 1) result = (result * base) % MOD;
        base = (base * base) % MOD;
        exp >>= 1;
    }
    return result;
}
}
