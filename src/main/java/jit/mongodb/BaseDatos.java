package jit.mongodb;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import jit.Frames.Principal;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

public class BaseDatos {

    private MongoClient mongoClient;
    String dbName;
    private DB database;
    final static String SEPARADOR = File.separator;
    
    // local - servidor

      private static  String rutaJson = System.getProperty("user.dir") + SEPARADOR + "configuracion.json";
        //  private static  String rutaJson = System.getProperty("user.dir") + SEPARADOR + "configuracionLocal.json";

    public BaseDatos() {

        LinkedTreeMap map = leerdbConnection();

        this.mongoClient = new MongoClient(new MongoClientURI("mongodb://"
                + map.get("username") + ":" + map.get("password")
                + "@" + map.get("address") + ":" + map.get("port")
                + "/" + map.get("dbname") + "?retryWrites=false"));

 //       this.mongoClient = new MongoClient(new MongoClientURI("mongodb://" + map.get("address") + ":" + map.get("port")));

        this.dbName = map.get("dbname").toString();
        this.database = mongoClient.getDB(dbName);

    }

    //  this.database = mongoClient.getDB(dbName);
    public DB getBaseDatos() {
        return database;
    }

    //lee el json y devuelve los datos de conexion
    public static LinkedTreeMap leerdbConnection() {
        Gson gson = new Gson();
        LinkedTreeMap configuracion = null;
        File archivo = new File(rutaJson);
        if (archivo.exists()) {
            Map jsonJavaRootObject = gson.fromJson(leerString(archivo), Map.class);
            configuracion = (LinkedTreeMap) jsonJavaRootObject.get("dbConnection");
        }
        return configuracion;
    }

    //devulve  un String con el json
    public static String leerString(File archivo) {
        String entrada = "";
        try {
            FileInputStream stream = new FileInputStream(archivo);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            int caracter;
            while ((caracter = reader.read()) != -1) {
                entrada += (char) caracter;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se ha podido leer el fichero");
        }
        return entrada;
    }

    public static void updateSiguiendo(String miUser, String user) {

        //leemos follows de usuario
        ArrayList<String> follows = new ArrayList<String>();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection("usuario");
        Bson filter = Filters.eq("username", miUser);
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            if (!(object.get("follows") == null)) {
                follows = (ArrayList<String>) object.get("follows");
            }

        }
        cursor.close();

        follows.add(user);

        Bson filterUp = Filters.eq("username", miUser);
        DBObject queryUp = new BasicDBObject(filterUp.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        Bson updateAux = Updates.set("follows", follows);
        DBObject update = new BasicDBObject(updateAux.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        coleccion.update(queryUp, update);
        DBCursor cursor2 = coleccion.find(new BasicDBObject());
        while (cursor2.hasNext()) {
            DBObject documentoAux = cursor2.next();
            System.out.println(documentoAux.toString());
        }
        cursor2.close();

    }

    public static ArrayList selectDocumentos(String obj) {

        ArrayList lista = new ArrayList();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection(obj);
        DBCursor cursor = coleccion.find();

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            lista.add(object);
        }
        cursor.close();

        return lista;
    }

    public static boolean siguiendo(String miUser, String user) {
        boolean sigue = false;
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection("usuario");
        Bson filter = Filters.eq("username", miUser);
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            ArrayList<String> array = (ArrayList<String>) object.get("follows");

            if (!(array == null)) {
                for (int i = 0; i < array.size(); i++) {

                    if (array.get(i).equals(user)) {
                        sigue = true;
                    }
                }
            }
        }
        cursor.close();

        return sigue;
    }

    public static ArrayList selectDocumentos(String obj, String usuario) {

        ArrayList lista = new ArrayList();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection(obj);

        //     DBObject query = new BasicDBObject("username", "Manuel Varela");
        Bson filter = Filters.or(Filters.regex("username", usuario), Filters.regex("nome", usuario));
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            lista.add(object);
        }
        cursor.close();

        return lista;
    }

    public static ArrayList selectMensajes(String usuario) {

        ArrayList lista = new ArrayList();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection("mensaxe");
        Bson filter = Filters.eq("user.username", usuario);
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            lista.add(object);
        }
        cursor.close();

        return lista;
    }

    public static ArrayList selectDocumentosHastag(String obj, String hastag) {

        ArrayList lista = new ArrayList();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection(obj);

        //     DBObject query = new BasicDBObject("username", "Manuel Varela");
        Bson filter = Filters.in("hashtags", hastag);
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            lista.add(object);
        }
        cursor.close();

        return lista;
    }

    public static ArrayList selectFollows(String user) {

        ArrayList<String> array = new ArrayList<>();
        BaseDatos bd = new BaseDatos();
        DBCollection coleccion = bd.getBaseDatos().getCollection("usuario");
        Bson filter = Filters.eq("username", user);
        DBObject query = new BasicDBObject(filter.toBsonDocument(BsonDocument.class, MongoClient.getDefaultCodecRegistry()));
        DBCursor cursor = coleccion.find(query);

        while (cursor.hasNext()) {
            DBObject object = cursor.next();
            array = (ArrayList<String>) object.get("follows");
        }
        cursor.close();

        return array;

    }

    public static String mensaxeToString(DBObject obj) {

        String cadena = "<html><body><h4>Usuario: " + ((DBObject) obj.get("user")).get("username").toString() + "</h4><p>"
                + obj.get("text") + "</p>"
                + "<p><em>" + obj.get("date") + "</em></p></body></html>";

        return cadena;
    }

    public static String usuarioToString(DBObject obj) {

        String cadena = "<html><body><h4>" + obj.get("username") + "(" + obj.get("nome") + ")</h4></body></html>";

        return cadena;
    }
}


/*


usuario
{
    "nome":"Manuel Varela",
    "username":"manu",
    "password":"abc123.",
    "follows":["username1","username2","username3"]
}

mensaxe
{
    "text":"Este é un exemplo de miniTwitter #MiniTwitter #AccesoADatos",
    "user":{
        "nome": "Manuel Varela",
        "username": "manu"
    },
    "date":"2016-05-18T16:00:00Z",
    "hashtags":["MiniTwitter","AccesoADatos"]
}


{
    "address":"192.168.56.1",
    "port":"27017",
    "dbname":"minitwitter",
    "username":"accesoADatos",
    "password":"4cc3s04d4t0s"
}


 */
