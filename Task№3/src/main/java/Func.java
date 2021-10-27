public class Func {
    public Func() {
    }

    int func (int n, int m, int N) {
        int k = 0;
        if (n < m) {
            for (int i = 1; i <= ((N - 1) / 2); i++) {
                int nk = n + i;
                if (n + i == m) {
                    k = 1; break;
                }
            }
        } if (n > m) { k = 1;
            for (int i = 1; i <= ((N - 1) / 2); i++) {
                int nk = m + i;
                if (nk == n) {
                    k = 0; break;
                }
            }
        } return k;
    }
}
