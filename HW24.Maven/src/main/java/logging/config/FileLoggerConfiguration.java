package logging.config;


import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Objects;

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
        if (filePath == null || filePath.trim().isEmpty()) throw new IllegalArgumentException();
        Path configFile = Path.of(filePath);
        if(!new File(configFile.toUri()).exists())
            throw new InvalidPathException(configFile.toString(), "wrong path");

        this.logFilePath = filePath;
    }

    public String getFilePath() {
        return logFilePath;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {

        if(maxFileSize <1) throw new IllegalArgumentException();
        this.maxFileSize = maxFileSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileLoggerConfiguration)) return false;
        if (!super.equals(o)) return false;
        FileLoggerConfiguration that = (FileLoggerConfiguration) o;
        return maxFileSize == that.maxFileSize && Objects.equals(logFilePath, that.logFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), logFilePath, maxFileSize);
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
