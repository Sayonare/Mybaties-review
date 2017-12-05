package spring.mvc.domain;

/**
 * Created by wyz_Sayonare on 2017/10/10.
 */
public class Orders {

    private Integer id;
    private String sn;  //订单编号
    private String remark; //订单描述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
