
## 环境变量管理系统 envmanager

后端项目 Java SpringBoot

### 说明
基于Java SpringBoot 构建的系统环境变量设置管理系统, 灵活配置多个变量; 
配合 goconfigenv 项目, 可实现根据项目管理的的 key-value 快速生成配置文件, 并部署到目标服务器


```shell
nohup java -jar /Users/rdg/www/api/target/api-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /Users/rdg/www/api/runtime.log 2>&1 &
