
/**
 * Created by aafful on 2/28/15.
 */
public class CardValidation {

    public static void main(String[] args) {

        validateCard("1556 9144 6285 339");
        validateCard("6363 1811 2857 7650");
        validateCard("6011 5940 0319 9511");
        validateCard("5537 0213 6797 6815");
        validateCard("5574 8363 8022 9735");
        validateCard("3044 8507 9391 30");
        validateCard("6370 1675 9034 6211 774");
    }

    /**
     * Uses The Luhn algorithm or Luhn formula, also known as the "modulus 10" or "mod 10" algorithm,
     * to validate that a given credit card number is valid or not. This is a simple checksum formula
     * @param str is the credit card number to be validated
     */
    private static void validateCard(String str){
        int sum = 0;
        String cardNUmber = str.replaceAll("\\s","");

        //We have to start from right to left so for simplicity sake, we just reverse the credit card number
        //If we don't want to reverse it, then we'll have to change our loop to start looping from the end
        String individualCardNUmbersReverse = new StringBuilder(cardNUmber).reverse().toString();
        String[] individualCardNUmbers = individualCardNUmbersReverse.split("");

        for (int i = 1; i < individualCardNUmbers.length ; i++) {
            if (i % 2 == 1) {
               sum += Integer.parseInt(individualCardNUmbers[i]);
            }
            else {
                int num = Integer.parseInt(individualCardNUmbers[i]);
                int doubleOfNum = 2 * num;
                String doubleOfNumString = "" + doubleOfNum;

                if (doubleOfNumString.length() == 1) {
                    sum += Integer.parseInt(doubleOfNumString);
                } else {
                    sum += addValuesWithinString(doubleOfNumString);
                }
            }
        }

        if(sum % 10 == 0){
            System.out.println("Valid Card");
        }
        else {
            System.out.println("NOT a Valid Card");
        }
    }

    /**
     * Takes a String compose of numbers. Adds the individual numbers together. Eg "123" => 1+2+3
     * @param str is the number passed as a String argument
     * @return sum of all the individual numbers in str.In case of "123" returns 6.
     */
    private static int addValuesWithinString(String str){
        String[] s = str.split("");
        int sum = 0;

        for (int i = 1; i < s.length; i++) {
            sum += Integer.parseInt(s[i]);
        }
        return sum;
    }
}
