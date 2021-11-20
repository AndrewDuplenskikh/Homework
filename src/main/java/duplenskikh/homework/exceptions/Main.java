package duplenskikh.homework.exceptions;

/*
Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
Login должен содержать только латинские буквы. Длина login должна быть меньше 20 символов.
Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.

Password должен содержать только латинские буквы.
Длина password должна быть меньше 20 символов.
Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами –
один по умолчанию,
второй принимает сообщение исключения и передает его в конструктор класса Exception.
Обработка исключений проводится внутри метода.
Используем multi-catch block.
Метод возвращает true, если значения верны или false в другом случае
Для проверки строки, содержит ли она только латинские символы, можно использовать регулярное выражение:
input.matches ("[a-zA-Z]+\.?");
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите последовательно значения: логин, пароль, подтверждение пароля.");
        } while (!isValuesCorrect(scanner.next(), scanner.next(), scanner.next()));
    }

    private static boolean isValuesCorrect(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z]+\\.?")) {
                throw new WrongLoginException(ErrorMessages.LOGIN_SYMBOLS);
            }
            if (login.length() > 19) {
                throw new WrongLoginException(ErrorMessages.LOGIN_LENGTH);
            }
            if (!password.matches("[a-zA-Z]+\\.?")) {
                throw new WrongPasswordException(ErrorMessages.PASSWORD_SYMBOLS);
            }
            if (password.length() > 19) {
                throw new WrongPasswordException(ErrorMessages.PASSWORD_LENGTH);
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException(ErrorMessages.PASSWORD_EQUAL);
            }
            System.out.println("Все хорошо!");
            return true;
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
