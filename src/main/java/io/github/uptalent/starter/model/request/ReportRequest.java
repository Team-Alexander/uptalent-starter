package io.github.uptalent.starter.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    @NotBlank
    @Size(max = 1000, message = "Message must be less than 1000 characters")
    private String message;
}
