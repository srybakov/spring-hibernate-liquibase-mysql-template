package com.nnprivate.project.controllers;

import com.nnprivate.project.common.Constants;
import com.nnprivate.project.model.domain.User;
import com.nnprivate.project.service.SecurityService;
import com.nnprivate.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.nnprivate.project.common.Utils.putParamToModel;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Controller
@RequestMapping(value = Constants.USER_CABINET)
public class UserCabinetController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userCabinet(ModelMap model){
        UserDetails userDetails = securityService.getUserDetails();
        User user = userService.findByEmail(userDetails.getUsername());
        putParamToModel(model, "email", user.getEmail());
        putParamToModel(model, "created", user.getCreated());

        return new ModelAndView(Constants.USER_CABINET, model);
    }
}
