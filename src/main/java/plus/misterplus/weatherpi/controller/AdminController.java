package plus.misterplus.weatherpi.controller;

import org.springframework.web.bind.annotation.*;
import plus.misterplus.weatherpi.bean.Admin;
import plus.misterplus.weatherpi.bean.Status;
import plus.misterplus.weatherpi.sql.dao.impl.AdminDaoImpl;
import plus.misterplus.weatherpi.util.TokenUtils;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Status login(@RequestBody Admin admin) {
        Admin selected = AdminDaoImpl.getInstance().select(admin);
        if (selected == null) {
            Status status = new Status();
            status.setStatus("error");
            status.setMsg("Login failed, no token was generated");
            return status;
        }
        else {
            Status status = new Status();
            status.setStatus("success");
            status.setToken(TokenUtils.createToken(admin.getUsername()));
            return status;
        }
    }
}
