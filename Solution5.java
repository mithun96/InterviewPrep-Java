  // Pure storage
    
    // Complete the check_log_history function below.
    static int check_log_history(List<String> events) {
        int n = events.size();
        
        Stack<Integer> s = new Stack<>();
        
        for(int i = 0; i < events.size(); i++){
            String[] l = events.get(i).split(" ");
            if(l[0].equals("ACQUIRE")){
                if(!s.contains(Integer.parseInt(l[1]))){
                   s.push(Integer.parseInt(l[1]));
                }
                else{
                    return i + 1;
                }
            }
            else if(l[0].equals("RELEASE")){
                if(s.peek() == Integer.parseInt(l[1])){
                    s.pop();
                }
                else{
                    return i + 1;
                }
            }
        }
        
        if(!s.empty()){
            return n + 1;
        }
        
        return 0;
    }

