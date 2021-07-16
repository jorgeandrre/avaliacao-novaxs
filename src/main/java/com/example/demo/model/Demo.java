package com.example.demo.model;

import java.util.List;

public class Demo {
    private final String num;
    private final String name;
    private final List<String> type;
    private final List<PreEvolution> pre_evolution;
    private final List<PreEvolution> next_evolution;

    public Demo(String num, String name, List<String> type, List<PreEvolution> pre_evolution, List<PreEvolution> next_evolution) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.pre_evolution = pre_evolution;
        this.next_evolution = next_evolution;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public List<String> getType() {
        return type;
    }

    public List<PreEvolution> getPre_evolution() {
        return pre_evolution;
    }

    public List<PreEvolution> getNext_evolution() {
        return next_evolution;
    }
}