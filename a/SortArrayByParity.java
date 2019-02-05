class Solution {
    public int[] sortArrayByParity(int[] A) {
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                swap(A, idx++, i);
            }
        }
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
