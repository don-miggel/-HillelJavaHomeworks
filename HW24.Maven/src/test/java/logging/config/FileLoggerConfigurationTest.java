package logging.config;


import logging.loader.FileLoggerConfigurationLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;

public class FileLoggerConfigurationTest {

    private LoggerConfiguration fileLoggerConfigExpected;

    @BeforeEach
    void setUpFileLoggerConfigLoader(){

        var loggerConfigurationLoader = new FileLoggerConfigurationLoader();

        fileLoggerConfigExpected =
                loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt");
    }

    @Nested
    class FileLoggerConfigurationObjCreatingTest {

        @Test
        void testFileLoggerConfigurationObjCreating() {

            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            String[] testData = new String[]{"E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                    "INFO", "100", "[%s][%s]-[%s]"};
            LoggerConfiguration actual = new FileLoggerConfiguration(fileConfPath, testData);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(fileLoggerConfigExpected, actual);

        }

        @Test
        void testFileLoggerConfigurationObjCreatingWithAnotherConstructor() {

            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            LoggerConfiguration actual = new FileLoggerConfiguration(fileConfPath, "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                    "INFO",  100,"[%s][%s]-[%s]");
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(fileLoggerConfigExpected, actual);

        }

        @Test
        void testFileLoggerConfigurationPath() {

            String  expectedConfigPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            String actualConfPath = fileLoggerConfigExpected.getFileConfigPath();
            Assertions.assertNotNull(actualConfPath);
            Assertions.assertEquals(expectedConfigPath,actualConfPath);

        }

        @Test
        void testFileLoggerOutputFilePath() {

            String  expectedOutputPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files";
            String actualOutputFilePath = ((FileLoggerConfiguration)fileLoggerConfigExpected).getFilePath();
            Assertions.assertNotNull(actualOutputFilePath);
            Assertions.assertEquals(expectedOutputPath,actualOutputFilePath);

        }

        @Test
        void testMaxFileSize() {

            int  expectedMaxFileSize = 100;
            int actualMaxFileSize = ((FileLoggerConfiguration)fileLoggerConfigExpected).getMaxFileSize();

            Assertions.assertEquals(expectedMaxFileSize,actualMaxFileSize);

        }

        @Test
        void testMaxFileSizeSettingCorrectVal() {

            int expectedMaxFileSize = 500;

            ((FileLoggerConfiguration)fileLoggerConfigExpected).setMaxFileSize(500);

            int actualMaxFileSize =  ((FileLoggerConfiguration)fileLoggerConfigExpected).getMaxFileSize();

            Assertions.assertEquals(expectedMaxFileSize,actualMaxFileSize);

        }

        @Test
        void testMaxFileSizeSettingInvalidVal(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  ((FileLoggerConfiguration)fileLoggerConfigExpected).setMaxFileSize(0)

            );
        }

        @Test
        void testSetUpCorrectOutputPath(){

            String expectedPath =  "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources";
            ((FileLoggerConfiguration)fileLoggerConfigExpected).setFilePath(expectedPath);
            String actualPath =  ((FileLoggerConfiguration)fileLoggerConfigExpected).getFilePath();
            Assertions.assertNotNull(actualPath);
            Assertions.assertEquals(expectedPath, actualPath);

        }

        @Test
        void testSetUpNullPath(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  ((FileLoggerConfiguration)fileLoggerConfigExpected).setFilePath(null)

            );
        }

        @Test
        void testSetUpEmptyPath(){

            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->  ((FileLoggerConfiguration)fileLoggerConfigExpected).setFilePath("   ")

            );
        }

        @Test
        void testSetUpWrongPath(){

            Assertions.assertThrows(InvalidPathException.class,
                    ()->  ((FileLoggerConfiguration)fileLoggerConfigExpected).setFilePath("E:\\someFolder\\HW24.Maven\\src\\test\\resources")

            );
        }

        @Test
        void testEquality(){

            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            String[] testData = new String[]{"E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                    "INFO", "100", "[%s][%s]-[%s]"};
            LoggerConfiguration actual = new FileLoggerConfiguration(fileConfPath, testData);
            Assertions.assertNotNull(actual);
            boolean expected = actual.equals(fileLoggerConfigExpected);
            Assertions.assertTrue(expected);
        }

        @Test
        void testEqualityTheSame(){
            boolean expected = true;
            boolean actual = fileLoggerConfigExpected.equals(fileLoggerConfigExpected);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testEqualityNull(){
            boolean expected = false;
            boolean actual = fileLoggerConfigExpected.equals(null);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testEqualityNotLoggerConfigObj(){
            boolean expected = false;
            boolean actual = fileLoggerConfigExpected.equals(new FileLoggerConfigurationLoader());
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testEqualityWithNotEqualConfigObj(){
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            String[] testData = new String[]{"E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                    "DEBUG", "200", "[%s][%s]-(%s)"};
            LoggerConfiguration actual = new FileLoggerConfiguration(fileConfPath, testData);
            Assertions.assertNotNull(actual);
            boolean expected = fileLoggerConfigExpected.equals(actual);
            Assertions.assertFalse(expected);
        }

        @Test
        void testHashCode(){
            int actual = fileLoggerConfigExpected.hashCode();
            Assertions.assertTrue(actual != 0);
        }

        @Test
        void testToString(){
            String expected = "FileLoggerConfiguration{filePath='E:\\JavaProjects\\HillelJavaHomeworks\\" +
                    "HW24.Maven\\src\\test\\resources\\log_files', loggingLevel=INFO, maxFileSize=100, " +
                    "loggingFormat='[%s][%s]-[%s]'}";

            String actual = fileLoggerConfigExpected.toString();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void testGetFileConfigPath(){
            String expected = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            String actual = fileLoggerConfigExpected.getFileConfigPath();
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected, actual);
        }



    }




}
