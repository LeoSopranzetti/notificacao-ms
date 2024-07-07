package tech.leo.notificacao_ms.controller.dto;

import tech.leo.notificacao_ms.entity.Channel;
import tech.leo.notificacao_ms.entity.Notification;
import tech.leo.notificacao_ms.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime, String destination, String message, Channel.Values channel) {

    public Notification toNotification(){
        return new Notification(
            dateTime,
            destination,
            message,
            channel.toChannel(),
            Status.Values.PENDING.toStatus()
        );
    }
}
