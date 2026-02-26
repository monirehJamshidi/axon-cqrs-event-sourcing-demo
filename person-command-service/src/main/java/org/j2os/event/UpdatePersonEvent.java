package org.j2os.event;

import lombok.*;

@Getter
@AllArgsConstructor
public class UpdatePersonEvent {

    private String id;
    private String name;
}
