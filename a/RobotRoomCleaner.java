/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    
    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            
            if (!(obj instanceof Pair)) {
                return false;
            }
            
            Pair o = (Pair) obj;
            
            return this.x == o.x && this.y == o.y;
        }
        
        public int hashCode() {
            return this.x ^ this.y;
        }
    }
    
    public void cleanRoom(Robot robot) {
        Set<Pair> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        dfs(robot, set, new Pair(0, 0), cur_dir);
    }
    
    private void dfs(Robot robot, Set<Pair> set, Pair pair, int dir) {
        if (set.contains(pair)) {
            return;
        }
        
        set.add(pair);
        robot.clean();
        
        for (int i = 0; i < 4; i++) {
            if(robot.move()) {
    			// can go directly. Find the (x, y) for the next cell based on current direction
    			int x = pair.x, y = pair.y;
    			switch(dir) {
    				case 0:
    					// go up, reduce i
    					x = pair.x - 1;
    					break;
    				case 90:
    					// go right
    					y = pair.y + 1;
    					break;
    				case 180:
    					// go down
    					x = pair.x + 1;
    					break;
    				case 270:
    					// go left
    					y = pair.y - 1;
    					break;
    				default:
    					break;
    			}
                dfs(robot, set, new Pair(x, y), dir);
                robot.turnLeft();
    			robot.turnLeft();
    			robot.move();
    			robot.turnRight();
    			robot.turnRight();
            }
            robot.turnRight();
    		dir += 90;
    		dir %= 360;
        }
    }
}
