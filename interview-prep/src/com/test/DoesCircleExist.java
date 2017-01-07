package com.test;

/**
 * We are given a string consisting of letters- G,L,R. - which is the instruction a robot follows
 * G - goes forward by one step.
 * L - turn left.
 * R - turn right.
 * String length can be upto 2500 characters.
 * The string runs itself infinite times. We need to tell if there exists a circle with a radius, r 
 * (r can be any real number), such that the robot never leaves the circle
 * 
 * @author Virag
 *
 */
public class DoesCircleExist {

	/**
	 * 
	 * @param commands
	 * @return
	 */
	public String[] doesCircleExist(String[] commands) {
		if(commands == null || commands.length == 0) {
			return new String[0];
		}

		String[] output = new String[commands.length];

		for(int i = 0; i < commands.length; i++) {
			// 0 -> N
			// 1 -> E
			// 2 -> S
			// 3 -> W
			int direction = 0;
			int x = 0;
			int y = 0;
			for(int k = 0; k < 4; k++) {
				for(int j = 0; j < commands[i].length(); j++) {
					if(commands[i].charAt(j) == 'G') {
						if(direction == 0) {
							y++;
						}
						if(direction == 1) {
							x++;
						}
						if(direction == 2) {
							y--;
						}
						if(direction == 3) {
							x--;
						}
					}

					if(commands[i].charAt(j) == 'L') {
						direction--;
						direction = direction % 4;
						if(direction < 0) {
							direction += 4;
						}
					}

					if(commands[i].charAt(j) == 'R') {
						direction++;
						direction = direction % 4;
					}
				} 
			}

			if(x == 0 && y == 0) {
				output[i] = "YES";
			}
			else {
				output[i] = "NO";
			}
		}
		return output;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DoesCircleExist circle = new DoesCircleExist();
		String[] input = new String[] {"G", "L", "GRGL", "GGGRGGG", "GLG", "LLRG"};

		String[] output = circle.doesCircleExist(input);

		for(String s : output) {
			System.out.println(s);
		}
	}
}
