package org.csystem.app.generator.text.server.receiver;

import com.karandev.util.net.UdpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PeriodicMessageReceiver {
    @Value("${server.config.receiver.port}")
    private int m_port;

    public void run()
    {
        System.out.printf("Periodic message receiver is waiting for a sender on port %d%n", m_port);

        while (true) {
            var str = UdpUtil.receiveString(m_port, 1024);

            System.out.printf("Message:%s%n", str);
        }
    }
}
