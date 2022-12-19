package totoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import totoro.dao.EmployeeDao;
import totoro.pojo.Employee;

import java.util.Collection;

/**
 * @author Totoro
 * @create 16 23:12
 *
 * 查询所有员工信息  -- >  /employee --> get GET
 * 跳转到添加页面  --》  /to/add --> get
 * 添加    /employee -> post
 * 跳转修改   /employee/1   ->get
 * 修改员工信息  /employee  -->put
 * 删除    /employee/1   -->delete
 */

@Controller
public class EmployeeController {

    //这里dao固定，因此不需要访问service


    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //获取所有员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将数据放入请求域中共享
        model.addAttribute("allEmployee",allEmployee);
        //跳转到列表页面
        return "employee_list";

    }


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能/
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        //删除员工信息，
        employeeDao.delete(id);
        //重定向
        return "redirect:/employee";
    }
}
