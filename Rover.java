
    class Rover {
    	public static final Integer N = 1;
    	public static final Integer E = 2;
    	public static final Integer S = 3;
    	public static final Integer W = 4;
    	Integer x = 0;
    	Integer y = 0;
    	Integer facing = N;
    	
        //Sets postion of the rover
    	public void setPosition(Integer x, Integer y, Integer facing) {
    		this.x = x;
    		this.y = y;
    		this.facing = facing;
    	}

        //Prints resultant position
    	public void printPosition() {
    		char dir = 'N';
    		if (facing == 1) {
    			dir = 'N';
    		} else if (facing == 2) {
    			dir = 'E';
    		} else if (facing == 3) {
    			dir = 'S';
    		} else if (facing == 4) {
    			dir = 'W';
    		}
    		System.out.println(x+" "+y+" "+dir);
    	}


    	public void process(String commands) {
    		for (int i = 0; i < commands.length(); i++) {
    			process(commands.charAt(i));
    		}
    	}
    	private void process(Character command) {
    		if (command.equals('L')) {
    			turnLeft();
    		} else if (command.equals('R')) {
    			turnRight();
    		} else if (command.equals('M')) {
    			move();
    		} else {
    			throw new IllegalArgumentException(
    					"Enter L,R or M only in the string");
    		}
    	}

        //Move function
    	private void move() {
    		if (facing == N) {
    			this.y++;
    		} else if (facing == E) {
    			this.x++;
    		} else if (facing == S) {
    			this.y--;
    		} else if (facing == W) {
    			this.x--;
    		}
    	}
        //computes facing for left direction
    	private void turnLeft() {
    		facing = (facing - 1) < N ? W : facing - 1;
    	}

        //computes facing for right direction
    	private void turnRight() {
    		facing = (facing + 1) > W ? N : facing + 1;
    	}

        //Driver code
    	public static void main(String args[]) {
    		Rover rover = new Rover();
    		rover.setPosition(1, 2, N);
    		rover.process("LMLMLMLMM");
    		rover.printPosition(); // prints 1 3 N

    		rover.setPosition(3, 3, E);
    		rover.process("MMRMMRMRRM");
    		rover.printPosition(); // prints 5 1 E

    	}
    }