package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static List<Question> questionList = new ArrayList<>();
	private static Map<String, Integer> questionOptionToSNMap = new HashMap<>();
	
	public static void initializeQuestion() {
		questionList.add(new Question("What is the largest mammal in the world?", List.of("A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Gorilla"), "B")); 
		questionList.add(new Question("In which year did World War II end?", List.of("A. 1943", "B. 1945", "C. 1947", "D. 1950"), "B"));
		questionList.add(new Question("Who wrote 'Romeo and Juliet'?", List.of("A. Charles Dickens", "B. Jane Austen", "C. William Shakespeare", "D. Mark Twain"), "C"));
		questionList.add(new Question("What is the capital of Japan?", List.of("A. Beijing", "B. Seoul", "C. Tokyo", "D. Bangkok"), "C"));
		questionList.add(new Question("Which planet is known as the Red Planet?", List.of("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"), "B"));
		questionList.add(new Question("What is the currency of Brazil?", List.of("A. Euro", "B. Peso", "C. Real", "D. Yen"), "C"));
		questionList.add(new Question("Who painted the Mona Lisa?", List.of("A. Pablo Picasso", "B. Vincent van Gogh", "C. Leonardo da Vinci", "D. Michelangelo"), "C"));
		questionList.add(new Question("What is the largest ocean on Earth?", List.of("A. Atlantic Ocean", "B. Indian Ocean", "C. Southern Ocean", "D. Pacific Ocean"), "D"));
		questionList.add(new Question("What is the main ingredient in guacamole?", List.of("A. Tomatoes", "B. Avocado", "C. Onions", "D. Peppers"), "B"));
		questionList.add(new Question("Which element has the chemical symbol 'O'?", List.of("A. Oxygen", "B. Gold", "C. Iron", "D. Silver"), "A"));
		questionList.add(new Question("Who wrote 'To Kill a Mockingbird'?", List.of("A. J.K. Rowling", "B. George Orwell", "C. Harper Lee", "D. F. Scott Fitzgerald"), "C"));
		questionList.add(new Question("Which country is known as the Land of the Rising Sun?", List.of("A. China", "B. South Korea", "C. Japan", "D. Vietnam"), "C"));
		questionList.add(new Question("What is the largest desert in the world?", List.of("A. Sahara Desert", "B. Gobi Desert", "C. Antarctic Desert", "D. Arctic Desert"), "C"));
		questionList.add(new Question("Who is known as the 'Father of Computer Science'?", List.of("A. Bill Gates", "B. Alan Turing", "C. Steve Jobs", "D. Tim Berners-Lee"), "B"));
		questionList.add(new Question("What is the speed of light?", List.of("A. 300,000 km/s", "B. 500,000 km/s", "C. 700,000 km/s", "D. 1,000,000 km/s"), "A"));
		questionList.add(new Question("Which of the following is a programming language?", List.of("A. HTML", "B. CSS", "C. Java", "D. SQL"), "C"));
		questionList.add(new Question("What is the world's largest rainforest?", List.of("A. Amazon Rainforest", "B. Congo Rainforest", "C. Daintree Rainforest", "D. Sundarbans Rainforest"), "A"));
		questionList.add(new Question("Who discovered penicillin?", List.of("A. Marie Curie", "B. Alexander Fleming", "C. Louis Pasteur", "D. Jonas Salk"), "B"));
		questionList.add(new Question("Which continent is known as the 'Dark Continent'?", List.of("A. Europe", "B. Africa", "C. South America", "D. Antarctica"), "B"));
		questionList.add(new Question("What is the boiling point of water in Celsius?", List.of("A. 0°C", "B. 100°C", "C. 50°C", "D. -50°C"), "B"));
		questionList.add(new Question("In which year did the Titanic sink?", List.of("A. 1905", "B. 1912", "C. 1920", "D. 1931"), "B"));
		questionList.add(new Question("Who wrote 'The Great Gatsby'?", List.of("A. Ernest Hemingway", "B. F. Scott Fitzgerald", "C. Jane Austen", "D. George Orwell"), "B"));
		questionList.add(new Question("What is the currency of China?", List.of("A. Yen", "B. Won", "C. Yuan", "D. Ringgit"), "C"));
		questionList.add(new Question("What is the capital of France?", List.of("Paris", "Marseille", "Lyon", "Roman"), "A"));
		questionList.add(new Question("Who is the author of '1984'?", List.of("A. George Orwell", "B. Aldous Huxley", "C. Ray Bradbury", "D. J.D. Salinger"), "A"));
		
	}
	
	public static void initializeQuestionAnsSN() {
		questionOptionToSNMap.put("A", 0);
		questionOptionToSNMap.put("B", 1);
		questionOptionToSNMap.put("C", 2);
		questionOptionToSNMap.put("D", 3);
	}
	
	
	public static void main(String[] args) {
		
		initializeQuestion();
		initializeQuestionAnsSN();
		Controller controller = new Controller(questionList,questionOptionToSNMap);
		
		//begin step1
		controller.step1_lanuchScreen();
		if(!controller.isHasTheGameStarted()) {
			System.out.println("Goodbye, See You Next Time!");
			return;
		}
		
		//begin step2
		controller.step2_setPlayerNameAndDifficulty();
		
		//start playing the game, 0 is easy, 1 is difficult
		int playRound = controller.getDifficultyLevel() == 0 ? 3 : 5;
		for(int i=0; i<playRound; i++) {
			controller.play();
			if(controller.isQuit()) {
				System.out.println("Game Over!");
				//show the final prize;
				return;
			}
			controller.setCurrentRound(i+2);
		}
		
	}

}
