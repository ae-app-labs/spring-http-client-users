package org.example.httpusers.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserHttpClientTest {

    @Test
    void testFindAll() {
        // Create a mock instance of UserHttpClient
        UserHttpClient httpClientMock = Mockito.mock(UserHttpClient.class);
        
        // Define the expected list of users
        List<User> expectedUsers = Arrays.asList(
            new User(1, "John", "john_doe", "john@example.com",
                     new Address("123 Main St", "Springfield", "", "12345", new Geo(1d, 1d)),
                     "123-456-7890", "www.johndoe.com",
                     new Company("ABC Inc", "Software", "")),
            new User(2, "Jane", "jane_smith", "jane@example.com",
                     new Address("456 Oak St", "Greenville", "", "54321", new Geo(1d, 1d)),
                     "987-654-3210", "www.janesmith.com",
                     new Company("XYZ Corp", "Tech", ""))
        );
        
        // Stub the findAll() method to return the expected list of users
        Mockito.when(httpClientMock.findAll()).thenReturn(expectedUsers);
        
        // Call the findAll() method
        List<User> actualUsers = httpClientMock.findAll();
        
        // Assert that the returned list matches the expected list
        assertEquals(expectedUsers, actualUsers);
    }
    
    @Test
    void testFindById() {
        // Create a mock instance of UserHttpClient
        UserHttpClient httpClientMock = Mockito.mock(UserHttpClient.class);
        
        // Define the expected user
        User expectedUser = new User(1, "John", "john_doe", "john@example.com",
                                     new Address("123 Main St", "Springfield", "", "12345", new Geo(1d, 2d)),
                                     "123-456-7890", "www.johndoe.com",
                                     new Company("ABC Inc", "Software", ""));
        
        // Stub the findById() method to return the expected user
        Mockito.when(httpClientMock.findById(1)).thenReturn(expectedUser);
        
        // Call the findById() method
        User actualUser = httpClientMock.findById(1);
        
        // Assert that the returned user matches the expected user
        assertEquals(expectedUser, actualUser);
    }
}
