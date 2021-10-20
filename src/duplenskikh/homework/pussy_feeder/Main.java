package duplenskikh.homework.pussy_feeder;

/*
Создать массив, который будет отображать количество корма для котов. То есть если food[1] = 5,
то у черного кота под номером 1 будет пять пакетиков еды.
Сама задача:
Создать функции, которые позволяют:
добавить или убавить еды у конкретного кота
добавить или убавить еды у всех котов сразу
добавить или убавить еды у четных или нечетных котов

Только надо класс подготовить, со статик массивом

по аналогии с задачей "угадай число"
цикл ввод, пока пользователь не введет число 666
то есть как ввел 666, то выйти из программы
в миске не может быть меньше 0 и больше 7 пакетиков корма

после ввода программа каждый раз выводит у кого сколько корма и меню
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        pussyFeeder();
    }

    private static final int FULL_FEEDER_VALUE = 7;
    private static final int EMPTY_FEEDER_VALUE = 0;
    private static final int INDEX_CORRECTION = 1;

    private static int[] feeders = new int[7];

    private static void pussyFeeder() {
        System.out.println(Utils.ENTRY_MESSAGE);
        printMenu();
        Scanner scan = new Scanner(System.in);
        do {
            switch (scan.nextInt()) {
                case 1: {
                    System.out.println(Utils.QUESTION_CAT_MESSAGE);
                    int feederIndex = scan.nextInt() - INDEX_CORRECTION;
                    System.out.println(Utils.QUESTION_FOOD_MESSAGE);
                    int foodValue = scan.nextInt();
                    feedPussy(feederIndex, foodValue);
                    printFeedersValues();
                    break;
                }
                case 2: {
                    System.out.println(Utils.QUESTION_FOOD_MESSAGE);
                    int foodValue = scan.nextInt();
                    feedAllPussies(foodValue);
                    printFeedersValues();
                    break;
                }
                case 3: {
                    System.out.println(Utils.QUESTION_FOOD_MESSAGE);
                    int foodValue = scan.nextInt();
                    feedEvenOrOddPussies(foodValue, true);
                    printFeedersValues();
                    break;
                }
                case 4: {
                    System.out.println(Utils.QUESTION_FOOD_MESSAGE);
                    int foodValue = scan.nextInt();
                    feedEvenOrOddPussies(foodValue, false);
                    printFeedersValues();
                    break;
                }
                case 5: {
                    feedAllPussiesCompletely();
                    printFeedersValues();
                    break;
                }
                case 666: {
                    System.out.println(Utils.EXIT_MESSAGE);
                    return;
                }
                default: {
                    System.out.println(Utils.ERROR_MESSAGE);
                    break;
                }
            }
        } while (true);
    }

    private static void feedPussy(int index, int value) {
        int total = feeders[index] + value;
        if (total > FULL_FEEDER_VALUE) {
            feeders[index] = FULL_FEEDER_VALUE;
            System.out.println("У кота под номером " + (index + INDEX_CORRECTION) + " полная миска(7 пакетиков)!");
            return;
        }
        if (total < 0) {
            feeders[index] = EMPTY_FEEDER_VALUE;
            System.out.println("У кота под номером" + (index + INDEX_CORRECTION) + " пустая миска!");
            return;
        }
        feeders[index] = total;
    }

    private static void feedAllPussies(int value) {
        for (int i = 0; i < feeders.length; i++) {
            feedPussy(i, value);
        }
    }

    private static void feedAllPussiesCompletely() {
        for (int i = 0; i < feeders.length; i++) {
            feeders[i] = FULL_FEEDER_VALUE;
        }
    }

    private static void feedEvenOrOddPussies(int value, boolean isEven) {
        int startPosition = isEven ? 1 : 0;
        for (int i = startPosition; i < feeders.length; i += 2) {
            feedPussy(i, value);
        }
    }

    private static void printMenu() {
        System.out.println(Utils.COMMANDS_MESSAGE);
    }

    private static void printFeedersValues() {
        for (int i = 0; i < feeders.length; i++) {
            System.out.println("В миске номер " + (i + INDEX_CORRECTION) + " содержится " + feeders[i] + " пакетика еды");
        }
        printMenu();
    }
}
