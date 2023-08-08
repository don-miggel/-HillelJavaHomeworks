package logging.loader;


import logging.config.FileLoggerConfiguration;
import logging.config.LoggerConfiguration;
import logging.exceptions.FileConfigurationKeysMismatchException;
import logging.utils.FileParser;

import java.io.File;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Arrays;

import java.util.Set;


public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {

    private final static Set<String> REQUIRED_KEYS = Set.of("file", "level", "max-size", "format");

    public LoggerConfiguration load(String file) throws IllegalArgumentException, FileConfigurationKeysMismatchException{
        if(file == null || file.trim().length() == 0) throw new IllegalArgumentException();
        Path configFile = Path.of(file);
        if(!new File(configFile.toUri()).exists())
            throw new InvalidPathException(configFile.toString(), "wrong path");
        // since our file has a ':' separator of key/value pairs, we pass it as a second param
        String[] keys = FileParser.getKeys(new File(configFile.toUri()),':');

        if(!verifyKeys(keys, REQUIRED_KEYS))
            throw new FileConfigurationKeysMismatchException(REQUIRED_KEYS);
        String[] configData = FileParser.getDataFromFile(new File(configFile.toUri()), ':');

        // our config array should have the same length as an amount of fields in the FileLoggerConfigurationLoader class
        System.out.println(Arrays.toString(LoggerConfiguration.class.getDeclaredFields()));

        return new FileLoggerConfiguration(configFile.toString(), configData);

    }


}
