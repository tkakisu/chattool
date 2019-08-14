package jp.evolveit.task.chattool.service;

import jp.evolveit.task.chattool.domain.Chat;
import jp.evolveit.task.chattool.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatService {
    @Autowired
    ChatMapper chatMapper;

    public List<Chat> findAll() {
        return chatMapper.findAll();
    }

    public int addMessage(String username, String message) {
        return chatMapper.insert(username, message);
    }
}
