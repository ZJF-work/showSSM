package com.hz.ssm.controller;

import com.hz.ssm.model.User;
import com.hz.ssm.req.UserAddReq;
import com.hz.ssm.req.UserDeleteReq;
import com.hz.ssm.req.UserUpdateReq;
import com.hz.ssm.resp.*;
import com.hz.ssm.service.UserService;
import com.hz.ssm.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;


//@RestController  不能返回页面 =@Controller +@ ResponeseBody
@Controller
@RequestMapping("/user")
public class UesrController {

//    通过搜spring 获取对象
    @Autowired
    private UserService userService;

    private static final Logger loger =  LoggerFactory.getLogger(UesrController.class);

    /**
     * 加载用户界面
     * @return
     */

        @RequestMapping("/show")
        public String showUser(){
            return "/user";
        }



/**
 * 显示所有用户
 */
@ResponseBody
@RequestMapping("/queryAll")
public QueryResp queryAllUser(){
   loger.info("接收到查询请求21332");
   QueryResp queryResp =new QueryResp();

//   数据库中查询出来的数据
   List<User> userList = userService.queryAllUser();
   queryResp.setCode(0);
   queryResp.setMsg("查询成功");

   if(CollectionUtils.isEmpty(userList)){
       return queryResp;
   }
//返回给前端的数据
    List<QueryData> dataList = new ArrayList<QueryData>();

   for(User u:userList){
       QueryData data = new QueryData();

       data.setId(u.getId());
       data.setAccount(u.getUserName());
       data.setPassword(u.getPassword());
       data.setInfo(u.getMsg());
       data.setName(u.getTrueName());
       dataList.add(data);
   }
queryResp.setData(dataList);
   return queryResp;
}

/**
 * 添加用户
 */
@ResponseBody
@RequestMapping("/add")
    public AddReqMsg addUser(@RequestBody UserAddReq userAddReq){

    System.out.println("---account---:" + userAddReq.getAccount());

    AddReqMsg addReqMsg = new AddReqMsg();
    if(StringUtils.isEmpty(userAddReq.getAccount())){
        addReqMsg.setStatus(0);
        addReqMsg.setMsg("用户名不能为空");
        return addReqMsg;
    }

    boolean flag=userService.addUser(userAddReq);
    if(flag==true){
        addReqMsg.setStatus(1);
        addReqMsg.setMsg("添加成功");
    }else{
        addReqMsg.setStatus(0);
        addReqMsg.setMsg("添加失败" );
    }
    return addReqMsg;
}

/**
 * 编辑用户信息
 */
@ResponseBody
@RequestMapping("/update")
public UpdateReqMsg updateUser(@RequestBody UserUpdateReq userUpdateReq){
    loger.info("接收到编辑请求");
    System.out.println("---account---:" + userUpdateReq.getAccount());

    UpdateReqMsg updateReqMsg = new UpdateReqMsg();
    if(StringUtils.isEmpty(userUpdateReq.getAccount())){
        updateReqMsg.setStatus(0);
        updateReqMsg.setMsg("用户名不能为空");
        return updateReqMsg;
    }

    boolean flag=userService.updateUser(userUpdateReq);
    if(flag==true){
        updateReqMsg.setStatus(1);
        updateReqMsg.setMsg("修改成功");
    }else{
        updateReqMsg.setStatus(0);
        updateReqMsg.setMsg("修改失败" );
    }
    return updateReqMsg;
    }


//    /**
//     * 删除用户信息
//     */
//    @ResponseBody
//    @RequestMapping("/delete/{id}")
//    public DeleteReqMsg deleteUser(@PathVariable("id") int id){
//        loger.info("接收到删除请求id:{}",id);
//        DeleteReqMsg deleteReqMsg = new DeleteReqMsg();
//
//        boolean flag=userService.deleteUser(id);
//        if(flag==true){
//            deleteReqMsg.setStatus(1);
//            deleteReqMsg.setMsg("删除成功");
//        }else{
//            deleteReqMsg.setStatus(0);
//            deleteReqMsg.setMsg("删除失败" );
//        }
//        return deleteReqMsg;
//    }

    /**
     * 删除用户信息
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
//    @requestBody这个标签在post 、put 方法中用于接收json格式的数据
//    @requestParam这个标签接收的是key-value形式的参数。
    // 用这种方法删除数据 不能写成 public DeleteReqMsg deleteUser( @RequestBody UserDeleteReq userDeleteReq)
//    发生 HttpMessageNotReadableException 这个错误有很大程度上是因为接值时候用的标签不对，不应该用@requestBody标签
    public DeleteReqMsg deleteUser(  UserDeleteReq userDeleteReq){
        loger.info("接收到删除请求id:{}");
        DeleteReqMsg deleteReqMsg = new DeleteReqMsg();

        boolean flag=userService.deleteUser(userDeleteReq);
        if(flag==true){
            deleteReqMsg.setStatus(1);
            deleteReqMsg.setMsg("删除成功");
        }else{
            deleteReqMsg.setStatus(0);
            deleteReqMsg.setMsg("删除失败" );
        }
        return deleteReqMsg;
    }
}