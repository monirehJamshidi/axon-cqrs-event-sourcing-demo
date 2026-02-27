package org.j2os.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.j2os.command.RemovePersonCommand;
import org.j2os.command.SavePersonCommand;
import org.j2os.command.UpdatePersonCommand;
import org.j2os.event.RemovePersonEvent;
import org.j2os.event.SavePersonEvent;
import org.j2os.event.UpdatePersonEvent;

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
//        command.setName("save command handle " + command.getName());
        AggregateLifecycle.apply(new SavePersonEvent(command.getId(), command.getName()));
    }

    @CommandHandler
    public void handle(UpdatePersonCommand command){
        log.info("    <update command handler>");
        log.info("        name: " + command.getName());
        log.info("        id: " + command.getId());
//        command.setName("update command handle " + command.getName());
        AggregateLifecycle.apply(new UpdatePersonEvent(command.getId(), command.getName()));
    }

    @CommandHandler
    public void handle(RemovePersonCommand command){
        log.info("    <remove command handler>");
        log.info("        name: " + command.getName());
        log.info("        id: " + command.getId());
//        command.setName("remove command handle " + command.getName());
        AggregateLifecycle.apply(new RemovePersonEvent(command.getId(), command.getName()));
    }

    @EventSourcingHandler
    private void on(SavePersonEvent event){
        log.info("        <save event sourcing handler>");
        log.info("            name: " + event.getName());
        log.info("            id: " + event.getId());
        this.id = event.getId();

    }

    @EventSourcingHandler
    private void on(UpdatePersonEvent event){
        log.info("        <update event sourcing handler>");
        log.info("            name: " + event.getName());
        log.info("            id: " + event.getId());
        this.id = event.getId();
    }

    @EventSourcingHandler
    private void  on(RemovePersonEvent event){
        log.info("        <remove event sourcing handler>");
        log.info("            name: " + event.getName());
        log.info("            id: " + event.getId());
        this.id = event.getId();
        AggregateLifecycle.markDeleted();

    }
}
