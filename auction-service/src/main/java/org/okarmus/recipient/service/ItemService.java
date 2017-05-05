package org.okarmus.recipient.service;

import io.vertx.core.Handler;
import io.vertx.rxjava.ext.web.RoutingContext;
import org.okarmus.recipient.domain.Item;

import java.util.ArrayList;
import java.util.List;


public class ItemService implements Handler<RoutingContext> {

    private final List<Item> items;

    public ItemService() {
        this.items = new ArrayList<>();
    }

    @Override
    public void handle(RoutingContext context) {
        Item item = context.get(Item.class.getSimpleName());
        items.add(item);
        System.out.println(item);
        context.next();
    }
}
