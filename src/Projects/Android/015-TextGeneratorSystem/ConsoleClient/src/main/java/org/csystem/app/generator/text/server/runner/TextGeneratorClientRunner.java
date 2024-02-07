package org.csystem.app.generator.text.server.runner;

import org.csystem.app.generator.text.server.Client;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

@Component
public class TextGeneratorClientRunner implements ApplicationRunner {
    private final ExecutorService m_threadPool;
    private final Client m_client;

    private void serverThreadCallback()
    {
        try {
            m_client.run();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public TextGeneratorClientRunner(ExecutorService threadPool, Client client)
    {
        m_threadPool = threadPool;
        m_client = client;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_threadPool.execute(this::serverThreadCallback);
    }
}
