package com.zaurtregulov.spring.chapter02_AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zaurtregulov.spring.chapter02_AOP")
@EnableAspectJAutoProxy
public class MyConfig {
}
