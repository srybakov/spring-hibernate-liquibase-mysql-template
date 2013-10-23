package com.nnprivate.project.model.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.nnprivate.project.model.mongo.dao.impl.TestDao;
import com.nnprivate.project.model.mongo.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Repository
public class TestDaoImpl implements TestDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    public void test(){
        Test test = new Test("Sergey", "Rybakov");
        mongoTemplate.save(test);
        DBCollection collection = mongoTemplate.getCollection("test");
        BasicDBObject query = new BasicDBObject("username", "Sergey");
        DBCursor cursor = collection.find(query);
        cursor.close();
    }
}
