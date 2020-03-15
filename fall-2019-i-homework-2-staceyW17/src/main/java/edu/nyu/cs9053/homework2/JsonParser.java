package edu.nyu.cs9053.homework2;

import edu.nyu.cs9053.homework2.model.EngineLightAlert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 *
 * @see {@literal https://www.json.org/}
 * @see {@literal https://en.wikipedia.org/wiki/JSON}
 */
public class JsonParser {

    /**
     * @param alert to serialize into {@literal JSON}
     * @return the serialized {@literal JSON} representation of {@code alert}
     * @implNote a null value should be an {@linkplain IllegalArgumentException}; i.e. {@code throw new IllegalArgumentException}
     */
    public static String toJson(EngineLightAlert alert) {
        String vehicleID = "";
        String codeToJson = "";
        String codesToJson = "";
        String alertToJson = "";

        if (alert == null) {
            throw new IllegalArgumentException();
        }

        //vehicleId
        if (alert.getVehicleId() == null) {
            alertToJson = "{";
        } else {
            String replacedVehicleID = alert.getVehicleId().replaceAll(Pattern.quote("\""), Matcher.quoteReplacement("\\\""));
            vehicleID = "{\"vehicleId\":" + "\"" + replacedVehicleID + "\"" + ",";//{"vehecleId":"str",
        }

        //dateTime
        String date = String.valueOf(alert.getDateTime());

        //codes
        if (alert.getCodes().length == 0) {
            codesToJson = "";
        } else {
            date += ",";
            //code in codes
            for (int i = 0; i < alert.getCodes().length; i++) {
                //for the code not the first and not null
                if (i != 0 && alert.getCodes()[i] != null) {
                    codeToJson += ",";
                }
                //if code is null
                if (alert.getCodes()[i] != null) {
                    if (alert.getCodes()[i].getCode() != null) {
                        codeToJson += "{\"code\":" + "\"" + alert.getCodes()[i].getCode() + "\"" + "}";// "codes":[{"code":"string"},{"code":"string"}]
                    } else codeToJson += "{}";
                } else codeToJson += "";
            }
            codesToJson = "\"codes\":" + "[" + codeToJson + "]"; // "codes": [code]
        }

        alertToJson += vehicleID +
                "\"dateTime\"" + ":" + date +
                codesToJson + "}";

        return alertToJson; // TODO - implement
    }


}
