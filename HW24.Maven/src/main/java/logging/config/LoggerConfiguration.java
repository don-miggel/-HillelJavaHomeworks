package logging.config;

import logging.LoggingLevel;

import java.util.Objects;

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
        if (loggingFormat == null || loggingFormat.trim().isEmpty()) throw new IllegalArgumentException();

        this.loggingFormat = loggingFormat;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(String loggingLevel) {
        if (loggingLevel == null || loggingLevel.trim().isEmpty()) throw new IllegalArgumentException();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoggerConfiguration)) return false;
        LoggerConfiguration that = (LoggerConfiguration) o;
        return Objects.equals(loggingFormat, that.loggingFormat) && loggingLevel == that.loggingLevel && Objects.equals(fileConfigPath, that.fileConfigPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loggingFormat, loggingLevel, fileConfigPath);
    }
}
