// some running faster than another guy question
/*
There are two kangaroos on a number line ready to jump in the positive direction 
(i.e, toward positive infinity). The first kangaroo starts at location  and moves at a 
rate of  meters per jump. The second kangaroo starts at location  and moves at a rate of  
meters per jump. Given the starting locations and movement rates for each kangaroo, can 
you determine if they'll ever land at the same location at the same time?
*/


public void will_catchup(int x1, int v1, int x2, int v2){
	int k1 = x1;
    int k2 = x2;
    if(x2 > x1 && v2 > v1){
		return false;	
    }

    for(int i = 0; i < 10000; i++){
        k1 += v1;
        k2 += v2;

        if(k1==k2){
        	return true;
        }
    }

	return false;	
}

public void will_catchup2(int x1, int v1, int x2, int v2){

	if((x1 - x2) % (v2 - v1) == 0){
		return true;
	}
	else 
		return false;
}