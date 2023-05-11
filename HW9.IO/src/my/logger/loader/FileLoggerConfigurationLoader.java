package my.logger.loader;

import my.logger.config.FileLoggerConfiguration;
import my.logger.utils.FileParser;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String file) {
        Path foundFile = Path.of(file);
        // since our file has a ':' separator of key/value pairs, we pass it as a second param
        String[] configData = FileParser.getDataFromFile(new File(foundFile.toUri()), ':');
        // our config array should have the same length as an amount of fields in the FileLoggerConfigurationLoader class
        if (configData.length + 1 == FileLoggerConfiguration.class.getDeclaredFields().length) {
            return new FileLoggerConfiguration(foundFile.toString(), configData);
        }
        return null;
    }
}
