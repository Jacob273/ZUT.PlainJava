package jg.zut.java.lab09.validation;

public class PeselValidator extends IValidator {


    private char[] peselArr;

    @Override
    public boolean Validate() {
        return (peselArr[0] + 3 * peselArr[1] + 7 * peselArr[2] + 9 * peselArr[3] +
                 peselArr[4] + 3 * peselArr[5] + 7 * peselArr[ 6 ] +  9 * peselArr[ 7 ] +
                 peselArr[8] + 3 * peselArr[9] + peselArr[10]) % 10 == 0;
    }

    public PeselValidator(String pesel){
        peselArr = pesel.toCharArray();
    }


}
