package com.sunhongyu.cpaassite20210201.controller;


import com.sunhongyu.cpaassite20210201.entity.Person;
import com.sunhongyu.cpaassite20210201.service.AdService;
import com.sunhongyu.cpaassite20210201.service.PersonRepository;
import com.sunhongyu.cpaassite20210201.utils.PinYinUtil;
import com.sunhongyu.cpaassite20210201.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ad")
public class ADController {
    @Autowired
    private AdService adService;
    @Autowired
    PersonRepository personRepository;


    @RequestMapping("/aduserList")
    public String aduserList(){
        return "page/user/aduserList";
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataVO list(){
        return adService.findlist();
    }


    @RequestMapping("/pagelist")
    @ResponseBody
    public DataVO list(Integer page,Integer limit){
        return adService.pageFindlist(page,limit);
    }

    @RequestMapping("/addperson")
    @ResponseBody
    public DataVO addPerson(String xing,String ming,String phone){

        boolean b = personRepository.addUser(xing,ming,phone);
        System.out.println(b);
        String xing1= PinYinUtil.getPinyin(xing);
        String ming1=PinYinUtil.getPinyin(ming);
        String userDn="cn="+xing1+ming1+",ou=demo";
        String groupDn="cn=demousers,cn=users";
        boolean c = personRepository.addUserToGroup(userDn,groupDn);
        System.out.println(c);
        List<Person> allPersons = personRepository.getAllPersons();
        System.out.println(allPersons);

        return null;
    }


    @RequestMapping("/delperson")
    @ResponseBody
    public DataVO delPerson(@RequestBody Map<String, String> map){
        String sAMAccountName=map.get("samaccountName");
        Person person = personRepository.findBysAMAccountName(sAMAccountName);
        System.out.println(person);
        personRepository.deletePerson(person);

        return null;
    }
}
