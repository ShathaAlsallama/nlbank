package nl.novi.nlbank.controller;

import nl.novi.nlbank.model.User;

import nl.novi.nlbank.service.PhotoService;
import nl.novi.nlbank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;


    public UserController(UserService userService, PhotoService photoService) {
        this.userService = userService;
        this.photoService = photoService;
    }

    @GetMapping
    @Transactional
    public List<User> getUsers() {

        List<User> users;


        users = userService.getUsers ();


        return users;

    }

    @GetMapping("/{id}")
    @Transactional
    public User getUser(@PathVariable("id") Long userNumber) {

        return userService.getUser(userNumber);

    }

    @PostMapping
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);

    }

    @PutMapping("/{userNumber}")
    public User updateUser(@PathVariable Long userNumber, @RequestBody User user) {

        return userService.updateUser(userNumber, user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userNumber) {

        userService.deleteUser(userNumber);

    }

    @PostMapping("/{id}/photo")
    public ResponseEntity<User> assignPhotoToUser(@PathVariable("id") Long userNumber,
                                                  @RequestBody MultipartFile file) {

//        StudentPhoto photo = controller.singleFileUpload(file);

        // next line makes url. example "http://localhost:8080/download/naam.jpg"
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString();

        String fileName = photoService.storeFile(file, url);

        return ResponseEntity.created(URI.create(url)).body(userService.assignPhotoToStudent(fileName, userNumber));

    }
}
