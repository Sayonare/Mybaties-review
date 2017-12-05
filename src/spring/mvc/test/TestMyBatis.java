package spring.mvc.test;


        import org.apache.ibatis.io.Resources;
        import org.apache.ibatis.session.SqlSession;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.ibatis.session.SqlSessionFactoryBuilder;
        import spring.mvc.domain.Person;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.List;

/**
 * Created by wyz_Sayonare on 2017/10/10.
 */
public class TestMyBatis {


    /**
     *
     *  1.获得 SqlSessionFactory
     *  2.获得 SqlSession
     *  3.调用在mappoer文件中配置的属性
     * */
    // @Test
    public void ceshi() throws IOException {
        String resource = "sqlMapConfig.xml";     //定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();//获取到sqlSession

        //调用mapper 中的方法：命名空间 + id
        List<Person> personList = sqlSession.selectList("spring.mvc/mapper.UserMapper.findAll");

        for (
                Person p:personList
                ) {
            System.out.println(p);
        }
    }

}
