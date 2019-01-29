class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("\\/+");
        Stack<String> stack = new Stack<>();
        
        for (int i = 1; i < paths.length; i++) {
            if (paths[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (paths[i].equals(".")) {
                continue;
            } else {
               stack.push(paths[i]); 
            }
        }
        String[] res = new String[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        
        return "/" + String.join("/", res);
    }
}
