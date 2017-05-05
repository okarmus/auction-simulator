package org.okarmus.recipient.web.common;


import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.rxjava.ext.web.RoutingContext;
import org.okarmus.recipient.domain.Item;



public class BodyExtractor implements Handler<RoutingContext> {

    private final Class<Item> bodyType;

    public BodyExtractor(Class<Item> bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public void handle(RoutingContext context) {
        Item item = Json.decodeValue(context.getBodyAsString(), bodyType);
        context.put(Item.class.getSimpleName(), item);

        context.next();
    }
}
