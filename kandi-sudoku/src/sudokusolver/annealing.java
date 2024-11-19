package sudokusolver;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class annealing {
	//Here's some sudoku puzzles.
	private static String puzzle1 = "4 0 0 0 1 0 0 0 0\r\n"
			   + "0 0 2 0 5 0 8 0 0\r\n"
			   + "0 0 0 0 7 0 3 0 4\r\n"
			   + "0 0 0 7 3 0 6 0 0\r\n"
			   + "0 0 0 0 0 1 0 7 0\r\n"
			   + "0 2 3 4 0 0 0 5 0\r\n"
			   + "0 0 1 0 4 0 9 0 0\r\n"
			   + "0 6 0 0 0 0 0 2 0\r\n"
			   + "0 8 0 3 0 0 0 0 0";
	
	private static String puzzle2 = "5 0 1 0 0 9 0 0 3\r\n"
			   + "0 0 7 0 6 0 0 0 0\r\n"
			   + "0 0 0 0 0 5 0 0 0\r\n"
			   + "0 0 0 9 0 0 0 4 0\r\n"
			   + "7 0 0 0 3 0 1 0 0\r\n"
			   + "9 0 0 0 0 0 8 0 6\r\n"
			   + "4 0 0 0 8 0 9 0 5\r\n"
			   + "0 0 6 0 0 2 4 8 0\r\n"
			   + "3 8 9 0 0 4 0 6 0";
	
	private static String puzzle3 = "8 0 0 2 5 0 1 0 6\r\n"
			   + "7 0 1 6 9 0 0 3 5\r\n"
			   + "6 4 5 1 7 0 2 9 8\r\n"
			   + "4 0 8 0 2 7 3 5 0\r\n"
			   + "2 9 3 4 1 5 6 0 7\r\n"
			   + "5 1 0 0 0 0 9 2 4\r\n"
			   + "0 7 0 8 0 0 5 6 0\r\n"
			   + "1 5 0 7 0 0 8 4 0\r\n"
			   + "3 8 0 0 0 2 7 1 9";
	
	private static String puzzle4 = "0 0 0 0 5 0 2 4 0\r\n"
			   + "0 2 0 0 0 6 9 0 0\r\n"
			   + "0 0 0 0 0 3 0 7 0\r\n"
			   + "0 8 0 9 0 0 0 6 0\r\n"
			   + "4 0 0 0 3 0 0 8 0\r\n"
			   + "6 3 1 0 0 0 0 0 0\r\n"
			   + "0 0 0 0 0 7 0 3 8\r\n"
			   + "8 7 5 0 0 4 0 1 2\r\n"
			   + "0 6 0 0 8 0 0 9 0";
	
	private static String puzzle5 = "0 0 0 1 0 8 0 0 0\r\n"
			   + "0 0 0 0 0 0 3 0 0\r\n"
			   + "3 8 9 0 0 4 0 0 0\r\n"
			   + "0 0 6 8 0 0 0 0 0\r\n"
			   + "7 0 0 6 0 0 0 5 0\r\n"
			   + "2 5 0 0 0 7 8 0 0\r\n"
			   + "0 0 0 0 0 0 0 0 4\r\n"
			   + "4 1 5 0 0 0 9 2 0\r\n"
			   + "0 6 0 0 7 5 0 0 3";
	
	
	public static void main(String[] args) {
		
		int no_of_runs = 50;
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = true, perturbations = 500:");
		System.out.println("");
		testPerformance(true,true,500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = true, perturbations = 1500:");
		System.out.println("");
		testPerformance(true,true,1500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = true, perturbations = 4500:");
		System.out.println("");
		testPerformance(true,true,4500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = false, perturbations = 500:");
		System.out.println("");
		testPerformance(true,false,500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = false, perturbations = 1500:");
		System.out.println("");
		testPerformance(true,false,1500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = true, slow_decrease = false, perturbations = 4500:");
		System.out.println("");
		testPerformance(true,false,4500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = true, perturbations = 500:");
		System.out.println("");
		testPerformance(false,true,500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = true, perturbations = 1500:");
		System.out.println("");
		testPerformance(false,true,1500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = true, perturbations = 4500:");
		System.out.println("");
		testPerformance(false,true,4500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = false, perturbations = 500:");
		System.out.println("");
		testPerformance(false,false,500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = false, perturbations = 1500:");
		System.out.println("");
		testPerformance(false,false,1500,no_of_runs);
		System.out.println("----------------------------------------------------------------------------");
		
		System.out.println("Parameter choices are high_start = false, slow_decrease = false, perturbations = 4500:");
		System.out.println("");
		testPerformance(false,false,4500,no_of_runs);
		
		
		/*
		 * One run of the following gave me 1.5873394 as being the average change to objective value for worsening
		 * solutions.
		 */
		
		/*
	    System.out.print("Java Specification Version: ");
	    System.out.println(System.getProperty("java.specification.version"));
	    System.out.print("java Runtime Environment (JRE) version: ");
	    System.out.println(System.getProperty("java.version"));
		
		int[][][] board = create_board();
		init_from_string(puzzle4,board);
		
		int[] candidate = new int[3];
		int[][] possibles = possible_candidates(board);
		int laskin = 0;
		int muutos_temp;
		double muutos_total = 0;
		guess_initial_solution(board);
		while(laskin < 10000000) {
			give_candidate(possibles, candidate, board);
			muutos_temp = change_in_duplicates(board, candidate);
			if(muutos_temp > 0) {
				laskin += 1;
				muutos_total = muutos_total + muutos_temp;
				board[candidate[0]][candidate[1]][0] = candidate[2];
			}
			else {
				board[candidate[0]][candidate[1]][0] = candidate[2];
			}
		}
		muutos_total = muutos_total/10000000;
		System.out.println("In the beginning the average change for worsening solutions is " + muutos_total);
		System.out.println("This information can be used to determine the starting temperature.");
		*/
		
		
		/*
		int[][][] board = create_board();
		init_from_string(puzzle1,board);
		
		BigInteger options = new BigInteger("1");
		long bigkusa = 0;
		int biggestkusa = 0;
		int[][] candidates = possible_candidates(board);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				bigkusa = 0;
				if(biggestkusa< candidates.length){
					while(candidates[biggestkusa][0] == i && candidates[biggestkusa][1] == j) {
						bigkusa++;
						biggestkusa++;
						if(biggestkusa == candidates.length) {
							break;
						}
					}
				}
				System.out.println("At index x=" + i + " and y=" + j + " number of options is " + bigkusa);
				if(bigkusa > 0) {
					options = options.multiply(BigInteger.valueOf(bigkusa));
					System.out.println("Calculated number of total options is now " + options);
				}
			}
		}
		*/
		
		
	}
	
	/*
	We initialize a board with the dimensions 9x9x2. The first two dimensions stand for the rows and the columns of a sudoku
	puzzle, while the last one exists to have two different values for each of the slots: the actual number in the sudoku,
	and another one to tell if the number is one of the 'original' values we're not allowed to change in our solution.
	
	Note: board[row][column][marker]
	*/
	static private int[][][] create_board() {
		return new int[9][9][2];
	}
	
	static private long change_counted = 0; //Takes into account both the initial measurement of the obj. function and the changes counted later on.
	
	static private Random ran = new Random();
	
	static public void print_board(int[][][] board) {
		if(board.length<9||board[0].length<9) {
			System.out.println("Give a proper board.");
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(i==3||i==6) {
				System.out.println("- - - x - - - x - - -");
			}
			for(int j=0;j<9;j++) {
				if(j==3||j==6) {
					System.out.print("| ");
				}
				System.out.print(board[i][j][0] + " ");
			}
			System.out.println("");
		}
	}
	
	//This is used to add an 'original' number to the sudoku puzzle, and it used when initializing a board from string.
	static private void add_original(int row, int column, int value, int[][][] board) {
		board[row][column][0] = value;
		board[row][column][1] = 1;
	}
	
	//Initializes a sudoku puzzle into the 9x9x2 board from a string.
	static private void init_from_string(String text, int[][][] board) {
		Scanner sc = new Scanner(text);
		int counter = 0;
		int help;
		while(sc.hasNextInt()) {
			if((help = sc.nextInt())!=0) {
				add_original(counter/9,counter%9,help,board);
			}
			counter += 1;
		}
		sc.close();
	}
	
	/*
	 * This method is used to figure out the number of duplicates for a board. It should only be used at the start, and not
	 * between rounds of iterations, as that would be computationally wasteful.
	 */
	static private int count_duplicates(int board[][][]) {
		change_counted += 1;
		
		int counter = 0;
		int[] vector = new int[9];
		for(int i=0;i<9;i++) {
			//We're checking how many of each number there is at row i.
			for(int j=0;j<9;j++) {
				if(board[i][j][0]!=0) {
					vector[board[i][j][0]-1] += 1;
				}
			}
			//We're adding the duplicates to the counter.
			for(int j=0;j<9;j++) {
				if(vector[j]>1) {
					counter = counter + vector[j] - 1;
				}
			}
			empty_vector(vector);
			
			//We're checking how many of each number there is at column j.
			for(int j=0;j<9;j++) {
				if(board[j][i][0]!=0) {
					vector[board[j][i][0]-1] += 1;
				}
			}
			for(int j=0;j<9;j++) {
				if(vector[j]>1) {
					counter = counter + vector[j] - 1;
				}
			}
			empty_vector(vector);
		}
		
		//Now that the duplicates for columns/rows has been counted for, let's count them for
		//the squares.
		for(int ii=0;ii<3;ii++) {
			for(int jj=0;jj<3;jj++) {
				for(int i=ii*3;i<(ii+1)*3;i++) {
					for(int j=jj*3;j<(jj+1)*3;j++) {
						if(board[i][j][0]!=0) {
							vector[board[i][j][0]-1] += 1;
						}
					}
				}
				for(int i=0;i<9;i++) {
					if(vector[i]>1) {
						counter = counter + vector[i] - 1;
					}
				}
				empty_vector(vector);
			}
		}
		
		return counter;
	}
	
	static private void empty_vector(int[] vector) {
		//Used only to help in the count_duplicates function
		for(int i=0;i<vector.length;i++) {
			vector[i]=0;
		}
	}
	
	/*
	 * The new candidate change should be given with a integer vector with a length of 3, having values (row, column, value).
	 * Then this method is used to figure out the change in the objective function, from we can determine if we wish to
	 * accept the change.
	 * 
	 * Note: This method requires for you to have a value other than zero on all of the spaces for it to work as intended.
	 */
	static private int change_in_duplicates(int board[][][], int candidate[]) {
		change_counted += 1;
		
		int change = 0;
		//Here we figure out what was the previous value in the space that we're trying to place a candidate value to.
		int previous = board[candidate[0]][candidate[1]][0];
		boolean helper = false;
		boolean helper2 = false;
		boolean another_helper;
		
		
		//Check if row or has multiples of previous/candidate value
		for(int i=0;i<9;i++) {
			if(i != candidate[1]) {
				if(board[candidate[0]][i][0] == previous) {
					helper = true;
				}
				if(board[candidate[0]][i][0] == candidate[2]) {
					helper2 = true;
				}
			}
		}
		if(helper) {
			change -= 1;
		}
		helper = false;
		if(helper2) {
			change += 1;
		}
		helper2 = false;
		
		//Check if column has multiples of previous/candidate value
		for(int i=0;i<9;i++) {
			if(i != candidate[0]) {
				if(board[i][candidate[1]][0] == previous) {
					helper = true;
				}
				if(board[i][candidate[1]][0] == candidate[2]) {
					helper2 = true;
				}
			}
		}
		if(helper) {
			change -= 1;
		}
		helper = false;
		if(helper2) {
			change += 1;
		}
		helper2 = false;
		
		//Check if square has multiples of previous value
		int rowSquare = candidate[0] / 3;
		rowSquare = 3*rowSquare;
		int columnSquare = candidate[1] / 3;
		columnSquare = 3*columnSquare;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				another_helper = (i + rowSquare == candidate[0]) && (j + columnSquare == candidate[1]);
				if(!another_helper) {
					if(board[i+rowSquare][j+columnSquare][0] == previous) {
						helper = true;
					}
					if(board[i+rowSquare][j+columnSquare][0] == candidate[2]) {
						helper2 = true;
					}
				}
			}
		}
		if(helper) {
			change -= 1;
		}
		if(helper2) {
			change += 1;
		}

		return change;
	}
	
	//With this we can figure out the amount of spots that are 'open', aka. can be changed and are not a part of the original formulation.
	static private int count_opens(int board[][][]) {
		int counter = 0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j][1] == 0) {
					counter += 1;
				}
			}
		}
		return counter;
	}
	
	//With this we get a matrix one dimension having the size of the amount of open spots on board. The other dimension is 2.
	//[x][0] will give a row for the x:th value, [x][1] will give a column for the x:th value.
	static private int[][] open_spots(int board[][][]){
		int counter = 0;
		int[][] opens = new int[count_opens(board)][2];
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j][1] == 0) {
					opens[counter][0] = i;
					opens[counter][1] = j;
					counter += 1;
				}
			}
		}
		return opens;	
	}
	//With this we initiate a guess for the sudoku board, where we just add random values to the open spots.
	static private void guess_initial_solution(int board[][][]) {
		int[][] opens = open_spots(board);
		int size = count_opens(board);
		for(int i=0;i<size;i++) {
			board[opens[i][0]][opens[i][1]][0] = ran.nextInt(9) + 1;
		}
	}
	
	//Return matrix with list of possible candidates
	static private int[][] possible_candidates(int board[][][]) {
		//Length for our matrix.
		int len = 0;
		
		int xSlot = 0;
		int ySlot = 0;
		//Used to check which are allowed moves and which are not. For example, if at the 5th row and 3rd column 7 
		//is allowed, then illegals[4][2][6] = false.
		boolean[][][] illegals = new boolean[9][9][9];
		//This will mark all illegal spots as 'true'.
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(board[i][j][1] == 1) {
					for(int x=0;x<9;x++) {
						illegals[i][x][board[i][j][0]-1] = true;
						illegals[x][j][board[i][j][0]-1] = true;
						illegals[i][j][x] = true;
					}
					xSlot = i / 3;
					xSlot = xSlot * 3;
					ySlot = j / 3;
					ySlot = ySlot * 3;
					for(int x=0;x<3;x++) {
						for(int y=0;y<3;y++) {
							illegals[x + xSlot][y + ySlot][board[i][j][0]-1] = true;
						}
					}
				}
			}
		}
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				for(int z=0;z<9;z++) {
					if(illegals[x][y][z] == false) {
						len += 1;
					}
				}
			}
		}
		//In the second dimension, 0: row (0-8), 1: column (0-8), 2: value (1-9)
		int[][] possible_candidates = new int[len][3];
		len = 0;
		for(int x=0;x<9;x++) {
			for(int y=0;y<9;y++) {
				for(int z=0;z<9;z++) {
					if(illegals[x][y][z] == false) {
						possible_candidates[len][0] = x;
						possible_candidates[len][1] = y;
						possible_candidates[len][2] = z+1;
						len += 1;
					}
				}
			}
		}
		return possible_candidates;	
	}
	
	//This is what we'll use to create candidate changes in the annealing algorithm. Notice how here one of the
	//parameters is the matrix created by the open_spots function.
	//You also need to give it a vector with length 3 so the candidate can be coded into it.
	static private void give_candidate(int possible_candidates[][], int candidate[], int board[][][]) {
		int random_spot = ran.nextInt(possible_candidates.length);
		int arvo = possible_candidates[random_spot][2];
		if(arvo == board[possible_candidates[random_spot][0]][possible_candidates[random_spot][1]][0]) {
			give_candidate(possible_candidates, candidate, board);
		}
		else {
			candidate[0] = possible_candidates[random_spot][0];
			candidate[1] = possible_candidates[random_spot][1];
			candidate[2] = arvo;
		}
	}
	
	/*
	 * This is the actual method used for simulated annealing. Make sure your board is properly initialized with a puzzle
	 * before using this method. You don't need to guess an initial solution before using this though.
	 * 
	 * There's two parameters you can switch between that are going to use a slightly different version of the algorithm,
	 * modifying in particular the temperature schedule. Everything else should be the same.
	 * boolean high_start: When true, starting temperature will match to accepting 50%. When false, will match to accepting 20%.
	 * boolean slower_decrease: When true, temperature is changed my multiplying it with 0.9. When false, it is changed by multiplying it with 0.8.
	 */
	
	static private int simulated_annealing(int board[][][], boolean high_start, boolean slower_decrease, int perturbations) {
		//Laying the groundwork with thing's we'll need for the annealing.
		int candidate[] = new int[3];
		int possibles[][] = possible_candidates(board); 
		guess_initial_solution(board);
		//Used for figuring out when to change the temperature.
		int count_changes = 0;
		//Used to keep track of value of objective function.
		int objfun_value = count_duplicates(board);
		int objfun_change;
		//Used to keep track the no. of rounds that go by without the obj value worsening. This will give us another termination
		//criteria.
		int rounds_without_accepting = 0;
		boolean accepted = false;
		//The actual temperature of the method
		double temperature;
		//Used to figure out if a worsened solution is accepted
		double random_value;
		double threshold;
		
		//init the parameters used for temperature changes
		if(high_start) {
			temperature = 2.290046681;
		}
		else {
			temperature = 0.986269422;
		}
		double decrease;
		if(slower_decrease) {
			decrease = 0.9;
		}
		else {
			decrease = 0.8;
		}
		
		//The actual annealing part of the method.
		while((objfun_value > 0) && (rounds_without_accepting<3)) {
			while(count_changes < perturbations) {
				give_candidate(possibles,candidate,board);
				objfun_change = change_in_duplicates(board, candidate);
				if(objfun_change <= 0) {
					board[candidate[0]][candidate[1]][0] = candidate[2];
					count_changes += 1;
					objfun_value = objfun_value + objfun_change;
				}
				else {
					count_changes += 1;
					random_value = ran.nextDouble();
					threshold = -objfun_change;
					threshold = threshold / temperature;
					threshold = Math.exp(threshold);
					if(random_value < threshold) {
						board[candidate[0]][candidate[1]][0] = candidate[2];
						objfun_value = objfun_value + objfun_change;
						accepted = true;
					}
				}
			}
			if(!accepted) {
				rounds_without_accepting += 1;
			}
			else {
				rounds_without_accepting = 0;
			}
			accepted = false;
			temperature = temperature * decrease;
			count_changes = 0;
		}
		if(objfun_value == 0) {
			// System.out.println("Solution found!");
			return objfun_value;
		}
		else {
			//System.out.println("Annealing terminated due to timing out.");
			//System.out.println("Objective function value was left at " + objfun_value);
			return objfun_value;
		}
		
	}
	
	//We can use this to run performance tests on different combinations of the parameters.
	//int solutions stands for how many times do we expect the program to find us the solution for each problem
	static private void testPerformance(boolean starting_temp, boolean decrease, int perturbations, int solutions) {
		//Note, we get the time in millis first.
		boolean meme = true;
		long total_time_all = 0;
		int times_tried = 0;
		int total_tries = 0;
		long total_change = 0;
		
		int[][][] board1 = create_board();
		init_from_string(puzzle1, board1);
		long total_time1 = 0;

		for(int i=0;i<solutions;i++) {
			meme = true;
			long start = System.currentTimeMillis();
			while(meme){
				if(simulated_annealing(board1,starting_temp,decrease,perturbations) == 0) {
					times_tried++;
					meme = false;
				}
				else {
					times_tried++;
				}
			}
			long finish = System.currentTimeMillis();
			total_time1 = total_time1 + (finish-start);
		}
		System.out.println("For puzzle 1 total elapsed time to was " + total_time1/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time1/(1000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required to reach " + solutions + " correct solutions was " + times_tried + ",");
		System.out.println("or around " + ((double) times_tried)/solutions + " tries per solution.");
		System.out.println("The value of the objective function was measured a total of " + change_counted + " times,");
		System.out.println("or around " + ((double) change_counted)/times_tried + " times per try.");
		total_change += change_counted;
		change_counted = 0;
		System.out.println("");
		
		total_tries += times_tried;
		times_tried = 0;
		int[][][] board2 = create_board();
		init_from_string(puzzle2, board2);
		long total_time2 = 0;

		for(int i=0;i<solutions;i++) {
			meme = true;
			long start = System.currentTimeMillis();
			while(meme){
				if(simulated_annealing(board2,starting_temp,decrease,perturbations) == 0) {
					times_tried++;
					meme = false;
				}
				else {
					times_tried++;
				}
			}
			long finish = System.currentTimeMillis();
			total_time2 = total_time2 + (finish-start);
		}
		System.out.println("For puzzle 2 total elapsed time to was " + total_time2/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time2/(1000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required to reach " + solutions + " correct solutions was " + times_tried + ",");
		System.out.println("or around " + ((double) times_tried)/solutions + " tries per solution.");
		System.out.println("The value of the objective function was measured a total of " + change_counted + " times,");
		System.out.println("or around " + ((double) change_counted)/times_tried + " times per try.");
		total_change += change_counted;
		change_counted = 0;
		System.out.println("");

		total_tries += times_tried;
		times_tried = 0;
		int[][][] board3 = create_board();
		init_from_string(puzzle3, board3);
		long total_time3 = 0;

		for(int i=0;i<solutions;i++) {
			meme = true;
			long start = System.currentTimeMillis();
			while(meme){
				if(simulated_annealing(board3,starting_temp,decrease,perturbations) == 0) {
					times_tried++;
					meme = false;
				}
				else {
					times_tried++;
				}
			}
			long finish = System.currentTimeMillis();
			total_time3 = total_time3 + (finish-start);
		}
		System.out.println("For puzzle 3 total elapsed time to was " + total_time3/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time3/(1000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required to reach " + solutions + " correct solutions was " + times_tried + ",");
		System.out.println("or around " + ((double) times_tried)/solutions + " tries per solution.");
		System.out.println("The value of the objective function was measured a total of " + change_counted + " times,");
		System.out.println("or around " + ((double) change_counted)/times_tried + " times per try.");
		total_change += change_counted;
		change_counted = 0;
		System.out.println("");
		
		total_tries += times_tried;
		times_tried = 0;
		int[][][] board4 = create_board();
		init_from_string(puzzle4, board4);
		long total_time4 = 0;
		
		for(int i=0;i<solutions;i++) {
			meme = true;
			long start = System.currentTimeMillis();
			while(meme){
				if(simulated_annealing(board4,starting_temp,decrease,perturbations) == 0) {
					times_tried++;
					meme = false;
				}
				else {
					times_tried++;
				}
			}
			long finish = System.currentTimeMillis();
			total_time4 = total_time4 + (finish-start);
		}
		System.out.println("For puzzle 4 total elapsed time to was " + total_time4/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time4/(1000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required to reach " + solutions + " correct solutions was " + times_tried + ",");
		System.out.println("or around " + ((double) times_tried)/solutions + " tries per solution.");
		System.out.println("The value of the objective function was measured a total of " + change_counted + " times,");
		System.out.println("or around " + ((double) change_counted)/times_tried + " times per try.");
		total_change += change_counted;
		change_counted = 0;
		System.out.println("");
		
		total_tries += times_tried;
		times_tried = 0;
		int[][][] board5 = create_board();
		init_from_string(puzzle5, board5);
		long total_time5 = 0;

		for(int i=0;i<solutions;i++) {
			meme = true;
			long start = System.currentTimeMillis();
			while(meme){
				if(simulated_annealing(board5,starting_temp,decrease,perturbations) == 0) {
					times_tried++;
					meme = false;
				}
				else {
					times_tried++;
				}
			}
			long finish = System.currentTimeMillis();
			total_time5 = total_time5 + (finish-start);
		}
		System.out.println("For puzzle 5 total elapsed time to was " + total_time5/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time5/(1000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required to reach " + solutions + " correct solutions was " + times_tried + ",");
		System.out.println("or around " + ((double) times_tried)/solutions + " tries per solution.");
		System.out.println("The value of the objective function was measured a total of " + change_counted + " times,");
		System.out.println("or around " + ((double) change_counted)/times_tried + " times per try.");
		total_change += change_counted;
		change_counted = 0;
		System.out.println("");
		
		total_tries += times_tried;
		total_time_all = total_time1 + total_time2 + total_time3 + total_time4 + total_time5;
		
		System.out.println("For all puzzles put together total elapsed time to was " + total_time_all/1000.0 + " seconds.");
		System.out.println("While the average time for reaching a solution was " + total_time_all/(5000.0*solutions) + " seconds.");
		System.out.println("The total amount of tries required between all the puzzles was " + total_tries + ",");
		System.out.println("or around " + ((double) total_tries)/(5*solutions) + " times per try.");
		System.out.println("The value of the objective function was measured a total of " + total_change + " times,");
		System.out.println("or around " + ((double) total_change)/total_tries + " times per try.");
		System.out.println("");
	}
	
}