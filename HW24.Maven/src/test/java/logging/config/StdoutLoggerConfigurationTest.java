package logging.config;

import logging.loader.FileLoggerConfigurationLoader;
import logging.loader.StdoutLoggerConfigurationLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class StdoutLoggerConfigurationTest {

    private LoggerConfiguration stdoutLoggerConfigExpected;

    @BeforeEach
    void setUpFileLoggerConfigLoader(){

        var loggerConfigurationLoader = new StdoutLoggerConfigurationLoader();

        stdoutLoggerConfigExpected =
                loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt");
    }

    @Nested
    class StdoutLoggerConfigurationTesting{

        @Test
        void testStdoutLoggerConfigurationObjCreatingWithArray(){
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            String[] testData = new String[]{"INFO", "[%s][%s]-[%s]"};
            LoggerConfiguration actual = new StdoutLoggerConfiguration(testData, fileConfPath);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(stdoutLoggerConfigExpected, actual);
        }

        @Test
        void testStdoutLoggerConfigurationObjCreatingWithValues(){
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            LoggerConfiguration actual = new StdoutLoggerConfiguration("INFO","[%s][%s]-[%s]", fileConfPath);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(stdoutLoggerConfigExpected, actual);

        }

        @Test
        void testEquality(){

            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            String[] testData = new String[]{"INFO", "[%s][%s]-[%s]"};
            LoggerConfiguration actual = new StdoutLoggerConfiguration(testData, fileConfPath);
            System.out.println(actual);
            Assertions.assertNotNull(actual);
            boolean expected =stdoutLoggerConfigExpected.equals(actual);
            Assertions.assertTrue(expected);
        }

        @Test
        void testEqualityTheSame(){
            boolean expected = true;
            boolean actual = stdoutLoggerConfigExpected.equals(stdoutLoggerConfigExpected);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testEqualityNull(){
            boolean expected = false;
            boolean actual = stdoutLoggerConfigExpected.equals(null);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testEqualityNotLoggerConfigObj(){
            boolean expected = false;
            boolean actual = stdoutLoggerConfigExpected.equals(new FileLoggerConfigurationLoader());
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testToString(){
            String expected = "StdoutLoggerConfiguration{loggingFormat='[%s][%s]-[%s]', " +
                    "loggingLevel=INFO, fileConfigPath='E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\" +
                    "src\\test\\resources\\config_files\\config2.txt'}";
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            String[] testData = new String[]{"INFO", "[%s][%s]-[%s]"};
            LoggerConfiguration actual = new StdoutLoggerConfiguration(testData, fileConfPath);
            Assertions.assertEquals(expected, actual.toString());

        }

        @Test
        void testGetLoggingFormat(){
            String expected = "[%s][%s]-[%s]";
            String actual = stdoutLoggerConfigExpected.getLoggingFormat();
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testGetLoggingLevel(){
            String expected = "INFO";
            String actual = stdoutLoggerConfigExpected.getLoggingLevel().toString();
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testSetCorrectLoggingLevel(){
            String expected = "DEBUG";
            stdoutLoggerConfigExpected.setLoggingLevel("DEBUG");
            String actual = stdoutLoggerConfigExpected.getLoggingLevel().toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testNullLoggingLevel(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  stdoutLoggerConfigExpected.setLoggingLevel(null)

            );
        }

        @Test
        void testEmptyLoggingLevel(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  stdoutLoggerConfigExpected.setLoggingLevel("   ")

            );
        }

        @Test
        void testSetInvalidLoggingLevel(){
            String expected = "INFO";
            stdoutLoggerConfigExpected.setLoggingLevel("ERROR");
            String actual = stdoutLoggerConfigExpected.getLoggingLevel().toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testNullLoggingFormat(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  stdoutLoggerConfigExpected.setLoggingFormat(null)

            );
        }

        @Test
        void testEmptyLoggingFormat(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  stdoutLoggerConfigExpected.setLoggingFormat("   ")

            );
        }

        @Test
        void testECorrectLoggingFormat(){

            String expected = "%s/%s--(%s)";
            stdoutLoggerConfigExpected.setLoggingFormat("%s/%s--(%s)");
            String actual = stdoutLoggerConfigExpected.getLoggingFormat();
            Assertions.assertEquals(expected, actual);
        }

    }

}
