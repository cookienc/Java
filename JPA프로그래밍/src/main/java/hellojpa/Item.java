package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int priace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriace() {
        return priace;
    }

    public void setPriace(int priace) {
        this.priace = priace;
    }
}
