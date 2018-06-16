# 作业


## 使用方法
后端位于/guitar目录，基于maven构建，直接导入就好。
### 启动方式
   环境JDK8、maven
   在后端项目中找到com.github.cumtfc.guitar.application.DemoApplication类，直接运行main方法即可启动后端项目，启动后项目使用的端口是8080
### 前端位于/front目录，基于angular6
前端运行需要安装NodeJs，安装完NodeJs后需要使用淘宝镜像

```
npm install -g cnpm –registry=https://registry.npm.taobao.org
```
安装完成后构建并运行前端
```bash
 npm i
 npm start
```
运行上述命令成功后直接访问http://127.0.0.1:4200即可访问前台页面


### 运行主界面
![mian](pic/main.png)
### 添加实体页面
![save](pic/save.png)
### 查询页面
![query](pic/query.png)
### 后端启动类代码

```
package com.github.cumtfc.guitar.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lfy
 * @date 2018/6/8-19:12
 */
@SpringBootApplication(scanBasePackages = {"com.github.cumtfc.guitar.controller", "com.github.cumtfc.guitar.service",
    "com.github.cumtfc.guitar.component"})
@EntityScan(basePackages = "com/github/cumtfc/guitar/po")
@EnableJpaRepositories(basePackages = "com.github.cumtfc.guitar.dao")
@EnableConfigurationProperties
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
