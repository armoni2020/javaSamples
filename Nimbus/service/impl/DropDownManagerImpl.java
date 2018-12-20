package Nimbus.service.impl;

import Nimbus.model.DropDown;
import Nimbus.service.DropDownManager;
import Nimbus.dao.DropDownDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 25, 2008
 * Time: 12:42:19 PM
 */
public class DropDownManagerImpl extends GenericManagerImpl<DropDown, Long> implements DropDownManager {

    DropDownDao dropDownDao;

    public DropDownManagerImpl(DropDownDao dropDownDao) {
        super(dropDownDao);
        this.dropDownDao = dropDownDao;
    }

    public List<DropDown> getSubList(String type, String order) {
        return dropDownDao.getSubList(type, order);
    }

    public List<DropDown> getSubList(String type) {
        return dropDownDao.getSubList(type);
    }

    public DropDown getDropDown(String type, String value) {
        return dropDownDao.getDropDown(type, value);
    }

    public List<DropDown> getAllADD() {
        return dropDownDao.getAllADD();
    }

    public List<DropDown> getAllCM() {
        return dropDownDao.getAllCM();
    }

    public String getNextBarcode() {
        return dropDownDao.getNextBarcode();
    }

    public String getNextPatron() {
        return dropDownDao.getNextPatron();
    }
}
