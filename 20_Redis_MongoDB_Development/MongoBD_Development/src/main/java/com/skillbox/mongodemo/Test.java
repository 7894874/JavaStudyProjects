package com.skillbox.mongodemo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {
      //  MongoClient mongoClient = new MongoClient( "192.168.2.77" , 27017 );
        //MongoClient mongoClient  = new MongoClient("mongodb://admin:superx@192.168.2.77:27017/");

      //  MongoCredential credential = MongoCredential.createCredential("Admin", "admin", "superx".toCharArray());
      //  MongoClient mongoClient = (new ServerAddress("192.168.2.77", 27017), Arrays.asList(credential));


//        // Mongodb initialization parameters.
//        int port_no = 27017;
//        String auth_user="admin", auth_pwd = "superx", host_name = "192.168.2.77", db_name = "admin", db_col_name = "emp", encoded_pwd = "";
//
//        /* Imp. Note -
//         *      1.  Developers will need to encode the 'auth_user' or the 'auth_pwd' string if it contains the <code>:</code> or the <code>@</code> symbol. If not, the code will throw the <code>java.lang.IllegalArgumentException</code>.
//         *      2.  If the 'auth_user' or the 'auth_pwd' string does not contain the <code>:</code> or the <code>@</code> symbol, we can skip the encoding step.
//         */
//        try {
//            encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//            System.out.println("error(ex)");
//        }
//
//        // Mongodb connection string.
//        String client_url = "mongodb://" + auth_user + ":" + encoded_pwd + "@" + host_name + ":" + port_no + "/" + db_name;
//        MongoClientURI uri = new MongoClientURI(client_url);
//
//        // Connecting to the mongodb server using the given client uri.
//        MongoClient mongoClient = new MongoClient(uri);


      //  MongoClient mongoClient = new MongoClient("mongodb://Admin:superx@192.168.2.77/?authSource=admin");


        try {
            // provide IP/hostname or port to connect mongoDB server
            // MongoClient mongoClient = new MongoClient( "192.168.2.77", 27017 );

          //  MongoClient mongoClient = new MongoClient("mongodb://admin:superx@192.168.2.77/?authSource=Admin");

//            MongoCredential credential = MongoCredential.createScramSha1Credential("myblogUser", "myblogdb", "secret".toCharArray());
//            MongoClient mongoClient = new MongoClient(new ServerAddress("10.0.8.20"), Arrays.asList(credential));

            MongoCredential credential = MongoCredential.createScramSha1Credential("adminUser", "admin", "superx".toCharArray());
            MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.2.77"), Arrays.asList(credential));





            ListDatabasesIterable<Document> dbList = mongoClient.listDatabases();
            for(Document dbName : dbList) {
                System.out.println("dbName: " + dbName);
            }

        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("TestSkillDemo");

        // Удалим из нее все документы
        collection.drop();

        // Создадим первый документ
        Document firstDocument = new Document()
                .append("Type", 1)
                .append("Description", "Это наш первый документ в MongoDB")
                .append("Author", "Я")
                .append("Time", new SimpleDateFormat().format(new Date()));


        // Вложенный объект
        Document nestedObject = new Document()
                .append("Course", "NoSQL Базы Данных")
                .append("Author", "Mike Ovchinnikov");

        firstDocument.append("Skillbox", nestedObject);


        // Вставляем документ в коллекцию
        collection.insertOne(firstDocument);

        collection.find().forEach((Consumer<Document>) document -> {
            System.out.println("Наш первый документ:\n" + document);
        });

        // Используем JSON-синтаксис для создания объекта
        Document secondDocument = Document.parse(
                "{Type: 2, Description:\"Мы создали и нашли этот документ с помощью JSON-синтаксиса\"}"
        );
        collection.insertOne(secondDocument);

        // Используем JSON-синтаксис для написания запроса (выбираем документы с Type=2)
        BsonDocument query = BsonDocument.parse("{Type: {$eq: 2}}");
        collection.find(query).forEach((Consumer<Document>) document -> {
            System.out.println("Наш второй документ:\n" + document);
        });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
