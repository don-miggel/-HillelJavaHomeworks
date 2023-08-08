package logging.loader;

import logging.config.*;
import logging.exceptions.FileConfigurationKeysMismatchException;
import logging.utils.FileParser;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Set;


public class StdoutLoggerConfigurationLoader implements LoggerConfigurationLoader {

    private final static Set<String> REQUIRED_KEYS = Set.of("level", "format");

    @Override
    public LoggerConfiguration load(String file) {
        if(file == null || file.trim().length() == 0) throw new IllegalArgumentException();
        Path configFile = Path.of(file);

        if(!new File(configFile.toUri()).exists())
            throw new InvalidPathException(configFile.toString(), "wrong path");

        String[] keys = FileParser.getKeys(new File(configFile.toUri()),':');
        if(!verifyKeys(keys, REQUIRED_KEYS))
            throw new FileConfigurationKeysMismatchException(REQUIRED_KEYS);

        // since our file has a ':' separator of key/value pairs, we pass it as a second param
        //third param
        String[] configData = FileParser.getDataFromFile(new File(configFile.toUri()), ':', "LEVEL",
                "FORMAT");

        return new StdoutLoggerConfiguration(configData, configFile.toString());
    }


}
