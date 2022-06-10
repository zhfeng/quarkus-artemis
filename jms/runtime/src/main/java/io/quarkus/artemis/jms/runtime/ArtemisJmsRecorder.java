package io.quarkus.artemis.jms.runtime;

import java.util.function.Supplier;

import javax.jms.ConnectionFactory;
import javax.jms.XAConnectionFactory;

import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQXAConnectionFactory;

import io.quarkus.artemis.core.runtime.ArtemisRuntimeConfig;
import io.quarkus.runtime.annotations.Recorder;

@Recorder
public class ArtemisJmsRecorder {

    final ArtemisRuntimeConfig config;

    public ArtemisJmsRecorder(ArtemisRuntimeConfig config) {
        this.config = config;
    }

    public Supplier<ConnectionFactory> getConnectionFactorySupplier() {
        return new Supplier<ConnectionFactory>() {
            @Override
            public ConnectionFactory get() {
                return new ActiveMQJMSConnectionFactory(config.url, config.username.orElse(null),
                        config.password.orElse(null));
            }
        };
    }

    public Supplier<XAConnectionFactory> getXAConnectionFactorySupplier() {
        return new Supplier<XAConnectionFactory>() {
            @Override
            public XAConnectionFactory get() {
                return new ActiveMQXAConnectionFactory(config.url, config.username.orElse(null),
                        config.password.orElse(null));
            }
        };
    }
}
