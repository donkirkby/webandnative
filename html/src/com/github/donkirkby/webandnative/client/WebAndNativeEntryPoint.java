package com.github.donkirkby.webandnative.client;

import java.util.Arrays;

import com.github.donkirkby.webandnative.Greeter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebAndNativeEntryPoint implements EntryPoint {
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        String greetings = Assets.INSTANCE.greetings().getText();
        final Greeter greeter = new Greeter();
        greeter.loadGreetings(Arrays.asList(greetings.split("\\n")));
        
        final TextBox nameField = new TextBox();
        final Button greetButton = new Button("Greet");
        final Label greetingLabel = new Label();
        greetingLabel.setText(greeter.greet("World"));
        final Label errorLabel = new Label();

        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        RootPanel.get("nameContainer").add(nameField);
        RootPanel.get("greetingContainer").add(greetingLabel);
        RootPanel.get("greetButtonContainer").add(greetButton);
        RootPanel.get("errorLabelContainer").add(errorLabel);

        // Focus the cursor on the name field when the app loads
        greetButton.setFocus(true);

        // Create a handler for the sendButton and nameField
        class MyHandler implements ClickHandler {
            /**
             * Fired when the user clicks on the sendButton.
             */
            public void onClick(ClickEvent event) {
                greetingLabel.setText(greeter.greet(nameField.getText()));
            }
        }

        // Add a handler to send the name to the server
        MyHandler handler = new MyHandler();
        greetButton.addClickHandler(handler);
    }
}
