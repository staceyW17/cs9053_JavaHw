package edu.nyu.cs9053.homework2;

import edu.nyu.cs9053.homework2.model.DiagnosticTroubleCode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: blangel
 */
public class Mechanic {

    /**
     * @see {@literal https://en.wikipedia.org/wiki/OBD-II_PIDs#Mode_3_(no_PID_required)}
     * @implNote For simplification of this homework, contrary to the Wikipedia article {@code data} is not in the ISO 15765-2 protocol.
     *           It is simply an array of data where the length should be equal to {@code expectedAmount} times 2.
     * @implNote If {code data} is null, empty or not equal to {@code expectedAmount} times 2 then throw
     *           an {@linkplain IllegalArgumentException}; i.e. {@code throw new IllegalArgumentException}
     * @param data to parse
     * @param expectedAmount of {@linkplain DiagnosticTroubleCode} to decode
     * @return the decoded {@linkplain DiagnosticTroubleCode} objects see {@linkplain DiagnosticTroubleCode#construct(String)} to create the object.
     */
    public static  DiagnosticTroubleCode[] decode(byte[] data, int expectedAmount) {
        if((data == null) || (data.length == 0) || (data.length != expectedAmount*2)) throw new IllegalArgumentException();
        DiagnosticTroubleCode decodeResult[] = new DiagnosticTroubleCode[expectedAmount];
        Map<String, String> decodeFirstDTCMap = new HashMap<String,String>();
        decodeFirstDTCMap.put("00","P");
        decodeFirstDTCMap.put("01","C");
        decodeFirstDTCMap.put("10","B");
        decodeFirstDTCMap.put("11","U");
        Map<String, String> decodeSecDTCMap = new HashMap<String,String>();
        decodeSecDTCMap.put("00","0");
        decodeSecDTCMap.put("01","1");
        decodeSecDTCMap.put("10","2");
        decodeSecDTCMap.put("11","3");

        for (int i = 0;i < expectedAmount*2;i = i+2) {
            String firstDTCChar = "", secondDTCChar = "";
            String encodedFirstChar = getLastBit(data[i], 7) + getLastBit(data[i], 6);
            for (String key : decodeFirstDTCMap.keySet()) {
                if (encodedFirstChar.equals(key)) {
                    firstDTCChar = decodeFirstDTCMap.get(key);
                }
            }
            String encodedSecondChar = getLastBit(data[i], 5) + getLastBit(data[i], 4);
            for (String key2 : decodeSecDTCMap.keySet()) {
                if (encodedSecondChar.equals(key2)){
                    secondDTCChar = decodeSecDTCMap.get(key2);
                }
            }
            //binary to hex, low bit
            String thirdDTCChar = String.valueOf(data[i] & 0x0F);//the 3rd Char
            //high bit
            String fourthDTCChar= String.valueOf((data[i + 1] & 0xF0) >> 4); //the 4th Char
            String fifthDTCChar= String.valueOf(data[i + 1] & 0x0F);//the 5th Char
            String decodedChars = firstDTCChar + secondDTCChar + thirdDTCChar + fourthDTCChar + fifthDTCChar;
            decodeResult[i/2] = new DiagnosticTroubleCode(decodedChars);
        }
        return decodeResult; // TODO - implement
    }
    public static String getLastBit(byte b, int i){
        return String.valueOf(b >>> i & 1);
    }

}
