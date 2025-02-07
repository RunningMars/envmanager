#envmanager
环境变量管理系统

# 说明
基于 java springboot 构建的系统环境变量设置管理系统 , 灵活配置多个变量, 配合 goconfigenv 项目可以实现快速根据设置的key-value生成配置文件部署到服务器


```shell
nohup java -jar /Users/rdg/www/api/target/api-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev > /Users/rdg/www/api/runtime.log 2>&1 &
