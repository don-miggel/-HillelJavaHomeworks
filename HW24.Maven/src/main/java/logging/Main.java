package logging;


import logging.config.LoggerConfiguration;
import logging.loader.FileLoggerConfigurationLoader;
import logging.loader.StdoutLoggerConfigurationLoader;
import logging.logger.*;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args)  {

        LoggerConfiguration conf = null;
        /*

        conf = new FileLoggerConfigurationLoader().load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\main\\resources\\config_files\\config3.txt");

        Logger log = new FileLogger(conf);
        log.debug("File not found");
        log.info("user logged in");

         */


        LoggerConfiguration conf1 = new StdoutLoggerConfigurationLoader().load("E:\\JavaProjects\\HillelJavaHomeworks\\HW24.Maven\\src\\main\\resources\\config_files\\config2.txt");

        Logger logStdout = new StdoutLogger(conf1);
        logStdout.debug("Opening file error occurred !");
        logStdout.info("User opened a .jpg file");


    }
}
