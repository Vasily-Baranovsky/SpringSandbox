package hibernate05_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String firstName;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name="child_section"
            , joinColumns = @JoinColumn(name="section_id")
            , inverseJoinColumns = @JoinColumn(name="child_id")
    )
    private List<Child> children;

    public List<Child> getChildren() {
        return children;
    }

    public Section addChildToSection(Child child) {
        if (children ==null) {
            children = new ArrayList<>();
        }

        children.add(child);
        return this;
    }
    public Section() {
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public Section(String firstName) {
        this.firstName = firstName;
    }
}
