package icet.adbplatform.service;

import icet.adbplatform.model.Notification;
import icet.adbplatform.model.UserSettings;
import icet.adbplatform.repository.UserSettingsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSettingsService {

    private final UserSettingsRepository userSettingsRepository;

    public Boolean getDarkMode(Long id) {
        UserSettings userSettings = userSettingsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserSettings not found with id: " + id));
        return userSettings.getIsDarkMode();
    }

    public List<Notification> getNotifications(Long id) {
        UserSettings userSettings = userSettingsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserSettings not found with id: " + id));
        return userSettings.getNotifications();
    }

    public Notification addNotification(Long id, Notification notification) {
        UserSettings userSettings = userSettingsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserSettings not found with id: " + id));
        notification.setUserSettings(userSettings);
        userSettings.getNotifications().add(notification);
        userSettingsRepository.save(userSettings);
        return notification;
    }
}
