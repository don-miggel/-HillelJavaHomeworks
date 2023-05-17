package my.logger.loader;

import my.logger.config.LoggerConfiguration;
import my.logger.config.StdoutLoggerConfiguration;
import my.logger.utils.FileParser;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class StdoutLoggerConfigurationLoader implements LoggerConfigurationLoader{
    @Override
    public LoggerConfiguration load(String file) {
        Path configFile = Path.of(file);
        // since our file has a ':' separator of key/value pairs, we pass it as a second param
        //third param
        String[] configData = FileParser.getDataFromFile(new File(configFile.toUri()), ':', "LEVEL",
                "FORMAT");

        return new StdoutLoggerConfiguration(configData, configFile.toString());
    }


}
