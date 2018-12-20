package Nimbus.util;

import Nimbus.model.DropDown;
import Nimbus.service.GenericManager;

import java.beans.PropertyEditorSupport;


/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 25, 2008
 * Time: 9:08:24 AM
 */
public class DropDownEditor extends PropertyEditorSupport {
    GenericManager<DropDown, Long> dropDownManager = null;

    public void setDropDownManager(GenericManager<DropDown, Long> dropDownManager) {
        this.dropDownManager = dropDownManager;
    }

    public void setAsText(String textValue) {
        Long id = Long.parseLong(textValue);
        DropDown dropDown = dropDownManager.get(id);
        setValue(dropDown);
    }

    public String getAsText() {
        DropDown dropDown = (DropDown) getValue();
        if (dropDown != null) {
            return dropDown.getId() + "";
        }
        return null;
    }

}
