package logging.loader;

import logging.config.FileLoggerConfiguration;
import logging.config.LoggerConfiguration;
import logging.exceptions.FileConfigurationKeysMismatchException;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FileLoggerConfigurationLoaderTest {

    private LoggerConfigurationLoader loggerConfigurationLoader;

    @BeforeEach
    void setLoggerConfiguration(){
        loggerConfigurationLoader = new FileLoggerConfigurationLoader();
    }

    @Nested
    class loadConfigTestClass{

        @Test
        void loadConfigTestCorrectData() throws FileNotFoundException {
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt";
            String[] testData = new String[]{"E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                                                "INFO", "100", "[%s][%s]-[%s]"};
            LoggerConfiguration expected = new FileLoggerConfiguration(fileConfPath, testData);
            LoggerConfiguration actual =
                    loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config1.txt");
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected, actual);

        }

        @Test
        void loadConfigWithMissingOneParam(){

            Assertions.assertThrows(FileConfigurationKeysMismatchException.class,
                    ()->   loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config3.txt")

                    );
        }

        @Test
        void loadConfigWithMoreThanNeededParams(){

            Assertions.assertThrows(FileConfigurationKeysMismatchException.class,
                    ()->   loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config4.txt")

            );
        }

        @Test
        void testNullVal(){
            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->   loggerConfigurationLoader.load(null)

            );
        }

        @Test
        void testEmptyPath(){
            Assertions.assertThrows(IllegalArgumentException.class,
                    ()->   loggerConfigurationLoader.load(" ")

            );
        }

        @Test
        void testNotExistedFile(){
            Assertions.assertThrows(InvalidPathException.class,
                    ()->  loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config55.txt")

            );
        }

        @Test
        void testLoggingLevelInfoIfWrongIsGiven() throws FileNotFoundException {

            // In the config5/txt file there will be ERROR level written, but we have only two levels: INFO and DEBUG
            // If a user points out something different from those both, INFO is set up by default
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config5.txt";
            String[] testData = new String[]{"E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\log_files",
                    "INFO", "100", "[%s][%s]-[%s]"};
            LoggerConfiguration actual =
                    loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config5.txt");
            LoggerConfiguration expected = new FileLoggerConfiguration(fileConfPath, testData);
            Assertions.assertEquals(actual, expected);
        }
    }
}
