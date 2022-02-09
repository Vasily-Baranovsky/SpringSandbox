package hibernate05_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="children")
public class Child {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name="child_section"
            , joinColumns = @JoinColumn(name="child_id")
            , inverseJoinColumns = @JoinColumn(name="section_id")
    )
    private List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public Child addSectionToChild(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }

        sections.add(section);
        return this;
    }

    public Child() {
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
