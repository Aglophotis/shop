package ru.mirea.data.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.data.SQLHelper;

@Service
public class StuffService {

    @Autowired
    private SQLHelper sqlHelper;

    public ObjectNode getStuffs(){
        return sqlHelper.selectAllFromItems("Stuff");
    }

    public ObjectNode getStuff(int id){
        return sqlHelper.selectConcreteFromItemsById("Stuff", id);
    }


    public void openConnectionToDB(){
        if (!sqlHelper.connectionIsRun())
            sqlHelper.run();
    }

    public void closeConnectionToDB(){
        if (sqlHelper.connectionIsRun())
            sqlHelper.stop();
    }
}