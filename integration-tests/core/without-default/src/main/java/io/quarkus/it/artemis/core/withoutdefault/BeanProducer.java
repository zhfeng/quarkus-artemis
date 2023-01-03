package io.quarkus.it.artemis.core.withoutdefault;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.activemq.artemis.api.core.client.*;

import io.quarkus.it.artemis.core.common.ArtemisCoreConsumerManager;
import io.quarkus.it.artemis.core.common.ArtemisCoreProducerManager;
import io.smallrye.common.annotation.Identifier;

public class BeanProducer {
    @Produces
    @ApplicationScoped
    @Identifier("named-1")
    ArtemisCoreConsumerManager namedOneConsumer(
            @SuppressWarnings("CdiInjectionPointsInspection") @Identifier("named-1") ServerLocator namedOneServerLocator)
            throws Exception {
        return new ArtemisCoreConsumerManager(namedOneServerLocator, "test-core-named-1");
    }

    @Produces
    @ApplicationScoped
    @Identifier("named-1")
    public static ArtemisCoreProducerManager namedOneProducer(
            @SuppressWarnings("CdiInjectionPointsInspection") @Identifier("named-1") ServerLocator namedOneServerLocator)
            throws Exception {
        return new ArtemisCoreProducerManager(namedOneServerLocator, "test-core-named-1");
    }

    BeanProducer() {
    }
}