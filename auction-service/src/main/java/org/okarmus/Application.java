package org.okarmus;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.rxjava.core.RxHelper;
import io.vertx.rxjava.core.Vertx;
import org.okarmus.recipient.web.ItemRecipientVerticle;

public class Application {

    public static void main(String args[]) {
        Injector injector = Guice.createInjector(new ApplicationModule());

        RxHelper.deployVerticle(
                injector.getInstance(Vertx.class),
                injector.getInstance(ItemRecipientVerticle.class)
        );
    }
}
