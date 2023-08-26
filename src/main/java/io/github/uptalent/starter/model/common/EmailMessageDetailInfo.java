package io.github.uptalent.starter.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessageDetailInfo {
    private String uuid;
    private String username;
    private String email;
    private LocalDateTime expiredDateTime;
}
