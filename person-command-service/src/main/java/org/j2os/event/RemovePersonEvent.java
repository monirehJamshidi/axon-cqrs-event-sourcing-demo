package org.j2os.event;

import lombok.*;

@Getter
@AllArgsConstructor
public class RemovePersonEvent {
    private String id;
    private String name;
}
