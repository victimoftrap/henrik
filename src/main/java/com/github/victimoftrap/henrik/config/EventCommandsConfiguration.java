package com.github.victimoftrap.henrik.config;

import com.github.victimoftrap.henrik.commands.ICommand;
import com.github.victimoftrap.henrik.commands.TabCommand;
import com.github.victimoftrap.henrik.commands.MouseEnterCommand;
import com.github.victimoftrap.henrik.commands.MouseLeaveCommand;
import com.github.victimoftrap.henrik.commands.ProblemChangedCommand;
import com.github.victimoftrap.henrik.commands.ProblemSentCommand;
import com.github.victimoftrap.henrik.model.EventType;
import com.github.victimoftrap.henrik.repository.EventRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class EventCommandsConfiguration {
    @Bean
    @Qualifier("eventCommands")
    public Map<EventType, ICommand> eventCommands(
            @Qualifier("eventRepository") final EventRepository eventRepository
    ) {
        return Map.ofEntries(
                Map.entry(EventType.TAB_EVENT, new TabCommand(eventRepository)),
                Map.entry(EventType.MOUSE_ENTER_EVENT, new MouseEnterCommand(eventRepository)),
                Map.entry(EventType.MOUSE_LEAVE_EVENT, new MouseLeaveCommand(eventRepository)),
                Map.entry(EventType.PROBLEM_CHANGED_EVENT, new ProblemChangedCommand(eventRepository)),
                Map.entry(EventType.PROBLEM_SENT_EVENT, new ProblemSentCommand(eventRepository))
        );
    }
}
