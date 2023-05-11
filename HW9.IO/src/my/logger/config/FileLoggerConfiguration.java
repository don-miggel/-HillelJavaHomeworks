package my.logger.config;

import my.logger.LoggingLevel;

public class FileLoggerConfiguration {

    private String filePath;
    private String fileConfigPath;
    private LoggingLevel loggingLevel;
    private int maxFileSize;
    private String loggingFormat;

    public FileLoggerConfiguration(String fileConfigPath, String filePath, String loggingLevel, int maxFileSize, String loggingFormat) {
        setFilePath(filePath);
        setFileConfigPath(fileConfigPath);
        setLoggingLevel(loggingLevel);
        setMaxFileSize(maxFileSize);
        setLoggingFormat(loggingFormat);
    }

    public FileLoggerConfiguration(String fileConfigPath, String[] configData) {
        this(fileConfigPath, configData[0], configData[1], Integer.parseInt(configData[2]), configData[3]);
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

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getLoggingFormat() {
        return loggingFormat;
    }

    public void setLoggingFormat(String loggingFormat) {
        this.loggingFormat = loggingFormat;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "filePath='" + filePath + '\'' +
                ", loggingLevel=" + loggingLevel +
                ", maxFileSize=" + maxFileSize +
                ", loggingFormat='" + loggingFormat + '\'' +
                '}';
    }
}
