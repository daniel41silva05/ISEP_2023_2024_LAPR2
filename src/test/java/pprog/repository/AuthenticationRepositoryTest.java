package pprog.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationRepositoryTest {

    @Test
    void doLogin_validCredentials_returnTrue() {
        // Arrange
        AuthenticationRepository repository = new AuthenticationRepository();
        String email = "user@example.com";
        String password = "password";

        // Act
        boolean result = repository.doLogin(email, password);

        // Assert
        assertTrue(result);
    }

    @Test
    void doLogin_invalidCredentials_returnFalse() {
        // Arrange
        AuthenticationRepository repository = new AuthenticationRepository();
        String email = "invalid@example.com";
        String password = "invalid";

        // Act
        boolean result = repository.doLogin(email, password);

        // Assert
        assertFalse(result);
    }

    @Test
    void doLogout() {
        // Arrange
        AuthenticationRepository repository = new AuthenticationRepository();

        // Act
        repository.doLogout();

        // Assert
        assertNull(repository.getCurrentUserSession());
    }

    @Test
    void addUserRole() {
        // Arrange
        AuthenticationRepository repository = new AuthenticationRepository();
        String roleId = "1";
        String description = "Test Role";

        // Act
        boolean result = repository.addUserRole(roleId, description);

        // Assert
        assertTrue(result);
    }

    @Test
    void addUserWithRole() {
        // Arrange
        AuthenticationRepository repository = new AuthenticationRepository();
        String name = "Test User";
        String email = "testuser@example.com";
        String password = "password";
        String roleId = "1"; // Assuming the role exists

        // Act
        boolean result = repository.addUserWithRole(name, email, password, roleId);

        // Assert
        assertTrue(result);
    }
}
