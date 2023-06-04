package com.qa.opencart.java;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

public class LocatorReaderJSON {
    static JSONParser parser = null;
    static Object obj = null;
    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap;

    public static void main(String[] args) throws IOException, ParseException {
         HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> localMap =
                new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
        String fileName ="welcomepage.json";
        localMap = fetchLocalVal(fileName);
        readJsonLocal("next_button","android",localMap);
    }

    public static HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> fetchLocalVal(String fileName)
            throws IOException, ParseException {
        parser = new JSONParser();
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator +
                "resources" + File.separator + fileName);
        obj = parser.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        localMap = new HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>>();
        localMap.put("locatorMap", (HashMap<String, HashMap<String, HashMap<String, String>>>) obj);
        return localMap;
    }

    public static void readJsonLocal(
            String locatorName, String channel, HashMap<String, HashMap<String, HashMap<String, HashMap<String, String>>>> comMap) {

        HashMap<String, HashMap<String, HashMap<String, String>>> localMapobj = comMap.get("locatorMap");
        HashMap<String, HashMap<String, String>> locatorMap = localMapobj.get(locatorName);
        HashMap<String, String> channelMap = locatorMap.get(channel);
        String locatorValue = channelMap.get("ele_Ref");
        String locatorType = channelMap.get("ele_type");

        if (channel.contains("android")) {
            switch (locatorType.toLowerCase()) {
                case "id":
                    System.out.println(locatorValue);
                case "name":
                    System.out.println(locatorValue);
                case "xpath":
                    System.out.println(locatorValue);
                default:
                    break;
            }
        } else if (channel.contains("ios")) {

        }
    }



    public static String getDay() {
        String dayOfWeekIndex = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dayOfTheWeek = simpleDateFormat.format(new Date());
        System.out.println(dayOfTheWeek);
        switch (dayOfTheWeek) {
            case "Monday":
                dayOfWeekIndex = "1";
                break;
            case "Tuesday":
                dayOfWeekIndex = "2";
                break;
            case "Wednesday":
                dayOfWeekIndex = "3";
                break;
            case "Thursday":
                dayOfWeekIndex = "4";
                break;
            case "Friday":
                dayOfWeekIndex = "5";
                break;
            default:
                break;
        }
        return dayOfWeekIndex;
    }

    public static String randomNumber() {
        Random random = new Random();
        return String.format("%01d%n", random.nextInt(10000));
    }

    public static String generateLast4Digits() {
        Random random = new Random();
        return String.format("%04d%n", random.nextInt(10000));
    }

    public String getRandomMobileNumber() {
        long timeSeed = System.nanoTime();
        double randSeed = Math.random() * 1000;
        long midSeed = (long) (timeSeed * randSeed);
        String s = midSeed + "";
        String mobileNumber = s.substring(0, 10);
        return mobileNumber;
    }

    public String getRandomEmailId() {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(8);
        for (int i = 0; i <= 8; i++) {
            int nextRandomChar = lowerLimit + (int) (random.nextFloat() * (upperLimit - lowerLimit + 1));
            stringBuilder.append((char) nextRandomChar);
        }
        return stringBuilder.toString() + ".zqbtdihb@mailosaur.io";
    }

    public String dateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    public static void setValuesInPropertiesFile(String propertyFileName, String key, String value) throws IOException {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            File file = new File(System.getProperty("user.dir") +
                    File.separator + "src" + File.separator +"test"+ File.separator + "resources"+ File.separator + propertyFileName);
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            properties.setProperty(key, value);
            fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, "Updated dynamic values for the file name is - " + propertyFileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null && fileInputStream != null) {
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static Properties getProps(String propertyFileName) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        if (properties.isEmpty()) {
            try {
                File file = new File(System.getProperty("user.dir") +
                        File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + propertyFileName);
                fileInputStream = new FileInputStream(file);
                properties.load(fileInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        }
        return properties;
    }


    public HashMap<String, String> generateUserInfo() {

        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 4;
        Random random1 = new Random();
        String generatedString = random1.ints(leftLimit, rightLimit + 1).
                limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String streetAddress = randomNumber + " " + generatedString + " Street";

        for (int i = 0; i <= generatedString.length() - 1; i++)
            for (int j = i + 1; j <= generatedString.length() - 1; j++)
                if (generatedString.toLowerCase().charAt(i) == generatedString.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
                    streetAddress = randomNumber + " " + generatedString + " Street";
                }

        String firstName = "A" + "" + generatedString + "o";
        for (int i = 0; i <= firstName.length() - 1; i++)
            for (int j = i + 1; j <= firstName.length() - 1; j++)
                if (firstName.toLowerCase().charAt(i) == firstName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    firstName = "A" + "" + generatedString + "o";
                }

        String middleName = generatedString + "yu";
        for (int i = 0; i <= middleName.length() - 1; i++)
            for (int j = i + 1; j <= middleName.length() - 1; j++)
                if (middleName.toLowerCase().charAt(i) == middleName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    middleName = generatedString + "yu";
                }

        String lastName = "R" + "" + generatedString + "y";
        for (int i = 0; i <= lastName.length() - 1; i++)
            for (int j = i + 1; j <= lastName.length() - 1; j++)
                if (lastName.toLowerCase().charAt(i) == lastName.toLowerCase().charAt(j)) {
                    generatedString = random1.ints(leftLimit, rightLimit + 1)
                            .limit(targetStringLength)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString();
                    lastName = "R" + "" + generatedString + "y";
                }


        HashMap<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("StreetAddress", streetAddress);
        userInfoMap.put("firstName", firstName);
        userInfoMap.put("middleName", middleName);
        userInfoMap.put("lastName", lastName);

        return userInfoMap;
    }


}
