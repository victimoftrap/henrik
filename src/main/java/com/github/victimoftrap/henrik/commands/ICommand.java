package com.github.victimoftrap.henrik.commands;

import com.github.victimoftrap.henrik.dto.EventDtoRequest;

public interface ICommand {
    void execute(EventDtoRequest request);
}
