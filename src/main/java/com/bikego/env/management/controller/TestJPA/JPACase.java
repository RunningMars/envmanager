package com.bikego.env.management.controller.TestJPA;

public class JPACase {

    /**
     * JPA
     *  Java Persistence API : 用于对象持久化的API,是一种ORM规范
     *
     * JPA 的实现: Hibernate Toplink 其他的ORM框架
     *
     * ORM  映射元数据：JPA 支持XML和JDK 5.0注解两种元数据的形式，元数据描述对象和表之间的映射关系，框架据此将实体对象持久化到数据库表中。
     * JPA 的 API：用来操作实体对象，执行CRUD操作，框架在后台完成所有的事情，开发者从繁琐的 JDBC和 SQL代码中解脱出来。
     * 查询语言（JPQL）：这是持久化操作中很重要的一个方面，通过面向对象而非面向数据库的查询语言查询数据，避免程序和具体的SQL紧密耦合。
     */

    /**
     * Spring Data JPA
     * Spring Data JPA 是 Spring 基于 ORM 框架、JPA 规范的基础上封装的一套JPA应用框架，可使开发者用极简的代码即可实现对数据的访问和操作。
     * 它提供了包括增删改查等在内的常用功能，且易于扩展！学习并使用 Spring Data JPA 可以极大提高开发效率！
     * spring data jpa让我们解脱了DAO层的操作，基本上所有CRUD都可以依赖于它来实现
     *
     */

    /**
     * 使用JPA持久化对象的步骤
     * 1 创建 persistence.xml, 在这个文件中配置持久化单元
     *     - 需要指定跟哪个数据库进行交互;
     *     - 需要指定 JPA 使用哪个持久化的框架以及配置该框架的基本属性
     * 2 创建实体类, 使用 annotation 来描述实体类跟数据库表之间的映射关系.
     * 3 使用 JPA API 完成数据增加、删除、修改和查询操作
     *     - 创建 EntityManagerFactory (对应 Hibernate 中的 SessionFactory);
     *     - 创建 EntityManager (对应 Hibernate 中的Session);
     *
     * 依赖:
     * hibernate-release-4.2.4.Final\lib\required\*.jar
     * hibernate-release-4.2.4.Final\lib\jpa\*.jar
     * 数据库驱动的 jar 包
     */

    /**
     * JPA 基本注解
     * @Entity 标注用于实体类声明语句之前，指出该Java 类为实体类，将映射到指定的数据库表。如声明一个实体类 Customer，它将映射到数据库中的 customer 表上。
     *
     * @Table 标注的常用选项是 name，用于指明数据库的表名
     * 当实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，该标注与 @Entity 标注并列使用，置于实体类声明语句之前，可写于单独语句行，也可与声明语句同行。
     * @Table标注还有一个两个选项 catalog 和 schema 用于设置表所属的数据库目录或模式，通常为数据库名。uniqueConstraints 选项用于设置约束条件，通常不须设置。
     *
     * @Id 标注用于声明一个实体类的属性映射为数据库的主键列。该属性通常置于属性声明语句之前，可与声明语句同行，也可写在单独行上。
     * @Id标注也可置于属性的getter方法之前。
     *
     * @GeneratedValue  用于标注主键的生成策略，通过 strategy 属性指定。默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：SqlServer 对应 identity，
     * MySQL 对应 auto increment。
     * 在 javax.persistence.GenerationType 中定义了以下几种可供选择的策略：
     * IDENTITY：采用数据库 ID自增长的方式来自增主键字段，Oracle 不支持这种方式；
     * AUTO： JPA自动选择合适的策略，是默认选项；
     * SEQUENCE：通过序列产生主键，通过 @SequenceGenerator 注解指定序列名，MySql 不支持这种方式
     * TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植。
     *
     *
     * @Basic 表示一个简单的属性到数据库表的字段的映射, 对于没有任何标注的 getXxxx() 方法,默认即为@Basic
     *
     * @Transient 表示该属性并非一个到数据库表的字段的映射,ORM框架将忽略该属性.
     * 如果一个属性并非数据库表的字段映射,就务必将其标示为@Transient,否则,ORM框架默认其注解为@Basic
     *
     * @Column 当实体的属性与其映射的数据库表的列不同名时需要使用 @Column 标注说明，该属性通常置于实体的属性声明语句之前，还可与 @Id 标注一起使用。
     * 标注的常用属性是name，用于设置映射数据库表的列名。此外，该标注还包含其它多个属性，如：unique 、nullable、length 等。
     *
     * 在核心的 Java API 中并没有定义 Date 类型的精度(temporal precision). 而在数据库中,表示Date 类型的数据有DATE,TIME,和TIMESTAMP 三种精度(即单纯的日期,时间,或者两者 兼备).
     * 在进行属性映射时可使用@Temporal注解来调整精度.
     */

    /**
     * EntityManagerFactory 接口主要用来创建 EntityManager 实例。该接口约定了如下4个方法：
     * createEntityManager()：用于创建实体管理器对象实例。
     * createEntityManager(Map map)：用于创建实体管理器对象实例的重载方法，Map参数用于提供 EntityManager 的属性。
     * isOpen()：检查 EntityManagerFactory 是否处于打开状态。实体管理器工厂创建后一直处于打开状态，除非调用close()方法将其关闭。
     * close()：关闭 EntityManagerFactory。EntityManagerFactory 关闭后将释放所有资源，isOpen()方法测试将返回 false，其它方法将不能调用，否则将导致IllegalStateException异常。
     *
     */

    /**
     * EntityManager
     * 在JPA规范中, EntityManager 是完成持久化操作的核心对象。实体作为普通Java对象，只有在调用EntityManager将其持久化后才会变成持久化对象。EntityManager对象在
     * 一组实体类与底层数据源之间进行O/R映射的管理。它可以用来管理和更新Entity Bean,根椐主键查找Entity Bean, 还可以通过JPQL语句查询实体。实体的状态:
     * 新建状态:  新创建的对象，尚未拥有持久性主键。
     * 持久化状态：已经拥有持久性主键并和持久化建立了上下文环境。
     * 游离状态： 拥有持久化主键，但是没有与持久化建立上下文环境。
     * 删除状态:  拥有持久化主键，已经和持久化建立上下文环境，但是从数据库中删除。
     */

    /**
     * 关联映射
     * 基于外键的 1-1 关联关系：在双向的一对一关联中，需要在关系被维护端(inverse side)中的 @OneToOne 注释中指定 mappedBy，以指定是这一关联中的被维护端。
     * 同时需要在关系维护端(owner side)建立外键列指向关系被维护端的主键列。
     * 双向一对多关系中，必须存在一个关系维护端，在JPA规范中，要求many 的一方作为关系的维护端(owner side),one的一方作为被维护端(inverse side)。
     * 可以在 one 方指定 @OneToMany 注释并设置 mappedBy 属性，以指定它是这一关联中的被维护端，many 为维护端。
     * 在 many 方指定 @ManyToOne 注释，并使用 @JoinColumn 指定外键名称
     */

    /**
     * JPQL语言，即Java Persistence Query Language的简称。JPQL是一种和SQL非常类似的中间性和对象化查询语言，它最终会被编译成针对不同底层数据库的SQL查询，从而屏蔽不同数据库的差异。
     * JPQL语言的语句可以是 select 语句、update 语句或delete语句，它们都通过 Query 接口封装执行
     */


}
