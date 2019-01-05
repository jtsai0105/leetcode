class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] matrix = new boolean[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
    
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == false) {
                indegree[ready]++;
            }
            matrix[pre][ready] = true;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == true) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
