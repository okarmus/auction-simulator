package org.okarmus;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.ext.web.Router;
import org.okarmus.recipient.RecipientModule;

public class ApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
            install(new RecipientModule());
    }

    @Provides
    @Singleton
    Vertx vertx() {
        return Vertx.vertx();
    }

    @Provides
    @Singleton
    Router router(Vertx vertx) {
        return Router.router(vertx);
    }
}
