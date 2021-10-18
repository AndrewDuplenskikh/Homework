package duplenskikh.homework.guess_number;

/*
* Пограмма загадывает случайное число от 1 до 100.
* Говорит пользователю "Угадай" У пользователя 10 попыток.
* Программа говорит больше или меньше число (если пользователь не угадал)
* Когда игра заканчивается, выводится загаданое число
*/


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessNumber();
    }

    private static void guessNumber() {
        int numberToGuess = generateNumber();
        int triesCount = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Угадайте число от 1 до 100.");
        int playersInput;
        for (int i = 1; i <= triesCount; i++) {
            playersInput = scanner.nextInt();
            if (playersInput == numberToGuess) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (playersInput > numberToGuess) {
                System.out.println("Введенное число больше загаданного");
                continue;
            } else {
                System.out.println("Введенное число меньше загаданного");
            }
        }
        System.out.print("Загаданное число - " + numberToGuess);
    }

    private static int generateNumber() {
        Random random = new Random();
        int RANGE_CORRECTION = 1;
        int range = 100;
        int number = random.nextInt(range + RANGE_CORRECTION);
        return number;
    }
}
