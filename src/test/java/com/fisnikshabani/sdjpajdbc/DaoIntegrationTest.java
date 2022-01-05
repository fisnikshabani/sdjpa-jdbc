package com.fisnikshabani.sdjpajdbc;

import com.fisnikshabani.sdjpajdbc.dao.AuthorDao;
import com.fisnikshabani.sdjpajdbc.domain.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.fisnikshabani.sdjpajdbc.dao"})
public class DaoIntegrationTest {

    @Autowired
    AuthorDao authorDao;

    @Test
    void testGetAuthor() {

        Author author = authorDao.getById(1L);
        assertThat(author.getId()).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.findAuthorByName("Craig", "Walls");
        assertThat(author).isNotNull();
    }

    @Test
    void testInsertAuthor() {
        Author author = new Author();
        author.setFirstName("fisnik");
        author.setLastName("Sh2");

        Author saved = authorDao.saveNewAuthor(author);

        System.out.println("New id is " + saved.getId());

        assertThat(saved).isNotNull();
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("fisnik");
        author.setLastName("sh");

        Author saved = authorDao.saveNewAuthor(author);
        Author updated = authorDao.updateAuthor(saved);

        assertThat(updated.getLastName()).isEqualTo("Shabani");
    }
}
