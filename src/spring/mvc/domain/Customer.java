package spring.mvc.domain;

import java.util.List;

/**
 * Created by wyz_Sayonare on 2017/10/10.
 */
public class Customer {

    private List<Orders> orders; //关联多个订单
    private Integer  id;
    private String  name;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
