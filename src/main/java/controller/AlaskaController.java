package controller;
import javax.faces.bean.ManagedBean;

import data.model.Login;

@ManagedBean(name = "AlaskaControl")

public class AlaskaController {

    Login lg=new Login();
    int count=0;

    public Login getLg() {
        return lg;
    }

    public void setLg(Login lg) {
        this.lg = lg;
    }

    public String check()
    {

        if(lg.getUsername().equals("Faiza Huma"))
        {
            return "view";
        }
        else
        {
            count++;
            return "fail";
        }
    }


}
