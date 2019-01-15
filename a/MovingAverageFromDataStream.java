class MovingAverage {

    private Queue<Integer> q;
    private double sum;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        q.offer(val);
        sum += val;
        if (q.size() > size) {
            sum -= q.poll();
        }
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
