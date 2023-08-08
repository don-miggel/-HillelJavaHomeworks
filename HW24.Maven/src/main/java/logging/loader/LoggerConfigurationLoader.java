package logging.loader;

import logging.config.LoggerConfiguration;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public interface LoggerConfigurationLoader {


    LoggerConfiguration load(String file) throws FileNotFoundException;

    default boolean verifyKeys(String[] checkedKeys, Set<String> requiredKeys){

        Set<String> reqKeys = new HashSet<>(requiredKeys);
        Set<String> givenKeys = Arrays.stream(checkedKeys)
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        reqKeys.removeAll(givenKeys);
        givenKeys.removeAll(requiredKeys);
        return reqKeys.size() ==  givenKeys.size();
    }
}
