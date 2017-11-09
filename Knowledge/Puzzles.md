# Puzzles

## Question 1
Suppose you're in a hallway lined with 100 closed lockers. You begin by opening every locker. Then you close every second locker. Then you go to every third locker and open it (if it's closed) or close it (if it's open). Let's call this action toggling a locker. Continue toggling every nth locker on pass number n. After 100 passes, where you toggle only locker #100, how many lockers are open?

### Answer 1
Only lockers with a perfect square 1,4,9,16,25,36,49,64,81,100 will be open. All other cases will be closed because it requires two seperate numbers to multiply to a certain number, therefore we open and close a locker for every combination. The only case in which the locker wil be open if the pari of numbers are the same, therefore all perfect sqaure lockers will be open. For k lockers we can expect squareroot of k lockets to be open.


## Question 2
You are standing in a hallway next to three light switches, all of which are turned off. Each switch operatres a differnt lightbulb in the room.You cannot see the light from where the switches are. Determine which light corresponds to each switch. You can go into the room with the lioghts once.

### Answer 2
Turn on one light switch for the first bulb. Wait 10 minutes, turn off light switch for first bulb, and then turn on light switch for third one. Go into the room and the bulb that is lit is connected with third swtich, hot bulb is for first switch, and the cold dim bulb is for the second switch.

## Question 3
You have 9 balls, equally big, equally heavy - except for one, which is a little heavier. How would you identify the heavier ball if you could use a pair of balance scales only twice?

### Answer 3
Split marbles into groups of three. Next is to find which group of three has the heavier marble, so compare two sets. Take heavier marble group, if they are equal then choose the marble group that was not weighed. With this marle group pick two marbles, and weigh them. If one is heavier than that is the heavier marble, if they are equal weight than the marble that was not weighed is the heaviest marble. For k marbles this would be celing of log base 3 to the k marbles.

## Question 4
You have 3 baskets, one with apples, one with oranges and one with both apples and oranges mixed. Each basket is closed and is labeled with Apples, Oranges and Apples and Oranges. However, each of these labels is always placed incorrectly. How would you pick only one fruit from a basket to place the labels correctly on all the baskets?

### Answer 4
Pick a fruit from a basket of Apples and Oranges. If the fruit is an orange you immeaditely know that basket contains the only oranges because the labels are incorrect. Now that we know where only oranges are we know the basket labled as Apples must contain both apples and organges. The basket labled as Oranges will contain only apples.

## Question 5
You have two buckets. One holds exactly five gallons and the other three gallons. How can you measure exactly four gallons of water into the five gallon bucket?

### Answer 5
Fill up the 5 gallon bucket. Pour it into 3 gallon bucket, leaving 2 gallons. Empty out the 3 gallon bucket. Pour the 2 gallons in the 5 gallon bucket into the 3 gallon bucket. Fill up the 5 gallon bucket and pour it into the 3 gallon bucket until it’s full, leaving 4 gallons in the 5 gallon bucket.