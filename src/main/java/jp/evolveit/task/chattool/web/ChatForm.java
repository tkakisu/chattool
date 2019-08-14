package jp.evolveit.task.chattool.web;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ChatForm {

    @NotEmpty
    private String username;

    @NotEmpty
    private String message;
}
