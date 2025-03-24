package icet.adbplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user-settings")
@RequiredArgsConstructor
public class UserSettingsController {

    @GetMapping("settings/{id}/dark-mode")
    public Boolean getDarkMode() {
        return false;
    }

    @GetMapping("settings/{id}/notifications")
    public String getNotifications() {
        return "Notifications";
    }
}
