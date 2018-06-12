package com.analysis.lottery.controller;


import com.analysis.lottery.pojo.PUser;
import com.analysis.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody PUser user){
        userService.register(user);
        return "SUCCESS";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    public PUser login(String name, String password) throws Exception {
        PUser user = userService.login(name,password);
        return user;
    }

    @RequestMapping(value="/saveEdit",method = RequestMethod.POST)
    @ResponseBody
    public String saveEdit(@RequestBody PUser user){
        userService.saveEdit(user);
        return "SUCCESS";
    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public ModelAndView logout() throws Exception {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

}
