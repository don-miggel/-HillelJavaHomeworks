import my.logger.config.LoggerConfiguration;
import my.logger.loader.StdoutLoggerConfigurationLoader;
import my.logger.logger.FileLogger;
import my.logger.loader.FileLoggerConfigurationLoader;
import my.logger.logger.Logger;
import my.logger.logger.StdoutLogger;


public class Main {
    public static void main(String[] args)  {

        LoggerConfiguration conf = new FileLoggerConfigurationLoader().load("src/config_files/config1.txt");

        Logger log = new FileLogger(conf);
        log.debug("File not found");
        log.info("user logged in");
        LoggerConfiguration conf1 = new StdoutLoggerConfigurationLoader().load("src/config_files/config2.txt");

        Logger logStdout = new StdoutLogger(conf1);
        logStdout.debug("Opening file error occurred !");
        logStdout.info("User opened a .jpg file");
    }
}
