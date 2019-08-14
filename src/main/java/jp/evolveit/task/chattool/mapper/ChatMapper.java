package jp.evolveit.task.chattool.mapper;

import jp.evolveit.task.chattool.domain.Chat;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMapper {

    @Select("SELECT * FROM chat ORDER BY created_at DESC")
    List<Chat> findAll();

    @Insert("INSERT INTO chat (username, message) VALUES (#{username}, #{message})")
    int insert(@Param("username") String username, @Param("message") String message);
}
