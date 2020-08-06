package gt.app.config;

import dasniko.testcontainers.keycloak.KeycloakContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

@Profile("withTestContainer")
@Configuration
@Slf4j
public class DockerContainerConfig {

    /*

    Started by Docker TestContainer in withTestContainer profile
    - ElasticSearch
    - ActiveMQ Artemis
    - Keycloak

    Embedded Apps - started in dev profile
    - H2

     */


    static {
        var es = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:7.8.0");
        es.start();

        var activeMQ = new GenericContainer("vromero/activemq-artemis");
        activeMQ.start(); //using default ports

        var kc = new KeycloakContainer("quay.io/keycloak/keycloak:11.0.0").withRealmImportFile("keycloak/keycloak-export.json");
        kc.start();

        System.setProperty("ELASTICSEARCH_HOSTADDR", es.getHttpHostAddress());
        System.setProperty("KEYCLOAK_PORT", Integer.toString(kc.getHttpPort()));
    }

}
