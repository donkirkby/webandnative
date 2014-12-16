package com.github.donkirkby.webandnative;

import java.util.ArrayList;
import java.util.List;

public class Greeter {
    private List<String> greetings = new ArrayList<String>();
    private int greetingIndex;
    
    public void loadGreetings(List<String> greetings) {
        this.greetings.addAll(greetings);
    }
    
    public String greet(String name) {
        String template = greetings.get(greetingIndex);
        greetingIndex = (greetingIndex + 1) % greetings.size();
        return template.replace("*", name);
    }
}
