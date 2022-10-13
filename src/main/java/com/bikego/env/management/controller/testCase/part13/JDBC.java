//package com.bikego.env.management.controller.testCase.part13;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    /**
     * JDBC的全称是Java Database Connectivity，即Java数据库连接，它是一种可以执行SQL语句的Java API。
     *
     * 通过使用JDBC，就可以使用同一种API访问不同的数据库系统。换言之，有了JDBC API，就不必为访问Oracle数据库学习一组API，
     * 为访 问DB2数据库又学习一组API……开发人员面向JDBC API编写应用程序，然后根据不同的数据库，使用不同的数据库驱动程序即可。
     */

    /**
     * 对比两种存储机制，不难发现InnoDB比MyISAM多了事务支持的功能，而事务支持是Java EE最重要的特性，因此通常推荐使用InnoDB存储机制。
     * 如果使用5.0以上版本的MySQL数据库系统，通常无须指定数据表的存储机制，因为系统默认使用InnoDB存储机制。
     */

    /**
     * SQL的全称是Structured Query Language，也就是结构化查询语言。SQL是操作和检索关系数据库的标准语言，标准的SQL语句可用于操作任何关系数据库。
     *
     * 标准的SQL语句通常可分为如下几种类型。
     * ➢ 查询语句：主要由select关键字完成，查询语句是SQL语句中最复杂、功能最丰富的语句。
     * ➢ DML（Data Manipulation Language，数据操作语言）语句：主要由insert、update和delete三个关键字完成。
     * ➢ DDL（Data Definition Language，数据定义语言）语句：主要由create、alter、drop和truncate四个关键字完成。
     * ➢ DCL（Data Control Language，数据控制语言）语句：主要由grant和revoke两个关键字完成。
     * ➢ 事务控制语句：主要由commit、rollback和savepoint三个关键字完成。
     */


    /**
     * 函数
     * MySQL提供了如下几个处理null的函数。
     * ➢ ifnull(expr1, expr2)：如果expr1为null，则返回expr2，否则返回expr1。
     * ➢ nullif(expr1, expr2)： 如果 erpr1 和 expr2 相等，则返回null，否则返回expr1。
     * ➢ if(expr1, expr2, expr3)：有点类似于？：三目运算符，如果expr1为true，不等于0，且不等于null，则返回expr2，否则返回expr3。
     * ➢ isnull(expr1)：判断expr1是否为null，如果为null则返回true，否则返回false。
     */

    /**
     * case函数，该函数是一个流程控制函数。
     *
     * 用法一:
     * select student_name ,
     * case java_teacher
     * when 1 then 'Java老师'
     * when 2 then 'Php老师'
     * else '其他老师'
     * end
     * from student_table;
     *
     * 用法二:
     * select student_name ,
     * case
     * when student_id < 3 then '初级班'
     * when student_id <= 6 then '中级班'
     * else '高级班'
     * end
     * from student_table;
     */


    /**
     * minus运算的语法格式如下：
     * select 语句 minus select 语句
     * 不过很遗憾，MySQL并不支持使用minus运算符，因此只能借助于子查询来“曲线”实现上面的minus运算。
     *
     * intersect运算
     * select 语句 intersect select 语句
     * MySQL并不支持这种运算。但可以通过如下多表连接查询来实现上面运算。
     */


    /**
     * JDBC编程步骤
     *
     * ① 加载数据库驱动。通常使用Class类的forName()静态方法来加载驱动。例如如下代码：
     * Class.forName("com.mysql.cj.jdbc.Driver");
     * //加载Oracle的驱动
     * Class.forName("oracle.jdbc.driver.OracleDriver");
     *
     * ② 通过DriverManager获取数据库连接。DriverManager提供了如下方法：
     * DriverManager.getConnection(String url,String user,String pass)
     * jdbc:mysql://127.0.0.1:3:306/databaseName
     *
     * ③ 通过Connection对象创建Statement对象。Connection创建Statement的方法有如下三个。
     * ➢ createStatement()：创建基本的Statement对象。
     * ➢ prepareStatement(String sql)：根据传入的SQL语句创建预编译的Statement对象。
     * ➢ prepareCall(String sql)：根据传入的SQL语句创建CallableStatement对象。
     *
     * ④ 使用Statement执行SQL语句。所有的Statement都有如下三个方法来执行SQL语句。
     * ➢ execute()：可以执行任何SQL语句，但比较麻烦。
     * ➢ executeUpdate()：主要用于执行DML和DDL语句。执行DML语句返回受SQL语句影响的行数，执行DDL语句返回0。
     * ➢ executeQuery()：只能执行查询语句，执行后返回代表查询结果的ResultSet对象。
     *
     * ⑤ 操作结果集。如果执行的SQL语句是查询语句，则执行结果将返回一个ResultSet对象，该对象里保存了SQL语句查询的结果。
     * 程序可以通过操作该ResultSet对象来取出查询结果。ResultSet对象主要提供了如下两类方法。
     * ➢ next()、previous()、first()、last()、beforeFirst()、afterLast()、absolute()等移动记录指针的方法。
     * ➢ getXxx()方法获取记录指针指向行、特定列的值。该方法既可使用列索引作为参数，也可使用列名作为参数。使用列索引作为参数性能更好，使用列名作为参数可读性更好。
     *
     * ⑥ 回收数据库资源，包括关闭ResultSet、Statement和Connection等资源。
     */

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "rdgrdg");
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from test");

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));

        }
    }


    /**
     * 使用PreparedStatement还有一个优势—当SQL语句中要使用参数时，无须“拼接”SQL字符串。而使用Statement则要“拼接”SQL字符串，
     * 如上程序中粗体字代码所示，这是相当容易出现错误的—注意粗体字代码中的单引号，这是因为SQL语句中的字符串必须用单引号引起来。
     * 尤其是当SQL语句中有多个字符串参数时，“拼接”这条SQL语句时就更容易出错了。使用PreparedStatement则只需要使用
     * 问号占位符来代替这些参数即可，降低了编程复杂度。使用PreparedStatement还有一个很好的作用—用于防止SQL注入。
     *
     * 总体来看，使用PreparedStatement比使用Statement多了如下三个好处。
     * ➢ PreparedStatement预编译SQL语句，性能更好。
     * ➢ PreparedStatement无须“拼接”SQL语句，编程更简单。
     * ➢ PreparedStatement可以防止SQL注入，安全性更好。
     * 基于以上三点，通常推荐避免使用Statement来执行SQL语句，改为使用PreparedStatement执行SQL语句。
     */

    /**
     * 使用RowSet 包装结果集
     * RowSet 接口继承了ResultSet接口，RowSet 接口下包含JdbcRowSet、CachedRowSet、FilteredRowSet、JoinRowSet和WebRowSet常用子接口。
     * 除JdbcRowSet需要保持与数据库的连接之外，其余4个子接口都是离线的RowSet，无须保持与数据库的连接。与ResultSet相比，RowSet默认是可滚动、
     * 可更新、可序列化的结果集，而且作为JavaBean使用，因此能方便地在网络上传输，用于同步两端的数据。对于离线RowSet而言，程序在创建RowSet时已把
     * 数据从底层数据库读取到了内存，因此可以充分利用计算机的内存，从而降低数据库服务器的负载，提高程序性能。
     */

    /**
     * 事务是由一步或几步数据库操作序列组成的逻辑执行单元，这系 列操作要么全部执行，要么全部放弃执行。程序和事务是两个不同的
     * 概念。一般而言，一段程序中可能包含多个事务。
     *
     */

    /**
     * 事务具备4个特性：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）和持续性（Durability）。这4个特性也简称为ACID性。
     * ➢ 原子性（Atomicity）：事务是应用中最小的执行单位，就如原子是自然界的最小颗粒，具有不可再分的特征一样，事务是应用中不可再分的最小逻辑执行体。
     * ➢ 一致性（Consistency）：事务执行的结果，必须使数据库从一个一致性状态，变到另一个一致性状态。当数据库只包含事务成功提交的结果时，数据库处于一致性状态。
     * 如果系统运行发生中断，某个事务尚未完成而被迫中断，而该未完成的事务对数据库所做的修改已被写入数据库，此时，数据库就处于一种不正确的状态。
     * 比如银行在两个账户之间转账：从A账户向B账户转入1000元，系统先减少A账户的1000元，然后再为B账户增加1000元。如果全部执行成功，数据库处于一致性状态；
     * 如果仅执行完A账户金额的修改，而没有增加B账户的金额，则数据库就处于不一致性状态；因此，一致性是通过原子性来保证的。
     * ➢ 隔离性（Isolation）：各个事务的执行互不干扰，任意一个事务的内部操作对其他并发的事务都是隔离的。也就是说，并发执行的事务之间不能看到对方的中间状态，并发执行的事务之间不能互相影响。
     * ➢ 持续性（Durability）：持续性也称为持久性（Persistence），指事务一旦提交，对数据所做的任何改变都要记录到永久存储器中，通常就是保存进物理数据库。数据库的事务由下列语句组成。
     * ➢ 一组DML语句，经过这组DML语句修改后的数据将保持较好的一致性。
     * ➢ 一条DDL语句。
     * ➢ 一条DCL语句。
     * DDL和DCL语句最多只能有一条，因为DDL和DCL语句都会导致事务立即提交。当事务所包含的全部数据库操作都成功执行后，应该提交（commit）事务，使这些修改永久生效。
     * 事务提交有两种方式：显式提交和自动提交。
     * ➢ 显式提交：使用commit。
     * ➢ 自动提交：执行DDL或DCL语句，或者程序正常退出。
     * 当事务所包含的任意一个数据库操作执行失败后，应该回滚（rollback）事务，使该事务中所做的修改全部失效。事务回滚有两种方式：显式回滚和自动回滚。
     * ➢ 显式回滚：使用rollback。
     * ➢ 自动回滚：系统错误或者强行退出。
     */

    /**
     * savepoint 设置事务的中间点，通过使用savepoint设置事务的中间点可以让事务回滚到指定中间点，而不是回滚全部事务。
     *
     * savepoint a;
     *
     * rollback to a;
     */

    /**
     * 提示：实际上，当Connection遇到一个未处理的SQLException异常时，系统将会非正常退出，事务也会自动回滚。
     * 但如果程序捕获了该异常，则需要在异常处理块中显式地回滚事务。
     */


    /**
     * 数据库连接池的解决方案是：当应用程序启动时，系统主动建立足够的数据库连接，并将这些连接组成一个连接池。每次应用程序请求数据库连接时，无须重新打开连接，
     * 而是从连接池中取出已有的连接使用，使用完后不再关闭数据库连接，而是直接将连接归还给连接池。通过使用连接池，将大大提高程序的运行效率。
     */

    /**
     * DBCP是Apache软件基金组织下的开源连接池实现，该连接池依赖 该组织下的另一个开源系统：common-pool。
     *
     * 相比之下，C3P0数据源性能更胜一筹，Hibernate就推荐使用该连接池。C3P0连接池不仅可以自动清理不再使用的Connection，还可以自动清理Statement和ResultSet。
     */
}
