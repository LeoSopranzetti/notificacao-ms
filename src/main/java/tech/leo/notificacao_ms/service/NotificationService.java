package tech.leo.notificacao_ms.service;

import org.springframework.stereotype.Service;
import tech.leo.notificacao_ms.Repository.NotificationRepository;
import tech.leo.notificacao_ms.controller.dto.ScheduleNotificationDto;
import tech.leo.notificacao_ms.entity.Notification;
import tech.leo.notificacao_ms.entity.Status;

import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto){
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById (Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification (Long notificationId) {
        var notification = findById(notificationId);

        if(notification.isPresent()){
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }


    }
}
