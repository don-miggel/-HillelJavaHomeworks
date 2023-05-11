import my.logger.FileLogger;
import my.logger.config.FileLoggerConfiguration;
import my.logger.loader.FileLoggerConfigurationLoader;


public class Main {
    public static void main(String[] args)  {

        FileLoggerConfiguration conf = FileLoggerConfigurationLoader.load("src/config_files/config1.txt");

        FileLogger log = new FileLogger(conf);
        log.debug("File not found");
        log.info("user logged in");
    }
}
