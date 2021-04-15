package com.github.victimoftrap.henrik.model;

public enum EventType {
    TAB_EVENT("TAB_EVENT"),
    MOUSE_ENTER_EVENT("MOUSE_ENTER_EVENT"),
    MOUSE_LEAVE_EVENT("MOUSE_LEAVE_EVENT"),
    PROBLEM_CHANGED_EVENT("PROBLEM_CHANGED_EVENT"),
    PROBLEM_SENT_EVENT("PROBLEM_SENT_EVENT"),
    SOLUTION_CODE_SENT_EVENT("SOLUTION_CODE_SENT_EVENT");

    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
