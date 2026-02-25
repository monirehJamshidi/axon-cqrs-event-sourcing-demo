package org.j2os.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.j2os.event.SavePersonEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Slf4j
public class PersonService {

    private List<SavePersonEvent> savePersonEvents = new ArrayList<SavePersonEvent>();

    @EventHandler
    public void save(SavePersonEvent event){
        log.info("            <save service layer>");
        log.info("                name: " + event.getName());
        log.info("                id: " + event.getId());
        savePersonEvents.add(event);
    }


}
