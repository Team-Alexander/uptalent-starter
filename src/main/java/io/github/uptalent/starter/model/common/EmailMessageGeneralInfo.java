package io.github.uptalent.starter.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class EmailMessageGeneralInfo {
    private String username;
    private String email;
}
