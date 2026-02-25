package org.j2os.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.j2os.command.SavePersonCommand;
import org.j2os.event.SavePersonEvent;

@Aggregate
@Slf4j
public class PersonAggregate {

    @AggregateIdentifier
    private String id;

    public PersonAggregate(){}

    @CommandHandler
    public PersonAggregate(SavePersonCommand command){
        log.info("    <save command handler>");
        log.info("        name: " + command.getName());
        log.info("        id: " + command.getId());
        command.setName("save command handle " + command.getName());
        AggregateLifecycle.apply(new SavePersonEvent(command.getId(), command.getName()));
    }

    @EventSourcingHandler
    private void on(SavePersonEvent event){
        log.info("        <save event sourcing handler>");
        log.info("            name: " + event.getName());
        log.info("            id: " + event.getId());
        this.id = event.getId();

    }
}
