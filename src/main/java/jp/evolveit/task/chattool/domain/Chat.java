package jp.evolveit.task.chattool.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Chat {
    private Long id;

    private String username;

    private String message;

    private LocalDateTime createdAt;
}
