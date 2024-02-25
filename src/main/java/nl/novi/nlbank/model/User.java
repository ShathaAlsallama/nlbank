package nl.novi.nlbank.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.*;

@Entity
public class User{

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1003"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    //private Long studentNumber;
    private Long userNumber;
    private String emailAddress;
    private String name;
    private String type;
    @OneToOne
    UserPhoto userPhoto;

    public User() {
    }

    public User(Long userNumber, String emailAddress, String name, String type) {
        this.userNumber = userNumber;
        this.emailAddress = emailAddress;
        this.name = name;
        this.type = type;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public UserPhoto getFile() {
        return userPhoto;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFile(UserPhoto userPhoto) {
        this.userPhoto = userPhoto;
    }


}
