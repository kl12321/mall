package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    //默认文档地址为 http://localhost:8088/swagger-ui.html
    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)          //指定Api类型为Swagger2
                .apiInfo(apiInfo())                             //指定文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.controller")) //指定controller包路径
                .paths(PathSelectors.any())                     //指定展示所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        //返回一个apiinfo
        return new ApiInfoBuilder()
                .title("api接口文档")                                       //文档页标题
                .contact(
                        new Contact(
                                "psyDuck",
                                "https://blog.csdn.net/yjrguxing",
                                "yiyueguxing@qq.com")
                )                                                           // 联系人信息
                .description("api文档")                                       // 详细信息
                .version("2.0.12")                                           // 文档版本号
                .termsOfServiceUrl("https://www.baidu.com")                  //网站地址
                .build();
    }

}

