
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> up = new PriorityQueue<>();
        PriorityQueue<Integer> down = new PriorityQueue<>(Comparator.reverseOrder());
        boolean goingUp = true; // assume elevator starts at floor 1
        int currFloor = 1;
        int request;
        while(true){ 
                System.out.print("Which floor do you want to go to (0 to start elevator or if floor is already requested): ");
                request = scan.nextInt();
                if(request == 0)
                    break; //0 to get the elevator started
                if (request > currFloor){
                    if(up.contains(request))
                        continue;
                    up.add(request);
                } else if (request < currFloor){
                    if(down.contains(request))
                        continue;
                    down.add(request);
                }
            }
        while(!up.isEmpty() || !down.isEmpty()){
            if(goingUp && !up.isEmpty()){
                int next = up.poll();
                while(currFloor < next){
                    currFloor++;
                    System.out.println("Going up...currently at floor " + currFloor);
                }
                System.out.println("Currently at floor: " + currFloor);
                if(up.isEmpty()){
                    goingUp = false;
                }
            } else {
                int next = down.poll();
                while(currFloor > next){
                    currFloor--;
                    System.out.println("Going down...currently at floor " + currFloor);
                }
                System.out.println("Currently at floor: " + currFloor);
                if(down.isEmpty()){
                    goingUp = true;
                }
            } 
            System.out.println("Floors requested: "); //show user which "buttons" are already pressed
            for(int i : down){
                System.out.print(i + " ");
            }
            for(int i : up){
                System.out.print(i + " ");
            }
            System.out.println();
            while(true){ 
                System.out.print("Which floor do you want to go to (0 to start elevator or if floor is already requested): ");
                request = scan.nextInt();
                if(request == 0)
                    break; //0 to get the elevator started
                if (request > currFloor){
                    if(up.contains(request))
                        continue;
                    up.add(request);
                } else if (request < currFloor){
                    if(down.contains(request))
                        continue;
                    down.add(request);
                }
            }
        }
        System.out.println("Elevator is stationed at floor: " + currFloor);
    }
}



/*
I assumed the elevator acted like the one in my college apartment, where the elevator starts at floor 1 and then goes up and keeps fulfilling 
the requests to the highest floor number, then works its way down and keeps going until no more requests. If there are no more requests, 
the elevator stops at that current floor. When you press 0 when inputting a floor number, this is assuming that the "button" is 
already pressed. I assumed there were an infinite number of floors on the elevator, ranging from 1 to n. I assumed you could only request a floor when the elevator is not
moving. Duplicate requests are ignored. I assumed that you can't add duplicates. I assumed this was one elevator. I assumed the user 
inputs a valid number.

Some future features I would like to add are to make this a small full-stack application where we have the front-end being buttons with a user
inputting the floor number, as well as a small console with an arrow pointing at which floor it is going to. I want to implement a feature 
where you can request a floor while the elevator is moving. It would be cool to add an emergency button and possibly multiple elevator 
logic.
*/
