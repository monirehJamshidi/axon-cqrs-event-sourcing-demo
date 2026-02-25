package org.j2os.api;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.j2os.command.SavePersonCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonAPI {
    private final CommandGateway commandGateway;


    @GetMapping("/save")
    public Object save(){
        SavePersonCommand personCommand = SavePersonCommand.builder().id(UUID.randomUUID().toString()).name("Monireh").build();
        return commandGateway.sendAndWait(personCommand);

    }

}
