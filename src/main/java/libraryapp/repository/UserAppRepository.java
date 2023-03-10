package libraryapp.repository;

import libraryapp.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAppRepository extends JpaRepository < UserApp, UUID> {

    Optional<UserApp> findByUsername(String userName);

    Boolean existsByUsername(String username);

    Boolean existsByEmail (String email);
}
