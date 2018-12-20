package Nimbus.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ttilstra
 * Date: Aug 14, 2008
 * Time: 10:48:13 AM
 */
@Entity
public class DropDown extends BaseObject implements Serializable {
    private Long id;
    private String type;
    private String value;
    private String reverseValue;
    private String cat;
    private String notes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReverseValue() {
        return reverseValue;
    }

    public void setReverseValue(String reverseValue) {
        this.reverseValue = reverseValue;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DropDown lookUp = (DropDown) o;

        if (id != null ? !id.equals(lookUp.id) : lookUp.id != null) return false;
        if (type != null ? !type.equals(lookUp.type) : lookUp.type != null) return false;
        if (value != null ? !value.equals(lookUp.value) : lookUp.value != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String toString(boolean verbose) {
        if (verbose) {
            return "DropDown|" +
                  "id=" + id +
                  "| type='" + type + '\'' +
                  "| value='" + value + '\'' +
                  '\n';
        } else {
            return value;
        }
    }
    
    public String toString() {
        return toString(false);
    }
}
