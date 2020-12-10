package com.zm.dubbo.provider.dubboprovider.init;

import com.alibaba.dubbo.config.*;
import com.zm.dubbo.provider.dubboprovider.service.ItemService;
import com.zm.dubbo.service.ItemApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @description:
 * @author: ZM
 * @create: 2020-12-09 11:24
 **/
@Service
@Slf4j
@Configuration
public class ServiceInit {

    @Value("${dubbo.zk.addrs}")
    private String zkAddress;

    @Value("${dubbo.zk.port}")
    private int port;

    @Value("${dubbo.zk.group}")
    private String group;

    @Value("${dubbo.zk.version}")
    private String version;

    @Resource
    private ItemService itemService;

    @PostConstruct
    public void initDubboService() {
        log.info("start to init dubbo service ~~ ");
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-test");

        ProviderConfig config = new ProviderConfig();
        config.setTimeout(1234);

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress(zkAddress);
        registryConfig.setGroup(group);

        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(port);
        protocol.setSerialization("hessian2");
        protocol.setTransporter("netty");
        protocol.setThreads(200);

        ServiceConfig<ItemApi> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setProvider(config);
        service.setRegistry(registryConfig);
        service.setProtocol(protocol);
        service.setInterface(ItemApi.class);
        service.setVersion(version);
        service.setRef(itemService);

        service.export();

        log.info("dubbo service, zkAddress={}, group={}, version={}, port={}", zkAddress, group, version, port);
        log.info("end to init dubbo service ~~ ");
    }
}
