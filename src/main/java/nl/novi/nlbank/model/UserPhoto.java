package nl.novi.nlbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserPhoto {

    @Id
    private String fileName;

    private String contentType;

    private String url;

    public UserPhoto(String fileName, String contentType, String url) {
        this.fileName = fileName;
        this.contentType = contentType;
        this.url = url;
    }

    public UserPhoto() {
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
