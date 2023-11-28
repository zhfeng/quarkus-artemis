package io.quarkus.artemis.jms.ra.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;

public class ArtemisResourceAdapterProcessor {
    private static final String FEATURE = "artemis-jms-ra";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }
}
