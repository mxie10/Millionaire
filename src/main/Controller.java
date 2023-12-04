package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Controller {
	
	private List<Question> questionList;
	private Map<String, Integer> questionOptionToSNMap;
	private Player player;
	private Scanner scanner;
	private Random random;
	private boolean hasTheGameStarted;
	private int difficultyLevel;
	private int totalQuestions;
	private int currentRound;
	private int numberOfQuestionsInEachRound;
	private boolean quit;
	private List<String> lifelineList;
	private boolean ifIslastQuestion;
	
	public Controller(List<Question> questionList, Map<String, Integer> questionOptionToSNMap) {
		this.questionList = questionList;
		this.questionOptionToSNMap = questionOptionToSNMap;
		this.player = new Player("",0,false,false,false);
		this.scanner = new Scanner(System.in);
		this.random = new Random();
		this.hasTheGameStarted = false;
		this.difficultyLevel = -1;
		this.totalQuestions = -1;
		this.currentRound = 1;
		this.numberOfQuestionsInEachRound = -1;
		this.quit = false;
		this.lifelineList = new ArrayList<>(List.of("2","3","4"));
		this.ifIslastQuestion = false;
	}

	public Map<String, Integer> getQuestionOptionToSNMap() {
		return questionOptionToSNMap;
	}

	public void setQuestionOptionToSNMap(Map<String, Integer> questionOptionToSNMap) {
		this.questionOptionToSNMap = questionOptionToSNMap;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public boolean isHasTheGameStarted() {
		return hasTheGameStarted;
	}

	public void setHasTheGameStarted(boolean hasTheGameStarted) {
		this.hasTheGameStarted = hasTheGameStarted;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public List<String> getLifelineList() {
		return lifelineList;
	}

	public void setLifelineList(List<String> lifelineList) {
		this.lifelineList = lifelineList;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public int getNumberOfQuestionsInEachRound() {
		return numberOfQuestionsInEachRound;
	}

	public void setNumberOfQuestionsInEachRound(int numberOfQuestionsInEachRound) {
		this.numberOfQuestionsInEachRound = numberOfQuestionsInEachRound;
	}

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}
	
	public boolean getIfIslastQuestion() {
		return ifIslastQuestion;
	}

	public void setIfIslastQuestion(boolean ifIslastQuestion) {
		this.ifIslastQuestion = ifIslastQuestion;
	}
	
	//step1: launch screen
	public void step1_lanuchScreen() {
		System.out.println("Welcome to \"WHO WANTS TO BE A MILLIONAIRE\" game!");
		System.out.print("\n");
		System.out.println("If You Want to Start the Game, Press 'S' or 's'");
		System.out.println("If You Want to View the Rules of the game, press 'R' or 'r'");
		System.out.println("If You Want to Quit the Game, Press 'Q' or 'q' ");
		System.out.println("----------------------------------------------------------------");
		
		String command = "";

		while (true) {
		    command = scanner.nextLine().toLowerCase();

		    switch (command) {
		        case "s":
		            System.out.println("The Game Has Started");
		            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		            hasTheGameStarted = true;
		            return;

		        case "q":
		            System.out.println("The Game Ended");
		            hasTheGameStarted = false;
		            return;

		        case "r":
		            System.out.println("The Rules for the Game, Press 'S' or 's' to Start the Game");
		            System.out.println("Once you start the game, there are two modes available for this game. If you want to play easy mode you need to press 'e', if you want to play hard mode you need to press 'h'.");
		            System.out.println("For both difficulty you will have three life line options. You can only use each life line once.");
		            System.out.println("After question is asked, the game will ask you 4 options.");
		            System.out.println("Press '1' to select your answer.");
		            System.out.println("Press '2' for 50/50 Life Line option");
		            System.out.println("Press '3' for Ask to Audience Life Line option");
		            System.out.println("Press '4' to Phone a Friend Life Line option");
		            System.out.println("After each answer the game will ask if you're sure of your answer or not.");
		            System.out.println("After each correct answer you will have two options. Continue to the next question or you may leave with the current prize.");
		            System.out.println("GOOD LUCK!");
		            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		    		System.out.println("If You Want to Start the Game, Press 'S' or 's'");
		    		System.out.println("If You Want to Quit the Game, Press 'Q' or 'q' ");
		            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		            break;

		        default:
		            System.out.println("Please Enter Either 'S or s', 'Q or q', 'R or r'");
		            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		            break;
		    }
		}

	}
	
	//step2: set up player name and difficulty
	public void step2_setPlayerNameAndDifficulty() {
		System.out.print("Please Insert Your Name: ");
		String name = scanner.nextLine();
		
		if(name.isEmpty()) {
			name = "player";
		}
		
		player.setName(name);
		String difficulty = "";
		
		while(!difficulty.equals("e") && !difficulty.equals("h")) {
			System.out.println("Please Select Game Difficulty");
			System.out.println("Press \"e\" for Easy");
			System.out.println("press \"h\" for Hard");
			difficulty = scanner.nextLine();
		}
		
		difficultyLevel = difficulty.equals("e") ? 0 : 1;
		totalQuestions = difficultyLevel == 0 ? 9 : 15;
		numberOfQuestionsInEachRound = difficultyLevel == 0 ? 3 : 5;
	}
	
	//All eligible lifeline options player in each round
	public void lifelineOptions(boolean eligible) {
		if(eligible) {
			if(player.isLifeline_fifty_fifty() == false) {
				System.out.println("Use 50/50, Press 2");
			}
			if(player.isLifeline_ask_audience() == false) {
				System.out.println("Ask the audience, Press 3");
			}
			if(player.isLifeline_phone_a_friend() == false) {
				System.out.println("Phone a friend, Press 4");
			}
		}
	}
	
	//Answer the question, also need to check if current question is the last one in current round
	//if it is, then based on the player's answer to decide whether continue to next round or end the game here.
	public boolean answerQuestion(Question question, boolean lastQuestion) {
		System.out.println("Please choose your answer");
		String answer = scanner.nextLine();
		System.out.println("Are you sure this is the correct answer?");
		System.out.println("Type \"yes\" to confirm the answer, type \"no\" to choose the answer again");
		String confirm = scanner.nextLine();
		
		while(!confirm.equals("yes")) {
			System.out.println("Please Choose Your Answer");
			answer = scanner.nextLine();
			System.out.println("Are you sure this is the correct answer?");
			System.out.println("Type \"yes\" to confirm the answer, type \"no\" to choose the answer again");
			confirm = scanner.nextLine();
		}
		if(answer.toUpperCase().equals(question.getCorrectAnswer())) {
			System.out.println("Correct!");
			player.increasePrize(1);
			return decideWhetherContinueOrNot(lastQuestion);
		}else {
			System.out.println("Wrong Answer! Game Over!");
			//set player's total prize to 0;
			quit = true;
			player.setPrize(0);
			player.getPrize();
			return false;
		}
	}
	
	//Check whether continue or not
	public boolean decideWhetherContinueOrNot(boolean lastQuestion) {
		String continueOrNot = "";
		if(lastQuestion != true) {
			System.out.println("Do you want to continue? Input \"yes\" to continue, \"no\" to exit the game");
		}else {
			System.out.println("Do you want to move into next round? Input \"yes\" to continue, \"no\" to exit the game");
		}
		while(!continueOrNot.equals("yes") && !continueOrNot.equals("no"))
			continueOrNot = scanner.nextLine();
		if(continueOrNot.equals("yes")) { 
			return true;
		}
		player.getPrize();
		quit = true;
		return false;
	}
	
	//step3: play the game
	public void play() {
		System.out.println("Now let's play the game, good luck!");
		//1 is answering the question by player himself, which suppose to be default option
		if(!lifelineList.contains(1)) lifelineList.add("1");
		
		for(int i=0;i<numberOfQuestionsInEachRound;i++) {
			if(i == numberOfQuestionsInEachRound-1) ifIslastQuestion = true;
			//generate a random number
			int randomNumber = random.nextInt(questionList.size());
			//remove and retrieve the selected question from the list;
			Question question = questionList.remove(randomNumber);
			System.out.println("Round "+currentRound+" Question"+(i+1));
			System.out.println(question.getQuestionText());
			
			//Show the options on screen
			for(int j=0;j<4;j++) {
				System.out.println(question.getOptions().get(j));
			}
			System.out.print("\n");
			System.out.println("If you want to:");
			System.out.println("Select an answer, press 1");
			
			//check if lifeline is allow to use, on difficulty level, round 1 cannot use lifeline options.
			boolean eligible = !(currentRound == 1 && difficultyLevel == 1);
			lifelineOptions(eligible);

			//get user input command
			String command = scanner.nextLine();
			while(!lifelineList.contains(command)){
				System.out.println("Please Input a Valid Command");
				command = scanner.nextLine();
			}
			
			if(command.equals("1")) {
				boolean res = answerQuestion(question,ifIslastQuestion);
				if(res) continue;
				return;
			}else {
				if(command.equals("2")) {
					if(!usefiftyfifty(question)) {
						return;
					}
				}else if(command.equals("3")) {
					useAskTheAudience(question);
				}else if(command.equals("4")) {
					usePhoneAFriend(question);
				}
			}
		}
	}

	public boolean usefiftyfifty(Question question) {
		System.out.println("");
		System.out.println("Into 50/50");
		String correctAnwser = question.getCorrectAnswer();
		int serialNumber = questionOptionToSNMap.get(correctAnwser);
		
		int count = 0;
		
		System.out.println("serialNumber is:"+serialNumber);
					
		//list operations
		List<String> tempList = new ArrayList<>();
		tempList.add(question.getOptions().remove(serialNumber));
		question.getOptions().remove(0);
		question.getOptions().remove(0);
		question.getOptions().add(tempList.get(0));
		
		for(int i=0;i<lifelineList.size();i++) {
			if(lifelineList.get(i) == "2") {
				lifelineList.remove(i);
				break;
			}
		}
		
		System.out.println("Please choose one of the answer, you have 50% chance to correctly answer the question");
		for(int i=0;i<question.getOptions().size();i++) {
			System.out.println(question.getOptions().get(i));
		}
		player.setLifeline_fifty_fifty(true);
		return answerQuestion(question,ifIslastQuestion);
	}
	
	//Please work on this method.
	public boolean useAskTheAudience(Question question) {
		System.out.println("");
		int audienceNumber;
		System.out.println("Into Ask the Audience");
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		//assume we have 400 audiences
		for(int i=0;i<400;i++) {
			audienceNumber = random.nextInt(100);
			if(audienceNumber>=0 && audienceNumber<25) {
				a+=1;
			}else if(audienceNumber>=25 && audienceNumber<50) {
				b+=1;
			}else if(audienceNumber>=50 && audienceNumber<75) {
				c+=1;
			}else {
				d+=1;
			}
		}
		System.out.println(a+" Audiences Chose A");
		System.out.println(b+" Audiences Chose B");
		System.out.println(c+" Audiences Chose C");
		System.out.println(d+" Audiences Chose D");
		
		player.setLifeline_ask_audience(true);
		return answerQuestion(question,ifIslastQuestion);
	}
	
	//Please work on this method.
	public void usePhoneAFriend(Question question) {
		System.out.println("");
		System.out.println("Phone a Friend");
	}
}
