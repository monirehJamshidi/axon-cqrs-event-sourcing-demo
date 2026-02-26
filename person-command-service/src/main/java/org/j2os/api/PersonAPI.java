package org.j2os.api;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.j2os.command.RemovePersonCommand;
import org.j2os.command.SavePersonCommand;
import org.j2os.command.UpdatePersonCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonAPI {
    private final CommandGateway commandGateway;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleMyException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage() + "!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @GetMapping("/save")
    public Object save(){
        SavePersonCommand personCommand = SavePersonCommand.builder().id(UUID.randomUUID().toString()).name("Monireh").build();
        return commandGateway.sendAndWait(personCommand);

    }

    @GetMapping("/update/{id}/{name}")
    public String update(@PathVariable("id") String id, @PathVariable("name") String name){
        UpdatePersonCommand personCommand = UpdatePersonCommand.builder().id(id).name(name).build();
        return commandGateway.sendAndWait(personCommand);
    }

    @GetMapping("/remove/{id}/{name}")
    public String remove(@PathVariable("id") String id, @PathVariable("name") String name){
        RemovePersonCommand personCommand = RemovePersonCommand.builder().id(id).name(name).build();
        return commandGateway.sendAndWait(personCommand);
    }

}
