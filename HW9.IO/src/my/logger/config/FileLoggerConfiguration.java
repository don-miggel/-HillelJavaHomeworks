package my.logger.config;

import my.logger.LoggingLevel;

public class FileLoggerConfiguration extends LoggerConfiguration{

    private String logFilePath;
    private int maxFileSize;

    public FileLoggerConfiguration(String fileConfigPath, String filePath, String loggingLevel, int maxFileSize,
                                   String loggingFormat) {
        super(loggingLevel,loggingFormat, fileConfigPath);
        setFilePath(filePath);
        setMaxFileSize(maxFileSize);
    }

    public FileLoggerConfiguration(String fileConfigPath, String[] configData) {
        this(fileConfigPath, configData[0], configData[1], Integer.parseInt(configData[2]), configData[3]);
    }

       public String getFileConfigPath() {
        return fileConfigPath;
    }

    public void setFilePath(String filePath) {
        this.logFilePath = filePath;
    }

    public String getFilePath() {
        return logFilePath;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "filePath='" + logFilePath + '\'' +
                ", loggingLevel=" + loggingLevel +
                ", maxFileSize=" + maxFileSize +
                ", loggingFormat='" + loggingFormat + '\'' +
                '}';
    }
}
