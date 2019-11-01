package com.example.wsp_spring.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import static java.util.Collections.emptyList;

@Service
public class RetrospectService {

    public int register(String text,String textPass){
        var retrospect = new Retrospect(text,textPass);
        try{
            return repository.insert(retrospect);
        }catch(DataAccessException e){
            e.printStackTrace();
        }

        return 0;
    }
    @Autowired
    private RetrospectRepository repository;

    public List<Retrospect>findAll(){
        try{

            return repository.select();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return emptyList();
    }
    public String modelText(String text,String textPass){
        var n = register(text,textPass);
        var message = n > 0 ? n+"件を追加":"追加失敗"; //note:三項

       return message;

    }
}
