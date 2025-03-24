package icet.adbplatform.service;

import icet.adbplatform.model.User;
import icet.adbplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setBio(updatedUser.getBio());
            existingUser.setProfileImage(updatedUser.getProfileImage());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUserbyId(Long id) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setDisabled(true);
            userRepository.save(existingUser);
        }
    }

    public List<User> searchUsers(String query) {
        return userRepository.findByUsernameContaining(query);
    }
}
