/*

A child has a number of staircases in his house and he likes to climb each staircase 1, 2, or 3 steps 
at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the 
staircase.
*/



// Dynmaic Programming
    static int stepPerms(int n) {
        if(n <= 0)
            return 0;
        else if(n < 3)
            return n;
        int stairs[] = new int[n + 1];

        stairs[0] = 1;
        stairs[1] = 1;
        stairs[2] = 2;

        for(int i = 3; i <= n; i++){
            stairs[i] = stairs[i - 1] + stairs[i - 2] + stairs[i - 3] ;
        
            System.out.println(stairs[i]);
        }

        return stairs[n];
    }
   
//==========================================================================================================
//==========================================================================================================
//==========================================================================================================
 

// Recursion + Memory
    static int stepPerms(int n) {
        if(n <= 0)
            return 0;
        else if(n < 3)
            return n;
        
        int stairs[] = new int[n + 1];
        Arrays.fill(stairs, 0);

        stepPerms(n, stairs);

        return stairs[n];
    }
    static int stepPerms(int n, int[] stairs) {
        if(n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if(n < 3)
            return n;

        if(stairs[n] == 0){
            stairs[n] = stepPerms(n - 1, stairs) + stepPerms(n - 2, stairs) + stepPerms(n - 3, stairs);
            System.out.println(stairs[n]);
        }

        return stairs[n];
    }

