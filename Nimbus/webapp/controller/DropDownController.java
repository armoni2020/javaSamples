package Nimbus.webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import Nimbus.service.DropDownManager;
import Nimbus.Constants;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: May 21, 2009
 * Time: 11:24:17 AM
 */
public class DropDownController implements Controller {
    private final Log log = LogFactory.getLog(DropDownController.class);
    private DropDownManager dropDownManager = null;

    public void setDropDownManager(DropDownManager dropDownManager) {
        this.dropDownManager = dropDownManager;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("entering 'handleRequest' method...");

        if (request.isUserInRole(Constants.ADMIN_ROLE)) {
            if (request.isUserInRole(Constants.CMADMIN_ROLE)) {
                return new ModelAndView().addObject(dropDownManager.getAll());
            }
            return new ModelAndView().addObject(dropDownManager.getAllADD());
        }
        if (request.isUserInRole(Constants.CMADMIN_ROLE)) {
            return new ModelAndView().addObject(dropDownManager.getAllCM());
        }
        return new ModelAndView().addObject(dropDownManager.getAll());
    }
}
