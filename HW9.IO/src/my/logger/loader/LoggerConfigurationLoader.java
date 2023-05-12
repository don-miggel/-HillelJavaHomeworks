package my.logger.loader;

import my.logger.config.LoggerConfiguration;

public interface LoggerConfigurationLoader {

    LoggerConfiguration load(String file);
}
