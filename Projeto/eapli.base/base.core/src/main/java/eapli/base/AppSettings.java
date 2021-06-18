package eapli.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the application settings.
 *
 * @author Paulo Gandra Sousa
 */
public class AppSettings {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppSettings.class);

    private static final String PROPERTIES_RESOURCE = "application.properties";
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String UI_MENU_LAYOUT_KEY = "ui.menu.layout";
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String SCHEMA_GENERATION_KEY = "javax.persistence.schema-generation.database.action";
    private static final String HIGH_CALORIES_DISH_LIMIT = "HighCaloriesDishLimit";
    private static final String DATABASE_IP = "DATABASE_IP";
    private static final String IMAGE_SERVER_IP = "IMAGE_SERVER_IP";
    private static final String WORKFLOW_SERVER = "WORKFLOW_SERVER";
    private static final String EXECUTOR_SERVER = "EXECUTOR_SERVER";
    private static final String SSH_PASSWORD = "SSH_PASSWORD";
    private static final String SSH_USER = "SSH_USER";
    private static final String PORT_WORKFLOW = "PORT_WORKFLOW";
    private static final String PORT_AUTOMATICTASK_EXECUTOR = "PORT_AUTOMATICTASK_EXECUTOR";
    private static final String IP_WORKFLOW = "WORKFLOW_SERVER";
    private static final String IP_AUTOMATICTASK_EXECUTOR = "IP_AUTOMATICTASK_EXECUTOR";
    private static final String COLLABORATOR_ASSIGNER_ALGORITHM = "COLLABORATOR_ASSIGNER_ALGORITHM";
    private static final String GRAMMARFORMTYPE = "GRAMMARFORMTYPE";
    private static final String GRAMMARAUTOMATICTYPE = "GRAMMARAUTOMATICTYPE";

    private final Properties applicationProperties = new Properties();

    public AppSettings() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream propertiesStream = this.getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_RESOURCE)) {
            if (propertiesStream != null) {
                this.applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (final IOException exio) {
            setDefaultProperties();

            LOGGER.warn("Loading default properties", exio);
        }
    }

    private void setDefaultProperties() {
        this.applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
                "eapli.base.persistence.jpa.JpaRepositoryFactory");
        this.applicationProperties.setProperty(UI_MENU_LAYOUT_KEY, "horizontal");
        this.applicationProperties.setProperty(PERSISTENCE_UNIT_KEY, "eapli"+ ".base");
        this.applicationProperties.setProperty(HIGH_CALORIES_DISH_LIMIT, "300");
        this.applicationProperties.setProperty(DATABASE_IP, "localhost");
        this.applicationProperties.setProperty(IMAGE_SERVER_IP, "localhost");
        this.applicationProperties.setProperty(WORKFLOW_SERVER, "localhost");
        this.applicationProperties.setProperty(EXECUTOR_SERVER, "localhost");
        this.applicationProperties.setProperty(SSH_USER, "user");
        this.applicationProperties.setProperty(SSH_PASSWORD, "password");
        this.applicationProperties.setProperty(PORT_WORKFLOW, "10283");
        this.applicationProperties.setProperty(IP_WORKFLOW, "172.17.0.2");
        this.applicationProperties.setProperty(PORT_AUTOMATICTASK_EXECUTOR, "10030");
        this.applicationProperties.setProperty(IP_AUTOMATICTASK_EXECUTOR, "172.17.0.3");
        this.applicationProperties.setProperty( COLLABORATOR_ASSIGNER_ALGORITHM, "FCFS" );
        this.applicationProperties.setProperty( GRAMMARFORMTYPE, "VISITOR" );
        this.applicationProperties.setProperty( GRAMMARAUTOMATICTYPE, "VISITOR" );
    }

    public Boolean isMenuLayoutHorizontal() {
        return "horizontal"
                .equalsIgnoreCase(this.applicationProperties.getProperty(UI_MENU_LAYOUT_KEY));
    }

    public String getPersistenceUnitName() {
        return this.applicationProperties.getProperty(PERSISTENCE_UNIT_KEY);
    }

    public  String getGRAMMARFORMTYPE() {
        return this.applicationProperties.getProperty(GRAMMARFORMTYPE);
    }

    public String getRepositoryFactory() {
        return this.applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }
    public String getDatabaseIp() {
        return this.applicationProperties.getProperty(DATABASE_IP);
    }
    public String getWorkflowServer() {
        return this.applicationProperties.getProperty(WORKFLOW_SERVER);
    }
    public String getExecutorServer() {
        return this.applicationProperties.getProperty(EXECUTOR_SERVER);
    }
    public String getSshUser() {
        return this.applicationProperties.getProperty(SSH_USER);
    }
    public String getSshPassword() {
        return this.applicationProperties.getProperty(SSH_PASSWORD);
    }
    public String getImageServerIp() {
        return this.applicationProperties.getProperty(IMAGE_SERVER_IP);
    }
    public String getPortWorkflow() {
        return this.applicationProperties.getProperty(PORT_WORKFLOW);
    }
    public String getIpWorkflow() {
        return this.applicationProperties.getProperty(IP_WORKFLOW);
    }
    public String getPortAutomatictaskExecutor() {
        return this.applicationProperties.getProperty(PORT_AUTOMATICTASK_EXECUTOR);
    }

    public  String getGRAMMARAUTOMATICTYPE() {
        return this.applicationProperties.getProperty(GRAMMARAUTOMATICTYPE);
    }

    public String getIpAutomatictaskExecutor() {
        return this.applicationProperties.getProperty(IP_AUTOMATICTASK_EXECUTOR);
    }

    public Integer getHighCaloriesDishLimit() {
        return Integer.valueOf(this.applicationProperties.getProperty(HIGH_CALORIES_DISH_LIMIT));
    }

    public String getCollaboratorAssignerAlgorithm () {
        return this.applicationProperties.getProperty( COLLABORATOR_ASSIGNER_ALGORITHM );
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map getExtendedPersistenceProperties() {
        final Map ret = new HashMap();
        ret.put(SCHEMA_GENERATION_KEY,
                this.applicationProperties.getProperty(SCHEMA_GENERATION_KEY));
        return ret;
    }



    public String getProperty(String prop) {
        return this.applicationProperties.getProperty(prop);
    }

}
