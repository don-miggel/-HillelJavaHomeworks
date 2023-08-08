package logging.config;

public class StdoutLoggerConfiguration extends LoggerConfiguration {

    public StdoutLoggerConfiguration(String loggingLevel,String loggingFormat, String fileConfigPath) {
        super(loggingLevel, loggingFormat, fileConfigPath);
    }

    public StdoutLoggerConfiguration(String[] values, String fileConfigPath){
        this(values[0], values[1], fileConfigPath);
    }



    @Override
    public String toString() {
        return "StdoutLoggerConfiguration{" +
                "loggingFormat='" + loggingFormat + '\'' +
                ", loggingLevel=" + loggingLevel +
                ", fileConfigPath='" + fileConfigPath + '\'' +
                '}';
    }
}
