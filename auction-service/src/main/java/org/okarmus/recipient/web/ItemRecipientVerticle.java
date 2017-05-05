package org.okarmus.recipient.web;


import com.google.inject.Inject;
import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.handler.BodyHandler;
import org.okarmus.recipient.web.resource.ItemResourceDefinitions;
import org.okarmus.recipient.web.resource.ResourceDefinition;

import java.util.Set;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

public class ItemRecipientVerticle extends AbstractVerticle {

    private final Vertx vertx;
    private final Router router;
    private final Set<ResourceDefinition> resourceDefinitions;

    @Inject
    public ItemRecipientVerticle(Vertx vertx, Router router, @ItemResourceDefinitions Set<ResourceDefinition> itemResourceDefinitions) {
        this.vertx = vertx;
        this.router = router;
        this.resourceDefinitions = itemResourceDefinitions;
    }

    @Override
    public void start(Future<Void> future) {
        createRouteDefinitions();
        createHttpServer();
    }

    private void createRouteDefinitions() {
        router.route().consumes(APPLICATION_JSON);
        router.route().produces(APPLICATION_JSON);
        router.route().handler(BodyHandler.create());

        resourceDefinitions.forEach(ResourceDefinition::configureResource);
    }

    private void createHttpServer() {
        vertx.createHttpServer()
                .requestHandler(router::accept)
                .rxListen(8080)
                .subscribe(server -> System.out.println("Server has been deployed successfully"), failure -> System.out.println(failure.getMessage()));
    }
}
