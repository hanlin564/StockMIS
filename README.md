## 目录结构

src/main/java/com/fieldwork/stockmis

- dao：直接操作数据库的代码在这里
- entity：存放实体类，通常与数据表相对应
- service：业务逻辑代码在这里
- view：swing的代码写在这里
- StockMisApplication.java：程序的入口，运行其中的main函数即可启动登录界面

src/main/resources

- mappers：sql写在这里
- application.yml：项目的全局配置文件，mysql用户名密码在这里
