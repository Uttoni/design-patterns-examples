package projeto.locadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer client;

    @BeforeEach
    protected void setUp() throws Exception{
        client = new Customer("John");
    }

    @Test
    public void testNameCreation(){
        String result = client.statement();
        assertContain(result, "Rental Record for John");
    }

    @Test
    public void testOneRegularOneDay(){
        rentMovie("Indiana Jones", Movie.REGULAR, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 2.0");
        assertContain(result, "You earned 1 frequent renter points");
    }

    @Test
    public void testOneRegularThreeDays(){
        rentMovie("Indiana Jones", Movie.REGULAR, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 3.5");
        assertContain(result, "You earned 1 frequent renter points");
    }

    @Test
    public void testOneChildrenOneDay(){
        rentMovie("Procurando Nemo", Movie.REGULAR, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 2.0");
        assertContain(result, "You earned 1 frequent renter points");
    }

    @Test
    public void testOneChildrenFiveDays(){
        rentMovie("Procurando Nemo", Movie.REGULAR, 5);
        String result = client.statement();
        assertContain(result, "Amount owed is 6.5");
        assertContain(result, "You earned 1 frequent renter points");
    }

    @Test
    public void testOneNewReleaseOneDay(){
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 1);
        String result = client.statement();
        assertContain(result, "Amount owed is 3.0");
        assertContain(result, "You earned 1 frequent renter points");
    }

    @Test
    public void testOneNewReleaseThreeDays(){
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 9.0");
        assertContain(result, "You earned 2 frequent renter points");
    }

    @Test
    public void testManyMovies(){
        rentMovie("Vingadores 2", Movie.NEW_RELEASE, 2);
        rentMovie("Star Wars - Episodio VII", Movie.NEW_RELEASE, 3);
        rentMovie("Procurando Nemo", Movie.CHILDREN, 3);
        rentMovie("Indiana Jones", Movie.REGULAR, 2);
        rentMovie("Divertidamente", Movie.CHILDREN, 4);
        rentMovie("E o vento levou...", Movie.REGULAR, 3);
        String result = client.statement();
        assertContain(result, "Amount owed is 25.0");
        assertContain(result, "You earned 8 frequent renter points");
    }

    private void rentMovie(String title, int type, int days){
        Movie movie = Movie.createMovie(title, type);
        Rental rental = new Rental(movie, days);
        client.addRental(rental);
    }

    private void assertContain(String result, String content){
        System.out.println("Result: " + result);
        System.out.println("Content: " + content);
        assertTrue(result.contains(content));
    }
}