package model;

public class Student {
    private Long id;
    private String name;
    private String lastname;
    private String registration;

    public Student() {}

    public Student(String name, String lastname, String registration) {
        this.name = name;
        this.lastname = lastname;
        this.registration = registration;
    }

    public Student(Long id, String name, String lastname, String registration) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.registration = registration;
    }
    
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
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getRegistration() {
        return registration;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", registration=" + registration
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((registration == null) ? 0 : registration.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (registration == null) {
            if (other.registration != null)
                return false;
        } else if (!registration.equals(other.registration))
            return false;
        return true;
    }
}
