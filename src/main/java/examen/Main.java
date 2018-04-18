package examen;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by jordi on 18/04/2018.
 */
public class Main {
    public static final String BASE_URI = "http://localhost:8080/myapp/";
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages("examen");
        rc.register(JacksonFeature.class);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler,"/");
        ServeiREST serv = new ServeiREST();
    }
}
