package logging.loader;

import logging.config.StdoutLoggerConfiguration;
import logging.exceptions.FileConfigurationKeysMismatchException;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;

public class StdoutLoggerConfigurationLoaderTest {

    private LoggerConfigurationLoader loggerConfigurationLoader;

    @BeforeEach
    void setLoggerConfigurationLoader(){
        loggerConfigurationLoader = new StdoutLoggerConfigurationLoader();
    }

    @Nested
    class TestStdoutConfLoader{

        @Test
        void loadFromCorrectConfigFile() throws FileNotFoundException {
            String fileConfPath = "E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt";
            String[] configData = new String[]{"INFO", "[%s][%s]-[%s]"};
            var expectedConf = new StdoutLoggerConfiguration(configData, fileConfPath);
            Assertions.assertNotNull(expectedConf);
            var actualConfiguration = loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config2.txt");
            Assertions.assertNotNull(actualConfiguration);
            Assertions.assertEquals(expectedConf, actualConfiguration);
        }

        @Test
        void testWrongConfigPath(){

            Assertions.assertThrows(
                    InvalidPathException.class,
                    ()->loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\wrong.pdf")

            );
        }

        @Test
        void testNullPassed(){

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    ()->loggerConfigurationLoader.load(null)

            );
        }

        @Test
        void testEmptyPathPassed(){

            Assertions.assertThrows(
                    IllegalArgumentException.class,
                    ()->loggerConfigurationLoader.load("   ")

            );
        }

        @Test
        void loadConfigWithMoreThanNeededParams(){

            Assertions.assertThrows(FileConfigurationKeysMismatchException.class,
                    ()->   loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config6.txt")

            );
        }

        @Test
        void loadConfigWithMissingOneParam(){

            Assertions.assertThrows(FileConfigurationKeysMismatchException.class,
                    ()->   loggerConfigurationLoader.load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\test\\resources\\config_files\\config7.txt")

            );
        }


    }

    @AfterEach
    void tearDown(){
        loggerConfigurationLoader = null;
    }


}
