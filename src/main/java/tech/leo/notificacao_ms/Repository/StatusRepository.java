package tech.leo.notificacao_ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leo.notificacao_ms.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
