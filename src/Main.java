import exceptions.WrongBirthdayException;
import exceptions.WrongPhonenumberException;
import model.Data;



public class Main {
    public static void main(String[] args) throws WrongPhonenumberException, WrongBirthdayException {

        Data data = new Data();
        data.SaveDataEnter();
    }
}


