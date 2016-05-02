package web.crawler.db.dao;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import web.crawler.constant.DBTable;
import web.crawler.db.bean.IndexConfig;
import web.crawler.db.model.Index;

public class IndexDao {
	
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(IndexConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	
	public List<Index> getIndexBySimilarTerm(String term){
		Query findQuery = new Query();
		findQuery.addCriteria(Criteria.where("term").regex(term+".*"));
		List<Index> indexes = mongoOperation.find(findQuery, Index.class, DBTable.INDEX);
		
		return indexes;
	}
	
	public Index getIndexByTerm(String term){
		Query findQuery = new Query();
		findQuery.addCriteria(Criteria.where("term").is(term.toLowerCase()));
		Index dbIndex = mongoOperation.findOne(findQuery, Index.class, DBTable.INDEX);
		
		return dbIndex;
	}
	
	public List<Index> getAllIndexes(){
		List<Index> indexes = mongoOperation.findAll(Index.class, DBTable.INDEX);
		
		return indexes;
	}
	
	public void dropCollection(){
		mongoOperation.dropCollection(DBTable.INDEX);
		
	}
	
	public void saveIndex(List<Index> index)
	{
		mongoOperation.insertAll(index);
		
	}
}
