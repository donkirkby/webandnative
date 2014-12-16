package com.github.donkirkby.webandnative.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Assets extends ClientBundle {
    public static final Assets INSTANCE = GWT.create(Assets.class);

    @Source("com/github/donkirkby/webandnative/assets/greetings.txt")
    TextResource greetings();
}
