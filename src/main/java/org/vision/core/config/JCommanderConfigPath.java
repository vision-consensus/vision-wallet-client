package org.vision.core.config;

import com.beust.jcommander.Parameter;
import com.typesafe.config.Config;
import org.apache.commons.lang3.StringUtils;
import org.vision.core.config.Configuration;

public class JCommanderConfigPath {

    @Parameter(names = "-c", description = "dev path of config")
    public static String devPath ;

    @Parameter(names = "-local", description = "local path of config")
    public static String localPath;

    public static Config getConfigPath(){
        Config config;
        if (StringUtils.isNotBlank(JCommanderConfigPath.devPath)){
            config = Configuration.getByPath(JCommanderConfigPath.devPath);
        }else {
            config = Configuration.getByPath(JCommanderConfigPath.localPath);
        }
        return config;
    }
}
