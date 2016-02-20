/**
 * 
 */
package org.nithin.apps.boot.thymeleaf.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author nithin meshram
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.nithin.apps.boot.thymeleaf.web")
public class AlbumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbumsApplication.class, args);
    }

}
