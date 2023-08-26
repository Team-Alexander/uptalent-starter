package io.github.uptalent.starter.model.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Comment {
    private TextItem comment;
    private String[] languages;
    private Map<String, Map<String, String>> requestedAttributes;
}
