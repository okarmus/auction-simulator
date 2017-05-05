package org.okarmus.recipient.web.resource;

import com.google.inject.Inject;
import io.vertx.rxjava.ext.web.Router;
import org.okarmus.recipient.domain.Item;
import org.okarmus.recipient.service.ItemService;
import org.okarmus.recipient.web.common.BodyExtractor;
import org.okarmus.recipient.web.common.RequestFinalizer;

public class CreateItemResource implements ResourceDefinition {

    private static final String PATH = "/items";

    private final Router router;

    @Inject
    public CreateItemResource(Router router) {
        this.router = router;
    }

    @Override
    public void configureResource() {

        router.post(PATH)
                .handler(new BodyExtractor(Item.class));

        router.post(PATH)
                .handler(new ItemService());

        router.post(PATH)
                .handler(new RequestFinalizer());
    }
}
