package spring.mvc.service;

import org.springframework.stereotype.Service;
import spring.mvc.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wyz_Sayonare on 2017/10/7.
 */
@Service
public class PersonService {   //模拟内存数据库,准备数据

    //声明一个容器
    private static Map<Integer, Person> map = new HashMap<Integer, Person>();

    private static Integer id = 10;

    //利用静态代码块初始化数据
    static {
        for (int i = 1; i <= 10; i++) {
                Person p = new Person();
                p.setId(i);
                p.setName("Charie" + i);
                p.setAge(10 + i);
                map.put(i, p);

        }
    }

    //获取人员列表
    public List findAll() {
        //将map对象转换为List集合
        return new ArrayList(map.values());

}

    //新增人员信息
    public void insert(Person person) {
        id++;
        person.setId(id);
        map.put(id, person);
    }

    //获得一个person对象
    public Person get(Integer id) {
        return map.get(id);
    }


    //修改人员信息
    public void update(Person p) {
        map.put(p.getId(), p);
    }

    //删除单条记录
    public void deleteById(Integer id) {
        map.remove(id);
    }
}




