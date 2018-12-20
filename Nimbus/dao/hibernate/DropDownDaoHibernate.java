package Nimbus.dao.hibernate;

import Nimbus.model.DropDown;
import Nimbus.model.FindingAidFile;
import Nimbus.model.Container;
import Nimbus.dao.DropDownDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 25, 2008
 * Time: 12:33:10 PM
 */
public class DropDownDaoHibernate extends GenericDaoHibernate<DropDown, Long> implements DropDownDao {
    public DropDownDaoHibernate() {
        super(DropDown.class);
    }

    @SuppressWarnings("unchecked")
    public List<DropDown> getSubList(String type, String order) {
        return getHibernateTemplate().find("from DropDown where type like ? order by " + order, "%" + type + "%");
    }

    public List<DropDown> getSubList(String type) {
        return getSubList(type, "value");
//        return getHibernateTemplate().find("from DropDown where type like ? order by value", "%" + type + "%");
    }

    @SuppressWarnings("unchecked")
    public DropDown getDropDown(String type, String value) {
        List dropDowns = super.getHibernateTemplate().find("from DropDown where type=? and value=?",new String[]{type, value});
        if (dropDowns.isEmpty()) {
            return null;
        } else {
            return (DropDown) dropDowns.get(0);
        }
    }

    @SuppressWarnings("unchecked")
    public List<DropDown> getAllADD() {
        return getHibernateTemplate().find("from DropDown where cat=?", new String[]{"add"});
    }

    @SuppressWarnings("unchecked")
    public List<DropDown> getAllCM() {
        return getHibernateTemplate().find("from DropDown where cat=?", new String[]{"cm"});
    }

    @SuppressWarnings("unchecked")
    public String getNextBarcode() {
        incCode("max-barcode");
        String temp = getByColumn("type", "max-barcode").getValue();
        List <FindingAidFile> files = getHibernateTemplate().find("from FindingAidFile where barcode=?", new String[]{temp});
        List <Container> containers = getHibernateTemplate().find("from Container where barcode=?", new String[]{temp});
        if (files.size() > 0 || containers.size() > 0) {
            return getNextBarcode();
        }
        return temp + "A";
    }

    @SuppressWarnings("unchecked")
    public String getNextPatron() {
        incCode("max-patron");
        return getByColumn("type", "max-patron").getValue();
    }

    private void incCode(String name) {
        DropDown max = getByColumn("type", name);
        Long temp = Long.parseLong(max.getValue())+1;
        max.setValue(temp.toString());
        save(max);
    }
}
