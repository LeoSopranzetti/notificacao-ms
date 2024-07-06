package tech.leo.notificacao_ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leo.notificacao_ms.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
