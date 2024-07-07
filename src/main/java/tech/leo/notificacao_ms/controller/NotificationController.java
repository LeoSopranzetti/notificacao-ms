package tech.leo.notificacao_ms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.leo.notificacao_ms.controller.dto.ScheduleNotificationDto;
import tech.leo.notificacao_ms.entity.Notification;
import tech.leo.notificacao_ms.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto){
        notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("{notificationId}")
    public ResponseEntity<Notification> getNotification (@PathVariable("notificationId") Long notificationId){
        var notification = notificationService.findById(notificationId);

        if(notification.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("{notificationId}")
    public ResponseEntity<Void>cancelNotification(@PathVariable("notificationId") Long notificationId){
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }


}
