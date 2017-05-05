package org.okarmus.recipient.web.common;

import io.vertx.core.Handler;
import io.vertx.rxjava.ext.web.RoutingContext;

public class RequestFinalizer implements Handler<RoutingContext> {
    @Override
    public void handle(RoutingContext context) {
        context.response().end();
    }
}
