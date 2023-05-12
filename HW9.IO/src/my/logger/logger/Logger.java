package my.logger.logger;

import my.logger.LoggingLevel;
import my.logger.config.LoggerConfiguration;

public abstract class Logger {

    private LoggerConfiguration config;
    public Logger(LoggerConfiguration config){
        this.config = config;
    }

    public LoggerConfiguration getConfig() {
        return config;
    }

    public abstract void debug(String msg);
    public abstract void info(String msg);

}
