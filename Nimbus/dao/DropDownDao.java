package Nimbus.dao;

import gov.nysed.archives.Nimbus.model.DropDown;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 25, 2008
 * Time: 12:30:48 PM
 */
public interface DropDownDao extends GenericDao<DropDown, Long> {

    public List<DropDown> getSubList(String type, String order);
    public List<DropDown> getSubList(String type);
    public DropDown getDropDown(String type, String value);
    public List<DropDown> getAllADD();
    public List<DropDown> getAllCM();
    public String getNextBarcode();
    public String getNextPatron();
}
