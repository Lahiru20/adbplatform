package icet.adbplatform.controller;

import icet.adbplatform.model.Notification;
import icet.adbplatform.service.UserSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user-settings")
@RequiredArgsConstructor
public class UserSettingsController {

    private final UserSettingsService userSettingsService;

    @GetMapping("settings/{id}/dark-mode")
    public Boolean getDarkMode(@PathVariable Long id) {
        return userSettingsService.getDarkMode(id);
    }

    @GetMapping("settings/{id}/notifications")
    public List<Notification> getNotifications(@PathVariable Long id) {
        return userSettingsService.getNotifications(id);
    }

}
