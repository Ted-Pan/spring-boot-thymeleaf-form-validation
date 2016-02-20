/**
 * 
 */
package org.nithin.apps.boot.thymeleaf.web.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nithin meshram
 *         20-Feb-2016
 *
 */
public class Album {

    @NotNull(message = "Title cannot be empty")
    @Size(min = 3, max = 50, message = "Title name can be minimum 3 and maximum 50 characters long")
    private String title;

    @NotNull(message = "Artist cannot be empty")
    @Size(min = 3, max = 50, message = "Artist name can be minimum 3 and maximum 30 characters long")
    private String artist;

    @NotNull(message = "Price cannot be empty")
    @Min(value = 0, message = "Album price cannot be less than 0")
    private float price;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Album [title=");
        builder.append(this.title);
        builder.append(", artist=");
        builder.append(this.artist);
        builder.append(", price=");
        builder.append(this.price);
        builder.append("]");
        return builder.toString();
    }

}
