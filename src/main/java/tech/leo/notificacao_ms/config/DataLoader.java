package tech.leo.notificacao_ms.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.leo.notificacao_ms.Repository.ChannelRepository;
import tech.leo.notificacao_ms.Repository.StatusRepository;
import tech.leo.notificacao_ms.entity.Channel;
import tech.leo.notificacao_ms.entity.Status;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {


    private ChannelRepository channelRepository;
    private StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values()).map(Channel.Values::toChannel).forEach(channelRepository::save);
        Arrays.stream(Status.Values.values()).map(Status.Values::toStatus).forEach(statusRepository::save);
    }
}
