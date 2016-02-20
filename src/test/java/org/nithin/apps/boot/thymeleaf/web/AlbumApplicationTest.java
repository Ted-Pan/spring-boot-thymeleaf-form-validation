/**
 * 
 */
package org.nithin.apps.boot.thymeleaf.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nithin.apps.boot.thymeleaf.forms.AlbumsApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * We use Mockito here to test for validation errors.
 * 
 * @author nithin meshram
 *         21-Feb-2016
 */
@WebIntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AlbumsApplication.class)
public class AlbumApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(AlbumApplicationTest.class);


    public static final String BASE_URL = "http://localhost:8080";


    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        logger.debug("Setting up MockMvc...");
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        logger.debug("MockMvc => " + this.mockMvc);
        logger.debug("WAC     => " + this.wac);
    }


    @Test
    public void validationErrorsShownWhenEmptyFieldsSubmitted() throws Exception {
        // @formatter:off
        // Check if correct view name is forwarded to when asked for input page
        this.mockMvc.perform(get(BASE_URL + "/add"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("add"));
        
        // Check if expected number of validation errors occur when empty values passed in
        this.mockMvc.perform(post(BASE_URL + "/add").param("title", "").param("artist", "").param("price", ""))
                    .andExpect(model().hasErrors())
                    .andExpect(model().errorCount(3))
                    .andExpect(status().isOk())
                    .andExpect(view().name("add"));
     // @formatter:on
    }

}
