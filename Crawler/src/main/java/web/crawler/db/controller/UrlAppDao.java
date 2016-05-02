package web.crawler.db.controller;

import web.crawler.db.dao.DocDao;
import web.crawler.db.model.Doc;

public class UrlAppDao {
	
	public static void main(String[] args) {
		DocDao docDao = new DocDao();
		
		Doc doc = docDao.getDocByUrl("https://www.yahoo.com/parenting/");
		
		// test data from Db
		System.out.println("Metadate found for: " + doc.getUrl());
		System.out.println(doc.getMetadata());
		
		//get the Url object from DB using url String 
//		System.out.println(url);
		
//		List<Url> urls = urlDao.getUrlListByTitle("google");
//		System.out.println("list found: ");
//		System.out.println(urls);
		
		//save in DB
//		Url newUrl = new Url("www.yahoo.com", new Date(), 
//				"123456789", "c:/datat/123456789.txt", "yahoo metaData", 
//				"Yahoo header", "yahoo", null , "www.google.com", "Yahoo Content");
//		urlDao.saveUrl(newUrl);
		
//		List<Url> urls2 = urlDao.getAllUrls();
//		System.out.println("list found: ");
//		System.out.println(urls2);
		
//		urlDao.dropCollection();
//		System.out.println("Collection Url droped...");
		
		
	

	}

}