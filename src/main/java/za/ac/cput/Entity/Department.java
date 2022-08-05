/*  Department.java
    Entity for the Department
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Entity;

public class Department {
    private String departmentID;
    private String departmentName;
    private int departmentSize;

    private Department(Builder builder){
        this.departmentID = builder.departmentID;
        this.departmentName = builder.departmentName;
        this.departmentSize = builder.departmentSize;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentSize() {
        return departmentSize;
    }

    public void setDepartmentSize(int departmentSize) {
        this.departmentSize = departmentSize;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentSize=" + departmentSize +
                '}';
    }

    public static class Builder {
        private String departmentID;
        private String departmentName;
        private int departmentSize;

        public Builder setDepartmentID(String departmentID) {
            this.departmentID = departmentID;
            return this;
        }

        public Builder setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder setDepartmentSize(int departmentSize) {
            this.departmentSize = departmentSize;
            return this;
        }

        public Builder copy(Department department) {
            this.departmentID = department.departmentID;
            this.departmentName = department.departmentName;
            this.departmentSize = department.departmentSize;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
