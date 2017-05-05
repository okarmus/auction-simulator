package org.okarmus.recipient.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Item {
    String name;
    int expectedPrice;
    boolean sold;

}
