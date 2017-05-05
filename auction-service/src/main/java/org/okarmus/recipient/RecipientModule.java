package org.okarmus.recipient;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.okarmus.recipient.web.resource.CreateItemResource;
import org.okarmus.recipient.web.resource.ItemResourceDefinitions;
import org.okarmus.recipient.web.resource.ResourceDefinition;

public class RecipientModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<ResourceDefinition> itemResourceBinder = Multibinder.newSetBinder(binder(), ResourceDefinition.class, ItemResourceDefinitions.class);
        itemResourceBinder.addBinding().to(CreateItemResource.class);
    }
}
