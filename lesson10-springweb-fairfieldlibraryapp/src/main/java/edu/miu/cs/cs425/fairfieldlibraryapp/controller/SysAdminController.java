package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/fairfieldlibrary")
public class SysAdminController {

    @GetMapping(value = "sysadmin")
    public String displaySysAdminPage() {
        return "/secured/syssadmin/sysadmin";
    }
}
