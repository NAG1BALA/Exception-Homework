package model;

import exceptions.WrongBirthdayException;
import exceptions.WrongPhonenumberException;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }


    private void EnterFirstName() {
        System.out.println("Введите имя, использую русскую раскладку:");
        firstName = scan.nextLine();
        Pattern p = Pattern.compile("[а-яА-я]+");
        Matcher m = p.matcher(firstName);
        if (m.matches()) {
        } else
            throw new RuntimeException("Использованы неверные символы.\nПопробуйте снова!");
    }


    private void EnterLastName() {
        System.out.println("Введите фамилию, использую русскую раскладку:");
        lastName = scan.nextLine();
        Pattern p = Pattern.compile("[а-яА-я]+");
        Matcher m = p.matcher(lastName);
        if (m.matches()) {
        } else
            throw new RuntimeException("Использованы неверные символы.\nПопробуйте снова!");
    }

    private void EnterPatronymic() {
        System.out.println("Введите отчество, использую русскую раскладку:");
        patronymic = scan.nextLine();
        Pattern p = Pattern.compile("[а-яА-я]+");
        Matcher m = p.matcher(patronymic);
        if (m.matches()) {
        } else
            throw new RuntimeException("Использованы неверные символы.\nПопробуйте снова!");
    }


    private void EnterBirthday() throws WrongBirthdayException {
        System.out.println("Введите дату рождения в формате 'день-номер месяца-год'");
        birthday = scan.nextLine();
        if (birthday.equals("")) {
            throw new RuntimeException("Отсутствуют вводные данные.\nПопробуйте снова!");
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date time = dateFormat.parse(birthday);
        } catch (ParseException e) {
            throw new WrongBirthdayException();
        }
    }

    private void EnterNumberPhone() throws WrongPhonenumberException {
        System.out.println("Введите свой номер телефона (11 цифр) в формате: '79XXXXXXXXX' без знака '+'");
        String number = scan.nextLine();
        if (number.equals("")) {
            throw new RuntimeException("Отсутствуют вводные данные.\nПопробуйте снова!");
        } else if (number.length() < 11) {
            throw new RuntimeException("Недостаточное количество символов.\nПопробуйте снова!");
        } else if (number.length() > 11) {
            throw new RuntimeException("Слишком большое количество символов.\nПопробуйте снова!");
        }
        try {
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new WrongPhonenumberException();
        }
    }

    private void EnterGender() {
        System.out.println("Укажите свой пол. Введите символ латиницей");
        System.out.println("'f' - если женский пол");
        System.out.println("'m' - если мужской пол");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов. \nПопробуйте снова");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    private void OutPutData() {
        System.out.println("\nИмя \t- \t" + firstName + "\n" + "Фамилия \t- \t" + lastName + "\n" + "Отчество \t- \t" + patronymic + "\n" + "Дата рождения \t- \t" + birthday + "\n" + "Номер телефона \t- \t" + numberPhone + "\n" + "Пол   \t- \t" + gender);
    }

    private void DataEnter() throws WrongPhonenumberException, WrongBirthdayException {
        EnterFirstName();
        EnterLastName();
        EnterPatronymic();
        EnterBirthday();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }


    public void SaveDataEnter() throws WrongPhonenumberException, WrongBirthdayException {

        DataEnter();
        String file = (lastName + "." + "txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + patronymic + "> " + "<" + birthday + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так! Файл не был сохранен.");
            System.out.println(e.getMessage());
        }
    }
}



