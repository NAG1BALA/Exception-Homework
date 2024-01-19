package exceptions;

public class WrongBirthdayException extends MyException {
    public WrongBirthdayException() {super("Вы ввели свои данные не по шаблону. Попробуйте снова!");}
}
