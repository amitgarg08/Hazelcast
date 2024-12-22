package com.example.hazelcast.controller;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Bean
    public Config config(){
        return new Config().setManagementCenterConfig(new ManagementCenterConfig()
                .setEnabled(true)
                .setUrl("http://localhost:8080/mancenter")
        );
    }
    @Bean
    public HazelcastInstance instance(Config conf){
        return Hazelcast.newHazelcastInstance(conf);
    }

    @Bean
    public IMap<String, String> map(HazelcastInstance instance){
        return instance.getMap("nameMap");
    }

}
