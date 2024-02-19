package org.csystem.app.generator.text.server.runner;

import org.csystem.app.generator.text.server.ConfigServer;
import org.csystem.app.generator.text.server.GenerateServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

@Component
public class TextGeneratorServerRunner implements ApplicationRunner {
    private final ExecutorService m_threadPool;
    private final GenerateServer m_generateServer;
    private final ConfigServer m_configServer;

    private void generateServerThreadCallback()
    {
        try {
            m_generateServer.run();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void configServerThreadCallback()
    {
        try {
            m_configServer.run();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public TextGeneratorServerRunner(ExecutorService threadPool, GenerateServer generateServer, ConfigServer configServer)
    {
        m_threadPool = threadPool;
        m_generateServer = generateServer;
        m_configServer = configServer;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_threadPool.execute(this::generateServerThreadCallback);
        m_threadPool.execute(this::configServerThreadCallback);
    }
}
