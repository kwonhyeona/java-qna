package codesquad.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserId(String userId);

    User findByEmail(String email);

    User findByUserIdAndEmail(String userId, String email);
}
