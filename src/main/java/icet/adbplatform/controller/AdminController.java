package icet.adbplatform.controller;

import icet.adbplatform.model.Notification;
import icet.adbplatform.model.User;
import icet.adbplatform.service.UserService;
import icet.adbplatform.service.UserSettingsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final UserSettingsService userSettingsService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserbyId(@PathVariable Long id) {
        userService.deleteUserbyId(id);
    }

    @GetMapping("/users")
    public List<User> searchUsers(@RequestParam String query) {
        return userService.searchUsers(query);
    }

    @PostMapping("settings/{id}/notifications")
    public Notification addNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return userSettingsService.addNotification(id, notification);
    }
}
