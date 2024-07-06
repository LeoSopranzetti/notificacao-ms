package tech.leo.notificacao_ms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.leo.notificacao_ms.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
