package br.com.aevc.pocswing.model.dao.entity;

import br.com.aevc.pocswing.model.dao.connection.ConnectionManager;
import br.com.aevc.pocswing.model.dao.connection.ConnectionManagerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import static br.com.aevc.pocswing.util.ApplicationPropertiesUtil.getProperty;
import static br.com.aevc.pocswing.util.ResourcesUtil.listResourcesFrom;
import static java.nio.file.Files.readString;

public class EntityGenerator {

    private static final EntityGenerator ENTITY_GENERATOR = new EntityGenerator();

    private final ConnectionManager connectionManager = ConnectionManagerFactory.createDefault();

    private EntityGenerator() {
    }

    public static EntityGenerator getInstance() {
        return ENTITY_GENERATOR;
    }

    public void generate() {
        if (Boolean.parseBoolean(getProperty("poc-swing.h2.database.generate-ddl", "false"))) {
            try (Statement statement = this.connectionManager.getConnection().createStatement()) {
                Iterator<URL> urlIterator = listResourcesFrom("resources/sql/");
                while (urlIterator.hasNext()) {
                    Files.list(
                            Path.of(
                                    urlIterator.next()
                                            .toURI()
                            )
                    ).forEach(path ->
                            {
                                try {
                                    String ddl = readString(path);
                                    System.out.printf(
                                            "##### Executing DDL FROM [%s] #####%n",
                                            path
                                    );
                                    System.out.println(ddl);
                                    int i = statement.executeUpdate(ddl);
                                    System.out.printf(
                                            "##### FINISHED DDL FROM %s WITH RESULT [%s] #####%n",
                                            path,
                                            i
                                    );
                                } catch (IOException | SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Ignoring ddl generation.");
        }
    }

}
