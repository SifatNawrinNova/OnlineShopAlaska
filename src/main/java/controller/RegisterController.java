package controller;
import data.model.Register;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "RegisterControl")

public class RegisterController {

    Register rg=new Register();

    public Register getRg() {
        return rg;
    }

    public void setRg(Register rg) {
        this.rg = rg;
    }

   public String sucessReg()
   {
       return "success";
   }
}
