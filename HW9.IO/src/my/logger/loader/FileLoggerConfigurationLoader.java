package my.logger.loader;

import my.logger.config.FileLoggerConfiguration;
import my.logger.config.LoggerConfiguration;
import my.logger.utils.FileParser;

import java.io.File;
import java.nio.file.Path;

public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader{

    public LoggerConfiguration load(String file) {
        Path configFile = Path.of(file);
        // since our file has a ':' separator of key/value pairs, we pass it as a second param
        String[] configData = FileParser.getDataFromFile(new File(configFile.toUri()), ':');
        // our config array should have the same length as an amount of fields in the FileLoggerConfigurationLoader class

        return new FileLoggerConfiguration(configFile.toString(), configData);

    }
}
