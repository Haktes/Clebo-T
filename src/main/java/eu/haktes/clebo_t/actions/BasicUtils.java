package eu.haktes.clebo_t.actions;

public class BasicUtils {

	/**
	 * Input a unsafe String 
	 * int is returned (with "-" if needed!) 
	 */
    public static int stringToInt(String inputString) {

        int outputInt =
            Integer.parseInt(inputString.replaceAll("[^0-9\\-]", ""));

        return outputInt;
    }

}
