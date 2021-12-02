# Maven知识点梳理
Maven是工程开发中常用的项目管理工具，借着最近工作中需要搭服务的机会，对Maven的知识点作一个梳理</br></br>

**Maven的作用**

1）管理Jar包：既可以方便地添加第三方Jar包，又可以自动关联下载所有依赖的Jar包</br>

2）将项目拆分成多个模块</br>

**Maven的基本概念**

**定义：** 是一个基于Java平台的自动化构建工具</br>

**清理：** 删除编译的结果，为重新编译做准备</br>

**编译：** Java -> class </br>

**测试：** 针对项目中的关键点进行测试，也可用项目中的测试代码去测试开发代码</br>

**报告：** 将测试的结果进行显示</br>

**打包：** 将项目中包含的多个文件压缩成一个文件，用于安装或部署</br>

**安装：** 将打成的包放到本地仓库，供其它模块使用</br>

**部署：** 将打成的包放到服务器上准备运行</br>

<center>
<img src="https://files.mdnice.com/user/8785/3b2da148-98cf-497a-ab16-375fc0ca7bb1.png" width="500" height="280"/>
</center>

如上图所示，当工程项目寻找自身所依赖的jar包时，首先会到本地仓库找，如果找不到，再到远程仓库找；远程仓库又分为私服仓库和中央仓库，其中私服仓库通常是公司内部或部门内部所搭建的仓库，中央仓库是指Maven中央仓库

**Maven项目目录**

```xml
src
    main            -> 程序功能代码
        java        -> Java代码
        resources   -> 资源代码、配置代码
    test
        java
        resources
pom.xml 
target              -> 编译后的文件
```

**Maven常用命令**
```shell 
mvn clean    # 删除编译后的文件(target目录)
mvn compile  # 只编译main目录下的文件
mvn test     # 测试
mvn package  # 打包
mvn install  # 将开发的模块放入本地仓库，供其它模块使用
mvn deploy   # 将开发的项目放入远程仓库(通常是私服仓库)，供其它项目使用
```

**Maven依赖**

在Maven项目中，如果要使用一个已存在的jar包或模块，可以通过依赖实现(去本地、远程仓库找)。引入依赖：
```xml
<groupId>域名翻转.大项目名</groupId>
<groupId>org.JayChou.maven</groupId>

<artifactId>子模块名</artifactId>
<artifactId>HelloWorld</artifactId>

<version>版本号</version>
<version>0.1.1</version>
```
以上三部分也叫做gav</br></br>
依赖的范围：compile(默认)、test、provided。Maven在编译、测试和运行项目时，各自使用一套classpath，各自能够获取的依赖权限范围如下：
|     |compile     |test     | provided    |
| --- | --- | --- | --- |
|  编译   |  是   |  否   |  是   |
|  测试程序   |  是   |  是   | 是    |
|  部署(运行)   | 是    | 否    | 否   |

</br>
依赖排除：当通过maven引入A.jar时，会自动引入B.jar：

```java
A.jar(x.jar, y.jar, z.jar)
B.jar(p.jar, j.jar, k.jar)
A.jar与B.jar的依赖本质是：z.jar依赖于k.jar
```

当我们只用到x.jar和y.jar时，那么可以不用引入B.jar。可以通过以下方法排除B.jar：

```xml
<exclusions>
  <exclusion>
    <groupId></groupId>
    <artifactId></artifactId>
  </exclusion>
</exclusions>
```
</br>
依赖的传递性：当A.jar依赖于B.jar，B.jar依赖于C.jar，要使A.jar依赖于C.jar，当且仅当B.jar依赖于C.jar的范围是compile</br></br>

依赖原则：</br>
1）路径最短原则</br>
2）路径长度相同。i）在同一个pom.xml文件中有2个相同的依赖：则后面声明的依赖会覆盖前面声明的依赖；ii）如果是不同的pom.xml中有2个相同的依赖：则先声明的依赖会覆盖后声明的依赖</br></br>

**Maven生命周期和构建的关系** </br>如果Maven的生命周期如下：

```scala
a -> b -> c -> d ->e
```
假如执行命令d，则Maven会自动先执行a, b, c，再执行d</br></br>

**Maven的继承**</br>
定义：若A继承B，则A可以使用B的所有依赖</br></br>
实现步骤：</br>
1）建立父工程：父工程打包方式为pom(可以通过父工程，统一管理依赖的版本号)</br>
2）在父工程的pom.xml中编写依赖

```xml
<dependencyManageMent>
  <dependencies>
    <dependency>
      ...
    </dependency>
  </dependencies>
</dependencyManageMent>
```

3）子类中引入父类

```xml
<parent>
  <!--1.加入父工程gav-->
  ...
  <!--2.当前工程pom.xml到父工程pom.xml之间的相对路径-->
  <relativepath>../B/pom.xml</relativepath>
</parent>
```

4）子子类中声明使用哪些父类的依赖

```xml
<dependency>
  <!--声明：只需要ga-->
</dependency>
```

**Maven的聚合**</br>

配置聚合后，可以避免前置工程的install操作(只适合打包方式为pom的工程)。只需要操作总工程，则会自动操作聚合中配置过的工程

```xml
<modules>
  <!--前置项目的根路径-->
  <module>../Maven1</module>
  <module>../Maven2</module>
</modules>
```
