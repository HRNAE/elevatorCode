
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
                    up.add(request);
                } else if (request < currFloor){
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
                    up.add(request);
                } else if (request < currFloor){
                    down.add(request);
                }
            }
        }
        System.out.println("Elevator is stationed at floor: " + currFloor);
    }
}
