package com.cjy.controller;

import com.cjy.domain.User;
import com.cjy.domain.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//把UserController放到spring容器中
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value="/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);
    }

//获得请求头信息
    @RequestMapping(value="/quick20")
    @ResponseBody
//    将User-Agent的信息赋给user_agent
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }

    @RequestMapping(value="/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value="/quick18")
    @ResponseBody
    public void save18(Date data) throws IOException {
        System.out.println(data);
    }

    // localhost:8080/user/quick17/zhangsan
    @RequestMapping(value="/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable("username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value="/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "cjy") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping(value="/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {//将请求体@RequestBody的内容放到List集合中
        System.out.println(userList);
    }

    @RequestMapping(value="/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }

    @RequestMapping(value="/quick13")
    @ResponseBody
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));//将数组转化未集输出，直接打印数组是地址
    }

//    封装一个实体
    @RequestMapping(value="/quick12")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

//    获得基本类型参数
    @RequestMapping(value="/quick11")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public void save11(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value="/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        return user;
    }

    @RequestMapping(value="/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json的转换工具将对象转换成json格式字符串在返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping(value="/quick8")//RequestMethod请求的方式
    @ResponseBody //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save8() throws IOException {//原生的xml对象,tomcat产生的,这个方法不是常用,使用框架了一般用框架提供的对象
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value="/quick7")//RequestMethod请求的方式
    @ResponseBody //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() throws IOException {//原生的xml对象,tomcat产生的,这个方法不是常用,使用框架了一般用框架提供的对象
        return ("hello cjy");
    }

    @RequestMapping(value="/quick6")//RequestMethod请求的方式
    public void save6(HttpServletResponse response) throws IOException {//原生的xml对象,tomcat产生的,这个方法不是常用,使用框架了一般用框架提供的对象
        response.getWriter().println("hello cjy");
    }

    @RequestMapping(value="/quick5")//RequestMethod请求的方式
    public String save5(HttpServletRequest request){//原生的xml对象,tomcat产生的,这个方法不是常用,使用框架了一般用框架提供的对象
        request.setAttribute("username","哈哈哈");
        return "success";
    }

    @RequestMapping(value="/quick4")//RequestMethod请求的方式
    public String save4(Model model){
        model.addAttribute("username","模型视图分开");
        return "success";
    }

    @RequestMapping(value="/quick3")//RequestMethod请求的方式
    public ModelAndView save3(ModelAndView modelAndView){//spring提供方法的参数可以帮你注入
        //        设置模型数据
        modelAndView.addObject("username","itcjy");
        //        设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value="/quick2")//RequestMethod请求的方式
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        /*
            Model:模型 作用封装数据
            View：视图 作用展示数据
         */
//        设置模型数据
        modelAndView.addObject("username","cjy");
//        设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

//    @RequestMapping("/quick")//只有一个参数的时候默认是value
    // 请求地址  http://localhost:8080/user/quick
//    携带参数类型请求地址http://localhost:8080/user/quick?username=1
    @RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})//RequestMethod请求的方式
    public String save(){
        System.out.println("Controller save running....");
        return "success";//要跳转的视图,/success.jsp表示在当前目录webapp下查找,配置了内部资源视图解析器的前缀和后缀
    }
}
