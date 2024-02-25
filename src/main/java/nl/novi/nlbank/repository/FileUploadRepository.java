package nl.novi.nlbank.repository;

import nl.novi.nlbank.model.UserPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileUploadRepository extends JpaRepository<UserPhoto, String> {
    Optional<UserPhoto> findByFileName(String fileName);
}
