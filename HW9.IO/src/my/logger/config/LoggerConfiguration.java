package my.logger.config;

import my.logger.LoggingLevel;

public abstract class LoggerConfiguration {

    protected String loggingFormat;
    protected LoggingLevel loggingLevel;
    protected String fileConfigPath;

    public LoggerConfiguration(String loggingLevel, String loggingFormat, String fileConfigPath){
        setLoggingLevel(loggingLevel);
        setLoggingFormat(loggingFormat);
        setFileConfigPath(fileConfigPath);
    }

    public String getLoggingFormat() {
        return loggingFormat;
    }

    public void setLoggingFormat(String loggingFormat) {
        this.loggingFormat = loggingFormat;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(String loggingLevel) {
        if (loggingLevel.equals("DEBUG") || loggingLevel.equals("INFO")) {
            this.loggingLevel = LoggingLevel.valueOf(loggingLevel);
            return;
        }
        // if user gives a wrong logging level, which is neither DEBUG nor INFO, set "INFO" by default
        this.loggingLevel = LoggingLevel.INFO;
    }

    public String getFileConfigPath() {
        return fileConfigPath;
    }

    public void setFileConfigPath(String fileConfigPath) {
        this.fileConfigPath = fileConfigPath;
    }
}
