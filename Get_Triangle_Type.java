
    /*
     * Complete the function below.
     */
    static String[] getTriangleType(String[] abc) {
        String[] results = new String[abc.length];
        String result=""; 
       
        for (int i = 0; i < abc.length; i++){
            result="None of these";
            String[] init = abc[i].split(" ");
            int a = Integer.valueOf(init[0]);
            int b = Integer.valueOf(init[1]);
            int c = Integer.valueOf(init[2]);
            
            if (validTri(a, b, c) && (a == b) && (b == c)){
                result = "Equilateral";
            }
            else if (validTri(a, b, c) && ((a == b) || (b == c) || (a == c))){
                result = "Isosceles";
            }
            results[i] = result;
        }
        return results; 
    }

    static boolean validTri(int a, int b, int c){
        if (a + b > c && a + c > b && b + c > a)
            return true;
        else 
            return false;
    }