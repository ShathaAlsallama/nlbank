package nl.novi.nlbank.service;

import nl.novi.nlbank.exeption.RecordNotFoundException;
import nl.novi.nlbank.model.UserPhoto;

import nl.novi.nlbank.model.User;
import nl.novi.nlbank.repository.FileUploadRepository;
import nl.novi.nlbank.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    private final FileUploadRepository uploadRepository;

    public UserService(UserRepository repository, FileUploadRepository uploadRepository){
        this.repository = repository;
        this.uploadRepository = uploadRepository;
    }

    public List<User> getUsers() {

        return repository.findAll();

    }

    public User getUser(Long userNumber) {

        Optional<User> user = repository.findById(userNumber);

        if(user.isPresent()) {

            return user.get();

        } else {

            throw new RecordNotFoundException("User does not exist");

        }

    }

    public User saveUser(User user) {

        return repository.save(user);

    }

    public User updateUser(Long userNumber, User user) {

        Optional<User> optionalUser = repository.findById(userNumber);

        if (optionalUser.isPresent()) {

            User old = optionalUser.get();
            if(user.getUserNumber() != null){
                old.setUserNumber(userNumber);
            }
            if(user.getEmailAddress() != null){
                old.setEmailAddress(user.getEmailAddress());
            }
            if(user.getType() != null){
                old.setType(user.getType());
            }
            if(user.getName() != null){
                old.setName(user.getName());
            }
            if(old.getFile() != null && user.getFile() != null){
                old.setFile(user.getFile());
            } else if (old.getFile() != null) {
                old.setFile(old.getFile());
            }

            return repository.save(old);

        } else {

            throw new RecordNotFoundException("User does not exist");

        }

    }

    public void deleteUser(Long userNumber) {

        repository.deleteById(userNumber);

    }

    public User assignPhotoToStudent(String name, Long userNumber) {

        Optional<User> optionalUser = repository.findById(userNumber);

        Optional<UserPhoto> optionalPhoto = uploadRepository.findByFileName(name);

        if (optionalUser.isPresent() && optionalPhoto.isPresent()) {

            UserPhoto photo = optionalPhoto.get();

            User user = optionalUser.get();

            user.setFile(photo);

            return repository.save(user);

        } else {
            throw new RecordNotFoundException("User of foto niet gevonden");
        }

    }

}
