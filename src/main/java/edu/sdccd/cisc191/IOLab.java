package edu.sdccd.cisc191;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

/**
     *
     * References:
     * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
     * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
     *
     */

    public class IOLab {
    public static String readTestResults(String s) {

        //Empty String to add our file contents to
        String results = "";

        //try/catch block in case an exception is thrown
        try {
            //Locating the file we are intending to use
            File testResult = new File("src/main/resources/" + s);
            //Creating a Scanner to pass in our file
            Scanner scanner = new Scanner(testResult);
            //While our file has lines, add them to our empty string
            while (scanner.hasNextLine()) {
                //add each line of the file to our string
                results += scanner.nextLine();
            }
            //Return new content read from file
            return results;
        }
        //In case an exception is thrown, return nothing
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void appendTestResult(String s, String s1) {
        //try/catch block in case an exception is thrown
        try {
            //Locate the file we intend to use
            File newResults = new File("src/main/resources/" + s);
            //Set up new PrintWriter for our file, append = true to replace
            //old file contents, autoFlush = true to flush when finished
            PrintWriter write = new PrintWriter(new FileWriter(newResults, true), true);
            //Override old file contents with new file contents
            write.println(s1);
        } catch (IOException e) {
            //In case our file is not found, print error message to console
            System.out.println("File not found");
        }
    }

    public static String readDateTime(String s) {
        //try/catch block in case an exception is thrown
        try {
            //Create a new URL object to pass in our URL (s)
            URL website = new URL(s);
            //Create scanner object to scan data from URL object
            Scanner download = new Scanner(website.openStream());
            //Put data from scanner into a string
            String getInput = download.nextLine();
            //Convert index of "dateTime" into an int
            int dateTime = getInput.indexOf("datetime");
            //Return date and time as a substring from index 11-35
            return getInput.substring(dateTime+11, dateTime+43);
        //Catch exception for incorrect URLs
        } catch (MalformedURLException e) {
            //If URL is not found, print error message to user
            System.out.println("Url now found");
        //Catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}