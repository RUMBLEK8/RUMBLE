package com.example.wsp_spring.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
//追加 10/29
import java.util.List;
import static org.springframework.jdbc.core.BeanPropertyRowMapper.newInstance;

@Repository
public class RetrospectRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public int insert(Retrospect retrospect){
        var sql = "insert into retrospect values(?,?)";
        //note:spring jdbc を使いJDBCプログラムを容易にしている
        var n = jdbc.update(sql,retrospect.getText(),retrospect.getPostedAt());
        return n;
    }

    public List<Retrospect>select(){
        var sql = "select text,posted_at from retrospect order by posted_at desc";

        return jdbc.query(sql,newInstance(Retrospect.class));
    }
}
