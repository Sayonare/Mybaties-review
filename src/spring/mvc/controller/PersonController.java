package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.apache.commons.io.FileUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.mvc.domain.Person;
import spring.mvc.service.PersonService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by wyz_Sayonare on 2017/10/7.
 */
@Controller
public class PersonController {
    @Resource
    PersonService ps;  //注入Service层

    @RequestMapping("/person/all")
    public String findAll(Map<String,Object> model)
    {
        List<Person> personList=ps.findAll();
        model.put("personList",personList);
        return "/person/jPersonList";
    }

    //跳转新增页面
    @RequestMapping("/person/toCreatePersonInfo")
    public String toCreatePersonInfo()
    {
        return "/person/jPersonCreate";
    }



    //跳转修改页面
    @RequestMapping("/person/toUpdatePersonInfo")
    public String toUpdatePersonInfo(Integer id,Model model)  //跳转修改页面
    {
        Person p = ps.get(id);          //获得要修改的值，重新设置页面的值
        model.addAttribute("p",p);  //将数据放到response
        return "/person/jPersonUpdate";
    }


    @RequestMapping("/person/updatePersonList")
    public String updatePersonList(HttpServletRequest request ,
                                   @Valid Person p,
                                   BindingResult bindingResult,
                                   Model model,
                                   @RequestParam("photo") MultipartFile photoFile)throws IOException
    {
        if(p.getId() == null)
        {
            ps.insert(p);       //调用Service层方法，插入数据
        }
        else
        {
            System.out.println("request = [" + request + "], p = [" + p + "], bindingResult = [" + bindingResult + "], model = [" + model + "], photoFile = [" + photoFile + "]");
            if (bindingResult.hasErrors()) {   //判断校检是否发现错误
                model.addAttribute("bindingResult", bindingResult);
                model.addAttribute("p", p);
                return "/person/jPersonUpdate";  //校检错误，返回校检页面，进行错误提示。
            }
            System.out.println("request = [" + request + "], p = [" + p + "], bindingResult = [" + bindingResult + "], model = [" + model + "], photoFile = [" + photoFile + "]");
            String dir = request.getSession().getServletContext().getRealPath("/")+"upload";
            System.out.println("dir:"+dir);
            String fileName = photoFile.getOriginalFilename();   //原始的文件名
            System.out.println("1fileName:"+fileName);
            String extName = fileName.substring(fileName.lastIndexOf(".")); //扩展名
            System.out.println(extName);
            fileName = fileName.substring(0,fileName.lastIndexOf("."))+System.nanoTime()+extName;
            System.out.println("2fileName"+fileName);
            System.out.println("System.nanoTime:"+System.nanoTime());
            FileUtils.writeByteArrayToFile(new File(dir+fileName),photoFile.getBytes());

            p.setPhotoPath("/upload"+fileName);
            ps.update(p);     //调用Service层方法，更新数据
        }
        return "redirect:/person/all.action";
    }

    //通过id删除单条记录
    @RequestMapping("/person/deleteById")
    public String deleteById(Integer id)
    {
        ps.deleteById(id);
        return "redirect:/person/all.action";
    }

    //批量删除
    @RequestMapping("/person/deleteMuch")
    public String deleteMuch(@RequestParam("id") Integer[] ids)
    {
        for (Integer delId: ids)
        {
            ps.deleteById(delId);

        }
        return "redirect:/person/all.action";
    }

}
