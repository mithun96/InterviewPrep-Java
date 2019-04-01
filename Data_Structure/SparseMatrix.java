import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// SparseMatrix<int> default value of zero
// MxN where M~10,000,000 and N~10,000,000
// L non-zero entries where L~10,000
// constructor(m, n)
// get(i, j)
// set(i, j, value)
// add(m1, m2) or m1.add(m2)
// mul(m1, m2)

// dotproduct: [a b] dot [x y] = a*x + b*y
// m3[i, j] = dotproduct(ith row of m1, jth col of m2)

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}
public class Axis{
    int x, 
    int y, 
    public Axis(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int hash() {
        // assume this is written
    }
}

public class Matrix{
    HashMap<Integer, Integer> m;
    
    public Matrix(){
        m = new HashMap<>();
    }
    
    public int get(int i, int j){
        Axis index = new Axis(i, j);
        
        if(m.containsKey(index.hash())){
            return m.get(index.hash());
        }
        
        return 0;
    }
    
    public void set(int i, int j, int val){
        Axis index = new Axis(i, j);
        if(val != 0){
            m.put(index.hash(), val);
        }
        else if(get(i , j) != 0){
            m.remove(index.hash());
        }
    }
    
    public void add(Matrix m2){
        for(Map.Entry.<Interger, Interger> entry : m2.entrySet()){
            if(m2.containsKey(entry.getKey())){
                set(entry.getKey().x, entry.getKey().y, entry.getValue() + get(entry.getKey()))
            }
        }
    }
    
}
