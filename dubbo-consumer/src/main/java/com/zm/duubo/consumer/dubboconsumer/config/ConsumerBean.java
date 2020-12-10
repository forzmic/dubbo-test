package com.zm.duubo.consumer.dubboconsumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.zm.dubbo.service.ItemApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: ZM
 * @create: 2020-12-09 14:50
 **/
@Configuration
@Slf4j
public class ConsumerBean {

    @Value("${dubbo.zk.addrs}")
    private String zkAddress;

    @Value("${dubbo.zk.group}")
    private String group;

    @Value("${dubbo.zk.version}")
    private String version;

    @Bean
    public ItemApi getItemApi() {

        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbo-consumer");

        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setThreads(100);
        consumerConfig.setTimeout(100);
        consumerConfig.setRetries(0);

        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress(zkAddress);
        registry.setGroup(group);

        ReferenceConfig<ItemApi> config = new ReferenceConfig<>();
        config.setApplication(application);
        config.setRegistry(registry);
        config.setInterface(ItemApi.class);
        config.setVersion(version);
        config.setConsumer(consumerConfig);
        config.setTimeout(200);
        config.setCheck(false);
        ItemApi api = config.get();
        log.info("get dubbo consumer, zk={}, group={}, version={}", zkAddress, group, version);
        return api;

    }
}
