package my.logger.logger;

import my.logger.LoggingLevel;
import my.logger.config.LoggerConfiguration;

import java.time.LocalDateTime;

public class StdoutLogger extends Logger{


    public StdoutLogger(LoggerConfiguration config) {
        super(config);
    }

    @Override
    public void debug(String msg) {
        if (getConfig().getLoggingLevel().equals(LoggingLevel.INFO))
            return;
        System.out.printf(getConfig().getLoggingFormat(), LocalDateTime.now(), LoggingLevel.DEBUG, msg);
        System.out.println();
    }

    @Override
    public void info(String msg) {
        System.out.printf(getConfig().getLoggingFormat(), LocalDateTime.now(), LoggingLevel.INFO, msg);
        System.out.println();

    }
}
