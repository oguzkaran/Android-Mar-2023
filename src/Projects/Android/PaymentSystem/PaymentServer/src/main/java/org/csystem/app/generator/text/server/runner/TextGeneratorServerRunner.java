package org.csystem.app.generator.text.server.runner;

import org.csystem.app.generator.text.server.Server;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

@Component
public class TextGeneratorServerRunner implements ApplicationRunner {
    private final ExecutorService m_threadPool;
    private final Server m_server;

    private void serverThreadCallback()
    {
        try {
            m_server.run();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public TextGeneratorServerRunner(ExecutorService threadPool, Server server)
    {
        m_threadPool = threadPool;
        m_server = server;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_threadPool.execute(this::serverThreadCallback);
    }
}
