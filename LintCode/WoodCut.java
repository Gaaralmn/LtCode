public class WoodCut {
    public int woodCut(int[] L, int k) {
        if (L.length == 0) {
            return 0;
        }
        int end = L[0];
        for (int i = 1; i < L.length; i++) {
            if (end < L[i]) {
                end = L[i];
            }
        }
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getPieces(L, mid) >= k) { //Really important that can not be just >
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPieces(L, end) >= k) {
            return end;
        } else if (getPieces(L, start) >= k) {
            return start;
        } else {
            return start - 1;
        }
    }

    public int getPieces(int[], int len) {
        int pieces = 0;
        for (int i = 0; i < L.length; i++) {
            pieces += L[i] / len;
        }
        return pieces;
    }
}
