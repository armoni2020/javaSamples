package Nimbus.service;

import Nimbus.model.DropDown;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 25, 2008
 * Time: 12:40:52 PM
 */
public interface DropDownManager extends GenericManager<DropDown, Long> {

    public List<DropDown> getSubList(String type, String order);
    public List<DropDown> getSubList(String type);
    public DropDown getDropDown(String type, String value);
    public List<DropDown> getAllADD();
    public List<DropDown> getAllCM();
    public String getNextBarcode();
    public String getNextPatron();
}
