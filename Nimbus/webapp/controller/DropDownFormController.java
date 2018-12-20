package Nimbus.webapp.controller;

import Nimbus.service.DropDownManager;
import Nimbus.model.DropDown;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: May 21, 2009
 * Time: 11:27:53 AM
 */
public class DropDownFormController extends BaseFormController {
    DropDownManager dropDownManager = null;

    public void setDropDownManager(DropDownManager dropDownManager) {
        this.dropDownManager = dropDownManager;
    }

    public DropDownFormController() {
        setCommandClass(DropDown.class);
        setCommandName("dropDown");
    }

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return dropDownManager.get(new Long(id));
        }

        return new DropDown();
    }

    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> referenceValue = new HashMap<String, Object>();

        referenceValue.put("catList", dropDownManager.getSubList("dd-cat"));
        return referenceValue;
    }

    public ModelAndView onSubmit(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object command,
                                 BindException errors)
          throws Exception {
        log.debug("entering 'onSubmit' method");

        DropDown dropDown = (DropDown) command;
        boolean isNew = (dropDown.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        java.util.Date today = new java.util.Date();
        long t = today.getTime();
        java.sql.Date currentDate = new java.sql.Date(t);
        
        if (request.getParameter("delete") != null) {
            log.info("**OBJECT DELETED ON " + currentDate + " BY USER: " + request.getRemoteUser() + "," + dropDown.toString(true));
            dropDownManager.remove(dropDown.getId());
            saveMessage(request, getText("dropDown.deleted", locale));
        } else {
            dropDownManager.save(dropDown);
            String key = (isNew) ? "dropDown.added" : "dropDown.updated";
            saveMessage(request, getText(key, locale));
        }

        return new ModelAndView(success);
    }

}
