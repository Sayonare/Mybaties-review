package spring.mvc.domain;


import javax.validation.constraints.Size;

/**
 * Created by wyz_Sayonare on 2017/10/7.
 */
public class Person {


    private Integer id;
    @Size(min = 6,max =12,message = "姓名必须大于6个字符，小于12个字符")
    private String name;
    private Integer age;
    private String photoPath; //图片储存路劲

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
