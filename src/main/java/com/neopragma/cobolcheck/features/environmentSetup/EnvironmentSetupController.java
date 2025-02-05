package com.neopragma.cobolcheck.features.environmentSetup;

import com.neopragma.cobolcheck.services.Config;
import com.neopragma.cobolcheck.services.Messages;
import com.neopragma.cobolcheck.services.filehelpers.PathHelper;
import com.neopragma.cobolcheck.services.log.Log;

import java.io.Reader;
import java.io.Writer;

public class EnvironmentSetupController {
    EnvironmentSetup environmentSetup;

    public EnvironmentSetupController(){
        environmentSetup = new EnvironmentSetup();
    }

    public void runSetup(String configFileFromCommandLine, String logLevelFromCommandLine) {
        environmentSetup.loadConfigurationSettings(configFileFromCommandLine);

        Log.info(Messages.get("INF003"));        // We are starting

        environmentSetup.setLogLevel(logLevelFromCommandLine);

        Log.info(Messages.get("INF006",          // We are using config x
                Config.getString("config.loaded")));
    }


}
