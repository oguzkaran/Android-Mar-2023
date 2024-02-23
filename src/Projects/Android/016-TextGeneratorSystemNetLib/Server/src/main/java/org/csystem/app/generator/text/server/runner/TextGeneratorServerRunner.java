package org.csystem.app.generator.text.server.runner;

import org.csystem.app.generator.text.server.ConfigServer;
import org.csystem.app.generator.text.server.GeneratorServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TextGeneratorServerRunner implements ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger("TextGeneratorServerRunner");
    private final ExecutorService m_threadPool;
    private final GeneratorServer m_generatorServer;
    private final ConfigServer m_configServer;

    private void generateServerThreadCallback()
    {
        try {
            m_generatorServer.run();
        }
        catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    private void configServerThreadCallback()
    {
        try {
            m_configServer.run();
        }
        catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    public TextGeneratorServerRunner(ExecutorService threadPool, GeneratorServer generatorServer, ConfigServer configServer)
    {
        m_threadPool = threadPool;
        m_generatorServer = generatorServer;
        m_configServer = configServer;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_threadPool.execute(this::generateServerThreadCallback);
        m_threadPool.execute(this::configServerThreadCallback);
    }
}
