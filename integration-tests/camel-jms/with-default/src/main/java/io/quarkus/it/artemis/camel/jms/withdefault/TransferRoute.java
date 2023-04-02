package io.quarkus.it.artemis.camel.jms.withdefault;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.jms;

import org.apache.camel.builder.RouteConfigurationBuilder;

@SuppressWarnings("unused")
public class TransferRoute extends RouteConfigurationBuilder {
    @Override
    public void configuration() {
        from(jms("queue:in"))
                .to(jms("queue:out"));
    }
}
