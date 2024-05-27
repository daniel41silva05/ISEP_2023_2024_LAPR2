package pprog.session;

import pprog.domain.algoritmos.SortingAlgorithm;
import pprog.domain.email.Email;
import pprog.repository.AuthenticationRepository;
import pprog.repository.Repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ApplicationSession {
    private final AuthenticationRepository authenticationRepository;
    private static final String CONFIGURATION_FILENAME = "src/main/resources/config.properties";
    private static final String COMPANY_DESIGNATION = "Company.Designation";

    private ApplicationSession() {
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        Properties props = getProperties();
    }

    public pprog.session.UserSession getCurrentSession() {
        pt.isep.lei.esoft.auth.UserSession userSession = this.authenticationRepository.getCurrentUserSession();
        return new UserSession(userSession);
    }

    private Properties getProperties() {
        Properties props = new Properties();

        props.setProperty(COMPANY_DESIGNATION, "MusgoSublime");

        try {
            InputStream in = new FileInputStream(CONFIGURATION_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    private static pprog.session.ApplicationSession singleton = null;

    public static pprog.session.ApplicationSession getInstance() {
        if (singleton == null) {
            synchronized (pprog.session.ApplicationSession.class) {
                singleton = new pprog.session.ApplicationSession();
            }
        }
        return singleton;
    }

    private static String getEmail() throws IOException {
        try (InputStream input = new FileInputStream(CONFIGURATION_FILENAME)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("emailService", "");
        }
    }

    public static Email getEmailService() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String emailClassPath = "pprog.domain." + getEmail();
        Class<?> className = Class.forName(emailClassPath);
        return (Email) className.getDeclaredConstructor().newInstance();
    }

    private static String getAlgorithm() throws IOException {
        try (InputStream input = new FileInputStream(CONFIGURATION_FILENAME)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("SortingAlgorithm", "");
        }
    }

    public static SortingAlgorithm getSortingAlgorithm() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, NoSuchMethodException, InvocationTargetException {
        String algorithm= "pprog.domain." + getAlgorithm();
        Class<?> className = Class.forName(algorithm);
        return (SortingAlgorithm) className.getDeclaredConstructor().newInstance();
    }

}
