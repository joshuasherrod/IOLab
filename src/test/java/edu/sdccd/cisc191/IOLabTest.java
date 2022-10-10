package edu.sdccd.cisc191;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

    /**
     * Adapted from Tasha Frankie and Allan Schougaard
     */

    class IOLabTest
    {
        @Test
        void testReadTestResultsExists()
        {
            String results = IOLab.readTestResults("TestResult.csv");
            assertTrue(results.startsWith("Alex,Smith,99,A"));
            assertTrue(results.contains("Jolene,Schmidt,100,A"));
            assertTrue(results.endsWith("Mackinzie,Jensen,86,B"));
        }

        @Test
        void testReadTestResultsDoesNotExist()
        {
            String results = IOLab.readTestResults("IDoNotExist.csv");
            assertEquals("", results);
        }

        @Test
        void testAppendTestResults()
        {
            // Note: With each run, a new set of data may be appended to the file
            IOLab.appendTestResult("NewTestResults.csv", "Julie,Brown,100,A");
            String results = IOLab.readTestResults("NewTestResults.csv");
            assertTrue(results.endsWith("Julie,Brown,100,A"));
            IOLab.appendTestResult("NewTestResults.csv", "Davy,Jones,30,F");
            results = IOLab.readTestResults("NewTestResults.csv");
            assertTrue(results.contains("Julie,Brown,100,A"));
            assertTrue(results.endsWith("Davy,Jones,30,F"));
        }

        @Test
        void testReadDateTime()
        {
            // You can see that the server responds with by entering the URL in a browser
            // and selecting Raw Data
            String dateTime = IOLab.readDateTime("http://worldtimeapi.org/api/ip");
            // Hint: use String's indexOf("\"datetime\":\", 0)
            // assertTrue(dateTime.startsWith("202"));
            assertTrue(dateTime.contains("T"));
            assertTrue(dateTime.endsWith("-07:00")); // unless you are on a different timezone
        }
    }
