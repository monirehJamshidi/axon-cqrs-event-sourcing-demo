package org.j2os.event;

import lombok.*;

@Getter
@AllArgsConstructor
public class SavePersonEvent {
    private String id;
    private String name;
}
