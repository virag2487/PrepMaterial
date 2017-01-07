package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static class Player implements Comparable<Player> {
		int playerId;
		int rushingYards;
		int passingYards;
		int passingTds;
		int interceptions;
		int fantasyScore;

		public Player(int playerId, int rushingYards, int passingYards, int passingTds, int interceptions) {
			this.playerId = playerId;
			this.rushingYards = rushingYards;
			this.passingYards = passingYards;
			this.passingTds = passingTds;
			this.interceptions = interceptions;
			this.fantasyScore = (rushingYards * 2) + passingYards + (passingTds * 6) - interceptions;
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + fantasyScore;
			result = prime * result + interceptions;
			result = prime * result + passingTds;
			result = prime * result + passingYards;
			result = prime * result + playerId;
			result = prime * result + rushingYards;
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Player other = (Player) obj;
			if (fantasyScore != other.fantasyScore) {
				return false;
			}
			if (interceptions != other.interceptions) {
				return false;
			}
			if (passingTds != other.passingTds) {
				return false;
			}
			if (passingYards != other.passingYards) {
				return false;
			}
			if (playerId != other.playerId) {
				return false;
			}
			if (rushingYards != other.rushingYards) {
				return false; 
			}
			return true;
		}



		public int compareTo(Player player) {

			if(this == player) {
				return 0;
			}
			if(this.fantasyScore > player.fantasyScore) {
				return 1;
			}
			else if(this.fantasyScore < player.fantasyScore) {
				return -1;
			}
			else {
				if(this.playerId > player.playerId) {
					return 1;
				}
				else if(this.playerId < player.playerId) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}


	}

	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scan = new Scanner(System.in);

		Set<Player> players = new TreeSet<Player>();

		Test t = new Test();

		String[] split = new String[1];
		Player player = new Player(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));

		Map<String, List<String>> gamesMap = new HashMap<String, List<String>>();
		while(scan.hasNext()) {
			String inputLine = scan.nextLine();
			String[] splitStrings = inputLine.split("\\s+");
			StringBuilder sb = new StringBuilder();
			for(String s : splitStrings) {
				if(s.trim().startsWith("[nba.p.") && s.trim().endsWith("]")) {
					if(sb.length() != 0) {
						sb.append(",");
					}
					sb.append(s.trim().substring(1, s.length() - 1));
				}
			}
			System.out.println(sb.toString());
		}
	}

}
