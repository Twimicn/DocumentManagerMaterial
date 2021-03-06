package com.twimi.documentmanager.Dao;

import com.twimi.documentmanager.Model.Comment;
import com.twimi.documentmanager.Model.Proposal;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("Select * From pcomment Where pid=#{pid}")
    List<Comment> getCommentsByPid(@Param("pid")int pid);

    @Select("Select * From pcomment Where pid=#{pid} And uid=#{uid}")
    Comment getCommentByPidAndUid(@Param("pid")int pid,@Param("uid")int uid);

    @Insert("INSERT INTO pcomment(pid,uid,content,timeline) VALUES (#{pid},#{uid},#{content},#{timeline})")
    @Options(useGeneratedKeys = true, keyProperty = "cid")
    int insert(Comment proposal);
}
